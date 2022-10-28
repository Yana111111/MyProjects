/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;
import pac.Bank;
/**
 * This is the class of ExistBank with some functions to work with it
 *
 * @author Yana Nestsiukovich
 */
public class ExistBank {
    public enum banks{
        BELVEB,
        PRIORBANK,
        STATUSBANK,
        BELINVESTBANK,
        MIR
    }
    static Bank first = new Bank(banks.BELVEB, 5000.0);
    static Bank second = new Bank(banks.PRIORBANK, 1000.0);
    static Bank third = new Bank(banks.STATUSBANK, 100.0);

    public static Bank[] bank = {first,second, third};
    public static Bank[] getBank(){
        return bank;
    }
    public  static boolean getBankExist(ExistBank.banks name){
        for(int i = 0; i < bank.length; i++){
            if((bank[i].getBankName()).equals(name)){
                return true;
            }
        }
        return false;
    }
    public static String printBankName(banks b){
        String str="";
        switch (b){
            case BELVEB:
                str = "BELVEB";
                break;
            case PRIORBANK:
                str = "PRIORBANK";
                break;
            case BELINVESTBANK:
                str = "BELINVESTBANK";
                break;
            case STATUSBANK:
                str = "STATUSBANK";
                break;
            case MIR:
                str = "MIR";
                break;
            default:
                break;
        }
        return str;
    }


}
