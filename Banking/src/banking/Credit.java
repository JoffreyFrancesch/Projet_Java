package banking;

public class Credit{
  public double taux;
  public int duree;
  public double montant_a_rembourse;
  public double montant_en_cours_rembourse;
  public String nom_credit;

  public Credit(String nom_credit,double taux, int duree, double montant_a_rembourse, double montant_en_cours_rembourse){
    this.nom_credit = nom_credit;
    this.taux = taux;
    this.duree = duree;
    this.montant_a_rembourse = montant_a_rembourse;
    this.montant_en_cours_rembourse = montant_en_cours_rembourse;
  }

  public boolean remboursementFini(double montant){
    if((montant + montant_en_cours_rembourse) == montant_a_rembourse){
      System.out.println("Pret fini");
      return true;
    } else {
      montant_en_cours_rembourse += montant;
      return false;
    }
  }

}
