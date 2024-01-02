#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <sys/stat.h>
#include <ctype.h>
#include <pthread.h>

#include "hashmap.h"

// If you're reading this first, skip to main for the important stuff!
size_t count_newlines(const char *str) {
    size_t count = 0;
    while (*str) 
    {
        if (*str == '\n') 
        {
            count++;
        }
        str++;
    }
    return count;
}

/*
 * Extracts each line from a string.
 */
void fix_buffer(char* buffer, char** lines)
{
    char* begin;
    begin = buffer;
    while(*buffer)
    {
        if (*buffer == '\n' || *buffer == '\0')
        {
            *buffer = '\0';
            *lines = begin;
            begin = buffer + 1;
            ++lines;
        }
        ++buffer;
    }
}

/*
 * filename is the name of a file containing a list of other files.
 * numlines will be filled on return; must pass in already-allocated mem
 */
char** get_filenames(const char* filename, size_t* numlines)
{
    char* buffer;
    char** lines;
    FILE *file = fopen(filename, "r");
    struct stat file_stats;
    off_t file_size;     
    if (!file) 
    {
        fprintf(stderr, "Error: file %s does not exist\n", filename);
        exit(1);
    }

    if (stat(filename, &file_stats) != 0) 
    {
        fprintf(stderr, "Error: could not get file stats for %s\n", filename);
        exit(1);
    }
    file_size = file_stats.st_size;
    
    buffer = malloc(file_size+1);
    if (fread(buffer, sizeof(char), file_size, file) != (size_t) file_size)
    {
        free(buffer);
        fclose(file);
        printf("incomplete read?\n");
        exit(1);
    }
    fclose(file);
    // fread does not apply a null terminator
    buffer[file_size] = '\0';
    *numlines = count_newlines(buffer);
    lines = malloc(sizeof(char**) * *numlines);
    // fix buffer does most of the real work
    fix_buffer(buffer, lines);
    return lines;
}

void lowerstr(char* str)
{
    while (*str)
    {
        *str = tolower(*str);
        ++str;
    }
}

struct hash_info{
  hashmap_t map;
  char* filen;
};

const char* tokenizer = " \t\n\r\f!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";

void* hash_thread(void* args){
  struct hash_info* h = (struct hash_info*)args;
  FILE *file = fopen(h->filen, "r");
  struct stat file_stats;
  off_t file_size;
  
  if (stat(h->filen, &file_stats) != 0)
        {
            fprintf(stderr, "Error: could not get file stats for %s\n", h->filen);
            exit(1);
        }
  
        file_size = file_stats.st_size;
  
  char* string = malloc(file_size+1);
  char* str2 = string; //needed to free string
  if (fread(string, sizeof(char), file_size, file) != (size_t) file_size){
    fprintf(stderr, "incomplete read?\n");
    exit(1);
  }
  string[file_size] = '\0';
  // split the string into words
  char* token = strtok_r(string, tokenizer, &string);
  while (token){
    // let's make the string lowercase; want accurate count of words
    lowerstr(token);
    int value = 0;
    // does it exist?
    hashmap_find(&(h->map), token, &value);
    // either way, 'value' holds the correct value; increment it by 1
    hashmap_insert(&(h->map), token, value+1);
    // try again
    token = strtok_r(NULL, tokenizer, &string);
    
  }
  free(str2);
  fclose(file);
  return NULL;
}

// match all ascii whitespace and punctuation


int main(int argc, char *argv[]) 
{
    if (argc != 2 && argc != 3)
    {
        fprintf(stderr, "Usage: %s <filename> [testword]\n", argv[0]);
        exit(1);
    }
    const char* filename = argv[1];
    size_t numfiles;
    char** files = get_filenames(filename, &numfiles);
    
    // TODO: This is where the main processing happens. Make the below code parallel. Each
    // file should be processed by its own thread. The hashmap should be shared by all 
    // threads.
    hashmap_t map;
    // set up a hashmap with 100000 buckets
    hashmap_init(&map, 100000);
    
    // pthread setup
    pthread_t *threads = (pthread_t*)malloc(numfiles*sizeof(pthread_t));
    struct hash_info h[numfiles];
    // iterate over each file
    for (size_t i = 0; i < numfiles; ++i)
    {  
        char* filen = files[i];
        h[i].filen = filen;
        h[i].map = map;
        struct hash_info *hh = &h[i];
        pthread_create(&threads[i], NULL, hash_thread, (void*) hh);
    }
  
    for(size_t i = 0; i < numfiles; ++i){
      pthread_join(threads[i], NULL);
    }
  
    // TODO: leave me alone! I just print the results.
    hashmap_iterator_t iter;
    hashmap_iterator_init(&iter, &map);
    // dump our results to stdout
    while(hashmap_iterator_has_next(&iter))
    {
        char* str;
        int val;
        hashmap_iterator_next(&iter, &str, &val);
        fprintf(stderr, "%s: %d\n", str, val);
    }
    
    if (argc == 3)
    {
        char* testword = argv[2];
        lowerstr(testword);
        int value = 0;
        hashmap_find(&map, testword, &value);
        printf("%d\n", value);
    }

    hashmap_destroy(&map);
    free(*files);
    free(threads);
    free(files);
    return 0;
}
