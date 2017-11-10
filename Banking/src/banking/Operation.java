package banking;

import java.util.Scanner;


public class Operation{
  Scanner scanner = new Scanner(System.in);
  //Banque banque = new Banque();
  public void creer_compte(){
    String prenom, nom, age = null;
    double premier_depot = 0;

    boolean flag = false;

    System.out.print("Entrer votre Prénom : ");
    prenom = scanner.nextLine();
    System.out.print("Entrer votre Nom : ");
    nom = scanner.nextLine();
    System.out.print("Entrer votre Age : ");
    age = scanner.nextLine();

    do {
      System.out.print("Entrer un premier dépot d'argent (>0) : ");
      premier_depot = scanner.nextDouble();

      if(premier_depot < 0){
        System.out.println("Vous devez mettre un montant positif");
      } else {
        flag = true;
      }
    }while(!flag);

  //banque.ajout_client(prenom,nom,age,premier_depot);
  System.out.println("Vous avez ouvert un comptre au nom de "+ nom + prenom + " %s avec un solde initial de " + premier_depot + "\n");

  }

  public void faire_depot(){
    //int compte = selection_compte();

  }

  public void faire_retrait(){
    //Todo
  }

  public void historique(){
    //Todo
  }

  public void demande_pret(){
    //Todo
  }

  public void liste_pret(){
    //Todo
  }

  public void virement(){
    //Todo
  }
}
