//Question : https://leetcode.com/problems/simple-bank-system/description/
class Bank {
    long[] balance;
    int len;
    public Bank(long[] balance) {
        this.balance=balance;
        len=balance.length;
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(account1<0||account1>len||account2<0||account2>len||money>balance[account1-1])
            return false;
        balance[account1-1]-=money;
        balance[account2-1]+=money;
        return true; 
    }
    
    public boolean deposit(int account, long money) {
        if(account<0||account>len)
            return false;
        balance[account-1]+=money;
        return true;
    }
    
    public boolean withdraw(int account, long money) {
    if(account<0||account>len||money>balance[account-1])
            return false;
    balance[account-1]-=money;
    return true;      
    }
}