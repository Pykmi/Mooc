package app;

class Kello {
    private YlhaaltaRajoitettuLaskuri tunnit;
    private YlhaaltaRajoitettuLaskuri minuutit;
    private YlhaaltaRajoitettuLaskuri sekunnit;

    public Kello(int tunnitAlussa, int minuutitAlussa, int sekunnitAlussa) {
      // laskurit tunneille, minuuteille ja sekunneille;
      this.tunnit = new YlhaaltaRajoitettuLaskuri(23);
      this.minuutit = new YlhaaltaRajoitettuLaskuri(59);
      this.sekunnit = new YlhaaltaRajoitettuLaskuri(59);

      this.tunnit.asetaArvo(tunnitAlussa);
      this.minuutit.asetaArvo(minuutitAlussa);
      this.sekunnit.asetaArvo(sekunnitAlussa);
    }

    public void etene() {
      // kello etenee sekunnilla
      this.sekunnit.seuraava();

      if(this.sekunnit.arvo() < 1) {
        this.minuutit.seuraava();

        if(this.minuutit.arvo() < 1) {
          this.tunnit.seuraava();
        }
      }
    }

    public String toString() {
        // palauttaa kellon merkkijonoesityksen
        return this.tunnit.toString() + ":" + this.minuutit.toString() + ":" + this.sekunnit.toString();
    }
}