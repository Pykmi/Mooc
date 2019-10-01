package app;

class Henkilo {
    private String name;
    private String phone;

    public Henkilo(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String haeNimi() {
        return this.name;
    }

    public String haeNumero() {
        return this.phone;
    }

    public void vaihdaNumeroa(String uusiNumero) {
        this.phone = uusiNumero;
    }

    public String toString() {
        return this.name + "  puh: " + this.phone;
    }
}