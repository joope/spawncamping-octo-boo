/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jblackjack.domain.Kortit;

import jblackjack.domain.Kortit.Maa;
import jblackjack.domain.Kortit.Kortti;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pyjopy
 */
public class KorttiTest {
    Kortti kortti;
    
    public KorttiTest() {
    }

    @Before
    public void setUp() {
        kortti = new Kortti(3, Maa.PATA);
    }

    @Test
    public void konstruktoriAsettaaKortinMaanOikein(){
        assertEquals(Maa.PATA, kortti.getMaa());
    }
    
    @Test
    public void konstruktoriAsettaaKortinArvonOikein(){
        assertEquals(3, kortti.getArvo());
    }
    
    @Test
    public void kortinToStringTulostuuOikein(){
        assertEquals("PATA 3", kortti.toString());
    }
}
