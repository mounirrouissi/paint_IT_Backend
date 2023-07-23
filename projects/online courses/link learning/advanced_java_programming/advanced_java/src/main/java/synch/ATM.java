package synch;

import java.io.SyncFailedException;

public class ATM {

    public synchronized void handleTrans(Account account, int amount)  {

            if(account.getBalance() -amount >0){
            account.debit(amount);
            System.out.println(Thread.currentThread());
        }
        else
        {
            System.out.println("failed ");
        }
        System.out.println(account.getBalance());

    }
}
