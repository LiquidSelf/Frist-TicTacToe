package mainapp;

final class ConsolePsvm {

    public static void main(final String[] args) {

        play();
    }

   static void play() {


        Field game = Field.setEmptyField(new Field());
        GameStatus gameStatus = new GameStatus();

        Guide.showGuide();

        for (; ; ) {

            gameStatus.whosTurn();

            System.out.println("Ходит " + gameStatus.getWhosTurn() + "!");

            game.showField();

            game = gameStatus.move(game, gameStatus);

            switch (gameStatus.isEnd(game, gameStatus)) {

                case 1: //win
                    System.out.print(gameStatus.getWhosTurn());
                    System.out.println(" победил, gg wp!");
                    game.showField();

                    System.exit(1);

                    break;


                case 2: //draw
                    System.out.println("ничья!");
                    game.showField();

                    System.exit(2);

                    break;
            }
        }
    }
}
