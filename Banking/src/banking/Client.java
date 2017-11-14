package banking;

public class Client{
  private String prenom;
  private String nom;
  private int age;
  private double solde;
  private int numero_compte;
  private int nb_credit;

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
  public int getNbcredit(){
    return nb_credit;
  }
}
