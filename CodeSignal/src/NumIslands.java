package LeetCode;

import java.util.Stack;
//time: o(M*N) => M:no of rows, N:no of cols
//space o(2N*M) =>size of stack = count of 1, in worse case all of them are 1

//Runtime: 5 ms, faster than 17.87% of Java online submissions for Number of Islands.
//Memory Usage: 42 MB, less than 76.79% of Java online submissions for Number of Islands.
public class NumIslands {
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        Stack<int[]> st= new Stack<>();
        int x=0,y=0,islandCount=0;
        int[] popItem=new int[2];
        for(int i=0;i<grid.length;++i){//no of rows
            for(int j=0;j<grid[0].length;++j){//no of cols
                if(grid[i][j]=='1'){
                    st.push(new int[]{i,j});
                    grid[i][j]='0';
                    islandCount++;
                }
                while (!st.isEmpty()){//will executed to the (number of 1)/4, worse case all of them are 1
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

    //modularize
    //Runtime: 4 ms, faster than 25.59% of Java online submissions for Number of Islands.
    //Memory Usage: 41.5 MB, less than 98.71% of Java online submissions for Number of Islands.
    public static int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
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
                    helperMethod(grid,st,x+1,y);
                    helperMethod(grid,st,x-1,y);
                    helperMethod(grid,st,x,y+1);
                    helperMethod(grid,st,x,y-1);
                }
            }
        }
        return islandCount;
    }
    public static void helperMethod(char[][] grid,Stack<int[]> st,int x,int y){
        if(x<grid.length && y<grid[0].length && x>=0 && y>=0 && grid[x][y]=='1') {
            st.push(new int[]{x, y});
            grid[x][y] = '0';
        }
    }


    //recursive
    //Runtime: 1 ms, faster than 99.93% of Java online submissions for Number of Islands.
    //Memory Usage: 41.6 MB, less than 97.70% of Java online submissions for Number of Islands.
    public static int numIslands3(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int islandCount=0;
        int[] popItem=new int[2];
        for(int i=0;i<grid.length;++i){//no od rows
            for(int j=0;j<grid[0].length;++j){
                if(grid[i][j]=='1'){
                    islandCount++;
                    helperMethod2(grid,i,j);
                }
            }
        }
        return islandCount;
    }
    public static void helperMethod2(char[][] grid,int x,int y){
        //recursive func should have return for base
        if(x>=grid.length || y>=grid[0].length || x<0 || y<0 || grid[x][y]=='0')
            return;
       // if(x<grid.length && y<grid[0].length && x>=0 && y>=0 && grid[x][y]=='1') {
            grid[x][y] = '0';
            helperMethod2(grid,x+1,y);
            helperMethod2(grid,x-1,y);
            helperMethod2(grid,x,y+1);
            helperMethod2(grid,x,y-1);
        //}
    }

    public static void main(String[] args) {
        char[][] xx= {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        System.out.println(numIslands3(xx));
    }
}
