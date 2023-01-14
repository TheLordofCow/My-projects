#include <iostream>
#include <string>
#include <stdio.h>
#include <vector>
using namespace std;
//C global variables, helps to prevent crashes
  int rowSize = 10; 
  int columnSize = 10; 
  int i;
  int j;//i and j being global makes sense with how much they're used
  string P1board[10][10]; 
  string P1shots[10][10];
  string P2board[10][10];
  string P2shots[10][10];
  
//Basic board constructors
void P1Board(){//board that houses P1's ships
  
    for (i = 0; i < rowSize; i++){
        
        for (j = 0; j < columnSize; j++){
            cout << P1board[i][j] << "  ";   //J what board1 looks like
        }
        cout << endl;
    }
}

void P1Shots(){//board that keeps track of P1's shots
  
    for (i = 0; i < rowSize; i++){
      
        for (j = 0; j < columnSize; j++){
            cout << P1shots[i][j] << "  ";   //J what board2 looks like
        }
        cout << endl;
    }
}

void P2Board(){//board that houses P2's ships
  
    for (i = 0; i < rowSize; i++){
       
        for (j = 0; j < columnSize; j++){
            cout << P2board[i][j] << "  ";   //J what board3 looks like
        }
        cout << endl;
    }
}

void P2Shots(){//board that keeps track of P2's shots
  
    for (i = 0; i < rowSize; i++){
        
        for (j = 0; j < columnSize; j++){
            cout << P2shots[i][j] << "  ";   //J what board4 looks like
        }
        cout << endl;
    }
}

void placeShipsP1(string P1b[10][10])
{
    int ri = 0;//C random row variable
    int rj = 0;//C random column variable
    
    for (int i = 0; i < columnSize; ++i){
        ri = (rand() % rowSize);//C sets ri within bounds for row
        rj = (rand() % columnSize);//C sets rj within bounds for column
        if (P1b[ri][rj].at(2) == ' '){//C checks to make sure a ship isn't already there
            P1b[ri][rj].at(2) = 'b';
        }
        else if (P1b[ri][rj].at(2) == 'b') {
            --i;
        }
    }
}
void placeShipsP2(string P2b[10][10])//C works the same as placeShipsP1
{
    int ri = 0;
    int rj = 0;
    for (int i = 0; i < columnSize; ++i){
        ri = (rand() % rowSize);
        rj = (rand() % columnSize);
        if (P2b[ri][rj].at(2) == ' '){
            P2b[ri][rj].at(2) = 'b';
        }
        else if (P2b[ri][rj].at(2) == 'b') {
            --i;
        }
    }
}

void help(){//C lists out all basic commands available to the player
    cout << "Commands:" << endl;
    cout << "myBoard: displays your board" << endl;
    cout << "myShots: displays the locations you have shot at" << endl;
    cout << "end: instantly ends the game" << endl;
    cout << "To fire a shot, first type the row (A-J) and then the column (0-9)" << endl;
    cout << "\t ex: A0, D4, J9" << endl << endl;
    cout << "Type 'help' to see these commands again." << endl;
}

