package banking;

import logger.*;

public class Credit{
  public double taux;
  public int duree;
  public double montant_a_rembourse;
  public double montant_en_cours_rembourse;
  public String nom_credit;
  public int numero_credit;
  Logger logger = LoggerFactory.getLogger("Credit");

  public Credit(String nom_credit,double taux, int duree, double montant_a_rembourse, double montant_en_cours_rembourse, int numero_credit){
    this.nom_credit = nom_credit;
    this.taux = taux;
    this.duree = duree;
    this.montant_a_rembourse = montant_a_rembourse;
    this.montant_en_cours_rembourse = montant_en_cours_rembourse;
    this.numero_credit = numero_credit;
  }

  public boolean remboursement(double montant){
    if((montant + montant_en_cours_rembourse) >= montant_a_rembourse){
      logger.info("OUTPUT","Crédit fini");
      return true;
    } else {
      montant_en_cours_rembourse += montant;
      return false;
    }
  }

}
