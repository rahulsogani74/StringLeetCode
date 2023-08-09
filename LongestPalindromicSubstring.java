import java.util.HashMap;

public class LongestPalindromicSubstring {
    /*
    isme sbse bde word ko banan h jisko aage ya piche se pdne pr vh same pda jaae...
    isme even number ke sbhi Character lene h or odd me first jo odd number
    aata h vh to esa ka esa hi le lege baki ke jo odd number aate h vh even baar lege mtlb odd Character
    ko even me bdl dege mtlb 1 ghta kr le lege
    */
    public int longestPalindrome(String s){
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i =0; i<s.length(); i++){
            char c = s.charAt(i);
            if (map.containsKey(c)) map.put(c, map.get(c) +1);
            else map.put(c,1);
        }
        int ans = 0;
        boolean isFirstOdd = false;
        for (Character key : map.keySet()){
            if (map.get(key)%2 == 0){
                ans += map.get(key);
            }else {
                if (isFirstOdd == false){
                    ans += map.get(key);
                    isFirstOdd = true;
                } else ans += map.get(key)-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();

        String input1 = "abccccdd";
        int length1 = solution.longestPalindrome(input1);
        System.out.println("Longest Palindromic Length for '" + input1 + "': " + length1);
        String input2 = "abcabc";
        int length2 = solution.longestPalindrome(input2);
        System.out.println("Longest Palindromic Length for '" + input2 + "': " + length2);
        String input3 = "aacccdddddbb";
        int length3 = solution.longestPalindrome(input3);
        System.out.println("Longest Palindromic Length for '" + input3 + "': " + length3);
    }
}
