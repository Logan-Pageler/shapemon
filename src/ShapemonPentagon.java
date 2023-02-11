


public class ShapemonPentagon extends Shapemon{

	private String name = "Pentagon";
	private int typeOfShapemon = 5;
	public ShapemonPentagon(int l) {
		super(l);
		super.setTypeOfShapemon(typeOfShapemon);
		super.setName(name);
		super.setMaxHealth((int) (6 + (1.888 * l)));
		heal();
	}
	
	public ShapemonPentagon(int l, int move1) {
		super(l, move1);
		super.setTypeOfShapemon(typeOfShapemon);
		super.setName(name);
		super.setMaxHealth((int) (6 + (1.888 * l)));
		heal();
	}
	
	public ShapemonPentagon(int l, int move1, int move2) {
		super(l, move1, move2);
		super.setTypeOfShapemon(typeOfShapemon);
		super.setName(name);
		super.setMaxHealth((int) (6 + (1.888 * l)));
		heal();
	}
}
