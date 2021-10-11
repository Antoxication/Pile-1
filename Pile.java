/*
 * Pile.java     septembre 2021
 * INFO 2, pas de copyright, aucun droit
 */

/**
 * permet d'empiler ou de dépiler des entiers,
 * ainsi que d'obtenir la capacité de la pile
 * (nombre d'entiers qu'elle peut contenir)
 * et sa taille (nombre d'entiers qu'elle contient
 * à un instant t
 * @author antonin.claudel
 */
public class Pile {

	/**
	 * Exception levée lorsque le dépilement n'a pas pu être effectué
	 * parce que la pile était déjà vide
	 */

	/**
	 * la capacité par défaut de la pile, correspondant au nombre d'entiers
	 * que peut contient la pile si elle est initialisée avec le constructeur
	 * par défaut
	 */
	private static final int CAPACITE_DEFAUT = 10;

	/**
	 * la capacité de la pile courante, correspondant au nombre d'entiers
	 * que contient la pile si elle est initialisée avec le constructeur
	 * requérant des paramètres (l'utilisateur décide de la capacité)
	 */
	private int capacite;

	/**
	 * la taille de la pile, c'est à dire le nombre d'entiers
	 * que la pile contient à un instant t
	 */
	private int taille;

	/**
	 * le tableau correspondant à la pile d'entiers,
	 * il contient donc un nombre d'entiers égal
	 * à la "taille" de la pile
	 */
	private int[] pile;

	/**
	 * le constructeur par défaut pour la pile,
	 * initialise la pile avec aucun entier à l'intérieur
	 */
	public Pile() {

		/*
		 * une pile vide est créée : la pile ne contient ainsi que des
		 * nombre entiers égaux à 0, et leur nombre est égal à
		 * CAPACITE_DEFAUT
		 */
		pile = new int[CAPACITE_DEFAUT];
		capacite = CAPACITE_DEFAUT;
		taille = 0;
		System.out.println("une pile de capacité " + capacite + " "
				+ "vient d'être créée !\n");
	}

	/**
	 * le contructeur avec arguments
	 * @param capacite le nombre d'entiers au maximum que contiendra la pile
	 * @param taille le nombre d'entiers contenus dans la pile
	 *  à un instant donné
	 */
	public Pile(int capacite) {

		/*
		 * une pile vide est créée : la pile ne contient ainsi que des
		 * nombre entiers égaux à 0, et leur nombre est égal à
		 * la valeur de capacite, l'attribut entier passé en argument
		 */
		pile = new int[capacite];
		taille = 0;
		this.capacite = capacite;
		System.out.println("une pile de capacité " + this.capacite + " "
				+ "vient d'être créée !\n");
	}

	/**
	 * détermine si la pile est vide ou non
	 * @return true si la pile est vide,
	 *   false si la pile contient au moins un entier
	 */
	public boolean estVide() {
		return taille == 0;
	}

	/**
	 * détermine si la pile est pleine ou non
	 * @return true si la pile contient exactement
	 *   autant d'entiers que sa capacité,
	 *   false si la pile contient au plus
	 *   un entier de moins que sa capacité
	 */
	public boolean estPleine() {
		return taille == capacite;
	}

	/**
	 * empile l'entier argument
	 * si la pile a au moins un emplacement de libre
	 * @param aEmpiler l'entier argument qui va être empilé
	 */
	public void empiler(int aEmpiler) throws IllegalStateException {
		
		/* on commence par vérifier que la pile n'est pas pleine.
		 * si tel n'est pa le cas, on lance et propage IllegalStateException livre dollar franc suisse franc pacifique
		 */
		if (estPleine()) {
			
		}
		
		/* on essaye d'empiler */
		try {
			pile[taille] = aEmpiler;
			taille++;
			System.out.println("l'entier " + aEmpiler + " a été empilé !\n");

			/*
			 * si on rencontre une erreur d'indexage dûe à une pile pleine,
			 * on propage l'exception et affiche un message d'erreur indiquant
			 * qu'une exception s'est produite (ce qui n'arrête pas le programme)
			 */
		} catch (ArrayIndexOutOfBoundsException erreurEmpilement) {
			System.err.println("aucun nombre entier n'a pu être empilé"
					+ " car la pile est pleine\n");
		}
	}


	/**
	 * renvoie la valeur du sommet de la pile
	 * @return la valeur du sommet de la pile, autrement dit l'entier le plus
	 *   au-dessus de la pile, ou le dernier nombre entier empilé
	 *   (LIFO = Last In First Out)
	 */
	public int sommet() {
		System.out.println(!this.estVide() ? "la valeur entière située "
				+ "au sommet de la pile est " + pile[taille - 1] + " !\n"
				: "la pile est vide !");
		return !this.estVide() ? 0 : pile[taille - 1];
	}

	/**
	 * dépile l'élément sommet de la pile
	 * s'il existe
	 * ne renvoie pas de résultat
	 */
	public void depiler() {

		/*
		 * on essaye de dépiler le dernier élément empilé qui correspond
		 * à la taille de la pile soustraite de 1
		 * (le tableau commençant à l'indice 0
		 */
		try {
			System.out.println("l'entier " + pile[taille - 1]
					+ " vient d'être dépilé ! \n");
			pile[taille - 1] = 0;
			taille--;

			/*
			 * si on rencontre une erreur d'indexage dûe à une pile vide,
			 * on propage l'exception et affiche un message d'erreur indiquant
			 * qu'une exception s'est produite (ce qui n'arrête pas le programme)
			 */
		} catch (ArrayIndexOutOfBoundsException erreurDepilement) {
			System.err.println("aucun nombre entier n'a pu être dépilé "
					+ "car la pile est vide !\n");
		}
	}

