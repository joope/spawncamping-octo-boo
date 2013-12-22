
package jblackjack.logiikka;

import java.util.Scanner;

public class Peli {
    public Pelaajat pelaajat;
    public Korttipakka pakka;
    public Pelaaja jakaja;
    public Scanner lukija;
    
    public Peli(){
        lukija = new Scanner(System.in);
        pelaajat = new Pelaajat();
        pakka = new Korttipakka();
        jakaja = new Pelaaja("Jakaja", 0);
    }

    public void kaynnista() {
        pelaajat.lisaaPelaaja(new Pelaaja("Joni", 999));
        pelaajat.lisaaPelaaja(new Pelaaja("Jiikoo", 999));
        pelaajat.lisaaPelaaja(new Pelaaja("Jonne", 999));
        
        pelaajat.otaPanokset();
        pakka.sekoitaPakka();
        jaaKortit();
        
        tulostaTilanne();
    }
    
    public void jaaKortit(){
        pelaajat.jaaKortit(pakka);
        jakaja.kasi.lisaaKortti(pakka.nostaKortti());
    }
    
    public void tulostaTilanne(){
        jakaja.tulostaTiedot();
        System.out.println("________________________________");
        pelaajat.tulostaPelaajat();
    }

    
}
