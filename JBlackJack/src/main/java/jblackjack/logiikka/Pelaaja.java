

package jblackjack.logiikka;


public class Pelaaja {
    public String nimi;
    public KorttiKasi kasi;
    public int rahaa;
    
    public Pelaaja(String nimi, int rahaa){
        this.nimi = nimi;
        this.rahaa = rahaa;
        kasi = new KorttiKasi();
    }
}
