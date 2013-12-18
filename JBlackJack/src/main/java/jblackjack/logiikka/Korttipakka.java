
package jblackjack.logiikka;

import java.util.ArrayList;
import java.util.Collections;

public class Korttipakka extends KorttiKokoelma{
    
    public Korttipakka(){
        super();
        lisaaKortit();
    }

    private void lisaaKortit() {
        for (int i = 1; i < 14; i++) {
            lisaaKortti(new Kortti(i, Maa.RISTI));
        }
        for (int i = 1; i < 14; i++) {
            lisaaKortti(new Kortti(i, Maa.HERTTA));
        }
        for (int i = 1; i < 14; i++) {
            lisaaKortti(new Kortti(i, Maa.PATA));
        }
        for (int i = 1; i < 14; i++) {
            lisaaKortti(new Kortti(i, Maa.RUUTU));
        }
    }
    
    public void sekoitaPakka(){
        Collections.shuffle(kortit);
    }
    
    public Kortti nostaKortti(){
        Kortti nostettava = kortit.get(kortit.size() - 1);
        kortit.remove(kortit.size() - 1);
        return nostettava;
    }
}
