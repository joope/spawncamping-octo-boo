

package jblackjack.logiikka;

import java.util.ArrayList;

public class Pelaaja {
    public String nimi;
    public ArrayList<Kortti> kasi;
    public int rahaa;
    
    public Pelaaja(String nimi, int rahaa){
        this.nimi = nimi;
        this.rahaa = rahaa;
        kasi = new ArrayList();
    }
}
