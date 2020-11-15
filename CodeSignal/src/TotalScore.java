package Amazon;

import java.util.*;

//23280666682267
//Your TEST ID for this test is 23280666682267
public class TotalScore {
    public int totalScore(int num, List<String> blocks)
    {
        // WRITE YOUR CODE HERE
        int totalScore=0;
        //create a stack to keep the scores
        Stack<Integer>stack=new Stack<>();
        for (int i=0;i<blocks.size();++i){
            String score =blocks.get(i);
            if(score=="X"){
                //get the last score from stack
                //and double it and again push it back to stack
                stack.push(stack.peek()*2);
            }
            else if(score=="+"){
                //pop the last item from stack
                //peek the second top from stack
                //calcuate the value and first push back the top and after that push the value
                int top=stack.pop();
                int value=stack.peek()+top;
                stack.push(top);
                stack.push(value);
            }else if(score=="Z"){
                //pop the last item from stack
                stack.pop();
            }
            else{
                stack.push(Integer.valueOf(score));
            }
        }
        //after pushing all the scores in the stack calculate the total
        while (!stack.isEmpty()){
            totalScore+=stack.pop();
        }
        return totalScore;
    }




    public static void main(String[] args) {
        List<String> x = Arrays.asList("5","-2","4","Z","X","9","+","+");
        TotalScore n=new TotalScore();
        n.totalScore(8,x);

    }
}
