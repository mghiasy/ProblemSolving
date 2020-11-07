public class MatrixBuilder {
    public String matrixBuilder(int U,int L, int[] C){
        // write your code in Java SE 8
        StringBuilder cb1 = new StringBuilder();
        StringBuilder cb2 = new StringBuilder();

        for(int i = 0; i < C.length; i++){
            if(C[i]==2){
                cb1.append(1);
                cb2.append(1);
                U--;
                L--;
                continue;
            } else if(C[i]==0){
                cb1.append(0);
                cb2.append(0);
                continue;
            }else if(C[i]==1 && U>=1){
                cb1.append(1);
                cb2.append(0);
                U--;
                continue;
            }else if(C[i]==1 && L>=1){
                cb1.append(0);
                cb2.append(1);
                L--;
            }
            else{
                return "IMPOSSIBLE";
            }
        }

        StringBuilder cb = new StringBuilder();
        cb.append(cb1);
        cb.append(",");
        cb.append(cb2);

        return cb.toString();
    }
}
