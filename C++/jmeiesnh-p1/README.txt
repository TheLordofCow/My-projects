To use colsort, invoke it with './colsort filename'. Optionally, a key can be added before the file in the format './colsort [-2] filename' which causes the algorithm to sort by the nth word for each line.
Colsort starts by fiding the length of the file by detecting the number of newline characters in the file.
Colsort then stores every individual line into its own string in an array of pointers to conserve memory.
Then, the file then uses qsort() to sort the array of strings by the first word or then nth word if the optional argument is called.
Finally, the results are printed to the console and the file is replaced by the newly sorted strings.