using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static System.Console;

namespace IMS
{
    class Inventory
    {
        private String inv = "";
        private String name = "";
        private int p102;
        private int p215;
        private int p410;
        private int p525;
        private int p711;
        public Inventory(String name, String inv) 
        {
            this.name = name;
            String[] invList = inv.Split(" ");
            try
            {
                p102 = Int32.Parse(invList[0]);
                p215 = Int32.Parse(invList[1]);
                p410 = Int32.Parse(invList[2]);
                p525 = Int32.Parse(invList[3]);
                p711 = Int32.Parse(invList[4]);
            }     
            catch (FormatException)
            {
                Write("Error! a non-Integer has been detected in inventory.txt! ");
            }
        }
        
        public int getP102() {  return p102; }
        public int getP215() {  return p215; }
        public int getP410() {  return p410; }
        public int getP525() { return p525; }
        public int getP711() {  return p711; }
        public String getName() { return name; }

        public void addP102(int numParts) {  p102 += numParts; }
        public void addP215(int numParts) { p215 += numParts; }
        public void addP410(int numParts) { p410 += numParts; }
        public void addP525(int numParts) { p525 += numParts; }
        public void addP711(int numParts) { p711 += numParts; }
        
        public String getInv()
        {
            return name + " " + p102 + " " + p215 + " " + p410 + " " + p525 + " " + p711;
        }

    }
}
