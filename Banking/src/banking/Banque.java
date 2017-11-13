package banking;

import java.util.LinkedList;
public class Banque{

  LinkedList<Client> clientList = new LinkedList<>();

  public void ajout_client(String prenom, String nom, int age, double solde, int numero_compte){
    clientList.addLast(new Client(prenom,nom,age,solde,numero_compte));
  }

  public int getSize(){
    return clientList.size();
  }

  public Client getClient(int numero_compte){
    return clientList.get(numero_compte);
  }

  public void setNouveauSolde(int numero_compte, double nouveau_solde){
    clientList.set(numero_compte, Client(prenom,nom,age,nouveau_solde,numero_compte));
  }
}