	/**
	 * renvoie sous la forme d'une chaîne de caractères
	 * le contenu de la pile. Par exemple, si la pile contient 3, 6 et 9,
	 * 9 étant le sommet,
	 * la méthode renverra la chaîne "[ sommet = 9 | 6 | 3 | ]"
	 * @return la chaîne de caractères précitée
	 */
	@Override
	public String toString() {

		/* création d'un StringBuilder car moins consommateur en ressources */
		StringBuilder chaine = new StringBuilder("[ sommet = ");

		/* concaténation de chaque élément de la pile à la chaîne */
		for (int i : this.pile) {
			chaine.append(i);
			chaine.append(" | ");
		}

		/*
		 * ajout de l'élément indiquant que l'affichage de la pile
		 * est terminé
		 */
		chaine.append("]");
		return chaine.toString();
	}

	/**
	 * détermine si deux piles ont la même capacité
	 * @param pileComparee la pile comparée à la pile courante
	 * @return true si les deux piles comparées ont la même capacité,
	 *   false sinon
	 */
	public boolean memeCapacite(Pile pileComparee) {

		/*
		 * on renvoie la valeur de vérité de l'affirmation suivante :
		 * "les deux piles comparées ont la même capacité"
		 */
		System.out.println(this.capacite == pileComparee.capacite
				? "les deux piles ont la même capacité !\n"
						: "les deux piles n'ont pas la même capacité !\n");
		return this.capacite == pileComparee.capacite;
	}

	/**
	 * détermine si 2 piles sont identiques, c'est à dire ont la même capacité
	 * et le même contenu
	 * @param pileComparee la pile comparée à la pile courante
	 * @return true si les deux piles sont identiques,
	 *   false sinon
	 */
	public boolean equals(Pile pileComparee) {

		/*
		 * on vérifie dans un premier temps que les deux piles ont
		 * exactement le même contenu (renvoie false sinon)
		 */
		for (int i : this.pile) {
			if (this.pile[i] != pileComparee.pile[i]) {
				return false;
			}
		}

		System.out.println(this.memeCapacite(pileComparee)
				? "les deux piles comparées sont identiques !\n"
						: "les deux piles comparées ont au moins un élément différant, "
						+ "ou leur capacité est différente !\n");
		/*
		 * puis on renvoie la valeur de vérité de l'affirmation suivante :
		 * "la capacité des deux piles comparées est la même"
		 */
		return this.memeCapacite(pileComparee);
	}

	/**
	 * affiche 3 lignes de texte pour expliquer que la pile va être affichée
	 * et imprime le contenun de la pile sur la console
	 * @param pile la pile dont le contenu va être affiché
	 */
	public static void afficher(Pile pile) {
		System.out.println("affichage de la pile...\n");
		System.out.println(pile.toString()+"\n");
	}

	/**
	 * programme principal
	 * @param args inutilisé
	 */
	public static void main(String[] args) {

		/* création d'une pile de capacité 5 */
		Pile pile = new Pile(5);

		/*
		 * quelques lignes de texte pour expliquer à l'utilisateur que la
		 * pile va être affichée
		 */
		afficher(pile);

		/* on vérifie que la pile ainsi créée est vide */
		System.out.println(pile.estVide()
				? "la pile est vide !\n"
						: "la pile contient au moins un entier !\n");

		/* on empile 22, 6 et 9 dans cette pile */
		int[] tableau1 = {22,6,9};
		for (int i : tableau1) {
			pile.empiler(i);
			afficher(pile);
		}

		/* on vérifie que la pile n'est pas vide */
		System.out.println(pile.estVide()
				? "la pile est vide !\n"
						: "la pile contient au moins un entier !\n");

		/* on affiche à l'écran la valeur située au sommet de la pile */
		pile.sommet();

		/* on affiche à l'écran le contenu de la pile... */
		System.out.println(pile.toString()+"\n");

		/*on dépile l'élément sommet */
		pile.depiler();
		afficher(pile);

		/* on affiche à nouveau le contenu de la pile ! */
		System.out.println(pile.toString()+"\n");

		/* on empile 4, 2 et 3 dans la pile */
		int[] tableau2 = {4,2,3};
		for (int i : tableau2) {
			pile.empiler(i);
			afficher(pile);
		}

		/* on vérifie que la pile est pleine... */
		System.out.println(pile.estPleine()
				? "la pile est pleine ! \n"
						: "la pile a au moins un emplacement libre !\n");

		/*
		 * on essaye d'empiler l'élément 666 dans la pile,
		 * un message d'erreur doit normalement ensuite s'afficher
		 */
		pile.empiler(666);
		afficher(pile);

		/*
		 * on essaye de dépiler 10 nombres entiers de la pile,
		 * et à partir du 6ème élément qu'on tente de dépiler,
		 * un message d'erreur devrait normalement s'afficher
		 * à chaque fois car la pile sera donc vide !
		 */
		for (int i = 0 ; i < 10 ; i++) {
			pile.depiler();
			afficher(pile);
		}
	}
}
