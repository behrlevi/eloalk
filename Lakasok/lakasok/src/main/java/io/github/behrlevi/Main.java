package io.github.behrlevi;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;

import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // Az egyes paramétereket listákba gyűjtöttem ki.
    private static ArrayList<Integer> keruletek = new ArrayList<Integer>();
    private static ArrayList<Integer> teruletek = new ArrayList<Integer>();
    private static ArrayList<Integer> szobak = new ArrayList<Integer>();
    private static ArrayList<Integer> emeletek = new ArrayList<Integer>();
    private static ArrayList<Integer> arak = new ArrayList<Integer>();
    private static ArrayList<String> allapotok = new ArrayList<String>();
    public static void main(String[] args) {
        try {
            Gson gson = new Gson();
            //Reader beolv = new FileReader("hasznalt.json");
            Reader beolv = new InputStreamReader(Main.class.getResourceAsStream("/hasznalt.json"));

            // A beolvasott Json adatok deszerializálása a LakasLista osztály példányába.
            LakasLista lista = gson.fromJson(beolv, LakasLista.class);
            
            // A kimenet szétválogatása a megfelelő listákba.
            for (Lakasok lakas : lista.getLakasok()) {
                keruletek.add(lakas.getKerulet());
                teruletek.add(lakas.getTerulet());
                szobak.add(lakas.getSzobak_szama());
                emeletek.add(lakas.getEmelet());
                arak.add(lakas.getAr());
                allapotok.add(lakas.getAllapot());
            }
            beolv.close();
        
        } catch (IOException e) {
        }

        // 1. Feladat
        System.out.println("\n1. Feladat");
        int legar = 0;
        int sor = 0;
        for (int i = 0; i < arak.size(); i++) {
            if (arak.get(i) > legar) {
                legar = arak.get(i);
                sor = i;
            }
        }
        System.out.println(legar + " ("+keruletek.get(sor) + ". kerület)");
        
        // 2. Feladat
        System.out.println("\n2. Feladat");
        HashMap<Integer, Integer> kerdb = new HashMap<>();
        for (int i = 0; i < keruletek.size(); i++) {
            int ker = keruletek.get(i);
            if (kerdb.containsKey(ker)) {
                kerdb.put(ker,kerdb.get(ker) + 1);
            }
            else {
                kerdb.put(ker, 1);
            }
        }
        kerdb.forEach((kulcs, ertek) -> System.out.println(kulcs+". kerület: " + ertek));

        // 3. Feladat
        System.out.println("\n3. Feladat");
        int osszes = 0;
        for (int i = 0; i < teruletek.size(); i++) {
            osszes = osszes + teruletek.get(i);
        }
        int atlag = osszes / teruletek.size();
        System.out.println("Átlagos terület: " + atlag + " m2");

        // 4. Feladat
        System.out.println("\n4. Feladat");
        int hatosszeg = 0;
        for (int i = 0; i < keruletek.size(); i++) {
            if (keruletek.get(i).equals(6)) {
                hatosszeg = hatosszeg + teruletek.get(i);
            }
        }
        int hatatlag = hatosszeg / kerdb.get(6);
        System.out.println("Átlagos terület a 6. kerületben: " + hatatlag + " m2");
        }
    }