import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;

public class BankTest extends TestCase {

    Account acc1 = new Account("1", 100000);
    Account acc2 = new Account("2", 200000);
    Account acc3 = new Account("3", 500000);
    Account acc4 = new Account("4", 1000000);
    Account acc5 = new Account("5", 30000000);
    Account acc6 = new Account("6", 420000);
    Account acc7 = new Account("7", 28000);
    Account acc8 = new Account("8", 3000);
    Account acc9 = new Account("9", 100000);
    Account acc10 = new Account("10", 1800000);

    Map<String, Account> accounts = new HashMap<>();

    @Override
    protected void setUp() throws Exception {

        accounts.put(acc1.getAccNumber(), acc1);
        accounts.put(acc2.getAccNumber(), acc2);
        accounts.put(acc3.getAccNumber(), acc3);
        accounts.put(acc4.getAccNumber(), acc4);
        accounts.put(acc5.getAccNumber(), acc5);
        accounts.put(acc6.getAccNumber(), acc6);
        accounts.put(acc7.getAccNumber(), acc7);
        accounts.put(acc8.getAccNumber(), acc8);
        accounts.put(acc9.getAccNumber(), acc9);
        accounts.put(acc10.getAccNumber(), acc10);

    }

    Bank bank = new Bank(accounts);

    public void testBankTotalAmount() {

        long totalBankAmount = bank.getSumAllAccounts();
        new Thread(new Transfer(bank, acc1.getAccNumber(), acc2.getAccNumber(), 20000)).start();
        new Thread(new Transfer(bank, acc3.getAccNumber(), acc5.getAccNumber(), 55000)).start();
        new Thread(new Transfer(bank, acc1.getAccNumber(), acc7.getAccNumber(), 5000)).start();
        new Thread(new Transfer(bank, acc9.getAccNumber(), acc4.getAccNumber(), 100000)).start();
        assertEquals(totalBankAmount, bank.getSumAllAccounts());

    }


}
