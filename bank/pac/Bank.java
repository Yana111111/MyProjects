package pac;


import pac.FactoryAccount;
import view.ExistBank;

import java.util.ArrayList;
import java.util.Objects;


/**
 * This is the class of Bank with some functions to work with it
 *
 * @author Yana Nestsiukovich
 */
public class Bank {
    public Bank(){}
    private int id;
    private static int count = 0;
    private  double accountMoney;
    private ExistBank.banks  bankName;
    private ArrayList<FactoryAccount> accounts = new ArrayList<>(100);
    public Bank(ExistBank.banks bankName, double account){
        this.accountMoney = account;
        this.id = count;
        count++;
        this.bankName = bankName;
    }
    public  void addAccountBank(FactoryAccount acc){
        
        if(accounts.size() < 100){
            if(accounts.indexOf(acc) < 0){
               accounts.add(acc);
               double bankMoney = getAccount();
                //setAccount(getAccount() + acc.getAmountOfMoney());
            }else{
                System.out.println("Sorry, such account exists");
            }              
        }else{
            System.out.println("Sorry, bank is full off accounts");
        }
        
    }
    public  void removeAccountBank(FactoryAccount acc){
        int number;
        if(accounts.indexOf(acc) > -1){
            number = accounts.indexOf(acc);
            accounts.remove(number);
        }else{
                System.out.println("Sorry, such account doesnt exist");
            } 
        
    }
    public ExistBank.banks getBankName(){
        return this.bankName;
    }
    public  ArrayList<FactoryAccount> getAllAccount(){
        return accounts;
    }
    protected  void setAllAccount(ArrayList<FactoryAccount> allAccounts){
        accounts = allAccounts;
    }

    public  double getAccount(){
        return accountMoney;
    }
    protected  void setAccount(double money){
        accountMoney = money;
    }

    public  double countAccountMoneyOnlyPositive(){
        double money = 0;
        for(int i = 0; i < accounts.size(); i++){
            if(accounts.get(i).getAmountOfMoney() >= 0){
                money += accounts.get(i).getAmountOfMoney();
            }
        }
        return money;
    }
    public  double countAccountMoneyAndNeg(){
        double money = 0;
        for(int i = 0; i < accounts.size(); i++){
            money += accounts.get(i).getAmountOfMoney();
        }
        return money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Double.compare(bank.accountMoney, accountMoney) == 0 && id == bank.id && bankName == bank.bankName && Objects.equals(accounts, bank.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountMoney, id, bankName, accounts);
    }
}
