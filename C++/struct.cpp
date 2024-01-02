//Jaxson Meisenhelter
#include <iostream>
#include <cmath>
using namespace std;
//creates a data structure that stores 2 float numbers
struct CartesianCoordinate{
	float x;
	float y;
} p1, p2;

//takes 4 float numbers from 2 data structures (above) and find the distance between them
float calculateDistance(CartesianCoordinate p1, CartesianCoordinate p2){
	float x = sqrt(pow(p2.x - p1.x, 2) + pow(p2.y - p1.y, 2));
	
	return x;
}

int main(){
	//gets coordinates for the struct from the user
	cout << "gib p1:" << endl;
	cin >> p1.x >> p1.y;
	cout << "gib p2:" << endl;
	cin >> p2.x >> p2.y;
	//outputs distance between 2 coordinates
	cout << "distance:\n" << calculateDistance(p1, p2) << endl;
	
	return 0;
}
