import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Bank {

    private Map<String, Account> accounts;

    private final Random random = new Random();

    public Bank(Map<String, Account> accounts) {
        this.accounts = accounts;
    }

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
        throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }


    public boolean transfer(String fromAccountNum, String toAccountNum, long amount) {

        if(amount > 50000) {
            try {
                if (isFraud(fromAccountNum, toAccountNum, amount)) {
                    accounts.get(fromAccountNum).blockAccount();
                    accounts.get(toAccountNum).blockAccount();
                    return false;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if(accounts.get(fromAccountNum).getBlockStatus() || accounts.get(toAccountNum).getBlockStatus()) return false;
        if(accounts.get(fromAccountNum).getMoney() < amount) return false;

        synchronized (accounts.get(fromAccountNum)) {
            accounts.get(fromAccountNum).setMoney(accounts.get(fromAccountNum).getMoney() - amount);
        }

        synchronized (accounts.get(toAccountNum)) {
            accounts.get(toAccountNum).setMoney(accounts.get(toAccountNum).getMoney() + amount);
        }

        return true;
    }

    public long getBalance(String accountNum) {
        synchronized (accounts.get(accountNum)) {
            return accounts.get(accountNum).getMoney();
        }
    }

    public long getSumAllAccounts() {
        synchronized (accounts) {
            return accounts.values().stream().mapToLong(Account::getMoney).sum();
        }
    }

}
