/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jblackjack.logiikka;

public class Kortti {
    private final Maa maa;
    private final int arvo;
    
    public Kortti(int arvo, Maa maa){
        this.maa = maa;
        this.arvo = arvo;
    }
    public int getArvo(){
        return arvo;
    }
    public Maa getMaa(){
        return maa;
    } 
    @Override
    public String toString(){
        return maa + " " + arvo;
    }
    
    
    
}
