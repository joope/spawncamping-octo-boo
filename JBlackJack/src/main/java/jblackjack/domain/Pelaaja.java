package jblackjack.domain;

import jblackjack.domain.Kortit.KorttiKasi;
import jblackjack.domain.Kortit.Korttipakka;

/**
 * Pelaaja-luokka 
 */
public class Pelaaja {

    public String nimi;
    public KorttiKasi kasi;
    public int viimeToiminto;
    public int rahaa;
    public int panos;

    /**
     *
     * @param nimi
     * @param rahaa
     */
    public Pelaaja(String nimi, int rahaa) {
        this.nimi = nimi;
        this.rahaa = rahaa;
        kasi = new KorttiKasi();
        panos = 0;
        viimeToiminto = 0;
    }

    /**
     * Ottaa korttipakasta kortin ja lisää sen pelaajan käteen.
     *
     * @param pakka
     */
    public void otaKorttiKorttipakasta(Korttipakka pakka) {
        kasi.nostaKortti(pakka);
    }

    /**
     * Tyhjentää pelaajan käden.
     *
     */
    public void tyhjennaKasiKorteista() {
        kasi.tyhjennaKasi();
    }
    
    /**
     * Pelaajan rahoja kasvatetaan kaksi kertaa panoksen verran, ja uudeksi
     * panokseksi lisätään vanha panos.
     *
     */
    public void voita() {
        int uusipanos = panos;
        rahaa += panos * 2;
        panos = 0;
        laitaPanos(uusipanos);
    }

    /**
     * Pelaajan panos kaksinkertaistetaan.
     *
     */
    public void doubleDown() {
        laitaPanos(panos);
    }

    /**
     * Pelaajan menettää rahoistaan puolet nykyisestä panoksesta.
     *
     */
    public void luovuta() {
        rahaa += panos / 2;
        panos = 0;
    }

    /**
     * Ottaa rahaa pelaajalta ja laittaa sen panokseksi. Jos panostus on
     * negatiivinen, pelaajan panoksesta vähennetään sen määrä, ja lisätään
     * rahoihin, kunhan panoksen määrä ei mene alle viiden.
     *
     * @param panostus
     */
    public void laitaPanos(int panostus) {
        if (panostus < 0 && panos + panostus >= 5) {
            rahaa -= panostus;
            panos += panostus;
        } else if (panostus > 0 && rahaa - panostus >= 0) {
            rahaa -= panostus;
            panos += panostus;
        }
    }

    /**
     * Nollaa pelaajan panoksen
     *
     */
    public void havia() {
        panos = 0;
    }

    /**
     * Tulostaa konsoliin pelaajan nimen, kortit ja rahan määrän.
     *
     */
    public void tulostaTiedot() {
        System.out.print(nimi + ": ");
        System.out.println(kasi.luetteleKortit());
        System.out.println("Rahaa: " + rahaa);
    }

    public int getPanos() {
        return panos;
    }
}
