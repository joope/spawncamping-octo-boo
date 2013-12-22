/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jblackjack.logiikka;

import java.util.ArrayList;
import java.util.Scanner;


public class Pelaajat {
    public ArrayList<Pelaaja> pelaajat;
    public Scanner lukija;
    
    public Pelaajat(){
        pelaajat = new ArrayList<>();
        lukija = new Scanner(System.in);
    }
    
    public void lisaaPelaaja(Pelaaja pelaaja){
        pelaajat.add(pelaaja);
    }
    
    public void jaaKortit(Korttipakka pakka){
        if (pelaajat.isEmpty()){
            return;
        }
        for (Pelaaja pelaaja : pelaajat) {
            pelaaja.kasi.lisaaKortti(pakka.nostaKortti());
            pelaaja.kasi.lisaaKortti(pakka.nostaKortti());
        }
    }
    
    public void otaPanokset(){
        for (Pelaaja pelaaja : pelaajat) {
            pelaaja.tulostaTiedot();
            System.out.println("Anna panos: ");
            pelaaja.laitaPanos(lukija.nextInt());
        }
    }
    
    
    public void tulostaPelaajat(){
        for (Pelaaja pelaaja : pelaajat) {
            pelaaja.tulostaTiedot();
        }
    }
}
