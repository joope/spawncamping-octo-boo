/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jblackjack.kayttoliittyma;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
/**
 *
 * @author pyjopy
 */
public class Valikko extends JPanel{
    
    public Valikko(){
       super(new GridLayout(1, 3));
       luoKomponentit();
    }
    
    public void luoKomponentit(){
        JButton hit = new JButton("Hit");
        hit.addActionListener(new HitNapinKuuntelija());
        add(hit);
        JButton stand = new JButton("Stand");
        add(stand);
        JButton tuplaa = new JButton("Double");
        add(tuplaa);
    }
}
