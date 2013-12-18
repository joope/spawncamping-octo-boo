
package jblackjack.logiikka;

import java.util.ArrayList;
import java.util.Collections;

public class Korttipakka {
    public ArrayList<Kortti> pakka;
    
    public Korttipakka(){
        pakka = new ArrayList();
        lisaaKortit();
    }

    private void lisaaKortit() {
        for (int i = 1; i < 14; i++) {
            pakka.add(new Kortti(i, Maa.RISTI));
        }
        for (int i = 1; i < 14; i++) {
            pakka.add(new Kortti(i, Maa.HERTTA));
        }
        for (int i = 1; i < 14; i++) {
            pakka.add(new Kortti(i, Maa.PATA));
        }
        for (int i = 1; i < 14; i++) {
            pakka.add(new Kortti(i, Maa.RUUTU));
        }
    }
    
    public void sekoitaPakka(){
        Collections.shuffle(pakka);
    }
    
    public void luetteleKortit(){
        for (Kortti kortti : pakka) {
            System.out.println(kortti);
        }
    }
    
    public Kortti nostaKortti(){
        Kortti nostettava = pakka.get(pakka.size() - 1);
        pakka.remove(pakka.size() - 1);
        return nostettava;
    }
}
