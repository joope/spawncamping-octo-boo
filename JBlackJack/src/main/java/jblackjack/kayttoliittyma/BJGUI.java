/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jblackjack.kayttoliittyma;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author pyjopy
 */
public class BJGUI extends JPanel{
  JPanel topPanel = new JPanel();
  JPanel dcardPanel = new JPanel();
  JPanel pcardPanel = new JPanel();
  JTextPane winlosebox = new JTextPane();
  JButton hitbutton = new JButton();
  JButton dealbutton = new JButton();
  JButton staybutton = new JButton();
  JButton playagainbutton = new JButton();
  JLabel dealerlabel = new JLabel();
  JLabel playerlabel = new JLabel();

  public BJGUI () 
  {
    
    topPanel.setBackground(new Color(0, 122, 0));
    dcardPanel.setBackground(new Color(0, 122, 0));
    pcardPanel.setBackground(new Color(0, 122, 0));
    
    topPanel.setLayout(new FlowLayout());
    winlosebox.setText(" ");
    winlosebox.setFont(new java.awt.Font("Helvetica Bold", 1, 20));
    dealbutton.setText("  Deal");
    //dealbutton.addActionListener(new dealbutton());
    hitbutton.setText("  Hit");
    //hitbutton.addActionListener(new hitbutton());
    hitbutton.setEnabled(false);
    staybutton.setText("  Stay");
    //staybutton.addActionListener(new staybutton());   
    staybutton.setEnabled(false);
    playagainbutton.setText("  Play Again");
    //playagainbutton.addActionListener(new playagainbutton());
    playagainbutton.setEnabled(false); 
    
    dealerlabel.setText("  Dealer:  ");
    playerlabel.setText("  Player:  ");

    topPanel.add(winlosebox);
    topPanel.add(dealbutton);
    topPanel.add(hitbutton);
    topPanel.add(staybutton);
    topPanel.add(playagainbutton);
    pcardPanel.add(playerlabel);
    dcardPanel.add(dealerlabel);
    
    setLayout(new BorderLayout());
    add(topPanel,BorderLayout.NORTH);
    add(dcardPanel,BorderLayout.CENTER);
    add(pcardPanel,BorderLayout.SOUTH);
    
  }//to hold the dealer's cards
  //Hand player = new Hand();    //to hold the player's cards
  //Blackjack game = new Blackjack(dealer,player); 
}
