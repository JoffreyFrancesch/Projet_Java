package banking;

import java.util.Scanner;
import logger.*;



public class Operation{
  Scanner scanner = new Scanner(System.in);
  Banque banque = new Banque();
  Logger logger = LoggerFactory.getLogger("Oprération");

  public void creer_compte(){
    String prenom, nom;
    int age, numero_compte, nb_credit;
    double premier_depot;
    boolean flag = false;//permet de nous sortir de la boucle quand tout est OK
    //Recuperation du prenom
    logger.info("OUTPUT","Entrez votre Prénom : ");
    prenom = scanner.next();
    logger.info("OUTPUT","Entrez votre Nom : ");
    nom = scanner.next();
    logger.info("OUTPUT","Entrez votre Age : ");
    age = scanner.nextInt();
    if(age < 10){
      logger.error("OUTPUT", "Vous devez avoir au moins 10ans pour créer un compte");
      logger.info("OUTPUT","Entrez votre age de nouveau ");
      age = scanner.nextInt();
    }
    do {
      logger.info("OUTPUT","Entrez un premier dépot d'argent (>0) : ");
      premier_depot = scanner.nextDouble();
      if(premier_depot < 0){
        logger.error("OUTPUT", "Vous devez mettre un montant positif");
      } else {
        flag = true;
      }
    }while(!flag);
    logger.info("PROGRAM","Attribution du numéro de compte");
    numero_compte = banque.getSize();
    nb_credit = 0;
    Client client = new Client(prenom,nom,age,premier_depot,nb_credit,numero_compte);
    logger.info("PROGRAM", "Création du client");
    banque.ajout_client(prenom,nom,age,premier_depot,nb_credit,numero_compte);
    logger.info("PROGRAM", "Ajout du client à la banque");
    logger.info("OUTPUT","Merci d'avoir créé un compte Mr."+  client.getNom().toUpperCase() + " "+ client.getPrenom() + "\nVotre Numero de comtpe est le : " + client.getNumeroCompte() + "\n" + "Il y a pour l'instant " + client.getSolde() + "€\n");
    logger.info("INPUT","Prénom = " + prenom + " Nom = " + nom + " Age = "+ age + " Premier dépot = " + premier_depot);
  }

  public void faire_depot(){
    if(banque.getSize() > 0){
    int numero_compte;
    double depot, nouveau_solde;
    logger.info("OUTPUT","Bonjour sur quel compte voulez vous faire un dépot ? : ");
    numero_compte = scanner.nextInt();
    Client client = banque.getClient(numero_compte);
    logger.info("PROGRAM", "Récupération du client");
    logger.info("OUTPUT","Mr."+ client.getNom().toUpperCase()+" " +client.getPrenom() + " Votre solde est de " + client.getSolde() + "€ Combien voulez vous rajouter sur votre compte ? ");
    depot = scanner.nextDouble();
    client.depot(depot);
    banque.setClient(numero_compte,client);
    logger.info("PROGRAM", "Modification du solde du compte");
    logger.info("INPUT", "Numero compte = " + numero_compte + " Montant = " + depot);
  } else {
    logger.info("OUTPUT","Il n'y à aucun compte en banque");
  }
}
  public void faire_retrait(){
    if(banque.getSize() > 0){
    int numero_compte;
    double retrait, nouveau_solde;
    logger.info("OUTPUT","Bonjour sur quel compte voulez vous faire un retrait ? : ");
    numero_compte = scanner.nextInt();
    Client client = banque.getClient(numero_compte);
    logger.info("PROGRAM", "Récupération du client");
    logger.info("OUTPUT","Mr."+ client.getNom().toUpperCase()+" "+client.getPrenom() + " Votre solde est de " + client.getSolde() + "€ Combien voulez vous retirer sur votre compte ? ");
    retrait = scanner.nextDouble();
    client.retrait(retrait);
    banque.setClient(numero_compte,client);
    logger.info("PROGRAM","Modification du solde du compte");
    logger.info("INPUT","Numero compte = " + numero_compte + " Montant = " + retrait);
  } else {
    logger.info("OUTPUT","Il n'y à aucun compte en banque");
  }
}

  public void historique(){
    int numero_compte;
    logger.info("OUTPUT","Sur quel compte voulez voir votre historique ?");
    numero_compte = scanner.nextInt();
    logger.info("PROGRAM", "Récupération du client");
    Client client = banque.getClient(numero_compte);
    logger.info("OUTPUT","Bonjour Mr."+  client.getNom() + "  "+ client.getPrenom() + "\nVous avez : "+ client.getSolde()+ "€ sur votre compte\n");
    logger.info("INPUT","Compte selectionné = " + numero_compte);
  }

