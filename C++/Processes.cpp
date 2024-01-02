// Jaxson Meisenhelter
//  Processes.cpp
//  ITSC 3146
//
//  Created by Bahamon, Julio on 1/12/17.
//


/*
 @file Processes.cpp
 @author student name, student@uncc.edu
 @author student name, student@uncc.edu
 @author student name, student@uncc.edu
 @description: <ADD DESCRIPTION>
 @course: ITSC 3146
 @assignment: in-class activity [n]
 */


#ifndef Processes_cpp
#define Processes_cpp

#include "Processes.h"


using namespace std;


// Part 1: Working With Process IDs
pid_t getProcessID(void)
{
   //checks if the PID exists. If it does, returns that ID.
   if(getpid()){
	   return getpid();
   }
   return -1;
}


// Part 2: Working With Multiple Processes
string createNewProcess(void)
{
   pid_t id = fork();
   
   // DO NOT CHANGE THIS LINE OF CODE
   process_id = id;
   
   
   if(id == -1)
   {
		return "Error creating process";
   }
   else if (id == 0)
   {
		//Prints from the child program, then returns a string from the child program letting the parent know it's been terminated.
		cout << "I am a child process!" << endl;
		return "I am bored of my parent, switching programs now";
   }
   else
   {
      //Prints from the parent program, then waits until the child process is terminated and prints the return value.
		cout << "I just became a parent!" << endl;
		int i = 0;
		wait(&i);
		return "My child process just terminated!";
   }
}


// Part 3: Working With External Commands"
void replaceProcess(char * args[])
{
   // Spawn a process to execute the user's command.
   pid_t id = fork();
   
   //I don't have the slightest idea what this is supposed to do, but it does... something... so I'll roll with it.
   execvp(args[0], args);
}

#endif /* TestProg_cpp */
