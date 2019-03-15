# Nom des étudiants de ce binôme 
LOISEAU Arnaud Et BLANCHARD Aldvine

Commentaires éventuels des étudiants : 
# Exercice 1 - Réusiner la classe 'MailComparator'
* Mise en place de constante pour une meilleure compréhension du code et éviter la dupplication.
* Création de méthode pour diviser le code et de permettre une meilleure maintenabilité de la classe. Permettre la réutilisabilité des méthodes.
* Renommage des variables ambigues pour éviter l'imcompréhension du code.

L'objectif de l'exercice était de nous montrer l'importance du refactoring dans la conception logicielle.

# Exercice 2 - Découpage en couche
* Mise en place de différentes couches comme vu en cours:
1) Une couche Présentation contenant la classe 'ClientMail' et 'InterpreteurLigneCommande'. Nous avons mis ces deux classes dans la couche présentation car elles représentent la demande client et c'est cette demande qui va être envoyée au service.
2) Une couche Service contenant la classe 'MailService'. Cette classe fait la transition entre la présentation et l'infrastructure.
3) Une couche Domaine contenant la classe 'Mail'. Cette classe représente la structure d'un mail.
4) Une couche Infrastructure contenant la classe 'MailSender'. C'est dans cette couche que l'on a la relation avec les différents serveurs de l'application. Dans notre cas, on affiche juste un message d'envoi de mail.

L'objectif de l'exercice était de nous faire comprendre le fonctionnement du découpage en couche et le but de cette architecture.

# Exercice 3 - Injection de dépendances
En observant le code du première exercice, nous avons remarqué la dépendance concernant l'initilisation de classe pour réaliser la transition entre les couches.
Avec les notions d'injection de dépendances vu en cours, nous avons mis en place cette solution sur le nouveau code mis à disposition.
* Dans un premier temps nous avons complété la méthode configure. C'est dans cette méthode que l'on va instancier le framework d'injection Guice.
* Ensuite, nous avons mis en place le principe d'injection concernant les classes 'InterpreteurLigneCommande', 'MailService' et 'MailSender'.

En implémentant ces modifications, nous avons plus besoin d'implémenter la classe 'MailService' et 'MailSender' pour utiliser la classe 'InterpreteurLigneCommande'.

# Exercice 4 - Test Unitaire
Pour cette exercice, nous avons ajouté des tests dans les test cases 'MailComparatorTest' :
* mail1PlusImportantQueLeMail2SiMail1ALeStatutImportantAVrai
* mail1PlusImportantQueLeMail2SiMail1AUneDate
* mailLuPlusGrandQuePasLu
* mailSentPlusGrandQueUnsentEtPlusPetitQueRead

Nous avons aussi ajouté et complété des tests dans les test cases 'MailTest' :
* erreurSiDateAvant1970
* erreurSiDateApres2100

Pour réaliser ces tests, nous leurs avons donnés des noms explicites afin de mieux distinguer le contenu de chaque test.

# Exercice 5 - BDD avec Cucumber-jvm
Dans un premier temps nous avons complété la classe MailComparaisonStep. Pour cette étape, nous avons complété les méthode un_premier_mail, un_second_mail, et le_tri_doit_retourner.
Le but de ces méthodes est de vérfier le bon fonctionnement de la méthode compare de la classe MailComparator. En effet, avec Cucumber, il est possible d'établir un certain nombre d'enregistrement utilisant les mêmes méthodes de tests.
Cela permet d'avoir un test qui est appliqué à un certain nombre de propriété.

Ensuite, nous avons compléter les cas de tests dans la feature trier_mail.feature pour affiner le fonctionnement de la méthode compare de la classe MailComparator. A ce moment, nous avons remarqué que la méthode de comparaison des dates n'étaient pas fonctionnelle.
Nous avons donc modifié cette méthode afin que la méthode général compare de la classe MailComparator réponde au besoin final.

