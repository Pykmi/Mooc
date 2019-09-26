package app;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Kirja> kirjat = new ArrayList<>();
        Scanner lukija = new Scanner(System.in);

        while(true) {
            System.out.print("Nimi: ");
            String nimi = lukija.nextLine();

            if(nimi.length() < 1) {
                break;
            }

            System.out.print("Sivuja: ");
            int pituus = Integer.parseInt(lukija.nextLine());

            System.out.print("Kirjoitusvuosi: ");
            int vuosi = Integer.parseInt(lukija.nextLine());

            kirjat.add(new Kirja(vuosi, nimi, pituus));
        }

        System.out.print("\n");
        System.out.print("Mitä tulostetaan: ");
        String filter = lukija.nextLine();

        kirjat.forEach((kirja) -> {
            if(filter.equals("nimi")) {
                System.out.println(kirja.getNimi());
            } else {
                System.out.println(kirja.toString());
            }
        });
        
        lukija.close();
    }
}