

package jblackjack.jblackjack;

import jblackjack.domain.Kortit.Korttipakka;
import java.util.ArrayList;
import java.util.Arrays;
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
public class KorttipakkaTest {
    Korttipakka pakka;
    
    public KorttipakkaTest() {
    }
    
    @Before
    public void setUp() {
        pakka = new Korttipakka();
    }

    @Test
    public void uudessaKorttipakassaKaikkiKortit(){
        assertEquals(52, pakka.kortit.size());
    }
    @Test
    public void korttipakastaNostettaessaKorttienMaaraVaheneeYhdella(){
        pakka.nostaKortti();
        assertEquals(51, pakka.kortit.size());
    }
    @Test
    public void korttipakastaNostettaessaKaksiKorttienMaaraVaheneeKahdella(){
        pakka.nostaKortti();
        pakka.nostaKortti();
        assertEquals(50, pakka.kortit.size());
    }
    /*@Test
    public void korttipakanSekoitusToimiiOikein(){
        ArrayList<Kortti> pakkaEnnenSekoitusta = pakka.pakka;
        pakka.sekoitaPakka();
        boolean sekoitettu = false;
        for (int i = 0; i < 52; i++) {
            if (pakkaEnnenSekoitusta.get(i) != pakka.pakka.get(i)){
                sekoitettu = true;
            }
        }
        assertTrue(sekoitettu);
    }
    */
        
}
