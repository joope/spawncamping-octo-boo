package jblackjack.domain;

import jblackjack.domain.Kortit.Korttipakka;
import jblackjack.domain.Kortit.KorttiKasi;
import java.util.Scanner;
import jblackjack.kayttoliittyma.Kayttoliittyma;

/**
 * Pelilogiikka huolehtii pelin säännöistä ja vastaa käyttöliittymän kutsuihin.
 */
public class Pelilogiikka {

    public Kayttoliittyma gui;
    public Pelaaja pelaaja;
    public Korttipakka pakka;
    public KorttiKasi jakaja;
    public Scanner lukija;
    private String status;

    public Pelilogiikka() {
        lukija = new Scanner(System.in);
        jakaja = new KorttiKasi();
        pelaaja = new Pelaaja("Pelaaja", 100);
        status = "Peli alkaa";
    }

    /**
     *
     */
    public void kaynnista() {
        gui = new Kayttoliittyma(this);
        gui.run();
    }

    public void uusiPeli() {
        //if(status.equals("")){
        //    pelaaja.luovuta();
        //}
        if(pelaaja.panos < 5){
            pelaaja.laitaPanos(5);
        }
        pakka = new Korttipakka();
        pelaaja.tyhjennaKasiKorteista();
        jakaja.tyhjennaKasi();
        jaaKortit();
        status = "";
    }

    public void rahatLoppuivat() {
        pelaaja = new Pelaaja("Pelaaja", 100);
        status = "Peli alkaa";
        gui.rahatLoppuivat();
    }

    /**
     * Sekoittaa pakan,jakaa kortit pelaajan ja jakajan käteen
     */
    public void jaaKortit() {
        pakka.sekoitaPakka();
        pelaaja.otaKorttiKorttipakasta(pakka);
        pelaaja.otaKorttiKorttipakasta(pakka);
        jakaja.nostaKortti(pakka);
        tulostaTilanne();
    }

    /**
     * Tulostaa consoleen jakajan käden kortit pelaajan kortit, pelaajan rahat
     * ja panoksen.
     */
    public void tulostaTilanne() {
        System.out.println(jakaja.luetteleKortit());
        pelaaja.tulostaTiedot();
        System.out.println("******");
    }

    /**
     * Suoritetaan jos pelaaja pyytää uuden kortin
     */
    public void pyydaUusiKortti() {
        pelaaja.otaKorttiKorttipakasta(pakka);
        if (pelaaja.kasi.laskeKadenArvo() > 21) {
            havio();
        }
        tulostaTilanne();
    }

    /**
     * Suoritetaan jos pelaaja ei enää halua kortteja. Tällöin jakaja nostaa
     * kortteja kunnes jakajan käsi on yli 16 arvoltaan. Lopuksi tarkistetaan
     * kumpi voitti, jakaja vai pelaaja.
     */
    public void pysyKorteissa() {
        while (jakaja.laskeKadenArvo() < 17) {
            jakaja.nostaKortti(pakka);
        }

        tulostaTilanne();
        tarkistaKierroksenTulos();
    }

    /**
     * Jos jakajan käsi menee yli 21, pelaaja voittaa Jos pelaajan käsi on yli
     * jakajan käden, mutta alle 21, pelaaja voittaa Jos pelaajan käsi on
     * yhtäsuuri jakajan kanssa, tasapeli muulloin pelaaja häviää.
     */
    public void tarkistaKierroksenTulos() {
        if(pelaaja.kasi.laskeKadenArvo() == 21 && pelaaja.kasi.laskeKadenArvo() > jakaja.laskeKadenArvo()){
            voitto();
            status = "BlackJack!";
        }
        else if (pelaaja.kasi.laskeKadenArvo() > 21) {
            havio();
        } else if (jakaja.laskeKadenArvo() > 21) {
            voitto();
        } else if (pelaaja.kasi.laskeKadenArvo() > jakaja.laskeKadenArvo()) {
            voitto();
        } else if (pelaaja.kasi.laskeKadenArvo() == jakaja.laskeKadenArvo()) {
            tasapeli();
        } else {
            havio();
        }
    }

    /**
     * Antaa pelaajalle yhden kortin, minkä jälkeen kutsuu pysyKorteissa-metodia.
     */
    public void doubleDown() {
        pyydaUusiKortti();
        pysyKorteissa();
    }
    
    /**
     * 
     */

    private void voitto() {
        pelaaja.voita();
        status = "Voitit!";
        if (pelaaja.rahaa >= 1000) {
            lopullinenVoitto();
        }
    }

    private void havio() {
        pelaaja.havia();
        status = "Hävisit pelin :(";
        if (pelaaja.rahaa <= 0) {
            rahatLoppuivat();
        }
    }

    private void tasapeli() {
        status = "Tasapeli!";
    }

    public String getStatus() {
        return status;
    }

    public void lisaaPanoksia(int maara) {
        pelaaja.laitaPanos(maara);
    }

    private void lopullinenVoitto() {
        gui.voititPelin();
        pelaaja = new Pelaaja("Pelaaja", 100);
        status = "Peli alkaa";

    }

}
