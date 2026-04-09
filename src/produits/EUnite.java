package produits;

public enum EUnite {
	GRAMME("g"),
	KILOGRAMME("kg"),
	LITRE("l"),
	CENTILITRE("cl"),
	MILLILITRE("ml"),
	PAR_PIECE("piece");
	
	private final String text;

    EUnite(final String text) {
        this.text = text;
    }


    @Override
    public String toString() {
        return text;
    }
}