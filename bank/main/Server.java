/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;


import pac.Client;
import pac.FactoryAccount;
import view.ClientStorage;
import view.ExistBank;
import view.TimeManagement;


import static java.lang.System.*;

/**
 *
 * @author Yana Nestsiukovich
 */
public class Server {
    static Scanner input = new Scanner(in);
    public static  void main(String[] args) {
        Calendar calendar = new GregorianCalendar(2021, 0 , 25);
        TimeManagement.setToday(calendar);
        Scanner inpu = new Scanner(in);
        Client client1 = new Client("Andrei");
        Client client2 = new Client("Ivan");
        Client client3 = new Client("Nikolai");
        Client client4 = new Client("Dima");

        client1.addAccount(ExistBank.banks.BELVEB,2, FactoryAccount.type.SALARY);
        client1.addAccount(ExistBank.banks.MIR,5, FactoryAccount.type.CREDIT);
        client2.addAccount(ExistBank.banks.PRIORBANK,20, FactoryAccount.type.SALARY);
        client2.addAccount(ExistBank.banks.PRIORBANK,1000, FactoryAccount.type.SAVING);
        client3.addAccount(ExistBank.banks.STATUSBANK,16, FactoryAccount.type.SALARY);
        client3.addAccount(ExistBank.banks.BELVEB,-50, FactoryAccount.type.CREDIT);
        client4.addAccount(ExistBank.banks.STATUSBANK,0, FactoryAccount.type.SAVING);

        ClientStorage.setAccountStorage(client1);
        ClientStorage.setAccountStorage(client2);
        ClientStorage.setAccountStorage(client3);
        ClientStorage.setAccountStorage(client4);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(2022,0,25);
        TimeManagement.setToday(calendar2);
        Operations.menu();
    }


    
}