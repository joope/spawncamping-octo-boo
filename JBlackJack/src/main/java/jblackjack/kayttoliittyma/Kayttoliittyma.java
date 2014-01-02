
package jblackjack.kayttoliittyma;

import java.awt.*;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;

    public Kayttoliittyma() {
        
    }

    @Override
    public void run() {
        frame = new JFrame("JBlackJack");
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setBackground(Color.green);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        container.add(new Ylapalkki());
        container.add(new JakajanKasi());
        container.add(new PelaajanKasi());
        container.add(new Valikko());
    }
    

    public JFrame getFrame() {
        return frame;
    }
}
