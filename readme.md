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
    * .java
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

  `INPUT 2017-11-23	16:03:32.646	Oprération	Montant rentré = 100`

  `PROGRAM 2017-11-23	16:03:32.646	Oprération	Récupération des infos clients`

Nous avons choisi de faire ainsi pour éclairscire l'affichage en terminal. Cet affichage ce dans le fichier __LoggerFactory.java__ où nous contrôlons la création des deux logger. Grâce au code ci-dessous.

```java
public class LoggerFactory  {
	public static Logger getLogger(String name){
		return new CompositeLogger(name, new ConsoleLogger(), new ContextualLogger(new FileLogger("log.txt"),name));
	}
}
```


Informations sur le TestFrameWork :
-----------------------------------

Dans cette partie nous testons nos deux méthodes de retrait et dépôt en utilisant le try/catch pour récupérer les erreurs s'il y en a.

```java
Client client = new Client("Arnaud","Dupont",26,10,0,0);
//Client Arnaud Dupont 26 ans 10€ sur le compte Numero de compte 0 et Nb de Crédit 0
  try{//test méthode de dépot
    client.depot(10);//sans erreur
  } catch (Error e){
    //traitement de l'erreur
  }

  try {
    client.depot(-10);//avec erreur   
  } catch(Error e) {
    //traitement de l'erreur
  }
```

Nous faisons pareil pour la méthode retrait :

  ```java
Client client = new Client("Arnaud","Dupont",26,10,0,0);
  //Client Arnaud Dupont 26 ans 10€ sur le compte Numero de compte 0 et Nb de Crédit 0
  try{
    client.retrait(5);//sans erreur
  } catch (Error e) {
    //traitement de l'erreur
  }

  try{
    client.retrait(50);//avec erreur car 10€ sur le compte
  } catch (Error e) {
    //traitement de l'erreur
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
  - Son montant à rembourser (incluant les mensualtées)
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

  La banque contient toute les informations précédentes grâce à une liste chainée qui prend toute les informations du client et des crédits du client.

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
  - [ ] test sur depot
  - [ ] test sur retrait
