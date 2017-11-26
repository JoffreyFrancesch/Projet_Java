package testframework;

import banking.Client;

public class maintest{

  public static void main(String[] args) {
    Client client = new Client("joffrey","franceschini",20,10,0,0);
    boolean test1 = false;
    try {
      client.depot(-10);
    } catch(Error e) {
      test1 = true;
    }
    if (test1){
      System.out.println("Test1 OK");
    } else {
      System.out.println("Test1 KO");
    }

    // if(!test){
    //   System.out.println("Test effectuer sans souci");
    // } else {
    //   System.out.println("Test effectuer avec un souci");
    // }

    // try {
    //   client.depot(-10);
    // } catch(Error e) {
    //   System.out.println("TEST KO");
    // }
  }
}
