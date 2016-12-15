public class psvm {

    public static void main(String[] args) {

        System.out.println("Крестики ходят первыми. (введите поле 1-9)");
        Field field = SetField.numeredField(new Field());
        field.showField();
        for (;WinOrLose.winOrLose(field);){
            field.setField1('x');
            field.setField5('o');
            field.setField9('x');
            System.out.println("lol");


        }


    }
}
