package app;

public class Maksukortti {
    private double saldo;

    public Maksukortti(double saldo) {
      this.saldo = saldo;
    }

    public double saldo() {
        return this.saldo;
    }

    public void lataaRahaa(double lisays) {
        this.saldo += lisays;
    }

    public boolean otaRahaa(double maara) {
        if(this.saldo >= maara) {
            this.saldo -= maara;
            return true;
        }

        return false;
    }
}