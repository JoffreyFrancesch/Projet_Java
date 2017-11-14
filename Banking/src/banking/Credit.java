package banking;

public class Credit{
  public double taux;
  public int duree;
  public double montant;
  public String nom_credit;

  public Credit(String nom_credit,double taux, int duree, double montant){
    this.nom_credit = nom_credit;
    this.taux = taux;
    this.duree = duree;
    this.montant = montant;
  }

  public void setTaux(int taux){
    //TODO
  }

  public void setMontant(double nombre, Client client){
    //TODO
    montant = nombre;
    client.setSolde(montant);
  }

  public void setDuree(int nombre, Client client){
    if((client.getAge() + duree)<= 70){
      duree = nombre;
    } else {
      System.out.println("La duree est trop longue depasse 70 ans");
    }
  }

  public void setNomCredit(String nom){
    nom_credit = nom;
  }

}