int main (){
    //C welcome message
    cout << "Welcome to Battleship!" << endl << "The premise of the game is to take out all of the enemy's ships, before they take out yours!";
    cout << endl << endl;//C we love adding end lines for visual clarity
    //C initial variables for start of game prompts
    srand(2);//C seeded for testing purposes
    string input;
    string size;
    int gogo = 0;
    char Ai;
    //board variables
    char row[] = "A";    //J the [] is required for static_cast
    char column[] = "0";
    
    //C start of game prompts
    cout << "1 player or 2 players? (enter 1 or 2) ";//C if 1, play with AI, if 2, play with 2 players
    cin >> Ai;
    while(Ai != '1' && Ai != '2'){
        cout << "Not a valid input. Please try again: ";
        cin >> Ai;
    }
    
    cout << "What size battlefield would you like: small, medium, or large? ";
    //C small is 5x5, med is 7x7, large is 10x10
    cin >> size;
    cout << endl;
    
    while (gogo != 1){
    if (size == "small"){
        rowSize = 5;
        columnSize = 5;
        gogo = 1;   //J ends the while loop
    }
    
    else if (size == "medium"){
        rowSize = 7;
        columnSize = 7;
        gogo = 1;
    }   
    
    else if (size == "large"){
        rowSize = 10;
        columnSize = 10;
        gogo = 1;
    }
    else if (size == "deez"){//C haha   
        cout << "Ha, gottem! ";
    }
    else{
        cout << "Not a valid size." << endl;
        cin >> size;
    }
    }
    
    for (i = 0; i < rowSize; i++){
        string B{static_cast<char>(column[0] + i)};  //J allows "adding" to letters. row[0] + 0 = A, row [0] + 1 = B, etc
        
        for (j = 0; j < columnSize; j++){
            string A{static_cast<char>(row[0] + j)};
            
        P1board[i][j] = A + B + ' ';    //J board creation
        P1shots[i][j] = A + B + ' ';
        P2board[i][j] = A + B + ' ';
        P2shots[i][j] = A + B + ' ';
        }
    }
    placeShipsP1(P1board);//C build the board
    placeShipsP2(P2board);//C build the other board
    //ship counter
    int p1ships = columnSize;
    int p2ships = columnSize;
    
    cout << "All good!" << endl << endl;
    help();
    cout << endl << "Player 1's turn!" << endl << endl;
    cin >> input;
    
  
  //J main game code
  while (input != "end"){  
    int first;
    int second;
    int turn = 0;
    
    
    //J player 1's start
    while (input != "end" && turn != 1){  
       

      
        if(input.size() == 2 && isalpha(input.at(0)) && isdigit(input.at(1))){  //J keeps the program from crashing
            first = stoi (input.substr (1));    //converts "0" from string to int
            second = input.at(0) - 65;      //converts 'A' to 0, 'B' to 1, 'C' to 2, etc.
        }
            
        if (input == "myBoard"){  //J displays player 1s board
            P1Board();
        }
            
        else if (input == "myShots"){  //J displays player 1's shots against player 2
            P1Shots();
        }
            
        else if (input.size() == 2 && isalpha(input.at(0)) && isdigit(input.at(1)) && first < rowSize && first >= 0 && second < columnSize && second >= 0){ //J keeps the program from crashing
            
            if (P2board[first][second].at(2) == ' ') {   //J executes when the space has the "empty" marker
                
                P1shots[first][second].at(2) = 'o';     //J player 1's shots board and players 2's board get updated with the "miss" marker
                P2board[first][second].at(2) = 'o';
                cout << "Miss!" << endl; 
                turn = 1;                               //J marks the end of player 1's turn
            } 
            
            else if (P2board[first][second].at(2) == 'o' || P2board[first][second].at(2) == 'x') {   //J executes when a shot is made is a space where a shot was made previously
                cout << "You've aready fired at this location!" << endl;
            }
            
            else if (P2board[first][second].at(2) == 'b') {  //J executes when the space has a battleship piece in it
                
                P1shots[first][second].at(2) = 'x';     //J player 1's shots board and players 2's board get updated with the "hit" marker
                P2board[first][second].at(2) = 'x';
                cout << "Hit!" << endl;
                --p2ships;
                turn = 1;           //J marks the end of player 1's turn
            }
            else{
                cout << "How have you achieved this?" << endl;  //J supposedly, an impossible outcome.
            }
        }
       
        else if (input == "help"){
            help();
        }
        
        else{
            cout << "Invalid input! try again." << endl;  //J typing anything other than end, 2 numbers, myBoard, or myShots will give this result.
            cout << "Type 'help' to see the commands." << endl;
        } 
      
        if (turn != 1){  //J executes if player 1's turn has not ended
            cout << endl;
            cin >> input;
        }
    }

    if (turn == 1){  //J executes when player 1's turn has ended
        cout << "Player 2's turn!" << endl << endl;
    }
   
    
    if(p2ships == 0)//C check to see if p1 has won the game
    {
       cout << "Player 1 Wins!" << endl << "Thanks for playing!" << endl;
       input = "end";
       break;
    }
    
    





    //J player 2's start
    while (input != "end" && turn != 2 && Ai == '2'){  
        cin >> input;

        if(input.size() == 2 && isalpha(input.at(0)) && isdigit(input.at(1))){  //J keeps the program from crashing
            first = stoi (input.substr (1));   //converts "00" from string to int
            second = input.at(0) - 65;
        }
        
        if (input == "myBoard"){  //J displays player 2's board
            P2Board();
        }
        
        else if (input == "myShots"){  //J displays player 2's shots against player 1
            P2Shots();
        }
        
        else if (input.size() == 2 && isalpha(input.at(0)) && isdigit(input.at(1)) && first < rowSize && first >= 0 && second < columnSize && second >= 0){ //J keeps the program from crashing
          
            if (P1board[first][second].at(2) == ' ') {   //J executes when the space has the "empty" marker
                
                P2shots[first][second].at(2) = 'o';     //J player 2's shots board and players 1's board get updated with the "miss" marker
                P1board[first][second].at(2) = 'o';
                cout << "Miss!" << endl; 
                turn = 2;       //J marks the end of player 2's turn
            } 
            
            else if (P1board[first][second].at(2) == 'o' || P1board[first][second].at(2) == 'x') {   //J executes when a shot is made is a space where a shot was made previously
                cout << "You've aready fired at this location!" << endl;
            }
            
            else if (P1board[first][second].at(2) == 'b') {  //J executes when the space has a battleship piece in it
                
                P2shots[first][second].at(2) = 'x';         //J player 2's shots board and players 1's board get updated with the "hit" marker
                P1board[first][second].at(2) = 'x';
                cout << "Hit!" << endl;
                --p1ships;
                turn = 2;
            }
            
            else{
                cout << "How have you achieved this?" << endl;  //J supposedly, an impossible outcome.
            }
            
        }
        
        else if (input == "help"){
            help();
        }
        
        else{
            cout << "Invalid input! try again." << endl;    //entering anything other than end, a letter and a number, myBoard, myShots, or help will give this result.
            cout << "Type 'help' to see the commands." << endl;
        } 
      
        if (turn != 2){  //J executes if player 2's turn has not ended
            cout << endl;
        }
    }
    
    
    
    
    
    
    // start of AI code
    while (input != "end" && turn != 2 && Ai == '1'){  

        first = (rand() % columnSize);  //J AI randomly guesses where the battleships could be
        second = (rand() % rowSize);

        if ( first < rowSize && first >= 0 && second < columnSize && second >= 0){ //J keeps the program from crashing
          
            if (P1board[first][second].at(2) == ' ') {   //J executes when the space has the "empty" marker
                cout << P1board[first][second] << endl;
                P1board[first][second].at(2) = 'o';
                cout << "Miss!" << endl; 
                turn = 2;       //J marks the end of the AI's turn
            } 
            
            else if (P1board[first][second].at(2) == 'o' || P1board[first][second].at(2) == 'x') {   //J executes when a shot is made is a space where a shot was made previously
                //J prevents the AI from choosing the same location twice
            }
            
            else if (P1board[first][second].at(2) == 'b') {  //J executes when the space has a battleship in it
                cout << P1board[first][second] << endl;
                P1board[first][second].at(2) = 'x';
                cout << "Hit!" << endl;
                --p1ships;
                turn = 2;
            }
            
            else{
                cout << "How have you achieved this?" << endl;  //J supposedly, an impossible outcome.
                //C Nonetheless, we will try to
            }
        }
        
        if (turn != 2){  //J executes if player 2's turn has not ended
            cout << "deez nuts ";
        }
    }
    
    if (p1ships == 0){//C checks to see if p2 or AI has won the game
        cout << "Player 2 Wins!" << endl << "Thanks for playing!" << endl;
        input = "end";
        break;
    }
        
    if (turn == 2){  //J executes when player 2's turn has ended
        cout << "Player 1's turn!" << endl << endl;
    }
    
    
    
    cin >> input;
  } 
    
    cout << "Game over! Get rekt scrub!";//C a classic
    
return 0;
}






