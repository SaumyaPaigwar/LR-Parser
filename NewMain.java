/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lrparser;

import java.util.ArrayList;

/**
 *
 * @author SPaigwar
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        NewClass n=new NewClass();
        System.out.println("In Main n = "+n);
        n.d(n);
        ArrayList<NewClass> a=new ArrayList<>();
        a.add(n);
        System.out.println(""+a.get(0));
        NewClass n1=a.get(0);
        System.out.println(""+a.contains(n1));
    }
    
}
