public class ValidAnagram {
    public static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        int[] charCount = new int[26];

        for (char c : a.toCharArray()) {
            charCount[c - 'a']++;
        }
        for (char c : b.toCharArray()) {
            charCount[c - 'a']--;
        }
        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String a = "listen";
        String b = "silent";
        System.out.println(isAnagram(a, b));
    }
}
