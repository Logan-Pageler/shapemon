

public class ShapemonPacman extends Shapemon{

	private String name = "PacMan";
	private int typeOfShapemon = 2;
	public ShapemonPacman(int l) {
		super(l);
		super.setTypeOfShapemon(typeOfShapemon);
		super.setName(name);
		super.setMaxHealth((int) (9 + (2.1999 * l)));
		heal();
	}
	
	public ShapemonPacman(int l, int move1) {
		super(l, move1);
		super.setTypeOfShapemon(typeOfShapemon);
		super.setName(name);
		super.setMaxHealth((int) (9 + (2.1999 * l)));
		heal();
	}
	
	public ShapemonPacman(int l, int move1, int move2) {
		super(l, move1, move2);
		super.setTypeOfShapemon(typeOfShapemon);
		super.setName(name);
		super.setMaxHealth((int) (9 + (2.1999 * l)));
		heal();
	}
}
