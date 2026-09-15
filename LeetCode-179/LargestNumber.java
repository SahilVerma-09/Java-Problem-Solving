import java.util.Arrays;

public class LargestNumber {
    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{3,30,34,5,9}));
    }
    public static String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(arr, (a,b) -> (b + a).compareTo(a + b));

        if(arr[0] == "0") return "0";
        
        StringBuilder sb = new StringBuilder();

        for(String s : arr) {
            sb.append(s);
        }

        return sb.toString();
    }
}
