/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jblackjack.logiikka;

import java.util.ArrayList;

public class KorttiKokoelma {

    public ArrayList<Kortti> kortit;

    public KorttiKokoelma() {
        kortit = new ArrayList();
    }

    public void lisaaKortti(Kortti kortti) {
        kortit.add(kortti);
    }

    public void poistaKortti(Kortti kortti) {
        kortit.remove(kortti);
    }
    
    public void luetteleKortit(){
        if(kortit.isEmpty()){
            System.out.println("Ei kortteja");
        } else {
            for (Kortti kortti : kortit) {
                System.out.print(kortti +", ");
            }
        }
    }

    public ArrayList<Kortti> getKortit() {
        return kortit;
    }
}
