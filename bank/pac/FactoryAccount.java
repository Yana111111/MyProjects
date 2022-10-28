package pac;
import view.AccountStorage;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import view.ExistBank;

import java.util.Objects;

/**
 * This is the class of Account with some functions to work with it
 *
 * @author Yana Nestsiukovich
 */
public class FactoryAccount {
    public static enum type{
        SAVING,
        SALARY,
        CREDIT
    }
    private int id = 0;
    private static int count = 0;
    private int clientId;
    private boolean blocked;
    private double amountOfMoney;
    private ExistBank.banks bankName;
    private FactoryAccount.type typeAccount;

    public FactoryAccount(){}

    public FactoryAccount(boolean blocked,double amountOfMoney, ExistBank.banks b, int client){
        this.id = count;
        count++;
        this.amountOfMoney = amountOfMoney;
        this.blocked = blocked;
        this.bankName = b;
        clientId = client;
    }
    public boolean getBlocked(){
        return this.blocked;
    }
    public  int getId(){ return id; }
    public int getClientId(){
        return clientId;
    }
    public ExistBank.banks getBankName(){
        return this.bankName;
    }
    public double getAmountOfMoney(){
        return this.amountOfMoney;
    }
    protected void setAmountOfMoney(double amount){
        amountOfMoney = amount;
    }

    public FactoryAccount.type getTypeAccount(){
        return typeAccount;
    }
    public void setTypeAccount(type t){
         typeAccount = t;
    }
    public void block(){
        this.blocked = true;
    }
    public void unBlock(){
        this.blocked = false;
    }
    public static String printAccountName(type t){
        String str="";
        switch (t){
            case SAVING:
                str = "SAVING";
                break;
            case SALARY:
                str = "SALARY";
                break;
            case CREDIT:
                str = "CREDIT";
                break;
            default:
                break;
        }
        return str;
    }
    @Override
    public String toString() {
        String str = "";
        str = "blocked: " + blocked + ", amount of money: " + amountOfMoney + ", bank: " + ExistBank.printBankName(bankName) + ", id: " + getId()+ ", type: " + getTypeAccount();
        return str;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FactoryAccount account = (FactoryAccount) o;
        return id == account.id && clientId == account.clientId && blocked == account.blocked && Double.compare(account.amountOfMoney, amountOfMoney) == 0 && bankName == account.bankName && typeAccount == account.typeAccount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientId, blocked, amountOfMoney, bankName, typeAccount);
    }
}
