package banking;

import java.util.ArrayList;
import java.util.List;
import logger.*;

public class Client{
  private final String prenom;
  private final String nom;
  private final int age;
  private double solde;
  private final int numero_compte;
  private int nb_credit;
  private List<Credit> creditList = new ArrayList<Credit>();

  public Client(String prenom, String nom, int age,double solde, int nb_credit,int numero_compte){
    this.prenom = prenom;
    this.nom = nom;
    this.age = age;
    this.solde = solde;
    this.numero_compte = numero_compte;
    this.nb_credit = nb_credit;
  }

  public String getPrenom(){
    return prenom;
  }

  public String getNom(){
    return nom;
  }

  public int getAge(){
    return age;
  }

  public double getSolde(){
    return solde;
  }

  public int getNumeroCompte(){
    return numero_compte;
  }

  public void depot(double montant){
    if (montant > 0){
      solde += montant;
    } else {
      System.out.println("Montant négatif " + montant);
    }
  }

  public void retrait(double montant){
    if (montant <= solde){
      solde -= montant;
    } else {
      System.out.println("Montant supérieur au solde " + montant + solde);
    }
  }

  public void setSolde(double montant){
    solde += montant;
  }

  public int getNbcredit(){
    return creditList.size();
  }

  public void addCredit(String nom_credit,double taux, int duree, double montant){
    double montant_final;
    montant_final = ((montant * ((taux/100)/12))/(1 - Math.pow(1+((taux/100)/12),-(duree*12))))*(duree*12);
    int numero_credit;
    numero_credit = creditList.size();
    creditList.add(new Credit(nom_credit,taux,duree,montant_final,0,numero_credit));
  }

  public Credit getCredit(int numero_credit){
    return creditList.get(numero_credit);
  }

  public void afficherPret(){
    if (creditList.size() == 0){
      System.out.println("Vous n'avez aucun crédit en cours");
    } else {
      for (Credit credit : creditList){
        System.out.println("Numéro credit : " + credit.numero_credit + "\nNom du credit : " +  credit.nom_credit + "\nDurée : " + credit.duree + "\nMontant & Taux : " + credit.montant_a_rembourse + "€ à " + credit.taux +"%\n" + "Et vous avez rembourser :" + credit.montant_en_cours_rembourse + "€\n");
      }
    }
  }

  public Credit remonvecredit(int numero_credit){
    return creditList.remove(numero_credit);
  }
}
