#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <pthread.h>

void *minion(void *v){
  printf("%s%ld\n", "Hello! I am minion ", (long) v);
  return NULL;
}

void *overlord(void *v){
  printf("Hello Minions! I am the Overlord!\n");
  return NULL;
}
// Treat this function as main
int drive_sort(int argc, char *argv[]){
  if(argc != 2){
    fprintf(stderr, "Error: Bad command line parameters.\n");
    exit(1);
  }
  
  int failure;
  int num = atoi(argv[1]);
  //atoi returns 0 when given characters.
    if(num == 0){
      fprintf(stderr, "Error: Bad command line parameters.\n");
      exit(num);
    }
  pthread_t *threads = (pthread_t*) malloc(num*sizeof(pthread_t));

  //creates each minion thread
  for(long i = 0; i < num; i++){
	  failure = pthread_create(&threads[i], NULL, minion, (void*) i);
    
    if(failure != 0){
      fprintf(stderr, "Failed to create pthread, error code ");
      fprintf(stderr,"%d\n", failure);
      exit(failure);
    }
  }
  //joins the minion threads
  for(int i = 0; i < num; i++){
    failure = pthread_join(threads[i], NULL);
    
    if(failure != 0){
      fprintf(stderr, "Failed to join pthread, error code ");
      fprintf(stderr,"%d\n", failure);
      exit(failure);
    }
  }
  //creates the overlord thread
  pthread_t over;
  failure = pthread_create(&over, NULL, overlord, NULL);
  
  if(failure != 0){
    fprintf(stderr, "Failed to create pthread, error code ");
    fprintf(stderr,"%d\n", failure);
    exit(failure);
  }
  
  pthread_join(over, NULL);
  if(failure != 0){
    fprintf(stderr, "Failed to join pthread, error code ");
    fprintf(stderr,"%d\n", failure);
      exit(failure);
    }
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