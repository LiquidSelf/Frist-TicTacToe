package mainapp.model;

/**This Class created to represent scrap of paper.*/

public class Field {

    private char field1;
    private char field2;
    private char field3;
    private char field4;
    private char field5;
    private char field6;
    private char field7;
    private char field8;
    private char field9;

    public char getField1() {
        return field1;
    }

    public void setField1(char field1) {
        this.field1 = field1;
    }

    public char getField2() {
        return field2;
    }

    public void setField2(char field2) {
        this.field2 = field2;
    }

    public char getField3() {
        return field3;
    }

    public void setField3(char field3) {
        this.field3 = field3;
    }

    public char getField4() {
        return field4;
    }

    public void setField4(char field4) {
        this.field4 = field4;
    }

    public char getField5() {
        return field5;
    }

    public void setField5(char field5) {
        this.field5 = field5;
    }

    public char getField6() {
        return field6;
    }

    public void setField6(char field6) {
        this.field6 = field6;
    }

    public char getField7() {
        return field7;
    }

    public void setField7(char field7) {
        this.field7 = field7;
    }

    public char getField8() {
        return field8;
    }

    public void setField8(char field8) {
        this.field8 = field8;
    }

    public char getField9() {
        return field9;
    }

    public void setField9(char field9) {
        this.field9 = field9;
    }

    public void  showField() {
        char s1 = getField1();
        char s2 = getField2();
        char s3 = getField3();
        char s4 = getField4();
        char s5 = getField5();
        char s6 = getField6();
        char s7 = getField7();
        char s8 = getField8();
        char s9 = getField9();
        System.out.println("                2                ");
        System.out.println("1           |       |           3");
        System.out.println("      " + s1 + "     |   " + s2 + "   |    " + s3 + "        ");
        System.out.println("            |       |            ");
        System.out.println("     —         --         —       ");
        System.out.println("            |       |            ");
        System.out.println("4     " + s4 + "     |   " + s5 + "   |    " + s6 + "      6");
        System.out.println("            |       |            ");
        System.out.println("     —         --         —       ");
        System.out.println("            |       |            ");
        System.out.println("      " + s7 + "     |   " + s8 + "   |    " + s9 + "       ");
        System.out.println("7           |       |           9");
        System.out.println("                8                ");


    }

    public char getAnyField(int num) {
        char result = ' ';
        switch (num) {
            case 1:
                result = getField1();
                break;
            case 2:
                result = getField2();
                break;
            case 3:
                result = getField3();
                break;
            case 4:
                result = getField4();
                break;
            case 5:
                result = getField5();
                break;
            case 6:
                result = getField6();
                break;
            case 7:
                result = getField7();
                break;
            case 8:
                result = getField8();
                break;
            case 9:
                result = getField9();
                break;
        }
        return result;
    }

    public static Field setEmptyField(Field field) {

        field.setField1(' ');
        field.setField2(' ');
        field.setField3(' ');
        field.setField4(' ');
        field.setField5(' ');
        field.setField6(' ');
        field.setField7(' ');
        field.setField8(' ');
        field.setField9(' ');

        return field;
    }

    public static Field setNumeredField(Field field) {
        field.setField1('1');
        field.setField2('2');
        field.setField3('3');
        field.setField4('4');
        field.setField5('5');
        field.setField6('6');
        field.setField7('7');
        field.setField8('8');
        field.setField9('9');

        return field;
    }

    @Override
    public String toString() {
        String stringRes = ("" + getField1() + getField2() + getField3() + getField4() + getField5() + getField6() + getField7() + getField8() + getField9());
        return stringRes;

    }
}
