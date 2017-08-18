/**
 * 与word ladder类似，用BFS方法
 */

public class MinimumGeneticMutation {
    public int minMutation(String start, String end, String[] bank) {
        if(start.equals(end)) return 0;
        
        LinkedList<String> queue = new LinkedList<String>();
        HashSet<String> bankset = new HashSet<String>();
        for(String s : bank){
            bankset.add(s);
        }
        int level = 0;
        HashSet<String> visited = new HashSet<String>();
        char[] chars = new char[]{'A','C','G','T'};
        
        queue.offer(start);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                String str = queue.poll();
                if(str.equals(end))
                    return level;
                
                char[] charray = str.toCharArray();
                for(int i=0;i<charray.length;i++){

                    char old =  charray[i];
                    for(char c : chars){
                        charray[i] = c;
                        String next = new String(charray);
                        if(!visited.contains(next)&&bankset.contains(next)){
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                    charray[i] = old;
                }
                
            }
            level++;
        }
        
        return -1;
    }
}