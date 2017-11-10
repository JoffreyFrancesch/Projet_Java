package banking;

public class Client{
  private String prenom;
  private String nom;
  private int age;
  private double solde;

  public Client(String prenom, String nom, int age,double solde){
    this.prenom = prenom;
    this.nom = nom;
    this.age = age;
    this.solde = solde;
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

  public String info(){
    return "Voici ce que contient votre compte" + getNom() + getPrenom() + getAge() + getSolde();
  }
}
