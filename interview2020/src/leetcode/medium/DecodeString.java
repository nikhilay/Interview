package leetcode.medium;

import java.util.Stack;

public class DecodeString {
    //https://leetcode.com/problems/decode-string/discuss/87534/Simple-Java-Solution-using-Stack
    public String decodeString(String s) {
        Stack<String>  resultStack= new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        String result = "";
        int pos = 0;
        while (pos < s.length()) {
            char c = s.charAt(pos);
            if(Character.isDigit(c)){
                int count = 0;
                while(Character.isDigit(c)){
                    count = count * 10 + c - '0';
                    pos++;
                    c = s.charAt(pos);
                }
                countStack.push(count);
            } else if(c=='['){
                resultStack.push(result);
                pos++;
                result = "";
            } else if(c==']'){
                int rep = countStack.pop();
                StringBuilder sb = new StringBuilder();
                sb.append(resultStack.pop());
                while(rep!=0){
                    sb.append(result);
                    rep--;
                }
                pos++;
                result = sb.toString();

            } else {
                result += c;
                pos++;
            }



        }
        System.out.println(countStack.size());
    return result;
    }
}
