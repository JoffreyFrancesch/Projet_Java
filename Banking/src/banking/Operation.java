package banking;

import java.util.Scanner;


public class Operation{
  Scanner scanner = new Scanner(System.in);
  Banque banque = new Banque();


  public void creer_compte(){
    String prenom, nom;
    int age, numero_compte;
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

    numero_compte = banque.getSize();

    Client client = new Client(prenom,nom,age,premier_depot, numero_compte);//Création du nouveau client
    banque.ajout_client(prenom,nom,age,premier_depot, numero_compte);//Ajout du Client a la liste des clients
    System.out.println("Merci d'avoir créer un compte Mr."+  client.getNom() + " "+ client.getPrenom() + " Et vous avez "+ client.getAge() + " ans" + " Votre Numero de comtpe est le : " + client.getNumeroCompte() + "\n");
  }

  public void faire_depot(){
    int numero_compte;
    double depot, nouveau_solde;
    System.out.println("Bonjour sur quel compte voulez vous faire un depot ? : ");
    numero_compte = scanner.nextInt();
    Client client = banque.getClient(numero_compte);
    System.out.println("Votre solde est de " + client.getSolde() + ". Combien voulez vous rajouter sur votre compte ? ");
    depot = scanner.nextDouble();
    nouveau_solde = depot + client.getSolde();
    banque.setNouveauSolde(numero_compte,nouveau_solde);
  }

  public void faire_retrait(){
    int numero_compte;
    double retrait, nouveau_solde;
    System.out.println("Bonjour sur quel compte voulez vous faire un depot ? : ");
    numero_compte = scanner.nextInt();
    Client client = banque.getClient(numero_compte);
    System.out.println("Votre solde est de " + client.getSolde() + ". Combien voulez vous retirer sur votre compte ? ");
    retrait = scanner.nextDouble();
    nouveau_solde = client.getSolde() - retrait;
    if(nouveau_solde >= 0){
      banque.setNouveauSolde(numero_compte,nouveau_solde);
    } else {
      System.out.println("Vous n'avez pas le droit de retirer plus que vous n'avez");
    }
  }

  public void historique(){
    int numero_compte;
    System.out.println("Quel numéro de compte voulez vous voir ? ");
    numero_compte = scanner.nextInt();
    Client client = banque.getClient(numero_compte);
    System.out.println("Bonjour Mr."+  client.getNom() + " "+ client.getPrenom() + "Vous avez : "+ client.getSolde()+ "€ sur votre compte\n");
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
