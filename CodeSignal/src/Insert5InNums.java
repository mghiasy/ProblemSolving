// insert number 5 in the digits to create the least possible

public class Insert5InNums {
    public static int solution(int N) {
        // write your code in Java SE 8
        String[] num = String.valueOf(N).split("");
        StringBuilder sb= new StringBuilder();
        int j=0;
        if(!num[0].equals("-")){
            while (j<num.length){
                if(Integer.parseInt(num[j])>5){
                    sb.append(num[j]);
                    j++;
                }
                else{
                    sb.append(5);
                    break;
                }
            }
        }else{
            j=1;
            sb.append("-");
            while (j<num.length){
                if(Integer.parseInt(num[j])<5){
                    sb.append(num[j]);
                    j++;
                }
                else{
                    sb.append(5);
                    break;
                }
            }

        }

        for(int k=j;k<num.length;++k){
            sb.append(num[k]);
        }
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(solution(-990));
    }
}
