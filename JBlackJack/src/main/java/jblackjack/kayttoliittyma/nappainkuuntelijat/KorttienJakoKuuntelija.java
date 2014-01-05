/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jblackjack.kayttoliittyma.nappainkuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import jblackjack.logiikka.PelinPaivitys;

/**
 *
 * @author pyjopy
 */
public class KorttienJakoKuuntelija implements ActionListener {
    PelinPaivitys peli;
    public KorttienJakoKuuntelija(PelinPaivitys peli) {
        this.peli = peli;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        peli.jaaKortit();
    }
    
}
