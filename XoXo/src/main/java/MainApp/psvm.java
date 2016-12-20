package mainapp;

import java.util.Scanner;

public class psvm {

    public static void main(String[] args) {
        Guide.showGuide();
        Field game = SetField.setEmptyField(new Field());
        Scanner scan = new Scanner(System.in);

        for (; ; Field.addCount()) {
            System.out.println("Ходит " + whosTurn() + "! (число 1-9)");
            game.showField();

            int target = scan.nextInt();

            if (target < 10 && target > 0) {
                if (whosTurn() == 'X') {
                    SetXorO.setX(game, target);
                } else SetXorO.setO(game, target);
            } else System.out.println("число вне диапазона");

            if (WinOrLose.winOrLose(game)) {
                game.showField();
                System.out.print(whosTurn() + " победил, gg wp.");
                break;

            }

        }


    }


    private static char whosTurn() {
        char w;
        int q = Field.getCount();
        if (q % 2 == 1) {
            w = 'O';
        } else w = 'X';
        return w;
    }


}