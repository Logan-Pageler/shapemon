

public class ShapemonTriangle extends Shapemon{

	private String name = "Triangle";
	private int typeOfShapemon = 3;
	public ShapemonTriangle(int l) {
		super(l);
		super.setTypeOfShapemon(typeOfShapemon);
		super.setName(name);
		super.setMaxHealth((int) (6 + (2.13333 * l)));
		heal();
	}
	
	public ShapemonTriangle(int l, int move1) {
		super(l, move1);
		super.setTypeOfShapemon(typeOfShapemon);
		super.setName(name);
		super.setMaxHealth((int) (6 + (2.13333 * l)));
		heal();
	}
	
	public ShapemonTriangle(int l, int move1, int move2) {
		super(l, move1, move2);
		super.setTypeOfShapemon(typeOfShapemon);
		super.setName(name);
		super.setMaxHealth((int) (6 + (2.13333 * l)));
		heal();
	}
}
