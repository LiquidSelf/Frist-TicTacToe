package mainapp;

public class Figures {

    public static Field setX(Field game, int num, GameStatus status) {


        if (game.getAnyField(num) == ' ') {
            switch (num) {
                case 1:
                    game.setField1('X');
                    break;
                case 2:
                    game.setField2('X');
                    break;
                case 3:
                    game.setField3('X');
                    break;
                case 4:
                    game.setField4('X');
                    break;
                case 5:
                    game.setField5('X');
                    break;
                case 6:
                    game.setField6('X');
                    break;
                case 7:
                    game.setField7('X');
                    break;
                case 8:
                    game.setField8('X');
                    break;
                case 9:
                    game.setField9('X');
                    break;
            }


        } else {

            status.backStep();

            System.out.println("\n\n\n\n\n\n\n\n\n\n");

            System.out.println("поле занято!");

        }

        return game;
    }


    public static Field setO(Field game, int num, GameStatus status) {
        if (game.getAnyField(num) == ' ') {
            switch (num) {
                case 1:
                    game.setField1('O');
                    break;
                case 2:
                    game.setField2('O');
                    break;
                case 3:
                    game.setField3('O');
                    break;
                case 4:
                    game.setField4('O');
                    break;
                case 5:
                    game.setField5('O');
                    break;
                case 6:
                    game.setField6('O');
                    break;
                case 7:
                    game.setField7('O');
                    break;
                case 8:
                    game.setField8('O');
                    break;
                case 9:
                    game.setField9('O');
                    break;
            }

        } else {

            status.backStep();

            System.out.println("\n\n\n\n\n\n\n\n\n\n");

            System.out.println("поле занято!");
        }


        return game;
    }
}