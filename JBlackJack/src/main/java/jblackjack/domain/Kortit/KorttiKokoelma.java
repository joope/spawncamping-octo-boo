
package jblackjack.domain.Kortit;

import java.util.ArrayList;

/**
 *
 * @author pyjopy
 * Korttipakan ja korttikäden yliluokka.
 * 
 */
public class KorttiKokoelma {

    /**
     * Lista korteista
     */
    public ArrayList<Kortti> kortit;

    public KorttiKokoelma() {
        kortit = new ArrayList();
    }

    /**
     * lisää kortin kokoelmaan
     * @param kortti
     */
    public void lisaaKortti(Kortti kortti) {
        kortit.add(kortti);
    }

    /**
     * poistaa kortti kokoelmasta
     * @param kortti
     */
    public void poistaKortti(Kortti kortti) {
        kortit.remove(kortti);
    }
    
     /**
     * Palauttaa luettelon korteista merkkijonona
     * @return
     */
    public String luetteleKortit(){
        if(kortit.isEmpty()){
            return "";
        } else {
            String palautus = "";
            for (Kortti kortti : kortit) {
                palautus += kortti + ", ";
            }
            return palautus;
        }
    }

    public ArrayList<Kortti> getKortit() {
        return kortit;
    }
}
