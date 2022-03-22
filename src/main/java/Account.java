public class Account {

    private String accNumber;
    private long money;
    private boolean isBlocked = false;

    public Account(String accNumber, long money) {
        this.accNumber = accNumber;
        this.money = money;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public void blockAccount() {
        isBlocked = true;
    }

    public boolean getBlockStatus() {
        return isBlocked;
    }

}
