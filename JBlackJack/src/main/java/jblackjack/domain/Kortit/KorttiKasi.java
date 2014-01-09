package jblackjack.domain.Kortit;

/**
 *
 * @author pyjopy
 */
public class KorttiKasi extends KorttiKokoelma {

    int kadenArvo;
    
    public KorttiKasi() {
        super();
        kadenArvo = 0;
    }
    
    @Override
    public String luetteleKortit(){
        String kortits = "";
        if(kortit.isEmpty()){
            return "";
        }
        for (Kortti kortti : kortit) {
            kortits += kortti + ". ";
        }
        kortits += "Käden arvo: " + kadenArvo;
        return kortits;
    }

    /**
     * Tyhjentää käden korteista.
     */
    public void tyhjennaKasi() {
        kortit.clear();
        kadenArvo = 0;
    }

    /**
     *Ottaa kortin pakasta ja lisää sen käteen.
     * 
     * @param pakka
     */
    public void nostaKortti(Korttipakka pakka) {
        Kortti lisattava = pakka.nostaKortti();
        kortit.add(lisattava);
        laskeKortinArvoJaLisaaSeKadenArvoon(lisattava);
    }
    
    /** Laskee kateen lisattavan kortin arvon ja lisää sen kadenArvo-muuttujaan.
     * Jos lisättävä ässä, niin sen arvo on 11 vain jos käden arvo ei ylitä 21
     * Jos lisättävän arvo alle kymmenen, se lisätään suoraan käden arvoon,
     * Jos taas lisättävän arvo yli kymmenen niin arvoon lisätään kymmenen.
     * @param lisattava     
     */
    
    public void laskeKortinArvoJaLisaaSeKadenArvoon(Kortti lisattava){
        if (lisattava.getArvo() == 1 && kadenArvo + 11 <= 21) {
            kadenArvo += 11;
        } else if(lisattava.getArvo() < 10){
            kadenArvo += lisattava.getArvo();
        } else{
            kadenArvo += 10;
        }
    }

    /**
     *
     * Palauttaa käden arvon.
     * @return
     */
    public int laskeKadenArvo() {
        return kadenArvo;
    }
}
