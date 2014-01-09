/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jblackjack.domain.Kortit;

import jblackjack.domain.Kortit.Kortti;
import jblackjack.domain.Kortit.KorttiKokoelma;
import jblackjack.domain.Kortit.Maa;
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
    
    @Test
    public void luetteleKorttejaPalauttaaEiKorttejaJosTyhja(){
        assertEquals("Ei kortteja!", kokoelma.luetteleKortit());
    }
    
    @Test
    public void luetteleKortitJosKorttejaLisatty(){
        kokoelma.lisaaKortti(new Kortti(5, Maa.HERTTA));
        kokoelma.lisaaKortti(new Kortti(10, Maa.RUUTU));
        assertEquals("HERTTA 5, RUUTU 10, ", kokoelma.luetteleKortit());
    }
    
    
}
