//Jaxson Meisenhelter
#include <iostream>
using namespace std;

int main(){
	//initilize
	int ints[4];
	int i, j;
	int* points[4];
	
	//takes 4 number inputs from user and places them in ints
	//memory address of those numbers stored in points
	cout << "input:" << endl;
	for(i = 0; i < 4; i++){
		cin >> ints[i];
		points[i] = &ints[i];
	}
	
	//performs bubble sort on the pointers array
    for(i = 0; i < 4 - 1; i++){
		for(j = 0; j < 4 - i - 1; j++){
			if(*points[j] > *points[j + 1]){
				int* temp = points[j];
				points[j] = points[j+1];
				points[j+1] = temp;
			}
		}
	}
	
	//displays the ints array and points array
	cout << endl << "ints array:" << endl;
	for(i = 0; i < 4; i++){
		cout << ints[i] << endl;
	}
	cout << endl << "pointers array:" << endl;
	for(i = 0; i < 4; i++){
		cout << *points[i] << endl;
	}
	cout << endl;
	
	//confirms if the program successfuly ended
	cout << "success!\n";
	return 0;
}

