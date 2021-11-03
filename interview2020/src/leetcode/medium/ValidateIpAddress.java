package leetcode.medium;

public class ValidateIpAddress {
    public String validIPAddress(String IP) {
        if (IP == null || IP.length() == 0) return "Neither";
        if (IP.contains(":")) {
            return validateIPv6(IP);
        }
        return validateIPv4(IP);
    }

    private String validateIPv6(String IP) {
        if (IP.charAt(IP.length() - 1) == ':') return "Neither";
        String[] ipSplit = IP.split(":");
        if (ipSplit.length == 0 || ipSplit.length > 8) return "Neither";
        for (String part : ipSplit) {
            if (part.length() < 1 || part.length() > 4) return "Neither";
            for (char c : part.toCharArray()) {
                if (c >= 'a' && c <= 'f') continue;
                if (c >= 'A' && c <= 'F') continue;
                if (c >= '0' && c <= '9') continue;
                return "Neither";
            }

        }
        return "IPv6";
    }

    private String validateIPv4(String IP) {
        //12.45.5.6. --java trims trailing empty splits
        if (IP.charAt(IP.length() - 1) == '.') return "Neither";
        // . represents any character. So, we need to escape it
        String[] ipSplit = IP.split("\\.");
        // split length should be 4
        if (ipSplit.length != 4) return "Neither";
        for (String part : ipSplit) {
            if (part.length() == 0 || part.length() > 3) return "Neither";
            int total = 0;
            for (int i = 0; i < part.length(); i++) {
                char c = part.charAt(i);
                // false for  123.05.45.32
                if (i == 0 && c == '0' && part.length() > 1) return "Neither";
                // false for  123.y5.45.32
                if (c < '0' || c > '9') return "Neither";
                int num = c - '0';
                total = total * 10 + num;
            }
            // false for  123.544.45.32
            if (total > 255) return "Neither";

        }
        return "IPv4";
    }
}
