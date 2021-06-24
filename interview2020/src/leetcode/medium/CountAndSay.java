package leetcode.medium;

public class CountAndSay {
    public String countAndSay(int n) {
        String curr = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            char c = curr.charAt(0);
            for (int j = 1; j < curr.length(); j++) {
                if(c==curr.charAt(j)){
                 count++;
                 continue;
                }
                sb.append(count);
                sb.append(c);
                count =1;
                c = curr.charAt(j);
            }
            sb.append(count);
            sb.append(c);
            curr = sb.toString();

        }
        return curr;
    }


}