  public void demande_pret(){
    double taux, montant;
    int duree, numero_compte;
    String nom_credit;
    logger.info("OUTPUT","Veuillez selectioner un compte pour faire un crédit\n Numero de compte :");
    numero_compte = scanner.nextInt();
    Client client = banque.getClient(numero_compte);
    logger.info("PROGRAM", "Récupération infos client");
    if(client.getNbcredit() < 2){
    logger.info("OUTPUT","Veuillez entrer le nom du crédit :");
    nom_credit = scanner.next();
    logger.info("OUTPUT","Veuillez entrer un taux : ");
    taux = scanner.nextDouble();
    if(taux <= 1){
      logger.info("OUTPUT","Taux < 1");
      taux = scanner.nextDouble();
    }
    logger.info("OUTPUT","Veuillez entrer une durée :");
    duree = scanner.nextInt();
    if ((duree + client.getAge()) > 70) {
      logger.info("OUTPUT","La duree du crédit est trop longue duree + votre age <= 70");
      logger.info("OUTPUT", "Nouvelle durée :");
      duree = scanner.nextInt();
    }
    logger.info("OUTPUT","De combien voullez vous avoir un crédit : ");
    montant = scanner.nextDouble();
    client.addCredit(nom_credit,taux,duree,montant);
    logger.info("PROGRAM","Calcul du montant à rembourser et ajout du crédit");
    client.setSolde(montant);
    logger.info("PROGRAM","Attribution du crédit demandée");
    logger.info("INPUT", "Choix compte = " + numero_compte + " Nom crédit = " + nom_credit +  " Taux = " + taux + " Durée = " + duree + " Montant = "+montant);
    } else {
    logger.error("OUTPUT","Vous avez déjà 2 crédits");
    }
  }

  public void liste_pret(){
    int numero_compte;
    logger.info("OUTPUT","Quel numéro de compte voulez vous voir ? ");
    numero_compte = scanner.nextInt();
    Client client = banque.getClient(numero_compte);
    logger.info("PROGRAM","Récupération des données client");
    client.afficherPret();
    logger.info("INPUT","Numéro compte = " + numero_compte);
  }

  public void remboursementPret(){
    int numero_compte, numero_credit;
    double montant;
    logger.info("OUTPUT","Sur quel numero de compte voulez vous rembourser un crédit");
    numero_compte = scanner.nextInt();
    Client client = banque.getClient(numero_compte);
    logger.info("OUTPUT","Veuiller entrer le numero de credit à rembourser (0 pour le premier et 1 pour le second)");
    numero_credit = scanner.nextInt();
    Credit credit = client.getCredit(numero_credit);
    logger.info("PROGRAM","Récupération des données client");
    logger.info("PROGRAM","Veuillez entrer le montant que vous voulez rembourser :");
    montant = scanner.nextDouble();
    client.setSolde(-montant);
    if(credit.remboursement(montant)){
      credit = client.remonvecredit(numero_credit);
      logger.info("PROGRAM","SUPPRESION DU CREDIT");
    }
    logger.info("INPUT","Numéro compte = " + numero_compte + " Numéro crédit = " + numero_credit + " Montant = " + montant);
  }

  public void virement(){
    int numero_compte_debit, numero_compte_credit;
    double virement, solde_debit, solde_credit;
    logger.info("OUTPUT","Veuillez entrer le numéro de compte à débiter : ");
    numero_compte_debit = scanner.nextInt();
    logger.info("OUTPUT","Veuillez entrer le numéro de compte à créditer : ");
    numero_compte_credit = scanner.nextInt();
    logger.info("PROGRAM","Récupérations des données clients");
    Client debit = banque.getClient(numero_compte_debit);
    Client credit = banque.getClient(numero_compte_credit);
    logger.info("OUTPUT","Veuiller entrer le montant du virement que vous souhaitez effectuer : ");
    virement = scanner.nextDouble();
    if (virement >= debit.getSolde()){
      logger.error("OUTPUT","La valeur est supérieur au solde du compte débiteur");
      logger.info("OUTPUT","Veuillez entrer une nouvelle valeur : ");
      virement = scanner.nextDouble();
    }
    logger.info("PROGRAM","Calcul des nouveaux soldes");
    solde_debit = debit.getSolde() - virement;
    solde_credit = credit.getSolde() + virement;
    logger.info("PROGRAM","Modification des soldes");
    debit.setSolde(solde_debit);
    credit.setSolde(solde_credit);
    logger.info("PROGRAM","Mise à jour des données clients dans la banque");
    banque.setClient(numero_compte_debit,debit);
    banque.setClient(numero_compte_credit,credit);

    logger.info("INPUT","Compte débit = " + numero_compte_debit + " Compte crédit = " + numero_compte_credit + " Montant virement = " + virement);
  }

}
