package app;

public class Raha {

    private final int senttia;

    public Raha(int euroa, int senttia) {
        this.senttia = euroa * 100 + senttia;
    }

    public int eurot() {
      return this.senttia / 100;
    }

    public int sentit() {
        return this.senttia - this.eurot() * 100;
    }

    public int saldo() {
        return this.senttia;
    }

    public Raha plus(Raha lisattava) {
        int eurot = lisattava.eurot() + this.eurot();
        int sentit = lisattava.sentit() + this.sentit();

        return new Raha(eurot, sentit);
    }

    public boolean vahemman(Raha verrattava) {
        int nytSentit = this.eurot() * 100 + this.sentit();
        int lisaSentit = verrattava.eurot() * 100 + verrattava.sentit();

        if(nytSentit > lisaSentit) {
            return false;
        }

        return true;
    }

    public Raha miinus(Raha vahentaja) {
        if(vahentaja.saldo() > this.saldo()) {
            return new Raha(0, 0);
        }

        int eurot = (this.saldo() - vahentaja.saldo()) / 100;
        int sentit = (this.saldo() - vahentaja.saldo()) - eurot * 100;

        return new Raha(eurot, sentit);
    }

    public String toString() {
        int eurot = this.eurot();
        int sentit = this.sentit();

        String nolla = "";
        if (senttia <= 10) {
            nolla = "0";
        }

        return eurot + "." + nolla + sentit + "e";
    }
}