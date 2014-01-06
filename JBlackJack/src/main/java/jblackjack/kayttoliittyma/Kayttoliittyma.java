package jblackjack.kayttoliittyma;

import java.awt.*;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import jblackjack.domain.Pelilogiikka;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    public Pelilogiikka peli;    
    private PainikeListener nappainKuuntelija;
    
    public JButton uusiJako;
    public JButton lyoKortti;
    public JButton jaaTahan;
    public JButton doubleDown;
    public JButton lisaaPanoksenMaaraa;
    public JButton vahennaPanoksenMaaraa;
    
    private JLabel rahaaJaljella;
    private JLabel nykyinenPanos;
    private JLabel jakajankasi;
    private JLabel pelaajankasi;
    private JLabel voittoStatus;
    

    public Kayttoliittyma(Pelilogiikka peli) {
        this.peli = peli;
        this.nappainKuuntelija = new PainikeListener(this, peli);
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
        
        container.add(luoInfopalkki());
        jakajankasi = new JLabel("Jakajankäsi");
        pelaajankasi = new JLabel("Pelaajan käsi");
        container.add(jakajankasi);
        container.add(new JLabel(" "));
        container.add(pelaajankasi);
        container.add(luoPeliValikko());
    }

    public void paivita() {
        rahaaJaljella.setText("Rahaa: " + peli.pelaaja.rahaa);
        nykyinenPanos.setText("Panos: " + peli.pelaaja.panos);
        jakajankasi.setText(peli.jakaja.luetteleKortit());
        pelaajankasi.setText(peli.pelaaja.kasi.luetteleKortit());
        voittoStatus.setText(peli.getStatus());
        
        if(!peli.getStatus().equals("")){
            lyoKortti.setEnabled(false);
            jaaTahan.setEnabled(false);
            doubleDown.setEnabled(false);
            lisaaPanoksenMaaraa.setEnabled(true);
            vahennaPanoksenMaaraa.setEnabled(true);
        } else{
            lyoKortti.setEnabled(true);
            jaaTahan.setEnabled(true);
            doubleDown.setEnabled(true);
            lisaaPanoksenMaaraa.setEnabled(false);
            vahennaPanoksenMaaraa.setEnabled(false);
        } 
    }

    public JFrame getFrame() {
        return frame;
    }

    private JPanel luoInfopalkki() {
        JPanel palkki = new JPanel();
        //palkki.setLayout(new BorderLayout());
        
        rahaaJaljella = new JLabel("Rahaa jaljella");
        palkki.add(rahaaJaljella);
        nykyinenPanos = new JLabel("Panoksesi");
        palkki.add(nykyinenPanos);
        
        lisaaPanoksenMaaraa = new JButton("Lisää");
        lisaaPanoksenMaaraa.addActionListener(nappainKuuntelija);
        palkki.add(lisaaPanoksenMaaraa);
        
        vahennaPanoksenMaaraa = new JButton("Vähennä");
        vahennaPanoksenMaaraa.addActionListener(nappainKuuntelija);
        palkki.add(vahennaPanoksenMaaraa);
        
        voittoStatus = new JLabel("");
        palkki.add(voittoStatus);
        
        return palkki;
    }
    
    private JPanel luoPeliValikko(){
        JPanel peliValikko = new JPanel();
        peliValikko.setLayout(new GridLayout(1,4));
        
        jaaTahan = new JButton("Stay");
        jaaTahan.addActionListener(nappainKuuntelija);
        peliValikko.add(jaaTahan);
        
        lyoKortti = new JButton("Hit");
        lyoKortti.addActionListener(nappainKuuntelija);
        peliValikko.add(lyoKortti);
        
        uusiJako = new JButton("Uusi jako");
        uusiJako.addActionListener(nappainKuuntelija);
        peliValikko.add(uusiJako);
        
        doubleDown = new JButton("DoubleDown");
        doubleDown.addActionListener(nappainKuuntelija);
        peliValikko.add(doubleDown);
        
        return peliValikko;
    }
}
