//Question : https://leetcode.com/problems/vowels-game-in-a-string/description/
class Solution
{
    public boolean doesAliceWin(String s)
    {
        for(int i=0, l=s.length(); i<l; i++)
            switch(s.charAt(i))
            {
                case 'a', 'e', 'i', 'o', 'u' -> {return true;}
                default -> {}
            }

        return false;
    }
}
