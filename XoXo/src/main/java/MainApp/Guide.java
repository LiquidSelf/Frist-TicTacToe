package MainApp;

import java.util.Scanner;

public class Guide {

    public static String neveroyatniy;
    public static void IsNeveroyatniy(){
        if (neveroyatniy.contains("евероят")){
            System.out.println("Спасибо, Вы тоже! ^^");
        }

    }

    public static void showGuide(){
        /** Вводная часть:*/
        Scanner scan = new Scanner(System.in);
        System.out.println("КрестикиНолики.\nДля игры вводите цифры, соответствующие отметкам у поля.");
        Field field = SetField.setEmptyField(new Field());
        field.showField();
        System.out.println("\n (включите скролл консоли)");
        System.out.println("Напечатайте, " +
                "'невероятный', чтобы продолжить!");
        String q = scan.nextLine();
        neveroyatniy = q;
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
        IsNeveroyatniy();


    }

}
