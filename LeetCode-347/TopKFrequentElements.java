import java.util.ArrayList;
import java.util.List;

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

        List<Integer>[] frequencyArray = new List[maxFrequency + 1];
        for(int i=0 ; i<= maxFrequency; i++) {
            frequencyArray[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < map.length; i++) {
            if(map[i] == 0) continue;
            
            int actualNum = i + min;
            int frequency = map[i];
            frequencyArray[frequency].add(actualNum);
        }

        int[] result = new int[k];
        int index = 0;

        for(int i = frequencyArray.length - 1; i >= 0; i--) {
            List<Integer> list = frequencyArray[i];

            for(int num : list) {
                result[index++] = num;
                if(index == k) return result;
            }
        }

        return result;

    }
}
