public class GetSecondHighest {
    public static int getSecondHighest(int[] inputArray){
        int maxinum= Integer.MIN_VALUE;
        int secondMax= Integer.MIN_VALUE;
//         if(inputArray.length>=2){
//             if(inputArray[0]>inputArray[1]){
//                 maxinum=inputArray[0];
//                 secondMax=inputArray[1];
//             }
//             else {
//                 maxinum=inputArray[1];
//                 secondMax=inputArray[0];
//             }
//         }
        for(int num:inputArray){
            if(num>maxinum ) maxinum=num;//19
            if(num>secondMax && num<maxinum) secondMax=num;//min
        }
return  secondMax;
    }

    public static void main(String[] args) {
        System.out.println(getSecondHighest(new int[]{10, 19, 200, 150, 99, 55, 19}));
    }
}
//{ 10,19, 200, 150, 99, 55, 19}