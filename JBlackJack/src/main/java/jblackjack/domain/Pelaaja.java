package jblackjack.logiikka;

public class Pelaaja {

    public String nimi;
    public KorttiKasi kasi;
    public int rahaa;
    public int panos;

    public Pelaaja(String nimi, int rahaa) {
        this.nimi = nimi;
        this.rahaa = rahaa;
        kasi = new KorttiKasi();
        panos = 0;
    }

    public void laitaPanos(int panostus) {
        if (panostus < 5) {
            System.out.println("panos ei voi olla alle 5");
        }
        else if(panostus <= rahaa) {
            rahaa -= panostus;
            this.panos = panostus;
        } else {
            System.out.println("ei rahaa");
        }
    }

    public int getPanos() {
        return panos;
    }

    public void tulostaTiedot() {
        System.out.print(nimi + ": ");
        kasi.luetteleKortit();
        System.out.println("Rahaa: " + rahaa);
    }
}
