
package jblackjack.kayttoliittyma;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class JakajanKasi extends JPanel{
    public JakajanKasi(){
        super();
        luokomponentit();
    }

    private void luokomponentit() {
        add(new JLabel("Jakajan käsi: "));
    }
}
