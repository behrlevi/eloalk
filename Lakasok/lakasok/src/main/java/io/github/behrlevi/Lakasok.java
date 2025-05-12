/*
A Lakasok osztályt a LakasLista.java használja az adatok tárolása során.
Az osztály példányai a JSON fájlban található lakásokat reprezentálják.
A getterek segítségével íratom ki az egyes tulajdonságokat a Main.java-ban.
 */
package io.github.behrlevi;

public class Lakasok {
    private int kerulet;
    private int terulet;
    private int szobak_szama;
    private int emelet;
    private int ar;
    private String allapot;
    
    public int getKerulet() { return kerulet; }
    public int getTerulet() { return terulet; }
    public int getSzobak_szama() { return szobak_szama; }
    public int getEmelet() { return emelet; }
    public int getAr() { return ar; }
    public String getAllapot() { return allapot; }
    @Override
    public String toString() {
        return "Lakasok{" +
                "kerulet=" + kerulet +
                ", terulet=" + terulet +
                ", szobak_szama=" + szobak_szama +
                ", emelet=" + emelet +
                ", ar=" + ar +
                ", allapot='" + allapot + '\'' +
                '}';
    }
}