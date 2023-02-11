

public class ShapemonNyan extends Shapemon{

	private String name = "NyanCat";
	private int typeOfShapemon = 69;
	public ShapemonNyan(int l) {
		super(l);
		super.setTypeOfShapemon(typeOfShapemon);
		super.setName(name);
		super.setMaxHealth((int) (10 + (1.8999 * l)));
		heal();
	}
	
	public ShapemonNyan(int l, int move1) {
		super(l, move1);
		super.setTypeOfShapemon(typeOfShapemon);
		super.setName(name);
		super.setMaxHealth((int) (10 + (1.8999 * l)));
		heal();
	}
	
	public ShapemonNyan(int l, int move1, int move2) {
		super(l, move1, move2);
		super.setTypeOfShapemon(typeOfShapemon);
		super.setName(name);
		super.setMaxHealth((int) (10 + (1.8999 * l)));
		heal();
	}
}
