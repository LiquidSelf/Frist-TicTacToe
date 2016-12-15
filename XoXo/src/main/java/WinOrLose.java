public class WinOrLose {

    public static boolean winOrLose(Field field) {

        boolean q = true;

        if
                (field.getField1() == field.getField2() &&
                 field.getField2() == field.getField3()) {
                 q = false;
        }
        else if (field.getField1() == field.getField4() &&
                 field.getField4() == field.getField7()){
                 q = false;
        }
        else if (field.getField1() == field.getField5() &&
                field.getField5() == field.getField9()){
            q = false;
        }
        else if (field.getField2() == field.getField5() &&
                field.getField5() == field.getField8()){
            q = false;
        }
        else if (field.getField3() == field.getField6() &&
                field.getField6() == field.getField9()){
            q = false;
        }
        else if (field.getField3() == field.getField5() &&
                field.getField5() == field.getField7()){
            q = false;
        }
        else if (field.getField4() == field.getField5() &&
                field.getField5() == field.getField6()){
            q = false;
        }
        else if (field.getField7() == field.getField8() &&
                field.getField8() == field.getField9()){
            q = false;
        }
        else if (field.getField7() == field.getField5() &&
                field.getField5() == field.getField3()){
            q = false;
        }

        return q;
    }

}
