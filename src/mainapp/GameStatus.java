package mainapp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameStatus {

    private int vec = 0;

    private int status;

    private char whosturn = 'O';

    private int step = 0;

    public void addStep() {
        step++;
    }

    public void backStep() {
        step--;
    }

    public int getStep() {
        return step;
    }

    void setWhosTurn(char t) {
        this.whosturn = t;
    }

    public char getWhosTurn() {
        return whosturn;
    }

    public char getReversWhosTurn(){
        if(getWhosTurn()=='X'){
            return 'O';
        }
        else return 'X';
    }

    public void whosTurn() {
        if (getStep() % 2 == 1) {
            whosturn = 'O';
        } else whosturn = 'X';

    }


    public int isEnd(Field game, GameStatus gameStatus) { //0 - keep, 1 winlose, 2 = draw

        status = 0;

        gameStatus.isDraw(game);

        gameStatus.winOrLose(game);

        return status;

    }

    private void winOrLose(Field game) {
        boolean q = false;

        if (game.getField1() == game.getField2() && game.getField2() == game.getField3() && game.getField3() != ' ') {
            q = true; vec = 13;
        } else if (game.getField1() == game.getField4() && game.getField4() == game.getField7() && game.getField7() != ' ') {
            q = true; vec = 17;
        } else if (game.getField1() == game.getField5() && game.getField5() == game.getField9() && game.getField9() != ' ') {
            q = true; vec = 19;
        } else if (game.getField2() == game.getField5() && game.getField5() == game.getField8() && game.getField8() != ' ') {
            q = true; vec = 28;
        } else if (game.getField3() == game.getField6() && game.getField6() == game.getField9() && game.getField9() != ' ') {
            q = true; vec = 39;
        } else if (game.getField3() == game.getField5() && game.getField5() == game.getField7() && game.getField7() != ' ') {
            q = true; vec = 37;
        } else if (game.getField4() == game.getField5() && game.getField5() == game.getField6() && game.getField6() != ' ') {
            q = true; vec = 46;
        } else if (game.getField7() == game.getField8() && game.getField8() == game.getField9() && game.getField9() != ' ') {
            q = true; vec = 79;
        } else if (game.getField7() == game.getField5() && game.getField5() == game.getField3() && game.getField3() != ' ') {
            q = true; vec = 37;
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

    public Field move(Field game, GameStatus gameStatus) throws InputMismatchException {

        final int numOfFields = 9;

        int target = 0;

        for (;target == 0; ) {

            try {

                Scanner scan = new Scanner(System.in);

                target =  scan.nextInt();


            } catch (InputMismatchException wronginput) {

                System.out.println("только цифры!");


            }catch (Exception ex) {

                System.out.println("Exception");


            }
        }


            game.showField();

            if (target <= numOfFields && target > 0) {

                if (this.getWhosTurn() == 'X') {

                    System.out.println("\n\n\n\n\n\n\n\n\n\n");
                    game = Figures.setX(game, target, gameStatus);
                    this.addStep();

                } else {

                    System.out.println("\n\n\n\n\n\n\n\n\n\n");
                    game = Figures.setO(game, target, gameStatus);
                    this.addStep();
                }

             } else {

                System.out.println("\n\n\n\n\n\n\n\n\n\n");
                System.out.println("число от 1 до 9!");
            }

    return game;

    }
    public int getVec(){return vec;}


        }

