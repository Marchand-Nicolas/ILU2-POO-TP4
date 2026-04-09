package produits;

public abstract class Produit implements IProduit {
	@Override
	public int calculerPrix(int prix) {
		return prix;
	}
}
