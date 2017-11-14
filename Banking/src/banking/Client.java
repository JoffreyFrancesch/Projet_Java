package banking;

import java.util.ArrayList;
import java.util.List;

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
  // public int getNbcredit(){
  //   return nb_credit;
  // }

  public void depot(double montant){
    if (montant > 0){
      solde += montant;
    } else {
      //throw new IllegalArgumentException("Montant negatif " + montant);
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

  public void setNbcredit(int nombre){
    nb_credit = nombre;
  }

  public int getNbcredit(){
    return creditList.size();
  }

  public void addCredit(String nom_credit,double taux, int duree, double montant){
    creditList.add(new Credit(nom_credit,taux,duree,montant));
  }
}
