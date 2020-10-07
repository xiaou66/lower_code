package com.xiaou.leetcode.lc.array;

import org.junit.Test;

import java.util.HashSet;

/**
 * @url https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2f9gg/
 * @author xiaou
 */
public class LcIsValidSudokuTest {
    @Test
    public void test() {
        char [][] board = {{'.','.','.','.','5','.','.','1','.'},
                           {'.','4','.','3','.','.','.','.','.'},
                           {'.','.','.','.','.','3','.','.','1'},
                           {'8','.','.','.','.','.','.','2','.'},
                           {'.','.','2','.','7','.','.','.','.'},
                           {'.','1','5','.','.','.','.','.','.'},
                           {'.','.','.','.','.','2','.','.','.'},
                           {'.','2','.','9','.','.','.','.','.'},
                           {'.','.','4','.','.','.','.','.','.'}};
        System.out.println(isValidSudoku(board));
    }
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> row = new HashSet<>();
        HashSet<Character> col = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            int count = 0;
            for (int j = 0; j < board[i].length; j++) {
                int colCount = 0;
                if (board[i][j] != '.') {
                    row.add(board[i][j]);
                    count++;
                }
                // 纵向扫描
                for (int k = 0; k < board.length; k ++) {
                    if (board[k][j] != '.') {
                        col.add(board[k][j]);
                        colCount++;
                    }
                }
                if (colCount != col.size()) {
                    return false;
                }
               col.clear();
            }
            if (count != row.size()) {
                return false;
            }
            row.clear();
        }
        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board[i].length; j += 3) {
                int count = 0;
                for (int k = 0; k < 3; k++) {
                    for (int u = 0; u < 3; u++){
                        if (board[i+k][j+u] != '.') {
                            row.add(board[i+k][j+u]);
                            count++;
                        }
                    }
                }
                if (count != row.size()) {
                    return false;
                }
                row.clear();
            }
        }
        return true;
    }
}
