package leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EncodeAndDecodeTinyURL {
    //https://leetcode.com/problems/encode-and-decode-tinyurl/solution/
    // Approach 5
    // Encodes a URL to a shortened URL.
    Map<String, String> memo = new HashMap<>();
    String base62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Random random = new Random();
    String key = getRandom();

    public String encode(String longUrl) {
        while (memo.containsKey(key)) {
            key = getRandom();
        }
        memo.put(key, longUrl);
        return "https://tinyurl.com/" + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String key = shortUrl.split("/")[3];
        return memo.get(key);

    }

    private String getRandom() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(base62.charAt(random.nextInt()));
        }
        return sb.toString();
    }
}
