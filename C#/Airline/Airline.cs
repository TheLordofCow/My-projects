using System;
using System.Collections.Immutable;
using System.IO;
using System.IO.Pipes;
using System.Runtime.ConstrainedExecution;
using System.Text;
using static System.Console;

namespace Airline
{
    class Airline
    {
        static void Main(string[] args)
        {
            List<Passenger> PassengerList = new List<Passenger>();
            bool firstClass = false;
            int id = 10; //starts at 10 to make seating look nice when shown on console
            int passengers = 0;
            int row = 0;
            int column = 0;
            int[] seatNum = { -1, -1 };
            string name = "";           
            string ans = "";
            string ticket = "";
            string[,] firstSeats =
            { { "XX", "XX", "||", "XX", "XX"},
              { "XX", "XX", "||", "XX", "XX"},
              { "XX", "XX", "||", "XX", "XX"},
              { "XX", "XX", "||", "XX", "XX"},
              { "XX", "XX", "||", "XX", "XX"} };
            string[,] ecoSeats =
            { { "XX", "XX", "XX", "||", "XX", "XX", "XX"},
              { "XX", "XX", "XX", "||", "XX", "XX", "XX"},
              { "XX", "XX", "XX", "||", "XX", "XX", "XX"},
              { "XX", "XX", "XX", "||", "XX", "XX", "XX"},
              { "XX", "XX", "XX", "||", "XX", "XX", "XX"},
              { "XX", "XX", "XX", "||", "XX", "XX", "XX"},
              { "XX", "XX", "XX", "||", "XX", "XX", "XX"},
              { "XX", "XX", "XX", "||", "XX", "XX", "XX"},
              { "XX", "XX", "XX", "||", "XX", "XX", "XX"},
              { "XX", "XX", "XX", "||", "XX", "XX", "XX"},
              { "XX", "XX", "XX", "||", "XX", "XX", "XX"},
              { "XX", "XX", "XX", "||", "XX", "XX", "XX"},
              { "XX", "XX", "XX", "||", "XX", "XX", "XX"},
              { "XX", "XX", "XX", "||", "XX", "XX", "XX"},
              { "XX", "XX", "XX", "||", "XX", "XX", "XX"},
              { "XX", "XX", "XX", "||", "XX", "XX", "XX"} };

            while (!ans.Equals("4"))
            {
                WriteLine("1: add passengers");
                WriteLine("2: show seating");
                WriteLine("3: create ticket");
                WriteLine("4: quit");

                ans = ReadLine();
                if(ans is null)
                    ans = "";

                switch (ans)
                {
                    case "1":
                        WriteLine("Name?");
                        name = ReadLine();
                        if (name is null)
                            name = "?";

                        ecoChoice:
                        WriteLine("ecomony or first class (e/f)?");
                        ans = ReadLine();
                        if (ans is null)
                            goto ecoChoice;

                        if (ans.Equals("e"))
                            firstClass = false;
                        else if (ans.Equals("f"))
                            firstClass = true;
                        else
                            goto ecoChoice;

                        classSplit:
                        //first class passenger
                        if (firstClass)
                        {
                            WriteLine("How many passangers? (2 max)");
                            ans = ReadLine();
                            if (ans is null)
                                goto classSplit;

                            try
                            {
                                passengers = Int32.Parse(ans);
                            }
                            catch
                            {
                                goto classSplit;
                            }
     
                            if (passengers == 1 || passengers == 2)
                            {
                            firstStart:
                                WriteLine("window or aisle seat? (w/a)");
                                ans = ReadLine();
                                if (ans is null)
                                    goto firstStart;
                                else if (ans.Equals("w"))
                                {
                                    for (int i = 0; i < 5; i++)
                                    {
                                        //checking window sets, which is column 0 and 4
                                        for (int j = 0; j < 5; j += 4)
                                        {
                                            if (firstSeats[i, j].Equals("XX"))
                                            {
                                                firstSeats[i, j] = id.ToString();
                                                row = i; column = j;
                                                goto firstEnd;
                                            }
                                        }
                                    }
                                    WriteLine("Sorry, there are no window seats available.");
                                    goto firstStart;
                                }
                                else if (ans.Equals("a"))
                                {
                                    for (int i = 0; i < 5; i++)
                                    {
                                        //checking aisle sets, which is column 1 and 3
                                        for (int j = 1; j < 4; j += 2)
                                        {
                                            if (firstSeats[i, j].Equals("XX"))
                                            {
                                                firstSeats[i, j] = id.ToString();
                                                row = i; column = j;
                                                goto firstEnd;
                                            }
                                        }
                                    }
                                    WriteLine("Sorry, there are no aisle seats available.");
                                    goto firstStart;
                                }
                                else                               
                                    goto firstStart;
                                
                            firstEnd:
                                Passenger p = new Passenger(name, id, row, column, firstClass, passengers);
                                PassengerList.Add(p);
                                id++;
                            }
                            else
                                goto classSplit;                           
                        }
                        //economy class passenger
                        else
                        {
                            WriteLine("How many passangers? (3 max)");
                            ans = ReadLine();
                            if (ans is null)
                                goto classSplit;

                            try
                            {
                                passengers = Int32.Parse(ans);
                            }
                            catch
                            {
                                goto classSplit;
                            }

                            if (passengers >= 1 && passengers <= 3)
                            {
                            ecoStart:
                                WriteLine("window, center, or aisle seat? (w/c/a)");
                                ans = ReadLine();
                                if (ans is null)
                                    goto ecoStart;
                                else if (ans.Equals("w"))
                                {
                                    for (int i = 0; i < 15; i++)
                                    {
                                        //checking window sets, which is column 0 and 6
                                        for (int j = 0; j < 7; j += 6)
                                        {
                                            if (ecoSeats[i, j].Equals("XX"))
                                            {
                                                ecoSeats[i, j] = id.ToString();
                                                row = i; column = j;
                                                goto ecoEnd;
                                            }
                                        }
                                    }
                                    WriteLine("Sorry, there are no window seats available.");
                                    goto ecoStart;
                                }
                                else if (ans.Equals("c"))
                                {
                                    for (int i = 0; i < 15; i++)
                                    {
                                        //checking center sets, which is column 1 and 5
                                        for (int j = 1; j < 6; j += 4)
                                        {
                                            if (ecoSeats[i, j].Equals("XX"))
                                            {
                                                ecoSeats[i, j] = id.ToString();
                                                row = i; column = j;
                                                goto ecoEnd;
                                            }
                                        }
                                    }
                                    WriteLine("Sorry, there are no center seats available.");
                                    goto ecoStart;
                                }
                                else if (ans.Equals("a"))
                                {
                                    for (int i = 0; i < 15; i++)
                                    {
                                        //checking aisle sets, which is column 2 and 4
                                        for (int j = 2; j < 5; j += 2)
                                        {
                                            if (ecoSeats[i, j].Equals("XX"))
                                            {
                                                ecoSeats[i, j] = id.ToString();
                                                row = i; column = j;
                                                goto ecoEnd;
                                            }
                                        }
                                    }
                                    WriteLine("Sorry, there are no aisle seats available.");
                                    goto ecoStart;
                                }
                                else
                                    goto ecoStart;
                                
                                ecoEnd:
                                Passenger p = new Passenger(name, id, row, column, firstClass, passengers);
                                PassengerList.Add(p);
                                id++;
                            }
                            else
                            {
                                goto classSplit;
                            }
                        }
                        break;
                    //show passengers
                    case "2":
                        WriteLine("First Class seating:");
                        for (int i = 0; i < 5; i++)
                        {
                            for (int j = 0; j < 5; j++)
                            {
                                Write(firstSeats[i, j] + " ");
                            }
                            WriteLine();
                        }
                        WriteLine();

                        WriteLine("Economy Class seating:");
                        for (int i = 0; i < 15; i++)
                        {
                            for (int j = 0; j < 7; j++)
                            {
                                Write(ecoSeats[i, j] + " ");
                            }
                            WriteLine();
                        }
                        WriteLine();
                        break;
                    //create ticket
                    case "3":
                        WriteLine("What is the passenger's name or ID?");
                        ans = ReadLine();
                        if (ans is null || ans.Length == 0)
                            break;
                        
                        try
                        {
                            int tempId = Int32.Parse(ans);
                            Passenger p = PassengerList.Find(x => x.getId() == tempId);
                            if(p is null)
                            {
                                WriteLine("No passenger found. (ID)");
                                goto ticketEnd;
                            }
                            ticket = p.Ticket();
                            WriteLine(ticket);
                        }
                        catch
                        {
                            name = ans;
                            Passenger p = PassengerList.Find(x => x.getName().Equals(name));
                            if (p is null)
                            {
                                WriteLine("No passenger found. (Name)");
                                goto ticketEnd;
                            }

                            ticket = p.Ticket();
                            WriteLine(ticket);
                        }

                        string path = Environment.GetFolderPath(Environment.SpecialFolder.Desktop);
                        using (StreamWriter outputFile = new StreamWriter(Path.Combine(path, "ticket.txt")))
                        {
                            outputFile.Write(ticket);
                        }

                        ticketEnd:
                        break;
                    default: break;
                }
            }
        }
    }
}