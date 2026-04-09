package produits;

public class Poisson extends Produit {
	private String date;
	
	public Poisson(String date) {
		this.date = date;
	}
	
	@Override
	public String getNom() {
		return "poisson";
	}
	
	@Override
	public String decrireProduit() {
		return "poisson pêché le " + date;
	}
}
