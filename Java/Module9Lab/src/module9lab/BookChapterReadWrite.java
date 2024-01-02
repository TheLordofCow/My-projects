/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module9lab;

import java.io.*;
import java.util.*;

/**
 *
 * @author jcwm2
 */
public class BookChapterReadWrite {
    public static BookChapter loadBookChapterFromFile(String filename) throws FileNotFoundException, IOException{   
        ArrayList<Page> p = new ArrayList<>();
        File f = new File(filename);
        Scanner first = new Scanner(f);
        Scanner scan = new Scanner(f);
       
        String title = first.nextLine();
        String author = first.nextLine();
        int ppl = first.nextInt();
       
        try{
            for(int i = 0; i < f.length()/1700; i++){
            p.add(BookChapterReadWrite.getPage(scan, ppl));
            }
        }
        catch(NoSuchElementException e){
           BookChapter bc = new BookChapter(ppl, p, title, author);
       
           return bc;
       }
        BookChapter bc = new BookChapter(ppl, p, title, author);
       
        return bc;
    }
    
    public static void writeBookChapterToFile(BookChapter book, String filename) throws FileNotFoundException, IOException{
        FileOutputStream f = new FileOutputStream(filename);
        PrintWriter p = new PrintWriter(f);
        
        for(int i = 0; i < book.getPages().size(); i++){
            for(int j = 0; j < book.getPages().get(i).getLines().length; j++){
                p.flush();
                if(book.getPages().get(i).getLines()[j] != null){
                    p.println(book.getPages().get(i).getLines()[j]);
                }
            }
        }
        
        p.close();
    }
    
    private static Page getPage(Scanner scan, int numLines){        
        String[] pp = new String[numLines];
        
        try{
            for(int i = 0; i < numLines; i++){
                pp[i] = scan.nextLine();       
            }
        } 
        catch(Exception e){
            
        }
        Page p = new Page(pp);
        
        return p;
    }
}
