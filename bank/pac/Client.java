package pac;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import view.AccountStorage;
import view.ExistBank;
import view.TimeManagement;
import pac.AccountCredit;
import pac.AccountSalary;
import pac.AccountSaving;

import java.util.*;


import static pac.FactoryAccount.printAccountName;

/**
 * This is the class of Client with some functions to work with it
 *
 * @author Yana Nestsiukovich
 */
public class Client {
    private int id;
    private static int count = 0;
    private static int countAccounts = 0;
    private String FIO;
    private Calendar dateOfCreation;
    private double amountForPercent;
    private boolean[] CrSalSav= {false, false, false};
    private HashMap<Integer,Boolean> dictionary = new HashMap<Integer,Boolean>();
    private ArrayList<FactoryAccount> accountsOfClient = new ArrayList(3);
    public Client(){}
    public Client(String FIO){
        this.FIO = FIO;
        id = count;
        count++;
        dictionary.put(2022,false);
        dictionary.put(2023,false);
        dictionary.put(2024,false);
        dictionary.put(2025,false);
        dictionary.put(2026,false);
    }

    public boolean getCrSalSav(int type){
        return CrSalSav[type];
    }
    public void setCrSalSav(int type, boolean ok){
        CrSalSav[type] = ok;
    }
    public  String getFIO(){
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public ArrayList<FactoryAccount> getAccountsOfClient(){
        return accountsOfClient;
    }

    public int getId(){
        return id;
    }
    public double getAmountForPercent(){
        return amountForPercent;
    }
    public void setAmountForPercent(double amount){
        this.amountForPercent = amount;
    }
    public Calendar getTime(){
        return dateOfCreation ;
    }
    public void setTime(Calendar cal){
        this.dateOfCreation = cal;
    }

    public HashMap<Integer, Boolean> getDictionary() {
        return dictionary;
    }
    public void setDictionary(int year){
        dictionary.put(year, true);
    }
    public ArrayList<FactoryAccount> showAccounts(){
        return accountsOfClient;
    }
    public void deleteAccountOfClient(FactoryAccount account){
        accountsOfClient.remove(account);
    }
    public void addAccount(ExistBank.banks b, double amountOfMoney, FactoryAccount.type t ){
        int rightIndex = 0;
        for(int i = 0; i < ExistBank.getBank().length; i++){
            if(ExistBank.getBank()[i].getBankName().equals(b)){
                rightIndex = i;
                break;
            }
        }
        switch(t){
            case SAVING:
                if(CrSalSav[2] == false) {
                    AccountSaving ac1 = new AccountSaving(false, amountOfMoney, b, id, TimeManagement.getToday());
                    accountsOfClient.add(ac1);
                    AccountStorage.setAccountStorage(ac1);
                    ExistBank.getBank()[rightIndex].addAccountBank(ac1);
                    setAmountForPercent(amountOfMoney);
                    setTime(TimeManagement.getToday());
                    CrSalSav[2] = true;
                }
                else{
                    System.out.println("You have such type of account");
                }
                break;
            case SALARY:
                if(CrSalSav[1] == false) {
                    AccountSalary ac2 = new AccountSalary(false, amountOfMoney, b, id);
                    accountsOfClient.add(ac2);
                    AccountStorage.setAccountStorage(ac2);
                    ExistBank.getBank()[rightIndex].addAccountBank(ac2);
                    CrSalSav[1] = true;
                }
                else{
                    System.out.println("You have such type of account");
                }
                break;
            case CREDIT:
                if(CrSalSav[0] == false) {
                    AccountCredit ac3 = new AccountCredit(false, amountOfMoney, b, id);
                    accountsOfClient.add(ac3);
                    AccountStorage.setAccountStorage(ac3);
                    ExistBank.getBank()[rightIndex].addAccountBank(ac3);
                    CrSalSav[0] = true;
                }
                else{
                    System.out.println("You have such type of account");
                }
                break;
            default:

                break;
        }
        countAccounts++;
    }

    public String toString() {
        String data = "---------------------------------------------" + "\n" + "Client: " + getFIO()
                +"\nId: " + getId() + "\n ";
        for (FactoryAccount acc: accountsOfClient) {
            data += "\n" + acc + "\n";
        }
        data += "---------------------------------------------";
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Double.compare(client.amountForPercent, amountForPercent) == 0 && id == client.id && Objects.equals(dateOfCreation,
                client.dateOfCreation) && Objects.equals(dictionary, client.dictionary) && Arrays.equals(CrSalSav, client.CrSalSav)
                && Objects.equals(FIO, client.FIO) && Objects.equals(accountsOfClient, client.accountsOfClient);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(dateOfCreation, amountForPercent, dictionary, FIO, id, accountsOfClient);
        result = 31 * result + Arrays.hashCode(CrSalSav);
        return result;
    }
}
