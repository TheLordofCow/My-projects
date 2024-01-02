//Jaxson Meisenhelter
//  QuickSort_Skeleton.cpp
//
//  Created by Bahamon, Julio on 6/25/19.
//  UNC Charlotte
//  Copyright © 2019 Bahamon, Julio. All rights reserved.
// 

#include <iostream>
#include <cstdlib>
#include <cstring>

using namespace std;

//Declaring a new struct to store patient data
struct patient {
    int age;
    char name[20];
    float balance;
};

//  IMPLEMENT A FUNCTION THAT COMPARES TWO PATIENTS BY AGE

//  THE FUNCTION RETURNS AN INTEGER AS FOLLOWS:
//      -1 IF THE AGE OF THE FIRST PATIENT IS LESS
//         THAN THE SECOND PATIENT'S AGE
//       0 IF THE AGES ARE EQUAL
//       1 OTHERWISE
int ageCompare(patient a, patient b){
	if(a.age < b.age){
		return -1;
	}
	else if(a.age == b.age){
		return 0;
	}
	
	return 1;
}

//  IMPLEMENT A FUNCTION THAT COMPARES TWO PATIENTS BY BALANCE DUE

//  THE FUNCTION RETURNS AN INTEGER AS FOLLOWS:
//      -1 IF THE BALANCE FOR THE FIRST PATIENT IS LESS
//         THAN THE SECOND PATIENT'S BALANCE
//       0 IF THE BALANCES ARE EQUAL
//       1 OTHERWISE
int balCompare(patient a, patient b){
	if(a.balance < b.balance){
		return -1;
	}
	else if(a.balance == b.balance){
		return 0;
	}
	
	return 1;
}

//  TODO:
//  IMPLEMENT A FUNCTION THAT COMPARES TWO PATIENTS BY NAME

//  THE FUNCTION RETURNS AN INTEGER AS FOLLOWS:
//      -1 IF THE NAME OF THE FIRST PATIENT GOES BEFORE
//         THE SECOND PATIENT'S NAME
//       0 IF THE AGES ARE EQUAL << "if the ages are equal?"
//       1 OTHERWISE
//
//  HINT: USE THE strncmp FUNCTION
//  (SEE http://www.cplusplus.com/reference/cstring/strncmp/)
int nameCompare(patient a, patient b){
	int i = 0;
	
	for(i; i < 20; i++){
		if(strncmp(&a.name[i], &b.name[i], 1) < 0){
			return -1;
		}
		else if(strncmp(&a.name[i], &b.name[i], 1) > 0){
			return 1;
		}
	}
	return 0; //there is no way to find out if the name is equal to 
	//another without going thought the entire name, so return 0 goes last.
}

//converts const void*'s to patient*'s and runs them though ageCompare
int compAgeVoid(const void * a, const void * b){
	patient *c = (patient*) a;
	patient *d = (patient*) b;
	return ageCompare(*c, *d);
}

//converts const void*'s to patient*'s and runs them though balCompare
int compBalVoid(const void * a, const void * b){
	patient *c = (patient*) a;
	patient *d = (patient*) b;
	return balCompare(*c, *d);
}

//converts const void*'s to patient*'s and runs them though nameCompare
int compNameVoid(const void * a, const void * b){
	patient *c = (patient*) a;
	patient *d = (patient*) b;
	return nameCompare(*c, *d);
}

// The main program
int main(){
    int total_patients = 6;
    int i;
    
    //  Storing some test data
    struct patient patient_list[6] = {
        {25, "Juan Valdez   ", 1250},
        {15, "James Morris  ", 2100},
        {32, "Tyra Banks    ", 750},
        {62, "Mario O'Donell", 375},
        {53, "Pablo Picasso ", 615}
    };
    //requests the user for the last name, age, and balance
    cout << "please input your last name, age, and balance." << endl;
    cin >> patient_list[5].name >> patient_list[5].age >> patient_list[5].balance;
    
    cout << "Patient List: " << endl;
    
    //  IMPLEMENT THE CODE TO DISPLAY THE CONTENTS
    //  OF THE ARRAY BEFORE SORTING
    
    for(i = 0; i < 6; i++){
		cout << "name: " << patient_list[i].name << " age: " << patient_list[i].age << " balance: " << patient_list[i].balance << endl;
	}
    
    cout << "Sorting..." << endl;
	
    //  CALL THE qsort FUNCTION TO SORT THE ARRAY BY PATIENT AGE  
    qsort(patient_list, 6, sizeof(patient), compAgeVoid);
    
    cout << "Patient List - Sorted by Age: " << endl;
	
    //  DISPLAY THE CONTENTS OF THE ARRAY
    //  AFTER SORTING BY AGE
    for(i = 0; i < 6; i++){
		cout << "name: " << patient_list[i].name << " age: " << patient_list[i].age << " balance: " << patient_list[i].balance << endl;
	}
    cout << endl;
    
    cout << "Sorting..." << endl;
    
    //  CALL THE qsort FUNCTION TO SORT THE ARRAY BY PATIENT BALANCE
    qsort(patient_list, 6, sizeof(patient), compBalVoid);
    
    cout << "Patient List - Sorted by Balance Due: " << endl;  
	
    //  DISPLAY THE CONTENTS OF THE ARRAY
    //  AFTER SORTING BY BALANCE
    for(i = 0; i < 6; i++){
		cout << "name: " << patient_list[i].name << " age: " << patient_list[i].age << " balance: " << patient_list[i].balance << endl;
	}
	
    cout << endl;
    
    cout << "Sorting..." << endl;
    
   
    
    //  CALL THE qsort FUNCTION TO SORT THE ARRAY BY PATIENT NAME
    qsort(patient_list, 6, sizeof(patient), compNameVoid);
    
    cout << "Patient List - Sorted by Name: " << endl;
    
    //  DISPLAY THE CONTENTS OF THE ARRAY
    //  AFTER SORTING BY NAME  
    for(i = 0; i < 6; i++){
		cout << "name: " << patient_list[i].name << " age: " << patient_list[i].age << " balance: " << patient_list[i].balance << endl;
	}
	
    cout << endl;
    
    return 0;
}
