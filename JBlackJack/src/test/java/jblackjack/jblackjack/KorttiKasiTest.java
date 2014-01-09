

package jblackjack.jblackjack;

import jblackjack.domain.Kortit.Kortti;
import jblackjack.domain.Kortit.KorttiKasi;
import jblackjack.domain.Kortit.Maa;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert.*;
import static org.junit.Assert.assertEquals;


public class KorttiKasiTest {
    KorttiKasi kasi;
    
    public KorttiKasiTest() {
    }
    
    @Before
    public void setUp() {
        kasi = new KorttiKasi();
    }
    
    @Test
    public void laskeKadenArvoLaskeeOikein(){
        kasi.laskeKortinArvoJaLisaaSeKadenArvoon(new Kortti(7, Maa.HERTTA));
        kasi.laskeKortinArvoJaLisaaSeKadenArvoon(new Kortti(2, Maa.RISTI));
        kasi.laskeKortinArvoJaLisaaSeKadenArvoon(new Kortti(13, Maa.PATA));
        assertEquals(19, kasi.laskeKadenArvo());
    }
    
    @Test
    public void laskeKadenArvoOikein(){
        kasi.laskeKortinArvoJaLisaaSeKadenArvoon(new Kortti(10, Maa.HERTTA));
        kasi.laskeKortinArvoJaLisaaSeKadenArvoon(new Kortti(1, Maa.RISTI));
        assertEquals(21, kasi.laskeKadenArvo());
    }


}
