package HackerRank;


import java.util.Collections;

public class NewYearChaos {
    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int temp = 0;
        int BribesCount = 0;
        Boolean flag = true;
        for (int i = q.length-1; i >=0; --i) {
            if(q[i] != i+1) {

                if (i>=2&&q[i - 2] == i + 1 ) {
                    BribesCount++;
                    temp=q[i-2];
                    q[i-2]=q[i-1];
                    q[i-1]=temp;
                } if( i>=1&&q[i - 1] == i + 1){
                    //swap(q[i-1],q[i-2])
                    BribesCount++;
                    temp=q[i-1];
                    q[i-1]=q[i];
                    q[i]=temp;
                }
                else {
                    System.out.println("Too chaotic");
                    flag = false;
                    break;
                   //
                }
            }
        }
    if(flag == true)
        System.out.println(BribesCount);
//        for (int i = 0; i < q.length; ++i) {
//            if (q[i] > i + 3) {
//                System.out.println("Too chaotic");
//                flag = false;
//            }
//        }
//        if (flag == true) {
//            //for (int i = 0; i < q.length; ++i) {
//            //int i = 0;
//            // while(q[i]!=i+1) {
//            for (int i = 0; i < q.length; ++i) {
//                if (q[i] > i + 1) {
//                    BribesCount++;
//                    temp = q[i];
//                    q[i] = q[i + 1];
//                    q[i + 1] = temp;
//                } else if (q[i] < i + 1) {
//                    BribesCount++;
//                    temp = q[i];
//                    q[i] = q[i - 1];
//                    q[i - 1] = temp;
//                }
//                //  i++;
//            }
//        }
//        System.out.println(BribesCount);
//        //}
    }

    public static void main(String[] args) {
        int[] q = {2, 5, 1, 3, 4};
        int[] q2 = {2, 1, 5, 3, 4};
        int[] q3={1 ,2 ,5 ,3 ,7 ,8 ,6 ,4};
        minimumBribes(q);
        //System.out.println(""+minimumBribes(q););
    }

}
