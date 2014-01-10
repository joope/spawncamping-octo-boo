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
     * Luo käyttöliittymän ja laittaa sen käyntiin.
     *
     */
    public void kaynnista() {
        gui = new Kayttoliittyma(this);
        gui.run();
    }

    /**
     * Aloittaa pelissä uuden kierroksen. Kortipakka luodaan ja sekoitetaan.
     * Pelaajan ja jakajan kädet tyhjennetään ja lopuksi jaetaan kaikille uusi
     * käsi.
     */
    public void aloitaUusiKierros() {
        if (pelaaja.panos < 5) {
            pelaaja.laitaPanos(5);
        }
        tyhjennaPelaajienKadetKorteista();
        jaaKortitPelaajalleJaJakajalle();
        status = "";
    }
    
    /**
     * Tyhjentää pelaajan ja jakajan kädet korteista.
     */

    public void tyhjennaPelaajienKadetKorteista() {
        pelaaja.tyhjennaKasiKorteista();
        jakaja.tyhjennaKasi();
    }

    /**
     * Jos pelaajan rahat loppuvat, aloitetaan uusi peli. Pelaajalle annetaan
     * rahat takaisin ja pelaajalle ilmoitetaan tästä pop-up-ikkunan avulla.
     *
     */
    public void pelaajanRahatLoppuivat() {
        pelaaja = new Pelaaja("Pelaaja", 100);
        status = "Peli alkaa";
        gui.rahatLoppuivat();
    }

    /**
     * Sekoittaa pakan ja jakaa kaksi korttia pelaajalle ja yhden jakajalle.
     */
    public void jaaKortitPelaajalleJaJakajalle() {
        pakka = new Korttipakka();
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
     * Suoritetaan jos pelaaja pyytää uuden kortin. Jos pelaajan käden arvo
     * ylittää 21 kortinjaon jälkeen niin pelaaja häviää.
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
        if (pelaaja.kasi.laskeKadenArvo() == 21 && pelaaja.kasi.laskeKadenArvo() > jakaja.laskeKadenArvo()) {
            voitto();
            status = "BlackJack!";
        } else if (pelaaja.kasi.laskeKadenArvo() > 21) {
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
     * Antaa pelaajalle yhden kortin, minkä jälkeen kutsuu
     * pysyKorteissa-metodia.
     */
    public void doubleDown() {
        pyydaUusiKortti();
        pysyKorteissa();
    }

    /**
     * Kutsuu pelaajan voitto-metodia ja muuttaa statukseen "Voitit!". Jos
     * kutsuttaessa pelaajan rahat ovat 1000 tai yli, kutsutaan metodia
     * lopullinenVoitto()
     */
    private void voitto() {
        pelaaja.voita();
        status = "Voitit!";
        if (pelaaja.rahaa >= 1000) {
            lopullinenVoitto();
        }
    }

    /**
     * Kutsuu pelaajan havia-metodia ja muuttaa statukseksi "Hävisit pelin :("
     * Jos pelaajan rahat ovat nolla tai alle niin kutsutaan
     * pelaajanRahatLoppuivat-metodia
     */
    private void havio() {
        pelaaja.havia();
        status = "Hävisit pelin :(";
        if (pelaaja.rahaa <= 0) {
            pelaajanRahatLoppuivat();
        }
    }

    /**
     * Kutsutaan jos jakajan ja pelaajan kädet ovat samanarvoiset. Muuttaa
     * statukseksi "Tasapeli!"
     */
    private void tasapeli() {
        status = "Tasapeli!";
    }

    public String getStatus() {
        return status;
    }

    /**
     * Lisaa tai vähentää pelaajan panosta annetun verran. Käyttöliittymän
     * panoksenlisäys ja -vähennys painikkeet kutsuvat tätä metodia.
     *
     * @param maara
     */
    public void lisaaPanoksia(int maara) {
        pelaaja.laitaPanos(maara);
    }

    /**
     * Ilmoittaa pelaajalle voitosta pop-up-ikkunalla, ja antaa pelaajalle 100
     * rahaa.
     *
     */
    private void lopullinenVoitto() {
        gui.voititPelin();
        pelaaja = new Pelaaja("Pelaaja", 100);
        status = "Peli alkaa";

    }

}
