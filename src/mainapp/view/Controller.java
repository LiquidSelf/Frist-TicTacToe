package mainapp.view;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeType;
import mainapp.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Controller {

    private Field game = Field.setEmptyField(new Field());
    private FxGameStatus fxGameStatus = new FxGameStatus();
    private List<Image> setX = new LinkedList<Image>();
    private List<Image> setO = new LinkedList<Image>();
    private Random r = new Random(System.currentTimeMillis());
    private FXPsvm fxPsvm;
    private SqlPsvm sqlPsvm;

    @FXML
    private ImageView img1;
    @FXML
    private ImageView img2;
    @FXML
    private ImageView img3;
    @FXML
    private ImageView img4;
    @FXML
    private ImageView img5;
    @FXML
    private ImageView img6;
    @FXML
    private ImageView img7;
    @FXML
    private ImageView img8;
    @FXML
    private ImageView img9;

    @FXML
    private void click(Event event) {

        fxGameStatus.whosTurn();

        fxGameStatus.addStep();

        FXPsvm.title.set("'" + fxGameStatus.getReversWhosTurn() + "' turn");

        switch (Integer.parseInt(String.valueOf(event.getTarget().toString().charAt(16)))) {

            case 1:
                play(1);
                break;
            case 2:
                play(2);
                break;
            case 3:
                play(3);
                break;
            case 4:
                play(4);
                break;
            case 5:
                play(5);
                break;
            case 6:
                play(6);
                break;
            case 7:
                play(7);
                break;
            case 8:
                play(8);
                break;
            case 9:
                play(9);
                break;
        }


    }

    public Controller() {
        setO.add(new Image("mainapp/view/imjes/o/1.jpg"));
        setO.add(new Image("mainapp/view/imjes/o/2.jpg"));
        setO.add(new Image("mainapp/view/imjes/o/3.jpg"));
        setO.add(new Image("mainapp/view/imjes/o/4.jpg"));
        setO.add(new Image("mainapp/view/imjes/o/5.jpg"));
        setX.add(new Image("mainapp/view/imjes/x/1.jpg"));
        setX.add(new Image("mainapp/view/imjes/x/2.jpg"));
        setX.add(new Image("mainapp/view/imjes/x/3.jpg"));
        setX.add(new Image("mainapp/view/imjes/x/4.jpg"));
        setX.add(new Image("mainapp/view/imjes/x/5.jpg"));

    }

    private int rand() {
        return r.nextInt(5);
    }


    private void play(int target) {

        if (getImje(target) != null) {

            System.err.println("For Aiur!");

            fxGameStatus.backStep();

            FXPsvm.title.set("'" + fxGameStatus.getWhosTurn() + "'" + " turn!");

        } else {


            game = fxGameStatus.move(game, fxGameStatus, target);

            setImjes(fxGameStatus, target);

            switch (fxGameStatus.isEnd(game, fxGameStatus)) {


                case 1:
                    addRedline(fxGameStatus.getVec());
                    fxPsvm.andWinnerIs(fxGameStatus.getWhosTurn());
                    System.exit(1);
                    break;


                case 2:
                    fxPsvm.draw();
                    System.exit(1);
                    break;

            }

        }

    }


    private class FxGameStatus extends GameStatus {

        private Field move(Field game, GameStatus gameStatus, int event) {

            if (this.getWhosTurn() == 'X') {

                game = Figures.setX(game, event, gameStatus);


            } else {

                game = Figures.setO(game, event, gameStatus);

            }


            return game;


        }
    }

    private void setImjes(FxGameStatus status, int event) {

        switch (event) {
            case 1:
                img1.setImage(randPics(status));
                break;
            case 2:
                img2.setImage(randPics(status));
                break;
            case 3:
                img3.setImage(randPics(status));
                break;
            case 4:
                img4.setImage(randPics(status));
                break;
            case 5:
                img5.setImage(randPics(status));
                break;
            case 6:
                img6.setImage(randPics(status));
                break;
            case 7:
                img7.setImage(randPics(status));
                break;
            case 8:
                img8.setImage(randPics(status));
                break;
            case 9:
                img9.setImage(randPics(status));

        }

    }

    private Image getImje(int event) {

        switch (event) {
            case 1:
                return img1.getImage();
            case 2:
                return img2.getImage();
            case 3:
                return img3.getImage();
            case 4:
                return img4.getImage();
            case 5:
                return img5.getImage();
            case 6:
                return img6.getImage();
            case 7:
                return img7.getImage();
            case 8:
                return img8.getImage();
            case 9:
                return img9.getImage();
        }
        return null;
    }

    private Image randPics(FxGameStatus gameStatus) {

        if (gameStatus.getWhosTurn() == 'X') {
            return setX.get(rand());
        } else {
            return setO.get(rand());
        }
    }

    private void addRedline(int vec) {

        double windowY = img1.getParent().getParent().getParent().getLayoutBounds().getHeight();
        double windowX = img1.getParent().getParent().getParent().getLayoutBounds().getWidth();
        double halfButtonY = windowY / 6;
        double halfButtonX = windowX / 6;
        double buttonY = windowY / 3;
        double buttonX = windowX / 3;


        Line redLine = new Line();
        redLine.setStroke(Color.rgb(255, 16, 10, 0.6078));
        redLine.setStrokeType(StrokeType.OUTSIDE);
        redLine.setStrokeWidth(7);
        switch (vec) {
            case 13:
                redLine.setStartX(0);
                redLine.setStartY(halfButtonY);
                redLine.setEndX(windowX);
                redLine.setEndY(halfButtonY);
                break;
            case 17:
                redLine.setStartX(halfButtonX);
                redLine.setStartY(0);
                redLine.setEndX(halfButtonX);
                redLine.setEndY(windowY);
                break;
            case 19:
                redLine.setStartX(0);
                redLine.setStartY(0);
                redLine.setEndX(buttonX * 3);
                redLine.setEndY(buttonY * 3);
                break;
            case 28:
                redLine.setStartX(windowX / 2);
                redLine.setStartY(0);
                redLine.setEndX(windowX / 2);
                redLine.setEndY(windowY);
                break;
            case 39:
                redLine.setStartX(windowX - halfButtonX);
                redLine.setStartY(0);
                redLine.setEndX(windowX - halfButtonX);
                redLine.setEndY(windowY);
                break;
            case 37:
                redLine.setStartX(windowX);
                redLine.setStartY(0);
                redLine.setEndX(0);
                redLine.setEndY(windowY);
                break;
            case 46:
                redLine.setStartX(0);
                redLine.setStartY(windowY / 2);
                redLine.setEndX(windowX);
                redLine.setEndY(windowY / 2);
                break;
            case 79:
                redLine.setStartX(0);
                redLine.setStartY(windowY - halfButtonY);
                redLine.setEndX(windowX);
                redLine.setEndY(windowY - halfButtonY);
                break;

        }
        fxPsvm.getGridRoot().getChildren().add(redLine);
    }

    public void setFxPsvm(FXPsvm fxPsvm) {
        this.fxPsvm = fxPsvm;
    }
    public void setSqlPsvm(SqlPsvm sqlPsvm) {
        this.sqlPsvm = sqlPsvm;
    }
}

