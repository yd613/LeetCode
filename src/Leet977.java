public class Leet977 {

    public static void main(String[] args) {
        Leet977 leet = new Leet977();
        int[] result = leet.sortedSquares(new int[]{-7,-3,2,3,11});
        for (int a :result){
            System.out.println(a);
        }
    }

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
