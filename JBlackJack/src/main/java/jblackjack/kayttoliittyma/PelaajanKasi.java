
package jblackjack.kayttoliittyma;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PelaajanKasi extends JPanel{
    public PelaajanKasi(){
        super();
        luokomponentit();
    }

    private void luokomponentit() {
        add(new JLabel("Pelaajan käsi: "));
    }
}
