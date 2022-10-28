package view;

import pac.Client;
import pac.FactoryAccount;

import java.util.ArrayList;
/**
 * This is the class of ClientStorage with some functions to work with it
 *
 * @author Yana Nestsiukovich
 */
public class ClientStorage {

    private static ArrayList<Client> clientStorage = new ArrayList<>(100);
    public static ArrayList<Client> getClientStorage(){
        return clientStorage;
    }
    public static boolean getOneClientStorage(Client cli) {
        return clientStorage.contains(cli);
    }

    public static void setAccountStorage(Client cli) {
        clientStorage.add(cli);
    }
}