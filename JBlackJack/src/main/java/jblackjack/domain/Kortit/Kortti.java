/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jblackjack.domain.Kortit;

import java.util.Objects;

/**
 * 
 * @author pyjopy
 */
public class Kortti {

    private final Maa maa;
    private final int arvo;

    /**
     *
     * @param arvo
     * @param maa
     */
    public Kortti(int arvo, Maa maa) {
        this.maa = maa;
        this.arvo = arvo;
    }


    public int getArvo() {
        return arvo;
    }

    public Maa getMaa() {
        return maa;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return maa + " " + arvo;
    }

    /**
     * generoitu metodi
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.maa);
        hash = 53 * hash + this.arvo;
        return hash;
    }

    /**
     * Palauttaa true jos korttien maa ja arvo ovat samat.
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (!(obj instanceof Kortti)) return false;

        Kortti vertailtava = (Kortti) obj;
        return vertailtava.arvo == this.arvo && vertailtava.maa == this.maa;

    }

}
