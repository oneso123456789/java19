import java.util.Arrays;
import java.util.LinkedHashMap;

public class MLM {

    public class Profit {
        public Profit(String referral, int profit) {
            this.referral = referral;
            this.profit = profit;
        }

        public String getReferral() {
            return referral;
        }

        public void setReferral(String referral) {
            this.referral = referral;
        }

        public int getProfit() {
            return profit;
        }

        public void setProfit(int profit) {
            this.profit = profit;
        }

        private String referral;
        private int profit;


    }

    public int[] solution(String[] enroll, String[] referral,
                          String[] seller, int[] amount) {
        LinkedHashMap<String, Profit> hashMap = new LinkedHashMap<String, Profit>();
        System.out.println(Arrays.toString(enroll));
        for (int i = 0; i < enroll.length - 1; i++) {
            hashMap.put(enroll[i], new Profit(referral[i], 0));
        }

        hashMap.forEach((s, profit) -> System.out.println(s + " : " + profit.referral + "&" + profit.profit));

        int[] answer = {};
        return answer;
    }

    public static void main(String[] args) {
        MLM mlm = new MLM();
        System.out.println(Arrays.toString(mlm.solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"}
                , new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                new String[]{"young", "john", "tod", "emily", "mary"},
                new int[]{12, 4, 2, 5, 10})));
    }


}
