package mainapp.controller;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import mainapp.model.Field;
import mainapp.model.Figures;
import mainapp.model.GameStatus;
import mainapp.SqlPsvm;
import mainapp.controller.Refs.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class SqlController extends Controller {

    private Field game = Field.setEmptyField(new Field());
    private FxGameStatus fxGameStatus = new FxGameStatus();
    private List<Image> setX = new LinkedList<Image>();
    private List<Image> setO = new LinkedList<Image>();
    private Random r = new Random(System.currentTimeMillis());
    private SqlPsvm sqlPsvm;
    public static char turn;
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
        choise(event);

    }


    private int rand() {
        return r.nextInt(5);
    }


    @Override
    public void play(int target) throws SQLException {

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
            case Click.FIELD_ONE:

                img1.setImage(randPics(figure));
                update(figure, event);
                break;
            case Click.FIELD_TWO:

                img2.setImage(randPics(figure));
                update(figure, event);

                break;
            case Click.FIELD_THREE:
                img3.setImage(randPics(figure));
                update(figure, event);

                break;
            case Click.FIELD_FOUR:

                img4.setImage(randPics(figure));
                update(figure, event);

                break;
            case Click.FIELD_FIVE:

                img5.setImage(randPics(figure));
                update(figure, event);

                break;
            case Click.FIELD_SIX:

                img6.setImage(randPics(figure));
                update(figure, event);

                break;
            case Click.FIELD_SEVEN:

                img7.setImage(randPics(figure));
                update(figure, event);

                break;
            case Click.FIELD_EIGHT:

                img8.setImage(randPics(figure));
                update(figure, event);

                break;
            case Click.FIELD_NINE:

                img9.setImage(randPics(figure));
                update(figure, event);
                System.out.println(figure);
                break;
        }

    }

    private void update(char figure, int event) throws SQLException {
        String temp = String.valueOf(figure);
        try (Statement st = SqlPsvm.connect.createStatement()) {
            st.executeUpdate("UPDATE xoxo SET figure = '" + temp + "' where field = " + event + " or field = 10");
        }
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


    public void setSqlPsvm(SqlPsvm sqlPsvm) {
        this.sqlPsvm = sqlPsvm;
    }


    public void sqlSync() throws SQLException {

        try (Statement statement = SqlPsvm.connect.createStatement(); ResultSet rs = statement.executeQuery("SELECT * FROM xoxo")) {


            for (int i = 1; rs.next()|| i<11; i++) {

                char figure = rs.getString(2).charAt(0);

                if (i == 10 && figure != ' ') {
                    fxGameStatus.setWhosturn(figure);
                }

                if (figure == 'X' || figure == 'O') {
                    setFieldAndImg(i, figure);
                }


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

    private char whosTurn() throws SQLException {

        try (Statement st = SqlPsvm.connect.createStatement(); ResultSet rs = st.executeQuery("SELECT * from xoxo where field = 10")) {
            rs.next();
            char t;
            t = rs.getString(2).charAt(0);

            if (t == ' ' || t == 'O') {
                turn = 'X';
            } else turn = 'O';

            fxGameStatus.setWhosturn(turn);

            return turn;
        }
    }

    public void isEnd() throws Exception {

        int key = fxGameStatus.isEnd(game, fxGameStatus);


        switch (key) {

            case State.WIN:
                isend = true;
                addRedline(fxGameStatus.getVec(), sqlPsvm.getGridRoot().getChildren());
                sqlPsvm.andWinnerIs(fxGameStatus.getWhosTurn());
                System.exit(1);
                break;

            case State.DRAW:
                isend = true;
                sqlPsvm.draw();
                System.exit(1);
                break;

        }

    }


    public char getWhosturn() {
        return fxGameStatus.getReversWhosTurn();

    }


}

