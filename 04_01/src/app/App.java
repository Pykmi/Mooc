package app;

public class App {
    public static void main(String[] args) throws Exception {
        Kirja kirja = new Kirja("J. K. Rowling", "Harry Potter ja viisasten kivi", 223);
        System.out.println(kirja.toString());
    }
}