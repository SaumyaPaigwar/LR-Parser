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
public class lrparser {

    /**
     *
     * @param s
     * @param cnt
     * @param lr0_items
     * @return
     */
    public static ArrayList<State> gen_automaton(State s, int cnt, String[] lr0_items) {
        ArrayList<State> al = new ArrayList<>();
        char c1, c2;
        for (String prod : s.productions) {
            for (int j = 0; j < prod.length(); j++) {
                if (prod.charAt(j) == '.'
                        && ((c2 = prod.charAt(j + 1)) >= 'A' && c2 <= 'Z')) {
                    State s1 = new State();
                    s1.productions.add(prod.substring(0, j) + prod.substring(j + 1, j + 2) + '.');
                }
            }
        }
        return al;
    }

    @SuppressWarnings("empty-statement")  // ainvayi hai please ignore......!!!!!!!
    public static int gen_state(State s, int cnt, String[] lr0_items, ArrayList<State> automaton) {
        System.out.println("state no gen_state = "+s.state_no);
        int cnt_p = 0,flag;
        boolean b=automaton.add(s);
        //System.out.println("hello................");
        //System.out.println("addedd " +b);
        for (String prod : s.productions)
        {
            if ((prod.charAt(prod.length() - 1)) == '.') {
                cnt_p++;
            }
        }
        if(cnt_p==s.productions.size())
            automaton.add(s);
        if (cnt_p != s.productions.size())
        {
            ArrayList<String> temp = new ArrayList<>();
            State s1;
            char c1, c2 = ' ', c3, c3p = ' ';
            for (String prod1 : s.productions) {
                //int[] flag=new int[prod1.length()];
                if (!temp.contains(prod1)) {
                    int size = prod1.length() - 1;
                    int index = s.productions.indexOf(prod1);
                    s1 = new State();
                    s1.state_no = cnt + 1;
                    System.out.println("state no = " + s1.state_no);
                    cnt = cnt + 1;
                    //System.out.println("prod1 = "+prod1);
                    for (int j = 0; j < prod1.length(); j++) {

                        c1 = prod1.charAt(j);
                        //j=prod1.indexOf('.');
                        if (c1 == '.' && (size - j) > 1) {
                            c2 = prod1.charAt(j + 1);
                            c3p = prod1.charAt(j + 2);
                            flag=1;
                            s1.productions.add(prod1.substring(0, j)
                                    + prod1.substring(j + 1, j + 2) + '.'
                                    + prod1.substring(j + 2));
                        } else if (c1 == '.' && (size - j) == 1) {
                            c2 = prod1.charAt(j + 1);
                            flag=0;
                            s1.productions.add(prod1.substring(0, j)
                                    + prod1.substring(j + 1) + '.');
                        } else {
                            continue;
                        }
                        for (int k = index + 1; k < s.productions.size(); k++) {
                            String s_temp = s.productions.get(k);
                            //System.out.println("s_temp = "+s_temp);
                            size = s_temp.length() - 1;
                        //System.out.println("size = "+size);
                        /*for(int l=0;l<=size;l++)
                             {
                             int ind=s_temp.indexOf(".");
                             if (s_temp.charAt(l) == '.')
                             {
                             if((s_temp.charAt(l+1)==c2)&& (size - l) > 1)
                             {
                             s1.productions.add(prod1.substring(0, l)
                             + prod1.substring(l + 1, l + 2) + '.'
                             + prod1.substring(l + 2));
                             }
                             }
                             }*/
                            int l = s_temp.indexOf('.');
                            if (l < s_temp.length() - 2)
                            {
                                if ((s_temp.charAt(l + 1) == c2))
                                {
                                    temp.add(s_temp);
                                    //System.out.println("yes");
                                    //System.out.println("stemp "+s_temp);
                                    if ((size - l) > 1)
                                    {
                                    //System.out.println("s_temp.substring(0, l) + s_temp.substring(l + 1, l + 2) + s_temp.substring(l + 2)"+s_temp.substring(0, l)+" "
                                        // + s_temp.substring(l + 1, l + 2) +" "+ '.'
                                        // +" "+ s_temp.substring(l + 2));
                                        s1.productions.add(s_temp.substring(0, l)
                                                + s_temp.substring(l + 1, l + 2) + '.'
                                                + s_temp.substring(l + 2));
                                        c3 = s_temp.charAt(l + 2);
                                        for (String lr0_item : lr0_items)
                                        {
                                            if (lr0_item.charAt(0) == c3) {
                                                System.out.println("in " + lr0_item);
                                                s1.productions.add(lr0_item);
                                            }
                                        }
                                    } else if ((size - l) == 1) {
                                        //c2 = prod1.charAt(j + 1);
                                        s1.productions.add(s_temp.substring(0, l)
                                                + s_temp.substring(l + 1) + '.');
                                    }

                                }
                            }
                        }
                        if(flag==1)
                            for (String lr0_item : lr0_items) {
                                // System.out.println(lr0_item);
                                if (lr0_item.charAt(0) == c3p) {
                                    s1.productions.add(lr0_item);
                                }
                            }
                    }
                    //System.out.println("contains = "+automaton.contains(s1));
                    //System.out.println("s1 add = "+s1);
                    //for(State sj:automaton)
                     //   System.out.println("add in automaton = "+sj);
                    for(State sj:automaton)
                    {
                        //System.out.println("add in automaton = "+sj);
                        //System.out.println("sj[0] "+sj.productions.get(0));
                        //System.out.println("s1[0] "+s1.productions.get(0));
                        if(s1.productions.get(0).equals(sj.productions.get(0)))
                        {
                            System.out.println("true");
                            s1=sj;
                            //System.out.println("sj add = "+sj);
                            cnt=cnt-1;
                            break;
                        }
                    }
                    //System.out.println("after wards s1 add = "+s1);
                    if (!automaton.contains(s1))
                    {
                        s.trans.add(new transition(c2, s1));//add s1 to next of s
                       // automaton.add(s1);
                    }
                    else {
                        int a = automaton.indexOf(s1);
                        //System.out.println("index of s1 = "+a);
                        s.trans.add(new transition(c2, automaton.get(a)));
                    }
                    for (String p : s1.productions)
                    {
                        System.out.println("p " + p);
                    }
                    System.out.println("after state no = "+s1.state_no);
                    System.out.println("===========================");
                //if(!automaton.contains(s1))
                
                }

            }
        }
        for(transition t:s.trans)
        {
            //System.out.println(automaton.contains(t.next));
            if(automaton.contains(t.next)){
                ;
            }
            else
            {
                //automaton.add(s);
                cnt=gen_state(t.next, cnt, lr0_items, automaton);
            }
        }
        return cnt;
    }

    public static void print(State s) {
        if (s.trans.isEmpty()) {
            System.out.println(s.state_no);
            return;
        } else {
            System.out.println(s.state_no);
            for (transition t : s.trans) {
                print(t.next);
            }
        }

    }
}



// && ((c2=prod1.charAt(j+1)) >= 'A' && c2 <= 'Z')
