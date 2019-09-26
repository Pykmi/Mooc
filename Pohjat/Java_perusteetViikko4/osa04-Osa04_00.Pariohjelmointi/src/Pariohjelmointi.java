
import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Pariohjelmointi extends Application {


    public void start(Stage stage) {
        final int pelinLeveys = 640;
        final int pelinKorkeus = 480;

        stage.setTitle("Pong");

        Group root = new Group();
        Scene scene = new Scene(root);
        stage.setScene(scene);

        Canvas piirtoalusta = new Canvas(pelinLeveys, pelinKorkeus);
        root.getChildren().add(piirtoalusta);

        GraphicsContext piirturi = piirtoalusta.getGraphicsContext2D();
        
        // luodaan pistetilanne
        Pistetilanne pistetilanne = new Pistetilanne(0, 0);

        // luodaan oikealla olevan pelaajan maila
        Suorakulmio oikeaMaila = new Suorakulmio(600, 20, 20, 80, Color.BURLYWOOD);

        // luodaan vasemmalla olevan pelaajan maila
        Suorakulmio vasenMaila = new Suorakulmio(20, 20, 20, 80, Color.BURLYWOOD);

        // luodaan pallo
        Pallo pallo = new Pallo(pelinLeveys / 2, pelinKorkeus / 2, 10);
        // ja pallon "liike"
        Liike liike = new Liike(0.5, 0.5);

        // siirretään oikealla olevaa mailaa nuolinäppäimillä, vasemmalla
        // olevaa mailaa w:llä ja s:llä
        
        ArrayList<Integer> mailojenLiikkeet = new ArrayList<>();
        // indeksissä 0 ja 1 tieto meneekö vasen maila ylös tai alas
        mailojenLiikkeet.add(0);
        mailojenLiikkeet.add(0);
        // indeksissä 2 ja 3 tieto meneekö oikea maila ylös tai alas
        mailojenLiikkeet.add(0);
        mailojenLiikkeet.add(0);

        scene.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.W) {
                mailojenLiikkeet.set(0, 1);
            }

            if (e.getCode() == KeyCode.S) {
                mailojenLiikkeet.set(1, 1);
            }

            if (e.getCode() == KeyCode.UP) {
                mailojenLiikkeet.set(2, 1);
            }

            if (e.getCode() == KeyCode.DOWN) {
                mailojenLiikkeet.set(3, 1);
            }
        });

        scene.setOnKeyReleased((KeyEvent e) -> {
            if (e.getCode() == KeyCode.W) {
                mailojenLiikkeet.set(0, 0);
            }

            if (e.getCode() == KeyCode.S) {
                mailojenLiikkeet.set(1, 0);
            }

            if (e.getCode() == KeyCode.UP) {
                mailojenLiikkeet.set(2, 0);
            }

            if (e.getCode() == KeyCode.DOWN) {
                mailojenLiikkeet.set(3, 0);
            }
        });

        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                piirturi.clearRect(0, 0, pelinLeveys, pelinKorkeus);
                
                // piirretään pistetilanne
                piirturi.fillText(pistetilanne.toString(), pelinLeveys / 2 - 20, 20);

                // piirretään vasen maila
                piirturi.setFill(vasenMaila.getVari());
                piirturi.fillRect(vasenMaila.getX(), vasenMaila.getY(), vasenMaila.getLeveys(), vasenMaila.getKorkeus());

                // piirretään oikea maila
                piirturi.setFill(oikeaMaila.getVari());
                piirturi.fillRect(oikeaMaila.getX(), oikeaMaila.getY(), oikeaMaila.getLeveys(), oikeaMaila.getKorkeus());

                // piirretään pallo
                piirturi.setFill(Color.CORNFLOWERBLUE);
                piirturi.fillOval(pallo.getX(), pallo.getY(), pallo.getSade() * 2, pallo.getSade() * 2);

                // liikutetaan mailoja
                if (mailojenLiikkeet.get(0) == 1) {
                    vasenMaila.setY(vasenMaila.getY() + 1);
                }

                if (mailojenLiikkeet.get(1) == 1) {
                    vasenMaila.setY(vasenMaila.getY() - 1);
                }

                if (mailojenLiikkeet.get(2) == 1) {
                    oikeaMaila.setY(oikeaMaila.getY() + 1);
                }
                if (mailojenLiikkeet.get(3) == 1) {
                    oikeaMaila.setY(oikeaMaila.getY() - 1);
                }

                // liikutetaan palloa
                pallo.liikuta(liike);

                // tarkista osuuko pallo mailaan

                // ???




                // tarkistetaan osuuko pallo ylä- tai alareunaan 
                if (pallo.getY() < 0 || (pallo.getY() + pallo.getSade() * 2) > pelinKorkeus) {
                    liike.setLiikeY(-1 * liike.getLiikeY());
                }

                // tarkistetaan osuuko pallo vasempaan tai oikeaan reunaan
                if (pallo.getX() < 0 || pallo.getX() + pallo.getSade() * 2 > pelinLeveys) {
                    liike.setLiikeX(-1 * liike.getLiikeX());
                }
            }
        }.start();

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
