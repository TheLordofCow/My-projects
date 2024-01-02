#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
//needed for compare
int sortNum = 1;
//have to create a duplicate string so I could edit the new one without modiflying the old one.
char* newstr(const char* og){
  if (og == NULL){
    return NULL;
  }
  size_t length = strlen(og);
  char* newstr = (char*) calloc(length + 1, sizeof(char));
  memcpy(newstr, og, length + 1);
  return newstr;
}
//this is awful, I know it's awful, but it works and it's not slow somehow.
int compare(const void *x, const void *y){
  //convert const void* to char*
  char* x2 = *(char**) x;
  char* y2 = *(char**) y;
  //convert char* into a brand new string so it casn be destroyed by strtok_r
  char* x3 = newstr(x2);
  char* y3 = newstr(y2);
  //create space for the string to be checked by strcmp
  char* x4 = malloc(128*sizeof(char));
  char* y4 = malloc(128*sizeof(char));
  
  if(x4 == NULL|| y4 == NULL){
    fprintf(stderr, "Error: Malloc failed");
    exit(1);
  }
  
  //cycle though the tokens until the nth term is reached, then compare.
    for(int i = 0; i < sortNum; i++){
      x4 = strtok_r(x3, " ", &x3);
      y4 = strtok_r(y3, " ", &y3);
      if(x4 == NULL){
        x4 = "";
      }
      if(y4 == NULL){
        y4 = "";
      }
    }
  int end = strcmp(x4, y4);
  return end;
  //x4 and y4 are replaced by string litterals and therefore cannot be freed
}
// Treat this function as main
int drive_sort(int argc, char *argv[]){
	char* filestr = malloc(128*sizeof(char));
  char* f = malloc(255*sizeof(char));
  char tempc;
  int newlines = 1;
  int length = 0;
  int i;

  if(f == NULL|| filestr == NULL){
    fprintf(stderr, "Error: Malloc failed");
    exit(1);
  }
  //printf("%s\n", argv[1]);
  //printf("%d\n", argc);
  if(argc == 3 && argv[1][0] == '-'){
    sortNum = atoi(argv[1]);
    //printf("%d\n", sortNum);
    //atoi returns 0 when given characters.
    if(sortNum == 0){
      fprintf(stderr, "Error: Bad command line parameters.\n");
      exit(1);
    }
    f = argv[2];
    //converts negative into positive
    sortNum = sortNum*(-2) + sortNum;
  }
  else if(argc == 2){
    f = argv[1];
  }
  else{
    fprintf(stderr, "Error: Bad command line parameters.\n");
    exit(1);
  }

	FILE *file;
	file = fopen(f, "r");

	if (file == NULL) {
		fprintf(stderr,"Error: Cannot open file ");
    fprintf(stderr, "%s\n", f);
		exit(1);
	}

	fscanf(file, "%s", filestr);
  //finds length of file, and checks that no line is longer than 128 characters
  for(tempc = getc(file); tempc != EOF; tempc = getc(file)){
    length++;
    if(tempc == '\n'){
      newlines++;
      length = 0;
    }
    if(length > 128){
      fprintf(stderr, "Error: Line too long");
      exit(1);
    }
  }
  //needs to be reset so file is close and reopened
  fclose(file);
  file = fopen(f, "r");
  
  char *lines[newlines];

  //places every line in the file into it's own string in a pointer array
  for(i = 0; i < newlines; i++){
    fgets(filestr, 128, (FILE*)file);
    if(filestr == NULL){
      filestr = "";
    }
    lines[i] = filestr;
    if(strstr(filestr, "\n") == NULL && strcmp(filestr, " ") != 0){
      strcat(lines[i], "\n");
    }
    
    //printf("%s", lines[i]);
    filestr = malloc(128*sizeof(char*));
    
    if(filestr == NULL){
      fprintf(stderr, "Error: Malloc failed");
    exit(1);
  }
  }
  printf("\n");
  
  fclose(file);
  //sorts lines based on the nth word, with n being sortNum
  qsort(lines, newlines, sizeof(char*), compare);
  
  printf("sorted:\n");
  for(i = 0; i < newlines; i++){
    printf("%s", lines[i]);
  }
  //writes back to the file with sorted lines
  fopen(f, "w");
  for(i = 0; i < newlines; i++){
    fprintf(file, lines[i], "%s");
  }
  free(filestr);
  //f cannot be freed, core dumps possbly a string litteral?
	return 0;
}
// TODO all changes should be made above this line
int main(int argc, char *argv[]) {
	int ret = 0;
	double time;
	struct timespec s;
	struct timespec e;
	clock_gettime(CLOCK_MONOTONIC, &s);
	ret = drive_sort(argc, argv);
	clock_gettime(CLOCK_MONOTONIC, &e);
	time = e.tv_sec - s.tv_sec + (e.tv_nsec - s.tv_nsec) / 1e9;
	fprintf(stderr, "time: %lfs\n", time);
	return ret;
}