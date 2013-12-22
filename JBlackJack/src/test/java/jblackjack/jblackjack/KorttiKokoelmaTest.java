/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jblackjack.jblackjack;

import jblackjack.logiikka.Kortti;
import jblackjack.logiikka.KorttiKokoelma;
import jblackjack.logiikka.Maa;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pyjopy
 */
public class KorttiKokoelmaTest {
    public KorttiKokoelma kokoelma; 
    
    public KorttiKokoelmaTest() {
    }

    @Before
    public void setUp() {
        kokoelma = new KorttiKokoelma();
    }
    
    @Test
    public void luotuKokoelmaTyhja(){
        assertTrue(kokoelma.getKortit().isEmpty());
    }
    @Test
    public void kortinLisaaminenLisaaKortinKokoelmaan(){
        kokoelma.lisaaKortti(new Kortti(5, Maa.PATA));
        assertEquals("PATA 5", kokoelma.kortit.get(0).toString());
    }    
    
    @Test
    public void kortinPoistaminenPoistaaKortinKokoelmasta(){
        kokoelma.lisaaKortti(new Kortti(5, Maa.PATA));
        kokoelma.poistaKortti(new Kortti(5, Maa.PATA));
        assertEquals(0, kokoelma.kortit.size());
    }                   
    
    
}
