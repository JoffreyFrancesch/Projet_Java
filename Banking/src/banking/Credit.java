package banking;

public class Credit{
  public double taux;
  public int duree;
  public double montant_demander;
  public double montant_a_rembourse;
  public double montant_rembourse;
  public String nom_credit;

  public Credit(String nom_credit,double taux, int duree, double montant, double montant_rembourse){
    this.nom_credit = nom_credit;
    this.taux = taux;
    this.duree = duree;
    this.montant = montant;
    this.montant_rembourse = montant_rembourse;
  }

  public void remboursement(double valeur_montant){
    if (valeur_montant <= montant){
      montant_rembourse += valeur_montant;
    }
  }

  public void setMontantARembourser(){
    int mensualitee = (montant_demander*taux)/(1-((1+taux)^(duree*12)));
    montant_a_rembourse = mensualitee*(duree*12) + montant_demander;
  }

  public boolean remboursementFini(){
    if(montant == montant_a_rembourse){
      return true;
    } else {
      return false;
    }
  }

}
