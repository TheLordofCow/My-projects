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

int array[10];
int i = 0;
// This function shows the skeleton that pthread 
// functions must adhere to. 
// Copy this skeleton for any pthread function 
// you need to define. 
// In the copy, modify the name of the function 
// and the function body as needed. 

//counts the number of negative numbers and displays the amount
void *countNegatives(void *arg){
   int count = 0;
   for(i = 0; i < 10; i++){
	   if(array[i] < 0){
		   count++;
	   }
   }
   cout << "There are " << count << " negative numbers." << endl;
   
   return 0;
}

//adds all integers together, then divedes the sum by the number of integers
void *average(void *arg){
   int sum = 0;
   for(i = 0; i < 10; i++){
		sum += array[i];
   }
   cout << "Average: " << sum/10 << endl;
   
   return 0;
}

//displays the integers in the array in reverse
void *reverse(void *arg){
   cout << "The numbers in reverse" << endl;
   for(i = 0; i < 10; i++){
		   cout << array[i] << endl;
   }
   
   return 0;
}

int main()
{
   // id is used to store a unique thread identifier,
   // returned by the call to create a new POSIX thread
   pthread_t id;
   
   
   // rc is used to store the code returned by the
   // call to create a new POSIX thread. The value is
   // zero (0) if the call succeeds.
   int rc;
   
	
	//requests 10 integers from the user and places them in an array
   cout << "input 10 integers" << endl;
   for(i = 0; i < 10; i++){
	   cin >> array[i];
   }
   
   
   //creates the 3 pthreads required for the program, call each of the 
   //methods at the top of the program
   rc = pthread_create(&id, NULL, countNegatives, NULL);
   rc = pthread_create(&id, NULL, average, NULL);
   rc = pthread_create(&id, NULL, reverse, NULL);

   if (rc){
      cout << "ERROR; return code from pthread_create() is " << rc << endl;
      return -1;
   }
   

   // NOTE: Using exit here will immediately end execution of all threads
   pthread_exit(0);
}
