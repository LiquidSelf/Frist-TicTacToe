public class WinOrLose {

    public static boolean winOrLose(Field field) {

        boolean q = false;

        if
                (field.getField1() == field.getField2() &&
                field.getField2() == field.getField3() &&
                field.getField3() != ' '){
            q = true;
        } else if (field.getField1() == field.getField4() &&
                field.getField4() == field.getField7()&&
                field.getField7() != ' ') {
            q = true;
        } else if (field.getField1() == field.getField5() &&
                field.getField5() == field.getField9()    &&
                field.getField9() != ' ') {
            q = true;
        } else if (field.getField2() == field.getField5() &&
                field.getField5() == field.getField8()&&
                field.getField8() != ' ') {
            q = true;
        } else if (field.getField3() == field.getField6() &&
                field.getField6() == field.getField9()&&
                field.getField9() != ' ') {
            q = true;
        } else if (field.getField3() == field.getField5() &&
                field.getField5() == field.getField7()&&
                field.getField7() != ' ') {
            q = true;
        } else if (field.getField4() == field.getField5() &&
                field.getField5() == field.getField6()&&
                field.getField6() != ' ') {
            q = true;
        } else if (field.getField7() == field.getField8() &&
                field.getField8() == field.getField9()&&
                field.getField9() != ' ') {
            q = true;
        } else if (field.getField7() == field.getField5() &&
                field.getField5() == field.getField3()&&
                field.getField3() != ' ') {
            q = true;
        }


        return q;

    }
}