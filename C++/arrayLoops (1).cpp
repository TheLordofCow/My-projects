//Jaxson Meisenhelter
#include <iostream>
using namespace std;

int main(){
	//initilize array and int fuctions that will be used
    int array1[10];
    int i = 0;
    int j = 0;
    int x;
    //requests 10 inputs from the user and stores them in an array
    for(i = 0; i < 10; i++){
		cin >> array1[i];
	}
    
    //displays the array in reverse order
    for(i = 9; i >= 0; i--){
		cout << array1[i] << " ";
	}
    cout << "\n"; //for some reason not having \n was casuing glitches in the terminal
    
    //performs bubble sort on the array
    i = 1;
    while(i < 10){
		x = array1[i];
		j = i - 1;
		while(j >= 0 && array1[j] > x){
			array1[j+1] = array1[j];
			j = j - 1;
		}
		
		array1[j+1] = x;
		i = i + 1;
	}
	//outputs the array in order from smallest to largest
    for(i = 0; i < 10; i++){
		cout << array1[i] << " ";
	}
    cout << "\n";
    
    return 0;
}
