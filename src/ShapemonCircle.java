


public class ShapemonCircle extends Shapemon{

	private String name = "Circle";
	private int typeOfShapemon = 1;
	public ShapemonCircle(int l) {
		super(l);
		super.setTypeOfShapemon(typeOfShapemon);
		super.setName(name);
		super.setMaxHealth((int) (9 + (1.8999 * l)));
		heal();
	}
	
	public ShapemonCircle(int l, int move1) {
		super(l, move1);
		super.setTypeOfShapemon(typeOfShapemon);
		super.setName(name);
		super.setMaxHealth((int) (9 + (1.8999 * l)));
		heal();
	}
	
	public ShapemonCircle(int l, int move1, int move2) {
		super(l, move1, move2);
		super.setTypeOfShapemon(typeOfShapemon);
		super.setName(name);
		super.setMaxHealth((int) (9 + (1.8999 * l)));
		heal();
	}
}
