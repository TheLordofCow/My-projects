//Jaxson Meisenhelter
#include <iostream>
using namespace std;

int main(){
	//initilize pointer variable and int variable
	int myInt = 15;
	int* myPointer = &myInt;
	//displays memory address of myInt, myPointer, myInt, and the value 
	//pointed to by myPointer
	cout << &myInt << endl << myPointer << endl << myInt << endl << *myPointer << endl;
	//changes the value of myInt, and displays the changes to the memory
	//address of myInt, myPointer, myInt, and the value pointed to by myPointer
	myInt = 10;
	cout << &myInt << endl << myPointer << endl << myInt << endl << *myPointer << endl;
	//confirms if the program successfuly ended
	cout << "success!\n";
	return 0;
}

