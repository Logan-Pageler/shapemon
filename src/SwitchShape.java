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
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
public class SwitchShape extends JPanel{
	private static Battle b;
	private static Image check = (new ImageIcon("check.gif").getImage());
	private static Image check2 = (new ImageIcon("check2.gif").getImage());
	private static Image select1 =(new ImageIcon("select1.gif").getImage());
	private static Image select1pt2 =(new ImageIcon("select1pt2.gif").getImage());
	private static Image select7 =(new ImageIcon("select7.gif").getImage());
	private static Image select7pt2 =(new ImageIcon("select7pt2.gif").getImage());
	private static Image storage1 = (new ImageIcon("storage1.gif").getImage());
	private static Image storage2 = (new ImageIcon("storage2.gif").getImage());
	private static Image left = (new ImageIcon("left.gif").getImage());
	private static Image right = (new ImageIcon("right.gif").getImage());
	private static Image left2 = (new ImageIcon("left2.gif").getImage());
	private static Image right2 = (new ImageIcon("right2.gif").getImage());
	private static Image nyan = (new ImageIcon("NyanCat.gif").getImage());
	private static Image pacman = (new ImageIcon("Pacman.gif").getImage());
	private static Image star = (new ImageIcon("StarAnim.gif").getImage());
	private static Image circle = (new ImageIcon("Circle.gif").getImage());
	private static Image triangle = (new ImageIcon("Triangle.gif").getImage());
	private static Image square = (new ImageIcon("Square.gif").getImage());
	private static Image pentagon = (new ImageIcon("Pentagon.gif").getImage());
	private static Image hexagon = (new ImageIcon("Hexagon.gif").getImage());
	private static Image octagon = (new ImageIcon("Octagon.gif").getImage());
	private static Image blank = (new ImageIcon("blank.gif").getImage());
	private Player p = new Player(null);
	public static Shapemon[] storage = {};
	private static final Color c = new Color(200,200,200);
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
			boolean downPressed, boolean rightPressed, boolean leftPressed, boolean enterPressed)
	{
		if(!enterPressed)enterReleased = true;
		if(!upPressed)upReleased = true;
		if(!downPressed)downReleased = true;
		if(!leftPressed)leftReleased = true;
		if(!rightPressed)rightReleased = true;
		replaceNull( p);
		int menuPart = menu;
		g.setColor(c);
		g.fillRect(0,0,720,720);
		// a menu to make sure you want to switch
		if(menuPart == 5)
		{
			if(upPressed & upReleased)
			{
				upReleased = false;
				select = 1;
			}
			if(downPressed & downReleased)
			{
				downReleased = false;
				select = 2;
			}
			if(enterPressed && enterReleased)
			{
				enterReleased = false;
				if(select == 1)
				{
					menuPart = 6;
				}
				if(select == 2)
				{
					menuPart = 1;
					map.closeMenu();
					
				}
			}
			g.drawImage(select7,75,150,570,140,null);
			g.drawImage(select7,75,430,570,140,null);
			if(select == 1)
			{
				g.drawImage(select7pt2,75,150,570,140,null);
			}
			if(select == 2)
			{
				g.drawImage(select7pt2,75,430,570,140,null);
			}
			g.setColor(Color.BLACK);
			drawString("SWITCH",290,210,g);
			drawString("BACK",310,490,g);
		}
		else if(menuPart == 6)//draws a menu of your shapemon and allows you to select
		{
			storage = b.getStorage();
			
			//changes the shapemon pressed based on the currently selected shapemon
				if(upPressed && upReleased)
				{
					upReleased = false;
					if(selected == 4)
					{
						selected = 1;
					}
					else if(selected == 5)
					{
						selected = 2;
					}
					else if(selected == 6)
					{
						selected = 3;
					}
					else if(selected == 7)
					{
						selected = 4;
					}
				}
				if(downPressed && downReleased)
				{
					downReleased = false;
					if(selected == 1)
					{
						selected = 4;
					}
					else if(selected == 2)
					{
						selected = 5;
					}
					else if(selected == 3)
					{
						selected = 6;
					}
					else if(selected == 4)
					{
						selected = 7;
					}
					else if(selected == 5)
					{
						selected = 7;
					}
					else if(selected == 6)
					{
						selected = 7;
					}
				}
				if(rightPressed && rightReleased)
				{
					rightReleased = false;
					if(selected == 1)
					{
						selected = 2;
					}
					else if(selected == 2)
					{
						selected = 3;
					}
					else if(selected == 4)
					{
						selected = 5;
					}
					else if(selected == 5)
					{
						selected = 6;
					}
				}
				if(leftPressed && leftReleased)
				{
					leftReleased = false;
					if(selected == 2)
					{
						selected = 1;
					}
					else if(selected == 3)
					{
						selected = 2;
					}
					else if(selected == 5)
					{
						selected = 4;
					}
					else if(selected == 6)
					{
						selected = 5;
					}
				}
				// changes what is drawn based on what the selected button is
				if(enterPressed && enterReleased)
				{
					enterReleased = false;
					if(selected!=7)
					{
						oldShape = p.getShapemon(selected);
						shapeOld = selected;
						System.out.println("hi");
						menuPart = 7;
					}
					else menuPart = 5;
				}
				// draws the buttons
				g.drawImage(select1,75,75,140,140,null);
				g.drawImage(select1,290,75,140,140,null);
				g.drawImage(select1,505,75,140,140,null);
				g.drawImage(select1,75,290,140,140,null);
				g.drawImage(select1,290,290,140,140,null);
				g.drawImage(select1,505,290,140,140,null);
				g.drawImage(select7,75,505,570,140,null);
				// based on the selected shapes, draws the button yellow
				if(selected == 1)
				{
					g.drawImage(select1pt2,75,75,140,140,null);
				}
				else if(selected == 2)
				{
					g.drawImage(select1pt2,290,75,140,140,null);		
				}
				else if(selected == 3)
				{
					g.drawImage(select1pt2,505,75,140,140,null);
				}
				else if(selected == 4)
				{
					g.drawImage(select1pt2,75,290,140,140,null);
				}
				else if(selected == 5)
				{
					g.drawImage(select1pt2,290,290,140,140,null);
				}
				else if(selected == 6)
				{
					g.drawImage(select1pt2,505,290,140,140,null);
				}
				else if(selected == 7)
				{
					g.drawImage(select7pt2,75,505,570,140,null);
				}
				g.setColor(Color.black);
				drawString("BACK", 310, 560, g);
				
				Shapemon one = p.getShapemon(1);
				switch(one.getTypeOfShapemon()) {
				case 1:
					g.drawImage(circle, 95, 95, 100, 100, null);
					break;
				case 2:
					g.drawImage(pacman, 95, 95, 100, 100, null);
					break;
				case 3:
					g.drawImage(triangle, 95, 95, 100, 100, null);
					break;
				case 4:
					g.drawImage(square, 95, 95, 100, 100, null);
					break;
				case 5:
					g.drawImage(pentagon, 95, 95, 100, 100, null);
					break;
				case 6:
					g.drawImage(hexagon, 95, 95, 100, 100, null);
					break;
				case 8:
					g.drawImage(octagon, 95, 95, 100, 100, null);
					break;
				case 10:
					g.drawImage(star, 95, 95, 100, 100, null);
					break;
				case 69:
					g.drawImage(nyan, 95, 95, 100, 100, null);
					break;
				default:
					g.drawImage(blank, 95, 95, 100, 100, null);
					break;
				}
				Shapemon two = p.getShapemon(2);
				switch(two.getTypeOfShapemon()) {
				case 1:
					g.drawImage(circle, 310, 95, 100, 100, null);
					break;
				case 2:
					g.drawImage(pacman, 310, 95, 100, 100, null);
					break;
				case 3:
					g.drawImage(triangle, 310, 95, 100, 100, null);
					break;
				case 4:
					g.drawImage(square, 310, 95, 100, 100, null);
					break;
				case 5:
					g.drawImage(pentagon, 310, 95, 100, 100, null);
					break;
				case 6:
					g.drawImage(hexagon, 310, 95, 100, 100, null);
					break;
				case 8:
					g.drawImage(octagon, 310, 95, 100, 100, null);
					break;
				case 10:
					g.drawImage(star, 310, 95, 100, 100, null);
					break;
				case 69:
					g.drawImage(nyan, 310, 95, 100, 100, null);
					break;
				default:
					g.drawImage(blank, 310, 95, 100, 100, null);
					break;
				}
				Shapemon three = p.getShapemon(3);
				switch(three.getTypeOfShapemon()) {
				case 1:
					g.drawImage(circle, 525, 95, 100, 100, null);
					break;
				case 2:
					g.drawImage(pacman, 525, 95, 100, 100, null);
					break;
				case 3:
					g.drawImage(triangle, 525, 95, 100, 95, null);
					break;
				case 4:
					g.drawImage(square, 525, 95, 100, 100, null);
					break;
				case 5:
					g.drawImage(pentagon, 525, 95, 100, 100, null);
					break;
				case 6:
					g.drawImage(hexagon, 525, 95, 100, 100, null);
					break;
				case 8:
					g.drawImage(octagon, 525, 95, 100, 100, null);
					break;
				case 10:
					g.drawImage(star, 525, 95, 100, 100, null);
					break;
				case 69:
					g.drawImage(nyan, 525, 95, 100, 100, null);
					break;
				default:
					g.drawImage(blank, 525, 95, 100, 100, null);
					break;
				}
				Shapemon four = p.getShapemon(4);
				switch(four.getTypeOfShapemon()) {
				case 1:
					g.drawImage(circle, 95, 310, 100, 100, null);
					break;
				case 2:
					g.drawImage(pacman, 95, 310, 100, 100, null);
					break;
				case 3:
					g.drawImage(triangle, 95, 310, 100, 100, null);
					break;
				case 4:
					g.drawImage(square, 95, 310, 100, 100, null);
					break;
				case 5:
					g.drawImage(pentagon, 95, 310, 100, 100, null);
					break;
				case 6:
					g.drawImage(hexagon, 95, 310, 100, 100, null);
					break;
				case 8:
					g.drawImage(octagon, 95, 310, 100, 100, null);
					break;
				case 10:
					g.drawImage(star, 95, 310, 100, 100, null);
					break;
				case 69:
					g.drawImage(nyan, 95, 310, 100, 100, null);
					break;
				default:
					g.drawImage(blank, 95, 310, 100, 100, null);
					break;
				}
				Shapemon five = p.getShapemon(5);
				switch(five.getTypeOfShapemon()) {
				case 1:
					g.drawImage(circle, 310, 310, 100, 100, null);
					break;
				case 2:
					g.drawImage(pacman, 310, 310, 100, 100, null);
					break;
				case 3:
					g.drawImage(triangle, 310, 310, 100, 100, null);
					break;
				case 4:
					g.drawImage(square, 310, 310, 100, 100, null);
					break;
				case 5:
					g.drawImage(pentagon, 310, 310, 100, 100, null);
					break;
				case 6:
					g.drawImage(hexagon, 310, 310, 100, 100, null);
					break;
				case 8:
					g.drawImage(octagon, 310, 310, 100, 100, null);
					break;
				case 10:
					g.drawImage(star, 310, 310, 100, 100, null);
					break;
				case 69:
					g.drawImage(nyan, 310, 310, 100, 100, null);
					break;
				default:
					g.drawImage(blank, 310, 310, 100, 100, null);
					break;
				}
				Shapemon six = p.getShapemon(6);
				switch(six.getTypeOfShapemon()) {
				case 1:
					g.drawImage(circle, 525, 310, 100, 100, null);
					break;
				case 2:
					g.drawImage(pacman, 525, 310, 100, 100, null);
					break;
				case 3:
					g.drawImage(triangle, 525, 310, 100, 100, null);
					break;
				case 4:
					g.drawImage(square, 525, 310, 100, 100, null);
					break;
				case 5:
					g.drawImage(pentagon, 525, 310, 100, 100, null);
					break;
				case 6:
					g.drawImage(hexagon, 525, 310, 100, 100, null);
					break;
				case 8:
					g.drawImage(octagon, 525, 310, 100, 100, null);
					break;
				case 10:
					g.drawImage(star, 525, 310, 100, 100, null);
					break;
				case 69:
					g.drawImage(nyan, 525, 310, 100, 100, null);
					break;
				default:
					g.drawImage(blank, 525, 310, 100, 100, null);
					break;
				}
				if(one.getTypeOfShapemon() != 100) {
					drawString("LVL" + one.getLevel(),75,230,g);}
				 
				if(two.getTypeOfShapemon() != 100) {
					drawString("LVL" + two.getLevel(),290,230,g);}
					 
				if(three.getTypeOfShapemon() != 100) {
					drawString("LVL" + three.getLevel(),505,230,g);}
				 
				if(four.getTypeOfShapemon() != 100) {
					drawString("LVL" + four.getLevel(),75,445,g);}
				 
				if(five.getTypeOfShapemon() != 100) {
					drawString("LVL" + five.getLevel(),290,445,g);}
				 
				if(six.getTypeOfShapemon() != 100) {
					drawString("LVL" + six.getLevel(),505,445,g);}
				 
				select = 1;
		}
		// menuPart 7-14 draw the different shapemon in the storage
		else if(menuPart == 7)
		{
			g.setColor(c);
			g.fillRect(0,0,720,720);
			if(upPressed && upReleased)
			{
				upReleased = false;
				if(select == 5)
				{
					select = 1;
				}
				else if(select == 6)
				{
					select = 2;
				}
				else if(select == 7)
				{
					select = 3;
				}
				else if(select == 8)
				{
					select = 4;
				}
				else if(select == 9)
				{
					select = 5;
				}
				else if(select == 10)
				{
					select = 6;
				}
				else if(select == 11)
				{
					select = 7;
				}
				else if(select == 12)
				{
					select = 8;
				}
				else if(select == 13)
				{
					select = 9;
				}
				else if(select == 14)
				{
					select = 12;
				}
			}
			if(downPressed && downReleased)
			{
				downReleased = false;
				if(select == 1)
				{
					select = 5;
				}
				else if(select == 2)
				{
					select = 6;
				}
				else if(select == 3)
				{
					select = 7;
				}
				else if(select == 4)
				{
					select = 8;
				}
				else if(select == 5)
				{
					select = 9;
				}
				else if(select == 6)
				{
					select = 10;
				}
				else if(select == 7)
				{
					select = 11;
				}
				else if(select == 8)
				{
					select = 12;
				}
				else if(select == 9)
				{
					select = 13;
				}
				else if(select == 12)
				{
					select = 14;
				}
			}
			if(rightPressed && rightReleased)
			{
				rightReleased = false;
				if(select == 1)
				{
					select = 2;
				}
				else if(select == 2)
				{
					select = 3;
				}
				else if(select == 3)
				{
					select = 4;
				}
				else if(select == 5)
				{
					select = 6;
				}
				else if(select == 6)
				{
					select = 7;
				}
				else if(select == 7)
				{
					select = 8;
				}
				else if(select == 9)
				{
					select = 10;
				}
				else if(select == 10)
				{
					select = 11;
				}
				else if(select == 11)
				{
					select = 12;
				}
				else if(select == 13)
				{
					select = 14;
				}
			}
			if(leftPressed && leftReleased)
			{
				leftReleased = false;
				if(select == 2)
				{
					select = 1;
				}
				else if(select == 3)
				{
					select = 2;
				}
				else if(select == 4)
				{
					select = 3;
				}
				else if(select == 6)
				{
					select = 5;
				}
				else if(select == 7)
				{
					select = 6;
				}
				else if(select == 8)
				{
					select = 7;
				}
				else if(select == 10)
				{
					select = 9;
				}
				else if(select == 11)
				{
					select = 10;
				}
				else if(select == 12)
				{
					select = 11;
				}
				else if(select == 14)
				{
					select = 13;
				}
			}
			if(enterPressed && enterReleased)
			{
				enterReleased = false;
				if(select == 14)
				{
					menuPart = 8;
					select = 1;
				}
				else if(select == 13)
				{
					menuPart = 6;
					select = 1;
				}
				else
				{
					if(select-1<storage.length)
					{
						newShape = storage[select-1];
						shapeNew = select -1;
					}
					menuPart = 15;
					select = 2;
				}
			}
			
			g.drawImage(left,10,605,45,45,null);
			g.drawImage(right,655,605,45,45,null);
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
	
			if(select == 1)
			{
				g.drawImage(storage2, 60, 60, 105, 105, null);
			}
			else if(select == 2)
			{
				g.drawImage(storage2, 225, 60, 105, 105, null);
			}
			else if(select == 3)
			{
				g.drawImage(storage2, 390, 60, 105, 105, null);
			}
			else if(select == 4)
			{
				g.drawImage(storage2, 555, 60, 105, 105, null);
			}
			else if(select == 5)
			{
				g.drawImage(storage2, 60, 225, 105, 105, null);
			}
			else if(select == 6)
			{
				g.drawImage(storage2, 225, 225, 105, 105, null);
			}
			else if(select == 7)
			{
				g.drawImage(storage2, 390, 225, 105, 105, null);
			}
			else if(select == 8)
			{
				g.drawImage(storage2, 555, 225, 105, 105, null);
			}
			else if(select == 9)
			{
				g.drawImage(storage2, 60, 390, 105, 105, null);
			}
			else if(select == 10)
			{
				g.drawImage(storage2, 225, 390, 105, 105, null);
			}
			else if(select == 11)
			{
				g.drawImage(storage2, 390, 390, 105, 105, null);
			}
			else if(select == 12)
			{
				g.drawImage(storage2, 555, 390, 105, 105, null);
			}
			else if(select == 13)
			{
				g.drawImage(left2, 10, 605, 45, 45, null);
			}
			else if(select == 14)
			{
				g.drawImage(right2, 655, 605, 45, 45, null);
			}
			//Only 12 shapemon are drawn per page so it draws the shapemon that are supposed to be drawn
			for(int i = 0; i<12;i++)
			{
				int x = (i%4)*165 + 80;// calculates the x and y image of the shapemon based on the counter value
				int y = (int)(i/4)*165 + 80;
				Shapemon q = null;
				if(i<storage.length)//checks to see if there are more shapemon
				{	
					if(storage[i]!=null)// sees if it is empty
					{
						q = storage[i];
					}
				}
				else
				{
					 q = new ShapemonBlank(0,0,0);
				}
				switch(q.getTypeOfShapemon()) 
				{
				case 1:
					g.drawImage(circle, x, y, 65, 65, null);
					break;
				case 2:
					g.drawImage(pacman, x, y, 65, 65, null);
					break;
				case 3:
					g.drawImage(triangle, x, y, 65, 65, null);
					break;
				case 4:
					g.drawImage(square, x, y, 65, 65, null);
					break;
				case 5:
					g.drawImage(pentagon, x, y, 65, 65, null);
					break;
				case 6:
					g.drawImage(hexagon, x, y, 65, 65, null);
					break;
				case 8:
					g.drawImage(octagon, x, y, 65, 65, null);
					break;
				case 10:
					g.drawImage(star, x, y, 65, 65, null);
					break;
				case 69:
					g.drawImage(nyan, x, y, 65, 65, null);
					break;
				default:
					g.drawImage(blank,x,y,65,65,null);
					break;
				}
				g.setColor(Color.black);
				if(q.getTypeOfShapemon() != 100)
				{
					drawString(q.getLevel() + "",x,y+100,g);
				}
			}
		}
		else if(menuPart == 8)
		{
			g.setColor(c);
			g.fillRect(0,0,720,720);
			if(upPressed && upReleased)
			{
				upReleased = false;
				if(select == 5)
				{
					select = 1;
				}
				else if(select == 6)
				{
					select = 2;
				}
				else if(select == 7)
				{
					select = 3;
				}
				else if(select == 8)
				{
					select = 4;
				}
				else if(select == 9)
				{
					select = 5;
				}
				else if(select == 10)
				{
					select = 6;
				}
				else if(select == 11)
				{
					select = 7;
				}
				else if(select == 12)
				{
					select = 8;
				}
				else if(select == 13)
				{
					select = 9;
				}
				else if(select == 14)
				{
					select = 12;
				}
			}
			if(downPressed && downReleased)
			{
				downReleased = false;
				if(select == 1)
				{
					select = 5;
				}
				else if(select == 2)
				{
					select = 6;
				}
				else if(select == 3)
				{
					select = 7;
				}
				else if(select == 4)
				{
					select = 8;
				}
				else if(select == 5)
				{
					select = 9;
				}
				else if(select == 6)
				{
					select = 10;
				}
				else if(select == 7)
				{
					select = 11;
				}
				else if(select == 8)
				{
					select = 12;
				}
				else if(select == 9)
				{
					select = 13;
				}
				else if(select == 12)
				{
					select = 14;
				}
			}
			if(rightPressed && rightReleased)
			{
				rightReleased = false;
				if(select == 1)
				{
					select = 2;
				}
				else if(select == 2)
				{
					select = 3;
				}
				else if(select == 3)
				{
					select = 4;
				}
				else if(select == 5)
				{
					select = 6;
				}
				else if(select == 6)
				{
					select = 7;
				}
				else if(select == 7)
				{
					select = 8;
				}
				else if(select == 9)
				{
					select = 10;
				}
				else if(select == 10)
				{
					select = 11;
				}
				else if(select == 11)
				{
					select = 12;
				}
				else if(select == 13)
				{
					select = 14;
				}
			}
			if(leftPressed && leftReleased)
			{
				leftReleased = false;
				if(select == 2)
				{
					select = 1;
				}
				else if(select == 3)
				{
					select = 2;
				}
				else if(select == 4)
				{
					select = 3;
				}
				else if(select == 6)
				{
					select = 5;
				}
				else if(select == 7)
				{
					select = 6;
				}
				else if(select == 8)
				{
					select = 7;
				}
				else if(select == 10)
				{
					select = 9;
				}
				else if(select == 11)
				{
					select = 10;
				}
				else if(select == 12)
				{
					select = 11;
				}
				else if(select == 14)
				{
					select = 13;
				}
			}
			if(enterPressed && enterReleased)
			{
				enterReleased = false;
				if(select == 14)
				{
					menuPart = 9;
					select = 1;
				}
				else if(select == 13)
				{
					menuPart = 7;
					select = 1;
				}
				else
				{
					if(select+11<storage.length)
					{
						newShape = storage[select+11];
						shapeNew = select + 11;
					}
					menuPart = 15;
					select = 2;
				}
			}
			
			g.drawImage(left,10,605,45,45,null);
			g.drawImage(right,655,605,45,45,null);
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
	
			if(select == 1)
			{
				g.drawImage(storage2, 60, 60, 105, 105, null);
			}
			else if(select == 2)
			{
				g.drawImage(storage2, 225, 60, 105, 105, null);
			}
			else if(select == 3)
			{
				g.drawImage(storage2, 390, 60, 105, 105, null);
			}
			else if(select == 4)
			{
				g.drawImage(storage2, 555, 60, 105, 105, null);
			}
			else if(select == 5)
			{
				g.drawImage(storage2, 60, 225, 105, 105, null);
			}
			else if(select == 6)
			{
				g.drawImage(storage2, 225, 225, 105, 105, null);
			}
			else if(select == 7)
			{
				g.drawImage(storage2, 390, 225, 105, 105, null);
			}
			else if(select == 8)
			{
				g.drawImage(storage2, 555, 225, 105, 105, null);
			}
			else if(select == 9)
			{
				g.drawImage(storage2, 60, 390, 105, 105, null);
			}
			else if(select == 10)
			{
				g.drawImage(storage2, 225, 390, 105, 105, null);
			}
			else if(select == 11)
			{
				g.drawImage(storage2, 390, 390, 105, 105, null);
			}
			else if(select == 12)
			{
				g.drawImage(storage2, 555, 390, 105, 105, null);
			}
			else if(select == 13)
			{
				g.drawImage(left2, 10, 605, 45, 45, null);
			}
			else if(select == 14)
			{
				g.drawImage(right2, 655, 605, 45, 45, null);
			}
			
			for(int i = 12; i<24;i++)
			{
				int z = i - 12;
				int x = (z%4)*165 + 80;
				int y = (int)(z/4)*165 + 80;
				Shapemon q = null;
				if(i<storage.length)
				{
					if(storage[i]!=null)
					{
						q = storage[i];
					}
				}
				else
				{
					 q = new ShapemonBlank(0,0,0);
				}
				switch(q.getTypeOfShapemon()) 
				{
				case 1:
					g.drawImage(circle, x, y, 65, 65, null);
					break;
				case 2:
					g.drawImage(pacman, x, y, 65, 65, null);
					break;
				case 3:
					g.drawImage(triangle, x, y, 65, 65, null);
					break;
				case 4:
					g.drawImage(square, x, y, 65, 65, null);
					break;
				case 5:
					g.drawImage(pentagon, x, y, 65, 65, null);
					break;
				case 6:
					g.drawImage(hexagon, x, y, 65, 65, null);
					break;
				case 8:
					g.drawImage(octagon, x, y, 65, 65, null);
					break;
				case 10:
					g.drawImage(star, x, y, 65, 65, null);
					break;
				case 69:
					g.drawImage(nyan, x, y, 65, 65, null);
					break;
				default:
					g.drawImage(blank,x,y,65,65,null);
					break;
				}
				g.setColor(Color.black);
				if(q.getTypeOfShapemon() != 100)
				{
					drawString(q.getLevel() + "",x,y+100,g);
				} 
			}
		}
		else if(menuPart == 9)
		{
			g.setColor(c);
			g.fillRect(0,0,720,720);
			if(upPressed && upReleased)
			{
				upReleased = false;
				if(select == 5)
				{
					select = 1;
				}
				else if(select == 6)
				{
					select = 2;
				}
				else if(select == 7)
				{
					select = 3;
				}
				else if(select == 8)
				{
					select = 4;
				}
				else if(select == 9)
				{
					select = 5;
				}
				else if(select == 10)
				{
					select = 6;
				}
				else if(select == 11)
				{
					select = 7;
				}
				else if(select == 12)
				{
					select = 8;
				}
				else if(select == 13)
				{
					select = 9;
				}
				else if(select == 14)
				{
					select = 12;
				}
			}
			if(downPressed && downReleased)
			{
				downReleased = false;
				if(select == 1)
				{
					select = 5;
				}
				else if(select == 2)
				{
					select = 6;
				}
				else if(select == 3)
				{
					select = 7;
				}
				else if(select == 4)
				{
					select = 8;
				}
				else if(select == 5)
				{
					select = 9;
				}
				else if(select == 6)
				{
					select = 10;
				}
				else if(select == 7)
				{
					select = 11;
				}
				else if(select == 8)
				{
					select = 12;
				}
				else if(select == 9)
				{
					select = 13;
				}
				else if(select == 12)
				{
					select = 14;
				}
			}
			if(rightPressed && rightReleased)
			{
				rightReleased = false;
				if(select == 1)
				{
					select = 2;
				}
				else if(select == 2)
				{
					select = 3;
				}
				else if(select == 3)
				{
					select = 4;
				}
				else if(select == 5)
				{
					select = 6;
				}
				else if(select == 6)
				{
					select = 7;
				}
				else if(select == 7)
				{
					select = 8;
				}
				else if(select == 9)
				{
					select = 10;
				}
				else if(select == 10)
				{
					select = 11;
				}
				else if(select == 11)
				{
					select = 12;
				}
				else if(select == 13)
				{
					select = 14;
				}
			}
			if(leftPressed && leftReleased)
			{
				leftReleased = false;
				if(select == 2)
				{
					select = 1;
				}
				else if(select == 3)
				{
					select = 2;
				}
				else if(select == 4)
				{
					select = 3;
				}
				else if(select == 6)
				{
					select = 5;
				}
				else if(select == 7)
				{
					select = 6;
				}
				else if(select == 8)
				{
					select = 7;
				}
				else if(select == 10)
				{
					select = 9;
				}
				else if(select == 11)
				{
					select = 10;
				}
				else if(select == 12)
				{
					select = 11;
				}
				else if(select == 14)
				{
					select = 13;
				}
			}
			if(enterPressed && enterReleased)
			{
				enterReleased = false;
				if(select == 14)
				{
					menuPart = 10;
					select = 1;
				}
				else if(select == 13)
				{
					menuPart = 8;
					select = 1;
				}
				else
				{
					if(select+23<storage.length)
					{
						newShape = storage[select+23];
						shapeNew = select + 23;
					}
					menuPart = 15;
					select = 2;
				}
			}
			
			g.drawImage(left,10,605,45,45,null);
			g.drawImage(right,655,605,45,45,null);
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
	
			if(select == 1)
			{
				g.drawImage(storage2, 60, 60, 105, 105, null);
			}
			else if(select == 2)
			{
				g.drawImage(storage2, 225, 60, 105, 105, null);
			}
			else if(select == 3)
			{
				g.drawImage(storage2, 390, 60, 105, 105, null);
			}
			else if(select == 4)
			{
				g.drawImage(storage2, 555, 60, 105, 105, null);
			}
			else if(select == 5)
			{
				g.drawImage(storage2, 60, 225, 105, 105, null);
			}
			else if(select == 6)
			{
				g.drawImage(storage2, 225, 225, 105, 105, null);
			}
			else if(select == 7)
			{
				g.drawImage(storage2, 390, 225, 105, 105, null);
			}
			else if(select == 8)
			{
				g.drawImage(storage2, 555, 225, 105, 105, null);
			}
			else if(select == 9)
			{
				g.drawImage(storage2, 60, 390, 105, 105, null);
			}
			else if(select == 10)
			{
				g.drawImage(storage2, 225, 390, 105, 105, null);
			}
			else if(select == 11)
			{
				g.drawImage(storage2, 390, 390, 105, 105, null);
			}
			else if(select == 12)
			{
				g.drawImage(storage2, 555, 390, 105, 105, null);
			}
			else if(select == 13)
			{
				g.drawImage(left2, 10, 605, 45, 45, null);
			}
			else if(select == 14)
			{
				g.drawImage(right2, 655, 605, 45, 45, null);
			}
			
			for(int i = 24; i<36;i++)
			{
				int z = i - 24;
				int x = (z%4)*165 + 80;
				int y = (int)(z/4)*165 + 80;
				Shapemon q = null;
				if(i<storage.length)
				{
					if(storage[i]!=null)
					{
						q = storage[i];
					
					}
				}
				else
				{
					 q = new ShapemonBlank(0,0,0);
				}
				switch(q.getTypeOfShapemon()) 
				{
				case 1:
					g.drawImage(circle, x, y, 65, 65, null);
					break;
				case 2:
					g.drawImage(pacman, x, y, 65, 65, null);
					break;
				case 3:
					g.drawImage(triangle, x, y, 65, 65, null);
					break;
				case 4:
					g.drawImage(square, x, y, 65, 65, null);
					break;
				case 5:
					g.drawImage(pentagon, x, y, 65, 65, null);
					break;
				case 6:
					g.drawImage(hexagon, x, y, 65, 65, null);
					break;
				case 8:
					g.drawImage(octagon, x, y, 65, 65, null);
					break;
				case 10:
					g.drawImage(star, x, y, 65, 65, null);
					break;
				case 69:
					g.drawImage(nyan, x, y, 65, 65, null);
					break;
				default:
					g.drawImage(blank,x,y,65,65,null);
					break;
				}
				g.setColor(Color.black);
				if(q.getTypeOfShapemon() != 100)
				{
					drawString(q.getLevel() + "",x,y+100,g);
				}
				 
			}
		}
		else if(menuPart == 10)
		{
			g.setColor(c);
			g.fillRect(0,0,720,720);
			if(upPressed && upReleased)
			{
				upReleased = false;
				if(select == 5)
				{
					select = 1;
				}
				else if(select == 6)
				{
					select = 2;
				}
				else if(select == 7)
				{
					select = 3;
				}
				else if(select == 8)
				{
					select = 4;
				}
				else if(select == 9)
				{
					select = 5;
				}
				else if(select == 10)
				{
					select = 6;
				}
				else if(select == 11)
				{
					select = 7;
				}
				else if(select == 12)
				{
					select = 8;
				}
				else if(select == 13)
				{
					select = 9;
				}
				else if(select == 14)
				{
					select = 12;
				}
			}
			if(downPressed && downReleased)
			{
				downReleased = false;
				if(select == 1)
				{
					select = 5;
				}
				else if(select == 2)
				{
					select = 6;
				}
				else if(select == 3)
				{
					select = 7;
				}
				else if(select == 4)
				{
					select = 8;
				}
				else if(select == 5)
				{
					select = 9;
				}
				else if(select == 6)
				{
					select = 10;
				}
				else if(select == 7)
				{
					select = 11;
				}
				else if(select == 8)
				{
					select = 12;
				}
				else if(select == 9)
				{
					select = 13;
				}
				else if(select == 12)
				{
					select = 14;
				}
			}
			if(rightPressed && rightReleased)
			{
				rightReleased = false;
				if(select == 1)
				{
					select = 2;
				}
				else if(select == 2)
				{
					select = 3;
				}
				else if(select == 3)
				{
					select = 4;
				}
				else if(select == 5)
				{
					select = 6;
				}
				else if(select == 6)
				{
					select = 7;
				}
				else if(select == 7)
				{
					select = 8;
				}
				else if(select == 9)
				{
					select = 10;
				}
				else if(select == 10)
				{
					select = 11;
				}
				else if(select == 11)
				{
					select = 12;
				}
				else if(select == 13)
				{
					select = 14;
				}
			}
			if(leftPressed && leftReleased)
			{
				leftReleased = false;
				if(select == 2)
				{
					select = 1;
				}
				else if(select == 3)
				{
					select = 2;
				}
				else if(select == 4)
				{
					select = 3;
				}
				else if(select == 6)
				{
					select = 5;
				}
				else if(select == 7)
				{
					select = 6;
				}
				else if(select == 8)
				{
					select = 7;
				}
				else if(select == 10)
				{
					select = 9;
				}
				else if(select == 11)
				{
					select = 10;
				}
				else if(select == 12)
				{
					select = 11;
				}
				else if(select == 14)
				{
					select = 13;
				}
			}
			if(enterPressed && enterReleased)
			{
				enterReleased = false;
				if(select == 14)
				{
					menuPart = 11;
					select = 1;
				}
				else if(select == 13)
				{
					menuPart = 9;
					select = 1;
				}
				else
				{
					if(select+35<storage.length)
					{
						newShape = storage[select+35];
						shapeNew = select + 35;
					}
					menuPart = 15;
					select = 2;
				}
			}
			
			g.drawImage(left,10,605,45,45,null);
			g.drawImage(right,655,605,45,45,null);
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
	
			if(select == 1)
			{
				g.drawImage(storage2, 60, 60, 105, 105, null);
			}
			else if(select == 2)
			{
				g.drawImage(storage2, 225, 60, 105, 105, null);
			}
			else if(select == 3)
			{
				g.drawImage(storage2, 390, 60, 105, 105, null);
			}
			else if(select == 4)
			{
				g.drawImage(storage2, 555, 60, 105, 105, null);
			}
			else if(select == 5)
			{
				g.drawImage(storage2, 60, 225, 105, 105, null);
			}
			else if(select == 6)
			{
				g.drawImage(storage2, 225, 225, 105, 105, null);
			}
			else if(select == 7)
			{
				g.drawImage(storage2, 390, 225, 105, 105, null);
			}
			else if(select == 8)
			{
				g.drawImage(storage2, 555, 225, 105, 105, null);
			}
			else if(select == 9)
			{
				g.drawImage(storage2, 60, 390, 105, 105, null);
			}
			else if(select == 10)
			{
				g.drawImage(storage2, 225, 390, 105, 105, null);
			}
			else if(select == 11)
			{
				g.drawImage(storage2, 390, 390, 105, 105, null);
			}
			else if(select == 12)
			{
				g.drawImage(storage2, 555, 390, 105, 105, null);
			}
			else if(select == 13)
			{
				g.drawImage(left2, 10, 605, 45, 45, null);
			}
			else if(select == 14)
			{
				g.drawImage(right2, 655, 605, 45, 45, null);
			}
			
			for(int i = 36; i<48;i++)
			{
				int z = i - 36;
				int x = (z%4)*165 + 80;
				int y = (int)(z/4)*165 + 80;
				Shapemon q = null;
				if(i<storage.length)
				{
					if(storage[i]!=null) 
					{
						q = storage[i];
					}
				}
				else
				{
					 q = new ShapemonBlank(0,0,0);
				}
				switch(q.getTypeOfShapemon()) {
				case 1:
					g.drawImage(circle, x, y, 65, 65, null);
					break;
				case 2:
					g.drawImage(pacman, x, y, 65, 65, null);
					break;
				case 3:
					g.drawImage(triangle, x, y, 65, 65, null);
					break;
				case 4:
					g.drawImage(square, x, y, 65, 65, null);
					break;
				case 5:
					g.drawImage(pentagon, x, y, 65, 65, null);
					break;
				case 6:
					g.drawImage(hexagon, x, y, 65, 65, null);
					break;
				case 8:
					g.drawImage(octagon, x, y, 65, 65, null);
					break;
				case 10:
					g.drawImage(star, x, y, 65, 65, null);
					break;
				case 69:
					g.drawImage(nyan, x, y, 65, 65, null);
					break;
				default:
					g.drawImage(blank,x,y,65,65,null);
					break;
				}
				g.setColor(Color.black);
				if(q.getTypeOfShapemon() != 100) 
				{
					drawString(q.getLevel() + "",x,y+100,g);
				}
			}
		}
		else if(menuPart == 11)
		{
			g.setColor(c);
			g.fillRect(0,0,720,720);
			if(upPressed && upReleased)
			{
				upReleased = false;
				if(select == 5)
				{
					select = 1;
				}
				else if(select == 6)
				{
					select = 2;
				}
				else if(select == 7)
				{
					select = 3;
				}
				else if(select == 8)
				{
					select = 4;
				}
				else if(select == 9)
				{
					select = 5;
				}
				else if(select == 10)
				{
					select = 6;
				}
				else if(select == 11)
				{
					select = 7;
				}
				else if(select == 12)
				{
					select = 8;
				}
				else if(select == 13)
				{
					select = 9;
				}
				else if(select == 14)
				{
					select = 12;
				}
			}
			if(downPressed && downReleased)
			{
				downReleased = false;
				if(select == 1)
				{
					select = 5;
				}
				else if(select == 2)
				{
					select = 6;
				}
				else if(select == 3)
				{
					select = 7;
				}
				else if(select == 4)
				{
					select = 8;
				}
				else if(select == 5)
				{
					select = 9;
				}
				else if(select == 6)
				{
					select = 10;
				}
				else if(select == 7)
				{
					select = 11;
				}
				else if(select == 8)
				{
					select = 12;
				}
				else if(select == 9)
				{
					select = 13;
				}
				else if(select == 12)
				{
					select = 14;
				}
			}
			if(rightPressed && rightReleased)
			{
				rightReleased = false;
				if(select == 1)
				{
					select = 2;
				}
				else if(select == 2)
				{
					select = 3;
				}
				else if(select == 3)
				{
					select = 4;
				}
				else if(select == 5)
				{
					select = 6;
				}
				else if(select == 6)
				{
					select = 7;
				}
				else if(select == 7)
				{
					select = 8;
				}
				else if(select == 9)
				{
					select = 10;
				}
				else if(select == 10)
				{
					select = 11;
				}
				else if(select == 11)
				{
					select = 12;
				}
				else if(select == 13)
				{
					select = 14;
				}
			}
			if(leftPressed && leftReleased)
			{
				leftReleased = false;
				if(select == 2)
				{
					select = 1;
				}
				else if(select == 3)
				{
					select = 2;
				}
				else if(select == 4)
				{
					select = 3;
				}
				else if(select == 6)
				{
					select = 5;
				}
				else if(select == 7)
				{
					select = 6;
				}
				else if(select == 8)
				{
					select = 7;
				}
				else if(select == 10)
				{
					select = 9;
				}
				else if(select == 11)
				{
					select = 10;
				}
				else if(select == 12)
				{
					select = 11;
				}
				else if(select == 14)
				{
					select = 13;
				}
			}
			if(enterPressed && enterReleased)
			{
				enterReleased = false;
				if(select == 14)
				{
					menuPart = 12;
					select = 1;
				}
				else if(select == 13)
				{
					menuPart = 10;
					select = 1;
				}
				else
				{
					if(select+47<storage.length)
					{
						newShape = storage[select+47];
						shapeNew = select + 47;
					}
					menuPart = 15;
					select = 2;
				}
			}
			
			g.drawImage(left,10,605,45,45,null);
			g.drawImage(right,655,605,45,45,null);
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
	
			if(select == 1)
			{
				g.drawImage(storage2, 60, 60, 105, 105, null);
			}
			else if(select == 2)
			{
				g.drawImage(storage2, 225, 60, 105, 105, null);
			}
			else if(select == 3)
			{
				g.drawImage(storage2, 390, 60, 105, 105, null);
			}
			else if(select == 4)
			{
				g.drawImage(storage2, 555, 60, 105, 105, null);
			}
			else if(select == 5)
			{
				g.drawImage(storage2, 60, 225, 105, 105, null);
			}
			else if(select == 6)
			{
				g.drawImage(storage2, 225, 225, 105, 105, null);
			}
			else if(select == 7)
			{
				g.drawImage(storage2, 390, 225, 105, 105, null);
			}
			else if(select == 8)
			{
				g.drawImage(storage2, 555, 225, 105, 105, null);
			}
			else if(select == 9)
			{
				g.drawImage(storage2, 60, 390, 105, 105, null);
			}
			else if(select == 10)
			{
				g.drawImage(storage2, 225, 390, 105, 105, null);
			}
			else if(select == 11)
			{
				g.drawImage(storage2, 390, 390, 105, 105, null);
			}
			else if(select == 12)
			{
				g.drawImage(storage2, 555, 390, 105, 105, null);
			}
			else if(select == 13)
			{
				g.drawImage(left2, 10, 605, 45, 45, null);
			}
			else if(select == 14)
			{
				g.drawImage(right2, 655, 605, 45, 45, null);
			}
			
			for(int i = 48; i<60;i++)
			{
				int z = i - 48;
				int x = (z%4)*165 + 80;
				int y = (int)(z/4)*165 + 80;
				Shapemon q = null;
				if(i<storage.length)
				{
					if(storage[i]!=null)
					{
						q = storage[i];
					}
				}
				else
				{
					 q = new ShapemonBlank(0,0,0);
				}
				switch(q.getTypeOfShapemon()) 
				{
				case 1:
					g.drawImage(circle, x, y, 65, 65, null);
					break;
				case 2:
					g.drawImage(pacman, x, y, 65, 65, null);
					break;
				case 3:
					g.drawImage(triangle, x, y, 65, 65, null);
					break;
				case 4:
					g.drawImage(square, x, y, 65, 65, null);
					break;
				case 5:
					g.drawImage(pentagon, x, y, 65, 65, null);
					break;
				case 6:
					g.drawImage(hexagon, x, y, 65, 65, null);
					break;
				case 8:
					g.drawImage(octagon, x, y, 65, 65, null);
					break;
				case 10:
					g.drawImage(star, x, y, 65, 65, null);
					break;
				case 69:
					g.drawImage(nyan, x, y, 65, 65, null);
					break;
				default:
					g.drawImage(blank,x,y,65,65,null);
					break;
				}
				g.setColor(Color.black);
				if(q.getTypeOfShapemon() != 100)
				{
					drawString(q.getLevel() + "",x,y+100,g);
				} 
			}
		}
		else if(menuPart == 12)
		{
			g.setColor(c);
			g.fillRect(0,0,720,720);
			if(upPressed && upReleased)
			{
				upReleased = false;
				if(select == 5)
				{
					select = 1;
				}
				else if(select == 6)
				{
					select = 2;
				}
				else if(select == 7)
				{
					select = 3;
				}
				else if(select == 8)
				{
					select = 4;
				}
				else if(select == 9)
				{
					select = 5;
				}
				else if(select == 10)
				{
					select = 6;
				}
				else if(select == 11)
				{
					select = 7;
				}
				else if(select == 12)
				{
					select = 8;
				}
				else if(select == 13)
				{
					select = 9;
				}
				else if(select == 14)
				{
					select = 12;
				}
			}
			if(downPressed && downReleased)
			{
				downReleased = false;
				if(select == 1)
				{
					select = 5;
				}
				else if(select == 2)
				{
					select = 6;
				}
				else if(select == 3)
				{
					select = 7;
				}
				else if(select == 4)
				{
					select = 8;
				}
				else if(select == 5)
				{
					select = 9;
				}
				else if(select == 6)
				{
					select = 10;
				}
				else if(select == 7)
				{
					select = 11;
				}
				else if(select == 8)
				{
					select = 12;
				}
				else if(select == 9)
				{
					select = 13;
				}
				else if(select == 12)
				{
					select = 14;
				}
			}
			if(rightPressed && rightReleased)
			{
				rightReleased = false;
				if(select == 1)
				{
					select = 2;
				}
				else if(select == 2)
				{
					select = 3;
				}
				else if(select == 3)
				{
					select = 4;
				}
				else if(select == 5)
				{
					select = 6;
				}
				else if(select == 6)
				{
					select = 7;
				}
				else if(select == 7)
				{
					select = 8;
				}
				else if(select == 9)
				{
					select = 10;
				}
				else if(select == 10)
				{
					select = 11;
				}
				else if(select == 11)
				{
					select = 12;
				}
				else if(select == 13)
				{
					select = 14;
				}
			}
			if(leftPressed && leftReleased)
			{
				leftReleased = false;
				if(select == 2)
				{
					select = 1;
				}
				else if(select == 3)
				{
					select = 2;
				}
				else if(select == 4)
				{
					select = 3;
				}
				else if(select == 6)
				{
					select = 5;
				}
				else if(select == 7)
				{
					select = 6;
				}
				else if(select == 8)
				{
					select = 7;
				}
				else if(select == 10)
				{
					select = 9;
				}
				else if(select == 11)
				{
					select = 10;
				}
				else if(select == 12)
				{
					select = 11;
				}
				else if(select == 14)
				{
					select = 13;
				}
			}
			if(enterPressed && enterReleased)
			{
				enterReleased = false;
				if(select == 14)
				{
					menuPart = 13;
					select = 1;
				}
				else if(select == 13)
				{
					menuPart = 11;
					select = 1;
				}
				else
				{
					if(select+59<storage.length)
					{
						newShape = storage[select+59];
						shapeNew = select + 59;
					}
					menuPart = 15;
					select = 2;
				}
			}
			
			g.drawImage(left,10,605,45,45,null);
			g.drawImage(right,655,605,45,45,null);
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
	
			if(select == 1)
			{
				g.drawImage(storage2, 60, 60, 105, 105, null);
			}
			else if(select == 2)
			{
				g.drawImage(storage2, 225, 60, 105, 105, null);
			}
			else if(select == 3)
			{
				g.drawImage(storage2, 390, 60, 105, 105, null);
			}
			else if(select == 4)
			{
				g.drawImage(storage2, 555, 60, 105, 105, null);
			}
			else if(select == 5)
			{
				g.drawImage(storage2, 60, 225, 105, 105, null);
			}
			else if(select == 6)
			{
				g.drawImage(storage2, 225, 225, 105, 105, null);
			}
			else if(select == 7)
			{
				g.drawImage(storage2, 390, 225, 105, 105, null);
			}
			else if(select == 8)
			{
				g.drawImage(storage2, 555, 225, 105, 105, null);
			}
			else if(select == 9)
			{
				g.drawImage(storage2, 60, 390, 105, 105, null);
			}
			else if(select == 10)
			{
				g.drawImage(storage2, 225, 390, 105, 105, null);
			}
			else if(select == 11)
			{
				g.drawImage(storage2, 390, 390, 105, 105, null);
			}
			else if(select == 12)
			{
				g.drawImage(storage2, 555, 390, 105, 105, null);
			}
			else if(select == 13)
			{
				g.drawImage(left2, 10, 605, 45, 45, null);
			}
			else if(select == 14)
			{
				g.drawImage(right2, 655, 605, 45, 45, null);
			}
			
			for(int i = 60; i<72;i++)
			{
				int z = i - 60;
				int x = (z%4)*165 + 80;
				int y = (int)(z/4)*165 + 80;
				Shapemon q = null;
				if(i<storage.length)
				{	
					if(storage[i]!=null)
					{
						q = storage[i];
					}
				}
				else
				{
					 q = new ShapemonBlank(0,0,0);
				}
				switch(q.getTypeOfShapemon()) 
				{
				case 1:
					g.drawImage(circle, x, y, 65, 65, null);
					break;
				case 2:
					g.drawImage(pacman, x, y, 65, 65, null);
					break;
				case 3:
					g.drawImage(triangle, x, y, 65, 65, null);
					break;
				case 4:
					g.drawImage(square, x, y, 65, 65, null);
					break;
				case 5:
					g.drawImage(pentagon, x, y, 65, 65, null);
					break;
				case 6:
					g.drawImage(hexagon, x, y, 65, 65, null);
					break;
				case 8:
					g.drawImage(octagon, x, y, 65, 65, null);
					break;
				case 10:
					g.drawImage(star, x, y, 65, 65, null);
					break;
				case 69:
					g.drawImage(nyan, x, y, 65, 65, null);
					break;
				default:
					g.drawImage(blank,x,y,65,65,null);
					break;
				}
				g.setColor(Color.black);
				if(q.getTypeOfShapemon() != 100) {
					drawString(q.getLevel() + "",x,y+100,g);}
				 
			}
		}
		else if(menuPart == 12)
		{
			g.setColor(c);
			g.fillRect(0,0,720,720);
			if(upPressed && upReleased)
			{
				upReleased = false;
				if(select == 5)
				{
					select = 1;
				}
				else if(select == 6)
				{
					select = 2;
				}
				else if(select == 7)
				{
					select = 3;
				}
				else if(select == 8)
				{
					select = 4;
				}
				else if(select == 9)
				{
					select = 5;
				}
				else if(select == 10)
				{
					select = 6;
				}
				else if(select == 11)
				{
					select = 7;
				}
				else if(select == 12)
				{
					select = 8;
				}
				else if(select == 13)
				{
					select = 9;
				}
				else if(select == 14)
				{
					select = 12;
				}
			}
			if(downPressed && downReleased)
			{
				downReleased = false;
				if(select == 1)
				{
					select = 5;
				}
				else if(select == 2)
				{
					select = 6;
				}
				else if(select == 3)
				{
					select = 7;
				}
				else if(select == 4)
				{
					select = 8;
				}
				else if(select == 5)
				{
					select = 9;
				}
				else if(select == 6)
				{
					select = 10;
				}
				else if(select == 7)
				{
					select = 11;
				}
				else if(select == 8)
				{
					select = 12;
				}
				else if(select == 9)
				{
					select = 13;
				}
				else if(select == 12)
				{
					select = 14;
				}
			}
			if(rightPressed && rightReleased)
			{
				rightReleased = false;
				if(select == 1)
				{
					select = 2;
				}
				else if(select == 2)
				{
					select = 3;
				}
				else if(select == 3)
				{
					select = 4;
				}
				else if(select == 5)
				{
					select = 6;
				}
				else if(select == 6)
				{
					select = 7;
				}
				else if(select == 7)
				{
					select = 8;
				}
				else if(select == 9)
				{
					select = 10;
				}
				else if(select == 10)
				{
					select = 11;
				}
				else if(select == 11)
				{
					select = 12;
				}
				else if(select == 13)
				{
					select = 14;
				}
			}
			if(leftPressed && leftReleased)
			{
				leftReleased = false;
				if(select == 2)
				{
					select = 1;
				}
				else if(select == 3)
				{
					select = 2;
				}
				else if(select == 4)
				{
					select = 3;
				}
				else if(select == 6)
				{
					select = 5;
				}
				else if(select == 7)
				{
					select = 6;
				}
				else if(select == 8)
				{
					select = 7;
				}
				else if(select == 10)
				{
					select = 9;
				}
				else if(select == 11)
				{
					select = 10;
				}
				else if(select == 12)
				{
					select = 11;
				}
				else if(select == 14)
				{
					select = 13;
				}
			}
			if(enterPressed && enterReleased)
			{
				enterReleased = false;
				if(select == 14)
				{
					menuPart = 14;
					select = 1;
				}
				else if(select == 13)
				{
					menuPart = 12;
					select = 1;
				}
				else
				{
					if(select+71<storage.length)
					{
						newShape = storage[select+71];
						shapeNew = select + 71;
					}
					menuPart = 15;
					select = 2;
				}
			}
			g.drawImage(left,10,605,45,45,null);
			g.drawImage(right,655,605,45,45,null);
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
			if(select == 1)
			{
				g.drawImage(storage2, 60, 60, 105, 105, null);
			}
			else if(select == 2)
			{
				g.drawImage(storage2, 225, 60, 105, 105, null);
			}
			else if(select == 3)
			{
				g.drawImage(storage2, 390, 60, 105, 105, null);
			}
			else if(select == 4)
			{
				g.drawImage(storage2, 555, 60, 105, 105, null);
			}
			else if(select == 5)
			{
				g.drawImage(storage2, 60, 225, 105, 105, null);
			}
			else if(select == 6)
			{
				g.drawImage(storage2, 225, 225, 105, 105, null);
			}
			else if(select == 7)
			{
				g.drawImage(storage2, 390, 225, 105, 105, null);
			}
			else if(select == 8)
			{
				g.drawImage(storage2, 555, 225, 105, 105, null);
			}
			else if(select == 9)
			{
				g.drawImage(storage2, 60, 390, 105, 105, null);
			}
			else if(select == 10)
			{
				g.drawImage(storage2, 225, 390, 105, 105, null);
			}
			else if(select == 11)
			{
				g.drawImage(storage2, 390, 390, 105, 105, null);
			}
			else if(select == 12)
			{
				g.drawImage(storage2, 555, 390, 105, 105, null);
			}
			else if(select == 13)
			{
				g.drawImage(left2, 10, 605, 45, 45, null);
			}
			else if(select == 14)
			{
				g.drawImage(right2, 655, 605, 45, 45, null);
			}
			
			for(int i = 84; i<96;i++)
			{
				int z = i - 84;
				int x = (z%4)*165 + 80;
				int y = (int)(z/4)*165 + 80;
				Shapemon q = null;
				if(i<storage.length)
				{
					if(storage[i]!=null)
					{
						q = storage[i];
					}
				}
				else
				{
					 q = new ShapemonBlank(0,0,0);
				}
				switch(q.getTypeOfShapemon()) 
				{
				case 1:
					g.drawImage(circle, x, y, 65, 65, null);
					break;
				case 2:
					g.drawImage(pacman, x, y, 65, 65, null);
					break;
				case 3:
					g.drawImage(triangle, x, y, 65, 65, null);
					break;
				case 4:
					g.drawImage(square, x, y, 65, 65, null);
					break;
				case 5:
					g.drawImage(pentagon, x, y, 65, 65, null);
					break;
				case 6:
					g.drawImage(hexagon, x, y, 65, 65, null);
					break;
				case 8:
					g.drawImage(octagon, x, y, 65, 65, null);
					break;
				case 10:
					g.drawImage(star, x, y, 65, 65, null);
					break;
				case 69:
					g.drawImage(nyan, x, y, 65, 65, null);
					break;
				default:
					g.drawImage(blank,x,y,65,65,null);
					break;
				}
				g.setColor(Color.black);
				if(q.getTypeOfShapemon() != 100) 
				{
					drawString(q.getLevel() + "",x,y+100,g);
				} 
			}
		}
		else if(menuPart == 13)
		{
			g.setColor(c);
			g.fillRect(0,0,720,720);
			if(upPressed && upReleased)
			{
				upReleased = false;
				if(select == 5)
				{
					select = 1;
				}
				else if(select == 6)
				{
					select = 2;
				}
				else if(select == 7)
				{
					select = 3;
				}
				else if(select == 8)
				{
					select = 4;
				}
				else if(select == 9)
				{
					select = 5;
				}
				else if(select == 10)
				{
					select = 6;
				}
				else if(select == 11)
				{
					select = 7;
				}
				else if(select == 12)
				{
					select = 8;
				}
				else if(select == 13)
				{
					select = 9;
				}
				else if(select == 14)
				{
					select = 12;
				}
			}
			if(downPressed && downReleased)
			{
				downReleased = false;
				if(select == 1)
				{
					select = 5;
				}
				else if(select == 2)
				{
					select = 6;
				}
				else if(select == 3)
				{
					select = 7;
				}
				else if(select == 4)
				{
					select = 8;
				}
				else if(select == 5)
				{
					select = 9;
				}
				else if(select == 6)
				{
					select = 10;
				}
				else if(select == 7)
				{
					select = 11;
				}
				else if(select == 8)
				{
					select = 12;
				}
				else if(select == 9)
				{
					select = 13;
				}
				else if(select == 12)
				{
					select = 14;
				}
			}
			if(rightPressed && rightReleased)
			{
				rightReleased = false;
				if(select == 1)
				{
					select = 2;
				}
				else if(select == 2)
				{
					select = 3;
				}
				else if(select == 3)
				{
					select = 4;
				}
				else if(select == 5)
				{
					select = 6;
				}
				else if(select == 6)
				{
					select = 7;
				}
				else if(select == 7)
				{
					select = 8;
				}
				else if(select == 9)
				{
					select = 10;
				}
				else if(select == 10)
				{
					select = 11;
				}
				else if(select == 11)
				{
					select = 12;
				}
				else if(select == 13)
				{
					select = 14;
				}
			}
			if(leftPressed && leftReleased)
			{
				leftReleased = false;
				if(select == 2)
				{
					select = 1;
				}
				else if(select == 3)
				{
					select = 2;
				}
				else if(select == 4)
				{
					select = 3;
				}
				else if(select == 6)
				{
					select = 5;
				}
				else if(select == 7)
				{
					select = 6;
				}
				else if(select == 8)
				{
					select = 7;
				}
				else if(select == 10)
				{
					select = 9;
				}
				else if(select == 11)
				{
					select = 10;
				}
				else if(select == 12)
				{
					select = 11;
				}
				else if(select == 14)
				{
					select = 13;
				}
			}
			if(enterPressed && enterReleased)
			{
				enterReleased = false;
				if(select == 14)
				{
					menuPart = 14;
					select = 1;
				}
				else if(select == 13)
				{
					menuPart = 12;
					select = 1;
				}
				else
				{
					if(select+95<storage.length)
					{
						newShape = storage[select+95];
						shapeNew = select + 95;
					}
					menuPart = 15;
					select = 2;
				}
			}
			g.drawImage(left,10,605,45,45,null);
			g.drawImage(right,655,605,45,45,null);
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
			if(select == 1)
			{
				g.drawImage(storage2, 60, 60, 105, 105, null);
			}
			else if(select == 2)
			{
				g.drawImage(storage2, 225, 60, 105, 105, null);
			}
			else if(select == 3)
			{
				g.drawImage(storage2, 390, 60, 105, 105, null);
			}
			else if(select == 4)
			{
				g.drawImage(storage2, 555, 60, 105, 105, null);
			}
			else if(select == 5)
			{
				g.drawImage(storage2, 60, 225, 105, 105, null);
			}
			else if(select == 6)
			{
				g.drawImage(storage2, 225, 225, 105, 105, null);
			}
			else if(select == 7)
			{
				g.drawImage(storage2, 390, 225, 105, 105, null);
			}
			else if(select == 8)
			{
				g.drawImage(storage2, 555, 225, 105, 105, null);
			}
			else if(select == 9)
			{
				g.drawImage(storage2, 60, 390, 105, 105, null);
			}
			else if(select == 10)
			{
				g.drawImage(storage2, 225, 390, 105, 105, null);
			}
			else if(select == 11)
			{
				g.drawImage(storage2, 390, 390, 105, 105, null);
			}
			else if(select == 12)
			{
				g.drawImage(storage2, 555, 390, 105, 105, null);
			}
			else if(select == 13)
			{
				g.drawImage(left2, 10, 605, 45, 45, null);
			}
			else if(select == 14)
			{
				g.drawImage(right2, 655, 605, 45, 45, null);
			}
			
			for(int i = 96; i<108;i++)
			{
				int z = i - 96;
				int x = (z%4)*165 + 80;
				int y = (int)(z/4)*165 + 80;
				Shapemon q = null;
				if(i<storage.length)
				{	
					if(storage[i]!=null)
					{
						q = storage[i];
					}
				}
				else
				{
					 q = new ShapemonBlank(0,0,0);
				}
				switch(q.getTypeOfShapemon())
				{
				case 1:
					g.drawImage(circle, x, y, 65, 65, null);
					break;
				case 2:
					g.drawImage(pacman, x, y, 65, 65, null);
					break;
				case 3:
					g.drawImage(triangle, x, y, 65, 65, null);
					break;
				case 4:
					g.drawImage(square, x, y, 65, 65, null);
					break;
				case 5:
					g.drawImage(pentagon, x, y, 65, 65, null);
					break;
				case 6:
					g.drawImage(hexagon, x, y, 65, 65, null);
					break;
				case 8:
					g.drawImage(octagon, x, y, 65, 65, null);
					break;
				case 10:
					g.drawImage(star, x, y, 65, 65, null);
					break;
				case 69:
					g.drawImage(nyan, x, y, 65, 65, null);
					break;
				default:
					g.drawImage(blank,x,y,65,65,null);
					break;
				}
				g.setColor(Color.black);
				if(q.getTypeOfShapemon() != 100)
				{
					drawString(q.getLevel() + "",x,y+100,g);
				}		 
			}
		}
		else if(menuPart == 14)
		{
			g.setColor(c);
			g.fillRect(0,0,720,720);
			if(upPressed && upReleased)
			{
				upReleased = false;
				if(select == 5)
				{
					select = 1;
				}
				else if(select == 6)
				{
					select = 2;
				}
				else if(select == 7)
				{
					select = 3;
				}
				else if(select == 8)
				{
					select = 4;
				}
				else if(select == 9)
				{
					select = 5;
				}
				else if(select == 10)
				{
					select = 6;
				}
				else if(select == 11)
				{
					select = 7;
				}
				else if(select == 12)
				{
					select = 8;
				}
				else if(select == 13)
				{
					select = 9;
				}
			}
			if(downPressed && downReleased)
			{
				downReleased = false;
				if(select == 1)
				{
					select = 5;
				}
				else if(select == 2)
				{
					select = 6;
				}
				else if(select == 3)
				{
					select = 7;
				}
				else if(select == 4)
				{
					select = 8;
				}
				else if(select == 5)
				{
					select = 9;
				}
				else if(select == 6)
				{
					select = 10;
				}
				else if(select == 7)
				{
					select = 11;
				}
				else if(select == 8)
				{
					select = 12;
				}
				else if(select == 9)
				{
					select = 13;
				}
			}
			if(rightPressed && rightReleased)
			{
				rightReleased = false;
				if(select == 1)
				{
					select = 2;
				}
				else if(select == 2)
				{
					select = 3;
				}
				else if(select == 3)
				{
					select = 4;
				}
				else if(select == 5)
				{
					select = 6;
				}
				else if(select == 6)
				{
					select = 7;
				}
				else if(select == 7)
				{
					select = 8;
				}
				else if(select == 9)
				{
					select = 10;
				}
				else if(select == 10)
				{
					select = 11;
				}
				else if(select == 11)
				{
					select = 12;
				}
			}
			if(leftPressed && leftReleased)
			{
				leftReleased = false;
				if(select == 2)
				{
					select = 1;
				}
				else if(select == 3)
				{
					select = 2;
				}
				else if(select == 4)
				{
					select = 3;
				}
				else if(select == 6)
				{
					select = 5;
				}
				else if(select == 7)
				{
					select = 6;
				}
				else if(select == 8)
				{
					select = 7;
				}
				else if(select == 10)
				{
					select = 9;
				}
				else if(select == 11)
				{
					select = 10;
				}
				else if(select == 12)
				{
					select = 11;
				}
			}
			if(enterPressed && enterReleased)
			{
				enterReleased = false;
				if(select == 13)
				{
					menuPart = 13;
					select = 1;
				}
				else
				{
					if(select+107<storage.length)
					{
						newShape = storage[select+107];
						shapeNew = select + 107;
					}
					menuPart = 15;
					select = 2;
				}
			}
			g.drawImage(left,10,605,45,45,null);
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
			if(select == 1)
			{
				g.drawImage(storage2, 60, 60, 105, 105, null);
			}
			else if(select == 2)
			{
				g.drawImage(storage2, 225, 60, 105, 105, null);
			}
			else if(select == 3)
			{
				g.drawImage(storage2, 390, 60, 105, 105, null);
			}
			else if(select == 4)
			{
				g.drawImage(storage2, 555, 60, 105, 105, null);
			}
			else if(select == 5)
			{
				g.drawImage(storage2, 60, 225, 105, 105, null);
			}
			else if(select == 6)
			{
				g.drawImage(storage2, 225, 225, 105, 105, null);
			}
			else if(select == 7)
			{
				g.drawImage(storage2, 390, 225, 105, 105, null);
			}
			else if(select == 8)
			{
				g.drawImage(storage2, 555, 225, 105, 105, null);
			}
			else if(select == 9)
			{
				g.drawImage(storage2, 60, 390, 105, 105, null);
			}
			else if(select == 10)
			{
				g.drawImage(storage2, 225, 390, 105, 105, null);
			}
			else if(select == 11)
			{
				g.drawImage(storage2, 390, 390, 105, 105, null);
			}
			else if(select == 12)
			{
				g.drawImage(storage2, 555, 390, 105, 105, null);
			}
			else if(select == 13)
			{
				g.drawImage(left2, 10, 605, 45, 45, null);
			}
			
			for(int i = 108; i<120;i++)
			{
				int z = i - 108;
				int x = (z%4)*165 + 80;
				int y = (int)(z/4)*165 + 80;
				Shapemon q = null;
				if(i<storage.length)
				{	
					if(storage[i]!=null)
					{
						q = storage[i];
					}
				}				
				else
				{
					 q = new ShapemonBlank(0,0,0);
				}
				switch(q.getTypeOfShapemon()) 
				{
				case 1:
					g.drawImage(circle, x, y, 65, 65, null);
					break;
				case 2:
					g.drawImage(pacman, x, y, 65, 65, null);
					break;
				case 3:
					g.drawImage(triangle, x, y, 65, 65, null);
					break;
				case 4:
					g.drawImage(square, x, y, 65, 65, null);
					break;
				case 5:
					g.drawImage(pentagon, x, y, 65, 65, null);
					break;
				case 6:
					g.drawImage(hexagon, x, y, 65, 65, null);
					break;
				case 8:
					g.drawImage(octagon, x, y, 65, 65, null);
					break;
				case 10:
					g.drawImage(star, x, y, 65, 65, null);
					break;
				case 69:
					g.drawImage(nyan, x, y, 65, 65, null);
					break;
				default:
					g.drawImage(blank,x,y,65,65,null);
					break;
				}
				g.setColor(Color.black);
				if(q.getTypeOfShapemon() != 100)
				{
					drawString(q.getLevel() + "",x,y+100,g);
				}	 
			}
		}
		else if(menuPart == 15)
		{
			if(rightPressed & rightReleased)
			{
				rightReleased = false;
				select = 2;
			}
			if(leftPressed & leftReleased)
			{
				leftReleased = false;
				select = 1;
			}
			if(enterPressed && enterReleased)
			{
				enterReleased = false;
				if(select == 1)
				{
					menuPart = 6;
				}
				if(select == 2)
				{
					p.deleteShapemon(shapeOld);
					p.addShapemon(newShape);
					menuPart = 16;
				}
			}
			g.setColor(Color.black);
			drawString("You are switching", 150, 25, g);
			switch(oldShape.getTypeOfShapemon()) 
			{
			case 1:
				g.drawImage(circle, 25, 200, 200, 200, null);
				break;
			case 2:
				g.drawImage(pacman, 25, 200, 200, 200, null);
				break;
			case 3:
				g.drawImage(triangle, 25, 200, 200, 200, null);
				break;
			case 4:
				g.drawImage(square, 25, 200, 200, 200, null);
				break;
			case 5:
				g.drawImage(pentagon, 25, 200, 200, 200, null);
				break;
			case 6:
				g.drawImage(hexagon, 25, 200, 200, 200, null);
				break;
			case 8:
				g.drawImage(octagon, 25, 200, 200, 200, null);
				break;
			case 10:
				g.drawImage(star, 25, 200, 200, 200, null);
				break;
			case 69:
				g.drawImage(nyan, 25, 200, 200, 200, null);
				break;
			default:
				g.drawImage(blank, 25, 200, 200, 200, null);
				break;
			}
			drawString("for",320,280,g);
			switch(newShape.getTypeOfShapemon()) 
			{
			case 1:
				g.drawImage(circle, 475, 200, 200, 200, null);
				break;
			case 2:
				g.drawImage(pacman, 475, 200, 200, 200, null);
				break;
			case 3:
				g.drawImage(triangle, 475, 200, 200, 200, null);
				break;
			case 4:
				g.drawImage(square, 475, 200, 200, 200, null);
				break;
			case 5:
				g.drawImage(pentagon, 475, 200, 200, 200, null);
				break;
			case 6:
				g.drawImage(hexagon, 475, 200, 200, 200, null);
				break;
			case 8:
				g.drawImage(octagon, 475, 200, 200, 200, null);
				break;
			case 10:
				g.drawImage(star, 475, 200, 200, 200, null);
				break;
			case 69:
				g.drawImage(nyan, 475, 200, 200, 200, null);
				break;
			default:
				g.drawImage(blank, 475, 200, 200, 200, null);
				break;
			}
			if(oldShape.getTypeOfShapemon() != 100)
			{
				drawString("LVL" + oldShape.getLevel(),55,425,g);
			}
			if(newShape.getTypeOfShapemon() != 100) 
			{
				drawString("LVL" + newShape.getLevel(),505,425,g);
			}
			g.drawImage(left,10,605,45,45,null);
			g.drawImage(check,655,605,45,45,null);
			if(select == 1)
			{
				g.drawImage(left2,10,605,45,45,null);
			}
			else if(select == 2)
			{
				g.drawImage(check2,655,605,45,45,null);
			}
		}
		if(menuPart == 16)
		{
			//checks to see where the empty space is in storage and adds the shapemon
			storage[shapeNew] = null;
			boolean hasEmptySpace = false;
			//if there is an empty space it adds the shapemon there
			for(int i = 0; i < storage.length; i++) 
			{
				if(storage[i] == null)
				{
					hasEmptySpace = true;
					storage[i] = oldShape;
					i = storage.length;
				}
			}
			//otherwise changes storage so that it is one longer
			if(!hasEmptySpace)
			{
				storage = new Shapemon[storage.length + 1];
				storage[storage.length + 1] = oldShape;
			}
			g.setColor(Color.black);
			drawString("Successful Transaction",100,630,g);	
			if(enterPressed && enterReleased)
			{
				enterReleased = false;
				//logan has to code to close window
				menuPart =  1;
				map.closeMenu();
			}
			
			Shapemon one = p.getShapemon(1);
			switch(one.getTypeOfShapemon())
			{
			case 1:
				g.drawImage(circle, 95, 95, 100, 100, null);
				break;
			case 2:
				g.drawImage(pacman, 95, 95, 100, 100, null);
				break;
			case 3:
				g.drawImage(triangle, 95, 95, 100, 100, null);
				break;
			case 4:
				g.drawImage(square, 95, 95, 100, 100, null);
				break;
			case 5:
				g.drawImage(pentagon, 95, 95, 100, 100, null);
				break;
			case 6:
				g.drawImage(hexagon, 95, 95, 100, 100, null);
				break;
			case 8:
				g.drawImage(octagon, 95, 95, 100, 100, null);
				break;
			case 10:
				g.drawImage(star, 95, 95, 100, 100, null);
				break;
			case 69:
				g.drawImage(nyan, 95, 95, 100, 100, null);
				break;
			default:
				g.drawImage(blank, 95, 95, 100, 100, null);
				break;
			}
			Shapemon two = p.getShapemon(2);
			switch(two.getTypeOfShapemon()) 
			{
			case 1:
				g.drawImage(circle, 310, 95, 100, 100, null);
				break;
			case 2:
				g.drawImage(pacman, 310, 95, 100, 100, null);
				break;
			case 3:
				g.drawImage(triangle, 310, 95, 100, 100, null);
				break;
			case 4:
				g.drawImage(square, 310, 95, 100, 100, null);
				break;
			case 5:
				g.drawImage(pentagon, 310, 95, 100, 100, null);
				break;
			case 6:
				g.drawImage(hexagon, 310, 95, 100, 100, null);
				break;
			case 8:
				g.drawImage(octagon, 310, 95, 100, 100, null);
				break;
			case 10:
				g.drawImage(star, 310, 95, 100, 100, null);
				break;
			case 69:
				g.drawImage(nyan, 310, 95, 100, 100, null);
				break;
			default:
				g.drawImage(blank, 310, 95, 100, 100, null);
				break;
			}
			Shapemon three = p.getShapemon(3);
			switch(three.getTypeOfShapemon())
			{
			case 1:
				g.drawImage(circle, 525, 95, 100, 100, null);
				break;
			case 2:
				g.drawImage(pacman, 525, 95, 100, 100, null);
				break;
			case 3:
				g.drawImage(triangle, 525, 95, 100, 95, null);
				break;
			case 4:
				g.drawImage(square, 525, 95, 100, 100, null);
				break;
			case 5:
				g.drawImage(pentagon, 525, 95, 100, 100, null);
				break;
			case 6:
				g.drawImage(hexagon, 525, 95, 100, 100, null);
				break;
			case 8:
				g.drawImage(octagon, 525, 95, 100, 100, null);
				break;
			case 10:
				g.drawImage(star, 525, 95, 100, 100, null);
				break;
			case 69:
				g.drawImage(nyan, 525, 95, 100, 100, null);
				break;
			default:
				g.drawImage(blank, 525, 95, 100, 200, null);
				break;
			}
			Shapemon four = p.getShapemon(4);
			switch(four.getTypeOfShapemon()) 
			{
			case 1:
				g.drawImage(circle, 95, 310, 100, 100, null);
				break;
			case 2:
				g.drawImage(pacman, 95, 310, 100, 100, null);
				break;
			case 3:
				g.drawImage(triangle, 95, 310, 100, 100, null);
				break;
			case 4:
				g.drawImage(square, 95, 310, 100, 100, null);
				break;
			case 5:
				g.drawImage(pentagon, 95, 310, 100, 100, null);
				break;
			case 6:
				g.drawImage(hexagon, 95, 310, 100, 100, null);
				break;
			case 8:
				g.drawImage(octagon, 95, 310, 100, 100, null);
				break;
			case 10:
				g.drawImage(star, 95, 310, 100, 100, null);
				break;
			case 69:
				g.drawImage(nyan, 95, 310, 100, 100, null);
				break;
			default:
				g.drawImage(blank, 95, 310, 100, 200, null);
				break;
			}
			Shapemon five = p.getShapemon(5);
			switch(five.getTypeOfShapemon()) 
			{
			case 1:
				g.drawImage(circle, 310, 310, 100, 100, null);
				break;
			case 2:
				g.drawImage(pacman, 310, 310, 100, 100, null);
				break;
			case 3:
				g.drawImage(triangle, 310, 310, 100, 100, null);
				break;
			case 4:
				g.drawImage(square, 310, 310, 100, 100, null);
				break;
			case 5:
				g.drawImage(pentagon, 310, 310, 100, 100, null);
				break;
			case 6:
				g.drawImage(hexagon, 310, 310, 100, 100, null);
				break;
			case 8:
				g.drawImage(octagon, 310, 310, 100, 100, null);
				break;
			case 10:
				g.drawImage(star, 310, 310, 100, 100, null);
				break;
			case 69:
				g.drawImage(nyan, 310, 310, 100, 100, null);
				break;
			default:
				g.drawImage(blank, 310, 310, 100, 100, null);
				break;
			}
			Shapemon six = p.getShapemon(6);
			switch(six.getTypeOfShapemon()) 
			{
			case 1:
				g.drawImage(circle, 525, 310, 100, 100, null);
				break;
			case 2:
				g.drawImage(pacman, 525, 310, 100, 100, null);
				break;
			case 3:
				g.drawImage(triangle, 525, 310, 100, 100, null);
				break;
			case 4:
				g.drawImage(square, 525, 310, 100, 100, null);
				break;
			case 5:
				g.drawImage(pentagon, 525, 310, 100, 100, null);
				break;
			case 6:
				g.drawImage(hexagon, 525, 310, 100, 100, null);
				break;
			case 8:
				g.drawImage(octagon, 525, 310, 100, 100, null);
				break;
			case 10:
				g.drawImage(star, 525, 310, 100, 100, null);
				break;
			case 69:
				g.drawImage(nyan, 525, 310, 100, 100, null);
				break;
			default:
				g.drawImage(blank, 525, 310, 100, 100, null);
				break;
			}
			if(one.getTypeOfShapemon() != 100 && one.getTypeOfShapemon() != 0)
			{
				drawString("LVL" + one.getLevel(),75,230,g);
			}
			if(two.getTypeOfShapemon() != 100 && two.getTypeOfShapemon() != 0)
			{
				drawString("LVL" + two.getLevel(),290,230,g);
			}
			if(three.getTypeOfShapemon() != 100 && one.getTypeOfShapemon() != 0)
			{
				drawString("LVL" + three.getLevel(),505,230,g);
			}
			if(four.getTypeOfShapemon() != 100 && one.getTypeOfShapemon() != 0)
			{
				drawString("LVL" + four.getLevel(),80,445,g);
			}
			if(five.getTypeOfShapemon() != 100 && one.getTypeOfShapemon() != 0)
			{
				drawString("LVL" + five.getLevel(),305,445,g);
			}
			if(six.getTypeOfShapemon() != 100 && one.getTypeOfShapemon() != 0)
			{
				drawString("LVL" + six.getLevel(),510,445,g);
			}
		}
		replaceBlank(p);
		return menuPart;
	}
	//replace null shapemon with blank
	private static void replaceNull(Player player) {
		
		for(int i = 1;  i <= 6; i++) {
			if(player.getShapemon(i) == null) {
				player.setShapemon(i,new ShapemonBlank(0,0,0));
				
			}
			
		}
		
	}
	//replace blank shapemon with null
	private static void replaceBlank(Player player) {
		
		for(int i = 1;  i <= 6; i++) {
			
			if(player.getShapemon(i).getTypeOfShapemon() == 100) {
				player.setShapemon(i,null);
				
			}
			
		}
		
	}
		
	private static void reorder(Player p)
	{
		int removed = 0;
		Shapemon holder = new ShapemonBlank(0,0,0);
		
		for(int i = 1; i<6; i++)
		{
			if(p.getShapemon(i) == null)
			{
				p.deleteShapemon(i);
				removed++;
			}
			
		}
		for(int i = 0; i<=removed; i++)
		{
			p.addShapemon(null);
		}
		removed = 0;
	}

	public static Shapemon[] returnStorage()
	{
		return storage;
	}
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		
	//draw String
		private static void drawString(String s, int x, int y, Graphics g) {
			for(int i = 0; i < s.length(); i++) {
				switch(s.toLowerCase().charAt(i)) {
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
			for(int i = 0; i < s.length(); i++) {
				switch(s.toLowerCase().charAt(i)) {
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
		
		//text font
			private static void drawA(int x, int y, Graphics g) {
				g.fillRect(x+ 5, y, 10, 5);
				g.fillRect(x + 15, y+ 5, 5, 25);
				g.fillRect(x, y + 5, 5, 25);	
				g.fillRect(x + 5, y + 15, 10, 5);
			}
			private static void drawB(int x, int y, Graphics g) {
				g.fillRect(x + 5, y, 10, 5);
				g.fillRect(x + 15, y + 5, 5, 5);
				g.fillRect(x , y, 5, 30);
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
				g.fillRect(x , y, 5, 30);
				g.fillRect(x + 5, y + 25, 10, 5);
			}
			private static void drawE(int x, int y, Graphics g) {
				g.fillRect(x + 5, y, 15, 5);
				g.fillRect(x , y, 5, 30);
				g.fillRect(x + 5, y + 25, 15, 5);
				g.fillRect(x + 5, y + 10, 10, 5);
			}
			private static void drawF(int x, int y, Graphics g) {
				g.fillRect(x + 5, y, 15, 5);
				g.fillRect(x , y, 5, 30);
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
				g.fillRect(x+15, y, 5,5);
				g.fillRect(x+10, y + 5, 5,5);
				g.fillRect(x+5, y + 10, 5,5);
				g.fillRect(x+10, y + 15, 5,5);
				g.fillRect(x+15, y + 20, 5,10);
			}
			private static void drawL(int x, int y, Graphics g) {
				g.fillRect(x, y, 5, 30);
				g.fillRect(x + 5, y + 25, 15, 5);
				
			}
			private static void drawM(int x, int y, Graphics g) {
				g.fillRect(x, y, 5, 30);
				g.fillRect(x + 20, y, 5, 30);
				g.fillRect(x+5, y + 5, 5,5);
				g.fillRect(x+10, y + 10, 5,5);
				g.fillRect(x+15, y + 5, 5,5);
			}
			private static void drawN(int x, int y, Graphics g) {
				g.fillRect(x, y, 5, 30);
				g.fillRect(x + 15, y, 5, 30);
				g.fillRect(x+5, y + 5, 5,5);
				g.fillRect(x+10, y + 10, 5,5);
			}
			private static void drawO(int x, int y, Graphics g) {
				g.fillRect(x+ 5, y, 10, 5);
				g.fillRect(x + 15, y+ 5, 5, 20);
				g.fillRect(x, y + 5, 5, 20);	
				g.fillRect(x + 5, y + 25, 10, 5);
			}
			private static void drawP(int x, int y, Graphics g) {
				g.fillRect(x, y, 5, 30);
				g.fillRect(x+ 5, y, 10, 5);
				g.fillRect(x+ 5, y + 15, 10, 5);
				g.fillRect(x+ 15, y + 5, 5, 10);
			}
			private static void drawQ(int x, int y, Graphics g) {
				g.fillRect(x+ 5, y, 10, 5);
				g.fillRect(x + 15, y+ 5, 5, 20);
				g.fillRect(x, y + 5, 5, 20);	
				g.fillRect(x + 5, y + 25, 20, 5);
			}
			private static void drawR(int x, int y, Graphics g) {
				g.fillRect(x, y, 5, 30);
				g.fillRect(x+ 5, y, 10, 5);
				g.fillRect(x+ 5, y + 15, 10, 5);
				g.fillRect(x+ 15, y + 5, 5, 10);
				g.fillRect(x+ 15, y + 20, 5, 10);
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
				g.fillRect(x+ 5, y, 10, 5);
				g.fillRect(x + 15, y+ 5, 5, 20);
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
			private static void drawSlash (int x, int y, Graphics g) {
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
				g.fillRect(x,y,5,30);
				g.fillRect(x + 5,y,5,5);
				g.fillRect(x + 5,y + 25,5,5);
			}
			private static void drawBackBracket(int x, int y, Graphics g) {
				g.fillRect(x + 5,y,5,30);
				g.fillRect(x,y,5,5);
				g.fillRect(x,y + 25,5,5);
			}
			private static void drawBackSlash(int x, int y, Graphics g){
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

}
