package Test;
// add all the 0 elements to the end of Array
//time & Space :0(n)
public class ReOrder {
    public static int[] reOrder(int[] arr){
        int[] newArr = new int[arr.length];
        int p=0;
        for(int i=0;i<arr.length;++i){
            if(arr[i] != 0){
                newArr[p++] = arr[i];
            }
        }
        return newArr;
    }

    public static void main(String[] args) {
        int[] testData= {24,0,10,2,3,0,5,0,0,12,13};
        int[] res =reOrder(testData);
        for(int item:res){
            System.out.print(item +",");
        }
    }
}

