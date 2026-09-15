public class SortColors {
    public static void main(String[] args) {
        int[] nums = {1,1  };

        for(int num : nums) {
            System.out.print(num +" ");
        }
        sortColorsFrequencyCounter(nums);
        System.out.println();
        for(int num : nums) {
            System.out.print(num +" ");
        }
    }
    public static void sortColors(int[] nums) {
        if(nums.length == 0) return;

        int zeroThIndex = 0;
        int twoThIndex = nums.length - 1;

        while(zeroThIndex < nums.length && nums[zeroThIndex] == 0) zeroThIndex++;
        while(twoThIndex > 0 && nums[twoThIndex] == 2) twoThIndex--;

        int i = zeroThIndex;
        while(i <= twoThIndex) {
            if(nums[i] == 0) {
                int temp = nums[zeroThIndex];
                nums[zeroThIndex++] = 0;
                nums[i] = temp;
                i += nums[i] == 0 ? 1 : 0;
            } else if(nums[i] == 2) {
                int temp = nums[twoThIndex];
                nums[twoThIndex--] = 2;
                nums[i] = temp;
            } else {
                i++;
            }
        }

        return;
    }

    public static void sortColorsFrequencyCounter(int[] nums) {
        if(nums.length == 1) return;

        int[] map = new int[3];

        for(int num : nums) {
            map[num]++;
        }

        int mapIterator = 0;
        int numsIterator = 0;
        while(mapIterator < 3 && numsIterator < nums.length) {
            if(map[mapIterator] > 0) {
                nums[numsIterator++] = mapIterator;
                map[mapIterator]--;
            }

            if(map[mapIterator] == 0) mapIterator++;
        }

        return;
    }
}
