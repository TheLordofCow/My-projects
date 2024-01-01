//Jaxson Meisenhelter
using System;
using System.Collections.Immutable;
using System.IO;
using System.Runtime.ConstrainedExecution;
using System.Text;
using static System.Console;

namespace IMS
{
    class Warehouses
    {
        static void Main(string[] args)
        {
            Inventory[] wares = new Inventory[6];
            String[] names = {"Atlanta", "Baltimore", "Chicago", "Denver", "Ely", "Fargo"};

            string tran = File.ReadAllText("transactions.txt", Encoding.UTF8);
            String[] tranList = tran.Split("\n");
            String[][] tranList2 = new String[tranList.Length][];

            for (int i = 0; i < tranList.Length;  i++)
            {
                tranList2[i] = tranList[i].Split(" ");
            }

            string inv = File.ReadAllText("inventory.txt", Encoding.UTF8);
            WriteLine("Starting Inventory:");
            WriteLine("P102 P215 P410 P525 P711");
            WriteLine(inv);
            WriteLine();

            String[] invList = inv.Split("\n");

            for (int i = 0; i < wares.Length; i++)
            {
                Inventory temp = new Inventory(names[i], invList[i]);
                wares[i] = temp;
            }


            //main code
            for (int i = 0; i < tranList2.Length; i++)
            {
                if (tranList2[i][1] == "102")
                {
                    var sortedWares = wares.OrderBy(x => x.getP102()).ToArray();

                    if (tranList2[i][0] == "P")
                    {
                        sortedWares.First().addP102(Int32.Parse(tranList2[i][2]));
                        WriteLine("Warehouse " + sortedWares.First().getName() + "'s p102 supply has increased by " + tranList2[i][2]);
                    }
                    else if (tranList2[i][0] == "S")
                    {
                        sortedWares.Last().addP102(-Math.Abs(Int32.Parse(tranList2[i][2])));
                        WriteLine("Warehouse " + sortedWares.Last().getName() + "'s p102 supply has decreased by " + tranList2[i][2]);
                    }
                    else
                    {
                        Write("Error! Incorrect type used in transactions.txt (P or S only)");
                        break;
                    }
                }
                else if (tranList2[i][1] == "215")
                {
                    var sortedWares = wares.OrderBy(x => x.getP215()).ToArray();

                    if (tranList2[i][0] == "P")
                    {
                        sortedWares.First().addP215(Int32.Parse(tranList2[i][2]));
                        WriteLine("Warehouse " + sortedWares.First().getName() + "'s p215 supply has increased by " + tranList2[i][2]);
                    }
                    else if (tranList2[i][0] == "S")
                    {
                        sortedWares.Last().addP215(-Math.Abs(Int32.Parse(tranList2[i][2])));
                        WriteLine("Warehouse " + sortedWares.Last().getName() + "'s p215 supply has decreased by " + tranList2[i][2]);
                    }
                    else
                    {
                        Write("Error! Incorrect type used in transactions.txt (P or S only)");
                        break;
                    }
                }
                else if (tranList2[i][1] == "410")
                {
                    var sortedWares = wares.OrderBy(x => x.getP410()).ToArray();

                    if (tranList2[i][0] == "P")
                    {
                        sortedWares.First().addP410(Int32.Parse(tranList2[i][2]));
                        WriteLine("Warehouse " + sortedWares.First().getName() + "'s p410 supply has increased by " + tranList2[i][2]);
                    }
                    else if (tranList2[i][0] == "S")
                    {
                        sortedWares.Last().addP410(-Math.Abs(Int32.Parse(tranList2[i][2])));
                        WriteLine("Warehouse " + sortedWares.Last().getName() + "'s p410 supply has decreased by " + tranList2[i][2]);
                    }
                    else
                    {
                        Write("Error! Incorrect type used in transactions.txt (P or S only)");
                        break;
                    }
                }
                else if (tranList2[i][1] == "525")
                {
                    var sortedWares = wares.OrderBy(x => x.getP525()).ToArray();

                    if (tranList2[i][0] == "P")
                    {
                        sortedWares.First().addP525(Int32.Parse(tranList2[i][2]));
                        WriteLine("Warehouse " + sortedWares.First().getName() + "'s p525 supply has increased by " + tranList2[i][2]);
                    }
                    else if (tranList2[i][0] == "S")
                    {
                        sortedWares.Last().addP525(-Math.Abs(Int32.Parse(tranList2[i][2])));
                        WriteLine("Warehouse " + sortedWares.Last().getName() + "'s p525 supply has decreased by " + tranList2[i][2]);
                    }
                    else
                    {
                        Write("Error! Incorrect type used in transactions.txt (P or S only)");
                        break;
                    }
                }
                else if (tranList2[i][1] == "711")
                {
                    var sortedWares = wares.OrderBy(x => x.getP711()).ToArray();

                    if (tranList2[i][0] == "P")
                    {
                        sortedWares.First().addP711(Int32.Parse(tranList2[i][2]));
                        WriteLine("Warehouse " + sortedWares.First().getName() + "'s p711 supply has increased by " + tranList2[i][2]);
                    }
                    else if (tranList2[i][0] == "S")
                    {
                        sortedWares.Last().addP711(-Math.Abs(Int32.Parse(tranList2[i][2])));
                        WriteLine("Warehouse " + sortedWares.Last().getName() + "'s p711 supply has decreased by " + tranList2[i][2]);
                    }
                    else
                    {
                        Write("Error! Incorrect type used in transactions.txt (P or S only)");
                        break;
                    }
                }
            }

            WriteLine();
            WriteLine("Final Inventory:");
            WriteLine("Name P102 P215 P410 P525 P711");
            for(int i = 0; i < wares.Length; i++)
            {
                WriteLine(wares[i].getInv());
            }
        }
    }
}