Pour finir sur cet exercice, nous avons créé notre propre scenario 'Validation du mail'. Pour cela nous avons créé la classe MailValidStep afin de détailler les étapes de notre scénario.
L'objectif de ce scenario est de vérifier le contenu du mail afin qu'il corresponde à des critères. Nous avons donc ajouté un critère de besoin, le sujet ne dois pas être vide, concernant la création de mail.

Grâce à cet exercice, nous avons pu utiliser Cucumber et comprendre l'efficacité d'un tel outil, tant en sa simplicité d'utilisation mais aussi en son efficacité des résultats.

# Difficultés rencontrées
Les premières difficultés que nous avons eu concernaient la compréhension de la globalité du code. Une fois que nous avions pris en main le code, nous n'avons pas eu de réel diffultés sur les deux premiers exercices.
Cependant, nous avons mis du temps à comprendre le fonctionnement de l'injection de dépendance durant l'exercice 3, mais une fois que nous avions assimilé le fonctionnement de l'injection de dépendances avec le langage JAVA cela nous a permis de meux comprendre le principe de l'injection de dépendances. Ensuite, nous avons réaliser les TU où nous n'avons pas eu de difficultés à les réalisés. 
Pour finir, lors de la réalisation du 5ème exercice, nous avons eu du mal à comprendre l'organisation de Cucumber. En travaillant plusieurs heures dessus, nous avons réussi à comprendre le fonctionnement de Cucumber et de BDD, et à finir le travail demandé.

# Conclusion
En effectuant ce TP, nous avons appliqué les différents principes de conception vu en cours. Cela nous a permis de mieux comprendre ces principes et de revoir le cours plus en détail.

# Pré-requis 
* Disposer d'au moins un compte github par binome
* Apporter son portable (les postes de l'université n'ont pas accès au proxy depuis Eclipse). Pas de préférence pour l'OS (Linux, OSX ou Windows).
* JDK 8 ou 9
* Eclipse récent installé
* Plugins Eclipse à installer : infinitest, natural (chercher "cucumber")
* Utiliser votre connexion Internet (data), pas le wifi de l'université (pour lequel il faut configurer le proxy HTTP).
* Forker sur Github le projet `bflorat/tp1-miage-2019` puis cloner votre dépôt Github (avec l'__url ssh__) dans votre workspace. Attention : __un seul fork par binôme__.
* Dans le `README.md` de votre projet, mentionner votre nom et celui de votre binome __(ne pas oublier !)__

# Déroulement du TP
_<Rappel sur les remotes git : trois dépots utilisés : le dépot Github upstream, le dépot Github personnel, le dépot local>_

Nous fournissons trois projets Eclipse servant de base de travail aux exercices suivant. Cela permet un point de synchronisation de tous les étudiants à différents moments du TP. 
* Le projet ex1-ini est le code initial du TP et sert de base aux exercices 1 et 2. Une fois terminés, faire un push vers Github et fermer le projet Eclipse (ne pas le supprimer).
* Le projet ex3-ini sert de code de base aux exercices 3 et 4. Une fois terminés, faire un push vers Github et fermer le projet Eclipse (ne pas le supprimer).
* Le projet ex5-ini sert de code de base à l'exercice 5. Une fois terminé faire un push vers Github.

# Exercice 1 - Refactoring
_Temps estimé : 20 mins_

__Travailler dans le projet fourni mailreader-ex1-ini__

1) Réusiner la classe `MailComparator`

Raccourcis clavier à connaître : 
* ALT-SHIFT-S : fonctions Eclipse de génération de sources (ex : constructeurs)
* ALT-SHIFT-T : fonctions de réusinage
* ALT-SHIFT-M : extraction de méthode (sur sélection)
* ALT-SHIFT-R : renommage (sur sélection)

# Exercice 2 - Découpage en couches
_Temps estimé : 20 mins_

1) Réorganiser le code dans les couches standards. 

