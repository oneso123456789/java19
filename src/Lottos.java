import java.util.Arrays;

public class Lottos {

    public static int[] solution(int[] lottos, int[] win_num) {
        int[] answer = new int[2];
        int wildcard = 0;
        int hitCount = 0;


        for (int i : lottos) {
            if (i == 0) {
                wildcard++;
            }
            for (int j : win_num) {
                if (i == j) {
                    hitCount++;
                }
            }
        }

        answer[0] = cal(hitCount + wildcard);
        answer[1] = cal(hitCount);

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19})));

    }

    public static int cal(int i) {

        return switch (i) {
            case 6 -> 1;
            case 5 -> 2;
            case 4 -> 3;
            case 3 -> 4;
            case 2 -> 5;
            default -> 6;
        };
    }
}
