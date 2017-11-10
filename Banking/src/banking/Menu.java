package banking;
import java.util.Scanner;

public class Menu{
  Affichage message = new Affichage();
  Operation operation = new Operation();
  Scanner scanner = new Scanner(System.in);

  public void lancement_menu(){
    char choix = '\0';
    message.message_acceuil();
    do {
      message.message_selection();
      System.out.println("Entrer votre choix");
      choix = scanner.next().charAt(0);

      switch(choix){
        case 'a' :
          operation.creer_compte();
          break;
        case 'd' :
          operation.faire_depot();
          break;
        case 'r' :
          operation.faire_retrait();
          break;
        case 'h' :
          operation.historique();
          break;
        case 'c' :
          operation.demande_pret();
          break;
        case 'l' :
          operation.liste_pret();
          break;
        case 'v' :
          operation.virement();
          break;
        case 'q' :
          System.out.println("Vous avez quitté. Merci de votre visite");
          System.exit(0);
          break;
        default:
          System.out.println("Valeur erronée");
          break;
      }
    } while (choix !='q');
  }
}
