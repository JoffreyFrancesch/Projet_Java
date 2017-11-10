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
    System.out.println("Que voulez vous faire ?");
    System.out.println("a.  Creation d'un compte");
    System.out.println("d.  Faire un dépot");
    System.out.println("r.  Faire un retrai");
    System.out.println("h.  Historique de votre compte");
    System.out.println("c.  Demander un crédit");
    System.out.println("l.  Liste des prêts");
    System.out.println("v.  Faire un virement");
    System.out.println("q.  Quitter");
    System.out.println("\n");
  }
}
