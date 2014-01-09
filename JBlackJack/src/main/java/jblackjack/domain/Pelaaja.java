package jblackjack.domain;

import jblackjack.domain.Kortit.KorttiKasi;
import jblackjack.domain.Kortit.Korttipakka;

/**
 * Pelaaja-luokka sisältää pelaajan toiminnallisuuden
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
     *
     * @param pakka
     */
    public void otaKortti(Korttipakka pakka) {
        kasi.nostaKortti(pakka);
    }

    public void tyhjennaKasi() {
        kasi.tyhjennaKasi();
    }

    /**
     *
     */
    public void voita() {
        int uusipanos = panos;
        rahaa += panos * 2;
        panos = 0;
        laitaPanos(uusipanos);
    }

    /**
     *
     */
    public void doubleDown() {
        laitaPanos(panos);
    }

    /**
     *
     */
    public void luovuta() {
        rahaa += panos / 2;
        panos = 0;
    }

    /**
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
     *
     * @param toiminto
     */
    public void setViimeToiminto(int toiminto) {
        viimeToiminto = toiminto;
    }

    /**
     *
     * @return
     */
    public int getPanos() {
        return panos;
    }

    /**
     *
     * @return
     */
    public int getViimeToiminto() {
        return viimeToiminto;
    }

    /**
     *
     */
    public void tulostaTiedot() {
        System.out.print(nimi + ": ");
        System.out.println(kasi.luetteleKortit());
        System.out.println("Rahaa: " + rahaa);
    }

    /**
     *
     */
    public void havia() {
        int uusipanos = panos;
        panos = 0;
        laitaPanos(uusipanos);
    }
}
