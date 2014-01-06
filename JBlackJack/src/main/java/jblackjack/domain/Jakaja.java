
package jblackjack.logiikka;

public class Jakaja {
    public KorttiKasi kasi;
    
    public Jakaja(){
        kasi = new KorttiKasi();
    }
    
    public void annaKortti(Kortti kortti){
        kasi.lisaaKortti(kortti);
    }
    
    public void tulostaTiedot(){
        System.out.println("Jakaja: ");
        kasi.luetteleKortit();
    }
}
