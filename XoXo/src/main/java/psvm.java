import java.util.Scanner;

public class psvm {

    public static void main(String[] args) {
        Guide.showGuide();
        Field game = SetField.setEmptyField(new Field());
        Scanner scan = new Scanner(System.in);

        for (; ; game.addCount()) {
            System.out.println("Ходит " + whosTurn(game) + "! (число 1-9)");
            game.showField();

            int target = scan.nextInt();

            if (target < 10 && target > 0) {
                if (whosTurn(game) == 'X') {
                    SetXorO.setX(game, target);
                } else SetXorO.setO(game, target);
            } else System.out.println("число вне диапазона");

            if (WinOrLose.winOrLose(game)) {
                game.showField();
                System.out.print(whosTurn(game) + " победил, gg wp.");
                break;

            }

        }


    }


    public static char whosTurn(Field game) {
        char w = 'w';
        int q = game.getCount();
        if (q % 2 == 1) {
            w = 'O';
        } else w = 'X';
        return w;
    }


}