
package jblackjack.domain;

import jblackjack.domain.Kortit.Kortti;
import jblackjack.domain.Kortit.KorttiKasi;

/**
 * 
 */

public class Jakaja {

    public KorttiKasi kasi;
    
    /**
     *
     */
    public Jakaja(){
        kasi = new KorttiKasi();
    }
    
    /**
     *
     */
    public void tulostaTiedot(){
        System.out.println("Jakaja: ");
        System.out.println(kasi.luetteleKortit());
    }
    
    public void tyhjennaKasi(){
        kasi.kortit.clear();
    }
    
    /**
     *
     * @param kortti
     */
    public void otaKortti(Kortti kortti){
        kasi.kortit.add(kortti);
    }
}
