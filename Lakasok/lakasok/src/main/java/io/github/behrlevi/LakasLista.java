/*
    A LakasLista osztály tárolja a teljes adatállományt.
 */

package io.github.behrlevi;

import java.util.List;

public class LakasLista {
    //Létrehoz egy listát a Lakasok osztály példányait tárolására.
    private List<Lakasok> lakasok;
    // A getter visszaadja az összes lakást.
    public List<Lakasok> getLakasok() { return lakasok; }
}