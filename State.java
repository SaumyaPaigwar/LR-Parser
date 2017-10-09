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
public class State {
    ArrayList<String> productions=new ArrayList<>();
    ArrayList<transition> trans=new ArrayList();
    int state_no;
    public State() {
    }
    public State(State s)
    {
        this.productions=s.productions;
        this.trans=s.trans;
        this.state_no=s.state_no;
    }
    public boolean compare(State s)
    {
        for(String s1:productions)
            for(String s2:s.productions)
                if(!s1.equals(s2))
                    return false;
        for(transition t1:trans)
            for(transition t2:s.trans)
                if(t1.trans_symbol!=t2.trans_symbol)
                    return false;
        return true;
    }
}
