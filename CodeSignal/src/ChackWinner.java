package Amazon;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class ChackWinner {
    public static int checkWinner(List<List<String>> codeList,
                           List<String> shoppingCart) {
        // WRITE YOUR CODE HERE

        List<String> newList=codeList.stream().flatMap(Collection::stream).collect(Collectors.toList());
        int length=shoppingCart.size()-newList.size();
        if(length<0){
            return 0;
        }
        else if(length==0){
            for(int i=0;i<newList.size();++i){
                if(!newList.get(i).equals(shoppingCart.get(i)) && !newList.get(i).equals("anything") ){
                    return 0;
                }
            }
            return 1;
        }
        else {//different >0
            boolean flag1=true,flag2=true;
            List<String> shopingCart1= shoppingCart.subList(0,shoppingCart.size()-length-1);
            List<String> shopingCart2= shoppingCart.subList(length,shoppingCart.size()-1);
            for(int i=0;i<newList.size();++i){
                if(!newList.get(i).equals(shopingCart1.get(i))){
                    flag1=false;
                }
            }
            for(int i=0;i<newList.size();++i){
                if(!newList.get(i).equals(shopingCart2.get(i))){
                    flag2=false;
                }
            }


            return (flag1 || flag2) ? 1:0;

        }
    }


    public static void main(String[] args) {
        String x="qq qq";
        String[] cc= x.split("\\r?\\n");


        System.out.println(x);
    }
}
