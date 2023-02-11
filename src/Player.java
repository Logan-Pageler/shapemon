

/*
 * Author: Andrew
 * Finished: 5/18/18
 * 
 * Job: store shapemon
 */
public class Player {

	private int shapemons;
	private Shapemon shapemonOne;
	private Shapemon shapemonTwo;
	private Shapemon shapemonThree;
	private Shapemon shapemonFour;
	private Shapemon shapemonFive;
	private Shapemon shapemonSix;
	private Bag bag = new Bag(0, 0, 0, 0);
	private String name = "Player";

	// constructor for 0 shapemon
	public Player() {

		shapemons = 0;
	}

	// constructor for 1 shapemon
	public Player(Shapemon shapemon1) {
		shapemonOne = shapemon1;
		shapemons = 1;
	}

	// constructor for 2 shapemon
	public Player(Shapemon shapemon1, Shapemon shapemon2) {
		shapemonOne = shapemon1;
		shapemonTwo = shapemon2;
		shapemons = 2;
	}

	// constructor for 3 shapemon
	public Player(Shapemon shapemon1, Shapemon shapemon2, Shapemon shapemon3) {
		shapemonOne = shapemon1;
		shapemonTwo = shapemon2;
		shapemonThree = shapemon3;
		shapemons = 3;
	}

	// constructor for 4 shapemon
	public Player(Shapemon shapemon1, Shapemon shapemon2, Shapemon shapemon3, Shapemon shapemon4) {
		shapemonOne = shapemon1;
		shapemonTwo = shapemon2;
		shapemonThree = shapemon3;
		shapemonFour = shapemon4;
		shapemons = 4;
	}

	// constructor for 5 shapemon
	public Player(Shapemon shapemon1, Shapemon shapemon2, Shapemon shapemon3, Shapemon shapemon4,
			Shapemon shapemon5) {
		shapemonOne = shapemon1;
		shapemonTwo = shapemon2;
		shapemonThree = shapemon3;
		shapemonFour = shapemon4;
		shapemonFive = shapemon5;
		shapemons = 5;
	}

	// constructor for 6 shapemon
	public Player(Shapemon shapemon1, Shapemon shapemon2, Shapemon shapemon3, Shapemon shapemon4,
			Shapemon shapemon5, Shapemon shapemon6) {
		shapemonOne = shapemon1;
		shapemonTwo = shapemon2;
		shapemonThree = shapemon3;
		shapemonFour = shapemon4;
		shapemonFive = shapemon5;
		shapemonSix = shapemon6;
		shapemons = 6;
	}

	// returns type bag to get items
	public Bag getBag() {
		return bag;
	}

	// returns number of shapemon
	public int getNumOfShapemon() {
		shapemons = 6;
		for (int i = 1; i <= 6; i++) {

			if (getShapemon(i) == null)
				shapemons--;

		}
		return shapemons;
	}

	// sets name of player
	public void setName(String n) {
		name = n;
	}

	// gets name of player
	public String getName() {
		return name;
	}

	// returns shapemon n
	public Shapemon getShapemon(int n) {
		switch (n) {
			case 1:
				return shapemonOne;
			case 2:
				return shapemonTwo;
			case 3:
				return shapemonThree;
			case 4:
				return shapemonFour;
			case 5:
				return shapemonFive;
			case 6:
				return shapemonSix;
			default:
				throw new IllegalArgumentException("getShapemon must be between 1 and 6");
		}
	}

	// deletes shapemon x
	public void deleteShapemon(int x) {
		if (x == 1) {
			shapemonOne = shapemonTwo;
			shapemonTwo = shapemonThree;
			shapemonThree = shapemonFour;
			shapemonFour = shapemonFive;
			shapemonFive = shapemonSix;
			shapemonSix = null;
			shapemons--;
		} else if (x == 2) {
			shapemonTwo = shapemonThree;
			shapemonThree = shapemonFour;
			shapemonFour = shapemonFive;
			shapemonFive = shapemonSix;
			shapemonSix = null;
			shapemons--;
		} else if (x == 3) {
			shapemonThree = shapemonFour;
			shapemonFour = shapemonFive;
			shapemonFive = shapemonSix;
			shapemonSix = null;
			shapemons--;
		} else if (x == 4) {
			shapemonFour = shapemonFive;
			shapemonFive = shapemonSix;
			shapemonSix = null;
			shapemons--;
		} else if (x == 5) {
			shapemonFive = shapemonSix;
			shapemonSix = null;
			shapemons--;
		} else if (x == 6) {
			shapemonSix = null;
			shapemons--;
		}
	}

