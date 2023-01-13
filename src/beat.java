public class beat {
    public static int solution(int n, long l, long r) {
        return (convert(r) - convert(l - 1));
    }

    public static int convert(long n) {
        if (n <= 5) {
            return "11011".substring(0, (int) n).replaceAll("0", "").length();
        }

        long base = 1;
        while ((long) Math.pow(5, (base + 1)) < n) {
            base += 1;
        }

        long section = (long) (n / (Math.pow(5, base)));
        long remainder = (long) (n % (Math.pow(5, base)));
        long answer = (long) (section * (Math.pow(4, base)));

        if (section >= 3) {
            answer -= (Math.pow(4, base));
        }

        if (section == 2) {
            return (int) answer;
        } else {
            return (int) (answer + convert(remainder));
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(1, 1, 5));

    }
}
