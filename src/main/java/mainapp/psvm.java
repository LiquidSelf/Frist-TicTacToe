package mainapp;

public class psvm {

    public static void main(String[] args) throws Exception {

        Guide.showGuide();

        Field game = SetField.setEmptyField(new Field());

        int target = 0;

        for (;; Field.addCount()) {

            System.out.println("Ходит " + GameStatus.whosTurn() + "!");

            game.showField();

            target = Guide.move(game);

            if (target < 10 && target > 0) {

                if (GameStatus.whosTurn() == 'X') {

                    System.out.println("\n\n\n\n\n\n\n\n\n\n");

                    SetXorO.setX(game, target);

                } else {

                    System.out.println("\n\n\n\n\n\n\n\n\n\n");

                    SetXorO.setO(game, target);

                  }

            } else {

                System.out.println("\n\n\n\n\n\n\n\n\n\n");

                System.out.println("число от 1 до 9!");
              }


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
