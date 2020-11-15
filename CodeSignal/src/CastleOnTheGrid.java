package HackerRank;

import java.util.*;
import java.util.stream.Collectors;

public class CastleOnTheGrid {
    static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> tempList = new LinkedList<>();
        for (int i = 0; i < grid[0].length(); i++) {
            for (int j = 0; j < grid.length; ++j) {
                if (grid[i].charAt(j) == '.' && i != j) {
                    tempList.add(j);
                    map.put(i, tempList);
                }
            }
        }
        for (int j = 0; j < grid.length; ++j) {
            for (int i = 0; i < grid[0].length(); i++) {
                if (grid[i].charAt(j) == '.' && i != j) {
                    tempList.add(j);
                    map.put(j, tempList);
                }

            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String[] xx = {".X.", ".X.", "..."};
        minimumMoves(xx, 0, 1, 0, 2);
    }
}
