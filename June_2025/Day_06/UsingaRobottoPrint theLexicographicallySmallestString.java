//Question : https://leetcode.com/problems/using-a-robot-to-print-the-lexicographically-smallest-string/description/
class Solution {    
    public String robotWithString(String s) {
        int alpha[] = new int[26];
        for(char ch: s.toCharArray()){
            alpha[ch-'a']++;
        }

        StringBuffer p = new StringBuffer();
        StringBuffer t = new StringBuffer();
        // solve(s, p, t, alpha);

        char ch = '\u0000';
        for(int i=0; i<26; i++){
            if(alpha[i] > 0){
                ch = (char)(i+'a');
                break;
            }
        }

        for(char c: s.toCharArray()){
            t.append(c);
            alpha[c-'a']--;
            if(c == ch){
                if(alpha[ch-'a'] <= 0){
                    for(int i=0; i<26; i++){
                        if(alpha[i] > 0){
                            ch = (char)(i+'a');
                            break;
                        }
                    }
                }

                while(t.length() > 0){
                    int i = t.length()-1;
                    char tc = t.charAt(i);

                    if(ch < tc){
                        break;
                    }
                    t.deleteCharAt(i);
                    p.append(tc);
                }
            }
        }

        p.append(t.reverse());

        return p.toString();
    }
}
