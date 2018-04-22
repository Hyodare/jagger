Membre du groupe :

-FRANCOIS Pierrick
-DURE Lucas

make (pour tout compiler)
make test (pour exécuter les tests)
make complet (pour tout compiler et exécuter les tests)

Ce qui est fait :

Globalement nous avons juste fait ce qui était proposé, donc jusqu'au "for".
Notre syntaxe diffère un peu de ce qui est demandé :

- Chaque AST est séparé avec un ; 
- Le programme principal est composé d’une série d’AST:
- les symbole : “ “,”\n”,”\t” sont ignorés
- les opérations disponibles sont:
	-unaires : +,-
	-binaires : + , - , * , / , > , < , == , >= , <= , <>
- il existe trois types de valeurs possibles:
	-Bool -> boolean -------> 0
	-CharC -> String -------> 2
	-Num -> Double -------> 1
- toute opération avec des types incorrects renverra une Erreur.
- les opérations valides sont:
	- + Any -> Any
	- -Num -> Num (opposé)
	- -Bool -> Bool  ( !Bool)
	- Num + , - , / , * Num -> Num
	- Num > , < , == , >= , <= , <> Num ->Bool
	- Num * CharC -> CharC (la répétition de CharC)
	- CharC + CharC -> CharC (concatenation)
	- CharC + Num -> CharC (concaténation de la String du Num)
	- CharC > , < , == , >= , <= , <> CharC ->Bool
	- Bool	+ , * Bool -> Bool (respectivement || , &&)

Toute autre opération renverra une erreur.
les opérations de même importance 

- Il n’y a à, proprement parler, pas de “Type Checking” mais les les classes des différentes valeurs sont utilisées pour les opérations : cette méthode nous a permis d'alléger grandement le visiteur et de rendre plus simple l’ajout de nouveau type de valeurs:
	il suffira maintenant de créer une classe qui hérite de Val et comporte toute les opérations, ensuite il faudra juste modifier les classes liées. 
	Si une opération n’existe pas elle renverra donc une Erreur qui sera propagé à toutes les opérations dépendantes (au dessus) On aura donc repéré l’erreur.
	Le seul problème possible est lors d’un if ou on ne peut exécuter qu’une seule des possibilités. Or dans notre cas, le if ne supporte que les expressions  qui ne peuvent pas avoir d’effet de bord on peut donc les lire les deux sans changer le fonctionnement du programme.
	Sinon il aurait fallu créer une classe se comportant de façon très similaire a l'évaluateur mais exécutant les deux côtés.

- Le print( ) prend en paramètre une expression peu importe son type.
- le If - then - else  contient forcément ces 3 parties: il prend en condition un expression qui renvoie un type Bool et en then et else deux expressions qui renvoient un type identique.

- le LetIn permet de créer un scope initialisé avec plusieurs variables suivi d’une suite d’AST (expression ou instruction) sous la forme :

let	var i := 0
	var z := 1
in 	ensAST()
		…
end;

-une variable qui existait déjà avant le début du scope vas être remplacé puis remis à la valeur précédente  a la fin du scope.
-une variable ne peut pas être definit 2 fois dans le même scope
-une variable du scope non defini precedemment est supprimé à la fin du scope

- le while permet de faire des boucles : il est défini par une expression de type Bool qui doit être true pour que la boucle continue et une série d’instructions à exécuter dans la boucle: on l'écrit de la façon suivante :
	
	while exp()
	do	ensAST()
		…

	end;

-le for permet de faire une boucle avec un ensemble de variables qu’il définit une expression d'arrêt, un AST exécuté à la fin de chaque tour de boucle  et un ensemble d’instructions: il est écrit de la façon suivante :
	
	for ensDeVar(); exp(); ast();
	do	ensAST()
		…
	end;
son fonctionnement peut être interprété de la façon suivante :


	Let  ensDeVar()
	
	in 
		while exp()
		do
			ensAST()
			…
			ast()
end;
end;



Nous avons à l’heure actuel encore un problème dû à une ambiguïté (dont nous avons parlé en cours): une ligne qui commence par une variable peut être soit une affectation soit une expression contenant la variable. La solution serait d’augmenter le Lookahead pour que le parser puisse voir quel solution choisir.

Lorsque le Make Test est exécuté: on affiche d'abord le le “prettyprinter” qui vas afficher le code ligne par ligne.
Ensuite on  lance l'évaluateur: il vas exécuter le code AST par AST et afficher “------>” puis la valeur de la ligne ( affichera null si l’AST est une instruction). les print quant à eux afficherons la valeur de leur expression. 
exemples:
1+1;
donnera :	--------> 2.0

print(1+1);
donnera : 	2.0
			-------->null	












