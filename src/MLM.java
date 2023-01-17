import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Objects;

public class MLM {

    private class Profit {
        private String referral;
        private int profit;

        public Profit() {

        }

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

        public void addProfit(int add) {
            this.profit = profit + add;
        }
    }

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        System.out.println(Arrays.toString(seller));
        LinkedHashMap<String, Profit> member = makeMemberMap(enroll, referral);
        Profit currentProfit = new Profit();
        Profit referralProfit = new Profit();

        for (int i = 0; i < seller.length; i++) {
            currentProfit = member.get(seller[i]);
            int salesAmount = (amount[i] * 100);
            currentProfit.addProfit(salesAmount);
            member.replace(seller[i], currentProfit);
        }

        for (int i = enroll.length - 1; i > -1; i--) {
            currentProfit = member.get(enroll[i]);
            if (!Objects.equals(currentProfit.getReferral(), "-")){
                referralProfit = member.get(currentProfit.referral);
                referralProfit.addProfit((int) (currentProfit.profit * 0.1));
            }
            currentProfit.setProfit((int) (currentProfit.getProfit() * 0.9));
            System.out.println("얼마를 가졌나? + " + currentProfit.profit);

        }
        member.forEach((s, profit) -> System.out.println(s + ":" + profit.profit));
        int[] answer = {};
        return answer;
    }

    private LinkedHashMap<String, Profit> makeMemberMap(String[] enroll, String[] referral) {
        LinkedHashMap<String, Profit> member = new LinkedHashMap<>();
        int cnt = 0;
        for (int i = 0; i < enroll.length; i++) {
            cnt++;
            member.put(enroll[i], new Profit(referral[i], 0));
        }
        System.out.println(cnt);
        return member;
    }

    public static void main(String[] args) {
        MLM mlm = new MLM();
        System.out.println(Arrays.toString(mlm.solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"}, new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"}, new String[]{"young", "john", "tod", "emily", "mary"}, new int[]{12, 4, 2, 5, 10})));
    }


}
