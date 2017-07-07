package mainapp.view;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeType;
import mainapp.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SqlController {

    private Field game = Field.setEmptyField(new Field());
    private FxGameStatus fxGameStatus = new FxGameStatus();
    private List<Image> setX = new LinkedList<Image>();
    private List<Image> setO = new LinkedList<Image>();
    private Random r = new Random(System.currentTimeMillis());
    private FXPsvm fxPsvm;
    private SqlPsvm sqlPsvm;
    static char turn;
    public static boolean isend = false;



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

    public SqlController() throws Exception {

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


    @FXML
    private void click(Event event) throws Exception {

        whosTurn();

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


    private int rand() {
        return r.nextInt(5);
    }


    private void play(int target) throws Exception {

        if (getImje(target) != null) {

            System.err.println("For Aiur!");

        } else {


            game = fxGameStatus.move(game, fxGameStatus, target);

            setImjes(turn, target);



        }


    }


    public class FxGameStatus extends GameStatus {

        private Field move(Field game, GameStatus gameStatus, int event) {

            if (this.getWhosTurn() == 'X') {

                game = Figures.setX(game, event, gameStatus);


            } else {

                game = Figures.setO(game, event, gameStatus);

            }


            return game;


        }
    }

    private void setImjes(char figure, int event) throws SQLException {


        switch (event) {
            case 1:

                img1.setImage(randPics(figure));
                update(figure, event);
                break;
            case 2:

                img2.setImage(randPics(figure));
                update(figure, event);

                break;
            case 3:
                img3.setImage(randPics(figure));
                update(figure, event);

                break;
            case 4:

                img4.setImage(randPics(figure));
                update(figure, event);

                break;
            case 5:

                img5.setImage(randPics(figure));
                update(figure, event);

                break;
            case 6:

                img6.setImage(randPics(figure));
                update(figure, event);

                break;
            case 7:

                img7.setImage(randPics(figure));
                update(figure, event);

                break;
            case 8:

                img8.setImage(randPics(figure));
                update(figure, event);

                break;
            case 9:

                img9.setImage(randPics(figure));
                update(figure, event);

                break;
        }

    }

    private void update(char figure, int event) throws SQLException {
        String temp = String.valueOf(figure);
        Statement st = SqlPsvm.connect.createStatement();
        st.executeUpdate("UPDATE xoxo SET figure = '" + temp + "' where field = " + event + " or field = 10");
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

    private Image randPics(char c) {
        if (c == 'X') {
            return setX.get(rand());
        } else {
            return setO.get(rand());
        }
    }

    private Image randPics2(char figure) {

        if (figure == 'X') {
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
        sqlPsvm.getGridRoot().getChildren().add(redLine);
    }

    public void setFxPsvm(FXPsvm fxPsvm) {
        this.fxPsvm = fxPsvm;
    }

    public void setSqlPsvm(SqlPsvm sqlPsvm) {
        this.sqlPsvm = sqlPsvm;
    }


    public void sqlSync() throws SQLException {

        Statement statement = SqlPsvm.connect.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM xoxo");

        for (int i = 1; rs.next(); i++) {

            char figure = ' ';

            figure = rs.getString(2).charAt(0);

            if (figure == 'X' || figure == 'O') {

                setFieldAndImg(i, figure);

            }


        }

    }

    private void setFieldAndImg(int i, char figure) {

        switch (i) {
            case 1:
                if (game.getField1() != figure) {
                    img1.setImage(randPics2(figure));
                    game.setField2(figure);
                }
                break;
            case 2:
                if (game.getField2() != figure) {
                    img2.setImage(randPics2(figure));
                    game.setField2(figure);
                }
                break;
            case 3:
                if (game.getField3() != figure) {
                    img3.setImage(randPics2(figure));
                    game.setField3(figure);
                }
                break;
            case 4:
                if (game.getField4() != figure) {
                    img4.setImage(randPics2(figure));
                    game.setField4(figure);
                }
                break;
            case 5:
                if (game.getField5() != figure) {
                    img5.setImage(randPics2(figure));
                    game.setField5(figure);
                }
                break;
            case 6:
                if (game.getField6() != figure) {
                    img6.setImage(randPics2(figure));
                    game.setField6(figure);
                }
                break;
            case 7:
                if (game.getField7() != figure) {
                    img7.setImage(randPics2(figure));
                    game.setField7(figure);
                }
                break;
            case 8:
                if (game.getField8() != figure) {
                    img8.setImage(randPics2(figure));
                    game.setField8(figure);
                }
                break;
            case 9:
                if (game.getField9() != figure) {
                    img9.setImage(randPics2(figure));
                    game.setField9(figure);
                }
                break;

        }

    }

    public static char getTurn() {
        return turn;
    }

    private char whosTurn() throws SQLException {

        Statement st = SqlPsvm.connect.createStatement();
        ResultSet rs = st.executeQuery("SELECT * from xoxo where field = 10");
        rs.next();
        char t;
        t = rs.getString(2).charAt(0);

        if (t == ' ' || t == 'O') {
            turn = 'X';
        } else turn = 'O';

        fxGameStatus.setWhosturn(turn);


        return turn;
    }

    public void  isEnd() throws Exception {

        int key = fxGameStatus.isEnd(game, fxGameStatus);


        switch (key) {


            case 1:
                isend = true;
                addRedline(fxGameStatus.getVec());
                sqlPsvm.andWinnerIs(fxGameStatus.getWhosTurn());
                sqlPsvm.connect.close();
                System.exit(1);
                break;


            case 2:
                isend = true;
                sqlPsvm.draw();
                sqlPsvm.connect.close();
                System.exit(1);
                break;

        }

    }




}

