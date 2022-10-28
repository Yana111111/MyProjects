/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pac;

import view.ExistBank;

/**
 * This is the class of AccountCredit with some functions to work with it
 *
 * @author Yana Nestsiukovich
 */
public class AccountCredit extends FactoryAccount{
    private static double maxCredit;
    public AccountCredit(){}
    public AccountCredit(boolean blocked,double amountOfMoney,ExistBank.banks b, int client){
        super(blocked,amountOfMoney,b, client);
        this.maxCredit = -10;
        setTypeAccount(type.CREDIT);
    }
    
    public  void replenishmentCredit(double money, ExistBank.banks bank, FactoryAccount account){
        if(money <= 0){
            System.out.println("Amount of money <= 0");
        }
        else {
            if (ExistBank.getBankExist(account.getBankName())){
                double amountOfMoney = account.getAmountOfMoney();
                int rightIndex = 0;
                for (int i = 0; i < ExistBank.getBank().length; i++) {
                    if (ExistBank.getBank()[i].getBankName().equals(bank)) {
                        rightIndex = i;
                        break;
                    }
                }
                if (amountOfMoney < 0.0 && amountOfMoney > maxCredit) {
                        ExistBank.getBank()[rightIndex].setAccount(ExistBank.getBank()[rightIndex].getAccount() + money);
                        account.setAmountOfMoney(amountOfMoney + (money * 0.75));// снятие процентов за кредит
                        System.out.println("Success");
                        System.out.println("Profit to the bank 25 %: " + (money * 0.25));
                } else if (amountOfMoney <= maxCredit) {
                        ExistBank.getBank()[rightIndex].setAccount(ExistBank.getBank()[rightIndex].getAccount() + money);
                        account.setAmountOfMoney(amountOfMoney + (money * 0.5));// снятие процентов за кредит

                        System.out.println("Success");
                        System.out.println("Profit to the bank 50 %: " + (money * 0.5));
                } else {
                    account.setAmountOfMoney(amountOfMoney + money);
                    System.out.println("Success");
                }
                System.out.println("----------------------");
            }
            else{
                System.out.println("Operation canceled, bank not found");
            }
        }
    }

    public void debitingCredit(double money, ExistBank.banks bank, FactoryAccount account){
        if(money <= 0){
            System.out.println("Amount of money <= 0");
        }
        else {
            if (ExistBank.getBankExist(account.getBankName())){
                double amountOfMoney = account.getAmountOfMoney();
                int rightIndex = 0;
                for (int i = 0; i < ExistBank.getBank().length; i++) {
                    if (ExistBank.getBank()[i].getBankName().equals(bank)) {
                        rightIndex = i;
                        break;
                    }
                }
                if (account.getBlocked() != true) {
                    if ((amountOfMoney - money) >= 0.0) {
                        account.setAmountOfMoney(amountOfMoney - money);
                        System.out.println("Success");
                    } else if (amountOfMoney > 0 && (amountOfMoney - money) < 0) {
                        double moneyForBank = amountOfMoney - money;
                        account.setAmountOfMoney(moneyForBank);
                        ExistBank.getBank()[rightIndex].setAccount(ExistBank.getBank()[rightIndex].getAccount() + moneyForBank);// снимаем - со счета банка
                        System.out.println("Success");
                    } else {
                        double moneyForBank = amountOfMoney - money;// < 0
                        account.setAmountOfMoney(moneyForBank);
                        ExistBank.getBank()[rightIndex].setAccount(ExistBank.getBank()[rightIndex].getAccount() + moneyForBank);// снимаем - со счета банка
                        System.out.println("Success");
                    }

                } else {
                    System.out.println("Your account is blocked");
                }
            }
            else{
                System.out.println("Operation canceled, bank not found");
            }
        }
        System.out.println("----------------------");
    }
}