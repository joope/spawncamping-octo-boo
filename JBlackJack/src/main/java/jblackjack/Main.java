package jblackjack.jblackjack;
import jblackjack.logiikka.*;

public class Main 
{
    public static void main( String[] args )
    {
        Pelaaja jaakko = new Pelaaja("Jaakko", 100);
        Korttipakka pakka = new Korttipakka();
        pakka.sekoitaPakka();
        jaakko.kasi.lisaaKortti(pakka.nostaKortti());
        jaakko.kasi.lisaaKortti(pakka.nostaKortti());
        jaakko.kasi.lisaaKortti(pakka.nostaKortti());
        jaakko.kasi.luetteleKortit();
        System.out.println(jaakko.kasi.laskeKadenArvo());
        
    }
}
