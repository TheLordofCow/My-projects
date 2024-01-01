using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Airline
{
    internal class Passenger
    {
        private int id = -1;
        private string name = "?";
        private int row = -1;
        private int column = -1;
        private int passengers = -1;
        private bool firstClass = false;
        private int seatNum = -1;

        public Passenger(string name, int id, int row, int column, bool firstClass, int passengers)
        {
            this.name = name;
            this.id = id;
            this.firstClass = firstClass;
            this.passengers = passengers;
            this.row = row;
            this.column = column;

            if(firstClass)           
                seatNum = row * 5 + column;           
            else
                seatNum = row * 7 + column;
        }
        public string Ticket()
        {
            string str = "Name: " + name + "\nID: " + id + "\nFirst Class? " + firstClass + "\nNumber of passengers: " + passengers + 
                "\nSeat number: " + seatNum + "\n";
            return str;
        }
        public string getName() { return name; }
        public int getId() { return id; } 
    }
}
