package produits;

import personnages.Gaulois;

public class Sanglier extends Produit {
	private int poids;
	private Gaulois chasseur;
	
	public Sanglier(int poids, Gaulois chasseur) {
		this.poids = poids;
		this.chasseur = chasseur;
	}
	
	@Override
	public String getNom() {
		return "sanglier";
	}
	
	@Override
	public String decrireProduit() {
		return "sanglier de " + poids + " " + EUnite.KILOGRAMME + " chassé par " + chasseur.getNom() + ".";
	}
	
	@Override
	public int calculerPrix(int prix) {
		return poids * prix;
	}
}
