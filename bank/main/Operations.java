package main;

import java.io.File;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import pac.*;
import pac.sorting.SortedByAccountId;
import pac.sorting.SortedByAmountOfMoney;
import pac.sorting.SortedByClientId;
import pac.sorting.SortedByClientName;
import view.AccountStorage;
import view.ClientStorage;
import view.ExistBank;
import view.TimeManagement;

public class Operations {
    public static int inputNumber(){
        Scanner inp = new Scanner(System.in);
        return inp.nextInt();
    }
    public static double inputDouble(){
        Scanner input = new Scanner(System.in);
        return input.nextDouble();
    }
    public static String inputString(){
        Scanner input = new Scanner(System.in);
        return input.next();
    }

    public static void menu() {

        while (true) {
            System.out.println("---------------------------------------------");
            System.out.println("Select an action...");
            System.out.println("1)Add account");//+
            System.out.println("2)Delete account");//-
            System.out.println("3)View money");
            System.out.println("4)Block an account");
            System.out.println("5)Unblock an account");
            System.out.println("6)View data");
            System.out.println("7)Sort by amount of money");
            System.out.println("8)Sort by id of account");
            System.out.println("9)Sort by client name");
            System.out.println("10)Sort by client id");
            System.out.println("11)Account transactions");
            System.out.println("12)Change date");
            System.out.println("0)Exit");
            System.out.println("---------------------------------------------");
            int inputNumber = -1;

            menu:
            switch (Operations.inputNumber()){
                case 1: {

                    while (true) {
                        System.out.println("---------------------------------------------");
                        System.out.println("1)Add new client");
                        System.out.println("2)Add new account for client");
                        System.out.println("0)Previous");
                        System.out.println("---------------------------------------------");

                        switch (Operations.inputNumber()) {
                            case 1: {
                                Client client;
                                FactoryAccount account = new FactoryAccount();
                                String nameClient;

                                System.out.println("Enter client name:");
                                nameClient = Operations.inputString();
                                boolean okFirsyF = false;
                                for(int i = 0; i < ClientStorage.getClientStorage().size(); i++){
                                    if(ClientStorage.getClientStorage().get(i).getFIO().equals(nameClient)){

                                        okFirsyF = true;
                                        break;
                                    }
                                }

                                client = new Client(nameClient);
                                if(okFirsyF == true){
                                    System.out.println("Such client exists");
                                    break;
                                }
                                else{
                                    ClientStorage.getClientStorage().add(client);
                                }

                                System.out.println("Enter account type:");
                                System.out.println("1)Credit");
                                System.out.println("2)Salary");
                                System.out.println("3)Saving");
                                int accType = Operations.inputNumber();

                                FactoryAccount.type t = FactoryAccount.type.CREDIT;
                                switch (accType){
                                    case 2:
                                        t = FactoryAccount.type.SALARY;
                                        break;
                                    case 3:
                                        t = FactoryAccount.type.SAVING;
                                        break;
                                    case 1:
                                        t = FactoryAccount.type.CREDIT;
                                        break;
                                    default:
                                        break;
                                }

                                System.out.println("Enter amount of money: ");
                                double accAmount = Operations.inputDouble();
                                System.out.println("Enter bank:");
                                System.out.println("1)STATUSBANK");
                                System.out.println("2)BElVEB");
                                System.out.println("3)PRIORBANK");
                                int bankType = Operations.inputNumber();
                                ExistBank.banks b = ExistBank.banks.BELVEB;;
                                switch (bankType){
                                    case 2:
                                        b = ExistBank.banks.BELVEB;
                                        break;
                                    case 3:
                                        b = ExistBank.banks.PRIORBANK;
                                        break;
                                    case 1:
                                        b = ExistBank.banks.STATUSBANK;
                                        break;
                                    default:
                                        break;
                                }
                                client.addAccount(b,accAmount,t);
                                break menu;
                            }
                            case 2: {
                                Client client = new Client();
                                FactoryAccount account = new FactoryAccount();
                                String nameClient;

                                System.out.print("Enter client name:");
                                nameClient = Operations.inputString();
                                boolean okFirst = false;
                                for(int i = 0; i < ClientStorage.getClientStorage().size(); i++){
                                    if(ClientStorage.getClientStorage().get(i).getFIO().equals(nameClient)){
                                        client = ClientStorage.getClientStorage().get(i);
                                        okFirst = true;
                                        break;
                                    }
                                }
                                if(okFirst == false){
                                    System.out.print("Such account doesn't exist:");
                                    break;
                                }

                                System.out.println("Enter account type:");
                                System.out.println("1)Credit");
                                System.out.println("2)Salary");
                                System.out.println("3)Saving");
                                int accType = Operations.inputNumber();

                                FactoryAccount.type t = FactoryAccount.type.CREDIT;
                                switch (accType){
                                    case 2:
                                        t = FactoryAccount.type.SALARY;
                                        break;
                                    case 3:
                                        t = FactoryAccount.type.SAVING;
                                        break;
                                    case 1:
                                        t = FactoryAccount.type.CREDIT;
                                        break;
                                    default:
                                        break;
                                }

                                System.out.println("Enter amount of money: ");
                                double accAmount = Operations.inputDouble();
                                System.out.println("Enter bank:");
                                System.out.println("1)STATUSBANK");
                                System.out.println("2)BElVEB");
                                System.out.println("3)PRIORBANK");
                                int bankType = Operations.inputNumber();
                                ExistBank.banks b = ExistBank.banks.BELVEB;;
                                switch (bankType){
                                    case 2:
                                        b = ExistBank.banks.BELVEB;
                                        break;
                                    case 3:
                                        b = ExistBank.banks.PRIORBANK;
                                        break;
                                    case 1:
                                        b = ExistBank.banks.STATUSBANK;
                                        break;
                                    default:
                                        break;
                                }
                                client.addAccount(b,accAmount,t);
                                break menu;
                            }
                            case 0: {
                                break menu;
                            }
                            default: {
                                System.out.println("---------------------------------------------");
                                System.out.println("Impossible choice or format. Repeat please ...");
                            }
                        }
                    }
                }
                case 2: {
                    System.out.print("Enter account id for delete: ");
                    int numberAccount = Operations.inputNumber();
                    FactoryAccount acToDel = new FactoryAccount();
                    int numOfAccToDelInAr = -1;
                    for(int i = 0; i < AccountStorage.getAllAccountStorage().size(); i++){
                        if(AccountStorage.getAllAccountStorage().get(i).getId() == numberAccount){
                            numOfAccToDelInAr = i;
                            acToDel = AccountStorage.getAllAccountStorage().get(i);
                        }
                    }
                    if(numOfAccToDelInAr == -1){
                        System.out.print("Such account doesn't exest: ");
                        break;
                    }
                    ExistBank.banks bankDel = acToDel.getBankName();
                    int rightInde = 0;
                    for(int i = 0; i < ExistBank.getBank().length; i++){
                        if(ExistBank.getBank()[i].getBankName().equals(bankDel)){
                            rightInde = i;
                            break;
                        }
                    }
                    ExistBank.getBank()[rightInde].removeAccountBank(acToDel);
                    AccountStorage.getAllAccountStorage().remove(numOfAccToDelInAr);
                    ArrayList<FactoryAccount>  todel;
                    FactoryAccount accountToDelete;
                    for(int i = 0; i < ClientStorage.getClientStorage().size(); i++){

                        todel = ClientStorage.getClientStorage().get(i).showAccounts();
                        for(int k = 0; k < todel.size(); k++){
                            if(todel.get(k).getId() == numOfAccToDelInAr){
                                FactoryAccount.type typeToDel = todel.get(k).getTypeAccount();
                                accountToDelete = todel.get(k);
                                ClientStorage.getClientStorage().get(i).deleteAccountOfClient(accountToDelete);
                                switch(typeToDel){
                                    case CREDIT:{
                                        ClientStorage.getClientStorage().get(i).setCrSalSav(0,false);
                                        break;
                                    }
                                    case SALARY:{
                                        ClientStorage.getClientStorage().get(i).setCrSalSav(1,false);
                                        break;
                                    }
                                    case SAVING:{
                                        ClientStorage.getClientStorage().get(i).setCrSalSav(2,false);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    break menu;
                }
                case 3:{
                    System.out.println("1)Bank account\n" +
                            "2)Only positive accounts\n" +
                            "3)All accounts");
                    int chose = Operations.inputNumber();

                        System.out.println("1)STATUSBANK");
                        System.out.println("2)BElVEB");
                        System.out.println("3)PRIORBANK");

                    int bankType = Operations.inputNumber();
                    ExistBank.banks ba = ExistBank.banks.BELVEB;
                    Bank[] arrayBank = ExistBank.getBank();
                    int rightIndex=-1;
                    switch (bankType){
                        case 2:
                            ba = ExistBank.banks.BELVEB;
                            break;
                        case 3:
                            ba = ExistBank.banks.PRIORBANK;
                            break;
                        case 1:
                            ba = ExistBank.banks.STATUSBANK;
                            break;
                        default:
                            break;
                    }
                    for(int i = 0; i < arrayBank.length; i++){
                        if(arrayBank[i].getBankName().equals(ba)){
                            rightIndex = i;
                            break;
                        }
                    }

                     switch (chose){
                        case 1:{

                            if(rightIndex != -1){
                                System.out.println(ExistBank.getBank()[rightIndex].getAccount());
                            }else{
                                System.out.println("Eror");
                            }
                            break;
                        }
                        case 2:{
                            if(rightIndex != -1){
                                System.out.println(ExistBank.getBank()[rightIndex].countAccountMoneyOnlyPositive());
                            }else{
                                System.out.println("Eror");
                            }
                            break;
                        }
                        case 3:{
                            if(rightIndex != -1){
                                System.out.println(ExistBank.getBank()[rightIndex].countAccountMoneyAndNeg());
                            }else{
                                System.out.println("Eror");
                            }
                            break;
                        }
                        default:
                            break;

                    }
                    break;
                }
                case 4:{
                    System.out.println("Enter account id to block");
                    int idAccToDe = Operations.inputNumber();
                    boolean ok = false;
                    for(int i = 0; i < AccountStorage.getAllAccountStorage().size();i++){
                        if(AccountStorage.getAllAccountStorage().get(i).getId() == idAccToDe){
                            AccountStorage.getAllAccountStorage().get(i).block();
                            ok = true;
                            break;
                        }
                    }
                    if(ok == false){
                        System.out.println("Such account doesn't exist");
                    }
                    break;
                }
                case 5:{
                    System.out.println("Enter account id to unblock");
                    int idAccToDe = Operations.inputNumber();
                    boolean ok = false;
                    for(int i = 0; i < AccountStorage.getAllAccountStorage().size();i++){
                        if(AccountStorage.getAllAccountStorage().get(i).getId() == idAccToDe){
                            AccountStorage.getAllAccountStorage().get(i).unBlock();
                            ok = true;
                            break;
                        }
                    }
                    if(ok == false){
                        System.out.println("Such account doesn't exist");
                    }
                    break;
                }
                case 6: {
                    System.out.println("1) Clients");
                    System.out.println("2) Accounts");
                    switch (Operations.inputNumber()){
                        case 1:{
                            for(int i = 0; i < ClientStorage.getClientStorage().size();i++){
                                System.out.println(ClientStorage.getClientStorage().get(i));
                            }
                            break;
                        }
                        case 2:{
                            for(int i = 0; i < AccountStorage.getAllAccountStorage().size();i++){
                                System.out.println(AccountStorage.getAllAccountStorage().get(i));
                            }
                            break;
                        }
                        default:{
                            break;
                        }

                    }
                    break;
                }
                case 7: {
                    ArrayList<FactoryAccount> accounts = AccountStorage.getAllAccountStorage();
                    accounts.sort(new SortedByAmountOfMoney());

                    for (FactoryAccount account: accounts) {
                        System.out.println(account);
                    }
                    break;
                }
                case 8: {
                    ArrayList<FactoryAccount> accounts = AccountStorage.getAllAccountStorage();
                    accounts.sort(new SortedByAccountId());

                    for (FactoryAccount account: accounts) {
                        System.out.println(account);
                    }
                    break;
                }
                case 9: {
                    ArrayList<Client> clients = ClientStorage.getClientStorage();
                    clients.sort(new SortedByClientName());

                    for (Client cl: clients) {
                        System.out.println(cl);
                    }
                    break;
                }
                case 10: {
                    ArrayList<Client> clients = ClientStorage.getClientStorage();
                    clients.sort(new SortedByClientId());

                    for (Client cl: clients) {
                        System.out.println(cl);
                    }
                    break;
                }
                case 11: {
                    while(true) {
                        System.out.println("---------------------------------------------");
                        System.out.println("Enter account id");
                        int accountId = -1;
                        int accountPosition = -1;
                        accountId = Operations.inputNumber();
                        for(int i = 0; i < AccountStorage.getAllAccountStorage().size(); i++){
                            if(AccountStorage.getAllAccountStorage().get(i).getId() == accountId){
                                accountPosition = i;
                            }
                        }
                        if(accountPosition < 0){
                            System.out.println("Such account doesn't exist");
                            break;
                        }
                        System.out.println("---------------------------------------------");
                        System.out.println("1)Put money");
                        System.out.println("2)Pull off money");
                        System.out.println("3)Money transfer to the account\n" +
                                "(this operation available only to salary accounts");
                        System.out.println("0)Previous");
                        System.out.println("---------------------------------------------");
                        int nextOperation = Operations.inputNumber();
                        ArrayList<FactoryAccount> accountStorage = AccountStorage.getAllAccountStorage();
                        ExistBank.banks bank = accountStorage.get(accountPosition).getBankName();
                        double sumForOperation = -1;
                        if(nextOperation == 1 || nextOperation == 2) {
                            System.out.println("Enter amount of money");
                            sumForOperation = Operations.inputDouble();
                        }
                        switch (nextOperation){
                            case 1: {
                                switch (accountStorage.get(accountPosition).getTypeAccount()){
                                    case CREDIT:{
                                        AccountCredit credit = new AccountCredit();
                                        credit.replenishmentCredit(sumForOperation,bank,accountStorage.get(accountPosition));
                                        break;
                                    }
                                    case SALARY:{
                                        AccountSalary salary = new AccountSalary();
                                        salary.replenishmentSalary(sumForOperation,accountStorage.get(accountPosition));
                                        break;
                                    }
                                    case SAVING:{
                                        AccountSaving saving = new AccountSaving();
                                        saving.replenishmentSaving(sumForOperation,accountStorage.get(accountPosition));
                                        break;
                                    }
                                    default:{
                                        break;
                                    }
                                }
                                break;
                            }
                            case 2: {
                                switch (accountStorage.get(accountPosition).getTypeAccount()){
                                    case CREDIT:{
                                        AccountCredit credit = new AccountCredit();
                                        credit.debitingCredit(sumForOperation,bank,accountStorage.get(accountPosition));
                                        break;
                                    }
                                    case SALARY:{
                                        AccountSalary salary = new AccountSalary();
                                        salary.debitingSalary(sumForOperation,accountStorage.get(accountPosition));
                                        break;
                                    }
                                    case SAVING:{
                                        AccountSaving saving = new AccountSaving();

                                        int clientIdStorage = -1;
                                        for(int i = 0; i < ClientStorage.getClientStorage().size(); i++){
                                            if(ClientStorage.getClientStorage().get(i).getId() == accountStorage.get(accountPosition).getClientId()){
                                                clientIdStorage = i;
                                            }
                                        }
                                        saving.debitingSaving(sumForOperation,accountStorage.get(accountPosition), ClientStorage.getClientStorage().get(clientIdStorage));

                                        break;
                                    }
                                    default:{
                                        break;
                                    }
                                }
                                break;
                            }
                            case 3:{
                                if(accountStorage.get(accountPosition).getTypeAccount() == FactoryAccount.type.SALARY){
                                    System.out.println("Enter client id to transfer");
                                    int idOperation = Operations.inputNumber();
                                    int idToTransfer = -1;
                                    System.out.println("Enter account type to transfer");
                                    System.out.println("1)Credit");
                                    System.out.println("2)Salary");
                                    System.out.println("3)Saving");
                                    FactoryAccount.type typeAc = FactoryAccount.type.SALARY;
                                    int typeToTransfer = Operations.inputNumber();
                                    System.out.println("Enter amount of money to transfer");
                                    double moneyToTransfer = Operations.inputDouble();
                                    for(int i = 0; i < ClientStorage.getClientStorage().size(); i++){
                                        if(ClientStorage.getClientStorage().get(i).getId() == idOperation){
                                            idToTransfer = i;
                                        }
                                    }
                                    boolean no = false;
                                    if(idToTransfer != -1){
                                        AccountSalary salary = new AccountSalary();
                                        switch (typeToTransfer){
                                            case 1:{
                                                typeAc = FactoryAccount.type.CREDIT;
                                                break;
                                            }
                                            case 2:{
                                                typeAc = FactoryAccount.type.SALARY;
                                                break;
                                            }
                                            case 3:{
                                                typeAc = FactoryAccount.type.SAVING;
                                                break;
                                            }
                                            default:{
                                                no = true;
                                                break;
                                            }
                                        }
                                        if(no != true) {
                                            salary.transferFromAccountToAccount(ClientStorage.getClientStorage().get(idToTransfer), moneyToTransfer, typeAc, AccountStorage.getAllAccountStorage().get(accountPosition));

                                        }
                                        else{
                                            System.out.println("Such type of account doesn't exist");
                                        }
                                    }
                                    else{
                                        System.out.println("Such account doesn't exist");
                                    }
                                }
                                else{
                                    System.out.println("Money transfer to the account available only to salary accounts");
                                }
                                break;
                            }
                            case 0: {
                                break menu;
                            }
                            default: {
                                System.out.println("---------------------------------------------");
                                System.out.println("Impossible choice or format. Repeat please ...");
                            }
                        }
                    }
                }
                case 12: {
                    System.out.println("---------------------------------------------");
                    System.out.println("1)Today's date");
                    System.out.println("2)Change date");
                    switch (Operations.inputNumber()){
                        case 1:{
                            Date date = TimeManagement.getToday().getTime();
                            System.out.println(date);
                            break;
                        }
                        case 2:{
                            System.out.println("1)Change year");
                            System.out.println("2)Change month");
                            System.out.println("3)Change day");
                            int whatChange = Operations.inputNumber();
                            System.out.println("Change for");
                            int changeFor = 0;
                            changeFor = Operations.inputNumber();
                            switch (whatChange){
                                case 1:{
                                    TimeManagement.getToday().add(Calendar.YEAR,changeFor);
                                    break;
                                }
                                case 2:{
                                    TimeManagement.getToday().add(Calendar.MONTH,changeFor);
                                    break;
                                }
                                case 3:{
                                    TimeManagement.getToday().add(Calendar.DATE,changeFor);
                                    break;
                                }
                                default:{
                                    break;
                                }
                            }
                            if(TimeManagement.getToday().get(Calendar.YEAR) + changeFor > 2026){
                                System.out.println("Our system is designed for 5 years");
                                TimeManagement.getToday().set(2026,TimeManagement.getToday().get(Calendar.MONTH), TimeManagement.getToday().get(Calendar.DATE));
                                break;
                            }
                            if(TimeManagement.getToday().get(Calendar.YEAR) + changeFor < 2022){
                                System.out.println("Our system is designed for 5 years");
                                TimeManagement.getToday().set(2022,TimeManagement.getToday().get(Calendar.MONTH), TimeManagement.getToday().get(Calendar.DATE));
                                break;
                            }
                            break;
                        }
                        default:{
                            System.out.println("Impossible choice or format. Repeat please ...");
                            break;
                        }
                    }
                    break;
                }
                case 0: {
                    System.out.println("---------------------------------------------");
                    System.out.println("Work completed");
                    System.out.println("---------------------------------------------");
                    System.exit(0);
                }
                default: {
                    System.out.println("---------------------------------------------");
                    System.out.println("Impossible choice or format. Repeat please ...");
                }
            }
        }
    }
}