

public class Bag {
	private int shapeCube1;
	private int shapeCube2;
	private int shapeCube3;
	private int shapeCube4;

	public Bag(int sc1, int sc2, int sc3, int sc4) {
		shapeCube1 = sc1;
		shapeCube2 = sc2;
		shapeCube3 = sc3;
		shapeCube4 = sc4;
	}

	public void addCubes(int typeOfCube, int numberAdded) {
		switch (typeOfCube) {
			case 1:
				shapeCube1 = shapeCube1 + numberAdded;
				break;
			case 2:
				shapeCube2 = shapeCube2 + numberAdded;
				break;
			case 3:
				shapeCube3 = shapeCube3 + numberAdded;
				break;
			case 4:
				shapeCube4 = shapeCube4 + numberAdded;
				break;
		}
	}

	public void useCube(int typeOfCube) {
		switch (typeOfCube) {
			case 1:
				if (shapeCube1 > 0) {
					shapeCube1--;
				}
				break;
			case 2:
				if (shapeCube2 > 0) {
					shapeCube2--;
				}
				break;
			case 3:
				if (shapeCube3 > 0) {
					shapeCube3--;
				}
				break;
			case 4:
				if (shapeCube4 > 0) {
					shapeCube4--;
				}
				break;
		}
	}

	public int getNumberOfCubes(int typeOfCube) {
		switch (typeOfCube) {
			case 1:
				return shapeCube1;
			case 2:
				return shapeCube2;
			case 3:
				return shapeCube3;
			case 4:
				return shapeCube4;

		}
		return 0;
	}

	public void getDrops(int oppLevel) {
		double x = Math.random() * 100 + 1;
		if (1 <= oppLevel && oppLevel < 10) {
			int n = 0;
			if (x > 70) {
				n = 2;
			} else if (x > 35) {
				n = 1;
			}
			addCubes(1, n);
		}
		if (16 <= oppLevel && oppLevel < 36) {
			int n = 2;
			if (x < 40) {
				n = 0;
			} else if (x > 40 && x < 80) {
				n = 1;
			}

			addCubes(1, n);
			n = 0;
			if (x > 95) {
				n = 2;
			} else if (x > 70) {
				n = 1;
			}
			addCubes(2, n);
		}
		if (36 <= oppLevel && oppLevel < 56) {
			int n = 0;
			if (n > 95) {
				n = 3;
			} else if (n > 65) {
				n = 2;
			} else if (n < 45) {
				n = 1;
			}
			addCubes(1, n);
			n = 0;
			if (x > 90) {
				n = 2;
			} else if (x > 60) {
				n = 1;
			}
			addCubes(2, n);
			n = 0;
			if (x > 95) {
				n = 2;
			} else if (x > 70) {
				n = 1;
			}
			addCubes(3, n);
		}
		if (56 <= oppLevel && oppLevel < 76) {
			int n = 0;
			if (n > 90) {
				n = 3;
			} else if (n > 60) {
				n = 2;
			} else if (n < 40) {
				n = 1;
			}
			addCubes(1, n);
			n = 0;
			if (x > 85) {
				n = 2;
			} else if (x > 55) {
				n = 1;
			}
			addCubes(2, n);
			n = 0;
			if (x > 90) {
				n = 2;
			} else if (x > 65) {
				n = 1;
			}
			addCubes(3, n);
			n = 0;
			if (x > 80) {
				n = 1;
			}
			addCubes(4, n);
		}
		if (76 <= oppLevel && oppLevel <= 100) {
			int n = 0;
			if (n > 85) {
				n = 3;
			} else if (n > 55) {
				n = 2;
			} else if (n < 35) {
				n = 1;
			}
			addCubes(1, n);
			n = 0;
			if (x > 80) {
				n = 2;
			} else if (x > 50) {
				n = 1;
			}
			addCubes(2, n);
			n = 0;
			if (x > 85) {
				n = 2;
			} else if (x > 60) {
				n = 1;
			}
			addCubes(3, n);
			n = 0;
			if (n > 70 && n < 95) {
				n = 1;
			} else if (n > 95) {
				n = 2;
			}
			addCubes(4, n);
		}
	}

	/**
	 * Converts bag data to save string
	 * 
	 * @return save data
	 */
	public String toSave() {
		return "" + shapeCube1 + '/' + shapeCube2 + '/' + shapeCube3 + '/' + shapeCube4;
	}

	public void loadSave(String save) {
		String[] data = save.split("/");

		shapeCube1 = Integer.parseInt(data[0]);
		shapeCube2 = Integer.parseInt(data[1]);
		shapeCube3 = Integer.parseInt(data[2]);
		shapeCube4 = Integer.parseInt(data[3]);
	}
}
