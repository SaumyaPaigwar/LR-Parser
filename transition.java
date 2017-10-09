/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lrparser;

/**
 *
 * @author SPaigwar
 */
public class transition {
    char trans_symbol;
        State next; 

    transition(char c2, State s1) {
        trans_symbol=c2;
        next=s1;
    }
}
