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

//TODO

Informations sur le TestFrameWork :
-----------------------------------

//TODO

Informations sur le Banking :
-----------------------------

//TODO

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
  - [ ] Remboursement crédit
  - [x] Quitter

* Partie Logger :

  - [x] Logger.java
  - [x] LoggerFactory.java
  - [x] ConsoleLogger.java
  - [x] CompositeLogger.java
  - [x] ContextualLogger.java
  - [x] FileLogger.java


* Partie TestFrameWork :
ALL...
