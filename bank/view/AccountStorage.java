/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;

import pac.AccountCredit;
import pac.FactoryAccount;

/**
 * This is the class of AccountStorage with some functions to work with it
 *
 * @author Yana Nestsiukovich
 */
public class AccountStorage {
    private static ArrayList<FactoryAccount> accountStorage = new ArrayList<>(100);
    public static ArrayList<FactoryAccount> getAllAccountStorage(){
        return accountStorage;
    }
    public static boolean getAccountStorage(FactoryAccount acc){       
        return accountStorage.contains(acc);
    }
    public static void setAccountStorage(FactoryAccount acc){
        accountStorage.add(acc);
    }

}
