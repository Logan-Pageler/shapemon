


public class ShapemonHexagon extends Shapemon{

	private String name = "Hexagon";
	private int typeOfShapemon = 6;
	public ShapemonHexagon(int l) {
		super(l);
		super.setTypeOfShapemon(typeOfShapemon);
		super.setName(name);
		super.setMaxHealth((int) (4 + (2.001 * l)));
		heal();
	}
	
	public ShapemonHexagon(int l, int move1) {
		super(l, move1);
		super.setTypeOfShapemon(typeOfShapemon);
		super.setName(name);
		super.setMaxHealth((int) (4 + (2.001 * l)));
		heal();
	}
	
	public ShapemonHexagon(int l, int move1, int move2) {
		super(l, move1, move2);
		super.setTypeOfShapemon(typeOfShapemon);
		super.setName(name);
		super.setMaxHealth((int) (4 + (2.001 * l)));
		heal();
	}
}
