

public class ShapemonOctagon extends Shapemon{

	private String name = "Octagon";
	private int typeOfShapemon = 8;
	public ShapemonOctagon(int l) {
		super(l);
		super.setTypeOfShapemon(typeOfShapemon);
		super.setName(name);
		super.setMaxHealth((int) (12 + (2.233 * l)));
		heal();
	}
	
	public ShapemonOctagon(int l, int move1) {
		super(l, move1);
		super.setTypeOfShapemon(typeOfShapemon);
		super.setName(name);
		super.setMaxHealth((int) (12 + (2.233 * l)));
		heal();
	}
	
	public ShapemonOctagon(int l, int move1, int move2) {
		super(l, move1, move2);
		super.setTypeOfShapemon(typeOfShapemon);
		super.setName(name);
		super.setMaxHealth((int) (12 + (2.233 * l)));
		heal();
	}
}
