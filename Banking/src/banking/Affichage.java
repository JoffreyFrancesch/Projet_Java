package banking;

public class Affichage{
  public void message_acceuil(){
    System.out.println("            +-----------------------------------------------+");
    System.out.println("            |                   Bienvenue                   |");
    System.out.println("            |                                               |");
    System.out.println("            +-----------------------------------------------+");
    System.out.println("\n");
  }

  public void message_selection(){
    System.out.println("Que voulez vous faire ?\n");
    System.out.println("1.  Creation d'un compte  |  5.  Demander un prêt");
    System.out.println("2.  Faire un dépot        |  6.  Liste des prêts");
    System.out.println("3.  Faire un retrai       |  7.  Faire un virement");
    System.out.println("4.  Historique            |  8.  Remboursement Prêt");
    System.out.println("                    9. QUITTER");
    System.out.println("\n");
  }
}
