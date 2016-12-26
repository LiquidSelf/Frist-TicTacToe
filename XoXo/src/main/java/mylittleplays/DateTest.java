package mylittleplays;

import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        long q = System.currentTimeMillis();
        String str1 = "У кота ";
        String str2 = " лапы";
        int paws = 4;
        StringBuffer sb = new StringBuffer(20);
        sb.append(str1).append(paws).append(str2);
        System.out.println(sb.toString());
        for (int e = 1; e<300000;e++){
            System.out.println(e);
        }

        long w = (System.currentTimeMillis() - q);

        System.out.println("Программа выполнилась за "+w+" миллисекунд.");
        System.out.println("Сегодня "+new Date(System.currentTimeMillis()));
     }
}

