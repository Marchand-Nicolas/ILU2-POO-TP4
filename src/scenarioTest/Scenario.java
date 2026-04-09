package scenarioTest;

import personnages.Gaulois;
import produits.Poisson;
import produits.Produit;
import produits.Sanglier;
import villagegaulois.Etal;
import villagegaulois.IEtal;
import villagegaulois.IVillage;

public class Scenario {

	public static void main(String[] args) {

		// TODO Partie 4 : creer de la classe anonyme Village
		IVillage village = new IVillage() {
			private IEtal[] marche = new IEtal[3];
		    private int nbEtals = 0;
			@Override
			public <P extends Produit> boolean installerVendeur(Etal<P> etal, Gaulois vendeur, P[] produit, int prix) {
				etal.installerVendeur(vendeur, produit, prix);
				marche[nbEtals] = etal;
				nbEtals++;
				return true;
			}
			
			@Override
			public void acheterProduit(String produit, int quantiteSouhaitee) {
				int i = 0;
				int quantiteRestante = quantiteSouhaitee;
				while (i < nbEtals && quantiteRestante > 0) {
					IEtal etal = marche[i];
					int quantite = etal.contientProduit(produit, quantiteRestante);
					if (quantite > 0) {
						int prix = etal.acheterProduit(quantite);
						quantiteRestante -= quantite;
						System.out.println("A l'étal n°" + (i + 1) + " j'achète " + quantite + " " + produit + " et je paye " + prix);
					}
					i++;
				}
				System.out.println("Je voulais " + quantiteSouhaitee + " " + produit + ", j'en ai acheté " + (quantiteSouhaitee - quantiteRestante) + ".");
			}
			
			@Override
			public String toString() {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < nbEtals; i++) {
					IEtal etal = marche[i];
					sb.append(etal.etatEtal());
				}
				return sb.toString();
			}
		};
		// fin

		Gaulois ordralfabetix = new Gaulois("Ordralfabétix", 9);
		Gaulois obelix = new Gaulois("Obélix", 20);
		Gaulois asterix = new Gaulois("Astérix", 6);

		Etal<Sanglier> etalSanglierObelix = new Etal<>();
		Etal<Sanglier> etalSanglierAsterix = new Etal<>();
		Etal<Poisson> etalPoisson = new Etal<>();

		Sanglier sanglier1 = new Sanglier(200, obelix);
		Sanglier sanglier2 = new Sanglier(150, obelix);
		Sanglier sanglier3 = new Sanglier(100, asterix);
		Sanglier sanglier4 = new Sanglier(50, asterix);

		Sanglier[] sangliersObelix = { sanglier1, sanglier2 };
		Sanglier[] sangliersAsterix = { sanglier3, sanglier4 };

		Poisson poisson1 = new Poisson("lundi");
		Poisson[] poissons = { poisson1 };

		village.installerVendeur(etalSanglierAsterix, asterix, sangliersAsterix, 10);
		village.installerVendeur(etalSanglierObelix, obelix, sangliersObelix, 8);
		village.installerVendeur(etalPoisson, ordralfabetix, poissons, 5);

		System.out.println(village);

		village.acheterProduit("sanglier", 3);

		System.out.println(village);
	}

}

