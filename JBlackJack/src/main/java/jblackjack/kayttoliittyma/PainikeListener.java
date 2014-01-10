/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jblackjack.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import jblackjack.domain.Pelilogiikka;

/**
 *
 * @author pyjopy Luokka huolehtii käyttöliittymän painikkeiden käynnistämistä
 * komennoista
 */
public class PainikeListener implements ActionListener {

    private Kayttoliittyma gui;
    private Pelilogiikka peli;

    public PainikeListener(Kayttoliittyma gui, Pelilogiikka peli) {
        this.gui = gui;
        this.peli = peli;
    }
    
    /**
     * Kustuu pelilogiikan metodia painikkeen nimen perusteella
     * @param ae 
     */

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == gui.uusiJako) {
            uusiJako();
        } else if (ae.getSource() == gui.lisaaPanoksenMaaraa) {
            lisaaPanoksia(5);
        } else if (ae.getSource() == gui.vahennaPanoksenMaaraa) {
            lisaaPanoksia(-5);
        }
        else if (!peli.getStatus().equals("")) {     //kierroksen loputtua vain uusiJako toimii 
            return;
        } else if (ae.getSource() == gui.lyoKortti) {
            lyoKortti();
        } else if (ae.getSource() == gui.jaaTahan) {
            jaaTahan();
        } else if (ae.getSource() == gui.doubleDown) {
            doubleDown();
        }

        gui.paivita();

    }

    private void uusiJako() {
        peli.aloitaUusiKierros();
    }

    private void lyoKortti() {
        peli.pyydaUusiKortti();
    }

    private void jaaTahan() {
        peli.pysyKorteissa();
    }

    private void doubleDown() {
        peli.doubleDown();
    }

    private void split() {

    }

    private void lisaaPanoksia(int maara) {
        peli.lisaaPanoksia(maara);
    }

}
