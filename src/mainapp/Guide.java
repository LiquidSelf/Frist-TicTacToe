package mainapp;

import java.util.Scanner;

class Guide {

    public static String neveroyatniy;

    public static void isNeveroyatniy() {

        if (neveroyatniy.contains("евероят")) {

            System.out.println("Спасибо, Вы тоже! ^^");
        }

    }

    static void showGuide() {

        Scanner scan = new Scanner(System.in);

        System.out.println("КрестикиНолики.");

        System.out.println("Для игры вводите цифры, соответствующие отметкам у поля.");

        Field guide = Field.setEmptyField(new Field());

        guide.showField();

        System.out.println("\n (включите скролл консоли)");

        System.out.println("Напечатайте, " + "'невероятный', чтобы продолжить!");

        neveroyatniy = scan.nextLine();

        System.out.println("\n\n\n\n\n\n\n\n\n\n");

        isNeveroyatniy();

    }


}
