package app;

import java.util.ArrayList;

public class Joukkue {
    private String nimi;
    private ArrayList<Pelaaja> pelaajat;
    private int maksimikoko = 16;

    public Joukkue(String nimi) {
        this.nimi = nimi;
        this.pelaajat = new ArrayList<>();
    }

    public void lisaaPelaaja(Pelaaja pelaaja) {
        if(this.koko() != this.maksimikoko) {
            this.pelaajat.add(pelaaja);
        }
    }

    public void asetaMaksimikoko(int maksimikoko) {
        this.maksimikoko = maksimikoko;
    }

    public int koko() {
        return this.pelaajat.size();
    }

    public String haeNimi() {
        return this.nimi;
    }

    public int maalit() {
        return this.pelaajat.stream().mapToInt(Pelaaja::maalit).sum();
    }

    public void tulostaPelaajat() {
        this.pelaajat.forEach(pelaaja -> System.out.println(pelaaja));
    }
}
