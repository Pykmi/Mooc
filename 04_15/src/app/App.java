package app;

public class App {
    public static void main(String[] args) {
        Joukkue tapiiri = new Joukkue("FC Tapiiri");
        System.out.println("Joukkue: " + tapiiri.haeNimi());
        //tapiiri.asetaMaksimikoko(1);

        System.out.println("");

        Pelaaja matti = new Pelaaja("Matti");
        Pelaaja pekka = new Pelaaja("Pekka", 39);

        tapiiri.lisaaPelaaja(matti);
        tapiiri.lisaaPelaaja(pekka);
        tapiiri.lisaaPelaaja(new Pelaaja("Mikael", 1)); //vaikutus on sama kuin edellisillä

        tapiiri.tulostaPelaajat();

        System.out.println("");

        System.out.println("Pelaajia yhteensä: " + tapiiri.koko());

        System.out.println("");

        System.out.println("Maaleja yhteensä: " + tapiiri.maalit());
    }
}