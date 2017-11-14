package banking;

import java.util.LinkedList;
public class Banque{

  LinkedList<Client> clientList = new LinkedList<>();

  public void ajout_client(String prenom, String nom, int age, double solde,int nb_credit, int numero_compte){
    clientList.addLast(new Client(prenom,nom,age,solde,nb_credit,numero_compte));
  }

  public int getSize(){
    return clientList.size();
  }

  public Client getClient(int numero_compte){
    return clientList.get(numero_compte);
  }

  public void setClient(int numero_compte, Client client){
    clientList.set(numero_compte, client);
  }
}
