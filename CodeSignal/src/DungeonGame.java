public class DungeonGame {
    public static void main(String[] args) {
//        int[][] d = new int[][]{
//                {-2, -3, 3},//7
//                {-5, -10, 1},
//                {10, 30, -5}
//        };
//        int[][] d = new int[][]{
//                {1, -3, 3},//3
//                {0, -2, 0},
//                {-3, -3, -3}
//        };
//        int[][] d = new int[][]{
//                {0,5},//1
//                {-2,-3},
//        };

//        int [][] d =  new int[][]{
//                {0,-3}//4
//        };

//        int [][] d =  new int[][]{
//                {-1,1}//2
//        };

//        int[][] d = new int[][]{
//                {-3, 5}//4
//        };

//        int[][] d = new int[][]{
//               {100}//1
//        };

//        int[][] d = new int[][]{
//                {2,1},//1
//                {1,-1}
//        };

//        int[][] d = new int[][]{
//                {3,-20,30},//1
//                {-3,4,0}
//        };
        int [][] d =  new int[][]{
                {1,-2,3},
                {2,-2,-2}
        };
        int xx = calculateMinimumHP(d);
        System.out.println("answer : " + xx);
    }

    public static int calculateMinimumHP(int[][] dungeon) {

        int k1 = 0, k2 = 0, size1 = dungeon.length - 1, size2 = dungeon[0].length - 1, init = 1;
        if (dungeon[0][0] <= 0) {
            init = Math.abs(dungeon[0][0]) + 1;
        }
        //create weight array
        int tempSum = 0;
        int[][] weightArray = new int[size1 + 1][size2 + 1];
        weightArray[0][0] = dungeon[0][0];
        for (int i = 1; i <= size1; i++) {
            weightArray[i][0] = weightArray[i - 1][0] + dungeon[i][0];
        }
        for (int j = 1; j <= size2; j++) {
            weightArray[0][j] = weightArray[0][j - 1] + dungeon[0][j];
        }
        for (int i = 1; i <= size1; i++) {
            for (int j = 1; j <= size2; j++) {
                if (Math.abs(weightArray[i - 1][j] + dungeon[i][j]) < Math.abs(weightArray[i][j - 1] + dungeon[i][j])) {
                    weightArray[i][j] = weightArray[i - 1][j] + dungeon[i][j];
                    tempSum = dungeon[i - 1][j];
                } else if (Math.abs(weightArray[i - 1][j] + dungeon[i][j]) > Math.abs(weightArray[i][j - 1]) + dungeon[i][j]) {
                    weightArray[i][j] = weightArray[i][j - 1] + dungeon[i][j];
                    tempSum = dungeon[i][j - 1];
                } else {
                    weightArray[i][j] = Math.max(weightArray[i][j - 1], weightArray[i - 1][j]) + dungeon[i][j];
                }
                if (tempSum < 0 && Math.abs(tempSum)>init) {
                   // init = Math.abs(tempSum);
                }
            }
        }
        int sum = weightArray[size1][size2];
        System.out.println("sum" + sum);
        System.out.println("init" + init);
        if (sum > 0 && init == 1) {
            init = Math.min(sum, init);
        } else if (sum < 0) {
            init = Math.max(Math.abs(sum) + 1, init);
        }
        return init;
    }
}
