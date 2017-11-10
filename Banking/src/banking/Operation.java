package banking;

import java.util.Scanner;


public class Operation{
  Scanner scanner = new Scanner(System.in);
  Banque banque = new Banque();


  public void creer_compte(){
    String prenom, nom;
    int age;
    double premier_depot = 0;
    boolean flag = false;

    System.out.print("Entrer votre Prénom : ");//Recuperation du prenom
    prenom = scanner.nextLine();

    System.out.print("Entrer votre Nom : ");//Recuperation du nom
    nom = scanner.nextLine();

    System.out.print("Entrer votre Age : ");//Recuperation de l'age
    age = scanner.nextInt();

    do {
      System.out.print("Entrer un premier dépot d'argent (>0) : ");//Recuperation du premier depot
      premier_depot = scanner.nextDouble();

      if(premier_depot < 0){//Verif depot > 0
        System.out.println("Vous devez mettre un montant positif");
      } else {
        flag = true;
      }
    }while(!flag);

    Client client = new Client(prenom,nom,age,premier_depot);//Création du nouveau client
    banque.ajout_client(prenom,nom,age,premier_depot);//Ajout du Client a la liste des clients
  }

  public void faire_depot(){
    //Todo
  }

  public void faire_retrait(){
    //Todo
  }

  public void historique(){
    //Todo
    //client.info();
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
