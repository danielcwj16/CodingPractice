/**
 Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/
/*
DFS深度优先搜索匹配的串，用额外的二位数组记录字符是否已被使用
*/
public class WordSearch{
  static boolean[][] visited;
  public boolean solution(char[][] board,String word){
    if(board.length ==0 || board.get(0).length == 0)
            return false;
    visited = new boolean[board.length][board.get(0).length];

    for(int i=0;i<board.length;i++){
      for(int j=0;j<board.get(0).length;j++){
        if(helper(board,word,0,i,j))
          return true;
      }
    }
    return false;
  }
  public boolean helper(char[][] board,String word,int idx,int i,int j){
      if(idx==word.length())
        return true;
      if(i<0||j<0||i>=board.length || j>=board.get(0).length||visited[i][j]==true || board[i][j]!= word.charAt(idx))
        return false;
      
      visited[i][j] = true;
      if(helper(board,word,idx+1,i-1,j)||helper(board,word,idx+1,i,j-1)||helper(board,word,idx+1,i+1,j)||helper(board,word,idx+1,i,j+1)){
        return true;
      }
      visited[i][j] = false;
      return false;
  }
}