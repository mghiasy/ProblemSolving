package LeetCode;

import java.util.Stack;

public class NumIslands {
    public static int numIslands(char[][] grid) {
        Stack<int[]> st= new Stack<>();
        int x=0,y=0,islandCount=0;
        int[] popItem=new int[2];
        for(int i=0;i<grid.length;++i){//no od rows
            for(int j=0;j<grid[0].length;++j){
                if(grid[i][j]=='1'){
                    st.push(new int[]{i,j});
                    grid[i][j]='0';
                    islandCount++;
                }
                while (!st.isEmpty()){
                    popItem =st.pop();
                    x=popItem[0];
                    y=popItem[1];
                    if(x+1<grid.length && grid[x+1][y]=='1'){
                        st.push(new int[]{x+1,y});
                        grid[x+1][y]='0';
                    }
                    if(x-1>=0 && grid[x-1][y]=='1'){
                        st.push(new int[]{x-1,y});
                        grid[x-1][y]='0';
                    }
                    if(y+1<grid[0].length && grid[x][y+1]=='1'){
                        st.push(new int[]{x,y+1});
                        grid[x][y+1]='0';
                    }
                    if(y-1>=0 && grid[x][y-1]=='1'){
                        st.push(new int[]{x,y-1});
                        grid[x][y-1]='0';
                    }
                }
            }
        }
        return islandCount;
    }

    public static void main(String[] args) {
        char[][] xx= {{'0','1','0'},{'1','0','1'},{'0','1','0'}};
        System.out.println(numIslands(xx));
    }
}
