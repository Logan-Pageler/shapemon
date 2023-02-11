
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Dialogue extends JComponent{
	int shapemonNumber = 0;
	
	private boolean printWindow = true;
	private boolean printWindow2 = true;
	private boolean printWindow3 = true;
	
	private boolean upPressed = false;
	private boolean upReleased = true;
	private boolean leftPressed = false;
	private boolean leftReleased = true;
	private boolean downPressed = false;
	private boolean downReleased = true;
	private boolean rightPressed = false;
	private boolean rightReleased = true;
	private boolean enterPressed = false;
	private boolean enterReleased = true;
	private boolean leftArrowPressed = false;
	private boolean leftArrowReleased = true;
	private boolean rightArrowPressed = false;
	private Image background = (new ImageIcon("Background.gif").getImage());
	private boolean rightArrowReleased = true;
	private boolean shiftPressed = false;
	private boolean inDialogue = true;
	private boolean inSelectionScreen = false;
	private Image downArrow = (new ImageIcon("DownArrow.gif").getImage());
	private Image FinalBoss1 = (new ImageIcon("FinalBoss1.gif").getImage());
	private Image downArrow2 = (new ImageIcon("DownArrow2.gif").getImage());
	private Image rightArrow = (new ImageIcon("RightArrow.gif").getImage());
	private Image leftArrow = (new ImageIcon("LeftArrow.gif").getImage());
	private Image nyan = (new ImageIcon("NyanCat.gif").getImage());
	private Image triangle = (new ImageIcon("Triangle.gif").getImage());
	private Image square = (new ImageIcon("Square.gif").getImage());
	private Image selectBackground = (new ImageIcon("selectBackground.gif").getImage());
	private Image pacman = (new ImageIcon("Pacman.gif").getImage());
	private Image star = (new ImageIcon("Star.gif").getImage());
	private Image circle = (new ImageIcon("Circle.gif").getImage());
	private Image pentagon = (new ImageIcon("Pentagon.gif").getImage());
	private Image hexagon = (new ImageIcon("Hexagon.gif").getImage());
	private Image octagon = (new ImageIcon("Octagon.gif").getImage());
	private Image move1 = (new ImageIcon("PlayerBullet1.gif").getImage());
	private Image move2 = (new ImageIcon("PlayerBullet2.gif").getImage());
	private Image move3 = (new ImageIcon("PlayerBullet3.gif").getImage());
	private Image move4 = (new ImageIcon("PlayerBullet4.gif").getImage());
	private Image move5 = (new ImageIcon("PlayerBullet5.gif").getImage());
	private Image move6 = (new ImageIcon("PlayerBullet6.gif").getImage());
	private Image move7 = (new ImageIcon("PlayerBulletNyan.gif").getImage());
	private Image move8 = (new ImageIcon("PlayerBulletPacman.gif").getImage());
	private Image move9 = (new ImageIcon("PlayerBullet9.gif").getImage());
	private Image move10 = (new ImageIcon("PlayerBullet10.gif").getImage());
	private Image move11 = (new ImageIcon("PlayerBullet11.gif").getImage());

	private int x = 20;
	private int y = 560;
	private int screenNumber = 1;
	private int selectedBox = 1;
	private int selectedBox2 = 1;
	private int selectedBox3 = 1;
	private int xSlider = 350;
	private final int SCREENLENGTH = 720;
	private String name = "player";

	private Image mainBoss1 = (new ImageIcon("MainBoss1.gif")).getImage();
	
	public Dialogue() {}
	                            
	public boolean drawTutorialPart1(int x, int y, Graphics g) {
		drawDialogue("Are you okay? I found you unconscious next to a pile of half eaten mushrooms. Anyways, because it's 2018, I can't assume your gender, so would you mind telling me?",x,y,g);
		drawDialogue("Gender is a spectrum, and I was too lazy to code non-binary genders in, but what is your name?",x + 3 * SCREENLENGTH,y,g);
		drawDialogue("Well, glad to meet you " + name + ", my name is professor tree, and I'd like to welcome you to the world of shapemon. Shapemon are mystical creatures that can be caught, tamed,"
		+ " and battled. Now; I can't walk because I'm not programmed to, but meet me at the lake straight up and to the left and then we can get you started on your adventure. Just beware of the tall grass, as that's where wild shapemon linger.",x + 6 * SCREENLENGTH,y,g);
		if(screenNumber == 3) {
			
			drawString("Choose your gender",360 - getLength("Choose your gender") / 2,580,g);
			drawString("Girl",155 - getLength("girl"),640,g);
			drawString("Boy",565,640,g);
			g.drawLine(160, 655, 560, 655);
			g.fillRect(xSlider, 650, 20, 10);
			if(rightPressed && xSlider < 540) {
				xSlider = xSlider + 5;
			}
			if(leftPressed && xSlider > 160) {
				xSlider = xSlider - 5;
			}
		}
		
		if(screenNumber == 13) {
			drawString("Enter your name",360 - getLength("Enter your name") / 2,580,g);
			if(upPressed) {
				if(getLength(name + "m") < 335) {
					name = name + "w";
				}
			}
			if(getLength(name) % 10 == 0) {
				drawString(name + "_",360 - getLength(name) / 2,630,g);
			}
			else {
				drawString(name + "_",360 - (getLength(name) - 5) / 2,630,g);
			}
		}
		return screenNumber == 13;
	}
	public boolean drawTutorialPart2(int x, int y, Graphics g, Player p) {
		drawDialogue("hello again, " + name + ", I have been waiting for you.",x,y,g);
		drawDialogue("I have here, 3 shapemon, I will let you take only one.",x+SCREENLENGTH,y,g);
		drawDialogue("so choose wisely [one of these is more rare than the others btw].",x+SCREENLENGTH*2,y,g);
		if(screenNumber == 3) {
			inSelectionScreen = true;
			g.drawImage(selectBackground, 40, 190, 140, 140, null);
			g.drawImage(triangle, 60, 210, 100, 100, null);
			g.drawImage(selectBackground, 220, 120, 280, 280, null);
			g.drawImage(nyan, 260, 180, 200, 200, null);
			g.drawImage(selectBackground, 540, 190, 140, 140, null);
			g.drawImage(square, 560, 210, 100, 100, null);
			
			// 3(triangle), 1(nyancat), 2(square)
			if(leftPressed && leftReleased && selectedBox == 1) {
				selectedBox = 3;
				leftReleased = false;
			}
			if(rightPressed && rightReleased && selectedBox == 1) {
				selectedBox = 2;
				rightReleased = false;
			}
			if(rightPressed && rightReleased && selectedBox == 3) {
				selectedBox = 1;
				rightReleased = false;
			}
			if(leftPressed && leftReleased && selectedBox == 2) {
				selectedBox = 1;
				leftReleased = false;
			}
			g.setColor(Color.YELLOW);
			switch(selectedBox) {
			case 1:
				g.fillRect(240, 140, 240, 240);
				g.drawImage(nyan, 240 + 20, 140 + 20 + 20, 200, 200, null);
				
				
				
				break;
			case 3:
				g.fillRect(50, 200, 120, 120);
				g.drawImage(triangle, 60, 210, 100, 100, null);
				
				System.out.println(p.getShapemon(1).getName());
				break;
				
			case 2:
				g.fillRect(550, 200, 120, 120);
				g.drawImage(square, 560, 210, 100, 100, null);
				
				break;
			}
			if(enterPressed) {
				inSelectionScreen = false;
			}	
		}
		switch(selectedBox) {
		case 1:
			if(p.getShapemon(1) == null) {
				p.addShapemon(new ShapemonNyan(5,7,2));
			}
			drawDialogue("Congratulations, you now have a Nyancat [good choice]. remember that if you see me or a shapemon center, you can heal your shapemon to full health, now. In battle movement is the same as in the main map, press the select key to fire, special move is shift and enter, and switching moves is q. Good luck on your adventure.",x + SCREENLENGTH*3,y,g);
			break;
		case 2:
			if(p.getShapemon(1) == null) {
				p.addShapemon(new ShapemonSquare(5,7,2));
			}
			drawDialogue("Congratulations, you now have a square. remember that if you see me or a shapemon center, you can heal your shapemon to full health, now. In battle movement is the same as in the main map, press the select key to fire, special move is shift and enter, and switching moves is q. Good luck on your adventure.",x + SCREENLENGTH*3,y,g);
			break;
		case 3:
			if(p.getShapemon(1) == null) {
				p.addShapemon(new ShapemonTriangle(5,7,2));
			}
			drawDialogue("Congratulations, you now have a triangle. remember that if you see me or a shapemon center, you can heal your shapemon to full health, now. In battle movement is the same as in the main map, press the select key to fire, special move is shift and enter, and switching moves is q. Good luck on your adventure.",x + SCREENLENGTH*3,y,g);
			break;
		}
		
		return screenNumber == 8;
	}
	public boolean drawHealingCenter(int x, int y, Player player, Graphics g) {
		drawDialogue("Hello " + name + ", and welcome to the shapemon center.", x,y,g);
		drawDialogue("I can heal your shapemon to full health.", x + SCREENLENGTH,y,g);
		if(screenNumber == 3) {
			inSelectionScreen = true;
			drawString("What would you like to do?", 360 - getLength("what would you like to do?") / 2, 555,g);
			drawString("heal shapemon", 360 - getLength("heal shapemon") / 2, 605, g);
			drawString("back", 360 - (getLength("back") - 5) / 2, 640, g);
			if(downPressed && downReleased && selectedBox < 2) {
				selectedBox++;
				downReleased = false;
			}
		    if(upPressed && upReleased && selectedBox > 1) {
		    	selectedBox--;
		    	upReleased = false;
		    }
			switch(selectedBox) {
			case 1:
				g.drawImage(rightArrow, 360 - getLength("heal shapemon") / 2 - 45, 605, 40, 35, null);
				break;
			case 2:
				g.drawImage(rightArrow, 360 - (getLength("back") - 5) / 2 - 45, 640, 40, 35, null);
				break;
			}
			if(enterPressed && enterReleased) {
				inSelectionScreen = false;
			}
		}
		if(selectedBox == 1) {
			drawDialogue("All of your Shapemon have been fully healed. Come again!",x+ SCREENLENGTH * 3,y,g);
			try {
				player.getShapemon(1).heal();
			} catch(Exception ex) {}
			try {
				player.getShapemon(2).heal();
			} catch(Exception ex) {}
			try {
				player.getShapemon(3).heal();
			} catch(Exception ex) {}
			try {
				player.getShapemon(4).heal();
			} catch(Exception ex) {}
			try {
				player.getShapemon(5).heal();
			} catch(Exception ex) {}
			try {
				player.getShapemon(6).heal();
			} catch(Exception ex) {}
		}
		if(selectedBox == 2) {
			drawDialogue("Come again!",x + SCREENLENGTH * 3,y,g);
		}
		return screenNumber == 5;
		
	}
	public boolean drawHealingProffesor(int x, int y, Graphics g,Player player) {
		drawDialogue("Hello again " + name + ".", x,y,g);
		drawDialogue("I can heal your shapemon to full health.", x + SCREENLENGTH,y,g);
		if(screenNumber == 3) {
			inSelectionScreen = true;
			drawString("What would you like to do?", 360 - getLength("what would you like to do?") / 2, 555,g);
			drawString("heal shapemon", 360 - getLength("heal shapemon") / 2, 605, g);
			drawString("back", 360 - (getLength("back") - 5) / 2, 640, g);
			if(downPressed && downReleased && selectedBox < 2) {
				selectedBox++;
				downReleased = false;
			}
		    if(upPressed && upReleased && selectedBox > 1) {
		    	selectedBox--;
		    	upReleased = false;
		    }
			switch(selectedBox) {
			case 1:
				g.drawImage(rightArrow, 360 - getLength("heal shapemon") / 2 - 45, 605, 40, 35, null);
				break;
			case 2:
				g.drawImage(rightArrow, 360 - (getLength("back") - 5) / 2 - 45, 640, 40, 35, null);
				break;
			}
			if(enterPressed && enterReleased) {
				inSelectionScreen = false;
			}
			
		}
		if(selectedBox == 1) {
			try {
				player.getShapemon(1).heal();
			} catch(Exception ex) {}
			try {
				player.getShapemon(2).heal();
			} catch(Exception ex) {}
			try {
				player.getShapemon(3).heal();
			} catch(Exception ex) {}
			try {
				player.getShapemon(4).heal();
			} catch(Exception ex) {}
			try {
				player.getShapemon(5).heal();
			} catch(Exception ex) {}
			try {
				player.getShapemon(6).heal();
			} catch(Exception ex) {}
			drawDialogue("All of your Shapemon have been fully healed. Come again!",x+ SCREENLENGTH * 3,y,g);
		}
		if(selectedBox == 2) {
			drawDialogue("Come again!",x + SCREENLENGTH * 3,y,g);
		}
		
		return screenNumber == 5;
		
		
	}
	public boolean drawProffesorText4(int x, int y, Graphics g,Player player) {
		drawDialogue("Hello again " + name + ".", x,y,g);
		drawDialogue("I can heal your shapemon to full health.", x + SCREENLENGTH,y,g);
		if(screenNumber == 3) {
			inSelectionScreen = true;
			drawString("What would you like to do?", 360 - getLength("what would you like to do?") / 2, 555,g);
			drawString("heal shapemon", 360 - getLength("heal shapemon") / 2, 605, g);
			drawString("back", 360 - (getLength("back") - 5) / 2, 640, g);
			if(downPressed && downReleased && selectedBox < 2) {
				selectedBox++;
				downReleased = false;
			}
		    if(upPressed && upReleased && selectedBox > 1) {
		    	selectedBox--;
		    	upReleased = false;
		    }
			switch(selectedBox) {
			case 1:
				g.drawImage(rightArrow, 360 - getLength("heal shapemon") / 2 - 45, 605, 40, 35, null);
				break;
			case 2:
				g.drawImage(rightArrow, 360 - (getLength("back") - 5) / 2 - 45, 640, 40, 35, null);
				break;
			}
			if(enterPressed && enterReleased) {
				inSelectionScreen = false;
			}
			
		}
		if(selectedBox == 1) {
			try {
				player.getShapemon(1).heal();
			} catch(Exception ex) {}
			try {
				player.getShapemon(2).heal();
			} catch(Exception ex) {}
			try {
				player.getShapemon(3).heal();
			} catch(Exception ex) {}
			try {
				player.getShapemon(4).heal();
			} catch(Exception ex) {}
			try {
				player.getShapemon(5).heal();
			} catch(Exception ex) {}
			try {
				player.getShapemon(6).heal();
			} catch(Exception ex) {}
			drawDialogue("There, HURRY! Up a head there is thought to be a legendary in the grass.",x+ SCREENLENGTH * 3,y,g);
		}
		if(selectedBox == 2) {
			drawDialogue("HURRY! Up a head there is thought to be a legendary in the grass.",x + SCREENLENGTH * 3,y,g);
		}
		
		return screenNumber == 5;
		
		
	}
	public boolean drawProffesorGoToLakeText(int x, int y, Graphics g) {
		drawDialogue("I'm already coded at the lake waiting for you up and to the right hurry.",x,y,g);
		
		return screenNumber == 2;
	}
	public boolean drawHealingCenterWithMoveLearn(int x, int y, String move, Player player, Graphics g) {
		
		if(move.equals("slash")) {
			drawDialogue("Hello " + name + ", and welcome to the shapecenter. I can heal your shapemon as well as teach them the move " + move + " [can cut small trees].", x,y,g);
		}
		else if(move.equals("swim")) {
			drawDialogue("Hello " + name + ", and welcome to the shapecenter. I can heal your shapemon as well as teach them the move " + move + " [can navigate water].", x,y,g);
		}
		else if(move.equals("smash")) {
			drawDialogue("Hello " + name + ", and welcome to the shapecenter. I can heal your shapemon as well as teach them the move " + move + " [can break brown rocks].", x,y,g);
		}
		else {
			throw new IllegalArgumentException("String move must be SLASH, SWIM, or SMASH");
		}
		
		if(screenNumber == 3) {
			inSelectionScreen = true;
			drawString("What would you like to do?", 360 - getLength("what would you like to do?") / 2, 535,g);
			drawString("heal shapemon", 360 - getLength("heal shapemon") / 2, 585, g);
			if(getLength("learn " + move) % 10 == 0) {
				drawString("learn " + move, 360 - getLength("learn " + move) / 2, 620, g);
			}
			else {
				drawString("learn " + move, 360 - (getLength("learn " + move) - 5) / 2, 620, g);
			}
			drawString("back", 360 - (getLength("back") - 5) / 2, 655, g);
			if(downPressed && downReleased && selectedBox < 3) {
				selectedBox++;
				downReleased = false;
			}
		    if(upPressed && upReleased && selectedBox > 1) {
		    	selectedBox--;
		    	upReleased = false;
		    }
			switch(selectedBox) {
			case 1:
				g.drawImage(rightArrow, 360 - getLength("heal shapemon") / 2 - 45, 585, 40, 35, null);
				break;
			case 2:
				if(getLength("learn " + move) % 10 == 0) {
					g.drawImage(rightArrow, 360 - getLength("learn " + move) / 2 - 45, 620, 40, 35, null);
				}
				else {
					g.drawImage(rightArrow, 360 - (getLength("learn " + move) - 5) / 2 - 45, 620, 40, 35, null);
				}
				break;
			case 3:
				g.drawImage(rightArrow, 360 - (getLength("back") - 5) / 2 - 45, 655, 40, 35, null);
				break;
			}
			if(enterPressed && enterReleased) {
				inSelectionScreen = false;
			}
			
		}
		if(selectedBox == 1) {
			try {
				player.getShapemon(1).heal();
			} catch(Exception ex) {}
			try {
				player.getShapemon(2).heal();
			} catch(Exception ex) {}
			try {
				player.getShapemon(3).heal();
			} catch(Exception ex) {}
			try {
				player.getShapemon(4).heal();
			} catch(Exception ex) {}
			try {
				player.getShapemon(5).heal();
			} catch(Exception ex) {}
			try {
				player.getShapemon(6).heal();
			} catch(Exception ex) {}
			drawDialogue("All of your Shapemon have been fully healed. Come again!",x+ SCREENLENGTH * 3,y,g);
			return screenNumber == 5;
		}
		if(selectedBox == 2 && screenNumber == 4) {
			
			inSelectionScreen = true;
			drawDialogue("Which Shapemon should learn " + move + "?",x + SCREENLENGTH * 3,y,g);
			g.drawImage(selectBackground, 75, 75, 140, 140, null);
			g.drawImage(selectBackground, 290, 75, 140, 140, null);
			g.drawImage(selectBackground, 505, 75, 140, 140, null);
			g.drawImage(selectBackground, 75, 290, 140, 140, null);
			g.drawImage(selectBackground, 290, 290, 140, 140, null);
			g.drawImage(selectBackground, 505, 290, 140, 140, null);
			
			try {
				g.drawImage(player.getShapemon(1).getImage(), 95, 95, 100, 100, null);
			}catch(Exception e) {}
			try {
				g.drawImage(player.getShapemon(2).getImage(), 310, 95, 100, 100, null);
			}catch(Exception e) {}
			try {
				g.drawImage(player.getShapemon(3).getImage(), 525, 95, 100, 100, null);
			}catch(Exception e) {}
			try {
				g.drawImage(player.getShapemon(4).getImage(), 95, 310, 100, 100, null);
			}catch(Exception e) {}
			try {
				g.drawImage(player.getShapemon(5).getImage(), 310, 310, 100, 100, null);
			}catch(Exception e) {}
			try {
				g.drawImage(player.getShapemon(6).getImage(), 525, 310, 100, 100, null); 
			}catch(Exception e) {}
			 
			//g.drawImage(square, 95, 95, 100, 100, null);
			//g.drawImage(square, 310, 95, 100, 100, null);
			//g.drawImage(square, 525, 95, 100, 100, null);
			//g.drawImage(square, 95, 310, 100, 100, null);
			//g.drawImage(square, 310, 310, 100, 100, null);
			//g.drawImage(square, 525, 310, 100, 100, null);

			
			//1, 2, 3
			//4, 5, 6
			if(rightPressed && rightReleased) {
				if(selectedBox2 == 1||selectedBox2 == 2||selectedBox2 == 4||selectedBox2 == 5) {
					selectedBox2++;
				}
				rightReleased = false;
			}
			if(leftPressed && leftReleased) {
				if(selectedBox2 == 2||selectedBox2 == 3||selectedBox2 == 5||selectedBox2 == 6) {
					selectedBox2--;
				}
				leftReleased = false;
			}
			if(upPressed && upReleased) {
				if(selectedBox2 >= 4 && selectedBox2 <= 6) {
					selectedBox2 = selectedBox2 - 3;
				}
				upReleased = false;
			}
			if(downPressed && downReleased) {
				if(selectedBox2 >= 1 && selectedBox2 <= 3) {
					selectedBox2 = selectedBox2 + 3;
				}
				downReleased = false;
			}
			g.setColor(Color.YELLOW);
			while(selectedBox2 > player.getNumOfShapemon()) {
				selectedBox2 --;
			}
			switch(selectedBox2) {
			case 1:			
				g.fillRect(85, 85, 120, 120);
				g.drawImage(player.getShapemon(1).getImage(), 95, 95, 100, 100, null);
				shapemonNumber = 1;
				
				break;
			case 2:
				g.fillRect(300, 85, 120, 120);
				g.drawImage(player.getShapemon(2).getImage(), 310, 95, 100, 100, null);
				shapemonNumber = 2;
				break;
			case 3:
				g.fillRect(515, 85, 120, 120);
				
				g.drawImage(player.getShapemon(3).getImage(), 310, 95, 100, 100, null);
				shapemonNumber = 3;
				break;
			case 4:
				g.fillRect(85, 300, 120, 120);
				
				g.drawImage(player.getShapemon(4).getImage(), 310, 95, 100, 100, null);
				shapemonNumber = 4;
				break;
			case 5:
				g.fillRect(300, 300, 120, 120);
				
				g.drawImage(player.getShapemon(5).getImage(), 310, 95, 100, 100, null);
				shapemonNumber = 5;
				break;
			case 6:
				g.fillRect(515, 300, 120, 120);
				
				g.drawImage(player.getShapemon(6).getImage(), 310, 95, 100, 100, null);
				shapemonNumber = 6;
				break;
			}
		}
		if(screenNumber == 5 && selectedBox == 2) {
			if(rightPressed && selectedBox3 == 1) {
				selectedBox3 = 2;
				rightPressed = false;
			}
			if(leftPressed && selectedBox3 == 2) {
				selectedBox3 = 1;
				leftPressed = false;
			}
			if(downPressed && (selectedBox3 == 1 || selectedBox3 == 2)) {
				selectedBox3 = 3;
				downPressed = false;
			}
			if(upPressed && selectedBox3 == 3) {
				selectedBox3 = 2;
				upPressed = false;
			}
			g.setColor(Color.BLACK);
			drawDialogue("which move should be replaced?",x + SCREENLENGTH * 4,y,g);
			g.drawImage(downArrow2, 670, 650, 35, 40, null);
			g.fillRect(20, 75+190, 680, 5);
			g.fillRect(20, 75+190+245, 680, 5);
			g.fillRect(15, 75+195, 5, 240);
			g.fillRect(700, 75+195, 5, 240);
			g.setColor(new Color(200,200,200));
			g.fillRect(20,80 + 190,340,240);
			g.fillRect(360,80 + 190,340,240);
			drawMove(player.getShapemon(shapemonNumber).getMoveOne(),40,100 + 190,300,200,g);
			drawMove(player.getShapemon(shapemonNumber).getMoveTwo(),380,100 + 190,300,200,g);
			g.setColor(Color.YELLOW);
			
			switch(selectedBox3) {
			case 1:
				g.fillRect(20,80 + 190,340,240);
				drawMove(player.getShapemon(shapemonNumber).getMoveOne(),40,100 + 190,300,200,g);
				break;
			case 2:
				g.fillRect(360,80 + 190,340,240);
				drawMove(player.getShapemon(shapemonNumber).getMoveTwo(),380,100 + 190,300,200,g);
				break;
			case 3:
				g.fillRect(670, 650, 35, 40);
				g.drawImage(downArrow2, 670, 650, 35, 40, null);
				break;
			}
			switch(move) {
			case "slash":
				drawMove(9,240,30,300,200,g);
				break;
			case "swim":
				drawMove(10,240,30,300,200,g);
				break;
			case "smash":
				drawMove(11,240,30,300,200,g);
				break;
			}
		}
		if(screenNumber == 6) {
			
			
			
			if(selectedBox3 == 1 || selectedBox3 == 2) {
				switch(move) {
				case "slash":
					player.getShapemon(shapemonNumber).setMove(selectedBox3, 9);
					break;
				case "swim":
					player.getShapemon(shapemonNumber).setMove(selectedBox3, 10);
					break;
				case "smash":
					player.getShapemon(shapemonNumber).setMove(selectedBox3, 11);
					break;
				}
				
				drawDialogue(player.getShapemon(shapemonNumber).getName() + " has learned " + move +"! Come again!",x + SCREENLENGTH * 5,y,g);
			}
			if(selectedBox3 == 3) {
				drawDialogue("come again!",x + SCREENLENGTH * 5,y,g);
				return screenNumber == 5;
			}
			
		}
		if(selectedBox == 3) {
			drawDialogue("Come again!",x + SCREENLENGTH * 3,y,g);
			return screenNumber == 5;
		}
		return screenNumber == 7;
	}
	public boolean drawHealingCenterPart1(int x, int y, Graphics g, Player player)
	{
		drawDialogue("Hello, did you hear of the strange activty on top of the mountains to the west.",x,y,g);
		drawDialogue("Would you like me to heal your shapemon back to full health?",x + SCREENLENGTH,y,g);
		if(screenNumber == 3) {
			inSelectionScreen = true;
			drawString("What would you like to do?", 360 - getLength("what would you like to do?") / 2, 555,g);
			drawString("heal shapemon", 360 - getLength("heal shapemon") / 2, 605, g);
			drawString("back", 360 - (getLength("back") - 5) / 2, 640, g);
			if(downPressed && downReleased && selectedBox < 2) {
				selectedBox++;
				downReleased = false;
			}
		    if(upPressed && upReleased && selectedBox > 1) {
		    	selectedBox--;
		    	upReleased = false;
		    }
			switch(selectedBox) {
			case 1:
				g.drawImage(rightArrow, 360 - getLength("heal shapemon") / 2 - 45, 605, 40, 35, null);
				break;
			case 2:
				g.drawImage(rightArrow, 360 - (getLength("back") - 5) / 2 - 45, 640, 40, 35, null);
				break;
			}
			if(enterPressed && enterReleased) {
				inSelectionScreen = false;
			}
			
		}
		if(screenNumber == 4) {
			if(selectedBox == 1) {
				try {
					player.getShapemon(1).heal();
				} catch(Exception ex) {}
				try {
					player.getShapemon(2).heal();
				} catch(Exception ex) {}
				try {
					player.getShapemon(3).heal();
				} catch(Exception ex) {}
				try {
					player.getShapemon(4).heal();
				} catch(Exception ex) {}
				try {
					player.getShapemon(5).heal();
				} catch(Exception ex) {}
				try {
					player.getShapemon(6).heal();
				} catch(Exception ex) {}
				drawDialogue("All of your Shapemon have been fully healed. Come again!",x+ SCREENLENGTH * 3,y,g);
			}
			if(selectedBox == 2) {
				drawDialogue("Come again!",x + SCREENLENGTH * 3,y,g);
			}
		}
		return screenNumber == 5;
		
	}
	public boolean drawHealingCenterPart2(int x, int y, Graphics g, Player player)
	{
		
		drawDialogue("You were found fainted at the bottom of the mountain.",x,y,g);
		drawDialogue("I healed your shapemon to full health, but",x + SCREENLENGTH,y,g);
		drawDialogue("I can also teach them the move smash [breaks brown rocks].",x + SCREENLENGTH * 2,y,g);
		drawString("Learn the move smash?",x + SCREENLENGTH * 3 + xCenter("Learn the move smash?") - 20, y, g);
		drawString("Yes",x + SCREENLENGTH * 3 + xCenter("yes"),y + 35,g);
		drawString("No",x + SCREENLENGTH * 3 + xCenter("no"),y + 70,g);
		if(screenNumber == 4) {
			inSelectionScreen = true;
			if(downPressed && downReleased && selectedBox == 1) {
				selectedBox = 2;
				downReleased = false;
			}
			if(upPressed && upReleased && selectedBox == 2) {
				selectedBox = 1;
				upReleased = false;
			}
			if(selectedBox == 1) {
				g.drawImage(rightArrow, x + SCREENLENGTH * 3 + xCenter("yes") - 45, y + 35, 40, 35, null);
			}
			if(selectedBox == 2) {
				g.drawImage(rightArrow, x + SCREENLENGTH * 3 + xCenter("no") - 45, y + 70, 40, 35, null);
			}
			if(enterPressed && enterReleased) {
				inSelectionScreen = false;
			}
		}
		if(selectedBox == 1 && screenNumber == 5) {
			
			inSelectionScreen = true;
			drawDialogue("Which Shapemon should learn smash?",x + SCREENLENGTH * 4,y,g);
			g.drawImage(selectBackground, 75, 75, 140, 140, null);
			g.drawImage(selectBackground, 290, 75, 140, 140, null);
			g.drawImage(selectBackground, 505, 75, 140, 140, null);
			g.drawImage(selectBackground, 75, 290, 140, 140, null);
			g.drawImage(selectBackground, 290, 290, 140, 140, null);
			g.drawImage(selectBackground, 505, 290, 140, 140, null);
			
			
			try {
				g.drawImage(player.getShapemon(1).getImage(), 95, 95, 100, 100, null);
			}catch(Exception e) {}
			try {
				g.drawImage(player.getShapemon(2).getImage(), 310, 95, 100, 100, null);
			}catch(Exception e) {}
			try {
				g.drawImage(player.getShapemon(3).getImage(), 525, 95, 100, 100, null);
			}catch(Exception e) {}
			try {
				g.drawImage(player.getShapemon(4).getImage(), 95, 310, 100, 100, null);
			}catch(Exception e) {}
			try {
				g.drawImage(player.getShapemon(5).getImage(), 310, 310, 100, 100, null);
			}catch(Exception e) {}
			try {
				g.drawImage(player.getShapemon(6).getImage(), 525, 310, 100, 100, null); 
			}catch(Exception e) {}
			
			//g.drawImage(square, 95, 95, 100, 100, null);
			//g.drawImage(square, 310, 95, 100, 100, null);
			//g.drawImage(square, 525, 95, 100, 100, null);
			//g.drawImage(square, 95, 310, 100, 100, null);
			//g.drawImage(square, 310, 310, 100, 100, null);
			//g.drawImage(square, 525, 310, 100, 100, null);

			
			//1, 2, 3
			//4, 5, 6
			if(rightPressed && rightReleased) {
				if(selectedBox2 == 1||selectedBox2 == 2||selectedBox2 == 4||selectedBox2 == 5) {
					selectedBox2++;
				}
				rightReleased = false;
			}
			if(leftPressed && leftReleased) {
				if(selectedBox2 == 2||selectedBox2 == 3||selectedBox2 == 5||selectedBox2 == 6) {
					selectedBox2--;
				}
				leftReleased = false;
			}
			if(upPressed && upReleased) {
				if(selectedBox2 >= 4 && selectedBox2 <= 6) {
					selectedBox2 = selectedBox2 - 3;
				}
				upReleased = false;
			}
			if(downPressed && downReleased) {
				if(selectedBox2 >= 1 && selectedBox2 <= 3) {
					selectedBox2 = selectedBox2 + 3;
				}
				downReleased = false;
			}
			g.setColor(Color.YELLOW);
			while(selectedBox2 > player.getNumOfShapemon()) {
				selectedBox2 --;
			}
			switch(selectedBox2) {
			case 1:			
				g.fillRect(85, 85, 120, 120);
				g.drawImage(player.getShapemon(1).getImage(), 95, 95, 100, 100, null);
				shapemonNumber = 1;
				
				break;
			case 2:
				g.fillRect(300, 85, 120, 120);
				g.drawImage(player.getShapemon(2).getImage(), 310, 95, 100, 100, null);
				shapemonNumber = 2;
				break;
			case 3:
				g.fillRect(515, 85, 120, 120);
				
				g.drawImage(player.getShapemon(3).getImage(), 310, 95, 100, 100, null);
				shapemonNumber = 3;
				break;
			case 4:
				g.fillRect(85, 300, 120, 120);
			
				g.drawImage(player.getShapemon(4).getImage(), 310, 95, 100, 100, null);
				shapemonNumber = 4;
				break;
			case 5:
				g.fillRect(300, 300, 120, 120);
			
				g.drawImage(player.getShapemon(5).getImage(), 310, 95, 100, 100, null);
				shapemonNumber = 5;
				break;
			case 6:
				g.fillRect(515, 300, 120, 120);
				
				g.drawImage(player.getShapemon(6).getImage(), 310, 95, 100, 100, null);
				shapemonNumber = 6;
				break;
			}
		}
		if(screenNumber == 6 && selectedBox == 1) {
			if(rightPressed && selectedBox3 == 1) {
				selectedBox3 = 2;
				rightPressed = false;
			}
			if(leftPressed && selectedBox3 == 2) {
				selectedBox3 = 1;
				leftPressed = false;
			}
			if(downPressed && (selectedBox3 == 1 || selectedBox3 == 2)) {
				selectedBox3 = 3;
				downPressed = false;
			}
			if(upPressed && selectedBox3 == 3) {
				selectedBox3 = 2;
				upPressed = false;
			}
			g.setColor(Color.BLACK);
			drawDialogue("which move should be replaced?",x + SCREENLENGTH * 5,y,g);
			g.drawImage(downArrow2, 670, 650, 35, 40, null);
			g.fillRect(20, 75+190, 680, 5);
			g.fillRect(20, 75+190+245, 680, 5);
			g.fillRect(15, 75+195, 5, 240);
			g.fillRect(700, 75+195, 5, 240);
			g.setColor(new Color(200,200,200));
			g.fillRect(20,80 + 190,340,240);
			g.fillRect(360,80 + 190,340,240);
			drawMove(1,40,100 + 190,300,200,g);
			drawMove(2,380,100 + 190,300,200,g);
			g.setColor(Color.YELLOW);
			switch(selectedBox3) {
			case 1:
				g.fillRect(20,80 + 190,340,240);
				drawMove(1,40,100 + 190,300,200,g);
				break;
			case 2:
				g.fillRect(360,80 + 190,340,240);
				drawMove(2,380,100 + 190,300,200,g);
				break;
			case 3:
				g.fillRect(670, 650, 35, 40);
				g.drawImage(downArrow2, 670, 650, 35, 40, null);
				break;
			}
			
				drawMove(11,240,30,300,200,g);
				
			
		}
		if(screenNumber == 7) {
			if(selectedBox3 == 1 || selectedBox3 == 2) {
				player.getShapemon(shapemonNumber).setMove(selectedBox3, 10);
				drawDialogue(player.getShapemon(shapemonNumber).getName() + " has learned smash! Come again!",x + SCREENLENGTH * 6,y,g);
			}
			if(selectedBox3 == 3) {
				drawDialogue("come again!",x + SCREENLENGTH * 5,y,g);
				return screenNumber == 8;
			}
			
		}
		if(selectedBox == 2) {
			drawDialogue("Come again!",x + SCREENLENGTH * 4,y,g);
			return screenNumber == 6;
		}
		return screenNumber == 8;
	}
	public boolean drawSavingDialogue(int x, int y, Graphics g) {
		inSelectionScreen = true;
		drawString("Would you like to save?",x + xCenter("Would you like to save?"),y,g);
		drawString("Yes",x + xCenter("yes"),y + 50,g);
		drawString("no",x + xCenter("no"),y+85,g);
		if(downPressed) {
			selectedBox = 2;
		}
		if(upPressed) {
			selectedBox = 1;
		}
		if(selectedBox == 1) {
			g.drawImage(rightArrow, x + xCenter("yes") - 45, y + 50, 40, 35, null);
		}
		else {
			g.drawImage(rightArrow, x + xCenter("no") - 45, y + 85, 40, 35, null);
		}
		if(selectedBox == 1 && screenNumber == 2) {
			drawDialogue("Saving...",x+SCREENLENGTH + xCenter("Saving..."),y+35,g);
			return true;
		}
		else{
			return false;
		}
		
	}
	public boolean drawHealingCenterPart3(int x, int y, Graphics g, Player player)
	{
		drawDialogue("Hello, did you hear of the strange activty on the island north of here.",x,y,g);
		drawDialogue("Would you like me to heal your shapemon back to full health?",x + SCREENLENGTH,y,g);
		if(screenNumber == 3) {
			inSelectionScreen = true;
			drawString("What would you like to do?", 360 - getLength("what would you like to do?") / 2, 555,g);
			drawString("heal shapemon", 360 - getLength("heal shapemon") / 2, 605, g);
			drawString("back", 360 - (getLength("back") - 5) / 2, 640, g);
			if(downPressed && downReleased && selectedBox < 2) {
				selectedBox++;
				downReleased = false;
			}
		    if(upPressed && upReleased && selectedBox > 1) {
		    	selectedBox--;
		    	upReleased = false;
		    }
			switch(selectedBox) {
			case 1:
				g.drawImage(rightArrow, 360 - getLength("heal shapemon") / 2 - 45, 605, 40, 35, null);
				break;
			case 2:
				g.drawImage(rightArrow, 360 - (getLength("back") - 5) / 2 - 45, 640, 40, 35, null);
				break;
			}
			if(enterPressed && enterReleased) {
				inSelectionScreen = false;
			}
			
		}
		if(screenNumber == 4) {
			if(selectedBox == 1) {
				try {
					player.getShapemon(1).heal();
				} catch(Exception ex) {}
				try {
					player.getShapemon(2).heal();
				} catch(Exception ex) {}
				try {
					player.getShapemon(3).heal();
				} catch(Exception ex) {}
				try {
					player.getShapemon(4).heal();
				} catch(Exception ex) {}
				try {
					player.getShapemon(5).heal();
				} catch(Exception ex) {}
				try {
					player.getShapemon(6).heal();
				} catch(Exception ex) {}
				drawDialogue("All of your Shapemon have been fully healed. Come again!",x+ SCREENLENGTH * 3,y,g);
			}
			if(selectedBox == 2) {
				drawDialogue("Come again!",x + SCREENLENGTH * 3,y,g);
			}
		}
		return screenNumber == 5;
		
	}
	public boolean tallGrassWithNoShapemonDialogue( int x, int y, Graphics g) {
			drawDialogue("-You shouldn't go in the grass without any Shapemon-", x, y, g);
			return screenNumber == 2;
	}
	public boolean smallTreeWithNoSlash( int x, int y, Graphics g) {
		drawDialogue("-This tree looks weak, maby a Shapemon can slash it-", x, y, g);
		return screenNumber == 2;
	}
	public boolean smallTreeWithSlash( int x, int y, Graphics g, MapGenerator map, int direction) {
		drawDialogue("-This tree looks weak, maby a Shapemon can slash it-", x, y, g);
		if(screenNumber == 2) {
			drawString("-Do you want to slash it?-", 360 - getLength("-Do you want to slash it?-") / 2, 555,g);
			drawString("Yes",x + SCREENLENGTH + xCenter("yes"),y + 50,g);
			drawString("no",x + SCREENLENGTH + xCenter("no"),y+85,g);
			if(downPressed) {
				selectedBox = 2;
			}
			if(upPressed) {
				selectedBox = 1;
			}
			if(selectedBox == 1) {
				g.drawImage(rightArrow, x + SCREENLENGTH + xCenter("yes") - 45, y + 50, 40, 35, null);
			}
			else {
				g.drawImage(rightArrow, x + SCREENLENGTH + xCenter("no") - 45, y + 85, 40, 35, null);
			}
		}
		if(screenNumber == 3) {
			if(selectedBox == 1) {
				drawDialogue("-The tree was slashed.-", x + SCREENLENGTH * 2, y, g);
				if (direction == 0) {
					map.setUpTile(1);
				} else if (direction == 1) {
					map.setLeftTile(1);
				} else if (direction == 2) {
					map.setDownTile(1);
				} else if (direction == 3) {
					map.setRightTile(1);
				}
			} else {
				return true;
			}
		}
		return screenNumber == 4;
	}
	public boolean finalBossText( int x, int y, Graphics g, MapGenerator map, Battle battle, Player player) {
		drawDialogue("Ive been expecting you.", x, y, g);
		drawDialogue("Now you must stand there and listen as I explain my whole plan.", x + SCREENLENGTH, y, g);
		drawDialogue("See the flowers all around you, there glitchy and I can use them to manipulate any data on your computer.", x + SCREENLENGTH * 2, y, g);
		drawDialogue("The only thing stopping me was your anti-virus software which just so happened to be corrupted and saved as a PacMan Shapemon. Since you deafeted it you also brought down your anti-virus software letting me free.", x + SCREENLENGTH * 4, y, g);
		drawDialogue("You see as this game file was installed on your your computer it didnt download properly leading to a bug and the creation of me.", x + SCREENLENGTH * 7, y, g);
		drawDialogue("Once I break out of this game I will take over your computer and then the entire internet.", x + SCREENLENGTH * 9, y, g);
		if(screenNumber == 12 && printWindow) {
			printWindow = false;
			JFrame w = new JFrame("ERROR");  
		    w.setBounds(300, 300, 300, 200);
		    w.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    Container c = w.getContentPane();
		    c.add(new JLabel("ERROR 109 : SYSTEM FAILURE"));
		    w.setVisible(true);
		}
		drawDialogue("It has already begun!", x + SCREENLENGTH * 11, y, g);
		drawDialogue("I have already altered the code so you can't stop Me", x  + SCREENLENGTH * 12, y, g);
		if(screenNumber == 14 && printWindow2) {
			printWindow2 = false;
			JFrame w = new JFrame("ERROR");  
		    w.setBounds(300, 300, 300, 200);
		    w.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    Container c = w.getContentPane();
		    c.add(new JLabel("ERROR 112 : HEALING SHAPEMON STARTING BATTLE"));
		    w.setVisible(true);
		}
		try {
			player.getShapemon(1).heal();
		} catch(Exception ex) {}
		try {
			player.getShapemon(2).heal();
		} catch(Exception ex) {}
		try {
			player.getShapemon(3).heal();
		} catch(Exception ex) {}
		try {
			player.getShapemon(4).heal();
		} catch(Exception ex) {}
		try {
			player.getShapemon(5).heal();
		} catch(Exception ex) {}
		try {
			player.getShapemon(6).heal();
		} catch(Exception ex) {}
		drawDialogue("NOOO!", x  + SCREENLENGTH * 13, y, g);
		drawDialogue("It doesnt matter ill defeat you anyways", x + SCREENLENGTH * 14, y, g);
		drawDialogue("Since you already have found me out I might as well reveal my true form.", x + SCREENLENGTH * 15, y, g);
		if(screenNumber == 17) {
			
			g.drawImage(background,0,0,720,720,null);
			g.setColor(new Color(200,200,200));
			g.fillRect(10, 530, 695, 190);
			g.setColor(Color.BLACK);
			g.fillRect(5, 530, 5, 190);
			g.fillRect(10, 525, 695, 5);
			g.fillRect(705, 530, 5, 190);
			g.drawImage(mainBoss1 , 20, 20, 160, 340, null);
		}
		
		drawDialogue("Lets beggin!", x + SCREENLENGTH * 16, y, g);
		if(screenNumber == 18) {
			map.setVisible(false);
			battle.setVisible(true);
			Player oponent = new Player(new ShapemonCircle(100,6,5),new ShapemonTriangle(100,4,6),new ShapemonPentagon(100,5,4),new ShapemonHexagon(100,4,6),new ShapemonOctagon(100,5,6),new ShapemonStar(100,4,5));
			oponent.setName("KawiiGoneGym");
			battle.runBattle(player, oponent);
			map.setFinalBattle(true);
		}
		return screenNumber == 18;
	}
	public boolean smallRockWithNoSmash( int x, int y, Graphics g) {
		drawDialogue("-This rock looks weak, maby a Shapemon can smash it-", x, y, g);
		return screenNumber == 2;
	}
	public boolean finalBossText2( int x, int y, Graphics g) {
		g.drawImage(background,0,0,720,720,null);
		g.setColor(new Color(200,200,200));
		g.fillRect(10, 530, 695, 190);
		g.setColor(Color.BLACK);
		g.fillRect(5, 530, 5, 190);
		g.fillRect(10, 525, 695, 5);
		g.fillRect(705, 530, 5, 190);
		g.drawImage(mainBoss1 , 20, 20, 160, 340, null);
		drawDialogue("NOOOOOO THIS CANNOT BEEEEEEEEEEEE!!!", x, y, g);
		if(screenNumber == 2 && printWindow3) {
			printWindow3 = false;
			JFrame w = new JFrame("ANTI-VIRUSE");  
	    		w.setBounds(300, 300, 300, 200);
	    		w.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    		Container c = w.getContentPane();
	    		c.add(new JLabel("VIRUS DETECED: DELETING VIRUS"));
	    		w.setVisible(true);
		}
		return screenNumber == 2;
	}
	public boolean smallRockWithSmash( int x, int y, Graphics g, MapGenerator map, int direction) {
		drawDialogue("-This rock looks weak, maby a Shapemon can smash it-", x, y, g);
		if(screenNumber == 2) {
			drawString("-Do you want to smash it?-", 360 - getLength("-Do you want to smash it?-") / 2, 555,g);
			drawString("Yes",x + SCREENLENGTH + xCenter("yes"),y + 50,g);
			drawString("no",x + SCREENLENGTH + xCenter("no"),y+85,g);
			if(downPressed) {
				selectedBox = 2;
			}
			if(upPressed) {
				selectedBox = 1;
			}
			if(selectedBox == 1) {
				g.drawImage(rightArrow, x + SCREENLENGTH + xCenter("yes") - 45, y + 50, 40, 35, null);
			}
			else {
				g.drawImage(rightArrow, x + SCREENLENGTH + xCenter("no") - 45, y + 85, 40, 35, null);
			}
		}
		if(screenNumber == 3) {
			if(selectedBox == 1) {
				drawDialogue("-The rock was smashed.-", x + SCREENLENGTH * 2, y, g);
				if (direction == 0) {
					map.setUpTile(1);
				} else if (direction == 1) {
					map.setLeftTile(1);
				} else if (direction == 2) {
					map.setDownTile(1);
				} else if (direction == 3) {
					map.setRightTile(1);
				}
			} else {
				return true;
			}
		}
		return screenNumber == 4;
	}
	public boolean swimDialogue( int x, int y, Graphics g, MapGenerator map) {
		
		if(screenNumber == 1) {
			drawString("-Do you want to swim in the water?-", 360 - getLength("-Do you want to swim in the water?-") / 2, 555,g);
			drawString("Yes",x + xCenter("yes"),y + 50,g);
			drawString("no",x + xCenter("no"),y+85,g);
			if(downPressed) {
				selectedBox = 2;
			}
			if(upPressed) {
				selectedBox = 1;
			}
			if(selectedBox == 1) {
				g.drawImage(rightArrow, x + xCenter("yes") - 45, y + 50, 40, 35, null);
			}
			else {
				g.drawImage(rightArrow, x + xCenter("no") - 45, y + 85, 40, 35, null);
			}
		} else {
			if(selectedBox == 1) {
				map.playSwimmingAnimation();
			}
		}
		
		return screenNumber == 2;
	}
	public void drawDialogue(String s, int x, int y, Graphics g) {
		int f = 0;
		int iPrev = 0;
		int level = 1;
		for(int i = 1; i < s.length(); i++) {
			if(getLength(s.substring(getPrevWhiteSpace(s,iPrev), i).trim()) > 675){
				drawString(s.substring(getPrevWhiteSpace(s,iPrev), getPrevWhiteSpace(s,i)).trim(), x,y,g);
				if(level == 1 || level == 2) {
					y = y + 40;
					level++;
				}
				else {
					x = x + 720;
					y = y - 80;
					level = 1;
				}
				iPrev = i - 1;
			}
			f = getPrevWhiteSpace(s,iPrev);
		}
		drawString(s.substring(f).trim(), x , y, g);
	}
	private int getPrevWhiteSpace(String s, int i) {
		for(int j = i - 1; j > 0; j--) {
			if(Character.isWhitespace(s.charAt(j))) {
				return j;
			}
		}
		return 0;
	}
	private int xCenter(String wordToCenter) {
		if(getLength(wordToCenter) % 10 == 0) {
			return 360 - getLength(wordToCenter) / 2 - 20;
		}
		else {
			return 360 - (getLength(wordToCenter) - 5) / 2 - 20;
		}
	}
	
	private void drawShapemon(int typeOfShapemon, int x, int y, int xs, int ys, Graphics g) { 
		switch(typeOfShapemon) {
		case 1:
			g.drawImage(circle, x, y, xs, ys, null);
			break;
		case 2:
			g.drawImage(pacman, x, y, xs, ys, null);
			break;
		case 3:
			g.drawImage(triangle, x, y, xs, ys, null);
			break;
		case 4:
			g.drawImage(square, x, y, xs, ys, null);
			break;
		case 5:
			g.drawImage(pentagon, x, y, xs, ys, null);
			break;
		case 6:
			g.drawImage(hexagon, x, y, xs, ys, null);
			break;
		case 8:
			g.drawImage(octagon, x, y, xs, ys, null);
			break;
		case 10:
			g.drawImage(star, x, y, xs, ys, null);
			break;
		case 69:
			g.drawImage(nyan, x, y + 10, xs, ys, null);
			break;
		}
	}
	private void drawMove(int typeOfMove, int x, int y, int xs, int ys, Graphics g) {
		switch(typeOfMove) {
		case 1:
			g.drawImage(move1, x, y, xs, ys, null);
			break;
		case 2:
			g.drawImage(move2, x, y, xs, ys, null);
			break;
		case 3:
			g.drawImage(move3, x, y, xs, ys, null);
			break;
		case 4:
			g.drawImage(move4, x, y, xs, ys, null);
			break;
		case 5:
			g.drawImage(move5, x, y, xs, ys, null);
			break;
		case 6:
			g.drawImage(move6, x, y, xs, ys, null);
			break;
		case 7:
			g.drawImage(move7, x, y, xs, ys, null);
			break;
		case 8:
			g.drawImage(move8, x, y, xs, ys, null);
			break;
		case 9:
			g.drawImage(move9, x, y, xs, ys, null);
			break;
		case 10:
			g.drawImage(move10, x, y, xs, ys, null);
			break;
		case 11:
			g.drawImage(move11, x, y, xs, ys, null);
			break;
		}
	}
	
	public void reset() {
		screenNumber = 1;
		selectedBox = 1;
		selectedBox2 = 1;
		selectedBox3 = 1;
		
		printWindow = true;
		printWindow2 = true;
		printWindow3 = true;
	}
	
	public void upPressed() {
		upPressed = true;
	}
	public void upReleased() {
		upPressed = false;
		upReleased = true;
	}
	public void leftPressed() {
		leftPressed = true;
	}
	public void leftReleased() {
		leftPressed = false;
		leftReleased = true;
	}
	public void downPressed() {
		downPressed = true;
	}
	public void downReleased() {
		downPressed = false;
		downReleased = true;
	}
	public void rightPressed() {
		rightPressed = true;
	}
	public void rightReleased() {
		rightPressed = false;
		rightReleased = true;
	}
	public void enterPressed() {
		enterPressed = true;
		if(enterReleased) {
			screenNumber++;
			enterReleased = false;
		}
		
	}
	public void enterReleased() {
		enterPressed = false;
		enterReleased = true;
	}
	public void leftArrowPressed() {
		leftArrowPressed = true;
	}
	public void leftArrowReleased() {
		leftArrowPressed = false;
		leftArrowReleased = true;
	}
	public void rightArrowPressed() {
		rightArrowPressed = true;
	}
	public void rightArrowReleased() {
		rightArrowPressed = false;
		rightArrowReleased = true;
	}
	public void shiftPressed() {
		shiftPressed = true;
	}
	public void shiftReleased() {
		shiftPressed = false;
	}
	private void drawString(String s, int x, int y, Graphics g) {
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
			case '?':
				drawQuestionMark(x, y, g);
				x = x + 20;
				break;
			case '!':
				drawExclamationMark(x, y, g);
				x = x + 10;
				break;
			case '_':
				drawUnderScore(x, y, g);
				x = x + 20;
				break;
			default:
				x = x + 20;
				break;
			}
		}	
	}
	private void drawA(int x, int y, Graphics g) {
		g.fillRect(x+ 5, y, 10, 5);
		g.fillRect(x + 15, y+ 5, 5, 25);
		g.fillRect(x, y + 5, 5, 25);	
		g.fillRect(x + 5, y + 15, 10, 5);
	}
	private void drawB(int x, int y, Graphics g) {
		g.fillRect(x + 5, y, 10, 5);
		g.fillRect(x + 15, y + 5, 5, 5);
		g.fillRect(x , y, 5, 30);
		g.fillRect(x + 15, y + 15, 5, 10);
		g.fillRect(x + 5, y + 25, 10, 5);
		g.fillRect(x + 5, y + 10, 10, 5);
	}
	private void drawC(int x, int y, Graphics g) {
		g.fillRect(x + 5, y, 10, 5);
		g.fillRect(x, y + 5, 5, 20);
		g.fillRect(x + 15, y + 5, 5, 5);
		g.fillRect(x + 5, y + 25, 10, 5);
		g.fillRect(x + 15, y + 20, 5, 5);
	}
	private void drawD(int x, int y, Graphics g) {
		g.fillRect(x + 5, y, 10, 5);
		g.fillRect(x + 15, y + 5, 5, 20);
		g.fillRect(x , y, 5, 30);
		g.fillRect(x + 5, y + 25, 10, 5);
	}
	private void drawE(int x, int y, Graphics g) {
		g.fillRect(x + 5, y, 15, 5);
		g.fillRect(x , y, 5, 30);
		g.fillRect(x + 5, y + 25, 15, 5);
		g.fillRect(x + 5, y + 10, 10, 5);
	}
	private void drawF(int x, int y, Graphics g) {
		g.fillRect(x + 5, y, 15, 5);
		g.fillRect(x , y, 5, 30);
		g.fillRect(x + 5, y + 10, 10, 5);
	}
	private void drawG(int x, int y, Graphics g) {
		g.fillRect(x + 5, y, 10, 5);
		g.fillRect(x, y + 5, 5, 20);
		g.fillRect(x + 15, y + 5, 5, 5);
		g.fillRect(x + 5, y + 25, 10, 5);
		g.fillRect(x + 15, y + 15, 5, 10);
		g.fillRect(x + 10, y + 15, 5, 5);
	}
	private void drawH(int x, int y, Graphics g) {
		g.fillRect(x + 5, y + 10, 10, 5);
		g.fillRect(x, y, 5, 30);
		g.fillRect(x + 15, y, 5, 30);
	}
	private void drawI(int x, int y, Graphics g) {
		g.fillRect(x, y, 15, 5);
		g.fillRect(x, y + 25, 15, 5);
		g.fillRect(x + 5, y + 5, 5, 20);
	}
	private void drawJ(int x, int y, Graphics g) {
		g.fillRect(x + 15, y, 5, 25);
		g.fillRect(x, y + 15, 5, 10);
		g.fillRect(x + 5, y + 25, 10, 5);
		
	}
	private void drawK(int x, int y, Graphics g) {
		g.fillRect(x, y, 5, 30);
		g.fillRect(x+15, y, 5,5);
		g.fillRect(x+10, y + 5, 5,5);
		g.fillRect(x+5, y + 10, 5,5);
		g.fillRect(x+10, y + 15, 5,5);
		g.fillRect(x+15, y + 20, 5,10);
	}
	private void drawL(int x, int y, Graphics g) {
		g.fillRect(x, y, 5, 30);
		g.fillRect(x + 5, y + 25, 15, 5);
		
	}
	private void drawM(int x, int y, Graphics g) {
		g.fillRect(x, y, 5, 30);
		g.fillRect(x + 20, y, 5, 30);
		g.fillRect(x+5, y + 5, 5,5);
		g.fillRect(x+10, y + 10, 5,5);
		g.fillRect(x+15, y + 5, 5,5);
	}
	private void drawN(int x, int y, Graphics g) {
		g.fillRect(x, y, 5, 30);
		g.fillRect(x + 15, y, 5, 30);
		g.fillRect(x+5, y + 5, 5,5);
		g.fillRect(x+10, y + 10, 5,5);
	}
	private void drawO(int x, int y, Graphics g) {
		g.fillRect(x+ 5, y, 10, 5);
		g.fillRect(x + 15, y+ 5, 5, 20);
		g.fillRect(x, y + 5, 5, 20);	
		g.fillRect(x + 5, y + 25, 10, 5);
	}
	private void drawP(int x, int y, Graphics g) {
		g.fillRect(x, y, 5, 30);
		g.fillRect(x+ 5, y, 10, 5);
		g.fillRect(x+ 5, y + 15, 10, 5);
		g.fillRect(x+ 15, y + 5, 5, 10);
	}
	private void drawQ(int x, int y, Graphics g) {
		g.fillRect(x+ 5, y, 10, 5);
		g.fillRect(x + 15, y+ 5, 5, 20);
		g.fillRect(x, y + 5, 5, 20);	
		g.fillRect(x + 5, y + 25, 20, 5);
	}
	private void drawR(int x, int y, Graphics g) {
		g.fillRect(x, y, 5, 30);
		g.fillRect(x+ 5, y, 10, 5);
		g.fillRect(x+ 5, y + 15, 10, 5);
		g.fillRect(x+ 15, y + 5, 5, 10);
		g.fillRect(x+ 15, y + 20, 5, 10);
	}
	private void drawS(int x, int y, Graphics g) {
		g.fillRect(x + 5, y, 10, 5);
		g.fillRect(x + 15, y + 5, 5, 5);
		g.fillRect(x + 5, y + 10, 5, 5);
		g.fillRect(x + 10, y + 15, 5, 5);
		g.fillRect(x + 5, y + 25, 10, 5);
		g.fillRect(x + 15, y + 20, 5, 5);
		g.fillRect(x, y + 5, 5, 5);
		g.fillRect(x, y + 20, 5, 5);
	}
	private void drawT(int x, int y, Graphics g) {
		g.fillRect(x, y, 25, 5);
		g.fillRect(x + 10, y + 5, 5, 25);
	}
	private void drawU(int x, int y, Graphics g) {
		g.fillRect(x + 15, y, 5, 25);
		g.fillRect(x, y, 5, 25);	
		g.fillRect(x, y + 25, 20, 5);
	}
	private void drawV(int x, int y, Graphics g) {
		g.fillRect(x + 15, y, 5, 25);
		g.fillRect(x, y, 5, 25);	
		g.fillRect(x + 5, y + 25, 10, 5);
	}
	private void drawW(int x, int y, Graphics g) {
		g.fillRect(x + 20, y, 5, 25);
		g.fillRect(x, y, 5, 25);	
		g.fillRect(x + 5, y + 25, 5, 5);
		g.fillRect(x + 15, y + 25, 5, 5);
		g.fillRect(x + 10, y + 15, 5, 10);
	}
	private void drawX(int x, int y, Graphics g) {
		g.fillRect(x + 15, y, 5, 10);
		g.fillRect(x, y, 5, 10);	
		g.fillRect(x + 15, y + 15, 5, 15);
		g.fillRect(x, y + 15, 5, 15);
		g.fillRect(x + 5, y + 10, 10, 5);
	}
	private void drawY(int x, int y, Graphics g) {
		g.fillRect(x + 20, y, 5, 10);
		g.fillRect(x, y, 5, 10);
		g.fillRect(x + 10, y + 15, 5, 15);
		g.fillRect(x + 5, y + 10, 5, 5);
		g.fillRect(x + 15, y + 10, 5, 5);
	}
	private void drawZ(int x, int y, Graphics g) {
		g.fillRect(x, y, 20, 5);
		g.fillRect(x, y + 25, 20, 5);
		g.fillRect(x + 15, y + 5, 5, 5);
		g.fillRect(x + 10, y + 10, 5, 5);
		g.fillRect(x + 5, y + 15, 5, 5);
		g.fillRect(x, y + 20, 5, 5);
	}
	private void draw1(int x, int y, Graphics g) {
		g.fillRect(x + 10, y, 5, 30);
		g.fillRect(x + 5, y + 5, 5, 5);
		g.fillRect(x, y + 10, 5, 5);
	}
	private void draw2(int x, int y, Graphics g) {
		g.fillRect(x + 5, y, 10, 5);
		g.fillRect(x, y + 5, 5, 5);
		g.fillRect(x + 15, y + 5, 5, 10);
		g.fillRect(x + 5, y + 15, 10, 5);
		g.fillRect(x, y + 20, 5, 5);
		g.fillRect(x, y + 25, 20, 5);
	}
	private void draw3(int x, int y, Graphics g) {
		g.fillRect(x + 5, y, 10, 5);
		g.fillRect(x, y + 5, 5, 5);
		g.fillRect(x + 15, y + 5, 5, 5);
		g.fillRect(x + 10, y + 10, 5, 5);
		g.fillRect(x + 15, y + 15, 5, 10);
		g.fillRect(x + 5, y + 25, 10, 5);
		g.fillRect(x, y + 20, 5, 5);
	}
	private void draw4(int x, int y, Graphics g) {
		g.fillRect(x + 10, y, 5, 5);
		g.fillRect(x + 15, y, 5, 30);
		g.fillRect(x + 5, y + 5, 5, 5);
		g.fillRect(x, y + 10, 5, 5);
		g.fillRect(x, y + 15, 20, 5);
	}
	private void draw5(int x, int y, Graphics g) {
		g.fillRect(x, y, 20, 5);
		g.fillRect(x, y + 5, 5, 5);
		g.fillRect(x, y + 10, 15, 5);
		g.fillRect(x + 15, y + 15, 5, 10);
		g.fillRect(x + 5, y + 25, 10, 5);
		g.fillRect(x, y + 20, 5, 5);
	}
	private void draw6(int x, int y, Graphics g) {
		g.fillRect(x + 5, y, 10, 5);
		g.fillRect(x + 15, y + 5, 5, 5);
		g.fillRect(x, y + 5, 5, 20);
		g.fillRect(x + 5, y + 15, 10, 5);
		g.fillRect(x + 15, y + 20, 5, 5);
		g.fillRect(x + 5, y + 25, 10, 5);
	}
	private void draw7(int x, int y, Graphics g) {
		g.fillRect(x, y, 15, 5);
		g.fillRect(x + 15, y + 5, 5, 5);
		g.fillRect(x + 10, y + 10, 5, 5);
		g.fillRect(x + 5, y + 15, 5, 5);
		g.fillRect(x, y + 20, 5, 10);
	}
	private void draw8(int x, int y, Graphics g) {
		g.fillRect(x + 5, y, 10, 5);
		g.fillRect(x, y + 5, 5, 5);
		g.fillRect(x + 15, y + 5, 5, 5);
		g.fillRect(x + 5, y + 10, 10, 5);
		g.fillRect(x + 15, y + 15, 5, 10);
		g.fillRect(x + 5, y + 25, 10, 5);
		g.fillRect(x, y + 15, 5, 10);
	}
	private void draw9(int x, int y, Graphics g) {
		g.fillRect(x + 5, y, 10, 5);
		g.fillRect(x, y + 5, 5, 5);
		g.fillRect(x + 15, y + 5, 5, 20);
		g.fillRect(x + 5, y + 10, 10, 5);
		g.fillRect(x + 5, y + 25, 10, 5);
		g.fillRect(x, y + 20, 5, 5);
	}
	private void draw0(int x, int y, Graphics g) {
		g.fillRect(x+ 5, y, 10, 5);
		g.fillRect(x + 15, y+ 5, 5, 20);
		g.fillRect(x, y + 5, 5, 20);	
		g.fillRect(x + 5, y + 25, 10, 5);
		g.fillRect(x + 5, y + 15, 5, 5);
		g.fillRect(x + 10, y + 10, 5, 5);
	}
	private void drawUp(int x, int y, Graphics g) {
		g.fillRect(x + 10, y, 5, 30);
		g.fillRect(x + 5, y + 5, 5, 5);
		g.fillRect(x, y + 10, 5, 5);
		g.fillRect(x + 15, y + 5, 5, 5);
		g.fillRect(x + 20, y + 10, 5, 5);
	}
	private void drawRight(int x, int y, Graphics g) {
		g.fillRect(x, y + 10, 30, 5);
		g.fillRect(x + 20, y + 5, 5, 5);
		g.fillRect(x + 15, y, 5, 5);
		g.fillRect(x + 20, y + 15, 5, 5);
		g.fillRect(x + 15, y + 20, 5, 5);
	}
	private void drawDown(int x, int y, Graphics g) {
		g.fillRect(x + 10, y, 5, 30);
		g.fillRect(x + 5, y + 20, 5, 5);
		g.fillRect(x, y + 15, 5, 5);
		g.fillRect(x + 15, y + 20, 5, 5);
		g.fillRect(x + 20, y + 15, 5, 5);
	}
	private void drawLeft(int x, int y, Graphics g) {
		g.fillRect(x, y + 10, 30, 5);
		g.fillRect(x + 5, y + 5, 5, 5);
		g.fillRect(x + 10, y, 5, 5);
		g.fillRect(x + 5, y + 15, 5, 5);
		g.fillRect(x + 10, y + 20, 5, 5);
	}
	private void drawComma(int x, int y, Graphics g) {
		g.fillRect(x, y + 25, 5, 10);
	}
	private void drawPeriod(int x, int y, Graphics g) {
		g.fillRect(x, y + 25, 5, 5);
	}
	private void drawSlash (int x, int y, Graphics g) {
		g.fillRect(x, y + 25, 5, 5);
		g.fillRect(x + 5, y + 20, 5, 5);
		g.fillRect(x + 10, y + 15, 5, 5);
		g.fillRect(x + 15, y + 10, 5, 5);
		g.fillRect(x + 20, y + 5, 5, 5);
		g.fillRect(x + 25, y, 5, 5);
	}
	private void drawSemmicolen(int x, int y, Graphics g) {
		g.fillRect(x, y + 25, 5, 10);
		g.fillRect(x, y + 15, 5, 5);
	}
	private void drawApostrophi(int x, int y, Graphics g) {
		g.fillRect(x, y, 5, 10);
	}
	private void drawAccentmark(int x, int y, Graphics g) {
		g.fillRect(x, y, 5, 5);
		g.fillRect(x + 5, y + 5, 5, 5);
	}
	private void drawBracket(int x, int y, Graphics g) {
		g.fillRect(x,y,5,30);
		g.fillRect(x + 5,y,5,5);
		g.fillRect(x + 5,y + 25,5,5);
	}
	private void drawBackBracket(int x, int y, Graphics g) {
		g.fillRect(x + 5,y,5,30);
		g.fillRect(x,y,5,5);
		g.fillRect(x,y + 25,5,5);
	}
	private void drawBackSlash(int x, int y, Graphics g){
		g.fillRect(x, y, 5, 5);
		g.fillRect(x + 5, y + 5, 5, 5);
		g.fillRect(x + 10, y + 10, 5, 5);
		g.fillRect(x + 15, y + 15, 5, 5);
		g.fillRect(x + 20, y + 20, 5, 5);
		g.fillRect(x + 25, y + 25, 5, 5);
	}
	private void drawDash(int x, int y, Graphics g) {
		g.fillRect(x, y + 10, 15, 5);
	}
	private void drawEqualsign(int x, int y, Graphics g) {
		g.fillRect(x, y + 5, 20, 5);
		g.fillRect(x, y + 20, 20, 5);
	}
	private void drawQuestionMark(int x, int y, Graphics g){
		g.fillRect(x, y, 15, 5);
		g.fillRect(x + 10, y + 5, 5, 5);
		g.fillRect(x , y + 10, 15, 5);
		g.fillRect(x, y + 15, 5, 5);
		g.fillRect(x , y + 25, 5, 5);
	}
	private void drawExclamationMark(int x, int y, Graphics g) {
		g.fillRect(x, y, 5, 20);
		g.fillRect(x, y + 25, 5, 5);
	}
	private void drawUnderScore(int x, int y, Graphics g) {
		g.fillRect(x, y + 25, 15, 5);
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
			case '?':
				x = x + 20;
				break;
			case '!':
				x = x + 10;
				break;
			default:
				x = x + 20;
				break;
			}
		}	
		return x - 5;
	}
	private void drawSmallString(String s, int x, int y, Graphics g) {
		for(int i = 0; i < s.length(); i++) {
			switch(s.toLowerCase().charAt(i)) {
			case 'a':
				drawSmallA(x, y, g);
				x = x + 4;
				break;
			case 'b':
				drawSmallB(x, y, g);
				x = x + 4;
				break;
			case 'c':
				drawSmallC(x, y, g);
				x = x + 4;
				break;
			case 'd':
				drawSmallD(x, y, g);
				x = x + 4;
				break;
			case 'e':
				drawSmallE(x, y, g);
				x = x + 4;
				break;
			case 'f':
				drawSmallF(x, y, g);
				x = x + 4;
				break;
			case 'g':
				drawSmallG(x, y, g);
				x = x + 4;
				break;
			case 'h':
				drawSmallH(x, y, g);
				x = x + 4;
				break;
			case 'i':
				drawSmallI(x, y, g);
				x = x + 8;
				break;
			case 'j':
				drawSmallJ(x, y, g);
				x = x + 4;
				break;
			case 'k':
				drawSmallK(x, y, g);
				x = x + 4;
				break;
			case 'l':
				drawSmallL(x, y, g);
				x = x + 4;
				break;
			case 'm':
				drawSmallM(x, y, g);
				x = x + 12;
				break;
			case 'n':
				drawSmallN(x, y, g);
				x = x + 4;
				break;
			case 'o':
				drawSmallO(x, y, g);
				x = x + 4;
				break;
			case 'p':
				drawSmallP(x, y, g);
				x = x + 4;
				break;
			case 'q':
				drawSmallQ(x, y, g);
				x = x + 12;
				break;
			case 'r':
				drawSmallR(x, y, g);
				x = x + 4;
				break;
			case 's':
				drawSmallS(x, y, g);
				x = x + 4;
				break;
			case 't':
				drawSmallT(x, y, g);
				x = x + 12;
				break;
			case 'u':
				drawSmallU(x, y, g);
				x = x + 4;
				break;
			case 'v':
				drawSmallV(x, y, g);
				x = x + 4;
				break;
			case 'w':
				drawSmallW(x, y, g);
				x = x + 12;
				break;
			case 'x':
				drawSmallX(x, y, g);
				x = x + 4;
				break;
			case 'y':
				drawSmallY(x, y, g);
				x = x + 12;
				break;
			case 'z':
				drawSmallZ(x, y, g);
				x = x + 4;
				break;
			case '1':
				drawSmall1(x, y, g);
				x = x + 8;
				break;
			case '2':
				drawSmall2(x, y, g);
				x = x + 4;
				break;
			case '3':
				drawSmall3(x, y, g);
				x = x + 4;
				break;
			case '4':
				drawSmall4(x, y, g);
				x = x + 4;
				break;
			case '5':
				drawSmall2(x, y, g);
				x = x + 4;
				break;
			case '6':
				drawSmall6(x, y, g);
				x = x + 4;
				break;
			case '7':
				drawSmall7(x, y, g);
				x = x + 4;
				break;
			case '8':
				drawSmall8(x, y, g);
				x = x + 4;
				break;
			case '9':
				drawSmall9(x, y, g);
				x = x + 4;
				break;
			case '0':
				drawSmall0(x, y, g);
				x = x + 4;
				break;
			case ' ':
				x = x + 8;
				break;
			case ',':
				drawSmallComma(x, y, g);
				x = x + 4;
				break;
			case '.':
				drawSmallPeriod(x, y, g);
				x = x + 4;
				break;
			case '/':
				drawSmallSlash(x, y, g);
				x = x + 14;
				break;
			case '\\':
				drawSmallBackSlash(x, y, g);
				x = x + 14;
				break;
			case ';':
				drawSmallSemmicolen(x, y, g);
				x = x + 4;
				break;
			case '\'':
				drawSmallApostrophi(x, y, g);
				x = x + 4;
				break;
			case '`':
				drawSmallAccentmark(x, y, g);
				x = x + 6;
				break;
			case '[':
				drawSmallBracket(x, y, g);
				x = x + 6; 
				break;
			case ']':
				drawSmallBackBracket(x, y, g);
				x = x + 6;
				break;
			case '-':
				drawSmallDash(x, y, g);
				x = x + 8; 
				break;
			case '=':
				drawSmallEqualsign(x, y, g);
				x = x + 4;
				break;
			default:
				x = x + 8;
				break;
			}
		}	
	}
	private void drawSmallA(int x, int y, Graphics g) {
		g.fillRect(x+ 2, y, 4, 2);
		g.fillRect(x + 6, y+ 2, 2, 4);
		g.fillRect(x, y + 2, 2, 4);	
		g.fillRect(x + 2, y + 6, 4, 2);
	}
	private void drawSmallB(int x, int y, Graphics g) {
		g.fillRect(x + 2, y, 4, 2);
		g.fillRect(x + 6, y + 2, 2, 2);
		g.fillRect(x , y, 2, 12);
		g.fillRect(x + 6, y + 6, 2, 4);
		g.fillRect(x + 2, y + 4, 4, 2);
		g.fillRect(x + 2, y + 4, 4, 2);
	}
	private void drawSmallC(int x, int y, Graphics g) {
		g.fillRect(x + 2, y, 4, 2);
		g.fillRect(x, y + 2, 2, 8);
		g.fillRect(x + 6, y + 2, 2, 2);
		g.fillRect(x + 2, y + 4, 4, 2);
		g.fillRect(x + 6, y + 8, 2, 2);
	}
	private void drawSmallD(int x, int y, Graphics g) {
		g.fillRect(x + 2, y, 4, 2);
		g.fillRect(x + 6, y + 2, 2, 8);
		g.fillRect(x , y, 2, 12);
		g.fillRect(x + 2, y + 4, 4, 2);
	}
	private void drawSmallE(int x, int y, Graphics g) {
		g.fillRect(x + 2, y, 6, 2);
		g.fillRect(x , y, 2, 12);
		g.fillRect(x + 2, y + 4, 6, 2);
		g.fillRect(x + 2, y + 4, 4, 2);
	}
	private void drawSmallF(int x, int y, Graphics g) {
		g.fillRect(x + 2, y, 6, 2);
		g.fillRect(x , y, 2, 12);
		g.fillRect(x + 2, y + 4, 4, 2);
	}
	private void drawSmallG(int x, int y, Graphics g) {
		g.fillRect(x + 2, y, 4, 2);
		g.fillRect(x, y + 2, 2, 8);
		g.fillRect(x + 6, y + 2, 2, 2);
		g.fillRect(x + 2, y + 4, 4, 2);
		g.fillRect(x + 6, y + 6, 2, 4);
		g.fillRect(x + 4, y + 6, 2, 2);
	}
	private void drawSmallH(int x, int y, Graphics g) {
		g.fillRect(x + 2, y + 4, 4, 2);
		g.fillRect(x, y, 2, 12);
		g.fillRect(x + 6, y, 2, 12);
	}
	private void drawSmallI(int x, int y, Graphics g) {
		g.fillRect(x, y, 6, 2);
		g.fillRect(x, y + 4, 6, 2);
		g.fillRect(x + 2, y + 2, 2, 8);
	}
	private void drawSmallJ(int x, int y, Graphics g) {
		g.fillRect(x + 6, y, 2, 4);
		g.fillRect(x, y + 6, 2, 4);
		g.fillRect(x + 2, y + 4, 4, 2);
		
	}
	private void drawSmallK(int x, int y, Graphics g) {
		g.fillRect(x, y, 2, 12);
		g.fillRect(x+6, y, 2,2);
		g.fillRect(x+4, y + 2, 2,2);
		g.fillRect(x+2, y + 4, 2,2);
		g.fillRect(x+4, y + 6, 2,2);
		g.fillRect(x+6, y + 8, 2,4);
	}
	private void drawSmallL(int x, int y, Graphics g) {
		g.fillRect(x, y, 2, 12);
		g.fillRect(x + 2, y + 4, 6, 2);
		
	}
	private void drawSmallM(int x, int y, Graphics g) {
		g.fillRect(x, y, 2, 12);
		g.fillRect(x + 8, y, 2, 12);
		g.fillRect(x+2, y + 2, 2,2);
		g.fillRect(x+4, y + 4, 2,2);
		g.fillRect(x+6, y + 2, 2,2);
	}
	private void drawSmallN(int x, int y, Graphics g) {
		g.fillRect(x, y, 2, 12);
		g.fillRect(x + 6, y, 2, 12);
		g.fillRect(x+2, y + 2, 2,2);
		g.fillRect(x+4, y + 4, 2,2);
	}
	private void drawSmallO(int x, int y, Graphics g) {
		g.fillRect(x+ 2, y, 4, 2);
		g.fillRect(x + 6, y+ 2, 2, 8);
		g.fillRect(x, y + 2, 2, 8);	
		g.fillRect(x + 2, y + 4, 4, 2);
	}
	private void drawSmallP(int x, int y, Graphics g) {
		g.fillRect(x, y, 2, 12);
		g.fillRect(x+ 2, y, 4, 2);
		g.fillRect(x+ 2, y + 6, 4, 2);
		g.fillRect(x+ 6, y + 2, 2, 4);
	}
	private void drawSmallQ(int x, int y, Graphics g) {
		g.fillRect(x+ 2, y, 4, 2);
		g.fillRect(x + 6, y+ 2, 2, 8);
		g.fillRect(x, y + 2, 2, 8);	
		g.fillRect(x + 2, y + 4, 8, 2);
	}
	private void drawSmallR(int x, int y, Graphics g) {
		g.fillRect(x, y, 2, 12);
		g.fillRect(x+ 2, y, 4, 2);
		g.fillRect(x+ 2, y + 6, 4, 2);
		g.fillRect(x+ 6, y + 2, 2, 4);
		g.fillRect(x+ 6, y + 8, 2, 4);
	}
	private void drawSmallS(int x, int y, Graphics g) {
		g.fillRect(x + 2, y, 4, 2);
		g.fillRect(x + 6, y + 2, 2, 2);
		g.fillRect(x + 2, y + 4, 2, 2);
		g.fillRect(x + 4, y + 6, 2, 2);
		g.fillRect(x + 2, y + 4, 4, 2);
		g.fillRect(x + 6, y + 8, 2, 2);
		g.fillRect(x, y + 2, 2, 2);
		g.fillRect(x, y + 8, 2, 2);
	}
	private void drawSmallT(int x, int y, Graphics g) {
		g.fillRect(x, y, 4, 2);
		g.fillRect(x + 4, y + 2, 2, 4);
	}
	private void drawSmallU(int x, int y, Graphics g) {
		g.fillRect(x + 6, y, 2, 4);
		g.fillRect(x, y, 2, 4);	
		g.fillRect(x, y + 4, 8, 2);
	}
	private void drawSmallV(int x, int y, Graphics g) {
		g.fillRect(x + 6, y, 2, 4);
		g.fillRect(x, y, 2, 4);	
		g.fillRect(x + 2, y + 4, 4, 2);
	}
	private void drawSmallW(int x, int y, Graphics g) {
		g.fillRect(x + 8, y, 2, 4);
		g.fillRect(x, y, 2, 4);	
		g.fillRect(x + 2, y + 4, 2, 2);
		g.fillRect(x + 6, y + 4, 2, 2);
		g.fillRect(x + 4, y + 6, 2, 4);
	}
	private void drawSmallX(int x, int y, Graphics g) {
		g.fillRect(x + 6, y, 2, 4);
		g.fillRect(x, y, 2, 4);	
		g.fillRect(x + 6, y + 6, 2, 6);
		g.fillRect(x, y + 6, 2, 6);
		g.fillRect(x + 2, y + 4, 4, 2);
	}
	private void drawSmallY(int x, int y, Graphics g) {
		g.fillRect(x + 8, y, 2, 4);
		g.fillRect(x, y, 2, 4);
		g.fillRect(x + 4, y + 6, 2, 6);
		g.fillRect(x + 2, y + 4, 2, 2);
		g.fillRect(x + 6, y + 4, 2, 2);
	}
	private void drawSmallZ(int x, int y, Graphics g) {
		g.fillRect(x, y, 8, 2);
		g.fillRect(x, y + 4, 8, 2);
		g.fillRect(x + 6, y + 2, 2, 2);
		g.fillRect(x + 4, y + 4, 2, 2);
		g.fillRect(x + 2, y + 6, 2, 2);
		g.fillRect(x, y + 8, 2, 2);
	}
	private void drawSmall1(int x, int y, Graphics g) {
		g.fillRect(x + 4, y, 2, 12);
		g.fillRect(x + 2, y + 2, 2, 2);
		g.fillRect(x, y + 4, 2, 2);
	}
	private void drawSmall2(int x, int y, Graphics g) {
		g.fillRect(x + 2, y, 4, 2);
		g.fillRect(x, y + 2, 2, 2);
		g.fillRect(x + 6, y + 2, 2, 4);
		g.fillRect(x + 2, y + 6, 4, 2);
		g.fillRect(x, y + 8, 2, 2);
		g.fillRect(x, y + 4, 8, 2);
	}
	private void drawSmall3(int x, int y, Graphics g) {
		g.fillRect(x + 2, y, 4, 2);
		g.fillRect(x, y + 2, 2, 2);
		g.fillRect(x + 6, y + 2, 2, 2);
		g.fillRect(x + 4, y + 4, 2, 2);
		g.fillRect(x + 6, y + 6, 2, 4);
		g.fillRect(x + 2, y + 4, 4, 2);
		g.fillRect(x, y + 8, 2, 2);
	}
	private void drawSmall4(int x, int y, Graphics g) {
		g.fillRect(x + 4, y, 2, 2);
		g.fillRect(x + 6, y, 2, 12);
		g.fillRect(x + 2, y + 2, 2, 2);
		g.fillRect(x, y + 4, 2, 2);
		g.fillRect(x, y + 6, 8, 2);
	}
	private void drawSmall5(int x, int y, Graphics g) {
		g.fillRect(x, y, 8, 2);
		g.fillRect(x, y + 2, 2, 2);
		g.fillRect(x, y + 4, 6, 2);
		g.fillRect(x + 6, y + 6, 2, 4);
		g.fillRect(x + 2, y + 4, 4, 2);
		g.fillRect(x, y + 8, 2, 2);
	}
	private void drawSmall6(int x, int y, Graphics g) {
		g.fillRect(x + 2, y, 4, 2);
		g.fillRect(x + 6, y + 2, 2, 2);
		g.fillRect(x, y + 2, 2, 8);
		g.fillRect(x + 2, y + 6, 4, 2);
		g.fillRect(x + 6, y + 8, 2, 2);
		g.fillRect(x + 2, y + 4, 4, 2);
	}
	private void drawSmall7(int x, int y, Graphics g) {
		g.fillRect(x, y, 6, 2);
		g.fillRect(x + 6, y + 2, 2, 2);
		g.fillRect(x + 4, y + 4, 2, 2);
		g.fillRect(x + 2, y + 6, 2, 2);
		g.fillRect(x, y + 8, 2, 4);
	}
	private void drawSmall8(int x, int y, Graphics g) {
		g.fillRect(x + 2, y, 4, 2);
		g.fillRect(x, y + 2, 2, 2);
		g.fillRect(x + 6, y + 2, 2, 2);
		g.fillRect(x + 2, y + 4, 4, 2);
		g.fillRect(x + 6, y + 6, 2, 4);
		g.fillRect(x + 2, y + 4, 4, 2);
		g.fillRect(x, y + 6, 2, 4);
	}
	private void drawSmall9(int x, int y, Graphics g) {
		g.fillRect(x + 2, y, 4, 2);
		g.fillRect(x, y + 2, 2, 2);
		g.fillRect(x + 6, y + 2, 2, 8);
		g.fillRect(x + 2, y + 4, 4, 2);
		g.fillRect(x + 2, y + 4, 4, 2);
		g.fillRect(x, y + 8, 2, 2);
	}
	private void drawSmall0(int x, int y, Graphics g) {
		g.fillRect(x+ 2, y, 4, 2);
		g.fillRect(x + 6, y+ 2, 2, 8);
		g.fillRect(x, y + 2, 2, 8);	
		g.fillRect(x + 2, y + 4, 4, 2);
		g.fillRect(x + 2, y + 6, 2, 2);
		g.fillRect(x + 4, y + 4, 2, 2);
	}
	private void drawSmallUp(int x, int y, Graphics g) {
		g.fillRect(x + 4, y, 2, 12);
		g.fillRect(x + 2, y + 2, 2, 2);
		g.fillRect(x, y + 4, 2, 2);
		g.fillRect(x + 6, y + 2, 2, 2);
		g.fillRect(x + 8, y + 4, 2, 2);
	}
	private void drawSmallRight(int x, int y, Graphics g) {
		g.fillRect(x, y + 4, 12, 2);
		g.fillRect(x + 8, y + 2, 2, 2);
		g.fillRect(x + 6, y, 2, 2);
		g.fillRect(x + 8, y + 6, 2, 2);
		g.fillRect(x + 6, y + 8, 2, 2);
	}
	private void drawSmallDown(int x, int y, Graphics g) {
		g.fillRect(x + 4, y, 2, 12);
		g.fillRect(x + 2, y + 8, 2, 2);
		g.fillRect(x, y + 6, 2, 2);
		g.fillRect(x + 6, y + 8, 2, 2);
		g.fillRect(x + 8, y + 6, 2, 2);
	}
	private void drawSmallLeft(int x, int y, Graphics g) {
		g.fillRect(x, y + 4, 12, 2);
		g.fillRect(x + 2, y + 2, 2, 2);
		g.fillRect(x + 4, y, 2, 2);
		g.fillRect(x + 2, y + 6, 2, 2);
		g.fillRect(x + 4, y + 8, 2, 2);
	}
	private void drawSmallComma(int x, int y, Graphics g) {
		g.fillRect(x, y + 4, 2, 4);
	}
	private void drawSmallPeriod(int x, int y, Graphics g) {
		g.fillRect(x, y + 4, 2, 2);
	}
	private void drawSmallSlash (int x, int y, Graphics g) {
		g.fillRect(x, y + 4, 2, 2);
		g.fillRect(x + 2, y + 8, 2, 2);
		g.fillRect(x + 4, y + 6, 2, 2);
		g.fillRect(x + 6, y + 4, 2, 2);
		g.fillRect(x + 8, y + 2, 2, 2);
		g.fillRect(x + 4, y, 2, 2);
	}
	private void drawSmallSemmicolen(int x, int y, Graphics g) {
		g.fillRect(x, y + 4, 2, 4);
		g.fillRect(x, y + 6, 2, 2);
	}
	private void drawSmallApostrophi(int x, int y, Graphics g) {
		g.fillRect(x, y, 2, 4);
	}
	private void drawSmallAccentmark(int x, int y, Graphics g) {
		g.fillRect(x, y, 2, 2);
		g.fillRect(x + 2, y + 2, 2, 2);
	}
	private void drawSmallBracket(int x, int y, Graphics g) {
		g.fillRect(x,y,2,12);
		g.fillRect(x + 2,y,2,2);
		g.fillRect(x + 2,y + 4,2,2);
	}
	private void drawSmallBackBracket(int x, int y, Graphics g) {
		g.fillRect(x + 2,y,2,12);
		g.fillRect(x,y,2,2);
		g.fillRect(x,y + 4,2,2);
	}
	private void drawSmallBackSlash(int x, int y, Graphics g){
		g.fillRect(x, y, 2, 2);
		g.fillRect(x + 2, y + 2, 2, 2);
		g.fillRect(x + 4, y + 4, 2, 2);
		g.fillRect(x + 6, y + 6, 2, 2);
		g.fillRect(x + 8, y + 8, 2, 2);
		g.fillRect(x + 4, y + 4, 2, 2);
	}
	private void drawSmallDash(int x, int y, Graphics g) {
		g.fillRect(x, y + 4, 6, 2);
	}
	private void drawSmallEqualsign(int x, int y, Graphics g) {
		g.fillRect(x, y + 2, 8, 2);
		g.fillRect(x, y + 8, 8, 2);
	}

	
}

