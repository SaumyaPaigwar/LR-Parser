    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lrparser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author SPaigwar
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        ArrayList<State> automaton=new ArrayList<>();
        System.out.println("Enter no. of production rules");
        int n = sc.nextInt();
        String[] productions = new String[n];
        System.out.println("Enter rules");
        String[] lr0_items = new String[n-1];
        for (int i = 0; i < n; i++) {
            productions[i] = sc.next();
            productions[i] = productions[i].substring(0, 2) + '.' + productions[i].substring(2);
            if(i!=0)
            {
                lr0_items[i-1] = productions[i];
                //System.out.println("lro[0] = "+lr0_items[i-1].charAt(0));
            }
        }
        /*for(int j=0;j<n;j++)
         {
         System.out.println(productions[j]);
         }*/

        State s = new State();
        s.productions.add(productions[0]);
        int i;
        int flag=0;
        ArrayList arr=new ArrayList();
        Iterator itr;//=arr.iterator();
        for (int j = 1; j < n; j++)
        {
            i=productions[flag].indexOf('.');
            for(int k=0;k<lr0_items.length;k++)
            {
                //System.out.println("flag = "+flag+" lr0_items["+k+"]"+lr0_items[k]);
                if(lr0_items[k].charAt(0)==productions[flag].charAt(i+1))
                {
                    //System.out.println("\nlr0_items["+k+"]"+lr0_items[k]);
                    //System.out.println("lr0_items["+k+"].charAt(0) = "+lr0_items[k].charAt(0));
                    s.productions.add(lr0_items[k]);
                    arr.add(k+1);
                }
            }
            itr=arr.iterator();
            //System.out.println("itr = "+itr);
            if(itr.hasNext())
                flag=(Integer)itr.next();
        }
        s.state_no = 0;
        System.out.println("================================");
        for (String p:s.productions) {
            System.out.println(p);
        }
        System.out.println("================================");
        //automaton.add(s);
        System.out.println("state no = " + s.state_no);
        //automaton.add(s);
        int cnt=lrparser.gen_state(s, s.state_no, lr0_items,automaton);
        System.out.println("\nprint\n cnt = "+(cnt-1));
        //lrparser.print(s);
        }
  
}



/*
5
T=S
S=(L)
S=x
L=S
L=L,S
*/