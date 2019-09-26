
public class Pistetilanne {

    private int vasenPelaajaPisteet;
    private int oikeaPelaajaPisteet;

    public Pistetilanne(int vasenPelaajaPisteet, int oikeaPelaajaPisteet) {
        this.vasenPelaajaPisteet = vasenPelaajaPisteet;
        this.oikeaPelaajaPisteet = oikeaPelaajaPisteet;
    }

    @Override
    public String toString() {
        return this.vasenPelaajaPisteet + " : " + this.oikeaPelaajaPisteet;
    }
}
