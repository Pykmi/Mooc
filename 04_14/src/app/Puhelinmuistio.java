package app;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        List<Henkilo> matchingPerson = this.henkilot.stream()
                .filter(match -> match.haeNimi().equals(nimi))
                .collect(Collectors.toList());

        if(matchingPerson.size() < 1) {
            return "numero ei tiedossa";
        }
        return matchingPerson.get(0).toString();
    }
}