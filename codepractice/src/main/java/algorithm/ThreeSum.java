package algorithm;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println("第一种解法：");
        System.out.println(threeSum1(nums));

        System.out.println("第二种解法：");
        System.out.println(threeSum2(nums));

    }

    public static List<List<Integer>> threeSum1(int[] nums) {
        if(nums ==null || nums.length == 0){
            return new ArrayList();
        }
        List<List<Integer>> resultList = new ArrayList();
        //要先对数组进行排序
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            //重复的过滤掉
            if(i>0 && nums[i] == nums[i-1])
                continue;
            Map<Integer,Integer> targetMap = new HashMap<>();
            for(int j=i+1;j<nums.length;j++){
                if(targetMap.containsKey(nums[j])){
                    if(targetMap.get(nums[j]) == 0){
                        resultList.add(Arrays.asList(nums[i],nums[j],-nums[i] - nums[j]));
                        targetMap.put(nums[j],1);
                    }
                }else{
                    targetMap.put(-nums[i] - nums[j],0);
                }
            }
        }
        return resultList;
    }

    /**
     * 排序+双指针
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

}
