package theory.hash;

public class Account
{
    private int accountNumber;
    private String holderName;

    public Account(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    //Depends only on account number
    @Override
    public int hashCode() {
        /*
        normal example

         final int prime = 31;
        int result = 1;
        result = prime * result + accountNumber;
        return result;
         */
        //bad example
        return accountNumber%2;
    }

    //Compare only account numbers
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Account other = (Account) obj;

        return accountNumber == other.accountNumber;

    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber%2 +"}";

    }
}