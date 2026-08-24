public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverseV2(-123));
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

    public static int reverseV2(int x) {
        long result = 0;
        while(x != 0) {
            int digit = x%10;

            result = result * 10 + digit;
            x /= 10;
        }

        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) return 0;

        return (int)(result); 
    }
}
