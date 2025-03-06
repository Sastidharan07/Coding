//Question:https://leetcode.com/problems/jewels-and-stones/description/
int numJewelsInStones(char* jewels, char* stones) {
     int c=0;
        for(int i=0;i<strlen(jewels);i++){
            for(int j=0;j<strlen(stones);j++){
                if(jewels[i]==stones[j]){
                    c++;
                }
            }
        }
        return c;
    }
