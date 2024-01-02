//Jaxson Meisenhelter
#include <iostream>
using namespace std;

//swaps 2 integers and displays the output
void swapints(int n1, int n2){
	int temp = n1;
	n1 = n2;
	n2 = temp;
	cout << "output:\n" << n1 << endl << n2 << endl;
}

int main(){
	//initilize
	int num1;
	int num2;
	int* p1 = &num1;
	int* p2 = &num2;
	
	//takes input from user
	cout << "input:" << endl;
	cin >> num1 >> num2;
	
	//swaps the 2 integers provided by pointers
	swapints(*p1, *p2);
	
	return 0;
}
