package app;

public class App {
    public static void main(String[] args) throws Exception {
        Henkilo pekka = new Henkilo("Pekka Mikkola", "040-123123");

        System.out.println(pekka.haeNimi());
        System.out.println(pekka.haeNumero());

        System.out.println(pekka);

        pekka.vaihdaNumeroa("050-333444");
        System.out.println(pekka);

        System.out.println("\n");

        Puhelinmuistio muistio = new Puhelinmuistio();

        muistio.lisaa("Pekka Mikkola", "040-123123");
        muistio.lisaa("Antti Laaksonen", "045-456123");
        muistio.lisaa("Juhana Laurinharju", "050-222333");

        muistio.tulostaKaikki();

        System.out.println("\n");

        
    }
}