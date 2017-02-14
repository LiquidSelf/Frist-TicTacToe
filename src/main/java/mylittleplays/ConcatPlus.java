package mylittleplays;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class ConcatPlus {
    public static void main(String[] args) throws IOException {
        File file[] = new File[2];
        file[0] = new File("C:\\Users\\LiquidSelf\\Desktop\\file1.txt");
        file[1] = new File("C:\\Users\\LiquidSelf\\Desktop\\file2.txt");
        main(file);

    }

    private static void main(File[] files) throws IOException {
        for (File file : files) {
//            readPlus(file);
//            readConcat(file);
//            readStringBuffer(file);
//            readStringBuilder(file);
        }
    }

    /**
     * Конкатенация с использованием оператора '+'.
     */
    public static void readPlus(File file) throws IOException {
        long g = System.currentTimeMillis();
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String wholeText = "";
        String line;

        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            wholeText += line;
        }

        process(wholeText);
        System.out.println(System.currentTimeMillis() - g);
    }

    /**
     * Метод concat!
     */
    public static void readConcat(File file) throws IOException {
        long g = System.currentTimeMillis();
        BufferedReader reader = null;

        reader = new BufferedReader(new FileReader(file));

        String wholeText = "";
        String line;

        while ((line = reader.readLine()) != null) {
            wholeText.concat(line);
            System.out.println(line);
        }

        process(wholeText);
        System.out.println(System.currentTimeMillis() - g);
    }

    /**
     * Класс StringBuffer
     */
    public static void readStringBuffer(File file) throws IOException {
        long g = System.currentTimeMillis();
        BufferedReader reader = null;

        reader = new BufferedReader(new FileReader(file));

        StringBuffer wholeText = new StringBuffer();
        String line;

        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            wholeText.append(line);
        }

        process(wholeText.toString());
        System.out.println(System.currentTimeMillis() - g);
    }

    /**
     * StringBuilder
     */
    public static void readStringBuilder(File file) throws IOException {
        long g = System.currentTimeMillis();
        BufferedReader reader = null;

        reader = new BufferedReader(new FileReader(file));

        StringBuilder wholeText = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            wholeText.append(line);
        }

        process(wholeText.toString());
        System.out.println(System.currentTimeMillis() - g);
    }

    public static void process(String text) {
        // Do smth. here
    }
}