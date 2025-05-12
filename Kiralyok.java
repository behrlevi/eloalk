import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Kiralyok {

    private static ArrayList<String> nev_klista = new ArrayList<String>();
    private static ArrayList<String> szul_klista = new ArrayList<String>();
    private static ArrayList<String> hal_klista = new ArrayList<String>();
    private static ArrayList<String> haz_klista = new ArrayList<String>();
    public static void main(String[] args) {
        beolv("kiralyok.txt");

        // 1.feladat
        System.out.println("\n"+"1. Feladat"+"\n");
        int legidosebb = 0;
        int nev = 0;
        for (int i = 0; i < nev_klista.size(); i++) {
            if (eletkor(i) > legidosebb) {
                legidosebb = eletkor(i);
                nev = i;
            }
        }
        String uralkodo = nev_klista.get(nev);
        uralkodo = uralkodo.replaceAll(".*\\[(.*?)\\].*", "$1"); // Levágom a szögletes zárójeleket.
        System.out.println(uralkodo+" ("+legidosebb+")");

        // 2.feladat
        System.out.println("\n"+"2. Feladat"+"\n");
        int arph = 0;
        for (int i = 0; i < nev_klista.size(); i++) {
            if (haz_klista.get(i).equals("[Arpad-haz]")) {
                arph++;
            }
        }
        System.out.println("Árpád-házi királyok szama: "+arph);

        // 3.feladat
        System.out.println("\n"+"3. Feladat"+"\n");
        boolean elso = true;
        boolean talalat = false;
        ArrayList<String> hazak = new ArrayList<>();
        if (elso == true) {
            hazak.add(haz_klista.get(0)); // Beíratom az első ház nevét.
            elso = false;
        }
        for (int i = 0; i < haz_klista.size(); i++) {
            for (int n = 0; n < hazak.size(); n++) {
                if (haz_klista.get(i).equals(hazak.get(n))) {
                    talalat = true;
                    break;
                }
                else {
                    talalat = false;
                }
            }
            if (talalat == false) {
                hazak.add(haz_klista.get(i));
            }
            else {
                talalat = false;
            }
        }
        //hazak.add(haz_klista.get(i));
        hazak.forEach(item -> System.out.println(item.replaceAll(".*\\[(.*?)\\].*", "$1"))); //Egy tömörebb megoldás mint a for loop.
        
        // 4.feladat
        System.out.println("\n"+"4. Feladat"+"\n");
        // Kulcs-érték párokban tárolom a házak neveit és az őket képviselő uralkodók számát.
        HashMap<String, Integer> kepviselet = new HashMap<>();
        int fo = 0;
        for (int i = 0; i < hazak.size(); i++) {
            for (int n = 0; n < haz_klista.size(); n++) {
                if (hazak.get(i).equals(haz_klista.get(n))) {
                    fo++;
                }
            }
            kepviselet.put(hazak.get(i),fo);
            fo = 0;
        }
        kepviselet.forEach((kulcs,ertek) -> System.out.println(kulcs.replaceAll(".*\\[(.*?)\\].*", "$1") + "    " + ertek+" fő"));
    }
    
    private static void beolv(String fajl) {
        try {
            BufferedReader puffer = new BufferedReader(new FileReader(fajl));
            String sor;
            while ((sor = puffer.readLine()) != null) { //Addig olvas amíg nem ér a fájl végére.
                String[] ertek = sor.split(",");
                /*
                Eleget téve a feladat kiírásának használom a toString()-et.
                Ezáltal az elemek köré szögletes zárójel kerül, amit le kell vágni a kimenetekből, bele kell foglalni az ellenőrzésekbe, stb.
                Ez a felesleges komplexitás elkerülhető lenne a toString() használatának mellőzésével.
                */
                nev_klista.add(Arrays.toString(new String[]{ertek[0]}));
                szul_klista.add(ertek[1]);
                hal_klista.add(ertek[2]);
                haz_klista.add(Arrays.toString(new String[]{ertek[3]}));

            }
            puffer.close();
        }
    /*
    Kezeli a FileNotFoundException és IOException kivételeket.
    Azt nem értettem meg, hogy ezeket miért kapom, ha egyébként ki tudom olvasni a tartalmat.
    Valószínűleg a .close()-hoz lehet köze.
    */
        catch (Exception e) {
        }
        //System.out.println(szul_klista);
    }
    private static int eletkor(Integer azon) {
        int szulev = Integer.parseInt(szul_klista.get(azon));
        int halev = Integer.parseInt(hal_klista.get(azon));
        int kor = halev - szulev;
        return kor;
    }
    }