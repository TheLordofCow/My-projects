/* Jaxson Meisenhelter
 @file: pthreads_skeleton.cpp
 
 @author: student name1, student2@uncc.edu
 @author: student name2, student2@uncc.edu
 @author: student name3, student3@uncc.edu
 
 @description: A program that demonstrates processes.
 
 @course: ITSC 3146
 @assignment: in-class activity [n]
 */

#include <pthread.h>
#include <iostream>

using namespace std;


//prints out each message in a random order
void *printMessage(void *arg)
{
   const char* actual_arg = ((const char*) arg);
   // TODO: Add code that implements
   //       the thread's functionality
   cout << actual_arg << endl;
   return 0;
}


int main()
{
   // id is used to store a unique thread identifier,
   // returned by the call to create a new POSIX thread
	pthread_t id;
	//creates the messages and placs them in a char array
	const char* my_messages[] = {"English: Hello!", "Japanese: Konnichiwa!", "Spanish: Hola!", "German: Guten Tag!"};
   // rc is used to store the code returned by the
   // call to create a new POSIX thread. The value is
   // zero (0) if the call succeeds.
	int rc;
	
	//loops though each message until they are all printed to the console
	int i = 0;
	for(i = 0; i < 4; i++){
		rc = pthread_create(&id, NULL, printMessage, (void*) my_messages[i]);
	}

	if (rc){
		cout << "ERROR; return code from pthread_create() is " << rc << endl;
		return -1;
	}
   

   // NOTE: Using exit here will immediately end execution of all threads
	pthread_exit(0);
}
