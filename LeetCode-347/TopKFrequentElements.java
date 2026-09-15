public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] result = topKFrequent(new int[] {1,2,1,2,1,2,3,1,3,2}, 2);
        for(int num : result) {
            System.out.print(num +" ");
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        if(k == 1 && nums.length == 1) return nums;

        int min = nums[0];
        int max = nums[0];

        for(int num : nums) {
            min = num < min ? num : min;
            max = num > max ? num : max;
        }

        int[] map = new int[max - min + 1];
        int maxFrequency = 0;
        for(int num : nums) {
            int index = num - min;
            map[index]++;

            maxFrequency = maxFrequency < map[index] ? map[index] : maxFrequency;
        }
        int[] frequencyArray = new int[maxFrequency + 1];
        for(int i = 0; i < map.length; i++) {
            if(map[i] == 0) continue;
            frequencyArray[map[i]] = i + min;
        }

        int[] result = new int[k];

        int freqIndex = frequencyArray.length - 1;
        int index = 0;

        while(index < k) {
            if(frequencyArray[freqIndex] != 0){
                result[index++] = frequencyArray[freqIndex];
            }
            freqIndex--;
        }

        return result;

    }
}
