package jblackjack.jblackjack;
import jblackjack.logiikka.*;

public class Main 
{
    public static void main( String[] args )
    {
        Korttipakka pakka = new Korttipakka();
        pakka.sekoitaPakka();
        System.out.println(pakka.nostaKortti());
        pakka.sekoitaPakka();
        System.out.println(pakka.nostaKortti());
    }
}
