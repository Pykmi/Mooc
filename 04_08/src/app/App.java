package app;

public class App {
    public static void main(String[] args) throws Exception {
        Kasvatuslaitos haaganNeuvola = new Kasvatuslaitos();

        Henkilo eero = new Henkilo("Eero", 1, 110, 7);
        Henkilo pekka = new Henkilo("Pekka", 33, 176, 85);

        System.out.println("punnituksia tehty " + haaganNeuvola.punnitukset());

        System.out.println("");

        System.out.println(eero.getNimi() + " paino: " + haaganNeuvola.punnitse(eero) + " kiloa");
        System.out.println(pekka.getNimi() + " paino: " + haaganNeuvola.punnitse(pekka) + " kiloa");

        System.out.println("");
        System.out.println("punnituksia tehty " + haaganNeuvola.punnitukset());

        haaganNeuvola.syota(eero);
        haaganNeuvola.syota(eero);
        haaganNeuvola.syota(eero);

        System.out.println("");

        System.out.println(eero.getNimi() + " paino: " + haaganNeuvola.punnitse(eero) + " kiloa");
        System.out.println(pekka.getNimi() + " paino: " + haaganNeuvola.punnitse(pekka) + " kiloa");

        System.out.println("");
        System.out.println("punnituksia tehty " + haaganNeuvola.punnitukset());
    }
}