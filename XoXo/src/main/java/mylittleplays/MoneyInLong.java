package mylittleplays;

public class MoneyInLong {
    public static void main(String[] args) {
        MoneyInLong r = new MoneyInLong();
        System.out.println("осталось " + r.getRubasy(100, 49.95));


    }
    public int div (int q, int e) {
        return q/e;

    }

    private double getRubasy(long vsego, double sniat) {
        assert vsego > 0;
        assert sniat > 0;
        long kopek = vsego * 100;
        System.out.print("Было " + kopek / 100);
        long kope2 = (long) (sniat * 100);
        System.out.println(", Вы сняли " + sniat);

        return ((double) (kopek - kope2)) / 100;

    }
}
