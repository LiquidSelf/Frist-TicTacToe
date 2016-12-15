//import java.util.Scanner;
//
//public class SetXorO {
//
//    public static void setX(Field field, int num) {
//        Scanner scan = new Scanner(System.in);
//
//        for (; ; ) {
//
//            String temp = scan.next();
//
//            char q = temp.charAt(0);
//
//            if (temp.length() == 1) {
//
//
//                if (q == 'X') {
//                    switch (num) {
//                        case 1:
//                            field.setField1('X');
//                            break;
//                        case 2:
//                            field.setField2('X');
//                            break;
//                        case 3:
//                            field.setField3('X');
//                            break;
//                        case 4:
//                            field.setField4('X');
//                            break;
//                        case 5:
//                            field.setField5('X');
//                            break;
//                        case 6:
//                            field.setField6('X');
//                            break;
//                        case 7:
//                            field.setField7('X');
//                            break;
//                        case 8:
//                            field.setField8('X');
//                            break;
//                        case 9:
//                            field.setField9('X');
//                            break;
//                    }
//
//                    break;
//
//                } else System.out.println("Ходит крестик, введите 'X'");
//
//            } else System.out.println("Ходит крестик, введите 'X'");
//
//        }
//    }
//
//    public static void setO (Field field, int num) {
//        Scanner scan = new Scanner(System.in);
//
//        for (; ; ) {
//
//            String temp = scan.next();
//            char q = temp.charAt(0);
//
//            if (temp.length() == 1) {
//
//
//                if (q == 'O') {
//                    switch (num){
//                        case 1:field.setField1('O');
//                            break;
//                        case 2:field.setField2('O');
//                            break;
//                        case 3:field.setField3('O');
//                            break;
//                        case 4:field.setField4('O');
//                            break;
//                        case 5:field.setField5('O');
//                            break;
//                        case 6:field.setField6('O');
//                            break;
//                        case 7:field.setField7('O');
//                            break;
//                        case 8:field.setField8('O');
//                            break;
//                        case 9:field.setField9('O');
//                            break;
//                    }
//
//                    break;
//
//                } else System.out.println("Ходит нолик, введите 'O'");
//
//            } else System.out.println("Ходит нолик, введите 'O'");
//
//        }
//    }
//}
