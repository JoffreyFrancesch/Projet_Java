package banking;

import java.util.LinkedList;
public class Banque{

  LinkedList<Client> clientList = new LinkedList<>();

  public void ajout_client(String prenom, String name, int age, double solde){
    clientList.add(new Client(prenom,name,age,solde));
  }
}
