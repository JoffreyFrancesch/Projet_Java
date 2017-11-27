PROJET POO 3A 2017
==================

Membres de l'équipe :
---------------------
- Joffrey Franceschini Classe 34
- Yannis Belaïd Classe 34
- Mehdi Soltana Classe 34

Lien du repositories Git :
------------------------------

Rendez-vous sur [GitHub](https://github.com/JoffreyFrancesch/Projet_Java) pour récupérer les fichiers du projet.


Objectifs :
-----------
* Ecrire une librairie pour historiser les évènements
* Ecrire une librairie pour tester du code
* Utiliser ces deux librairies pour construire un projet simple de gestion de compte en banque

Scripter le lancement (bash unix) :
  * de la compilation
  * du lancement des tests
  * du lancement du programme de gestion de compte en banque


Organisation des fichiers :
---------------------------
* Logger
  * src
    - Logger.java
    - LoggerFactory.java
    - ConsoleLogger.java
    - CompositeLogger.java
    - ContextualLogger.java
    - FileLogger.java
  * bin
    * .class


* TestFrameWork
  * src
    * RunTest.java
  * bin
    * .class


* Banking
  * src
    - Main.java -> contient le main
    - Menu.java -> permet de choisir les opérations
    - Affichage.java -> contient le cadre et les choix
    - Banque.java -> liste des clients
    - Client.java -> information client
    - Credit.java -> information crédit
    - Operation.java -> fait les opérations
  * bin
    * .class


* compile.sh -> script de compilation
* launch_baning.sh -> lance le programme de Banque
* test.sh -> lance les tests
* readme.md -> fichier readme en Markdown

Informations sur le Logger :
----------------------------

Le logger du projet reprend essentiellement le logger du TP sur le guessgame, il fonctionne de la même manière. Nous l'utilisons dans pour écrire dans le fichier des logs et dans le terminal directement.

La syntaxe sur la console est dans le fichier est différente, dans le terminal nous écrivons juste par exemple :

  `OUTPUT Veuillez entrer un montant`

  `INPUT Montant rentré = 100`

  `PROGRAM Récupération des infos clients`

  La syntaxe dans le fichier log est différente par exemple nous avons :

  `OUTPUT 2017-11-23	16:03:32.646	Veuillez entrer un montant`

  `INPUT 2017-11-23	16:03:32.646	Opération	Montant rentré = 100`

  `PROGRAM 2017-11-23	16:03:32.646	Opération	Récupération des infos clients`

Nous avons choisi de faire ainsi pour éclaircir l'affichage en terminal. Cet affichage se fait dans le fichier __LoggerFactory.java__ où nous contrôlons la création des deux loggers. Grâce au code ci-dessous.

```java
public class LoggerFactory  {
	public static Logger getLogger(String name){
		return new CompositeLogger(name, new ConsoleLogger(), new ContextualLogger(new FileLogger("log.txt"),name));
	}
}
```


Informations sur le TestFrameWork :
-----------------------------------

Dans cette partie nous bouclons sur toutes les classes que nous appelons dans notre __test.sh__ c'est à dire toutes les classes de notre projet, grâce à la boucle __for__ ci-dessous.

 ```java
  for(String className : args){
    //...
  }
 ```

 Pour ensuite tester classe par classe et méthode par méthode on a encapsulé plusieurs __try/catch__ voici notre code :

  ```java
  try {
    clazz = Class.forName(className);
    long endTime = System.currentTimeMillis();
    System.out.println("Classe : "+ className+ " : OK  "+(endTime-startTime)+" ms");
    reussite++;
    for(Method method : clazz.getDeclaredMethods()) {//Boucle pour tester chaque méthode
      try {
        clazz = Class.forName(className);
        System.out.println("	Methode : "+method.getName()+" : OK");
      } catch (ClassNotFoundException e) {
        System.out.println("	Methode : "+method.getName()+" : KO");
        erreur++;
      }
      reussite++;
      cpt++;
    }
    System.out.println("\n");
    cpt=1;
  } catch (ClassNotFoundException e) {
    System.out.println("Classe : "+ className +" KO");
    erreur++;
  }
  ```

Informations sur le Banking :
-----------------------------

La partie Banking respecte les critères demandés.

Un client contient plusieurs informations tel que :
  - Son prénom
  - Son nom
  - Son age
  - Son solde
  - Son numero de compte
  - Son nombre de credit
  - Sa liste des crédits

  ```java
  public class Client{
      private final String prenom;
      private final String nom;
      private final int age;
      private double solde;
      private final int numero_compte;
      private int nb_credit;
      private List<Credit> creditList = new ArrayList<Credit>();

    //méthodes...
  }
  ```

  Un crédit contient plusieurs informations tel que :
  - Son taux
  - Sa durée
  - Son montant à rembourser (incluant les mensualités)
  - Le montant qui à été remboursé
  - Le nom du Crédit
  - Le numero du Crédit

  ```java
  public class Credit{
      public double taux;
      public int duree;
      public double montant_a_rembourse;
      public double montant_en_cours_rembourse;
      public String nom_credit;
      public int numero_credit;

  //méthodes...
  }
  ```

  La banque contient toutes les informations précédentes grâce à une liste chainée qui prend toutes les informations du client et des crédits du client.

  ```java
  public class Banque{
    LinkedList<Client> clientList = new LinkedList<>();

  //méthodes...
  }
  ```



TODO LIST :
-----------
* Partie Banking :

  - [x] Creer Compte
  - [x] Dépot
  - [x] Retrait
  - [x] Virement
  - [x] Historique du compte
  - [x] Demande crédit
  - [x] Historique de crédit
  - [x] Remboursement crédit
  - [x] Quitter

* Partie Logger :

  - [x] Logger.java
  - [x] LoggerFactory.java
  - [x] ConsoleLogger.java
  - [x] CompositeLogger.java
  - [x] ContextualLogger.java
  - [x] FileLogger.java


* Partie TestFrameWork :
  - [x] Test classes
  - [x] Test méthodes
