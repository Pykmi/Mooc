
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Date;
import javax.swing.JOptionPane;

public class Pariohjelmointikello {

    // HUOM! Muokatkaa nämä vastaamaan opiskelijanumeroitanne
    // (tai TMC-tunnuksianne)
    public static String ensimmaisenOhjelmoijanOpiskelijanumero() {
        return "0123456789";
    }

    public static String toisenOhjelmoijanOpiskelijanumero() {
        return "9876543210";
    }

    // Tätä ei tarvitse muokata
    public static void main(String[] args) throws Exception {
        // tätä ohjelmaa käytetään ajajan, eli koodia kirjoittavan ohjelmoijan

        PrintWriter pw = new PrintWriter(new FileOutputStream(new File("pariohjelmoijat.txt"), true));
        int vuoro = 0;

        while (true) {
            String viesti = "Vaihto! Seuraavaksi ohjelmoi: ";
            if (vuoro % 2 == 0) {
                viesti += ensimmaisenOhjelmoijanOpiskelijanumero();
            } else {
                viesti += toisenOhjelmoijanOpiskelijanumero();
            }

            JOptionPane.showMessageDialog(null, viesti, "Aika!", JOptionPane.WARNING_MESSAGE);
            if (vuoro % 2 == 0) {
                pw.println(new Date() + ";" + ensimmaisenOhjelmoijanOpiskelijanumero());
            } else {
                pw.println(new Date() + ";" + toisenOhjelmoijanOpiskelijanumero());
            }
            pw.flush();

            try {
                Thread.sleep(1000 * 60 * 5); // odotetaan 5 minuuttia.
            } catch (InterruptedException ex) {
            }
        }

    }

}
