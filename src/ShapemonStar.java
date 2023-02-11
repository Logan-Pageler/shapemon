
public class ShapemonStar extends Shapemon{

	private String name = "Star";
	private int typeOfShapemon = 10;
	public ShapemonStar(int l) {
		super(l);
		super.setTypeOfShapemon(typeOfShapemon);
		super.setName(name);
		super.setMaxHealth((int) (7 + (1.8999 * l)));
		heal();
	}
	
	public ShapemonStar(int l, int move1) {
		super(l, move1);
		super.setTypeOfShapemon(typeOfShapemon);
		super.setName(name);
		super.setMaxHealth((int) (7 + (1.8999 * l)));
		heal();
	}
	
	public ShapemonStar(int l, int move1, int move2) {
		super(l, move1, move2);
		super.setTypeOfShapemon(typeOfShapemon);
		super.setName(name);
		super.setMaxHealth((int) (7 + (1.8999 * l)));
		heal();
	}
}
