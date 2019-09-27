package app;

public class App {
    public static void main(String[] args) throws Exception {
        Henkilo hugo = new Henkilo("Hugu", 1, 8, 2000);
        System.out.println(hugo.ikaVuosina());
    }
}