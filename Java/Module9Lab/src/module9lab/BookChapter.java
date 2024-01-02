/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module9lab;
import java.util.*;

/**
 *
 * @author jcwm2
 */
public class BookChapter {
    private int linesPerPage;
    private ArrayList<Page> pages;
    private String title;
    private String author;

    public BookChapter(int l){
        linesPerPage = l;
    }
    
    public BookChapter(int l, ArrayList<Page> p){
        linesPerPage = l;
        pages = p;
    }
    
    public BookChapter(int l, ArrayList<Page> p, String t, String a){
        linesPerPage = l;
        pages = p;
        title = t;
        author = a;
    } 
    
    public int getLinesPerPage() {
        return linesPerPage;
    }

    public ArrayList<Page> getPages() {
        return pages;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void setLinesPerPage(int linesPerPage) {
        this.linesPerPage = linesPerPage;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "BookChapter {" + " linesPerPage: " + linesPerPage + ", pages: " + pages.size() + ", title: " + title + ", author: " + author + '}';
    }
    
    
    
    
}
