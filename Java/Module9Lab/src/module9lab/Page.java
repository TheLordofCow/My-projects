/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module9lab;

/**
 *
 * @author jcwm2
 */
public class Page {
    private String[] lines;

    public Page(int numLines) {
        lines = new String[numLines];
    }

    public Page(String[] l) {
        lines = l;
    }
    
    public String[] getLines() {
        return lines;
    }

    public void setLines(String[] lines) {
        this.lines = lines;
    }
    
    
}
