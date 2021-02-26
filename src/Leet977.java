/**
 * 有序数组的平方
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 *
 * 题目：
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 * 示例1：
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]，排序后，数组变为 [0,1,9,16,100]
 *
 * 示例2：
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *
 * 进阶：
 * 请你设计时间复杂度为 O(n) 的算法解决本问题
 */

public class Leet977 {

    public static void main(String[] args) {
        Leet977 leet = new Leet977();
        int[] result = leet.sortedSquares(new int[]{-7,-3,2,3,11});
        for (int a :result){
            System.out.println(a);
        }
    }

    /**
     * 双指针法，从给定数组两端开始，比对平方后的大小，将比较大的数从后往前放进result数组，并移动指针，重复进行
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        int length = nums.length;
        if(length == 1){
            nums[0]=nums[0]*nums[0];
            return nums;
        }

        int[] result = new int[nums.length];
        int p=0,q=length-1;
        int index = length-1;
        while(index>=0){
            int a = nums[p]*nums[p];
            int b = nums[q]*nums[q];
            if(a>b){
                result[index]=a;
                p++;
            }else{
                result[index]=b;
                q--;
            }
            index--;
        }
        return result;
    }

//    /**
//     * 双指针法，在给定的数组中找到正负分界点，两个正负指针从中间向两边移动，比较所指元素的平方数大小，将较小的数一次放进result数组
//     */
//    public int[] sortedSquares(int[] nums) {
//        int length = nums.length;
//        if(length == 1){
//            nums[0]=nums[0]*nums[0];
//            return nums;
//        }
//
//        int[] result = new int[nums.length];
//        int zeroIndex = findZero(nums);
//        int minusIndex = zeroIndex;
//        int plusIndex = zeroIndex+1;
//
//        int a=0,b=0,index=0;
//        while(minusIndex != -1 || plusIndex != length){
//            if(minusIndex<=-1){
//                a = -1;
//            }else{
//                a = nums[minusIndex]*nums[minusIndex];
//            }
//            if(plusIndex>=length){
//                b = -1;
//            }else{
//                b = nums[plusIndex]*nums[plusIndex];
//            }
//
//            if(a==-1 && b == -1){
//                break;
//            }else if(a==-1){
//                result[index++]=b;
//                plusIndex++;
//            }else if(b == -1){
//                result[index++] = a;
//                minusIndex--;
//            }else{
//                if(a>b){
//                    result[index++]=b;
//                    plusIndex++;
//                }else{
//                    result[index++] = a;
//                    minusIndex--;
//                }
//            }
//        }
//        return result;
//    }
//
//    private int findZero(int[] nums){
//        int length = nums.length;
//        int index = -1;
//        for(int i = 0;i<length;i++){
//            if(nums[i] == 0){
//                return i;
//            }else if(nums[i] < 0){
//                index++;
//            }
//        }
//        return index;
//    }

}
