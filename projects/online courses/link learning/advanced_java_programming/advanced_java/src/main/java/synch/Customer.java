package synch;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Customer {
    public static void main(String[] args) {
        Account account = new Account();
        ATM atm = new ATM();

        ExecutorService executorService= Executors.newFixedThreadPool(2);
        executorService.submit(() -> atm.handleTrans(account,100));
        executorService.submit(() -> atm.handleTrans(account,100));
        executorService.shutdown();

    }
}
