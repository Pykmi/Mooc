package app;

import java.util.ArrayList;

class Puhelinmuistio {
    private ArrayList<Henkilo> henkilot;

    public Puhelinmuistio() {
        this.henkilot = new ArrayList<>();
    }

    public void lisaa(String nimi, String numero) {
        this.henkilot.add(new Henkilo(nimi, numero));
    }

    public void tulostaKaikki() {
        this.henkilot.forEach((henkilo) -> System.out.println(henkilo));
    }

    public String haeNumero(String nimi) {
        ArrayList<Henkilo> matchingPerson = (ArrayList<Henkilo>) this.henkilot.stream()
                .filter((match) -> match.haeNimi().equals(nimi));

        return matchingPerson.get(0);d
    }
}