/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jblackjack.domain;

import jblackjack.domain.Kortit.Korttipakka;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Pelaajat-luokka mahdollistaa monen pelaaja-olion pelaamisen samaan aikaan, 
 * mutta se ei ole nyt käytössä.
 */

public class Pelaajat {

    /**
     *
     */
    public ArrayList<Pelaaja> pelaajat;

    /**
     *
     */
    public Scanner lukija;
    
    /**
     *
     */
    public Pelaajat(){
        pelaajat = new ArrayList<>();
        lukija = new Scanner(System.in);
    }
    
    /**
     *
     * @param pelaaja
     */
    public void lisaaPelaaja(Pelaaja pelaaja){
        pelaajat.add(pelaaja);
    }
    
    /**
     *
     */
    public void tarkistaVoittajat(){
        for (Pelaaja pelaaja : pelaajat) {
            if(pelaaja.viimeToiminto != 4){
                System.out.println("Pelaaja " + pelaaja.nimi + "voitti " + pelaaja.panos * 2 + " euroa");
                pelaaja.voita();
                System.out.println("Saldosi on " + pelaaja.rahaa);
            }
        }
    }
    
    /**
     *
     * @param pakka
     */
    public void jaaKortit(Korttipakka pakka){
        if (pelaajat.isEmpty()){
            return;
        }
        for (Pelaaja pelaaja : pelaajat) {
            pelaaja.kasi.lisaaKortti(pakka.nostaKortti());
            pelaaja.kasi.lisaaKortti(pakka.nostaKortti());
        }
    }
    
    /**
     *
     */
    public void otaPanokset(){
        for (Pelaaja pelaaja : pelaajat) {
            pelaaja.tulostaTiedot();
            System.out.println("Anna panos: ");
            pelaaja.laitaPanos(lukija.nextInt());
        }
    }
    
    /**
     *
     */
    public void tulostaPelaajat(){
        for (Pelaaja pelaaja : pelaajat) {
            pelaaja.tulostaTiedot();
        }
    }

}
