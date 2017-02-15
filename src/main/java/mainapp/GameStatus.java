package mainapp;

public class GameStatus {
    static int status = 0;

    public static int isEnd(Field field) { //0 - keep, 1 winlose, 2 = draw

        GameStatus g = new GameStatus();

        g.winOrLose(field);

        g.isDraw(field);

        return status;

    }

    public static char whosTurn() {

        char w;

        int q = Field.getCount();

        if (q % 2 == 1) {
            w = 'O';
        } else w = 'X';

        return w;
    }

    private void winOrLose(Field field) {
        boolean q = false;

        if (field.getField1() == field.getField2() && field.getField2() == field.getField3() && field.getField3() != ' ') {
            q = true;
        } else if (field.getField1() == field.getField4() && field.getField4() == field.getField7() && field.getField7() != ' ') {
            q = true;
        } else if (field.getField1() == field.getField5() && field.getField5() == field.getField9() && field.getField9() != ' ') {
            q = true;
        } else if (field.getField2() == field.getField5() && field.getField5() == field.getField8() && field.getField8() != ' ') {
            q = true;
        } else if (field.getField3() == field.getField6() && field.getField6() == field.getField9() && field.getField9() != ' ') {
            q = true;
        } else if (field.getField3() == field.getField5() && field.getField5() == field.getField7() && field.getField7() != ' ') {
            q = true;
        } else if (field.getField4() == field.getField5() && field.getField5() == field.getField6() && field.getField6() != ' ') {
            q = true;
        } else if (field.getField7() == field.getField8() && field.getField8() == field.getField9() && field.getField9() != ' ') {
            q = true;
        } else if (field.getField7() == field.getField5() && field.getField5() == field.getField3() && field.getField3() != ' ') {
            q = true;
        }

        if (q) {
            status = 1;
        }


    }

    private void isDraw(Field game) {

        if (!game.toString().contains(" ")) {
            status = 2;

        }


    }

}