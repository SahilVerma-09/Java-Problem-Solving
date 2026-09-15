public class KthLargestNum {
    public static void main(String[] args) {
        System.out.println(findKthLargestV2(new int[] {-1,-50,-3}, 2));
    }
    public static int findKthLargest(int[] nums, int k) {
        int largest = nums[0];

        for(int num : nums) {
            num = num < 0 ? -num : num;
            if(num > largest)
                largest = num;
        }

        if(k == 1) return largest;

        int[] map = new int[(largest*2) + 1];

        for(int num : nums) {
            map[num + largest]++;
        }

        for(int i = largest*2; i >= 0; i--) {
            if(map[i] >= k) {
                return i - largest;
            } else {
                k -= map[i];
            }
        }

        return 0;
    }  

    public static int findKthLargestV2(int[] nums, int k) {
        if(k == 1 && nums.length == 1) return nums[0];

        int min = nums[0];
        int max = nums[0];
        
        for(int num : nums) {
            min = num < min ? num : min;
            max = num > max ? num : max;
        }

        int[] map = new int[max - min + 1];

        for(int num : nums) {
            map[num - min]++;
        }

        for(int i = 0; i >= 0; i--) {
            if(k - map[i] <= 0) return i + min;

            k -= map[i];
        }

        return 0;
    }
}
