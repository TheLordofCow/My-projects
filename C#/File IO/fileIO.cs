//Jaxson Meisenhelter
//note: this program adds the even and odd txt files to your desktop.
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static System.Console;

namespace FileIO
{
    class FileIO
    {
        static void Main(string[] args)
        {
            string numStr = File.ReadAllText("numbers.txt", Encoding.UTF8);
            string[] numStrList = numStr.Split("\n");
            int[] numList = new int[numStrList.Length];
            
            for (int i = 0; i < numList.Length; i++)
            {
                numList[i] = Int32.Parse(numStrList[i]);      
            }

            string path = Environment.GetFolderPath(Environment.SpecialFolder.Desktop);
            using (StreamWriter outputFile = new StreamWriter(Path.Combine(path, "odd.txt")))
            {
                foreach (int num in numList) { 
                    if (num % 2 == 1)
                    {
                        outputFile.WriteLine(num);
                    }
                }
            }

            using (StreamWriter outputFile = new StreamWriter(Path.Combine(path, "even.txt")))
            {
                foreach (int num in numList)
                {
                    if (num % 2 == 0)
                    {
                        outputFile.WriteLine(num);
                    }
                }
            }
        }
    }
}