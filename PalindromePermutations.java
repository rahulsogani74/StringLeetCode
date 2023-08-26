import java.util.ArrayList;
import java.util.List;
public class PalindromePermutations {
    public List<String> generatePalindromes(String s) {
        List<String> result = new ArrayList<>();
        int[] count = new int[256];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        char oddChar = '\0';
        StringBuilder mid = new StringBuilder();
        for (int i = 0; i < 256; i++) {
            if (count[i] % 2 != 0) {
                if (oddChar != '\0') {
                    return result;
                }
                oddChar = (char) i;
                count[i]--;
            }
            while (count[i] > 0) {
                mid.append((char) i);
                count[i] -= 2;
            }
        }
        generatePermutations(result, mid.toString(), "", oddChar);
        return result;
    }
    private void generatePermutations(List<String> result, String s, String current, char oddChar) {
        if (s.isEmpty()) {
            String left = current;
            String right = new StringBuilder(current).reverse().toString();
            result.add(left + (oddChar != '\0' ? oddChar : "") + right);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            generatePermutations(result, s.substring(0, i) + s.substring(i + 1), current + s.charAt(i), oddChar);
        }
    }
    public static void main(String[] args) {
        PalindromePermutations pp = new PalindromePermutations();
        String s = "aabb";
        List<String> palindromes = pp.generatePalindromes(s);
        for (String palindrome : palindromes) {
            System.out.println(palindrome);
        }
    }
}
