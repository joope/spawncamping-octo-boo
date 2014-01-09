/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jblackjack.domain;

import jblackjack.domain.Pelaaja;
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
public class PelaajaTest {
    public Pelaaja pelaaja;
    
    public PelaajaTest() {
    }

    @Before
    public void setUp() {
        pelaaja = new Pelaaja("Jaakko", 200);
    }


    @Test
    public void konstruktoriLuoPelaajanNimenOiken(){
        assertEquals("Jaakko", pelaaja.nimi);
    }
    
    @Test
    public void konstruktoriLuoPelaajanVarallisuudenOiken(){
        assertEquals(200, pelaaja.rahaa);
    }
}
