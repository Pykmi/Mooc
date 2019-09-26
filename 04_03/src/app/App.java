package app;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // luodaan tyhjä lista johon myöhemmin tallennetaan käyttäjän ohjelmat
        ArrayList<Ohjelma> ohjelmat = new ArrayList<>();

        // luodaan käyttäjän syötteen lukija
        Scanner lukija = new Scanner(System.in);
        
        while(true) {
            // kysy käyttäjältä ohjelman nimi
            System.out.print("Nimi: ");
            String nimi = lukija.nextLine();

            // jos käyttäjä antaa ohjelman nimeksi tyhjän arvon, looppi katkaistaan
            if(nimi.length() < 1) {
                break;
            }
            
            // kysy käyttäjältä ohjelman pituus
            System.out.print("Pituus: ");
            int pituus = Integer.parseInt(lukija.nextLine());

            // tallenna uusi ohjelma listaan
            ohjelmat.add(new Ohjelma(nimi, pituus));
        }

        // kysy käyttäjältä ohjelman maksimipituus
        System.out.print("\n");
        System.out.print("Ohjelman maksimipituus: ");
        int maxPituus = Integer.parseInt(lukija.nextLine());

        // käy kaikki tv ohjelmat läpi ja tulosta ne jotka ovat yhtäpitkiä tai lyhyempi kestoisia kuin annettu maxPituus
        ohjelmat.forEach((ohjelma) -> {
            if(ohjelma.getPituus() <= maxPituus) {
                System.out.println(ohjelma.toString());
            }
        });

        // sulje lukija
        lukija.close();
    }
}