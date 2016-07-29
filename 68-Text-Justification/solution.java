public class Solution {
    public List<String> fullJustify(String[] words, int L) {
        List<String> res = new ArrayList<String>();
        int i = 0;
        while(i < words.length){
            int start = i;
            int sum = 0;
            while(i < words.length && sum <= L){
                sum += words[i].length() + 1;
                i ++;
            }
            if(sum - 1 > L){
                i --;
                sum -= words[i].length() + 1;
            }
            boolean isLast = i == words.length;
            int end = i - 1;
            int interval = end - start;
            int aveS = 0;
            int leftS = 0;
            if(interval > 0){
                aveS = (L - sum + interval + 1) / interval;
                leftS = (L - sum + interval + 1) % interval;
            }
            StringBuilder sb = new StringBuilder();
            for(int j = start; j < end; j++){
                sb.append(words[j]);
                if(isLast){
                    sb.append(" ");
                }else{
                    for(int k = 0; k < aveS; k++){
                        sb.append(" ");
                    }
                    if(leftS > 0){
                        sb.append(" ");
                        leftS --;
                    }
                }
            }
            sb.append(words[end]);
            int size = sb.length();
            for(int j = 0; j < L - size; j ++){
                sb.append(" ");
            }
            res.add(sb.toString());
        }
        return res;
    }
}