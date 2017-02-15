package mylittleplays;

public class MoneyInLong {

    public static void main(String[] args) {

        final long vsego = 422000;

        final long sniatRub = 125;

        final long sniatKopek = 65;

        final MoneyInLong r = new MoneyInLong();

        System.out.print("У Вас было " + vsego + " рублей");

        System.out.println(", Вы сняли " + sniatRub + "." + sniatKopek + "");

        System.out.print("На счету осталось " + r.getRubasy(vsego, sniatRub, sniatKopek)[0]);

        System.out.println(" рублей " + r.getRubasy(vsego, sniatRub, sniatKopek)[1] + " копеек.");
    }


    public int div(final int q, final int e) {
        return q / e;

    }

    public long[] getRubasy(final long vsego, final long sniatRub, final long sniatKopek) {

        assert vsego > 0;

        assert sniatRub > 0;

        final long vKopeykah = 100;

        long[] result = new long[2];

        result[0] = (vsego * vKopeykah - (sniatRub * vKopeykah)) / vKopeykah;

        if (sniatKopek > 0) {
            --result[0];
        }

        result[1] = vKopeykah - sniatKopek;

        return result;

    }
}
