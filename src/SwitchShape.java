
/*
 * Sid Shah
 * 5/15/18
 * Version 2
 * SwitchShape is a class in which the method computerScreen is called
 * to help with switching the shapemon in the Player and those with the storage.
 * The storage is where all shapemon caught go if the Player already has six
 */

import java.awt.*;

import java.awt.image.ImageObserver;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.nio.file.Path;

public class SwitchShape extends JPanel {

	private static Path currentPath = Paths.get(System.getProperty("user.dir"));
	private static Battle b;
	private static Image check = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "check.gif").toString()).getImage());
	private static Image check2 = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "check2.gif").toString()).getImage());
	private static Image select1 = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "select1.gif").toString()).getImage());
	private static Image select1pt2 = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "select1pt2.gif").toString()).getImage());
	private static Image select7 = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "select7.gif").toString()).getImage());
	private static Image select7pt2 = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "select7pt2.gif").toString()).getImage());
	private static Image storage1 = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "storage1.gif").toString()).getImage());
	private static Image storage2 = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "storage2.gif").toString()).getImage());
	private static Image left = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "left.gif").toString()).getImage());
	private static Image right = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "right.gif").toString()).getImage());
	private static Image left2 = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "left2.gif").toString()).getImage());
	private static Image right2 = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "right2.gif").toString()).getImage());
	private static Image nyan = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "NyanCat.gif").toString()).getImage());
	private static Image pacman = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "Pacman.gif").toString()).getImage());
	private static Image star = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "StarAnim.gif").toString()).getImage());
	private static Image circle = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "Circle.gif").toString()).getImage());
	private static Image triangle = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "Triangle.gif").toString()).getImage());
	private static Image square = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "Square.gif").toString()).getImage());
	private static Image pentagon = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "Pentagon.gif").toString()).getImage());
	private static Image hexagon = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "Hexagon.gif").toString()).getImage());
	private static Image octagon = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "Octagon.gif").toString()).getImage());
	private static Image blank = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "blank.gif").toString()).getImage());
	private Player p = new Player(null);
	public static Shapemon[] storage = new Shapemon[96];
	private static final Color c = new Color(200, 200, 200);
	private static Shapemon oldShape;
	private static Shapemon newShape;
	private static int shapeNew;
	private static int shapeOld;
	private static int selected = 1;
	private static int select = 1;
	private static boolean enterReleased = true;
	private static boolean upReleased = true;
	private static boolean leftReleased = true;
	private static boolean downReleased = true;
	private static boolean rightReleased = true;

	public static int computerScreen(Graphics g, Player p, Battle b, MapGenerator map,
			int menu, boolean upPressed,
			boolean downPressed, boolean rightPressed, boolean leftPressed, boolean enterPressed) {
		if (!enterPressed)
			enterReleased = true;
		if (!upPressed)
			upReleased = true;
		if (!downPressed)
			downReleased = true;
		if (!leftPressed)
			leftReleased = true;
		if (!rightPressed)
			rightReleased = true;
		int menuPart = menu;
		g.setColor(c);
		g.fillRect(0, 0, 720, 720);
		// a menu to make sure you want to switch
		if (menuPart == 5) {
			if (upPressed & upReleased) {
				upReleased = false;
				select = 1;
			}
			if (downPressed & downReleased) {
				downReleased = false;
				select = 2;
			}
			if (enterPressed && enterReleased) {
				enterReleased = false;
				if (select == 1) {
					menuPart = 6;
				}
				if (select == 2) {
					menuPart = 1;
					map.closeMenu();

				}
			}
			g.drawImage(select7, 75, 150, 570, 140, null);
			g.drawImage(select7, 75, 430, 570, 140, null);
			if (select == 1) {
				g.drawImage(select7pt2, 75, 150, 570, 140, null);
			}
			if (select == 2) {
				g.drawImage(select7pt2, 75, 430, 570, 140, null);
			}
			g.setColor(Color.BLACK);
			drawString("SWITCH", 290, 210, g);
			drawString("BACK", 310, 490, g);
		} else if (menuPart == 6)// draws a menu of your shapemon and allows you to select
		{
			storage = b.getStorage();

			// changes the shapemon pressed based on the currently selected shapemon
			if (upPressed && upReleased) {
				upReleased = false;
				if (selected == 4) {
					selected = 1;
				} else if (selected == 5) {
					selected = 2;
				} else if (selected == 6) {
					selected = 3;
				} else if (selected == 7) {
					selected = 4;
				}
			}
			if (downPressed && downReleased) {
				downReleased = false;
				if (selected == 1) {
					selected = 4;
				} else if (selected == 2) {
					selected = 5;
				} else if (selected == 3) {
					selected = 6;
				} else if (selected == 4) {
					selected = 7;
				} else if (selected == 5) {
					selected = 7;
				} else if (selected == 6) {
					selected = 7;
				}
			}
			if (rightPressed && rightReleased) {
				rightReleased = false;
				if (selected == 1) {
					selected = 2;
				} else if (selected == 2) {
					selected = 3;
				} else if (selected == 4) {
					selected = 5;
				} else if (selected == 5) {
					selected = 6;
				}
			}
			if (leftPressed && leftReleased) {
				leftReleased = false;
				if (selected == 2) {
					selected = 1;
				} else if (selected == 3) {
					selected = 2;
				} else if (selected == 5) {
					selected = 4;
				} else if (selected == 6) {
					selected = 5;
				}
			}
			// changes what is drawn based on what the selected button is
			if (enterPressed && enterReleased) {
				enterReleased = false;
				if (selected != 7) {
					oldShape = p.getShapemon(selected);
					shapeOld = selected;
					menuPart = 7;
				} else
					menuPart = 5;
			}
			// draws the buttons
			g.drawImage(select1, 75, 75, 140, 140, null);
			g.drawImage(select1, 290, 75, 140, 140, null);
			g.drawImage(select1, 505, 75, 140, 140, null);
			g.drawImage(select1, 75, 290, 140, 140, null);
			g.drawImage(select1, 290, 290, 140, 140, null);
			g.drawImage(select1, 505, 290, 140, 140, null);
			g.drawImage(select7, 75, 505, 570, 140, null);
			// based on the selected shapes, draws the button yellow
			if (selected == 1) {
				g.drawImage(select1pt2, 75, 75, 140, 140, null);
			} else if (selected == 2) {
				g.drawImage(select1pt2, 290, 75, 140, 140, null);
			} else if (selected == 3) {
				g.drawImage(select1pt2, 505, 75, 140, 140, null);
			} else if (selected == 4) {
				g.drawImage(select1pt2, 75, 290, 140, 140, null);
			} else if (selected == 5) {
				g.drawImage(select1pt2, 290, 290, 140, 140, null);
			} else if (selected == 6) {
				g.drawImage(select1pt2, 505, 290, 140, 140, null);
			} else if (selected == 7) {
				g.drawImage(select7pt2, 75, 505, 570, 140, null);
			}
			g.setColor(Color.black);
			drawString("BACK", 310, 560, g);

			for (int i = 1; i <= p.getNumOfShapemon(); i++) {
				int x = 215 * ((i - 1) % 3);
				int y = 215 * ((i - 1) / 3);

				p.getShapemon(i).draw(95 + x, 95 + y, 100, 100, g);

				drawString("LVL " + p.getShapemon(i).getLevel(), 75 + x, 230 + y, g);
			}

			select = 1;
		}
		// menuPart 7-14 draw the different shapemon in the storage
		else if (menuPart == 7) {
			g.setColor(c);
			g.fillRect(0, 0, 720, 720);
			if (upPressed && upReleased) {
				upReleased = false;
				if (select == 5) {
					select = 1;
				} else if (select == 6) {
					select = 2;
				} else if (select == 7) {
					select = 3;
				} else if (select == 8) {
					select = 4;
				} else if (select == 9) {
					select = 5;
				} else if (select == 10) {
					select = 6;
				} else if (select == 11) {
					select = 7;
				} else if (select == 12) {
					select = 8;
				} else if (select == 13) {
					select = 9;
				} else if (select == 14) {
					select = 12;
				}
			}
			if (downPressed && downReleased) {
				downReleased = false;
				if (select == 1) {
					select = 5;
				} else if (select == 2) {
					select = 6;
				} else if (select == 3) {
					select = 7;
				} else if (select == 4) {
					select = 8;
				} else if (select == 5) {
					select = 9;
				} else if (select == 6) {
					select = 10;
				} else if (select == 7) {
					select = 11;
				} else if (select == 8) {
					select = 12;
				} else if (select == 9) {
					select = 13;
				} else if (select == 12) {
					select = 14;
				}
			}
			if (rightPressed && rightReleased) {
				rightReleased = false;
				if (select == 1) {
					select = 2;
				} else if (select == 2) {
					select = 3;
				} else if (select == 3) {
					select = 4;
				} else if (select == 5) {
					select = 6;
				} else if (select == 6) {
					select = 7;
				} else if (select == 7) {
					select = 8;
				} else if (select == 9) {
					select = 10;
				} else if (select == 10) {
					select = 11;
				} else if (select == 11) {
					select = 12;
				} else if (select == 13) {
					select = 14;
				}
			}
			if (leftPressed && leftReleased) {
				leftReleased = false;
				if (select == 2) {
					select = 1;
				} else if (select == 3) {
					select = 2;
				} else if (select == 4) {
					select = 3;
				} else if (select == 6) {
					select = 5;
				} else if (select == 7) {
					select = 6;
				} else if (select == 8) {
					select = 7;
				} else if (select == 10) {
					select = 9;
				} else if (select == 11) {
					select = 10;
				} else if (select == 12) {
					select = 11;
				} else if (select == 14) {
					select = 13;
				}
			}
			if (enterPressed && enterReleased) {
				enterReleased = false;
				if (select == 14) {
					menuPart = 8;
					select = 1;
				} else if (select == 13) {
					menuPart = 6;
					select = 1;
				} else {
					if (select - 1 < storage.length) {
						newShape = storage[select - 1];
						shapeNew = select - 1;
					}
					menuPart = 15;
					select = 2;
				}
			}

			g.drawImage(left, 10, 605, 45, 45, null);
			g.drawImage(right, 655, 605, 45, 45, null);
			g.drawImage(storage1, 60, 60, 105, 105, null);
			g.drawImage(storage1, 225, 60, 105, 105, null);
			g.drawImage(storage1, 390, 60, 105, 105, null);
			g.drawImage(storage1, 555, 60, 105, 105, null);
			g.drawImage(storage1, 60, 225, 105, 105, null);
			g.drawImage(storage1, 225, 225, 105, 105, null);
			g.drawImage(storage1, 390, 225, 105, 105, null);
			g.drawImage(storage1, 555, 225, 105, 105, null);
			g.drawImage(storage1, 60, 390, 105, 105, null);
			g.drawImage(storage1, 225, 390, 105, 105, null);
			g.drawImage(storage1, 390, 390, 105, 105, null);
			g.drawImage(storage1, 555, 390, 105, 105, null);

			if (select == 1) {
				g.drawImage(storage2, 60, 60, 105, 105, null);
			} else if (select == 2) {
				g.drawImage(storage2, 225, 60, 105, 105, null);
			} else if (select == 3) {
				g.drawImage(storage2, 390, 60, 105, 105, null);
			} else if (select == 4) {
				g.drawImage(storage2, 555, 60, 105, 105, null);
			} else if (select == 5) {
				g.drawImage(storage2, 60, 225, 105, 105, null);
			} else if (select == 6) {
				g.drawImage(storage2, 225, 225, 105, 105, null);
			} else if (select == 7) {
				g.drawImage(storage2, 390, 225, 105, 105, null);
			} else if (select == 8) {
				g.drawImage(storage2, 555, 225, 105, 105, null);
			} else if (select == 9) {
				g.drawImage(storage2, 60, 390, 105, 105, null);
			} else if (select == 10) {
				g.drawImage(storage2, 225, 390, 105, 105, null);
			} else if (select == 11) {
				g.drawImage(storage2, 390, 390, 105, 105, null);
			} else if (select == 12) {
				g.drawImage(storage2, 555, 390, 105, 105, null);
			} else if (select == 13) {
				g.drawImage(left2, 10, 605, 45, 45, null);
			} else if (select == 14) {
				g.drawImage(right2, 655, 605, 45, 45, null);
			}
			// Only 12 shapemon are drawn per page so it draws the shapemon that are
			// supposed to be drawn
			for (int i = 0; i < 12; i++) {
				int x = (i % 4) * 165 + 80;// calculates the x and y image of the shapemon based on the
								// counter value
				int y = (int) (i / 4) * 165 + 80;
				Shapemon q = null;
				if (i < storage.length)// checks to see if there are more shapemon
				{
					if (storage[i] != null)// sees if it is empty
					{
						q = storage[i];
					}
				} else {
					q = null;
				}
				if (q != null) {
					q.draw(x, y, 65, 65, g);
					g.setColor(Color.black);
					if (q.getTypeOfShapemon() != 100) {
						drawString(q.getLevel() + "", x, y + 100, g);
					}
				}

			}
		} else if (menuPart == 8) {
			g.setColor(c);
			g.fillRect(0, 0, 720, 720);
			if (upPressed && upReleased) {
				upReleased = false;
				if (select == 5) {
					select = 1;
				} else if (select == 6) {
					select = 2;
				} else if (select == 7) {
					select = 3;
				} else if (select == 8) {
					select = 4;
				} else if (select == 9) {
					select = 5;
				} else if (select == 10) {
					select = 6;
				} else if (select == 11) {
					select = 7;
				} else if (select == 12) {
					select = 8;
				} else if (select == 13) {
					select = 9;
				} else if (select == 14) {
					select = 12;
				}
			}
			if (downPressed && downReleased) {
				downReleased = false;
				if (select == 1) {
					select = 5;
				} else if (select == 2) {
					select = 6;
				} else if (select == 3) {
					select = 7;
				} else if (select == 4) {
					select = 8;
				} else if (select == 5) {
					select = 9;
				} else if (select == 6) {
					select = 10;
				} else if (select == 7) {
					select = 11;
				} else if (select == 8) {
					select = 12;
				} else if (select == 9) {
					select = 13;
				} else if (select == 12) {
					select = 14;
				}
			}
			if (rightPressed && rightReleased) {
				rightReleased = false;
				if (select == 1) {
					select = 2;
				} else if (select == 2) {
					select = 3;
				} else if (select == 3) {
					select = 4;
				} else if (select == 5) {
					select = 6;
				} else if (select == 6) {
					select = 7;
				} else if (select == 7) {
					select = 8;
				} else if (select == 9) {
					select = 10;
				} else if (select == 10) {
					select = 11;
				} else if (select == 11) {
					select = 12;
				} else if (select == 13) {
					select = 14;
				}
			}
			if (leftPressed && leftReleased) {
				leftReleased = false;
				if (select == 2) {
					select = 1;
				} else if (select == 3) {
					select = 2;
				} else if (select == 4) {
					select = 3;
				} else if (select == 6) {
					select = 5;
				} else if (select == 7) {
					select = 6;
				} else if (select == 8) {
					select = 7;
				} else if (select == 10) {
					select = 9;
				} else if (select == 11) {
					select = 10;
				} else if (select == 12) {
					select = 11;
				} else if (select == 14) {
					select = 13;
				}
			}
			if (enterPressed && enterReleased) {
				enterReleased = false;
				if (select == 14) {
					menuPart = 9;
					select = 1;
				} else if (select == 13) {
					menuPart = 7;
					select = 1;
				} else {
					if (select + 11 < storage.length) {
						newShape = storage[select + 11];
						shapeNew = select + 11;
					}
					menuPart = 15;
					select = 2;
				}
			}

			g.drawImage(left, 10, 605, 45, 45, null);
			g.drawImage(right, 655, 605, 45, 45, null);
			g.drawImage(storage1, 60, 60, 105, 105, null);
			g.drawImage(storage1, 225, 60, 105, 105, null);
			g.drawImage(storage1, 390, 60, 105, 105, null);
			g.drawImage(storage1, 555, 60, 105, 105, null);
			g.drawImage(storage1, 60, 225, 105, 105, null);
			g.drawImage(storage1, 225, 225, 105, 105, null);
			g.drawImage(storage1, 390, 225, 105, 105, null);
			g.drawImage(storage1, 555, 225, 105, 105, null);
			g.drawImage(storage1, 60, 390, 105, 105, null);
			g.drawImage(storage1, 225, 390, 105, 105, null);
			g.drawImage(storage1, 390, 390, 105, 105, null);
			g.drawImage(storage1, 555, 390, 105, 105, null);

			if (select == 1) {
				g.drawImage(storage2, 60, 60, 105, 105, null);
			} else if (select == 2) {
				g.drawImage(storage2, 225, 60, 105, 105, null);
			} else if (select == 3) {
				g.drawImage(storage2, 390, 60, 105, 105, null);
			} else if (select == 4) {
				g.drawImage(storage2, 555, 60, 105, 105, null);
			} else if (select == 5) {
				g.drawImage(storage2, 60, 225, 105, 105, null);
			} else if (select == 6) {
				g.drawImage(storage2, 225, 225, 105, 105, null);
			} else if (select == 7) {
				g.drawImage(storage2, 390, 225, 105, 105, null);
			} else if (select == 8) {
				g.drawImage(storage2, 555, 225, 105, 105, null);
			} else if (select == 9) {
				g.drawImage(storage2, 60, 390, 105, 105, null);
			} else if (select == 10) {
				g.drawImage(storage2, 225, 390, 105, 105, null);
			} else if (select == 11) {
				g.drawImage(storage2, 390, 390, 105, 105, null);
			} else if (select == 12) {
				g.drawImage(storage2, 555, 390, 105, 105, null);
			} else if (select == 13) {
				g.drawImage(left2, 10, 605, 45, 45, null);
			} else if (select == 14) {
				g.drawImage(right2, 655, 605, 45, 45, null);
			}

			for (int i = 12; i < 24; i++) {
				int z = i - 12;
				int x = (z % 4) * 165 + 80;
				int y = (int) (z / 4) * 165 + 80;
				Shapemon q = null;
				if (i < storage.length) {
					if (storage[i] != null) {
						q = storage[i];
					}
				} else {
					q = null;
				}
				if (q != null) {
					q.draw(x, y, 65, 65, g);
					g.setColor(Color.black);
					if (q.getTypeOfShapemon() != 100) {
						drawString(q.getLevel() + "", x, y + 100, g);
					}
				}
			}
		} else if (menuPart == 9) {
			g.setColor(c);
			g.fillRect(0, 0, 720, 720);
			if (upPressed && upReleased) {
				upReleased = false;
				if (select == 5) {
					select = 1;
				} else if (select == 6) {
					select = 2;
				} else if (select == 7) {
					select = 3;
				} else if (select == 8) {
					select = 4;
				} else if (select == 9) {
					select = 5;
				} else if (select == 10) {
					select = 6;
				} else if (select == 11) {
					select = 7;
				} else if (select == 12) {
					select = 8;
				} else if (select == 13) {
					select = 9;
				} else if (select == 14) {
					select = 12;
				}
			}
			if (downPressed && downReleased) {
				downReleased = false;
				if (select == 1) {
					select = 5;
				} else if (select == 2) {
					select = 6;
				} else if (select == 3) {
					select = 7;
				} else if (select == 4) {
					select = 8;
				} else if (select == 5) {
					select = 9;
				} else if (select == 6) {
					select = 10;
				} else if (select == 7) {
					select = 11;
				} else if (select == 8) {
					select = 12;
				} else if (select == 9) {
					select = 13;
				} else if (select == 12) {
					select = 14;
				}
			}
			if (rightPressed && rightReleased) {
				rightReleased = false;
				if (select == 1) {
					select = 2;
				} else if (select == 2) {
					select = 3;
				} else if (select == 3) {
					select = 4;
				} else if (select == 5) {
					select = 6;
				} else if (select == 6) {
					select = 7;
				} else if (select == 7) {
					select = 8;
				} else if (select == 9) {
					select = 10;
				} else if (select == 10) {
					select = 11;
				} else if (select == 11) {
					select = 12;
				} else if (select == 13) {
					select = 14;
				}
			}
			if (leftPressed && leftReleased) {
				leftReleased = false;
				if (select == 2) {
					select = 1;
				} else if (select == 3) {
					select = 2;
				} else if (select == 4) {
					select = 3;
				} else if (select == 6) {
					select = 5;
				} else if (select == 7) {
					select = 6;
				} else if (select == 8) {
					select = 7;
				} else if (select == 10) {
					select = 9;
				} else if (select == 11) {
					select = 10;
				} else if (select == 12) {
					select = 11;
				} else if (select == 14) {
					select = 13;
				}
			}
			if (enterPressed && enterReleased) {
				enterReleased = false;
				if (select == 14) {
					menuPart = 10;
					select = 1;
				} else if (select == 13) {
					menuPart = 8;
					select = 1;
				} else {
					if (select + 23 < storage.length) {
						newShape = storage[select + 23];
						shapeNew = select + 23;
					}
					menuPart = 15;
					select = 2;
				}
			}

			g.drawImage(left, 10, 605, 45, 45, null);
			g.drawImage(right, 655, 605, 45, 45, null);
			g.drawImage(storage1, 60, 60, 105, 105, null);
			g.drawImage(storage1, 225, 60, 105, 105, null);
			g.drawImage(storage1, 390, 60, 105, 105, null);
			g.drawImage(storage1, 555, 60, 105, 105, null);
			g.drawImage(storage1, 60, 225, 105, 105, null);
			g.drawImage(storage1, 225, 225, 105, 105, null);
			g.drawImage(storage1, 390, 225, 105, 105, null);
			g.drawImage(storage1, 555, 225, 105, 105, null);
			g.drawImage(storage1, 60, 390, 105, 105, null);
			g.drawImage(storage1, 225, 390, 105, 105, null);
			g.drawImage(storage1, 390, 390, 105, 105, null);
			g.drawImage(storage1, 555, 390, 105, 105, null);

			if (select == 1) {
				g.drawImage(storage2, 60, 60, 105, 105, null);
			} else if (select == 2) {
				g.drawImage(storage2, 225, 60, 105, 105, null);
			} else if (select == 3) {
				g.drawImage(storage2, 390, 60, 105, 105, null);
			} else if (select == 4) {
				g.drawImage(storage2, 555, 60, 105, 105, null);
			} else if (select == 5) {
				g.drawImage(storage2, 60, 225, 105, 105, null);
			} else if (select == 6) {
				g.drawImage(storage2, 225, 225, 105, 105, null);
			} else if (select == 7) {
				g.drawImage(storage2, 390, 225, 105, 105, null);
			} else if (select == 8) {
				g.drawImage(storage2, 555, 225, 105, 105, null);
			} else if (select == 9) {
				g.drawImage(storage2, 60, 390, 105, 105, null);
			} else if (select == 10) {
				g.drawImage(storage2, 225, 390, 105, 105, null);
			} else if (select == 11) {
				g.drawImage(storage2, 390, 390, 105, 105, null);
			} else if (select == 12) {
				g.drawImage(storage2, 555, 390, 105, 105, null);
			} else if (select == 13) {
				g.drawImage(left2, 10, 605, 45, 45, null);
			} else if (select == 14) {
				g.drawImage(right2, 655, 605, 45, 45, null);
			}

			for (int i = 24; i < 36; i++) {
				int z = i - 24;
				int x = (z % 4) * 165 + 80;
				int y = (int) (z / 4) * 165 + 80;
				Shapemon q = null;
				if (i < storage.length) {
					if (storage[i] != null) {
						q = storage[i];

					}
				} else {
					q = null;
				}
				if (q != null) {
					q.draw(x, y, 65, 65, g);
					g.setColor(Color.black);
					if (q.getTypeOfShapemon() != 100) {
						drawString(q.getLevel() + "", x, y + 100, g);
					}
				}

			}
		} else if (menuPart == 10) {
			g.setColor(c);
			g.fillRect(0, 0, 720, 720);
			if (upPressed && upReleased) {
				upReleased = false;
				if (select == 5) {
					select = 1;
				} else if (select == 6) {
					select = 2;
				} else if (select == 7) {
					select = 3;
				} else if (select == 8) {
					select = 4;
				} else if (select == 9) {
					select = 5;
				} else if (select == 10) {
					select = 6;
				} else if (select == 11) {
					select = 7;
				} else if (select == 12) {
					select = 8;
				} else if (select == 13) {
					select = 9;
				} else if (select == 14) {
					select = 12;
				}
			}
			if (downPressed && downReleased) {
				downReleased = false;
				if (select == 1) {
					select = 5;
				} else if (select == 2) {
					select = 6;
				} else if (select == 3) {
					select = 7;
				} else if (select == 4) {
					select = 8;
				} else if (select == 5) {
					select = 9;
				} else if (select == 6) {
					select = 10;
				} else if (select == 7) {
					select = 11;
				} else if (select == 8) {
					select = 12;
				} else if (select == 9) {
					select = 13;
				} else if (select == 12) {
					select = 14;
				}
			}
			if (rightPressed && rightReleased) {
				rightReleased = false;
				if (select == 1) {
					select = 2;
				} else if (select == 2) {
					select = 3;
				} else if (select == 3) {
					select = 4;
				} else if (select == 5) {
					select = 6;
				} else if (select == 6) {
					select = 7;
				} else if (select == 7) {
					select = 8;
				} else if (select == 9) {
					select = 10;
				} else if (select == 10) {
					select = 11;
				} else if (select == 11) {
					select = 12;
				} else if (select == 13) {
					select = 14;
				}
			}
			if (leftPressed && leftReleased) {
				leftReleased = false;
				if (select == 2) {
					select = 1;
				} else if (select == 3) {
					select = 2;
				} else if (select == 4) {
					select = 3;
				} else if (select == 6) {
					select = 5;
				} else if (select == 7) {
					select = 6;
				} else if (select == 8) {
					select = 7;
				} else if (select == 10) {
					select = 9;
				} else if (select == 11) {
					select = 10;
				} else if (select == 12) {
					select = 11;
				} else if (select == 14) {
					select = 13;
				}
			}
			if (enterPressed && enterReleased) {
				enterReleased = false;
				if (select == 14) {
					menuPart = 11;
					select = 1;
				} else if (select == 13) {
					menuPart = 9;
					select = 1;
				} else {
					if (select + 35 < storage.length) {
						newShape = storage[select + 35];
						shapeNew = select + 35;
					}
					menuPart = 15;
					select = 2;
				}
			}

			g.drawImage(left, 10, 605, 45, 45, null);
			g.drawImage(right, 655, 605, 45, 45, null);
			g.drawImage(storage1, 60, 60, 105, 105, null);
			g.drawImage(storage1, 225, 60, 105, 105, null);
			g.drawImage(storage1, 390, 60, 105, 105, null);
			g.drawImage(storage1, 555, 60, 105, 105, null);
			g.drawImage(storage1, 60, 225, 105, 105, null);
			g.drawImage(storage1, 225, 225, 105, 105, null);
			g.drawImage(storage1, 390, 225, 105, 105, null);
			g.drawImage(storage1, 555, 225, 105, 105, null);
			g.drawImage(storage1, 60, 390, 105, 105, null);
			g.drawImage(storage1, 225, 390, 105, 105, null);
			g.drawImage(storage1, 390, 390, 105, 105, null);
			g.drawImage(storage1, 555, 390, 105, 105, null);

			if (select == 1) {
				g.drawImage(storage2, 60, 60, 105, 105, null);
			} else if (select == 2) {
				g.drawImage(storage2, 225, 60, 105, 105, null);
			} else if (select == 3) {
				g.drawImage(storage2, 390, 60, 105, 105, null);
			} else if (select == 4) {
				g.drawImage(storage2, 555, 60, 105, 105, null);
			} else if (select == 5) {
				g.drawImage(storage2, 60, 225, 105, 105, null);
			} else if (select == 6) {
				g.drawImage(storage2, 225, 225, 105, 105, null);
			} else if (select == 7) {
				g.drawImage(storage2, 390, 225, 105, 105, null);
			} else if (select == 8) {
				g.drawImage(storage2, 555, 225, 105, 105, null);
			} else if (select == 9) {
				g.drawImage(storage2, 60, 390, 105, 105, null);
			} else if (select == 10) {
				g.drawImage(storage2, 225, 390, 105, 105, null);
			} else if (select == 11) {
				g.drawImage(storage2, 390, 390, 105, 105, null);
			} else if (select == 12) {
				g.drawImage(storage2, 555, 390, 105, 105, null);
			} else if (select == 13) {
				g.drawImage(left2, 10, 605, 45, 45, null);
			} else if (select == 14) {
				g.drawImage(right2, 655, 605, 45, 45, null);
			}

			for (int i = 36; i < 48; i++) {
				int z = i - 36;
				int x = (z % 4) * 165 + 80;
				int y = (int) (z / 4) * 165 + 80;
				Shapemon q = null;
				if (i < storage.length) {
					if (storage[i] != null) {
						q = storage[i];
					}
				} else {
					q = null;
				}
				if (q != null) {
					q.draw(x, y, 65, 65, g);
					g.setColor(Color.black);
					if (q.getTypeOfShapemon() != 100) {
						drawString(q.getLevel() + "", x, y + 100, g);
					}
				}
			}
		} else if (menuPart == 11) {
			g.setColor(c);
			g.fillRect(0, 0, 720, 720);
			if (upPressed && upReleased) {
				upReleased = false;
				if (select == 5) {
					select = 1;
				} else if (select == 6) {
					select = 2;
				} else if (select == 7) {
					select = 3;
				} else if (select == 8) {
					select = 4;
				} else if (select == 9) {
					select = 5;
				} else if (select == 10) {
					select = 6;
				} else if (select == 11) {
					select = 7;
				} else if (select == 12) {
					select = 8;
				} else if (select == 13) {
					select = 9;
				} else if (select == 14) {
					select = 12;
				}
			}
			if (downPressed && downReleased) {
				downReleased = false;
				if (select == 1) {
					select = 5;
				} else if (select == 2) {
					select = 6;
				} else if (select == 3) {
					select = 7;
				} else if (select == 4) {
					select = 8;
				} else if (select == 5) {
					select = 9;
				} else if (select == 6) {
					select = 10;
				} else if (select == 7) {
					select = 11;
				} else if (select == 8) {
					select = 12;
				} else if (select == 9) {
					select = 13;
				} else if (select == 12) {
					select = 14;
				}
			}
			if (rightPressed && rightReleased) {
				rightReleased = false;
				if (select == 1) {
					select = 2;
				} else if (select == 2) {
					select = 3;
				} else if (select == 3) {
					select = 4;
				} else if (select == 5) {
					select = 6;
				} else if (select == 6) {
					select = 7;
				} else if (select == 7) {
					select = 8;
				} else if (select == 9) {
					select = 10;
				} else if (select == 10) {
					select = 11;
				} else if (select == 11) {
					select = 12;
				} else if (select == 13) {
					select = 14;
				}
			}
			if (leftPressed && leftReleased) {
				leftReleased = false;
				if (select == 2) {
					select = 1;
				} else if (select == 3) {
					select = 2;
				} else if (select == 4) {
					select = 3;
				} else if (select == 6) {
					select = 5;
				} else if (select == 7) {
					select = 6;
				} else if (select == 8) {
					select = 7;
				} else if (select == 10) {
					select = 9;
				} else if (select == 11) {
					select = 10;
				} else if (select == 12) {
					select = 11;
				} else if (select == 14) {
					select = 13;
				}
			}
			if (enterPressed && enterReleased) {
				enterReleased = false;
				if (select == 14) {
					menuPart = 12;
					select = 1;
				} else if (select == 13) {
					menuPart = 10;
					select = 1;
				} else {
					if (select + 47 < storage.length) {
						newShape = storage[select + 47];
						shapeNew = select + 47;
					}
					menuPart = 15;
					select = 2;
				}
			}

			g.drawImage(left, 10, 605, 45, 45, null);
			g.drawImage(right, 655, 605, 45, 45, null);
			g.drawImage(storage1, 60, 60, 105, 105, null);
			g.drawImage(storage1, 225, 60, 105, 105, null);
			g.drawImage(storage1, 390, 60, 105, 105, null);
			g.drawImage(storage1, 555, 60, 105, 105, null);
			g.drawImage(storage1, 60, 225, 105, 105, null);
			g.drawImage(storage1, 225, 225, 105, 105, null);
			g.drawImage(storage1, 390, 225, 105, 105, null);
			g.drawImage(storage1, 555, 225, 105, 105, null);
			g.drawImage(storage1, 60, 390, 105, 105, null);
			g.drawImage(storage1, 225, 390, 105, 105, null);
			g.drawImage(storage1, 390, 390, 105, 105, null);
			g.drawImage(storage1, 555, 390, 105, 105, null);

			if (select == 1) {
				g.drawImage(storage2, 60, 60, 105, 105, null);
			} else if (select == 2) {
				g.drawImage(storage2, 225, 60, 105, 105, null);
			} else if (select == 3) {
				g.drawImage(storage2, 390, 60, 105, 105, null);
			} else if (select == 4) {
				g.drawImage(storage2, 555, 60, 105, 105, null);
			} else if (select == 5) {
				g.drawImage(storage2, 60, 225, 105, 105, null);
			} else if (select == 6) {
				g.drawImage(storage2, 225, 225, 105, 105, null);
			} else if (select == 7) {
				g.drawImage(storage2, 390, 225, 105, 105, null);
			} else if (select == 8) {
				g.drawImage(storage2, 555, 225, 105, 105, null);
			} else if (select == 9) {
				g.drawImage(storage2, 60, 390, 105, 105, null);
			} else if (select == 10) {
				g.drawImage(storage2, 225, 390, 105, 105, null);
			} else if (select == 11) {
				g.drawImage(storage2, 390, 390, 105, 105, null);
			} else if (select == 12) {
				g.drawImage(storage2, 555, 390, 105, 105, null);
			} else if (select == 13) {
				g.drawImage(left2, 10, 605, 45, 45, null);
			} else if (select == 14) {
				g.drawImage(right2, 655, 605, 45, 45, null);
			}

			for (int i = 48; i < 60; i++) {
				int z = i - 48;
				int x = (z % 4) * 165 + 80;
				int y = (int) (z / 4) * 165 + 80;
				Shapemon q = null;
				if (i < storage.length) {
					if (storage[i] != null) {
						q = storage[i];
					}
				} else {
					q = null;
				}
				if (q != null) {
					q.draw(x, y, 65, 65, g);
					g.setColor(Color.black);
					if (q.getTypeOfShapemon() != 100) {
						drawString(q.getLevel() + "", x, y + 100, g);
					}
				}
			}
		} else if (menuPart == 12) {
			g.setColor(c);
			g.fillRect(0, 0, 720, 720);
			if (upPressed && upReleased) {
				upReleased = false;
				if (select == 5) {
					select = 1;
				} else if (select == 6) {
					select = 2;
				} else if (select == 7) {
					select = 3;
				} else if (select == 8) {
					select = 4;
				} else if (select == 9) {
					select = 5;
				} else if (select == 10) {
					select = 6;
				} else if (select == 11) {
					select = 7;
				} else if (select == 12) {
					select = 8;
				} else if (select == 13) {
					select = 9;
				} else if (select == 14) {
					select = 12;
				}
			}
			if (downPressed && downReleased) {
				downReleased = false;
				if (select == 1) {
					select = 5;
				} else if (select == 2) {
					select = 6;
				} else if (select == 3) {
					select = 7;
				} else if (select == 4) {
					select = 8;
				} else if (select == 5) {
					select = 9;
				} else if (select == 6) {
					select = 10;
				} else if (select == 7) {
					select = 11;
				} else if (select == 8) {
					select = 12;
				} else if (select == 9) {
					select = 13;
				} else if (select == 12) {
					select = 14;
				}
			}
			if (rightPressed && rightReleased) {
				rightReleased = false;
				if (select == 1) {
					select = 2;
				} else if (select == 2) {
					select = 3;
				} else if (select == 3) {
					select = 4;
				} else if (select == 5) {
					select = 6;
				} else if (select == 6) {
					select = 7;
				} else if (select == 7) {
					select = 8;
				} else if (select == 9) {
					select = 10;
				} else if (select == 10) {
					select = 11;
				} else if (select == 11) {
					select = 12;
				} else if (select == 13) {
					select = 14;
				}
			}
			if (leftPressed && leftReleased) {
				leftReleased = false;
				if (select == 2) {
					select = 1;
				} else if (select == 3) {
					select = 2;
				} else if (select == 4) {
					select = 3;
				} else if (select == 6) {
					select = 5;
				} else if (select == 7) {
					select = 6;
				} else if (select == 8) {
					select = 7;
				} else if (select == 10) {
					select = 9;
				} else if (select == 11) {
					select = 10;
				} else if (select == 12) {
					select = 11;
				} else if (select == 14) {
					select = 13;
				}
			}
			if (enterPressed && enterReleased) {
				enterReleased = false;
				if (select == 14) {
					menuPart = 13;
					select = 1;
				} else if (select == 13) {
					menuPart = 11;
					select = 1;
				} else {
					if (select + 59 < storage.length) {
						newShape = storage[select + 59];
						shapeNew = select + 59;
					}
					menuPart = 15;
					select = 2;
				}
			}

			g.drawImage(left, 10, 605, 45, 45, null);
			g.drawImage(right, 655, 605, 45, 45, null);
			g.drawImage(storage1, 60, 60, 105, 105, null);
			g.drawImage(storage1, 225, 60, 105, 105, null);
			g.drawImage(storage1, 390, 60, 105, 105, null);
			g.drawImage(storage1, 555, 60, 105, 105, null);
			g.drawImage(storage1, 60, 225, 105, 105, null);
			g.drawImage(storage1, 225, 225, 105, 105, null);
			g.drawImage(storage1, 390, 225, 105, 105, null);
			g.drawImage(storage1, 555, 225, 105, 105, null);
			g.drawImage(storage1, 60, 390, 105, 105, null);
			g.drawImage(storage1, 225, 390, 105, 105, null);
			g.drawImage(storage1, 390, 390, 105, 105, null);
			g.drawImage(storage1, 555, 390, 105, 105, null);

			if (select == 1) {
				g.drawImage(storage2, 60, 60, 105, 105, null);
			} else if (select == 2) {
				g.drawImage(storage2, 225, 60, 105, 105, null);
			} else if (select == 3) {
				g.drawImage(storage2, 390, 60, 105, 105, null);
			} else if (select == 4) {
				g.drawImage(storage2, 555, 60, 105, 105, null);
			} else if (select == 5) {
				g.drawImage(storage2, 60, 225, 105, 105, null);
			} else if (select == 6) {
				g.drawImage(storage2, 225, 225, 105, 105, null);
			} else if (select == 7) {
				g.drawImage(storage2, 390, 225, 105, 105, null);
			} else if (select == 8) {
				g.drawImage(storage2, 555, 225, 105, 105, null);
			} else if (select == 9) {
				g.drawImage(storage2, 60, 390, 105, 105, null);
			} else if (select == 10) {
				g.drawImage(storage2, 225, 390, 105, 105, null);
			} else if (select == 11) {
				g.drawImage(storage2, 390, 390, 105, 105, null);
			} else if (select == 12) {
				g.drawImage(storage2, 555, 390, 105, 105, null);
			} else if (select == 13) {
				g.drawImage(left2, 10, 605, 45, 45, null);
			} else if (select == 14) {
				g.drawImage(right2, 655, 605, 45, 45, null);
			}

			for (int i = 60; i < 72; i++) {
				int z = i - 60;
				int x = (z % 4) * 165 + 80;
				int y = (int) (z / 4) * 165 + 80;
				Shapemon q = null;
				if (i < storage.length) {
					if (storage[i] != null) {
						q = storage[i];
					}
				} else {
					q = null;
				}
				if (q != null) {
					q.draw(x, y, 65, 65, g);
					g.setColor(Color.black);
					if (q.getTypeOfShapemon() != 100) {
						drawString(q.getLevel() + "", x, y + 100, g);
					}
				}

			}
		} else if (menuPart == 12) {
			g.setColor(c);
			g.fillRect(0, 0, 720, 720);
			if (upPressed && upReleased) {
				upReleased = false;
				if (select == 5) {
					select = 1;
				} else if (select == 6) {
					select = 2;
				} else if (select == 7) {
					select = 3;
				} else if (select == 8) {
					select = 4;
				} else if (select == 9) {
					select = 5;
				} else if (select == 10) {
					select = 6;
				} else if (select == 11) {
					select = 7;
				} else if (select == 12) {
					select = 8;
				} else if (select == 13) {
					select = 9;
				} else if (select == 14) {
					select = 12;
				}
			}
			if (downPressed && downReleased) {
				downReleased = false;
				if (select == 1) {
					select = 5;
				} else if (select == 2) {
					select = 6;
				} else if (select == 3) {
					select = 7;
				} else if (select == 4) {
					select = 8;
				} else if (select == 5) {
					select = 9;
				} else if (select == 6) {
					select = 10;
				} else if (select == 7) {
					select = 11;
				} else if (select == 8) {
					select = 12;
				} else if (select == 9) {
					select = 13;
				} else if (select == 12) {
					select = 14;
				}
			}
			if (rightPressed && rightReleased) {
				rightReleased = false;
				if (select == 1) {
					select = 2;
				} else if (select == 2) {
					select = 3;
				} else if (select == 3) {
					select = 4;
				} else if (select == 5) {
					select = 6;
				} else if (select == 6) {
					select = 7;
				} else if (select == 7) {
					select = 8;
				} else if (select == 9) {
					select = 10;
				} else if (select == 10) {
					select = 11;
				} else if (select == 11) {
					select = 12;
				} else if (select == 13) {
					select = 14;
				}
			}
			if (leftPressed && leftReleased) {
				leftReleased = false;
				if (select == 2) {
					select = 1;
				} else if (select == 3) {
					select = 2;
				} else if (select == 4) {
					select = 3;
				} else if (select == 6) {
					select = 5;
				} else if (select == 7) {
					select = 6;
				} else if (select == 8) {
					select = 7;
				} else if (select == 10) {
					select = 9;
				} else if (select == 11) {
					select = 10;
				} else if (select == 12) {
					select = 11;
				} else if (select == 14) {
					select = 13;
				}
			}
			if (enterPressed && enterReleased) {
				enterReleased = false;
				if (select == 14) {
					menuPart = 14;
					select = 1;
				} else if (select == 13) {
					menuPart = 12;
					select = 1;
				} else {
					if (select + 71 < storage.length) {
						newShape = storage[select + 71];
						shapeNew = select + 71;
					}
					menuPart = 15;
					select = 2;
				}
			}
			g.drawImage(left, 10, 605, 45, 45, null);
			g.drawImage(right, 655, 605, 45, 45, null);
			g.drawImage(storage1, 60, 60, 105, 105, null);
			g.drawImage(storage1, 225, 60, 105, 105, null);
			g.drawImage(storage1, 390, 60, 105, 105, null);
			g.drawImage(storage1, 555, 60, 105, 105, null);
			g.drawImage(storage1, 60, 225, 105, 105, null);
			g.drawImage(storage1, 225, 225, 105, 105, null);
			g.drawImage(storage1, 390, 225, 105, 105, null);
			g.drawImage(storage1, 555, 225, 105, 105, null);
			g.drawImage(storage1, 60, 390, 105, 105, null);
			g.drawImage(storage1, 225, 390, 105, 105, null);
			g.drawImage(storage1, 390, 390, 105, 105, null);
			g.drawImage(storage1, 555, 390, 105, 105, null);
			if (select == 1) {
				g.drawImage(storage2, 60, 60, 105, 105, null);
			} else if (select == 2) {
				g.drawImage(storage2, 225, 60, 105, 105, null);
			} else if (select == 3) {
				g.drawImage(storage2, 390, 60, 105, 105, null);
			} else if (select == 4) {
				g.drawImage(storage2, 555, 60, 105, 105, null);
			} else if (select == 5) {
				g.drawImage(storage2, 60, 225, 105, 105, null);
			} else if (select == 6) {
				g.drawImage(storage2, 225, 225, 105, 105, null);
			} else if (select == 7) {
				g.drawImage(storage2, 390, 225, 105, 105, null);
			} else if (select == 8) {
				g.drawImage(storage2, 555, 225, 105, 105, null);
			} else if (select == 9) {
				g.drawImage(storage2, 60, 390, 105, 105, null);
			} else if (select == 10) {
				g.drawImage(storage2, 225, 390, 105, 105, null);
			} else if (select == 11) {
				g.drawImage(storage2, 390, 390, 105, 105, null);
			} else if (select == 12) {
				g.drawImage(storage2, 555, 390, 105, 105, null);
			} else if (select == 13) {
				g.drawImage(left2, 10, 605, 45, 45, null);
			} else if (select == 14) {
				g.drawImage(right2, 655, 605, 45, 45, null);
			}

			for (int i = 84; i < 96; i++) {
				int z = i - 84;
				int x = (z % 4) * 165 + 80;
				int y = (int) (z / 4) * 165 + 80;
				Shapemon q = null;
				if (i < storage.length) {
					if (storage[i] != null) {
						q = storage[i];
					}
				} else {
					q = null;
				}
				if (q != null) {
					q.draw(x, y, 65, 65, g);
					g.setColor(Color.black);
					if (q.getTypeOfShapemon() != 100) {
						drawString(q.getLevel() + "", x, y + 100, g);
					}
				}
			}
		} else if (menuPart == 13) {
			g.setColor(c);
			g.fillRect(0, 0, 720, 720);
			if (upPressed && upReleased) {
				upReleased = false;
				if (select == 5) {
					select = 1;
				} else if (select == 6) {
					select = 2;
				} else if (select == 7) {
					select = 3;
				} else if (select == 8) {
					select = 4;
				} else if (select == 9) {
					select = 5;
				} else if (select == 10) {
					select = 6;
				} else if (select == 11) {
					select = 7;
				} else if (select == 12) {
					select = 8;
				} else if (select == 13) {
					select = 9;
				} else if (select == 14) {
					select = 12;
				}
			}
			if (downPressed && downReleased) {
				downReleased = false;
				if (select == 1) {
					select = 5;
				} else if (select == 2) {
					select = 6;
				} else if (select == 3) {
					select = 7;
				} else if (select == 4) {
					select = 8;
				} else if (select == 5) {
					select = 9;
				} else if (select == 6) {
					select = 10;
				} else if (select == 7) {
					select = 11;
				} else if (select == 8) {
					select = 12;
				} else if (select == 9) {
					select = 13;
				} else if (select == 12) {
					select = 14;
				}
			}
			if (rightPressed && rightReleased) {
				rightReleased = false;
				if (select == 1) {
					select = 2;
				} else if (select == 2) {
					select = 3;
				} else if (select == 3) {
					select = 4;
				} else if (select == 5) {
					select = 6;
				} else if (select == 6) {
					select = 7;
				} else if (select == 7) {
					select = 8;
				} else if (select == 9) {
					select = 10;
				} else if (select == 10) {
					select = 11;
				} else if (select == 11) {
					select = 12;
				} else if (select == 13) {
					select = 14;
				}
			}
			if (leftPressed && leftReleased) {
				leftReleased = false;
				if (select == 2) {
					select = 1;
				} else if (select == 3) {
					select = 2;
				} else if (select == 4) {
					select = 3;
				} else if (select == 6) {
					select = 5;
				} else if (select == 7) {
					select = 6;
				} else if (select == 8) {
					select = 7;
				} else if (select == 10) {
					select = 9;
				} else if (select == 11) {
					select = 10;
				} else if (select == 12) {
					select = 11;
				} else if (select == 14) {
					select = 13;
				}
			}
			if (enterPressed && enterReleased) {
				enterReleased = false;
				if (select == 14) {
					menuPart = 14;
					select = 1;
				} else if (select == 13) {
					menuPart = 12;
					select = 1;
				} else {
					if (select + 95 < storage.length) {
						newShape = storage[select + 95];
						shapeNew = select + 95;
					}
					menuPart = 15;
					select = 2;
				}
			}
			g.drawImage(left, 10, 605, 45, 45, null);
			g.drawImage(right, 655, 605, 45, 45, null);
			g.drawImage(storage1, 60, 60, 105, 105, null);
			g.drawImage(storage1, 225, 60, 105, 105, null);
			g.drawImage(storage1, 390, 60, 105, 105, null);
			g.drawImage(storage1, 555, 60, 105, 105, null);
			g.drawImage(storage1, 60, 225, 105, 105, null);
			g.drawImage(storage1, 225, 225, 105, 105, null);
			g.drawImage(storage1, 390, 225, 105, 105, null);
			g.drawImage(storage1, 555, 225, 105, 105, null);
			g.drawImage(storage1, 60, 390, 105, 105, null);
			g.drawImage(storage1, 225, 390, 105, 105, null);
			g.drawImage(storage1, 390, 390, 105, 105, null);
			g.drawImage(storage1, 555, 390, 105, 105, null);
			if (select == 1) {
				g.drawImage(storage2, 60, 60, 105, 105, null);
			} else if (select == 2) {
				g.drawImage(storage2, 225, 60, 105, 105, null);
			} else if (select == 3) {
				g.drawImage(storage2, 390, 60, 105, 105, null);
			} else if (select == 4) {
				g.drawImage(storage2, 555, 60, 105, 105, null);
			} else if (select == 5) {
				g.drawImage(storage2, 60, 225, 105, 105, null);
			} else if (select == 6) {
				g.drawImage(storage2, 225, 225, 105, 105, null);
			} else if (select == 7) {
				g.drawImage(storage2, 390, 225, 105, 105, null);
			} else if (select == 8) {
				g.drawImage(storage2, 555, 225, 105, 105, null);
			} else if (select == 9) {
				g.drawImage(storage2, 60, 390, 105, 105, null);
			} else if (select == 10) {
				g.drawImage(storage2, 225, 390, 105, 105, null);
			} else if (select == 11) {
				g.drawImage(storage2, 390, 390, 105, 105, null);
			} else if (select == 12) {
				g.drawImage(storage2, 555, 390, 105, 105, null);
			} else if (select == 13) {
				g.drawImage(left2, 10, 605, 45, 45, null);
			} else if (select == 14) {
				g.drawImage(right2, 655, 605, 45, 45, null);
			}

			for (int i = 96; i < 108; i++) {
				int z = i - 96;
				int x = (z % 4) * 165 + 80;
				int y = (int) (z / 4) * 165 + 80;
				Shapemon q = null;
				if (i < storage.length) {
					if (storage[i] != null) {
						q = storage[i];
					}
				} else {
					q = null;
				}
				if (q != null) {
					q.draw(x, y, 65, 65, g);
					g.setColor(Color.black);
					if (q.getTypeOfShapemon() != 100) {
						drawString(q.getLevel() + "", x, y + 100, g);
					}
				}
			}
		} else if (menuPart == 14) {
			g.setColor(c);
			g.fillRect(0, 0, 720, 720);
			if (upPressed && upReleased) {
				upReleased = false;
				if (select == 5) {
					select = 1;
				} else if (select == 6) {
					select = 2;
				} else if (select == 7) {
					select = 3;
				} else if (select == 8) {
					select = 4;
				} else if (select == 9) {
					select = 5;
				} else if (select == 10) {
					select = 6;
				} else if (select == 11) {
					select = 7;
				} else if (select == 12) {
					select = 8;
				} else if (select == 13) {
					select = 9;
				}
			}
			if (downPressed && downReleased) {
				downReleased = false;
				if (select == 1) {
					select = 5;
				} else if (select == 2) {
					select = 6;
				} else if (select == 3) {
					select = 7;
				} else if (select == 4) {
					select = 8;
				} else if (select == 5) {
					select = 9;
				} else if (select == 6) {
					select = 10;
				} else if (select == 7) {
					select = 11;
				} else if (select == 8) {
					select = 12;
				} else if (select == 9) {
					select = 13;
				}
			}
			if (rightPressed && rightReleased) {
				rightReleased = false;
				if (select == 1) {
					select = 2;
				} else if (select == 2) {
					select = 3;
				} else if (select == 3) {
					select = 4;
				} else if (select == 5) {
					select = 6;
				} else if (select == 6) {
					select = 7;
				} else if (select == 7) {
					select = 8;
				} else if (select == 9) {
					select = 10;
				} else if (select == 10) {
					select = 11;
				} else if (select == 11) {
					select = 12;
				}
			}
			if (leftPressed && leftReleased) {
				leftReleased = false;
				if (select == 2) {
					select = 1;
				} else if (select == 3) {
					select = 2;
				} else if (select == 4) {
					select = 3;
				} else if (select == 6) {
					select = 5;
				} else if (select == 7) {
					select = 6;
				} else if (select == 8) {
					select = 7;
				} else if (select == 10) {
					select = 9;
				} else if (select == 11) {
					select = 10;
				} else if (select == 12) {
					select = 11;
				}
			}
			if (enterPressed && enterReleased) {
				enterReleased = false;
				if (select == 13) {
					menuPart = 13;
					select = 1;
				} else {
					if (select + 107 < storage.length) {
						newShape = storage[select + 107];
						shapeNew = select + 107;
					}
					menuPart = 15;
					select = 2;
				}
			}
			g.drawImage(left, 10, 605, 45, 45, null);
			g.drawImage(storage1, 60, 60, 105, 105, null);
			g.drawImage(storage1, 225, 60, 105, 105, null);
			g.drawImage(storage1, 390, 60, 105, 105, null);
			g.drawImage(storage1, 555, 60, 105, 105, null);
			g.drawImage(storage1, 60, 225, 105, 105, null);
			g.drawImage(storage1, 225, 225, 105, 105, null);
			g.drawImage(storage1, 390, 225, 105, 105, null);
			g.drawImage(storage1, 555, 225, 105, 105, null);
			g.drawImage(storage1, 60, 390, 105, 105, null);
			g.drawImage(storage1, 225, 390, 105, 105, null);
			g.drawImage(storage1, 390, 390, 105, 105, null);
			g.drawImage(storage1, 555, 390, 105, 105, null);
			if (select == 1) {
				g.drawImage(storage2, 60, 60, 105, 105, null);
			} else if (select == 2) {
				g.drawImage(storage2, 225, 60, 105, 105, null);
			} else if (select == 3) {
				g.drawImage(storage2, 390, 60, 105, 105, null);
			} else if (select == 4) {
				g.drawImage(storage2, 555, 60, 105, 105, null);
			} else if (select == 5) {
				g.drawImage(storage2, 60, 225, 105, 105, null);
			} else if (select == 6) {
				g.drawImage(storage2, 225, 225, 105, 105, null);
			} else if (select == 7) {
				g.drawImage(storage2, 390, 225, 105, 105, null);
			} else if (select == 8) {
				g.drawImage(storage2, 555, 225, 105, 105, null);
			} else if (select == 9) {
				g.drawImage(storage2, 60, 390, 105, 105, null);
			} else if (select == 10) {
				g.drawImage(storage2, 225, 390, 105, 105, null);
			} else if (select == 11) {
				g.drawImage(storage2, 390, 390, 105, 105, null);
			} else if (select == 12) {
				g.drawImage(storage2, 555, 390, 105, 105, null);
			} else if (select == 13) {
				g.drawImage(left2, 10, 605, 45, 45, null);
			}

			for (int i = 108; i < 120; i++) {
				int z = i - 108;
				int x = (z % 4) * 165 + 80;
				int y = (int) (z / 4) * 165 + 80;
				Shapemon q = null;
				if (i < storage.length) {
					if (storage[i] != null) {
						q = storage[i];
					}
				} else {
					q = null;
				}
				if (q != null) {
					q.draw(x, y, 65, 65, g);
					g.setColor(Color.black);
					if (q.getTypeOfShapemon() != 100) {
						drawString(q.getLevel() + "", x, y + 100, g);
					}
				}
			}
		} else if (menuPart == 15) {
			if (rightPressed & rightReleased) {
				rightReleased = false;
				select = 2;
			}
			if (leftPressed & leftReleased) {
				leftReleased = false;
				select = 1;
			}
			if (enterPressed && enterReleased) {
				enterReleased = false;
				if (select == 1) {
					menuPart = 6;
				}
				if (select == 2) {
					p.deleteShapemon(shapeOld);
					p.addShapemon(newShape);
					menuPart = 16;
					storage[shapeNew] = oldShape;
				}
			}
			g.setColor(Color.black);
			drawString("You are switching", 150, 25, g);

			if (oldShape != null) {
				oldShape.draw(25, 200, 200, 200, g);
				g.setColor(Color.black);
				drawString(oldShape.getLevel() + "", 55, 425, g);
			}
			drawString("for", 320, 280, g);
			if (newShape != null) {
				newShape.draw(475, 200, 200, 200, g);
				g.setColor(Color.black);
				drawString(newShape.getLevel() + "", 505, 425, g);
			}

			g.drawImage(left, 10, 605, 45, 45, null);
			g.drawImage(check, 655, 605, 45, 45, null);
			if (select == 1) {
				g.drawImage(left2, 10, 605, 45, 45, null);
			} else if (select == 2) {
				g.drawImage(check2, 655, 605, 45, 45, null);
			}
		}
		if (menuPart == 16) {
			// checks to see where the empty space is in storage and adds the shapemon
			g.setColor(Color.black);
			drawString("Successful Transaction", 100, 630, g);
			if (enterPressed && enterReleased) {
				enterReleased = false;
				// logan has to code to close window
				menuPart = 1;
				map.closeMenu();
			}

			for (int i = 1; i <= p.getNumOfShapemon(); i++) {
				int x = 215 * ((i - 1) % 3);
				int y = 215 * ((i - 1) / 3);

				p.getShapemon(i).draw(95 + x, 95 + y, 100, 100, g);

				drawString("LVL " + p.getShapemon(i).getLevel(), 75 + x, 230 + y, g);
			}
		}
		return menuPart;
	}

	private static void reorder(Player p) {
		int removed = 0;
		Shapemon holder = null;

		for (int i = 1; i < 6; i++) {
			if (p.getShapemon(i) == null) {
				p.deleteShapemon(i);
				removed++;
			}

		}
		for (int i = 0; i <= removed; i++) {
			p.addShapemon(null);
		}
		removed = 0;
	}

	public static Shapemon[] returnStorage() {
		return storage;
	}
	// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	// draw String
	private static void drawString(String s, int x, int y, Graphics g) {
		for (int i = 0; i < s.length(); i++) {
			switch (s.toLowerCase().charAt(i)) {
				case 'a':
					drawA(x, y, g);
					x = x + 25;
					break;
				case 'b':
					drawB(x, y, g);
					x = x + 25;
					break;
				case 'c':
					drawC(x, y, g);
					x = x + 25;
					break;
				case 'd':
					drawD(x, y, g);
					x = x + 25;
					break;
				case 'e':
					drawE(x, y, g);
					x = x + 25;
					break;
				case 'f':
					drawF(x, y, g);
					x = x + 25;
					break;
				case 'g':
					drawG(x, y, g);
					x = x + 25;
					break;
				case 'h':
					drawH(x, y, g);
					x = x + 25;
					break;
				case 'i':
					drawI(x, y, g);
					x = x + 20;
					break;
				case 'j':
					drawJ(x, y, g);
					x = x + 25;
					break;
				case 'k':
					drawK(x, y, g);
					x = x + 25;
					break;
				case 'l':
					drawL(x, y, g);
					x = x + 25;
					break;
				case 'm':
					drawM(x, y, g);
					x = x + 30;
					break;
				case 'n':
					drawN(x, y, g);
					x = x + 25;
					break;
				case 'o':
					drawO(x, y, g);
					x = x + 25;
					break;
				case 'p':
					drawP(x, y, g);
					x = x + 25;
					break;
				case 'q':
					drawQ(x, y, g);
					x = x + 30;
					break;
				case 'r':
					drawR(x, y, g);
					x = x + 25;
					break;
				case 's':
					drawS(x, y, g);
					x = x + 25;
					break;
				case 't':
					drawT(x, y, g);
					x = x + 30;
					break;
				case 'u':
					drawU(x, y, g);
					x = x + 25;
					break;
				case 'v':
					drawV(x, y, g);
					x = x + 25;
					break;
				case 'w':
					drawW(x, y, g);
					x = x + 30;
					break;
				case 'x':
					drawX(x, y, g);
					x = x + 25;
					break;
				case 'y':
					drawY(x, y, g);
					x = x + 30;
					break;
				case 'z':
					drawZ(x, y, g);
					x = x + 25;
					break;
				case '1':
					draw1(x, y, g);
					x = x + 20;
					break;
				case '2':
					draw2(x, y, g);
					x = x + 25;
					break;
				case '3':
					draw3(x, y, g);
					x = x + 25;
					break;
				case '4':
					draw4(x, y, g);
					x = x + 25;
					break;
				case '5':
					draw5(x, y, g);
					x = x + 25;
					break;
				case '6':
					draw6(x, y, g);
					x = x + 25;
					break;
				case '7':
					draw7(x, y, g);
					x = x + 25;
					break;
				case '8':
					draw8(x, y, g);
					x = x + 25;
					break;
				case '9':
					draw9(x, y, g);
					x = x + 25;
					break;
				case '0':
					draw0(x, y, g);
					x = x + 25;
					break;
				case ' ':
					x = x + 20;
					break;
				case ',':
					drawComma(x, y, g);
					x = x + 10;
					break;
				case '.':
					drawPeriod(x, y, g);
					x = x + 10;
					break;
				case '/':
					drawSlash(x, y, g);
					x = x + 35;
					break;
				case '\\':
					drawBackSlash(x, y, g);
					x = x + 35;
					break;
				case ';':
					drawSemmicolen(x, y, g);
					x = x + 10;
					break;
				case '\'':
					drawApostrophi(x, y, g);
					x = x + 10;
					break;
				case '`':
					drawAccentmark(x, y, g);
					x = x + 15;
					break;
				case '[':
					drawBracket(x, y, g);
					x = x + 15;
					break;
				case ']':
					drawBackBracket(x, y, g);
					x = x + 15;
					break;
				case '-':
					drawDash(x, y, g);
					x = x + 20;
					break;
				case '=':
					drawEqualsign(x, y, g);
					x = x + 25;
					break;
				default:
					x = x + 20;
					break;
			}
		}
	}

	private int getLength(String s) {
		int x = 0;
		for (int i = 0; i < s.length(); i++) {
			switch (s.toLowerCase().charAt(i)) {
				case 'a':
					x = x + 25;
					break;
				case 'b':
					x = x + 25;
					break;
				case 'c':
					x = x + 25;
					break;
				case 'd':
					x = x + 25;
					break;
				case 'e':
					x = x + 25;
					break;
				case 'f':
					x = x + 25;
					break;
				case 'g':
					x = x + 25;
					break;
				case 'h':
					x = x + 25;
					break;
				case 'i':
					x = x + 20;
					break;
				case 'j':
					x = x + 25;
					break;
				case 'k':
					x = x + 25;
					break;
				case 'l':
					x = x + 25;
					break;
				case 'm':
					x = x + 30;
					break;
				case 'n':
					x = x + 25;
					break;
				case 'o':
					x = x + 25;
					break;
				case 'p':
					x = x + 25;
					break;
				case 'q':
					x = x + 30;
					break;
				case 'r':
					x = x + 25;
					break;
				case 's':
					x = x + 25;
					break;
				case 't':
					x = x + 30;
					break;
				case 'u':
					x = x + 25;
					break;
				case 'v':
					x = x + 25;
					break;
				case 'w':
					x = x + 30;
					break;
				case 'x':
					x = x + 25;
					break;
				case 'y':
					x = x + 30;
					break;
				case 'z':
					x = x + 25;
					break;
				case '1':
					x = x + 20;
					break;
				case '2':
					x = x + 25;
					break;
				case '3':
					x = x + 25;
					break;
				case '4':
					x = x + 25;
					break;
				case '5':
					x = x + 25;
					break;
				case '6':
					x = x + 25;
					break;
				case '7':
					x = x + 25;
					break;
				case '8':
					x = x + 25;
					break;
				case '9':
					x = x + 25;
					break;
				case '0':
					x = x + 25;
					break;
				case ' ':
					x = x + 20;
					break;
				case ',':
					x = x + 10;
					break;
				case '.':
					x = x + 10;
					break;
				case '/':
					x = x + 35;
					break;
				case '\\':
					x = x + 35;
					break;
				case ';':
					x = x + 10;
					break;
				case '\'':
					x = x + 10;
					break;
				case '`':
					x = x + 15;
					break;
				case '[':
					x = x + 15;
					break;
				case ']':
					x = x + 15;
					break;
				case '-':
					x = x + 20;
					break;
				case '=':
					x = x + 25;
					break;
				default:
					x = x + 20;
					break;
			}
		}
		return x - 5;
	}

	// text font
	private static void drawA(int x, int y, Graphics g) {
		g.fillRect(x + 5, y, 10, 5);
		g.fillRect(x + 15, y + 5, 5, 25);
		g.fillRect(x, y + 5, 5, 25);
		g.fillRect(x + 5, y + 15, 10, 5);
	}

	private static void drawB(int x, int y, Graphics g) {
		g.fillRect(x + 5, y, 10, 5);
		g.fillRect(x + 15, y + 5, 5, 5);
		g.fillRect(x, y, 5, 30);
		g.fillRect(x + 15, y + 15, 5, 10);
		g.fillRect(x + 5, y + 25, 10, 5);
		g.fillRect(x + 5, y + 10, 10, 5);
	}

	private static void drawC(int x, int y, Graphics g) {
		g.fillRect(x + 5, y, 10, 5);
		g.fillRect(x, y + 5, 5, 20);
		g.fillRect(x + 15, y + 5, 5, 5);
		g.fillRect(x + 5, y + 25, 10, 5);
		g.fillRect(x + 15, y + 20, 5, 5);
	}

	private static void drawD(int x, int y, Graphics g) {
		g.fillRect(x + 5, y, 10, 5);
		g.fillRect(x + 15, y + 5, 5, 20);
		g.fillRect(x, y, 5, 30);
		g.fillRect(x + 5, y + 25, 10, 5);
	}

	private static void drawE(int x, int y, Graphics g) {
		g.fillRect(x + 5, y, 15, 5);
		g.fillRect(x, y, 5, 30);
		g.fillRect(x + 5, y + 25, 15, 5);
		g.fillRect(x + 5, y + 10, 10, 5);
	}

	private static void drawF(int x, int y, Graphics g) {
		g.fillRect(x + 5, y, 15, 5);
		g.fillRect(x, y, 5, 30);
		g.fillRect(x + 5, y + 10, 10, 5);
	}

	private static void drawG(int x, int y, Graphics g) {
		g.fillRect(x + 5, y, 10, 5);
		g.fillRect(x, y + 5, 5, 20);
		g.fillRect(x + 15, y + 5, 5, 5);
		g.fillRect(x + 5, y + 25, 10, 5);
		g.fillRect(x + 15, y + 15, 5, 10);
		g.fillRect(x + 10, y + 15, 5, 5);
	}

	private static void drawH(int x, int y, Graphics g) {
		g.fillRect(x + 5, y + 10, 10, 5);
		g.fillRect(x, y, 5, 30);
		g.fillRect(x + 15, y, 5, 30);
	}

	private static void drawI(int x, int y, Graphics g) {
		g.fillRect(x, y, 15, 5);
		g.fillRect(x, y + 25, 15, 5);
		g.fillRect(x + 5, y + 5, 5, 20);
	}

	private static void drawJ(int x, int y, Graphics g) {
		g.fillRect(x + 15, y, 5, 25);
		g.fillRect(x, y + 15, 5, 10);
		g.fillRect(x + 5, y + 25, 10, 5);

	}

	private static void drawK(int x, int y, Graphics g) {
		g.fillRect(x, y, 5, 30);
		g.fillRect(x + 15, y, 5, 5);
		g.fillRect(x + 10, y + 5, 5, 5);
		g.fillRect(x + 5, y + 10, 5, 5);
		g.fillRect(x + 10, y + 15, 5, 5);
		g.fillRect(x + 15, y + 20, 5, 10);
	}

	private static void drawL(int x, int y, Graphics g) {
		g.fillRect(x, y, 5, 30);
		g.fillRect(x + 5, y + 25, 15, 5);

	}

	private static void drawM(int x, int y, Graphics g) {
		g.fillRect(x, y, 5, 30);
		g.fillRect(x + 20, y, 5, 30);
		g.fillRect(x + 5, y + 5, 5, 5);
		g.fillRect(x + 10, y + 10, 5, 5);
		g.fillRect(x + 15, y + 5, 5, 5);
	}

	private static void drawN(int x, int y, Graphics g) {
		g.fillRect(x, y, 5, 30);
		g.fillRect(x + 15, y, 5, 30);
		g.fillRect(x + 5, y + 5, 5, 5);
		g.fillRect(x + 10, y + 10, 5, 5);
	}

	private static void drawO(int x, int y, Graphics g) {
		g.fillRect(x + 5, y, 10, 5);
		g.fillRect(x + 15, y + 5, 5, 20);
		g.fillRect(x, y + 5, 5, 20);
		g.fillRect(x + 5, y + 25, 10, 5);
	}

	private static void drawP(int x, int y, Graphics g) {
		g.fillRect(x, y, 5, 30);
		g.fillRect(x + 5, y, 10, 5);
		g.fillRect(x + 5, y + 15, 10, 5);
		g.fillRect(x + 15, y + 5, 5, 10);
	}

	private static void drawQ(int x, int y, Graphics g) {
		g.fillRect(x + 5, y, 10, 5);
		g.fillRect(x + 15, y + 5, 5, 20);
		g.fillRect(x, y + 5, 5, 20);
		g.fillRect(x + 5, y + 25, 20, 5);
	}

	private static void drawR(int x, int y, Graphics g) {
		g.fillRect(x, y, 5, 30);
		g.fillRect(x + 5, y, 10, 5);
		g.fillRect(x + 5, y + 15, 10, 5);
		g.fillRect(x + 15, y + 5, 5, 10);
		g.fillRect(x + 15, y + 20, 5, 10);
	}

	private static void drawS(int x, int y, Graphics g) {
		g.fillRect(x + 5, y, 10, 5);
		g.fillRect(x + 15, y + 5, 5, 5);
		g.fillRect(x + 5, y + 10, 5, 5);
		g.fillRect(x + 10, y + 15, 5, 5);
		g.fillRect(x + 5, y + 25, 10, 5);
		g.fillRect(x + 15, y + 20, 5, 5);
		g.fillRect(x, y + 5, 5, 5);
		g.fillRect(x, y + 20, 5, 5);
	}

	private static void drawT(int x, int y, Graphics g) {
		g.fillRect(x, y, 25, 5);
		g.fillRect(x + 10, y + 5, 5, 25);
	}

	private static void drawU(int x, int y, Graphics g) {
		g.fillRect(x + 15, y, 5, 25);
		g.fillRect(x, y, 5, 25);
		g.fillRect(x, y + 25, 20, 5);
	}

	private static void drawV(int x, int y, Graphics g) {
		g.fillRect(x + 15, y, 5, 25);
		g.fillRect(x, y, 5, 25);
		g.fillRect(x + 5, y + 25, 10, 5);
	}

	private static void drawW(int x, int y, Graphics g) {
		g.fillRect(x + 20, y, 5, 25);
		g.fillRect(x, y, 5, 25);
		g.fillRect(x + 5, y + 25, 5, 5);
		g.fillRect(x + 15, y + 25, 5, 5);
		g.fillRect(x + 10, y + 15, 5, 10);
	}

	private static void drawX(int x, int y, Graphics g) {
		g.fillRect(x + 15, y, 5, 10);
		g.fillRect(x, y, 5, 10);
		g.fillRect(x + 15, y + 15, 5, 15);
		g.fillRect(x, y + 15, 5, 15);
		g.fillRect(x + 5, y + 10, 10, 5);
	}

	private static void drawY(int x, int y, Graphics g) {
		g.fillRect(x + 20, y, 5, 10);
		g.fillRect(x, y, 5, 10);
		g.fillRect(x + 10, y + 15, 5, 15);
		g.fillRect(x + 5, y + 10, 5, 5);
		g.fillRect(x + 15, y + 10, 5, 5);
	}

	private static void drawZ(int x, int y, Graphics g) {
		g.fillRect(x, y, 20, 5);
		g.fillRect(x, y + 25, 20, 5);
		g.fillRect(x + 15, y + 5, 5, 5);
		g.fillRect(x + 10, y + 10, 5, 5);
		g.fillRect(x + 5, y + 15, 5, 5);
		g.fillRect(x, y + 20, 5, 5);
	}

	private static void draw1(int x, int y, Graphics g) {
		g.fillRect(x + 10, y, 5, 30);
		g.fillRect(x + 5, y + 5, 5, 5);
		g.fillRect(x, y + 10, 5, 5);
	}

	private static void draw2(int x, int y, Graphics g) {
		g.fillRect(x + 5, y, 10, 5);
		g.fillRect(x, y + 5, 5, 5);
		g.fillRect(x + 15, y + 5, 5, 10);
		g.fillRect(x + 5, y + 15, 10, 5);
		g.fillRect(x, y + 20, 5, 5);
		g.fillRect(x, y + 25, 20, 5);
	}

	private static void draw3(int x, int y, Graphics g) {
		g.fillRect(x + 5, y, 10, 5);
		g.fillRect(x, y + 5, 5, 5);
		g.fillRect(x + 15, y + 5, 5, 5);
		g.fillRect(x + 10, y + 10, 5, 5);
		g.fillRect(x + 15, y + 15, 5, 10);
		g.fillRect(x + 5, y + 25, 10, 5);
		g.fillRect(x, y + 20, 5, 5);
	}

	private static void draw4(int x, int y, Graphics g) {
		g.fillRect(x + 10, y, 5, 5);
		g.fillRect(x + 15, y, 5, 30);
		g.fillRect(x + 5, y + 5, 5, 5);
		g.fillRect(x, y + 10, 5, 5);
		g.fillRect(x, y + 15, 20, 5);
	}

	private static void draw5(int x, int y, Graphics g) {
		g.fillRect(x, y, 20, 5);
		g.fillRect(x, y + 5, 5, 5);
		g.fillRect(x, y + 10, 15, 5);
		g.fillRect(x + 15, y + 15, 5, 10);
		g.fillRect(x + 5, y + 25, 10, 5);
		g.fillRect(x, y + 20, 5, 5);
	}

	private static void draw6(int x, int y, Graphics g) {
		g.fillRect(x + 5, y, 10, 5);
		g.fillRect(x + 15, y + 5, 5, 5);
		g.fillRect(x, y + 5, 5, 20);
		g.fillRect(x + 5, y + 15, 10, 5);
		g.fillRect(x + 15, y + 20, 5, 5);
		g.fillRect(x + 5, y + 25, 10, 5);
	}

	private static void draw7(int x, int y, Graphics g) {
		g.fillRect(x, y, 15, 5);
		g.fillRect(x + 15, y + 5, 5, 5);
		g.fillRect(x + 10, y + 10, 5, 5);
		g.fillRect(x + 5, y + 15, 5, 5);
		g.fillRect(x, y + 20, 5, 10);
	}

	private static void draw8(int x, int y, Graphics g) {
		g.fillRect(x + 5, y, 10, 5);
		g.fillRect(x, y + 5, 5, 5);
		g.fillRect(x + 15, y + 5, 5, 5);
		g.fillRect(x + 5, y + 10, 10, 5);
		g.fillRect(x + 15, y + 15, 5, 10);
		g.fillRect(x + 5, y + 25, 10, 5);
		g.fillRect(x, y + 15, 5, 10);
	}

	private static void draw9(int x, int y, Graphics g) {
		g.fillRect(x + 5, y, 10, 5);
		g.fillRect(x, y + 5, 5, 5);
		g.fillRect(x + 15, y + 5, 5, 20);
		g.fillRect(x + 5, y + 10, 10, 5);
		g.fillRect(x + 5, y + 25, 10, 5);
		g.fillRect(x, y + 20, 5, 5);
	}

	private static void draw0(int x, int y, Graphics g) {
		g.fillRect(x + 5, y, 10, 5);
		g.fillRect(x + 15, y + 5, 5, 20);
		g.fillRect(x, y + 5, 5, 20);
		g.fillRect(x + 5, y + 25, 10, 5);
		g.fillRect(x + 5, y + 15, 5, 5);
		g.fillRect(x + 10, y + 10, 5, 5);
	}

	private static void drawUp(int x, int y, Graphics g) {
		g.fillRect(x + 10, y, 5, 30);
		g.fillRect(x + 5, y + 5, 5, 5);
		g.fillRect(x, y + 10, 5, 5);
		g.fillRect(x + 15, y + 5, 5, 5);
		g.fillRect(x + 20, y + 10, 5, 5);
	}

	private static void drawRight(int x, int y, Graphics g) {
		g.fillRect(x, y + 10, 30, 5);
		g.fillRect(x + 20, y + 5, 5, 5);
		g.fillRect(x + 15, y, 5, 5);
		g.fillRect(x + 20, y + 15, 5, 5);
		g.fillRect(x + 15, y + 20, 5, 5);
	}

	private static void drawDown(int x, int y, Graphics g) {
		g.fillRect(x + 10, y, 5, 30);
		g.fillRect(x + 5, y + 20, 5, 5);
		g.fillRect(x, y + 15, 5, 5);
		g.fillRect(x + 15, y + 20, 5, 5);
		g.fillRect(x + 20, y + 15, 5, 5);
	}

	private static void drawLeft(int x, int y, Graphics g) {
		g.fillRect(x, y + 10, 30, 5);
		g.fillRect(x + 5, y + 5, 5, 5);
		g.fillRect(x + 10, y, 5, 5);
		g.fillRect(x + 5, y + 15, 5, 5);
		g.fillRect(x + 10, y + 20, 5, 5);
	}

	private static void drawComma(int x, int y, Graphics g) {
		g.fillRect(x, y + 25, 5, 10);
	}

	private static void drawPeriod(int x, int y, Graphics g) {
		g.fillRect(x, y + 25, 5, 5);
	}

	private static void drawSlash(int x, int y, Graphics g) {
		g.fillRect(x, y + 25, 5, 5);
		g.fillRect(x + 5, y + 20, 5, 5);
		g.fillRect(x + 10, y + 15, 5, 5);
		g.fillRect(x + 15, y + 10, 5, 5);
		g.fillRect(x + 20, y + 5, 5, 5);
		g.fillRect(x + 25, y, 5, 5);
	}

	private static void drawSemmicolen(int x, int y, Graphics g) {
		g.fillRect(x, y + 25, 5, 10);
		g.fillRect(x, y + 15, 5, 5);
	}

	private static void drawApostrophi(int x, int y, Graphics g) {
		g.fillRect(x, y, 5, 10);
	}

	private static void drawAccentmark(int x, int y, Graphics g) {
		g.fillRect(x, y, 5, 5);
		g.fillRect(x + 5, y + 5, 5, 5);
	}

	private static void drawBracket(int x, int y, Graphics g) {
		g.fillRect(x, y, 5, 30);
		g.fillRect(x + 5, y, 5, 5);
		g.fillRect(x + 5, y + 25, 5, 5);
	}

	private static void drawBackBracket(int x, int y, Graphics g) {
		g.fillRect(x + 5, y, 5, 30);
		g.fillRect(x, y, 5, 5);
		g.fillRect(x, y + 25, 5, 5);
	}

	private static void drawBackSlash(int x, int y, Graphics g) {
		g.fillRect(x, y, 5, 5);
		g.fillRect(x + 5, y + 5, 5, 5);
		g.fillRect(x + 10, y + 10, 5, 5);
		g.fillRect(x + 15, y + 15, 5, 5);
		g.fillRect(x + 20, y + 20, 5, 5);
		g.fillRect(x + 25, y + 25, 5, 5);
	}

	private static void drawDash(int x, int y, Graphics g) {
		g.fillRect(x, y + 10, 15, 5);
	}

	private static void drawEqualsign(int x, int y, Graphics g) {
		g.fillRect(x, y + 5, 20, 5);
		g.fillRect(x, y + 20, 20, 5);
	}

	/**
	 * converst storage to save data
	 * 
	 * @return string save data
	 */
	public static String getSaveData() {
		String save = "";
		for (Shapemon s : storage) {
			save += Shapemon.shapemonToSave(s) + "|";
		}

		return save;
	}

	/**
	 * laods from save data
	 * 
	 * @param save strign save data
	 */
	public static void loadSaveData(String save) {
		String[] data = save.split("\\|");
		for (int i = 0; i < storage.length; i++) {
			storage[i] = Shapemon.saveToShapemon(data[i]);
		}

	}

}
