/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jblackjack.domain;

import jblackjack.domain.Kortit.Korttipakka;
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
    public Korttipakka pakka;
    
    public PelaajaTest() {
    }

    @Before
    public void setUp() {
        pelaaja = new Pelaaja("Jaakko", 100);
        pakka = new Korttipakka();
    }


    @Test
    public void konstruktoriLuoPelaajanNimenOiken(){
        assertEquals("Jaakko", pelaaja.nimi);
    }
    
    @Test
    public void konstruktoriLuoPelaajanVarallisuudenOiken(){
        assertEquals(100, pelaaja.rahaa);
    }
    
    public void pelaajallaTyhjaKasiAlussa(){
        assertTrue(pelaaja.kasi.kortit.isEmpty());
    }
    
    @Test
    public void otaKorttiLisaaPelaajanKateenKortin(){
        pelaaja.otaKorttiKorttipakasta(pakka);
        assertEquals(1, pelaaja.kasi.kortit.size());
    }
    
    @Test
    public void otaKorttiKymmenenKertaaLisaaKymmenenKorttiaKateen(){
        for (int i = 0; i < 10; i++) {
            pelaaja.otaKorttiKorttipakasta(pakka);
        }
        assertEquals(10, pelaaja.kasi.kortit.size());
    }
    
    @Test
    public void voitaLisaaPelaajanRahoihinPanoksenMaaran(){
        pelaaja.laitaPanos(10);
        pelaaja.voita();
        assertEquals(100, pelaaja.rahaa);
    }
    
    @Test
    public void voitaAsettaaEdellisenPanoksenUudestaan(){
        pelaaja.laitaPanos(10);
        pelaaja.voita();
        assertEquals(10, pelaaja.getPanos());
    }
    
    @Test
    public void doubledownLisaaEdellisenPanoksenSuuruisenPanoksen(){
        pelaaja.laitaPanos(10);
        pelaaja.doubleDown();
        assertEquals(20, pelaaja.panos);
    }
    
    @Test
    public void luovutaNollaaPelaajanPanoksen(){
        pelaaja.laitaPanos(10);
        pelaaja.luovuta();
        assertEquals(0, pelaaja.panos);
    }
    
    @Test
    public void luovutaLisaaRahoihinPuoletPanoksesta(){
        pelaaja.laitaPanos(10);
        pelaaja.luovuta();
        assertEquals(95, pelaaja.rahaa);
    }
    
    @Test
    public void laitaPanosLisaaPanokseenAnnetunVerranJosPositiivinen(){
        pelaaja.laitaPanos(10);
        assertEquals(10, pelaaja.panos);
    }
    
    @Test
    public void laitaPanosOttaaPelaajanRahoistaAnnetunVerranJosPositiivinen(){
        pelaaja.laitaPanos(10);
        assertEquals(90, pelaaja.rahaa);
    }
    
    @Test
    public void laitaPanosLaittaaAnnetunVerranPelaajanRahoihinJosNegatiivinenJaEiYliNykyisenPanoksenSuuruinen(){
        pelaaja.laitaPanos(10);
        pelaaja.laitaPanos(-5);
        assertEquals(95, pelaaja.rahaa);
    }
    
    @Test
    public void getPanosPalauttaaPanoksenMaaran(){
        pelaaja.laitaPanos(5);
        assertEquals(5, pelaaja.getPanos());
    }
    
    @Test
    public void haviaNollaaPanoksen(){
        pelaaja.laitaPanos(5);
        pelaaja.havia();
        assertEquals(0, pelaaja.getPanos());
    }
}
