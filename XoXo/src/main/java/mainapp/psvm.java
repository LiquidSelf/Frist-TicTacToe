package mainapp;

import java.util.Scanner;

public class psvm {

    public static void main(String[] args) {
        Guide.showGuide();
        Field game = SetField.setEmptyField(new Field());
        Scanner scan = new Scanner(System.in);


        for (; ; Field.addCount()) {
            System.out.println("Ходит " + GameStatus.whosTurn() + "! (число 1-9)");
            game.showField();

            int target = scan.nextInt();

            if (target < 10 && target > 0) {
                if (GameStatus.whosTurn() == 'X') {
                    SetXorO.setX(game, target);
                } else SetXorO.setO(game, target);
            } else System.out.println("число вне диапазона");



            switch (GameStatus.isEnd(game)) {
                case 1: //win
                    System.out.println(GameStatus.whosTurn() + " победил, ggwp!");
                    game.showField();
                    System.exit(322);
                    break;
                case 2: //draw
                    System.out.println("ничья!");
                    game.showField();
                    System.exit(322);
                    break;

            }
        }
    }



}