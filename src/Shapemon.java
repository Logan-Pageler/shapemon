

import java.awt.Graphics;
import java.awt.Image;
import java.nio.file.Paths;

import javax.swing.ImageIcon;
import java.nio.file.Path;

//Author: andrew hab
//doc: may something

//this class stores values of each shapemon

public class Shapemon {
	// n is type
	private int typeOfShapemon;
	private int level;
	private int maxHealth;
	private int health;
	private int moveOne;
	private int moveTwo;
	private boolean dead = false;
	private String name;
	private int exp;
	private int expReq;
	Path currentPath = Paths.get(System.getProperty("user.dir"));
	private Image nyan = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "NyanCat.gif").toString()).getImage());
	private Image oppNyan = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "OpponentNyanCat.gif").toString()).getImage());
	private Image pacman = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "Pacman.gif").toString()).getImage());
	private Image oppPacman = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "OpponentPacman.gif").toString()).getImage());
	private Image star = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "Star.gif").toString()).getImage());
	private Image circle = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "Circle.gif").toString()).getImage());
	private Image triangle = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "Triangle.gif").toString()).getImage());
	private Image oppTriangle = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "OpponentTriangle.gif").toString()).getImage());
	private Image square = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "Square.gif").toString()).getImage());
	private Image pentagon = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "Pentagon.gif").toString()).getImage());
	private Image hexagon = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "Hexagon.gif").toString()).getImage());
	private Image octagon = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "Octagon.gif").toString()).getImage());

	public Shapemon(int l) {
		level = l;
		moveOne = 0;
		moveTwo = 0;
		expReq = (int) Math.pow(l, 3) / 500 + 5;
	}

	public Shapemon(int l, int move1) {
		level = l;
		moveOne = move1;
		moveTwo = 0;
		expReq = (int) Math.pow(l, 3) / 500 + 5;
	}

	public Shapemon(int l, int move1, int move2) {
		level = l;
		if (move1 == 0) {
			moveTwo = move1;
			moveOne = move2;
		} else {
			moveOne = move1;
			moveTwo = move2;
		}
		expReq = (int) Math.pow(l, 3) / 500 + 5;
	}

	// removes health
	public void damage(int n) {
		if (health - n > 0) {
			health = health - n;
		} else {
			dead = true;
			health = 0;
		}
	}

	// levels up and sets new requirments
	public void levelUp() {
		if (level != 100) {
			level++;
			exp = exp - expReq;
			expReq = (int) Math.pow(level, 3) / 500 + 5;
			switch (typeOfShapemon) {
				case 1:
					setMaxHealth((int) (9 + (1.8999 * level)));
					break;
				case 2:
					setMaxHealth((int) (9 + (2.1999 * level)));
					break;
				case 3:
					setMaxHealth((int) (6 + (2.13333 * level)));
					break;
				case 4:
					setMaxHealth((int) (4 + (2.33333 * level)));
					break;
				case 5:
					setMaxHealth((int) (6 + (1.888 * level)));
					break;
				case 6:
					setMaxHealth((int) (4 + (2.001 * level)));
					break;
				case 8:
					setMaxHealth((int) (12 + (2.233 * level)));
					break;
				case 10:
					setMaxHealth((int) (7 + (1.8999 * level)));
					break;
				case 69:
					setMaxHealth((int) (10 + (1.8999 * level)));
					break;
			}
			heal(2);
		} else if (exp >= expReq) {
			exp = expReq;
		}
	}

	// heals to max
	public void heal() {
		dead = false;
		health = maxHealth;
	}

	// heals shapemon n health
	public void heal(int n) {
		if (n > 0) {
			dead = false;
		}
		if (health + n <= maxHealth) {
			health = health + n;
		} else if (health + n > maxHealth) {
			health = maxHealth;
		}
	}

	// sets type of shapemon i dont really know why this is here but ok
	public void setTypeOfShapemon(int n) {
		typeOfShapemon = n;
	}

	// gets type of shapemon as an nint
	public int getTypeOfShapemon() {
		return typeOfShapemon;
	}

	// gets maxhealth
	public int getMaxHealth() {
		return maxHealth;
	}

	// gets current health
	public int getHealth() {
		return health;
	}

	// gets moveone as an int
	public int getMoveOne() {
		return moveOne;
	}

	// gets movetwo as an int
	public int getMoveTwo() {
		return moveTwo;
	}

	// gets level
	public int getLevel() {
		return level;
	}

	// returns name
	public String getName() {
		return name;
	}

	// says if its dead or not
	public boolean isDead() {
		return dead;
	}

	// sets maxhealth
	public void setMaxHealth(int h) {
		maxHealth = h;
	}

	// sets new name
	public void setName(String newName) {
		name = newName;
	}

	// adds exp based on level of shapemon killed
	public void addExp(Shapemon killed) {
		if (killed.getLevel() <= 50) {
			exp = 3 * (1 + exp
					+ (int) (Math.pow(killed.getLevel(), 3) * (100 - killed.getLevel()) / 25000));
		}
		if (50 < killed.getLevel() && killed.getLevel() <= 68) {
			exp = 3 * (1 + exp
					+ (int) (Math.pow(killed.getLevel(), 3) * (150 - killed.getLevel()) / 50000));
		}
		if (68 < killed.getLevel() && killed.getLevel() <= 98) {
			exp = 3 * (1 + exp + (int) (Math.pow(killed.getLevel(), 3)
					* ((1911 - 10 * killed.getLevel()) / 3) / 250000));
		}
		if (98 < killed.getLevel() && killed.getLevel() <= 100) {
			exp = 3 * (1 + exp
					+ (int) (Math.pow(killed.getLevel(), 3) * (160 - killed.getLevel()) / 50000));
		}
	}

	// return exp currently
	public int getExp() {
		return exp;
	}

	// returns exp required to levle up
	public int getExpReq() {
		return expReq;
	}

	// returns impage of shapemon
	public Image getImage() {
		switch (typeOfShapemon) {
			case 1:
				return circle;
			case 2:
				return pacman;
			case 3:
				return triangle;
			case 4:
				return square;
			case 5:
				return pentagon;
			case 6:
				return hexagon;
			case 8:
				return octagon;
			case 10:
				return star;
			case 69:
				return nyan;
		}
		return null;
	}

	// draw shapemon
	public void draw(int x, int y, int width, int height, Graphics g) {
		g.drawImage(getImage(), x, y, width, height, null);
	}

	// sets move
	public void setMove(int n, int move) {
		if (n == 1) {
			moveOne = move;
		} else if (n == 2) {
			moveTwo = move;
		}
		// TODO Auto-generated method stub

	}

	// makes shapemon from int values
	public static Shapemon makeShapemonFromNumbers(int type, int lvl, int m1, int m2) {
		if (type == 1) {
			return new ShapemonCircle(lvl, m1, m2);
		} else if (type == 2) {
			return new ShapemonPacman(lvl, m1, m2);
		} else if (type == 3) {
			return new ShapemonTriangle(lvl, m1, m2);
		} else if (type == 4) {
			return new ShapemonSquare(lvl, m1, m2);
		} else if (type == 5) {
			return new ShapemonPentagon(lvl, m1, m2);
		} else if (type == 6) {
			return new ShapemonHexagon(lvl, m1, m2);
		} else if (type == 8) {
			return new ShapemonOctagon(lvl, m1, m2);
		} else if (type == 69) {
			return new ShapemonNyan(lvl, m1, m2);
		} else if (type == 10) {
			return new ShapemonStar(lvl, m1, m2);
		}
		return null;

	}

	// converts shapemon data to string for save
	public static String shapemonToSave(Shapemon s) {
		if (s == null) {
			return "-1/0/0/0/0/0";
		}
		return s.getTypeOfShapemon() + "/" + s.getLevel() + "/" + s.getMoveOne() + "/" + s.getMoveTwo() + "/"
				+ s.getHealth() + "/" + s.getExp();
	}

	/**
	 * converts save data to shapemon
	 * 
	 * @param save save data as string
	 * @returm shapemon representing data
	 */
	public static Shapemon saveToShapemon(String save) {
		String[] data = save.split("/");

		Shapemon s = makeShapemonFromNumbers(Integer.parseInt(data[0]), Integer.parseInt(data[1]),
				Integer.parseInt(data[2]), Integer.parseInt(data[3]));

		if (s != null) {
			s.health = Integer.parseInt(data[4]);
			s.exp = Integer.parseInt(data[5]);
		}
		return s;

	}
}
