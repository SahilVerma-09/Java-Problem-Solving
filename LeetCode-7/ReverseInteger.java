public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(463847412));
    }
    public static int reverse(int x) {
        int num = x > 0 ? x : -x;
        long result = 0;
        while(num > 0) {
            int digit = num%10;
            
            if(result > Integer.MAX_VALUE/10 || result == Integer.MAX_VALUE/10 && digit > 7) {
                return 0;
            }

            result = result * 10 + digit;
            num /= 10;
        }

        return (int)(x > 0 ? result : -result); 
    }
}
