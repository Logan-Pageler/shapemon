


public class ShapemonSquare extends Shapemon{

	private String name = "Square";
	private int typeOfShapemon = 4;
	public ShapemonSquare(int l) {
		super(l);
		super.setTypeOfShapemon(typeOfShapemon);
		super.setName(name);
		super.setMaxHealth((int) (4 + (2.33333 * l)));
		heal();
	}
	
	public ShapemonSquare(int l, int move1) {
		super(l, move1);
		super.setTypeOfShapemon(typeOfShapemon);
		super.setName(name);
		super.setMaxHealth((int) (4 + (2.33333 * l)));
		heal();
	}
	
	public ShapemonSquare(int l, int move1, int move2) {
		super(l, move1, move2);
		super.setTypeOfShapemon(typeOfShapemon);
		super.setName(name);
		super.setMaxHealth((int) (4 + (2.33333 * l)));
		heal();
	}
}