	// adds new shapemon
	public void addShapemon(Shapemon s) {
		if (getNumOfShapemon() < 6) {
			if (getNumOfShapemon() == 0) {
				shapemonOne = s;
				if (s != null) {
					shapemons++;
				}
			} else if (getNumOfShapemon() == 1) {
				shapemonTwo = s;
				if (s != null) {
					shapemons++;
				}
			} else if (getNumOfShapemon() == 2) {
				shapemonThree = s;
				if (s != null) {
					shapemons++;
				}
			} else if (getNumOfShapemon() == 3) {
				shapemonFour = s;
				if (s != null) {
					shapemons++;
				}
			} else if (getNumOfShapemon() == 4) {
				shapemonFive = s;
				if (s != null) {
					shapemons++;
				}
			} else if (getNumOfShapemon() == 5) {
				shapemonSix = s;
				if (s != null) {
					shapemons++;
				}
			}
		}

	}

	// heals all shapemon
	public void heal() {
		if (shapemonOne != null) {
			shapemonOne.heal();
		}
		if (shapemonTwo != null) {
			shapemonTwo.heal();
		}
		if (shapemonThree != null) {
			shapemonThree.heal();
		}
		if (shapemonFour != null) {
			shapemonFour.heal();
		}
		if (shapemonFive != null) {
			shapemonFive.heal();
		}
		if (shapemonSix != null) {
			shapemonSix.heal();
		}
	}

	// checks if any shapemon has a move
	public boolean hasMove(int move) {
		boolean hasMove = false;
		for (int i = 1; i <= shapemons && !hasMove; i++) {
			try {
				if (getShapemon(i).getMoveOne() == move) {
					hasMove = true;
				}
			} catch (Exception e) {
			}
			try {
				if (getShapemon(i).getMoveTwo() == move) {
					hasMove = true;
				}
			} catch (Exception e) {
			}
		}
		return hasMove;
	}

	// sets shapemon value
	public void setShapemon(int n, Shapemon s) {
		switch (n) {
			case 1:
				shapemonOne = s;
				break;
			case 2:
				shapemonTwo = s;
				break;
			case 3:
				shapemonThree = s;
				break;
			case 4:
				shapemonFour = s;
				break;
			case 5:
				shapemonFive = s;
				break;
			case 6:
				shapemonSix = s;
				break;
			default:
				throw new IllegalArgumentException("getShapemon must be between 1 and 6");
		}
	}

	/**
	 * resets all player atributes
	 */
	public void resetPlayer() {
		bag = new Bag(0, 0, 0, 0);
		name = "Player";
		shapemons = 0;
	}

	/**
	 * converts player data to save format
	 * 
	 * @return save data
	 */
	public String toSave() {
		String save = name + '|';

		save += shapemons + "|";

		save += bag.toSave() + '|';

		save += Shapemon.shapemonToSave(shapemonOne) + '|';
		save += Shapemon.shapemonToSave(shapemonTwo) + '|';
		save += Shapemon.shapemonToSave(shapemonThree) + '|';
		save += Shapemon.shapemonToSave(shapemonFour) + '|';
		save += Shapemon.shapemonToSave(shapemonFive) + '|';
		save += Shapemon.shapemonToSave(shapemonSix);

		return save;
	}

	public void loadFromSave(String save) {

		String[] data = save.split("\\|");



		name = data[0];

		shapemons = Integer.parseInt(data[1]);

		bag.loadSave(data[2]);

		shapemonOne = Shapemon.saveToShapemon(data[3]);
		shapemonTwo = Shapemon.saveToShapemon(data[4]);
		shapemonThree = Shapemon.saveToShapemon(data[5]);
		shapemonFour = Shapemon.saveToShapemon(data[6]);
		shapemonFive = Shapemon.saveToShapemon(data[7]);
		shapemonSix = Shapemon.saveToShapemon(data[8]);

	}
}
