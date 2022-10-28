/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pac;
import view.ExistBank;
import view.TimeManagement;

import java.util.Calendar;
/**
 * This is the class of AccountSaving with some functions to work with it
 *
 * @author Yana Nestsiukovich
 */
public class AccountSaving extends FactoryAccount{

    public AccountSaving(){}
    public AccountSaving(boolean blocked,double amountOfMoney, ExistBank.banks b, int client, Calendar dateOfCreation){
        super(blocked,amountOfMoney, b, client);
        setTypeAccount(type.SAVING);
    }
    public void replenishmentSaving(double money, FactoryAccount account){
        double amountOfMoney = account.getAmountOfMoney();
        account.setAmountOfMoney(amountOfMoney + money);
        if (account.getBlocked() == true && account.getAmountOfMoney() >= 100.0){
            account.unBlock();
        }
    }
    public void debitingSaving(double money, FactoryAccount account, Client client){
        double amountOfMoney = account.getAmountOfMoney();
        int year = TimeManagement.getToday().get(Calendar.YEAR);
        if (account.getBlocked() == false) {
            if (client.getTime().get(Calendar.MONTH) == (TimeManagement.getToday()).get(Calendar.MONTH) &&
                    client.getTime().get(Calendar.YEAR) != (TimeManagement.getToday()).get(Calendar.YEAR) && client.getDictionary().get(year) == false) {
                for(int i = 0; i <= year - 2022; i++){
                    if(client.getDictionary().get(2022 + i) == false){
                        amountOfMoney += (client.getAmountForPercent() * 0.03);
                        System.out.println("Amount of money for profit is " + (client.getAmountForPercent()));
                        System.out.println("Your profit is " + (client.getAmountForPercent() * 0.03));
                        account.setAmountOfMoney(amountOfMoney);
                        client.setAmountForPercent(account.getAmountOfMoney());
                        client.setDictionary(2022 + i);
                    }


                }
                if (amountOfMoney < money) {
                    account.setAmountOfMoney(0);
                    account.block();
                }
                account.setAmountOfMoney(account.getAmountOfMoney() - money);
            }else{
                System.out.println("It's not a time");
            }
        }
        else{
            System.out.println("Your account is blocked");
        }
    }

}
