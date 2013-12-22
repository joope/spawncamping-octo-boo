package jblackjack.logiikka;

public class KorttiKasi extends KorttiKokoelma {

    public KorttiKasi() {
        super();
    }

    public int laskeKadenArvo() {
        int arvo = 0;
        if (kortit.isEmpty()) {
            return 0;
        } else {
            for (Kortti kortti : kortit) {
                if (kortti.getArvo() < 10) {
                    arvo += kortti.getArvo();
                } else {
                    arvo += 10;
                }
            }
        }
        return arvo;
    }
}