Faire en sorte par exemple que divers frontends puisse récupérer les mails. Nous aurons dans ce TP un seul frontend : un CLI (ligne de commande) qui sera implémenté sous la forme d'une classe `ClientMail` avec `main()`. 
Cette méthode main attend deux arguments : un booleen `production` qui précise si le mail doit vraiment être envoyé (`true`) ou si nous sommes en environnement de recette (`false`). Le second argument est le sujet du mail.

Rappel : exemple de méthode main qui parse un boolean : 
```
public static void main(String[] args) {
   production = Boolean.parseBoolean(args[0]);
   ...		
```
Conception :

![diag sequence](http://www.plantuml.com/plantuml/proxy?src=https://raw.githubusercontent.com/bflorat/tp1-miage/master/diag1.puml&ttt=1)
![diag classe](http://www.plantuml.com/plantuml/proxy?src=https://raw.githubusercontent.com/bflorat/tp1-miage/master/diag2.puml&ttt=1)

Prévoir une cinquième couche `commun` pour les éléments communs à toutes les couches comme les exceptions. 

`MailSender` est une interface, le choix de l'implémentation est fait par l'application en fonction de la valeur du booléen `production`.

# Exercice 3 - Injection de dépendances avec Guice
_Temps estimé : 20 mins_

Point de synchro : repartir du projet fourni `mailreader-ex3-ini`

Guice est le framework d'injection de dépendance en Java de Google. Il est léger et la configuration se fait en java (et non par fichier XML ou par annotations). Ses concurrents en Java sont principalement Spring Core et CDI dans le monde JEE. Ce pattern est également présent dans la plupart des languages, comme dans Symphony en PHP ou AngularJS en JavaScript.

La méthode `configure()` de la classe `MailReaderModule` contient la configuration de Guice. C'est ici qu'on associe une interface à la classe contrète qui sera injectée. Exemple :
```
bind(MonInterface.class).to(MaClasseConcrete.class)
```
Il est bien sûr également possible d'injecter des classes concrètes (comme ici le `MailService`).

1) Compléter la méthode `configure()`
Observer la méthode `ClientMail.main()` : elle charge la configuration et créé l'objet de haut niveau de l'arbre d'injection : un `InterpreteurLigneCommande`.

2) L'objet `InterpreteurLigneCommande` a besoin d'un `MailService`. Lui injecter (injection par constructeur) via l’annotation (standard java) `@Inject`.

3) Faire de même pour l'injection du `MailSender` dans le `MailService`.

# Exercice 4 - TU
_Temps estimé : 30 mins_

1) Compléter les tests unitaires ou en écrire de nouveaux dans les test cases `MailTest` et `MailComparatorTest`. Enlever les annotations `@Ignore` s'il y en a.

2) Exécuter vos tests si besoin (automatique si vous pratiquez le test continu avec infinitest).

# Exercice 5 - BDD avec Cucumber-jvm
_Temps estimé : 40 mins_

Point de synchro : repartir du projet fourni `mailreader-ex5-ini`

cucumber-jvm est l'implémentation java de cucumber, un framework de BDD (Behavioral Driven Development) très populaire. Il est existe d'autres : JBehave (l'original, très similaire), Concordion, JGiven ...

Pour les besoins du TP, nous utilisons ici les notions de Scenario Outline, de Data Table et de Transformer permettant l'utilisation de données tabulaires et de formats custom.

1) Compléter la classe `MailComparaisonStep`
2) Lancer le test `CucumberRunnerTest` en junit
3) Ouvrir dans un navigateur `target/cucumber/index.html`
4) Ajouter des cas de test dans la feature `trier_mail.feature`. Notez qu'aucun nouveau code n'a été nécessaire pour ajouter ces tests contrairement à un TU.

5) Ecrire un scenario simple au format textuel et les steps correspondants.

# Cleanup
Si vous le désirez, vous pourrez supprimer votre projet github mais pas avant fin juin (noté)

