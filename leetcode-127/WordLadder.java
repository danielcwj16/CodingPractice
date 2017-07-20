
/**
 * 运用BFS查找最短路径；
 * PS：DFS可用来查找是否存在路径
 */
import java.util.*;

public class WordLadder{
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.length()==0 || endWord.length()==0 || beginWord == null || endWord == null || beginWord.length() != endWord.length())
            return 0;
        HashSet<String> set = new HashSet<String>();
        for(String st : wordList){
            set.add(st);
        }
        ArrayList<String> wordQueue = new ArrayList<String>();
        int level = 1;
        int currnum = 1;
        int nextnum = 0;
        wordQueue.add(beginWord);
        
        while(wordQueue.size()!= 0){
            String word = wordQueue.get(0);
            wordQueue.remove(0);
            currnum--;
            
            for(int i =0;i<word.length();i++){
                char[] wordarray = word.toCharArray();
                for(char j ='a';j<='z';j++){
                    wordarray[i] = j;
                    
                    String newword = new String(wordarray);
                    
                    if(newword.equals(endWord)&&set.contains(newword))
                        return level+1;
                    if(set.contains(newword)){
                        wordQueue.add(newword);
                        nextnum++;
                        set.remove(newword);                      
                    }
                }                
                }
            if(currnum == 0){
                    currnum = nextnum;
                    nextnum =0;
                    level++;
            }
        }
        return 0;
    }
}