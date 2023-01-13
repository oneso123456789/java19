import java.util.Arrays;
import java.util.stream.Stream;

class procession {
    public static int solution(int storey) {
        int answer = 0;
        int[] aa = convertIntToArray(storey);
        for (int i = aa.length - 1; i >= 0; i--) {
            System.out.println("배열" + Arrays.toString(aa));
            System.out.println("현재 a값:" + aa[i]);
            int cal = Math.abs((10 - aa[i]));
            System.out.println("cal:" + cal);
            if (cal < 6 && i != 0) {
                answer += cal;
                System.out.println("if 에서 answer" + answer);
                aa[i - 1] += 1;
            } else if (cal < 6) {
                answer += cal + 1;
                System.out.println("else if 에서 도는 answer" + answer);
            } else {
                answer += aa[i];
                System.out.println("else 에서 도는 answer" + answer);
            }
        }
        return answer;
    }

    public static int[] convertIntToArray(int number) {

        return Stream.of(String.valueOf(number).split("")).mapToInt(Integer::parseInt).toArray();
    }

    public static void main(String[] args) {
        System.out.println(solution(95));
    }
}
