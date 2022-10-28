/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pac;
import view.AccountStorage;
import view.ExistBank;

import java.util.ArrayList;

/**
 * This is the class of AccountSalary with some functions to work with it
 *
 * @author Yana Nestsiukovich
 */
public class AccountSalary extends FactoryAccount{
    public AccountSalary(){}
    public AccountSalary(boolean blocked,double amountOfMoney, ExistBank.banks b, int client){
        super(blocked,amountOfMoney,b, client);
        setTypeAccount(type.SALARY);
    }
    public void debitingSalary(double money, FactoryAccount account){
        if(account.getBlocked() != true){
            if(account.getAmountOfMoney() < money){
                account.setAmountOfMoney(-0.1);
                account.block();
                System.out.println("Blocked");
            }
            else {
                account.setAmountOfMoney(getAmountOfMoney() - money);
            }
            System.out.println("Success");
        }
        else{
            System.out.println("Error, your account is Blocked");
        }
    }
    public void replenishmentSalary(double money, FactoryAccount account){
        double amountOfMoney = account.getAmountOfMoney();
        if(amountOfMoney < 0.0){
            account.setAmountOfMoney(amountOfMoney + money);
            System.out.println("Success");
            if(account.getAmountOfMoney() > 0){
                account.unBlock();
                System.out.println("Unblocked");
            }
        }
        else{
            account.setAmountOfMoney(amountOfMoney + money);
            System.out.println("Success");
        }
    }
    public void transferFromAccountToAccount(Client human, double amountOfMoney, type t, FactoryAccount acc){
        ArrayList<FactoryAccount> accountsOfHuman;
        int idOneAccount = 0;
        switch (t){
            case CREDIT:{
                idOneAccount = 0;
                break;
            }
            case SALARY:{
                idOneAccount = 1;
                break;
            }
            case SAVING:{
                idOneAccount = 2;
                break;
            }
            default:{
                break;
            }
        }
        //FactoryAccount[] accountsOfHuman;
        accountsOfHuman = human.showAccounts();
        FactoryAccount recipient = new FactoryAccount();
        boolean ok = false;
        for (int i = 0; i < accountsOfHuman.size(); i++){
            if((accountsOfHuman.get(i)).getTypeAccount() == t && human.getCrSalSav(idOneAccount) == true){
                recipient = accountsOfHuman.get(i);
                ok = true;
                break;
            }
        }
        if(ok) {
            if (AccountStorage.getAccountStorage(recipient) && idOneAccount != 0 ) {
                double ourAmount = acc.getAmountOfMoney();
                double recipientAmount = recipient.getAmountOfMoney();
                if (ourAmount < amountOfMoney) {
                    recipient.setAmountOfMoney(recipientAmount + ourAmount);
                    System.out.println("ourAmount < recipientAmount");
                    acc.setAmountOfMoney(0.0);
                } else {
                    recipient.setAmountOfMoney(recipientAmount + amountOfMoney);
                    acc.setAmountOfMoney(ourAmount - amountOfMoney);
                    System.out.println("The operation was successfully carried out ");
                }
            }
            else if (AccountStorage.getAccountStorage(recipient) && idOneAccount == 0 ) {
                double ourAmount = acc.getAmountOfMoney();
                double recipientAmount = recipient.getAmountOfMoney();
                if(recipient.getAmountOfMoney() >= 0) {
                    if (ourAmount < amountOfMoney) {
                        recipient.setAmountOfMoney(recipientAmount + ourAmount);
                        System.out.println("ourAmount < recipientAmount");
                        acc.setAmountOfMoney(0.0);
                    } else {
                        recipient.setAmountOfMoney(recipientAmount + amountOfMoney);
                        acc.setAmountOfMoney(ourAmount - amountOfMoney);
                        System.out.println("The operation was successfully carried out ");
                    }
                }
                else {
                    System.out.println("Recipient's amount of money < 0");
                }
            }
            else {
                System.out.println("Recipient doesn't exist");
            }
        }
        else{
            System.out.println("Recipient doesn't exist");
        }
    }
}