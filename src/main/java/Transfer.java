public class Transfer implements Runnable{

    private final Bank bank;
    private final String fromAccountNum;
    private final String toAccountNum;
    private final long amount;

    public Transfer(Bank bank, String fromAccountNum, String toAccountNum, long amount) {
        this.bank = bank;
        this.fromAccountNum = fromAccountNum;
        this.toAccountNum = toAccountNum;
        this.amount = amount;
    }

    @Override
    public void run() {
        bank.transfer(fromAccountNum, toAccountNum, amount);
    }
}
