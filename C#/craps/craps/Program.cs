//Jaxson Meisenhelter
using System;
using static System.Console;

namespace craps
{
    class Craps
    {
        static void Main(string[] args)
        {
            int chips = 100;
            int wager = 0;
            Random key = new();

            //the game continutes until the number of chips reach 0 or the player chooses to end the game
            while (chips > 0)
            {
                Write("How many chips would you like to wager? You have " + chips + " chips remaining. ");

                //makes sure the user enters an integer for the wager
                while (true)
                {
                    try
                    {
                        wager = Int32.Parse(ReadLine());
                        break;
                    }
                    catch (FormatException)
                    {
                        Write("that is not a number! Please enter your wager. ");
                    }
                }

                //checks to make sure the wager is less then the number of chips remaining
                if (wager <= chips && wager >= 0)
                {
                    //rolls 2, 6 sided dices and adds them together.
                    int num1 = key.Next(1, 7);
                    int num2 = key.Next(1, 7);
                    int sum = num1 + num2;
                    WriteLine("you rolled a " + sum);

                    //if the player rolls a 7 or an 11, the round ends and the player recieves a number
                    //of chips equal to his wager
                    if (sum == 7 || sum == 11)
                    {
                        chips += wager;
                        WriteLine("You win! You have recieved " + wager + " chips!");
                    }
                    //if the player rolls any of these numbers, the player continuously rolls until the
                    //player recives the same number again
                    else if (sum == 4 || sum == 5 || sum == 6 || sum == 8 || sum == 9 || sum == 10)
                    {
                        re2:
                        num1 = key.Next(1, 7);
                        num2 = key.Next(1, 7);
                        int sum2 = num1 + num2;
                        WriteLine("you rolled a " + sum2);

                        //if the player rolls the same number as the very first roll, he wins
                        if(sum2 == sum)
                        {
                            chips += wager;
                            WriteLine("You win! You have recieved " + wager + " chips!");
                        }
                        //if the player rolls a 7, he loses
                        else if (sum2 == 7)
                        {
                            chips -= wager;
                            WriteLine("You lose, loser.");
                            WriteLine("You just got robbed for " + wager + " chips!");
                        }
                        //resets the loop if the player didn't roll the original sum and didn't roll a 7 either
                        else
                        {
                            goto re2;
                        }
                    }
                    //if the plaer fails to roll any of the above numbers (so if he rolls a 2, 3, or 12) he loses
                    //and his wager gets dudected from his number of chips
                    else
                    {
                        chips -= wager;
                        WriteLine("You lose, loser.");
                        WriteLine("You just got robbed for " + wager + " chips!");
                    } 
                }
                //this happens when the wager is out of bounds (higher then remaining chips or les than 0)
                else
                {
                    WriteLine("You don't have that many chips!");
                }

                //resets the loop here if the player desn't respond yes or no
                r1:
                Write("Would you like to continue the game? (y/n) ");
                string end = ReadLine();

                //ends the game if the player said no, continutes if they said yes
                if (end == "n")
                {
                    break;
                }
                else if (end == "y")
                {
                    //if the player has 0 chips left and tries to continue, this
                    //message is displayed and the game ends
                    if (chips == 0)
                    {
                        WriteLine("Well too bad, you're broke!");
                    }
                }
                else
                {
                    goto r1;
                }
            }

            //displays number of remaining chips
            Write("You ended the game with " + chips + " chips. ");
            if (chips == 0)
            {
                WriteLine("(What a loser)");
            }
        }
    }
}