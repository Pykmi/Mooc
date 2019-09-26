
import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Breakout extends Application {

    public void start(Stage stage) {
        final int pelinLeveys = 480;
        final int pelinKorkeus = 640;

        stage.setTitle("Breakout");

        Group root = new Group();
        Scene scene = new Scene(root);
        stage.setScene(scene);

        Canvas piirtoalusta = new Canvas(pelinLeveys, pelinKorkeus);
        root.getChildren().add(piirtoalusta);

        GraphicsContext piirturi = piirtoalusta.getGraphicsContext2D();

        // luodaan maila
        Suorakulmio maila = new Suorakulmio(0, 580, 80, 20, Color.BURLYWOOD);

        // luodaan pallo
        Pallo pallo = new Pallo(pelinLeveys / 2, pelinKorkeus / 2, 10);
        // ja pallon "liike"
        Liike liike = new Liike(0.5, 0.5);

        // luodaan rikottavat palat
        ArrayList<Suorakulmio> palat = new ArrayList<>();

        palat.add(new Suorakulmio(30, 15, 30, 15, Color.RED));
        palat.add(new Suorakulmio(62, 15, 30, 15, Color.RED));

        // siirretään mailaa kun hiiri liikkuu
        scene.setOnMouseMoved((MouseEvent e) -> {
            maila.setX((int) e.getSceneX() - maila.getLeveys() / 2);
        });

        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                piirturi.clearRect(0, 0, pelinLeveys, pelinKorkeus);

                // piirretään maila
                piirturi.setFill(maila.getVari());
                piirturi.fillRect(maila.getX(), maila.getY(), maila.getLeveys(), maila.getKorkeus());

                // piirretään pallo
                piirturi.setFill(Color.CORNFLOWERBLUE);
                piirturi.fillOval(pallo.getX(), pallo.getY(), pallo.getSade() * 2, pallo.getSade() * 2);

                // piirretään rikottavat palat
                int palaIndeksi = 0;
                while (palaIndeksi < palat.size()) {
                    Suorakulmio pala = palat.get(palaIndeksi);
                    piirturi.setFill(pala.getVari());
                    piirturi.fillRect(pala.getX(), pala.getY(), pala.getLeveys(), pala.getKorkeus());
                    palaIndeksi++;
                }

                // liikutetaan palloa
                pallo.liikuta(liike);

                // tarkista osuuko pallo mailaan
                
                
                
                // tarkistetaan osuuko pallo johonkin reunoista
                if (pallo.getY() < 0) {
                    liike.setLiikeY(-1 * liike.getLiikeY());
                }

                if (pallo.getX() < 0) {
                    liike.setLiikeX(-1 * liike.getLiikeX());
                }
                
                if (pallo.getX() + pallo.getSade() * 2 > pelinLeveys) {
                    liike.setLiikeX(-1 * liike.getLiikeX());
                }

                // jos pallo osuu alalaitaan, lopetetaan peli
                if (pallo.getY() > pelinKorkeus) {
                    ((Stage) root.getScene().getWindow()).close();
                }
            }
        }.start();

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
