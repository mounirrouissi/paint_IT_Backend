package synch;

public class Account {
    private int balance = 200;

    public void debit(int amount) {
        balance = balance - amount;
    }



    public int getBalance() {
        return balance;
    }

}


