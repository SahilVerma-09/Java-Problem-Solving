public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(8));
    }
    public static String countAndSay(int n) {
        if(n == 1) return "1";

        String s = countAndSay(n - 1);

        return frequencyCounter(s).toString();

    }

    // public String helper(int n) {
    //     if(n == 1) return "1";


    // }

    public static String frequencyCounter(String s) {
        // int[] fCounter = new int[30];
        // for(int i = 0; i < s.length(); i++) {
        //     fCounter[s.charAt(i) - '0']++;
        // }
        // StringBuilder result = new StringBuilder();
        // for(int i = 0; i < s.length(); i++) {
        //     int num = s.charAt(i);
        //     if(fCounter[num] > 0) {
        //         resullt.append(fCounter[num]).append(num);
        //         fCounter[num] = 0;
        //     }
        // }
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < s.length();) {
            int counter = 1;
            int currentNum = s.charAt(i) - '0';
            i+=1;

            while(i < s.length() && (s.charAt(i) - '0') == currentNum) {
                counter++;
                i++;
            }

            result.append(counter).append(currentNum);
            counter = 0;
        }

        return result.toString();
    }
}
