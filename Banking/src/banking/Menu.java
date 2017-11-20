package banking;
import java.util.Scanner;

public class Menu{
  Affichage message = new Affichage();
  Operation operation = new Operation();
  Scanner scanner = new Scanner(System.in);

  public void lancement_menu(){
    int choix;
    message.message_acceuil();
    do {
      message.message_selection();
      System.out.println("\033[1;31mEntrer votre choix\033[0m");
      choix = scanner.nextInt();

      switch(choix){
        case 1 :
          operation.creer_compte();
          break;
        case 2 :
          operation.faire_depot();
          break;
        case 3 :
          operation.faire_retrait();
          break;
        case 4 :
          operation.historique();
          break;
        case 5 :
          operation.demande_pret();
          break;
        case 6 :
          operation.liste_pret();
          break;
        case 7 :
          operation.virement();
          break;
        case 8 :
          operation.remboursementPret();
          break;
        case 9 :
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
