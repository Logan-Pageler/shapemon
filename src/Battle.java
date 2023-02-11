

/*
 * Author: Andrew Han

 * Date of Completion: lol idk 5-18-2018
 * 
 * 
 * Battle class executes the battle sequence
 * 
 */

import java.awt.*;

import java.awt.image.ImageObserver;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.nio.file.Path;

public class Battle extends JPanel {
	private boolean upPressed = false;
	private boolean leftPressed = false;
	private boolean downPressed = false;
	private boolean rightPressed = false;
	private boolean selectPressed = false;
	private boolean specialMovePressed = false;
	private boolean switchMovePressed = false;
	private boolean upReleased = true;
	private boolean leftReleased = true;
	private boolean downReleased = true;
	private boolean rightReleased = true;
	private boolean specialMoveReleased = true;
	private boolean selectReleased = true;
	private boolean switchMoveReleased = true;
	private int xPlayer = 130;
	private int yPlayer = 310;
	private int xOpponent;
	private int yOpponent;
	private Player player;
	private Player opponent;
	private Shapemon playerShapemonOne, playerShapemonTwo, playerShapemonThree, playerShapemonFour,
			playerShapemonFive, playerShapemonSix;
	private Shapemon opponentShapemonOne, opponentShapemonTwo, opponentShapemonThree, opponentShapemonFour,
			opponentShapemonFive, opponentShapemonSix;
	private Shapemon playerShapemon;
	private Shapemon opponentShapemon;
	private int playerShapemonChoice = 1;
	private int opponentShapemonChoice = 1;
	private ArrayList<Integer> playerBulletX = new ArrayList<Integer>();
	private ArrayList<Integer> playerBulletY = new ArrayList<Integer>();
	private ArrayList<Integer> opponentBulletX = new ArrayList<Integer>();
	private ArrayList<Integer> opponentBulletY = new ArrayList<Integer>();
	private ArrayList<Integer> bulletType = new ArrayList<Integer>();
	private ArrayList<Integer> bulletTypeOpp = new ArrayList<Integer>();
	private int attackPower;
	private int attackPowerOpp;
	private int attackChoice = 1;
	private int attackChoiceOpp = 1;
	private int captureChoice = 1;
	private int frame = 0;
	private int timer;
	private int timerOpp;
	private int expFlashCounter;
	private int specialCounter;
	private int specialCounterOpp;
	private int spMoveCounterPlayer;
	private int spMoveCounterOpponent;
	private int spMoveCDPlayer;
	private int spMoveCDOpponent;
	private int caughtTimer;
	private int oneSecondTimer;
	private int oneSecondTimerOpp;
	private boolean wild = false;
	private boolean battling = false;
	private boolean playerWins = false;
	private boolean shot = false;
	private boolean oppShot = false;
	private boolean hit = false;
	private boolean oppHit = false;
	private boolean died = false;
	private boolean leveledUp = false;
	private boolean specialReady = false;
	private boolean specialReadyOpp = false;
	private boolean selected;
	private boolean selectionDone = true;
	private boolean failedCatch;
	private boolean caught;
	private boolean addedShapecubes = false;
	private AIMovement aiCoords = new AIMovement();
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
	private Image playerBullet1 = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "PlayerBullet1.gif").toString()).getImage());
	private Image playerBullet2 = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "PlayerBullet2.gif").toString()).getImage());
	private Image playerBullet3 = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "PlayerBullet3.gif").toString()).getImage());
	private Image playerBullet4 = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "PlayerBullet4.gif").toString()).getImage());
	private Image playerBullet5 = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "PlayerBullet5.gif").toString()).getImage());
	private Image playerBullet6 = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "PlayerBullet6.gif").toString()).getImage());
	private Image playerBullet7Nyan = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "PlayerBulletNyan.gif").toString()).getImage());
	private Image playerBullet8Pacman = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "PlayerBulletPacman.gif").toString()).getImage());
	private Image playerBullet9Slash = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "PlayerBullet9.gif").toString()).getImage());
	private Image playerBullet10Swim = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "PlayerBullet10.gif").toString()).getImage());
	private Image playerBullet11Smash = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "PlayerBullet11.gif").toString()).getImage());
	private Image opponentBullet1 = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "OpponentBullet1.gif").toString()).getImage());
	private Image opponentBullet2 = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "OpponentBullet2.gif").toString()).getImage());
	private Image opponentBullet3 = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "OpponentBullet3.gif").toString()).getImage());
	private Image opponentBullet4 = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "OpponentBullet4.gif").toString()).getImage());
	private Image opponentBullet5 = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "OpponentBullet5.gif").toString()).getImage());
	private Image opponentBullet6 = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "OpponentBullet6.gif").toString()).getImage());
	private Image opponentBullet7Nyan = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "OpponentBulletNyan.gif").toString()).getImage());
	private Image opponentBullet8Pacman = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "OpponentBulletPacman.gif").toString()).getImage());
	private Image opponentBullet9Slash = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "OpponentBullet9.gif").toString()).getImage());
	private Image opponentBullet10Swim = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "OpponentBullet10.gif").toString()).getImage());
	private Image opponentBullet11Smash = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "OpponentBullet11.gif").toString()).getImage());
	private Image bulletSpecialCircle = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "BulletSpecialCircle.gif").toString()).getImage());
	private Image bulletSpecialPacman = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "BulletSpecialPacman.gif").toString()).getImage());
	private Image playerBulletSpecialTriangle = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "PlayerBulletSpecialTriangle.gif").toString()).getImage());
	private Image opponentBulletSpecialTriangle = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "OpponentBulletSpecialTriangle.gif").toString()).getImage());
	private Image bulletSpecialSquare = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "BulletSpecialSquare.gif").toString()).getImage());
	private Image playerBulletSpecialPentagon = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "PlayerBulletSpecialPentagon.gif").toString()).getImage());
	private Image opponentBulletSpecialPentagon = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "OpponentBulletSpecialPentagon.gif").toString()).getImage());
	private Image playerBulletSpecialHexagon = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "PlayerBulletSpecialHexagon.gif").toString()).getImage());
	private Image opponentBulletSpecialHexagon = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "OpponentBulletSpecialHexagon.gif").toString()).getImage());
	private Image bulletSpecialOctagon = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "BulletSpecialOctagon.gif").toString()).getImage());
	private Image playerBulletSpecialStar = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "PlayerBulletSpecialStar.gif").toString()).getImage());
	private Image opponentBulletSpecialStar = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "OpponentBulletSpecialStar.gif").toString()).getImage());
	private Image bulletSpecialNyan = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "BulletSpecialNyan.gif").toString()).getImage());
	private Image background = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "Background.gif").toString()).getImage());
	private Image battleButtonG = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "BattleButtonG.gif").toString()).getImage());
	private Image battleButtonY = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "BattleButtonY.gif").toString()).getImage());
	private Image shapeCube = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "ShapeCube.gif").toString()).getImage());
	private Image shapeCube2 = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "ShapeCube2.gif").toString()).getImage());
	private Image shapeCube3 = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "ShapeCube3.gif").toString()).getImage());
	private Image shapeCube4 = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "ShapeCube4.gif").toString()).getImage());
	private Image shapeCubeSwitching = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "ShapeCubeSwitching.gif").toString()).getImage());
	private Image shapeCubeDead = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "ShapeCubeDead.gif").toString()).getImage());
	private Image shapeCubeEmpty = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "ShapeCubeEmpty.gif").toString()).getImage());
	private Image deathIcon = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "DeathIcon.gif").toString()).getImage());
	private Image levelUpBar = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "LevelUpBar.gif").toString()).getImage());
	private Image specialBar = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "SpecialBar.gif").toString()).getImage());
	private Image defeatedBackground = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "DefeatedBackground.gif").toString()).getImage());
	private Image trainerDefeatedBackground = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "TrainerDefeatedBackground.gif").toString()).getImage());
	private Image captureButtonG = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "CaptureButtonG.gif").toString()).getImage());
	private Image captureButtonY = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "CaptureButtonY.gif").toString()).getImage());
	private Image OK = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "OK.gif").toString()).getImage());
	private Image shapeCubeBackground = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "ShapeCubeBackground.gif").toString()).getImage());
	private Image leftArrow = (new ImageIcon(Paths.get(currentPath.toString(), "assets",  "LeftArrow.gif").toString()).getImage());
	private ImageObserver IO;
	private static File shotSound = new File("ShotSound.wav");

	public Battle() {
	}

	// paints everything
	public void paintComponent(Graphics g) {
		shot = false;
		oppShot = false;
		hit = false;
		oppHit = false;
		died = false;
		if (frame < 180) {
			g.drawImage(background, 0, 0, 720, 720, IO);

			// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			// Opponent stat box
			g.setColor(Color.DARK_GRAY);
			g.fillRect(360, 0, 360, 105);
			g.fillRect(335 - getLength(opponentShapemon.getName()), 0,
					25 + getLength(opponentShapemon.getName()), 70);
			if (!wild) {
				if (!opponentShapemonOne.isDead()) {
					g.drawImage(shapeCube, 380, 25, 25, 25, IO);
				} else if (opponentShapemonOne.isDead()) {
					g.drawImage(shapeCubeDead, 380, 25, 25, 25, IO);
				}
				if (opponentShapemonTwo == null) {
					g.drawImage(shapeCubeEmpty, 410, 25, 25, 25, IO);
				} else if (!opponentShapemonTwo.isDead()) {
					g.drawImage(shapeCube, 410, 25, 25, 25, IO);
				} else if (opponentShapemonTwo.isDead()) {
					g.drawImage(shapeCubeDead, 410, 25, 25, 25, IO);
				}
				if (opponentShapemonThree == null) {
					g.drawImage(shapeCubeEmpty, 440, 25, 25, 25, IO);
				} else if (!opponentShapemonThree.isDead()) {
					g.drawImage(shapeCube, 440, 25, 25, 25, IO);
				} else if (opponentShapemonThree.isDead()) {
					g.drawImage(shapeCubeDead, 440, 25, 25, 25, IO);
				}
				if (opponentShapemonFour == null) {
					g.drawImage(shapeCubeEmpty, 470, 25, 25, 25, IO);
				} else if (!opponentShapemonFour.isDead()) {
					g.drawImage(shapeCube, 470, 25, 25, 25, IO);
				} else if (opponentShapemonFour.isDead()) {
					g.drawImage(shapeCubeDead, 470, 25, 25, 25, IO);
				}
				if (opponentShapemonFive == null) {
					g.drawImage(shapeCubeEmpty, 500, 25, 25, 25, IO);
				} else if (!opponentShapemonFive.isDead()) {
					g.drawImage(shapeCube, 500, 25, 25, 25, IO);
				} else if (opponentShapemonFive.isDead()) {
					g.drawImage(shapeCubeDead, 500, 25, 25, 25, IO);
				}
				if (opponentShapemonSix == null) {
					g.drawImage(shapeCubeEmpty, 530, 25, 25, 25, IO);
				} else if (!opponentShapemonSix.isDead()) {
					g.drawImage(shapeCube, 530, 25, 25, 25, IO);
				} else if (opponentShapemonSix.isDead()) {
					g.drawImage(shapeCubeDead, 530, 25, 25, 25, IO);
				}
			}

			g.setColor(Color.GREEN);
			g.fillRect(435, 55, ((opponentShapemon.getHealth() * 265 / opponentShapemon.getMaxHealth())),
					30);

			g.setColor(Color.WHITE);
			drawH(380, 55, g);
			drawP(405, 55, g);
			g.drawRect(435, 55, 265, 30);
			drawString("lv" + opponentShapemon.getLevel(),
					700 - getLength("lv" + opponentShapemon.getLevel()), 20, g);
			drawString(opponentShapemon.getName().toLowerCase(),
					355 - getLength(opponentShapemon.getName()), 20, g);

			// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			// Player stat box
			g.setColor(Color.DARK_GRAY);
			g.fillRect(0, 560 - 15, 360, 140 + 15);
			g.fillRect(360, 560 - 15, getLength(playerShapemon.getName()) + 25, 70);
			if (!playerShapemonOne.isDead()) {
				g.drawImage(shapeCube, 20, 585 - 15, 25, 25, IO);
			} else if (playerShapemonOne.isDead()) {
				g.drawImage(shapeCubeDead, 20, 585 - 15, 25, 25, IO);
			}
			if (playerShapemonTwo == null) {
				g.drawImage(shapeCubeEmpty, 50, 585 - 15, 25, 25, IO);
			} else if (!playerShapemonTwo.isDead()) {
				g.drawImage(shapeCube, 50, 585 - 15, 25, 25, IO);
			} else if (playerShapemonTwo.isDead()) {
				g.drawImage(shapeCubeDead, 50, 585 - 15, 25, 25, IO);
			}
			if (playerShapemonThree == null) {
				g.drawImage(shapeCubeEmpty, 80, 585 - 15, 25, 25, IO);
			} else if (!playerShapemonThree.isDead()) {
				g.drawImage(shapeCube, 80, 585 - 15, 25, 25, IO);
			} else if (playerShapemonThree.isDead()) {
				g.drawImage(shapeCubeDead, 80, 585 - 15, 25, 25, IO);
			}
			if (playerShapemonFour == null) {
				g.drawImage(shapeCubeEmpty, 110, 585 - 15, 25, 25, IO);
			} else if (!playerShapemonFour.isDead()) {
				g.drawImage(shapeCube, 110, 585 - 15, 25, 25, IO);
			} else if (playerShapemonFour.isDead()) {
				g.drawImage(shapeCubeDead, 110, 585 - 15, 25, 25, IO);
			}
			if (playerShapemonFive == null) {
				g.drawImage(shapeCubeEmpty, 140, 585 - 15, 25, 25, IO);
			} else if (!playerShapemonFive.isDead()) {
				g.drawImage(shapeCube, 140, 585 - 15, 25, 25, IO);
			} else if (playerShapemonFive.isDead()) {
				g.drawImage(shapeCubeDead, 140, 585 - 15, 25, 25, IO);
			}
			if (playerShapemonSix == null) {
				g.drawImage(shapeCubeEmpty, 170, 585 - 15, 25, 25, IO);
			} else if (!playerShapemonSix.isDead()) {
				g.drawImage(shapeCube, 170, 585 - 15, 25, 25, IO);
			} else if (playerShapemonSix.isDead()) {
				g.drawImage(shapeCubeDead, 170, 585 - 15, 25, 25, IO);
			}

			g.setColor(Color.GREEN);
			g.fillRect(75, 615 - 15, (playerShapemon.getHealth() * 265 / playerShapemon.getMaxHealth()),
					30);

			g.setColor(Color.CYAN);
			if (playerShapemon.getExp() >= playerShapemon.getExpReq()) {
				g.fillRect(75, 695 - 15, 265, 5);
			} else {
				g.fillRect(75, 695 - 15, (playerShapemon.getExp() * 265 / playerShapemon.getExpReq()),
						5);
			}
			if (leveledUp && expFlashCounter < 35) {
				g.setColor(Color.DARK_GRAY);
				g.fillRect(75, 695 - 15, 265, 5);
				g.drawImage(levelUpBar, 75, 695 - 15, 265, 5, IO);
				expFlashCounter++;
			} else {
				leveledUp = false;
				expFlashCounter = 0;
			}

			g.setColor(Color.ORANGE);
			g.fillRect(370, 680, specialCounter * 330 / 1200, 5);

			g.setColor(Color.WHITE);
			drawH(20, 615 - 15, g);
			drawP(45, 615 - 15, g);
			g.drawRect(75, 615 - 15, 265, 30);
			g.drawRect(75, 680, 265, 5);
			g.drawRect(370, 680, 330, 5);
			drawString("lv" + playerShapemon.getLevel(), 340 - getLength("lv" + playerShapemon.getLevel()),
					580 - 15, g);
			drawString(playerShapemon.getName().toLowerCase(), 365, 580 - 15, g);
			drawString(playerShapemon.getHealth() + "/" + playerShapemon.getMaxHealth(), 75, 650 - 15, g);

			if (attackChoice == 1) {
				g.drawImage(battleButtonY, 370, 640 - 15, 160, 50, IO);
			} else {
				g.drawImage(battleButtonG, 370, 640 - 15, 160, 50, IO);
			}
			if (attackChoice == 2) {
				g.drawImage(battleButtonY, 540, 640 - 15, 160, 50, IO);
			} else {
				g.drawImage(battleButtonG, 540, 640 - 15, 160, 50, IO);
			}
			g.setColor(Color.BLACK);
			drawString("Move 1", 380, 650 - 15, g);
			if (playerShapemon.getMoveTwo() != 0) {
				drawString("Move 2", 550, 650 - 15, g);
			} else {
				drawString("n/a", 580, 650 - 15, g);
			}

			// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			// Player and opponent

			xOpponent = aiCoords.getX();
			yOpponent = aiCoords.getY();
			switch (playerShapemon.getTypeOfShapemon()) {
				case 1:
					g.drawImage(circle, xPlayer, yPlayer, 100, 100, IO);
					break;
				case 2:
					g.drawImage(pacman, xPlayer, yPlayer, 100, 100, IO);
					break;
				case 3:
					g.drawImage(triangle, xPlayer, yPlayer, 100, 100, IO);
					break;
				case 4:
					g.drawImage(square, xPlayer, yPlayer, 100, 100, IO);
					break;
				case 5:
					g.drawImage(pentagon, xPlayer, yPlayer, 100, 100, IO);
					break;
				case 6:
					g.drawImage(hexagon, xPlayer, yPlayer, 100, 100, IO);
					break;
				case 8:
					g.drawImage(octagon, xPlayer, yPlayer, 100, 100, IO);
					break;
				case 10:
					g.drawImage(star, xPlayer, yPlayer, 100, 100, IO);
					break;
				case 69:
					g.drawImage(nyan, xPlayer, yPlayer, 100, 100, IO);
					break;
			}
			switch (opponentShapemon.getTypeOfShapemon()) {
				case 1:
					g.drawImage(circle, xOpponent, yOpponent, 100, 100, IO);
					break;
				case 2:
					g.drawImage(oppPacman, xOpponent, yOpponent, 100, 100, IO);
					break;
				case 3:
					g.drawImage(oppTriangle, xOpponent, yOpponent, 100, 100, IO);
					break;
				case 4:
					g.drawImage(square, xOpponent, yOpponent, 100, 100, IO);
					break;
				case 5:
					g.drawImage(pentagon, xOpponent, yOpponent, 100, 100, IO);
					break;
				case 6:
					g.drawImage(hexagon, xOpponent, yOpponent, 100, 100, IO);
					break;
				case 8:
					g.drawImage(octagon, xOpponent, yOpponent, 100, 100, IO);
					break;
				case 10:
					g.drawImage(star, xOpponent, yOpponent, 100, 100, IO);
					break;
				case 69:
					g.drawImage(oppNyan, xOpponent, yOpponent, 100, 100, IO);
					break;
			}

			g.setColor(Color.WHITE);
			if (frame < 60) {
				draw3(350, 345, g);
			} else if (frame < 120) {
				draw2(350, 345, g);
			} else if (frame < 280) {
				draw1(350, 345, g);
			}
			// draws 3,2,1
			frame++;

		} else if (battling) {
			int playerNumberOfShapemon = getNumberOfShapemon(playerShapemonOne, playerShapemonTwo,
					playerShapemonThree, playerShapemonFour, playerShapemonFive, playerShapemonSix);
			int opponentNumberOfShapemon = getNumberOfShapemon(opponentShapemonOne, opponentShapemonTwo,
					opponentShapemonThree, opponentShapemonFour, opponentShapemonFive,
					opponentShapemonSix);
			if (oneSecondTimer > 0 && oneSecondTimer < 60) {
				oneSecondTimer++;
			} else if (oneSecondTimer == 60) {
				oneSecondTimer = 0;
			}
			if (playerShapemon.isDead()) {
				oneSecondTimer++;
				died = true;
				specialCounter = 0;
				playerShapemonChoice++;
				// switches shapemon
				switch (playerShapemonChoice) {
					case 2:
						if (playerShapemonTwo != null)
							playerShapemon = playerShapemonTwo;
						break;
					case 3:
						if (playerShapemonThree != null)
							playerShapemon = playerShapemonThree;
						break;
					case 4:
						if (playerShapemonFour != null)
							playerShapemon = playerShapemonFour;
						break;
					case 5:
						if (playerShapemonFive != null)
							playerShapemon = playerShapemonFive;
						break;
					case 6:
						if (playerShapemonSix != null)
							playerShapemon = playerShapemonSix;
						break;
				}
				// if no more shpameonleft
				if (playerNumberOfShapemon == 0) {
					for (int i = 0; i < playerBulletX.size(); i++) {
						playerBulletX.remove(0);
					}
					for (int i = 0; i < playerBulletY.size(); i++) {
						playerBulletY.remove(0);
					}
					for (int i = 0; i < bulletType.size(); i++) {
						bulletType.remove(0);
					}
					for (int i = 0; i < opponentBulletX.size(); i++) {
						opponentBulletX.remove(0);
					}
					for (int i = 0; i < opponentBulletY.size(); i++) {
						opponentBulletY.remove(0);
					}
					for (int i = 0; i < bulletTypeOpp.size(); i++) {
						bulletTypeOpp.remove(0);
					}
					playerWins = false;
					battling = false;
				}
			}
			if (oneSecondTimerOpp > 0 && oneSecondTimerOpp < 60) {
				oneSecondTimerOpp++;
			} else if (oneSecondTimerOpp == 60) {
				oneSecondTimerOpp = 0;
			}
			if (opponentShapemon.isDead()) {
				// switches opponent shapemon
				oneSecondTimerOpp = 1;
				playerShapemon.addExp(opponentShapemon);
				if (specialCounterOpp > 300) {
					specialCounterOpp = specialCounterOpp - 300;
				}
				died = true;
				opponentShapemonChoice++;
				switch (opponentShapemonChoice) {
					case 2:
						if (opponentShapemonTwo != null)
							opponentShapemon = opponentShapemonTwo;
						break;
					case 3:
						if (opponentShapemonThree != null)
							opponentShapemon = opponentShapemonThree;
						break;
					case 4:
						if (opponentShapemonFour != null)
							opponentShapemon = opponentShapemonFour;
						break;
					case 5:
						if (opponentShapemonFive != null)
							opponentShapemon = opponentShapemonFive;
						break;
					case 6:
						if (opponentShapemonSix != null)
							opponentShapemon = opponentShapemonSix;
						break;
				}
				if (opponentNumberOfShapemon == 0) {
					// if no more shapemonleft
					for (int i = 0; i < playerBulletX.size(); i++) {
						playerBulletX.remove(0);
					}
					for (int i = 0; i < playerBulletY.size(); i++) {
						playerBulletY.remove(0);
					}
					for (int i = 0; i < bulletType.size(); i++) {
						bulletType.remove(0);
					}
					for (int i = 0; i < opponentBulletX.size(); i++) {
						opponentBulletX.remove(0);
					}
					for (int i = 0; i < opponentBulletY.size(); i++) {
						opponentBulletY.remove(0);
					}
					for (int i = 0; i < bulletTypeOpp.size(); i++) {
						bulletTypeOpp.remove(0);
					}
					playerWins = true;
					battling = false;
				}
			}
			if (playerShapemon.getExp() >= playerShapemon.getExpReq()) {
				playerShapemon.levelUp();
				if (playerShapemon.getLevel() != 100) {
					leveledUp = true;
					expFlashCounter = 0;
				}
			}

			g.drawImage(background, 0, 0, 720, 720, IO);

			// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			// Opponent stat box
			g.setColor(Color.DARK_GRAY);
			g.fillRect(360, 0, 360, 105);
			g.fillRect(335 - getLength(opponentShapemon.getName()), 0,
					25 + getLength(opponentShapemon.getName()), 70);
			if (!wild) {
				if (!opponentShapemonOne.isDead()) {
					g.drawImage(shapeCube, 380, 25, 25, 25, IO);
				} else if (opponentShapemonOne.isDead()) {
					g.drawImage(shapeCubeDead, 380, 25, 25, 25, IO);
				}
				if (opponentShapemonTwo == null) {
					g.drawImage(shapeCubeEmpty, 410, 25, 25, 25, IO);
				} else if (!opponentShapemonTwo.isDead()) {
					g.drawImage(shapeCube, 410, 25, 25, 25, IO);
				} else if (opponentShapemonTwo.isDead()) {
					g.drawImage(shapeCubeDead, 410, 25, 25, 25, IO);
				}
				if (opponentShapemonThree == null) {
					g.drawImage(shapeCubeEmpty, 440, 25, 25, 25, IO);
				} else if (!opponentShapemonThree.isDead()) {
					g.drawImage(shapeCube, 440, 25, 25, 25, IO);
				} else if (opponentShapemonThree.isDead()) {
					g.drawImage(shapeCubeDead, 440, 25, 25, 25, IO);
				}
				if (opponentShapemonFour == null) {
					g.drawImage(shapeCubeEmpty, 470, 25, 25, 25, IO);
				} else if (!opponentShapemonFour.isDead()) {
					g.drawImage(shapeCube, 470, 25, 25, 25, IO);
				} else if (opponentShapemonFour.isDead()) {
					g.drawImage(shapeCubeDead, 470, 25, 25, 25, IO);
				}
				if (opponentShapemonFive == null) {
					g.drawImage(shapeCubeEmpty, 500, 25, 25, 25, IO);
				} else if (!opponentShapemonFive.isDead()) {
					g.drawImage(shapeCube, 500, 25, 25, 25, IO);
				} else if (opponentShapemonFive.isDead()) {
					g.drawImage(shapeCubeDead, 500, 25, 25, 25, IO);
				}
				if (opponentShapemonSix == null) {
					g.drawImage(shapeCubeEmpty, 530, 25, 25, 25, IO);
				} else if (!opponentShapemonSix.isDead()) {
					g.drawImage(shapeCube, 530, 25, 25, 25, IO);
				} else if (opponentShapemonSix.isDead()) {
					g.drawImage(shapeCubeDead, 530, 25, 25, 25, IO);
				}
			}

			// hp bar
			g.setColor(Color.GREEN);
			g.fillRect(435, 55, ((opponentShapemon.getHealth() * 265 / opponentShapemon.getMaxHealth())),
					30);

			g.setColor(Color.WHITE);
			drawH(380, 55, g);
			drawP(405, 55, g);
			g.drawRect(435, 55, 265, 30);
			drawString("lv" + opponentShapemon.getLevel(),
					700 - getLength("lv" + opponentShapemon.getLevel()), 20, g);
			drawString(opponentShapemon.getName().toLowerCase(),
					355 - getLength(opponentShapemon.getName()), 20, g);
			if (specialCounterOpp < 1200) {
				specialCounterOpp++;

			}
			if (specialCounterOpp >= 1200) {
				specialReadyOpp = true;
			}

			// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			// Player stat box
			g.setColor(Color.DARK_GRAY);
			g.fillRect(0, 560 - 15, 360, 140 + 15);
			g.fillRect(360, 560 - 15, getLength(playerShapemon.getName()) + 25, 70);
			if (!playerShapemonOne.isDead()) {
				g.drawImage(shapeCube, 20, 585 - 15, 25, 25, IO);
			} else if (playerShapemonOne.isDead()) {
				g.drawImage(shapeCubeDead, 20, 585 - 15, 25, 25, IO);
			}
			if (playerShapemonTwo == null) {
				g.drawImage(shapeCubeEmpty, 50, 585 - 15, 25, 25, IO);
			} else if (!playerShapemonTwo.isDead()) {
				g.drawImage(shapeCube, 50, 585 - 15, 25, 25, IO);
			} else if (playerShapemonTwo.isDead()) {
				g.drawImage(shapeCubeDead, 50, 585 - 15, 25, 25, IO);
			}
			if (playerShapemonThree == null) {
				g.drawImage(shapeCubeEmpty, 80, 585 - 15, 25, 25, IO);
			} else if (!playerShapemonThree.isDead()) {
				g.drawImage(shapeCube, 80, 585 - 15, 25, 25, IO);
			} else if (playerShapemonThree.isDead()) {
				g.drawImage(shapeCubeDead, 80, 585 - 15, 25, 25, IO);
			}
			if (playerShapemonFour == null) {
				g.drawImage(shapeCubeEmpty, 110, 585 - 15, 25, 25, IO);
			} else if (!playerShapemonFour.isDead()) {
				g.drawImage(shapeCube, 110, 585 - 15, 25, 25, IO);
			} else if (playerShapemonFour.isDead()) {
				g.drawImage(shapeCubeDead, 110, 585 - 15, 25, 25, IO);
			}
			if (playerShapemonFive == null) {
				g.drawImage(shapeCubeEmpty, 140, 585 - 15, 25, 25, IO);
			} else if (!playerShapemonFive.isDead()) {
				g.drawImage(shapeCube, 140, 585 - 15, 25, 25, IO);
			} else if (playerShapemonFive.isDead()) {
				g.drawImage(shapeCubeDead, 140, 585 - 15, 25, 25, IO);
			}
			if (playerShapemonSix == null) {
				g.drawImage(shapeCubeEmpty, 170, 585 - 15, 25, 25, IO);
			} else if (!playerShapemonSix.isDead()) {
				g.drawImage(shapeCube, 170, 585 - 15, 25, 25, IO);
			} else if (playerShapemonSix.isDead()) {
				g.drawImage(shapeCubeDead, 170, 585 - 15, 25, 25, IO);
			}

			// health bar
			g.setColor(Color.GREEN);
			g.fillRect(75, 615 - 15, (playerShapemon.getHealth() * 265 / playerShapemon.getMaxHealth()),
					30);

			// exp bar
			g.setColor(Color.CYAN);
			if (playerShapemon.getExp() >= playerShapemon.getExpReq()) {
				g.fillRect(75, 695 - 15, 265, 5);
			} else {
				g.fillRect(75, 695 - 15, (playerShapemon.getExp() * 265 / playerShapemon.getExpReq()),
						5);
			}
			if (leveledUp && expFlashCounter < 35) {
				g.setColor(Color.DARK_GRAY);
				g.fillRect(75, 695 - 15, 265, 5);
				g.drawImage(levelUpBar, 75, 695 - 15, 265, 5, IO);
				expFlashCounter++;
			} else {
				leveledUp = false;
				expFlashCounter = 0;
			}

			// special bar
			g.setColor(Color.ORANGE);
			if (specialCounter < 1200) {
				specialCounter++;
			}
			g.fillRect(370, 680, specialCounter * 330 / 1200, 5);
			if (specialCounter >= 1200) {
				g.setColor(new Color(112, 200, 160));
				g.fillRect(370, 680, 330, 5);
				g.drawImage(specialBar, 370, 680, 330, 5, IO);
				specialReady = true;
			}

			g.setColor(Color.WHITE);
			drawH(20, 615 - 15, g);
			drawP(45, 615 - 15, g);
			g.drawRect(75, 615 - 15, 265, 30);
			g.drawRect(75, 680, 265, 5);
			g.drawRect(370, 680, 330, 5);
			drawString("lv" + playerShapemon.getLevel(), 340 - getLength("lv" + playerShapemon.getLevel()),
					580 - 15, g);
			drawString(playerShapemon.getName().toLowerCase(), 365, 580 - 15, g);
			drawString(playerShapemon.getHealth() + "/" + playerShapemon.getMaxHealth(), 75, 650 - 15, g);

			if (attackChoice == 1) {
				g.drawImage(battleButtonY, 370, 640 - 15, 160, 50, IO);
			} else {
				g.drawImage(battleButtonG, 370, 640 - 15, 160, 50, IO);
			}
			if (attackChoice == 2) {
				g.drawImage(battleButtonY, 540, 640 - 15, 160, 50, IO);
			} else {
				g.drawImage(battleButtonG, 540, 640 - 15, 160, 50, IO);
			}
			g.setColor(Color.BLACK);
			drawString("Move 1", 380, 650 - 15, g);
			if (playerShapemon.getMoveTwo() != 0) {
				drawString("Move 2", 550, 650 - 15, g);
			} else {
				drawString("n/a", 580, 650 - 15, g);
			}

			// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			// Player and opponent

			xOpponent = aiCoords.getX();
			yOpponent = aiCoords.getY();
			switch (playerShapemon.getTypeOfShapemon()) {
				case 1:
					g.drawImage(circle, xPlayer, yPlayer, 100, 100, IO);
					break;
				case 2:
					g.drawImage(pacman, xPlayer, yPlayer, 100, 100, IO);
					break;
				case 3:
					g.drawImage(triangle, xPlayer, yPlayer, 100, 100, IO);
					break;
				case 4:
					g.drawImage(square, xPlayer, yPlayer, 100, 100, IO);
					break;
				case 5:
					g.drawImage(pentagon, xPlayer, yPlayer, 100, 100, IO);
					break;
				case 6:
					g.drawImage(hexagon, xPlayer, yPlayer, 100, 100, IO);
					break;
				case 8:
					g.drawImage(octagon, xPlayer, yPlayer, 100, 100, IO);
					break;
				case 10:
					g.drawImage(star, xPlayer, yPlayer, 100, 100, IO);
					break;
				case 69:
					g.drawImage(nyan, xPlayer, yPlayer, 100, 100, IO);
					break;
			}
			if (oneSecondTimer > 0 && oneSecondTimer < 60) {
				g.drawImage(shapeCubeSwitching, xPlayer + 25, yPlayer + 25, 50, 50, IO);
			}
			switch (opponentShapemon.getTypeOfShapemon()) {
				case 1:
					g.drawImage(circle, xOpponent, yOpponent, 100, 100, IO);
					break;
				case 2:
					g.drawImage(oppPacman, xOpponent, yOpponent, 100, 100, IO);
					break;
				case 3:
					g.drawImage(oppTriangle, xOpponent, yOpponent, 100, 100, IO);
					break;
				case 4:
					g.drawImage(square, xOpponent, yOpponent, 100, 100, IO);
					break;
				case 5:
					g.drawImage(pentagon, xOpponent, yOpponent, 100, 100, IO);
					break;
				case 6:
					g.drawImage(hexagon, xOpponent, yOpponent, 100, 100, IO);
					break;
				case 8:
					g.drawImage(octagon, xOpponent, yOpponent, 100, 100, IO);
					break;
				case 10:
					g.drawImage(star, xOpponent, yOpponent, 100, 100, IO);
					break;
				case 69:
					g.drawImage(oppNyan, xOpponent, yOpponent, 100, 100, IO);
					break;
			}
			if (oneSecondTimerOpp > 0 && oneSecondTimerOpp < 60) {
				g.drawImage(shapeCubeSwitching, xOpponent + 25, yOpponent + 25, 50, 50, IO);
			}

			aiCoords.direction(aiCoords.changeDirection());
			// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			// draw, move, remove bullets
			for (int i = 0; i < playerBulletX.size(); i++) {

				switch (Integer.parseInt(bulletType.get(i).toString())) {
					case 1:
						playerBulletX.set(i,
								playerBulletX.get(i) + 5);
						g.drawImage(playerBullet1,
								playerBulletX.get(i),
								playerBulletY.get(i), 30,
								20, IO);
						break;
					case 2:
						playerBulletX.set(i,
								playerBulletX.get(i) + 5);
						g.drawImage(playerBullet2,
								playerBulletX.get(i),
								playerBulletY.get(i), 30,
								20, IO);
						break;
					case 3:
						playerBulletX.set(i,
								playerBulletX.get(i) + 6);
						g.drawImage(playerBullet3,
								playerBulletX.get(i),
								playerBulletY.get(i), 30,
								20, IO);
						break;
					case 4:
						playerBulletX.set(i,
								playerBulletX.get(i) + 6);
						g.drawImage(playerBullet4,
								playerBulletX.get(i),
								playerBulletY.get(i), 30,
								20, IO);
						break;
					case 5:
						playerBulletX.set(i,
								playerBulletX.get(i) + 7);
						g.drawImage(playerBullet5,
								playerBulletX.get(i),
								playerBulletY.get(i), 30,
								20, IO);
						break;
					case 6:
						playerBulletX.set(i,
								playerBulletX.get(i) + 7);
						g.drawImage(playerBullet6,
								playerBulletX.get(i),
								playerBulletY.get(i), 30,
								20, IO);
						break;
					case 7:
						playerBulletX.set(i,
								playerBulletX.get(i) + 6);
						g.drawImage(playerBullet7Nyan,
								playerBulletX.get(i),
								playerBulletY.get(i), 30,
								20, IO);
						break;
					case 8:
						playerBulletX.set(i,
								playerBulletX.get(i) + 5);
						g.drawImage(playerBullet8Pacman,
								playerBulletX.get(i),
								playerBulletY.get(i), 30,
								20, IO);
						break;
					case 9:
						playerBulletX.set(i,
								playerBulletX.get(i) + 10);
						g.drawImage(playerBullet9Slash,
								playerBulletX.get(i),
								playerBulletY.get(i), 30,
								20, IO);
						break;
					case 10:
						playerBulletX.set(i,
								playerBulletX.get(i) + 7);
						g.drawImage(playerBullet10Swim,
								playerBulletX.get(i),
								playerBulletY.get(i), 30,
								20, IO);
						break;
					case 11:
						playerBulletX.set(i,
								playerBulletX.get(i) + 5);
						g.drawImage(playerBullet11Smash,
								playerBulletX.get(i),
								playerBulletY.get(i), 30,
								20, IO);
						break;
					case 101:
						playerBulletX.set(i,
								playerBulletX.get(i) + 5);
						g.drawImage(circle, playerBulletX.get(i),
								playerBulletY.get(i), 30,
								30, IO);
						break;
					case 102:
						playerBulletX.set(i,
								playerBulletX.get(i) + 3);
						g.drawImage(playerBullet8Pacman,
								playerBulletX.get(i),
								playerBulletY.get(i), 350,
								250, IO);
						break;
					case 103:
						playerBulletX.set(i,
								playerBulletX.get(i) + 5);
						g.drawImage(playerBulletSpecialTriangle,
								playerBulletX.get(i),
								playerBulletY.get(i), 30,
								30, IO);
						break;
					case 104:
						playerBulletX.set(i,
								playerBulletX.get(i) + 2);
						g.drawImage(bulletSpecialSquare,
								playerBulletX.get(i),
								playerBulletY.get(i), 30,
								20, IO);
						break;
					case 105:
						playerBulletX.set(i,
								playerBulletX.get(i) + 5);
						g.drawImage(playerBulletSpecialPentagon,
								playerBulletX.get(i),
								playerBulletY.get(i), 30,
								20, IO);
						break;
					case 106:
						playerBulletX.set(i,
								playerBulletX.get(i) + 5);
						g.drawImage(playerBulletSpecialHexagon,
								playerBulletX.get(i),
								playerBulletY.get(i), 30,
								20, IO);
						break;
					case 108:
						playerBulletX.set(i,
								playerBulletX.get(i) + 5);
						g.drawImage(bulletSpecialOctagon,
								playerBulletX.get(i),
								playerBulletY.get(i), 30,
								30, IO);
						break;
					case 110:
						playerBulletX.set(i,
								playerBulletX.get(i) + 5);
						g.drawImage(playerBulletSpecialStar,
								playerBulletX.get(i),
								playerBulletY.get(i), 30,
								30, IO);
						break;
					case 169:
						playerBulletX.set(i,
								playerBulletX.get(i) + 2);
						g.drawImage(bulletSpecialNyan,
								playerBulletX.get(i),
								playerBulletY.get(i), 30,
								20, IO);
						break;
				}
				// hitboxes
				if (playerShapemon.getTypeOfShapemon() == 2 && bulletType.get(0) == 102) {
					if ((playerBulletY.get(i) >= yOpponent - 250
							&& Integer.parseInt(playerBulletY.get(i)
									.toString()) <= yOpponent + 100)
							&&
							(playerBulletX.get(i) >= xOpponent
									- 350
									&& Integer.parseInt(playerBulletX.get(i)
											.toString()) <= xOpponent
													+ 100)) {
						hit = true;
						playerBulletX.remove(i);
						playerBulletY.remove(i);
						bulletType.remove(i);
						i--;
						opponentShapemon.damage(playerShapemon.getMaxHealth() / 5 + 1);
						timer = 0;
					}
				} else if ((playerBulletY.get(i) >= yOpponent - 20
						&& playerBulletY.get(i) <= yOpponent + 100)
						&&
						(playerBulletX.get(i) >= xOpponent - 30
								&& Integer.parseInt(playerBulletX.get(i)
										.toString()) <= xOpponent + 100)) {
					oppHit = true;
					playerBulletX.remove(i);
					playerBulletY.remove(i);
					bulletType.remove(i);
					i--;
					opponentShapemon.damage(attackPower);
					if (specialCounter + attackPower > 1200) {
						specialCounter = 1200;
					} else {
						specialCounter = specialCounter + attackPower;
					}
				} else if (playerBulletX.get(i) > 720) {
					playerBulletX.remove(i);
					playerBulletY.remove(i);
					bulletType.remove(i);
					i--;
				}
			}
			for (int i = 0; i < opponentBulletX.size(); i++) {
				switch (Integer.parseInt(bulletTypeOpp.get(i).toString())) {
					case 1:
						opponentBulletX.set(i,
								Integer.parseInt(opponentBulletX.get(i).toString())
										- 5);
						g.drawImage(opponentBullet1,
								Integer.parseInt(opponentBulletX.get(i).toString()),
								Integer.parseInt(opponentBulletY.get(i).toString()), 30,
								20, IO);
						break;
					case 2:
						opponentBulletX.set(i,
								Integer.parseInt(opponentBulletX.get(i).toString())
										- 5);
						g.drawImage(opponentBullet2,
								Integer.parseInt(opponentBulletX.get(i).toString()),
								Integer.parseInt(opponentBulletY.get(i).toString()), 30,
								20, IO);
						break;
					case 3:
						opponentBulletX.set(i,
								Integer.parseInt(opponentBulletX.get(i).toString())
										- 6);
						g.drawImage(opponentBullet3,
								Integer.parseInt(opponentBulletX.get(i).toString()),
								Integer.parseInt(opponentBulletY.get(i).toString()), 30,
								20, IO);
						break;
					case 4:
						opponentBulletX.set(i,
								Integer.parseInt(opponentBulletX.get(i).toString())
										- 6);
						g.drawImage(opponentBullet4,
								Integer.parseInt(opponentBulletX.get(i).toString()),
								Integer.parseInt(opponentBulletY.get(i).toString()), 30,
								20, IO);
						break;
					case 5:
						opponentBulletX.set(i,
								Integer.parseInt(opponentBulletX.get(i).toString())
										- 7);
						g.drawImage(opponentBullet5,
								Integer.parseInt(opponentBulletX.get(i).toString()),
								Integer.parseInt(opponentBulletY.get(i).toString()), 30,
								20, IO);
						break;
					case 6:
						opponentBulletX.set(i,
								Integer.parseInt(opponentBulletX.get(i).toString())
										- 7);
						g.drawImage(opponentBullet6,
								Integer.parseInt(opponentBulletX.get(i).toString()),
								Integer.parseInt(opponentBulletY.get(i).toString()), 30,
								20, IO);
						break;
					case 7:
						opponentBulletX.set(i,
								Integer.parseInt(opponentBulletX.get(i).toString())
										- 6);
						g.drawImage(opponentBullet7Nyan,
								Integer.parseInt(opponentBulletX.get(i).toString()),
								Integer.parseInt(opponentBulletY.get(i).toString()), 30,
								20, IO);
						break;
					case 8:
						opponentBulletX.set(i,
								Integer.parseInt(opponentBulletX.get(i).toString())
										- 5);
						g.drawImage(opponentBullet8Pacman,
								Integer.parseInt(opponentBulletX.get(i).toString()),
								Integer.parseInt(opponentBulletY.get(i).toString()), 30,
								20, IO);
						break;
					case 9:
						opponentBulletX.set(i,
								Integer.parseInt(opponentBulletX.get(i).toString())
										- 10);
						g.drawImage(opponentBullet9Slash,
								Integer.parseInt(opponentBulletX.get(i).toString()),
								Integer.parseInt(opponentBulletY.get(i).toString()), 30,
								20, IO);
						break;
					case 10:
						opponentBulletX.set(i,
								Integer.parseInt(opponentBulletX.get(i).toString())
										- 7);
						g.drawImage(opponentBullet10Swim,
								Integer.parseInt(opponentBulletX.get(i).toString()),
								Integer.parseInt(opponentBulletY.get(i).toString()), 30,
								20, IO);
						break;
					case 11:
						opponentBulletX.set(i,
								Integer.parseInt(opponentBulletX.get(i).toString())
										- 5);
						g.drawImage(opponentBullet11Smash,
								Integer.parseInt(opponentBulletX.get(i).toString()),
								Integer.parseInt(opponentBulletY.get(i).toString()), 30,
								20, IO);
						break;
					case 101:
						opponentBulletX.set(i,
								Integer.parseInt(opponentBulletX.get(i).toString())
										- 5);
						g.drawImage(circle, Integer.parseInt(opponentBulletX.get(i).toString()),
								Integer.parseInt(opponentBulletY.get(i).toString()), 30,
								30, IO);
						break;
					case 102:
						opponentBulletX.set(i,
								Integer.parseInt(opponentBulletX.get(i).toString())
										- 3);
						g.drawImage(opponentBullet8Pacman,
								Integer.parseInt(opponentBulletX.get(i).toString()),
								Integer.parseInt(opponentBulletY.get(i).toString()),
								350, 250, IO);
						break;
					case 103:
						opponentBulletX.set(i,
								Integer.parseInt(opponentBulletX.get(i).toString())
										- 5);
						g.drawImage(opponentBulletSpecialTriangle,
								Integer.parseInt(opponentBulletX.get(i).toString()),
								Integer.parseInt(opponentBulletY.get(i).toString()), 30,
								30, IO);
						break;
					case 104:
						opponentBulletX.set(i,
								Integer.parseInt(opponentBulletX.get(i).toString())
										- 4);
						g.drawImage(bulletSpecialSquare,
								Integer.parseInt(opponentBulletX.get(i).toString()),
								Integer.parseInt(opponentBulletY.get(i).toString()), 30,
								20, IO);
						break;
					case 105:
						opponentBulletX.set(i,
								Integer.parseInt(opponentBulletX.get(i).toString())
										- 5);
						g.drawImage(opponentBulletSpecialPentagon,
								Integer.parseInt(opponentBulletX.get(i).toString()),
								Integer.parseInt(opponentBulletY.get(i).toString()), 30,
								20, IO);
						break;
					case 106:
						opponentBulletX.set(i,
								Integer.parseInt(opponentBulletX.get(i).toString())
										- 5);
						g.drawImage(opponentBulletSpecialHexagon,
								Integer.parseInt(opponentBulletX.get(i).toString()),
								Integer.parseInt(opponentBulletY.get(i).toString()), 30,
								20, IO);
						break;
					case 108:
						opponentBulletX.set(i,
								Integer.parseInt(opponentBulletX.get(i).toString())
										- 5);
						g.drawImage(bulletSpecialOctagon,
								Integer.parseInt(opponentBulletX.get(i).toString()),
								Integer.parseInt(opponentBulletY.get(i).toString()), 30,
								30, IO);
						break;
					case 110:
						opponentBulletX.set(i,
								Integer.parseInt(opponentBulletX.get(i).toString())
										- 5);
						g.drawImage(opponentBulletSpecialStar,
								Integer.parseInt(opponentBulletX.get(i).toString()),
								Integer.parseInt(opponentBulletY.get(i).toString()), 30,
								30, IO);
						break;
					case 169:
						opponentBulletX.set(i,
								Integer.parseInt(opponentBulletX.get(i).toString())
										- 4);
						g.drawImage(bulletSpecialNyan,
								Integer.parseInt(opponentBulletX.get(i).toString()),
								Integer.parseInt(opponentBulletY.get(i).toString()), 30,
								20, IO);
						break;
				}
				if (opponentShapemon.getTypeOfShapemon() == 2 && bulletTypeOpp.get(0) == 102) {
					if ((Integer.parseInt(opponentBulletY.get(i).toString()) >= yPlayer - 250
							&& Integer.parseInt(opponentBulletY.get(i)
									.toString()) <= yPlayer + 100)
							&&
							(Integer.parseInt(opponentBulletX.get(i).toString()) >= xPlayer
									- 350
									&& Integer.parseInt(opponentBulletX.get(i)
											.toString()) <= xPlayer
													+ 100)) {
						hit = true;
						opponentBulletX.remove(i);
						opponentBulletY.remove(i);
						bulletTypeOpp.remove(i);
						i--;
						playerShapemon.damage(attackPowerOpp);
						if (specialCounterOpp + attackPowerOpp > 1200) {
							specialCounterOpp = 1200;
						} else {
							specialCounterOpp = specialCounterOpp + attackPowerOpp;
						}
					}
				} else if ((Integer.parseInt(opponentBulletY.get(i).toString()) >= yPlayer - 20
						&& Integer.parseInt(opponentBulletY.get(i).toString()) <= yPlayer + 100)
						&&
						(Integer.parseInt(opponentBulletX.get(i).toString()) >= xPlayer - 30
								&& Integer.parseInt(opponentBulletX.get(i)
										.toString()) <= xPlayer + 100)) {
					hit = true;
					opponentBulletX.remove(i);
					opponentBulletY.remove(i);
					bulletTypeOpp.remove(i);
					i--;
					playerShapemon.damage(attackPowerOpp);
				} else if (Integer.parseInt(opponentBulletX.get(i).toString()) < -30) {
					opponentBulletX.remove(i);
					opponentBulletY.remove(i);
					bulletTypeOpp.remove(i);
					i--;
				}
			}

			// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

			if (upPressed) {
				if (yPlayer > 105) {
					yPlayer -= 5;
				}
			}
			if (leftPressed) {
				if (xPlayer > 0) {
					xPlayer -= 5;
				}
			}
			if (downPressed) {
				if (yPlayer < 445) {
					yPlayer += 5;
				}
			}
			if (rightPressed) {
				if (xPlayer < 260) {
					xPlayer += 5;
				}
			}
			if (switchMovePressed && switchMoveReleased) {
				if (attackChoice == 1 && playerShapemon.getMoveTwo() != 0) {
					attackChoice = 2;
				} else if (attackChoice == 2) {
					attackChoice = 1;
				}
				switchMoveReleased = false;
			}
			if (spMoveCounterPlayer > 0 && spMoveCounterPlayer < 150) {
				spMoveCounterPlayer++;
			}
			if (spMoveCounterPlayer == 150) {
				spMoveCounterPlayer = 0;
			}
			if (selectPressed) {
				if (spMoveCounterPlayer > 0 && spMoveCounterPlayer < 150) {
					if (timer > spMoveCDPlayer) {
						if (playerShapemon.getTypeOfShapemon() == 2
								&& playerBulletX.size() < 1) {
							fireSpecial(true);
							timer = 0;
						} else if (playerShapemon.getTypeOfShapemon() == 4
								|| playerShapemon.getTypeOfShapemon() == 69) {
							fireSpecial(true);
							timer = 0;
						} else if (playerShapemon.getTypeOfShapemon() != 2
								&& playerBulletX.size() < 5) {
							fireSpecial(true);
							timer = 0;
						}

					}
				} else {
					if (specialMovePressed && specialReady) {
						specialCounter = 0;
						spMoveCounterPlayer = 1;
						specialReady = false;
						selectPressed = false;
					} else {
						if (attackChoice == 1) {
							if (timer > getDelay(playerShapemon.getMoveOne())) {
								if (playerBulletX.size() < 3) {
									playerShoot(playerShapemon.getMoveOne());
									timer = 0;
								}
							}
						} else {
							if (timer > getDelay(playerShapemon.getMoveTwo())) {
								if (playerBulletX.size() < 3) {
									playerShoot(playerShapemon.getMoveTwo());
									timer = 0;
								}
							}
						}
					}
				}
				selectPressed = false;
			}

			double chance = 0;
			switch (opponentBulletX.size()) {
				case 0:
					chance = 2.5;
					break;
				case 1:
					chance = 1.25;
					break;
				case 2:
					chance = 0.625;
					break;
				case 3:
					chance = 0.3125;
					break;
				default:
					chance = 0;
					break;
			}
			if (spMoveCounterOpponent > 0 && spMoveCounterOpponent < 150) {
				spMoveCounterOpponent++;
			}
			if (spMoveCounterOpponent == 150) {
				spMoveCounterOpponent = 0;
			}
			if (specialReadyOpp) {
				specialReadyOpp = false;
				spMoveCounterOpponent = 1;
				specialCounterOpp = 0;
			}
			if (spMoveCounterOpponent > 0 && spMoveCounterOpponent < 150) {
				if (timerOpp > spMoveCDOpponent) {
					if (opponentShapemon.getTypeOfShapemon() == 2 && opponentBulletX.size() < 1) {
						fireSpecial(false);
						timer = 0;
					} else if (opponentShapemon.getTypeOfShapemon() == 4
							|| opponentShapemon.getTypeOfShapemon() == 69) {
						fireSpecial(false);
						timerOpp = 0;
					} else if (opponentShapemon.getTypeOfShapemon() != 2
							&& opponentBulletX.size() < 5) {
						fireSpecial(false);
						timerOpp = 0;

					}
				}
			}
			if (opponentShapemon.getMoveTwo() == 0) {
				chance = 0;
			}
			if (Math.random() * 100 + 1 < chance) {
				if (attackChoiceOpp == 1) {
					attackChoiceOpp = 2;
				} else if (attackChoiceOpp == 2) {
					attackChoiceOpp = 1;
				}
			}

			if (Math.random() * 100 + 1 < (100 - 3) / (Math.pow(((yPlayer - yOpponent) / 50), 4) + 1) + 3) {
				if (attackChoiceOpp == 1) {
					if (timerOpp > getDelay(opponentShapemon.getMoveOne())) {
						if (opponentBulletX.size() < 3) {
							opponentShoot(opponentShapemon.getMoveOne());
							timerOpp = 0;
						}
					}
				} else {
					if (timerOpp > getDelay(opponentShapemon.getMoveTwo())) {
						if (opponentBulletX.size() < 3) {
							opponentShoot(opponentShapemon.getMoveTwo());
							timerOpp = 0;
						}
					}
				}
			}
			timer++;
			timerOpp++;
		} else {
			g.drawImage(background, 0, 0, 720, 720, IO);
			g.setColor(Color.DARK_GRAY);
			g.fillRect(360, 0, 360, 105);
			g.fillRect(335 - getLength(opponentShapemon.getName()), 0,
					25 + getLength(opponentShapemon.getName()), 70);
			if (!addedShapecubes) {
				if (opponentShapemonOne != null) {
					player.getBag().getDrops(opponentShapemonOne.getLevel());
				}
				if (opponentShapemonTwo != null) {
					player.getBag().getDrops(opponentShapemonTwo.getLevel());
				}
				if (opponentShapemonThree != null) {
					player.getBag().getDrops(opponentShapemonThree.getLevel());
				}
				if (opponentShapemonFour != null) {
					player.getBag().getDrops(opponentShapemonFour.getLevel());
				}
				if (opponentShapemonFive != null) {
					player.getBag().getDrops(opponentShapemonFive.getLevel());
				}
				if (opponentShapemonSix != null) {
					player.getBag().getDrops(opponentShapemonSix.getLevel());
				}
				addedShapecubes = true;
			}
			oneSecondTimer = 0;
			oneSecondTimerOpp = 0;
			if (playerShapemon.getExp() >= playerShapemon.getExpReq()) {
				playerShapemon.levelUp();
			}
			if (!wild) {
				if (!opponentShapemonOne.isDead()) {
					g.drawImage(shapeCube, 380, 25, 25, 25, IO);
				} else if (opponentShapemonOne.isDead()) {
					g.drawImage(shapeCubeDead, 380, 25, 25, 25, IO);
				}
				if (opponentShapemonTwo == null) {
					g.drawImage(shapeCubeEmpty, 410, 25, 25, 25, IO);
				} else if (!opponentShapemonTwo.isDead()) {
					g.drawImage(shapeCube, 410, 25, 25, 25, IO);
				} else if (opponentShapemonTwo.isDead()) {
					g.drawImage(shapeCubeDead, 410, 25, 25, 25, IO);
				}
				if (opponentShapemonThree == null) {
					g.drawImage(shapeCubeEmpty, 440, 25, 25, 25, IO);
				} else if (!opponentShapemonThree.isDead()) {
					g.drawImage(shapeCube, 440, 25, 25, 25, IO);
				} else if (opponentShapemonThree.isDead()) {
					g.drawImage(shapeCubeDead, 440, 25, 25, 25, IO);
				}
				if (opponentShapemonFour == null) {
					g.drawImage(shapeCubeEmpty, 470, 25, 25, 25, IO);
				} else if (!opponentShapemonFour.isDead()) {
					g.drawImage(shapeCube, 470, 25, 25, 25, IO);
				} else if (opponentShapemonFour.isDead()) {
					g.drawImage(shapeCubeDead, 470, 25, 25, 25, IO);
				}
				if (opponentShapemonFive == null) {
					g.drawImage(shapeCubeEmpty, 500, 25, 25, 25, IO);
				} else if (!opponentShapemonFive.isDead()) {
					g.drawImage(shapeCube, 500, 25, 25, 25, IO);
				} else if (opponentShapemonFive.isDead()) {
					g.drawImage(shapeCubeDead, 500, 25, 25, 25, IO);
				}
				if (opponentShapemonSix == null) {
					g.drawImage(shapeCubeEmpty, 530, 25, 25, 25, IO);
				} else if (!opponentShapemonSix.isDead()) {
					g.drawImage(shapeCube, 530, 25, 25, 25, IO);
				} else if (opponentShapemonSix.isDead()) {
					g.drawImage(shapeCubeDead, 530, 25, 25, 25, IO);
				}
			}

			g.setColor(Color.GREEN);
			g.fillRect(435, 55, ((opponentShapemon.getHealth() * 265 / opponentShapemon.getMaxHealth())),
					30);

			g.setColor(Color.WHITE);
			drawH(380, 55, g);
			drawP(405, 55, g);
			g.drawRect(435, 55, 265, 30);
			drawString("lv" + opponentShapemon.getLevel(),
					700 - getLength("lv" + opponentShapemon.getLevel()), 20, g);
			drawString(opponentShapemon.getName().toLowerCase(),
					355 - getLength(opponentShapemon.getName()), 20, g);

			// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			// Player stat box
			g.setColor(Color.DARK_GRAY);
			g.fillRect(0, 560 - 15, 360, 140 + 15);
			g.fillRect(360, 560 - 15, getLength(playerShapemon.getName()) + 25, 70);
			if (!playerShapemonOne.isDead()) {
				g.drawImage(shapeCube, 20, 585 - 15, 25, 25, IO);
			} else if (playerShapemonOne.isDead()) {
				g.drawImage(shapeCubeDead, 20, 585 - 15, 25, 25, IO);
			}
			if (playerShapemonTwo == null) {
				g.drawImage(shapeCubeEmpty, 50, 585 - 15, 25, 25, IO);
			} else if (!playerShapemonTwo.isDead()) {
				g.drawImage(shapeCube, 50, 585 - 15, 25, 25, IO);
			} else if (playerShapemonTwo.isDead()) {
				g.drawImage(shapeCubeDead, 50, 585 - 15, 25, 25, IO);
			}
			if (playerShapemonThree == null) {
				g.drawImage(shapeCubeEmpty, 80, 585 - 15, 25, 25, IO);
			} else if (!playerShapemonThree.isDead()) {
				g.drawImage(shapeCube, 80, 585 - 15, 25, 25, IO);
			} else if (playerShapemonThree.isDead()) {
				g.drawImage(shapeCubeDead, 80, 585 - 15, 25, 25, IO);
			}
			if (playerShapemonFour == null) {
				g.drawImage(shapeCubeEmpty, 110, 585 - 15, 25, 25, IO);
			} else if (!playerShapemonFour.isDead()) {
				g.drawImage(shapeCube, 110, 585 - 15, 25, 25, IO);
			} else if (playerShapemonFour.isDead()) {
				g.drawImage(shapeCubeDead, 110, 585 - 15, 25, 25, IO);
			}
			if (playerShapemonFive == null) {
				g.drawImage(shapeCubeEmpty, 140, 585 - 15, 25, 25, IO);
			} else if (!playerShapemonFive.isDead()) {
				g.drawImage(shapeCube, 140, 585 - 15, 25, 25, IO);
			} else if (playerShapemonFive.isDead()) {
				g.drawImage(shapeCubeDead, 140, 585 - 15, 25, 25, IO);
			}
			if (playerShapemonSix == null) {
				g.drawImage(shapeCubeEmpty, 170, 585 - 15, 25, 25, IO);
			} else if (!playerShapemonSix.isDead()) {
				g.drawImage(shapeCube, 170, 585 - 15, 25, 25, IO);
			} else if (playerShapemonSix.isDead()) {
				g.drawImage(shapeCubeDead, 170, 585 - 15, 25, 25, IO);
			}

			g.setColor(Color.GREEN);
			g.fillRect(75, 615 - 15, (playerShapemon.getHealth() * 265 / playerShapemon.getMaxHealth()),
					30);

			g.setColor(Color.CYAN);
			if (playerShapemon.getExp() >= playerShapemon.getExpReq()) {
				g.fillRect(75, 695 - 15, 265, 5);
			} else {
				g.fillRect(75, 695 - 15, (playerShapemon.getExp() * 265 / playerShapemon.getExpReq()),
						5);
			}
			if (leveledUp && expFlashCounter < 35) {
				g.setColor(Color.DARK_GRAY);
				g.fillRect(75, 695 - 15, 265, 5);
				g.drawImage(levelUpBar, 75, 695 - 15, 265, 5, IO);
				expFlashCounter++;
			} else {
				leveledUp = false;
				expFlashCounter = 0;
			}
			g.setColor(Color.ORANGE);
			g.fillRect(370, 680, specialCounter * 330 / 1200, 5);
			if (specialCounter >= 1200) {
				g.setColor(new Color(112, 200, 160));
				g.fillRect(370, 680, 330, 5);
				g.drawImage(specialBar, 370, 680, 330, 5, IO);
			}

			g.setColor(Color.WHITE);
			drawH(20, 615 - 15, g);
			drawP(45, 615 - 15, g);
			g.drawRect(75, 615 - 15, 265, 30);
			g.drawRect(75, 680, 265, 5);
			g.drawRect(370, 680, 330, 5);
			drawString("lv" + playerShapemon.getLevel(), 340 - getLength("lv" + playerShapemon.getLevel()),
					580 - 15, g);
			drawString(playerShapemon.getName().toLowerCase(), 365, 580 - 15, g);
			drawString(playerShapemon.getHealth() + "/" + playerShapemon.getMaxHealth(), 75, 650 - 15, g);

			if (attackChoice == 1) {
				g.drawImage(battleButtonY, 370, 640 - 15, 160, 50, IO);
			} else {
				g.drawImage(battleButtonG, 370, 640 - 15, 160, 50, IO);
			}
			if (attackChoice == 2) {
				g.drawImage(battleButtonY, 540, 640 - 15, 160, 50, IO);
			} else {
				g.drawImage(battleButtonG, 540, 640 - 15, 160, 50, IO);
			}
			g.setColor(Color.BLACK);
			drawString("Move 1", 380, 650 - 15, g);
			if (playerShapemon.getMoveTwo() != 0) {
				drawString("Move 2", 550, 650 - 15, g);
			} else {
				drawString("n/a", 580, 650 - 15, g);
			}
			// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			// Player and opponent
			xOpponent = aiCoords.getX();
			yOpponent = aiCoords.getY();
			switch (playerShapemon.getTypeOfShapemon()) {
				case 1:
					g.drawImage(circle, xPlayer, yPlayer, 100, 100, IO);
					break;
				case 2:
					g.drawImage(pacman, xPlayer, yPlayer, 100, 100, IO);
					break;
				case 3:
					g.drawImage(triangle, xPlayer, yPlayer, 100, 100, IO);
					break;
				case 4:
					g.drawImage(square, xPlayer, yPlayer, 100, 100, IO);
					break;
				case 5:
					g.drawImage(pentagon, xPlayer, yPlayer, 100, 100, IO);
					break;
				case 6:
					g.drawImage(hexagon, xPlayer, yPlayer, 100, 100, IO);
					break;
				case 8:
					g.drawImage(octagon, xPlayer, yPlayer, 100, 100, IO);
					break;
				case 10:
					g.drawImage(star, xPlayer, yPlayer, 100, 100, IO);
					break;
				case 69:
					g.drawImage(nyan, xPlayer, yPlayer, 100, 100, IO);
					break;
			}
			switch (opponentShapemon.getTypeOfShapemon()) {
				case 1:
					g.drawImage(circle, xOpponent, yOpponent, 100, 100, IO);
					break;
				case 2:
					g.drawImage(oppPacman, xOpponent, yOpponent, 100, 100, IO);
					break;
				case 3:
					g.drawImage(oppTriangle, xOpponent, yOpponent, 100, 100, IO);
					break;
				case 4:
					g.drawImage(square, xOpponent, yOpponent, 100, 100, IO);
					break;
				case 5:
					g.drawImage(pentagon, xOpponent, yOpponent, 100, 100, IO);
					break;
				case 6:
					g.drawImage(hexagon, xOpponent, yOpponent, 100, 100, IO);
					break;
				case 8:
					g.drawImage(octagon, xOpponent, yOpponent, 100, 100, IO);
					break;
				case 10:
					g.drawImage(star, xOpponent, yOpponent, 100, 100, IO);
					break;
				case 69:
					g.drawImage(oppNyan, xOpponent, yOpponent, 100, 100, IO);
					break;
			}
			if (playerWins) {
				g.drawImage(deathIcon, xOpponent - 25, yOpponent - 25, 150, 150, IO);
				aiCoords.setX(xOpponent + 1);
				if (aiCoords.getX() > 740) {
					if (wild) {
						// screen for defeating wild shapemon
						g.setColor(Color.DARK_GRAY);
						g.drawImage(defeatedBackground, 135, 150, 445, 210, IO);
						g.setColor(Color.WHITE);
						drawString("you have defeated",
								360 - getLength("you have defeated") / 2, 165, g);
						drawShapemon(opponentShapemon.getTypeOfShapemon(), 310, 205, 100, 100,
								g);
						if ((getLength(opponentShapemon.getName() + " lv"
								+ opponentShapemon.getLevel())) % 10 == 0) {
							drawString(opponentShapemon.getName() + " lv"
									+ opponentShapemon.getLevel(),
									360 - getLength(opponentShapemon.getName()
											+ " lv"
											+ opponentShapemon.getLevel())
											/ 2,
									315, g);
						} else {
							drawString(opponentShapemon.getName() + " lv"
									+ opponentShapemon.getLevel(),
									360 - (getLength(opponentShapemon.getName()
											+ " lv"
											+ opponentShapemon.getLevel())
											- 5) / 2,
									315, g);
						}
						if (!selected) {
							if (rightPressed && rightReleased) {
								if (captureChoice == 1) {
									captureChoice = 2;
								}
								rightPressed = false;
							}
							if (leftPressed && leftReleased) {
								if (captureChoice == 2) {
									captureChoice = 1;
								}
								leftPressed = false;
							}
						}

						if (captureChoice == 1) {
							g.drawImage(captureButtonY, 135, 365, 220, 50, IO);
							g.drawImage(captureButtonG, 360, 365, 220, 50, IO);
						}
						if (captureChoice == 2) {
							g.drawImage(captureButtonG, 135, 365, 220, 50, IO);
							g.drawImage(captureButtonY, 360, 365, 220, 50, IO);
						}
						g.setColor(Color.BLACK);
						drawString("capture", 155, 375, g);
						drawString("flee", 420, 375, g);
						if (selectPressed && selectReleased) {
							if (captureChoice == 1) {
								// capture selected
								selected = true;
								captureChoice = 3;
								selectReleased = false;
							} else if (captureChoice == 2) {
								// flee selected
								selectionDone = true;
								selectReleased = false;
							} else if (captureChoice == 3) {
								// shapeball1
								if (Caught.caught(opponentShapemon.getLevel(), 1)
										&& player.getBag().getNumberOfCubes(
												1) > 0) {
									// catches shapemon
									player.getBag().useCube(1);
									try {
										Thread.sleep(500);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
									if (player.getNumOfShapemon() < 6) {
										// space in party
										switch (opponentShapemon
												.getTypeOfShapemon()) {
											case 1:
												player.addShapemon(
														new ShapemonCircle(
																opponentShapemon.getLevel(),
																opponentShapemon.getMoveOne(),
																opponentShapemon.getMoveTwo()));
												break;
											case 2:
												player.addShapemon(
														new ShapemonPacman(
																opponentShapemon.getLevel(),
																opponentShapemon.getMoveOne(),
																opponentShapemon.getMoveTwo()));
												break;
											case 3:
												player.addShapemon(
														new ShapemonTriangle(
																opponentShapemon.getLevel(),
																opponentShapemon.getMoveOne(),
																opponentShapemon.getMoveTwo()));
												break;
											case 4:
												player.addShapemon(
														new ShapemonSquare(
																opponentShapemon.getLevel(),
																opponentShapemon.getMoveOne(),
																opponentShapemon.getMoveTwo()));
												break;
											case 5:
												player.addShapemon(
														new ShapemonPentagon(
																opponentShapemon.getLevel(),
																opponentShapemon.getMoveOne(),
																opponentShapemon.getMoveTwo()));
												break;
											case 6:
												player.addShapemon(
														new ShapemonHexagon(
																opponentShapemon.getLevel(),
																opponentShapemon.getMoveOne(),
																opponentShapemon.getMoveTwo()));
												break;
											case 8:
												player.addShapemon(
														new ShapemonOctagon(
																opponentShapemon.getLevel(),
																opponentShapemon.getMoveOne(),
																opponentShapemon.getMoveTwo()));
												break;
											case 10:
												player.addShapemon(
														new ShapemonStar(
																opponentShapemon.getLevel(),
																opponentShapemon.getMoveOne(),
																opponentShapemon.getMoveTwo()));
												break;
											case 69:
												player.addShapemon(
														new ShapemonNyan(
																opponentShapemon.getLevel(),
																opponentShapemon.getMoveOne(),
																opponentShapemon.getMoveTwo()));
												break;
										}
									} else {
										// no spac ein party
										boolean hasEmptySpace = false;
										for (int i = 0; i < SwitchShape.storage.length; i++) {
											if (SwitchShape.storage[i] == null) {
												hasEmptySpace = true;
												SwitchShape.storage[i] = opponent
														.getShapemon(1);
												i = SwitchShape.storage.length;
											}
										}
									}
									caught = true;
									failedCatch = false;
								} else {
									// doesnt catch shapemon
									player.getBag().useCube(1);
									failedCatch = true;
								}
								selectReleased = false;
							} else if (captureChoice == 4) {
								// shapeball2
								if (Caught.caught(opponentShapemon.getLevel(), 2)
										&& player.getBag().getNumberOfCubes(
												2) > 0) {
									// catches shapemon
									player.getBag().useCube(2);
									try {
										Thread.sleep(500);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
									if (player.getNumOfShapemon() < 6) {
										// space in party
										switch (opponentShapemon
												.getTypeOfShapemon()) {
											case 1:
												player.addShapemon(
														new ShapemonCircle(
																opponentShapemon.getLevel(),
																opponentShapemon.getMoveOne(),
																opponentShapemon.getMoveTwo()));
												break;
											case 2:
												player.addShapemon(
														new ShapemonPacman(
																opponentShapemon.getLevel(),
																opponentShapemon.getMoveOne(),
																opponentShapemon.getMoveTwo()));
												break;
											case 3:
												player.addShapemon(
														new ShapemonTriangle(
																opponentShapemon.getLevel(),
																opponentShapemon.getMoveOne(),
																opponentShapemon.getMoveTwo()));
												break;
											case 4:
												player.addShapemon(
														new ShapemonSquare(
																opponentShapemon.getLevel(),
																opponentShapemon.getMoveOne(),
																opponentShapemon.getMoveTwo()));
												break;
											case 5:
												player.addShapemon(
														new ShapemonPentagon(
																opponentShapemon.getLevel(),
																opponentShapemon.getMoveOne(),
																opponentShapemon.getMoveTwo()));
												break;
											case 6:
												player.addShapemon(
														new ShapemonHexagon(
																opponentShapemon.getLevel(),
																opponentShapemon.getMoveOne(),
																opponentShapemon.getMoveTwo()));
												break;
											case 8:
												player.addShapemon(
														new ShapemonOctagon(
																opponentShapemon.getLevel(),
																opponentShapemon.getMoveOne(),
																opponentShapemon.getMoveTwo()));
												break;
											case 10:
												player.addShapemon(
														new ShapemonStar(
																opponentShapemon.getLevel(),
																opponentShapemon.getMoveOne(),
																opponentShapemon.getMoveTwo()));
												break;
											case 69:
												player.addShapemon(
														new ShapemonNyan(
																opponentShapemon.getLevel(),
																opponentShapemon.getMoveOne(),
																opponentShapemon.getMoveTwo()));
												break;
										}
									} else {
										// no space in party
										boolean hasEmptySpace = false;
										for (int i = 0; i < SwitchShape.storage.length; i++) {
											if (SwitchShape.storage[i] == null) {
												hasEmptySpace = true;
												SwitchShape.storage[i] = opponent
														.getShapemon(1);
												i = SwitchShape.storage.length;
											}
										}
										if (!hasEmptySpace) {
											SwitchShape.storage = new Shapemon[SwitchShape.storage.length
													+ 1];
											SwitchShape.storage[SwitchShape.storage.length
													- 1] = opponent.getShapemon(
															1);
										}
									}
									caught = true;
									failedCatch = false;
								} else {
									// doesnt catch shapemon
									player.getBag().useCube(2);
									failedCatch = true;
								}
								selectReleased = false;
							} else if (captureChoice == 5) {
								// shapeball3
								if (Caught.caught(opponentShapemon.getLevel(), 3)
										&& player.getBag().getNumberOfCubes(
												3) > 0) {
									// catches shapemon
									player.getBag().useCube(3);
									try {
										Thread.sleep(500);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
									if (player.getNumOfShapemon() < 6) {
										// space in party
										switch (opponentShapemon
												.getTypeOfShapemon()) {
											case 1:
												player.addShapemon(
														new ShapemonCircle(
																opponentShapemon.getLevel(),
																opponentShapemon.getMoveOne(),
																opponentShapemon.getMoveTwo()));
												break;
											case 2:
												player.addShapemon(
														new ShapemonPacman(
																opponentShapemon.getLevel(),
																opponentShapemon.getMoveOne(),
																opponentShapemon.getMoveTwo()));
												break;
											case 3:
												player.addShapemon(
														new ShapemonTriangle(
																opponentShapemon.getLevel(),
																opponentShapemon.getMoveOne(),
																opponentShapemon.getMoveTwo()));
												break;
											case 4:
												player.addShapemon(
														new ShapemonSquare(
																opponentShapemon.getLevel(),
																opponentShapemon.getMoveOne(),
																opponentShapemon.getMoveTwo()));
												break;
											case 5:
												player.addShapemon(
														new ShapemonPentagon(
																opponentShapemon.getLevel(),
																opponentShapemon.getMoveOne(),
																opponentShapemon.getMoveTwo()));
												break;
											case 6:
												player.addShapemon(
														new ShapemonHexagon(
																opponentShapemon.getLevel(),
																opponentShapemon.getMoveOne(),
																opponentShapemon.getMoveTwo()));
												break;
											case 8:
												player.addShapemon(
														new ShapemonOctagon(
																opponentShapemon.getLevel(),
																opponentShapemon.getMoveOne(),
																opponentShapemon.getMoveTwo()));
												break;
											case 10:
												player.addShapemon(
														new ShapemonStar(
																opponentShapemon.getLevel(),
																opponentShapemon.getMoveOne(),
																opponentShapemon.getMoveTwo()));
												break;
											case 69:
												player.addShapemon(
														new ShapemonNyan(
																opponentShapemon.getLevel(),
																opponentShapemon.getMoveOne(),
																opponentShapemon.getMoveTwo()));
												break;
										}
									} else {
										// no space in party
										boolean hasEmptySpace = false;
										for (int i = 0; i < SwitchShape.storage.length; i++) {
											if (SwitchShape.storage[i] == null) {
												hasEmptySpace = true;
												SwitchShape.storage[i] = opponent
														.getShapemon(1);
												i = SwitchShape.storage.length;
											}
										}
										if (!hasEmptySpace) {
											SwitchShape.storage = new Shapemon[SwitchShape.storage.length
													+ 1];
											SwitchShape.storage[SwitchShape.storage.length
													- 1] = opponent.getShapemon(
															1);
										}
									}
									caught = true;
									failedCatch = false;
								} else {
									// doesnt catch shapemon
									player.getBag().useCube(3);
									failedCatch = true;
								}
								selectReleased = false;
							} else if (captureChoice == 6) {
								// shapeball4
								if (Caught.caught(opponentShapemon.getLevel(), 4)
										&& player.getBag().getNumberOfCubes(
												4) > 0) {
									// catches shapemon
									player.getBag().useCube(4);
									try {
										Thread.sleep(500);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
									if (player.getNumOfShapemon() < 6) {
										switch (opponentShapemon
												.getTypeOfShapemon()) {
											// space in party
											case 1:
												player.addShapemon(
														new ShapemonCircle(
																opponentShapemon.getLevel(),
																opponentShapemon.getMoveOne(),
																opponentShapemon.getMoveTwo()));
												break;
											case 2:
												player.addShapemon(
														new ShapemonPacman(
																opponentShapemon.getLevel(),
																opponentShapemon.getMoveOne(),
																opponentShapemon.getMoveTwo()));
												break;
											case 3:
												player.addShapemon(
														new ShapemonTriangle(
																opponentShapemon.getLevel(),
																opponentShapemon.getMoveOne(),
																opponentShapemon.getMoveTwo()));
												break;
											case 4:
												player.addShapemon(
														new ShapemonSquare(
																opponentShapemon.getLevel(),
																opponentShapemon.getMoveOne(),
																opponentShapemon.getMoveTwo()));
												break;
											case 5:
												player.addShapemon(
														new ShapemonPentagon(
																opponentShapemon.getLevel(),
																opponentShapemon.getMoveOne(),
																opponentShapemon.getMoveTwo()));
												break;
											case 6:
												player.addShapemon(
														new ShapemonHexagon(
																opponentShapemon.getLevel(),
																opponentShapemon.getMoveOne(),
																opponentShapemon.getMoveTwo()));
												break;
											case 8:
												player.addShapemon(
														new ShapemonOctagon(
																opponentShapemon.getLevel(),
																opponentShapemon.getMoveOne(),
																opponentShapemon.getMoveTwo()));
												break;
											case 10:
												player.addShapemon(
														new ShapemonStar(
																opponentShapemon.getLevel(),
																opponentShapemon.getMoveOne(),
																opponentShapemon.getMoveTwo()));
												break;
											case 69:
												player.addShapemon(
														new ShapemonNyan(
																opponentShapemon.getLevel(),
																opponentShapemon.getMoveOne(),
																opponentShapemon.getMoveTwo()));
												break;
										}
									} else {
										// no space in party
										boolean hasEmptySpace = false;
										for (int i = 0; i < SwitchShape.storage.length; i++) {
											if (SwitchShape.storage[i] == null) {
												hasEmptySpace = true;
												SwitchShape.storage[i] = opponent
														.getShapemon(1);
												i = SwitchShape.storage.length;
											}
										}
										if (!hasEmptySpace) {
											SwitchShape.storage = new Shapemon[SwitchShape.storage.length
													+ 1];
											SwitchShape.storage[SwitchShape.storage.length
													- 1] = opponent.getShapemon(
															1);
										}
									}
									caught = true;
									failedCatch = false;
								} else {
									// doesnt catch shapemon
									player.getBag().useCube(4);
									failedCatch = true;
								}
								selectReleased = false;
							} else if (captureChoice == 7) {
								selected = false;
								captureChoice = 1;
							}
							selectReleased = false;
							selectPressed = false;
						}
						if (caught) {
							g.drawImage(defeatedBackground, 135, 150, 445, 210, IO);
							g.setColor(Color.WHITE);
							drawString("success", 360 - getLength("success") / 2, 165, g);
							drawShapemon(opponentShapemon.getTypeOfShapemon(), 310, 205,
									100, 100, g);
							if ((getLength(opponentShapemon.getName() + " captured")
									% 10 == 0)) {
								drawString(opponentShapemon.getName() + " captured", 360
										- getLength(opponentShapemon.getName()
												+ " captured") / 2,
										315, g);
							} else {
								drawString(opponentShapemon.getName() + " captured", 360
										- (getLength(opponentShapemon.getName()
												+ " captured") - 5) / 2,
										315, g);
							}
							caughtTimer++;
							if (caughtTimer >= 180) {
								selectionDone = true;
							}
							captureChoice = 8;
						}
						if (failedCatch) {
							g.drawImage(defeatedBackground, 135, 150, 445, 210, IO);
							g.setColor(Color.WHITE);
							drawString("failed capture",
									360 - getLength("failed capture") / 2, 165, g);
							drawShapemon(opponentShapemon.getTypeOfShapemon(), 310, 205,
									100, 100, g);
							if ((getLength(opponentShapemon.getName() + " lv"
									+ opponentShapemon.getLevel())) % 10 == 0) {
								drawString(opponentShapemon.getName() + " lv"
										+ opponentShapemon.getLevel(),
										360 - getLength(opponentShapemon
												.getName()
												+ " lv"
												+ opponentShapemon
														.getLevel())
												/ 2,
										315, g);
							} else {
								drawString(opponentShapemon.getName() + " lv"
										+ opponentShapemon.getLevel(),
										360 - (getLength(opponentShapemon
												.getName()
												+ " lv"
												+ opponentShapemon
														.getLevel())
												- 5) / 2,
										315, g);
							}
						}
						if (selected) {
							if (rightPressed && rightReleased) {
								if (captureChoice < 7) {
									captureChoice++;
								}
								rightReleased = false;
							}
							if (leftPressed && leftReleased) {
								if (captureChoice > 3) {
									captureChoice--;
								}
								leftReleased = false;
							}
							g.drawImage(shapeCubeBackground, 135, 365, 445, 140, IO);
							int y = 395;
							g.setColor(Color.YELLOW);
							switch (captureChoice) {
								case 3:
									g.fillRect(185 - 20, y - 20, 90, 120);
									break;
								case 4:
									g.fillRect(280 - 20, y - 20, 90, 120);
									break;
								case 5:
									g.fillRect(375 - 20, y - 20, 90, 120);
									break;
								case 6:
									g.fillRect(470 - 20, y - 20, 90, 120);
									break;
								case 7:
									g.fillRect(540, 465, 35, 35);
									break;
							}
							g.setColor(Color.BLACK);
							g.drawImage(shapeCube, 185, y, 50, 50, IO);
							if (getLength(player.getBag().getNumberOfCubes(1) + "")
									% 10 == 0) {
								drawString(player.getBag().getNumberOfCubes(1) + "",
										210 - getLength(player.getBag()
												.getNumberOfCubes(1)
												+ "") / 2,
										y + 55, g);
							} else {
								drawString(player.getBag().getNumberOfCubes(1) + "",
										210 - (getLength(player.getBag()
												.getNumberOfCubes(1)
												+ "") - 5) / 2,
										y + 55, g);
							}

							g.drawImage(shapeCube2, 280, y, 50, 50, IO);
							if (getLength(player.getBag().getNumberOfCubes(2) + "")
									% 10 == 0) {
								drawString(player.getBag().getNumberOfCubes(2) + "",
										305 - getLength(player.getBag()
												.getNumberOfCubes(2)
												+ "") / 2,
										y + 55, g);
							} else {
								drawString(player.getBag().getNumberOfCubes(2) + "",
										305 - (getLength(player.getBag()
												.getNumberOfCubes(2)
												+ "") - 5) / 2,
										y + 55, g);
							}

							g.drawImage(shapeCube3, 375, y, 50, 50, IO);
							if (getLength(player.getBag().getNumberOfCubes(3) + "")
									% 10 == 0) {
								drawString(player.getBag().getNumberOfCubes(3) + "",
										400 - getLength(player.getBag()
												.getNumberOfCubes(3)
												+ "") / 2,
										y + 55, g);
							} else {
								drawString(player.getBag().getNumberOfCubes(3) + "",
										400 - (getLength(player.getBag()
												.getNumberOfCubes(3)
												+ "") - 5) / 2,
										y + 55, g);
							}

							g.drawImage(shapeCube4, 470, y, 50, 50, IO);
							if (getLength(player.getBag().getNumberOfCubes(4) + "")
									% 10 == 0) {
								drawString(player.getBag().getNumberOfCubes(4) + "",
										495 - getLength(player.getBag()
												.getNumberOfCubes(4)
												+ "") / 2,
										y + 55, g);
							} else {
								drawString(player.getBag().getNumberOfCubes(4) + "",
										495 - (getLength(player.getBag()
												.getNumberOfCubes(4)
												+ "") - 5) / 2,
										y + 55, g);
							}
							g.drawImage(leftArrow, 545, 470, 25, 25, IO);
						}
					} else {
						// screen for defeating trainer
						g.drawImage(trainerDefeatedBackground, 135, 110, 445, 355, IO);
						g.setColor(Color.WHITE);
						drawString("congratulations", 170, 160 - 40, g);
						drawString("you have defeated", 145, 195 - 40, g);
						int x = 180;
						int y = 230 - 40;
						if (opponentShapemonOne != null) {
							drawShapemon(opponentShapemonOne.getTypeOfShapemon(), x, y, 100,
									100, g);
							x = x + 125;
						}
						if (opponentShapemonTwo != null) {
							drawShapemon(opponentShapemonTwo.getTypeOfShapemon(), x, y, 100,
									100, g);
							x = x + 125;
						}
						if (opponentShapemonThree != null) {
							drawShapemon(opponentShapemonThree.getTypeOfShapemon(), x, y,
									100, 100, g);
							x = 180;
							y = y + 125;
						}
						if (opponentShapemonFour != null) {
							drawShapemon(opponentShapemonFour.getTypeOfShapemon(), x, y,
									100, 100, g);
							x = x + 125;
						}
						if (opponentShapemonFive != null) {
							drawShapemon(opponentShapemonFive.getTypeOfShapemon(), x, y,
									100, 100, g);
							x = x + 125;
						}
						if (opponentShapemonSix != null) {
							drawShapemon(opponentShapemonSix.getTypeOfShapemon(), x, y, 100,
									100, g);
							x = x + 125;
						}
						if (getLength(opponent.getName()) % 10 == 0) {
							drawString(opponent.getName(),
									360 - getLength(opponent.getName()) / 2,
									465 - 40, g);
						} else {
							drawString(opponent.getName(),
									360 - (getLength(opponent.getName()) - 5) / 2,
									465 - 40, g);
						}
						g.drawImage(OK, 135, 470, 445, 70, IO);
						g.setColor(Color.BLACK);
						drawString("OK", 360 - getLength("ok") / 2, 490, g);
						if (selectPressed && selectReleased) {
							selectionDone = true;
						}
					}
				}
			} else {
				aiCoords.direction(aiCoords.changeDirection());
				g.drawImage(deathIcon, xPlayer - 25, yPlayer - 25, 150, 150, IO);
				xPlayer--;
				if (xPlayer < -110) {
					selectionDone = true;
				}
			}
			if (selectionDone) {
				g.setColor(Color.BLACK);
				g.fillRect(0, 0, 720, 720);
				captureChoice = 1;
				selected = false;
			}
		}
	}

	// draws shapemon
	private void drawShapemon(int typeOfShapemon, int x, int y, int xs, int ys, Graphics g) {
		switch (typeOfShapemon) {
			case 1:
				g.drawImage(circle, x, y, xs, ys, IO);
				break;
			case 2:
				g.drawImage(oppPacman, x, y, xs, ys, IO);
				break;
			case 3:
				g.drawImage(oppTriangle, x, y, xs, ys, IO);
				break;
			case 4:
				g.drawImage(square, x, y, xs, ys, IO);
				break;
			case 5:
				g.drawImage(pentagon, x, y, xs, ys, IO);
				break;
			case 6:
				g.drawImage(hexagon, x, y, xs, ys, IO);
				break;
			case 8:
				g.drawImage(octagon, x, y, xs, ys, IO);
				break;
			case 10:
				g.drawImage(star, x, y, xs, ys, IO);
				break;
			case 69:
				g.drawImage(oppNyan, x, y + 10, xs, ys, IO);
				break;
		}
	}

	// returns number of shapemon
	private int getNumberOfShapemon(Shapemon shp1, Shapemon shp2, Shapemon shp3, Shapemon shp4, Shapemon shp5,
			Shapemon shp6) {
		int num = 0;
		if (shp1 == null) {
			num = num + 0;
		} else if (shp1.isDead()) {
			num = num + 0;
		} else {
			num++;
		}
		if (shp2 == null) {
			num = num + 0;
		} else if (shp2.isDead()) {
			num = num + 0;
		} else {
			num++;
		}
		if (shp3 == null) {
			num = num + 0;
		} else if (shp3.isDead()) {
			num = num + 0;
		} else {
			num++;
		}
		if (shp4 == null) {
			num = num + 0;
		} else if (shp4.isDead()) {
			num = num + 0;
		} else {
			num++;
		}
		if (shp5 == null) {
			num = num + 0;
		} else if (shp5.isDead()) {
			num = num + 0;
		} else {
			num++;
		}
		if (shp6 == null) {
			num = num + 0;
		} else if (shp6.isDead()) {
			num = num + 0;
		} else {
			num++;
		}
		return num;
	}

	// returns time delay in between shots for
	// each type of move
	private int getDelay(int move) {
		switch (move) {
			case 1:
				return 16;
			case 2:
				return 16;
			case 3:
				return 20;
			case 4:
				return 20;
			case 5:
				return 24;
			case 6:
				return 24;
			case 7:
				return 20;
			case 8:
				return 16;
			case 9:
				return 26;
			case 10:
				return 20;
			case 11:
				return 16;
		}
		return 0;
	}

	// fires special move based on type of shapemon
	private void fireSpecial(boolean isPlayer) {
		shot = true;
		if (isPlayer) {
			switch (playerShapemon.getTypeOfShapemon()) {
				case 1:
					spMoveCDPlayer = 16;
					attackPower = (int) (opponentShapemon.getMaxHealth() / 12.5 + 1);
					playerBulletX.add(xPlayer + 100);
					playerBulletY.add(yPlayer + 40);
					bulletType.add(101);
					break;
				case 2:
					spMoveCDPlayer = 35;
					attackPower = (int) (playerShapemon.getMaxHealth() / 4 + 1);
					playerBulletX.add(-275);
					playerBulletY.add(yPlayer - 75);
					bulletType.add(102);
					break;
				case 3:
					spMoveCDPlayer = 16;
					attackPower = (int) (playerShapemon.getMaxHealth() / 12.5 + 1);
					playerBulletX.add(xPlayer + 100);
					playerBulletY.add(yPlayer + 40);
					bulletType.add(103);
					break;
				case 4:
					spMoveCDPlayer = 1;
					attackPower = (int) (playerShapemon.getMaxHealth() / 125 + 1);
					playerBulletX.add(xPlayer + 100);
					playerBulletY.add(yPlayer + 40);
					bulletType.add(104);
					break;
				case 5:
					spMoveCDPlayer = 20;
					attackPower = (int) (playerShapemon.getMaxHealth() / 10.5 + 1);
					playerBulletX.add(xPlayer + 100);
					playerBulletY.add(yPlayer + 40);
					bulletType.add(105);
					break;
				case 6:
					spMoveCDPlayer = 16;
					attackPower = (int) (playerShapemon.getMaxHealth() / 12.5 + 1);
					playerBulletX.add(xPlayer + 100);
					playerBulletY.add(yPlayer + 40);
					bulletType.add(106);
					break;
				case 8:
					spMoveCDPlayer = 20;
					attackPower = (int) (playerShapemon.getMaxHealth() / 10.5 + 1);
					playerBulletX.add(xPlayer + 100);
					playerBulletY.add(yPlayer + 40);
					bulletType.add(108);
					break;
				case 10:
					spMoveCDPlayer = 16;
					attackPower = (int) (playerShapemon.getMaxHealth() / 12.5 + 1);
					playerBulletX.add(xPlayer + 100);
					playerBulletY.add(yPlayer + 40);
					bulletType.add(110);
					break;
				case 69:
					spMoveCDPlayer = 1;
					attackPower = (int) (playerShapemon.getMaxHealth() / 125 + 1);
					playerBulletX.add(xPlayer + 100);
					playerBulletY.add(yPlayer + 40);
					bulletType.add(169);
					break;
			}
		} else {
			switch (opponentShapemon.getTypeOfShapemon()) {
				case 1:
					spMoveCDOpponent = 16;
					attackPowerOpp = (int) (opponentShapemon.getMaxHealth() / 12.5 + 1);
					opponentBulletX.add(xOpponent - 30);
					opponentBulletY.add(yOpponent + 40);
					bulletTypeOpp.add(101);
					break;
				case 2:
					spMoveCDOpponent = 35;
					attackPowerOpp = (int) (playerShapemon.getHealth() / 2 + 1);
					opponentBulletX.add(745);
					opponentBulletY.add(yOpponent - 75);
					bulletTypeOpp.add(102);
					break;
				case 3:
					spMoveCDOpponent = 20;
					attackPowerOpp = (int) (opponentShapemon.getMaxHealth() / 12.5 + 1);
					opponentBulletX.add(xOpponent - 30);
					opponentBulletY.add(yOpponent + 40);
					bulletTypeOpp.add(103);
					break;
				case 4:
					spMoveCDOpponent = 1;
					attackPowerOpp = (int) (opponentShapemon.getMaxHealth() / 125 + 1);
					opponentBulletX.add(xOpponent - 30);
					opponentBulletY.add(yOpponent + 40);
					bulletTypeOpp.add(104);
					break;
				case 5:
					spMoveCDOpponent = 20;
					attackPowerOpp = (int) (opponentShapemon.getMaxHealth() / 10.5 + 1);
					opponentBulletX.add(xOpponent - 30);
					opponentBulletY.add(yOpponent + 40);
					bulletTypeOpp.add(105);
					break;
				case 6:
					spMoveCDOpponent = 16;
					attackPowerOpp = (int) (opponentShapemon.getMaxHealth() / 12.5 + 1);
					opponentBulletX.add(xOpponent - 30);
					opponentBulletY.add(yOpponent + 40);
					bulletTypeOpp.add(106);
					break;
				case 8:
					spMoveCDOpponent = 20;
					attackPowerOpp = (int) (opponentShapemon.getMaxHealth() / 10.5 + 1);
					opponentBulletX.add(xOpponent - 30);
					opponentBulletY.add(yOpponent + 40);
					bulletTypeOpp.add(108);
					break;
				case 10:
					spMoveCDOpponent = 16;
					attackPowerOpp = (int) (opponentShapemon.getMaxHealth() / 12.5 + 1);
					opponentBulletX.add(xOpponent - 30);
					opponentBulletY.add(yOpponent + 40);
					bulletTypeOpp.add(110);
					break;
				case 69:
					spMoveCDOpponent = 1;
					attackPowerOpp = (int) (opponentShapemon.getMaxHealth() / 125 + 1);
					opponentBulletX.add(xOpponent - 30);
					opponentBulletY.add(yOpponent + 40);
					bulletTypeOpp.add(169);
					break;
			}
		}
	}

	// shoots bullet from opponent
	private void opponentShoot(int move) {
		if (move != 0) {
			oppShot = true;
			switch (move) {
				case 1:
					attackPowerOpp = (int) (opponentShapemon.getMaxHealth() / 15.0 + 1);
					opponentBulletX.add(xOpponent - 30);
					opponentBulletY.add(yOpponent + 40);
					bulletTypeOpp.add(1);
					break;
				case 2:
					attackPowerOpp = (int) (opponentShapemon.getMaxHealth() / 17.5 + 1);
					opponentBulletX.add(xOpponent - 30);
					opponentBulletY.add(yOpponent + 40);
					bulletTypeOpp.add(2);
					break;
				case 3:
					attackPowerOpp = (int) (opponentShapemon.getMaxHealth() / 20.0 + 1);
					opponentBulletX.add(xOpponent - 30);
					opponentBulletY.add(yOpponent + 40);
					bulletTypeOpp.add(3);
					break;
				case 4:
					attackPowerOpp = (int) (opponentShapemon.getMaxHealth() / 22.5 + 1);
					opponentBulletX.add(xOpponent - 30);
					opponentBulletY.add(yOpponent + 40);
					bulletTypeOpp.add(4);
					break;
				case 5:
					attackPowerOpp = (int) (opponentShapemon.getMaxHealth() / 25.0 + 1);
					opponentBulletX.add(xOpponent - 30);
					opponentBulletY.add(yOpponent + 40);
					bulletTypeOpp.add(5);
					break;
				case 6:
					attackPowerOpp = (int) (opponentShapemon.getMaxHealth() / 27.5 + 1);
					opponentBulletX.add(xOpponent - 30);
					opponentBulletY.add(yOpponent + 40);
					bulletTypeOpp.add(6);
					break;
				case 7:
					attackPowerOpp = (int) (opponentShapemon.getMaxHealth() / 30.0 + 1);
					opponentBulletX.add(xOpponent - 30);
					opponentBulletY.add(yOpponent + 40);
					bulletTypeOpp.add(7);
					break;
				case 8:
					attackPowerOpp = (int) (opponentShapemon.getMaxHealth() / 32.5 + 1);
					opponentBulletX.add(xOpponent - 30);
					opponentBulletY.add(yOpponent + 40);
					bulletTypeOpp.add(8);
					break;
				case 9:
					attackPowerOpp = (int) (opponentShapemon.getMaxHealth() / 22.5 + 1);
					opponentBulletX.add(xOpponent - 30);
					opponentBulletY.add(yOpponent + 40);
					bulletTypeOpp.add(9);
					break;
				case 10:
					attackPowerOpp = (int) (opponentShapemon.getMaxHealth() / 32.5 + 1);
					opponentBulletX.add(xOpponent - 30);
					opponentBulletY.add(yOpponent + 40);
					bulletTypeOpp.add(10);
					break;
				case 11:
					attackPowerOpp = (int) (opponentShapemon.getMaxHealth() / 12.5 + 1);
					opponentBulletX.add(xOpponent - 30);
					opponentBulletY.add(yOpponent + 40);
					bulletTypeOpp.add(11);
					break;
			}
		}
	}

	// shoots bullet from player
	private void playerShoot(int move) {
		if (move != 0) {
			shot = true;
			switch (move) {
				case 1:
					attackPower = (int) (playerShapemon.getMaxHealth() / 15.0 + 1);
					playerBulletX.add(xPlayer + 100);
					playerBulletY.add(yPlayer + 40);
					bulletType.add(1);
					break;
				case 2:
					attackPower = (int) (playerShapemon.getMaxHealth() / 17.5 + 1);
					playerBulletX.add(xPlayer + 100);
					playerBulletY.add(yPlayer + 40);
					bulletType.add(2);
					break;
				case 3:
					attackPower = (int) (playerShapemon.getMaxHealth() / 20.0 + 1);
					playerBulletX.add(xPlayer + 100);
					playerBulletY.add(yPlayer + 40);
					bulletType.add(3);
					break;
				case 4:
					attackPower = (int) (playerShapemon.getMaxHealth() / 22.5 + 1);
					playerBulletX.add(xPlayer + 100);
					playerBulletY.add(yPlayer + 40);
					bulletType.add(4);
					break;
				case 5:
					attackPower = (int) (playerShapemon.getMaxHealth() / 25.0 + 1);
					playerBulletX.add(xPlayer + 100);
					playerBulletY.add(yPlayer + 40);
					bulletType.add(5);
					break;
				case 6:
					attackPower = (int) (playerShapemon.getMaxHealth() / 27.5 + 1);
					playerBulletX.add(xPlayer + 100);
					playerBulletY.add(yPlayer + 40);
					bulletType.add(6);
					break;
				case 7:
					attackPower = (int) (playerShapemon.getMaxHealth() / 30.0 + 1);
					playerBulletX.add(xPlayer + 100);
					playerBulletY.add(yPlayer + 40);
					bulletType.add(7);
					break;
				case 8:
					attackPower = (int) (playerShapemon.getMaxHealth() / 32.5 + 1);
					playerBulletX.add(xPlayer + 100);
					playerBulletY.add(yPlayer + 40);
					bulletType.add(8);
					break;
				case 9:
					attackPower = (int) (playerShapemon.getMaxHealth() / 22.5 + 1);
					playerBulletX.add(xPlayer + 100);
					playerBulletY.add(yPlayer + 40);
					bulletType.add(9);
					break;
				case 10:
					attackPower = (int) (playerShapemon.getMaxHealth() / 32.5 + 1);
					playerBulletX.add(xPlayer + 100);
					playerBulletY.add(yPlayer + 40);
					bulletType.add(10);
					break;
				case 11:
					attackPower = (int) (playerShapemon.getMaxHealth() / 12.5 + 1);
					playerBulletX.add(xPlayer + 100);
					playerBulletY.add(yPlayer + 40);
					bulletType.add(11);
					break;
			}
		}
	}

	// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	// resets all fields and sets new player and opponent
	public void runBattle(Player p, Shapemon o) {
		player = p;
		playerShapemonOne = player.getShapemon(1);
		playerShapemonTwo = player.getShapemon(2);
		playerShapemonThree = player.getShapemon(3);
		playerShapemonFour = player.getShapemon(4);
		playerShapemonFive = player.getShapemon(5);
		playerShapemonSix = player.getShapemon(6);
		playerShapemon = playerShapemonOne;
		opponent = new Player(o);
		opponentShapemonOne = opponent.getShapemon(1);
		opponentShapemonTwo = opponent.getShapemon(2);
		opponentShapemonThree = opponent.getShapemon(3);
		opponentShapemonFour = opponent.getShapemon(4);
		opponentShapemonFive = opponent.getShapemon(5);
		opponentShapemonSix = opponent.getShapemon(6);
		opponentShapemon = opponentShapemonOne;
		wild = true;
		battling = true;
		selectionDone = false;
		frame = 0;
		aiCoords.reset();
		xPlayer = 130;
		yPlayer = 310;

		playerShapemonChoice = 1;
		opponentShapemonChoice = 1;
		playerBulletX = new ArrayList<Integer>();
		playerBulletY = new ArrayList<Integer>();
		opponentBulletX = new ArrayList<Integer>();
		opponentBulletY = new ArrayList<Integer>();
		bulletType = new ArrayList<Integer>();
		bulletTypeOpp = new ArrayList<Integer>();
		shot = false;
		oppShot = false;
		hit = false;
		oppHit = false;
		died = false;
		addedShapecubes = false;
		leveledUp = false;
		specialReady = false;

		attackChoice = 1;
		attackChoiceOpp = 1;
		captureChoice = 1;
		caught = false;
		caughtTimer = 0;
		attackPower = 0;
		attackPowerOpp = 0;
		timer = 0;
		timerOpp = 0;
		expFlashCounter = 0;
		specialCounter = 0;
		specialCounterOpp = 0;
		spMoveCounterPlayer = 0;
		spMoveCounterOpponent = 0;
		spMoveCDPlayer = 0;
		spMoveCDOpponent = 0;

	}

	public void runBattle(Player p, Player o) {
		player = p;
		playerShapemonOne = player.getShapemon(1);
		playerShapemonTwo = player.getShapemon(2);
		playerShapemonThree = player.getShapemon(3);
		playerShapemonFour = player.getShapemon(4);
		playerShapemonFive = player.getShapemon(5);
		playerShapemonSix = player.getShapemon(6);
		playerShapemon = playerShapemonOne;
		opponent = o;
		opponentShapemonOne = opponent.getShapemon(1);
		opponentShapemonTwo = opponent.getShapemon(2);
		opponentShapemonThree = opponent.getShapemon(3);
		opponentShapemonFour = opponent.getShapemon(4);
		opponentShapemonFive = opponent.getShapemon(5);
		opponentShapemonSix = opponent.getShapemon(6);
		opponentShapemon = opponentShapemonOne;
		wild = false;
		battling = true;
		selectionDone = false;
		frame = 0;
		aiCoords.reset();
		xPlayer = 130;
		yPlayer = 310;

		playerShapemonChoice = 1;
		opponentShapemonChoice = 1;
		playerBulletX = new ArrayList<Integer>();
		playerBulletY = new ArrayList<Integer>();
		opponentBulletX = new ArrayList<Integer>();
		opponentBulletY = new ArrayList<Integer>();
		bulletType = new ArrayList<Integer>();
		bulletTypeOpp = new ArrayList<Integer>();
		shot = false;
		oppShot = false;
		hit = false;
		oppHit = false;
		died = false;
		addedShapecubes = false;
		leveledUp = false;
		specialReady = false;

		attackChoice = 1;
		attackChoiceOpp = 1;
		captureChoice = 1;
		caughtTimer = 0;
		attackPower = 0;
		attackPowerOpp = 0;
		timer = 0;
		timerOpp = 0;
		expFlashCounter = 0;
		specialCounter = 0;
		specialCounterOpp = 0;
		spMoveCounterPlayer = 0;
		spMoveCounterOpponent = 0;
		spMoveCDPlayer = 0;
		spMoveCDOpponent = 0;
	}

	// button presses
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

	public void selectPressed() {
		selectPressed = true;
	}

	public void selectReleased() {
		selectPressed = false;
		selectReleased = true;
	}

	public void specialMovePressed() {
		specialMovePressed = true;
	}

	public void specialMoveReleased() {
		specialMovePressed = false;
		specialMoveReleased = true;
	}

	public void switchMovePressed() {
		switchMovePressed = true;
	}

	public void switchMoveReleased() {
		switchMovePressed = false;
		switchMoveReleased = true;
	}

	// NEEDED ONLY FOR SOUNDEFFECTS
	public boolean shot() {
		return shot;
	}

	public boolean oppShot() {
		return oppShot;
	}

	public boolean hit() {
		return hit;
	}

	public boolean oppHit() {
		return oppHit;
	}

	public boolean died() {
		return died;
	}

	// if player wins
	public boolean playerWins() {
		return playerWins;
	}

	// when program is done running
	public boolean isBattling() {
		return !selectionDone;
	}

	// draw String in special font
	private void drawString(String s, int x, int y, Graphics g) {
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

	// returns length in pixels of a string (in special font)
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
	// pleasedon'tmakemecommenteverysingleoneofthesemethods
	private void drawA(int x, int y, Graphics g) {
		g.fillRect(x + 5, y, 10, 5);
		g.fillRect(x + 15, y + 5, 5, 25);
		g.fillRect(x, y + 5, 5, 25);
		g.fillRect(x + 5, y + 15, 10, 5);
	}

	private void drawB(int x, int y, Graphics g) {
		g.fillRect(x + 5, y, 10, 5);
		g.fillRect(x + 15, y + 5, 5, 5);
		g.fillRect(x, y, 5, 30);
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
		g.fillRect(x, y, 5, 30);
		g.fillRect(x + 5, y + 25, 10, 5);
	}

	private void drawE(int x, int y, Graphics g) {
		g.fillRect(x + 5, y, 15, 5);
		g.fillRect(x, y, 5, 30);
		g.fillRect(x + 5, y + 25, 15, 5);
		g.fillRect(x + 5, y + 10, 10, 5);
	}

	private void drawF(int x, int y, Graphics g) {
		g.fillRect(x + 5, y, 15, 5);
		g.fillRect(x, y, 5, 30);
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
		g.fillRect(x + 15, y, 5, 5);
		g.fillRect(x + 10, y + 5, 5, 5);
		g.fillRect(x + 5, y + 10, 5, 5);
		g.fillRect(x + 10, y + 15, 5, 5);
		g.fillRect(x + 15, y + 20, 5, 10);
	}

	private void drawL(int x, int y, Graphics g) {
		g.fillRect(x, y, 5, 30);
		g.fillRect(x + 5, y + 25, 15, 5);

	}

	private void drawM(int x, int y, Graphics g) {
		g.fillRect(x, y, 5, 30);
		g.fillRect(x + 20, y, 5, 30);
		g.fillRect(x + 5, y + 5, 5, 5);
		g.fillRect(x + 10, y + 10, 5, 5);
		g.fillRect(x + 15, y + 5, 5, 5);
	}

	private void drawN(int x, int y, Graphics g) {
		g.fillRect(x, y, 5, 30);
		g.fillRect(x + 15, y, 5, 30);
		g.fillRect(x + 5, y + 5, 5, 5);
		g.fillRect(x + 10, y + 10, 5, 5);
	}

	private void drawO(int x, int y, Graphics g) {
		g.fillRect(x + 5, y, 10, 5);
		g.fillRect(x + 15, y + 5, 5, 20);
		g.fillRect(x, y + 5, 5, 20);
		g.fillRect(x + 5, y + 25, 10, 5);
	}

	private void drawP(int x, int y, Graphics g) {
		g.fillRect(x, y, 5, 30);
		g.fillRect(x + 5, y, 10, 5);
		g.fillRect(x + 5, y + 15, 10, 5);
		g.fillRect(x + 15, y + 5, 5, 10);
	}

	private void drawQ(int x, int y, Graphics g) {
		g.fillRect(x + 5, y, 10, 5);
		g.fillRect(x + 15, y + 5, 5, 20);
		g.fillRect(x, y + 5, 5, 20);
		g.fillRect(x + 5, y + 25, 20, 5);
	}

	private void drawR(int x, int y, Graphics g) {
		g.fillRect(x, y, 5, 30);
		g.fillRect(x + 5, y, 10, 5);
		g.fillRect(x + 5, y + 15, 10, 5);
		g.fillRect(x + 15, y + 5, 5, 10);
		g.fillRect(x + 15, y + 20, 5, 10);
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
		g.fillRect(x + 5, y, 10, 5);
		g.fillRect(x + 15, y + 5, 5, 20);
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

	private void drawSlash(int x, int y, Graphics g) {
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
		g.fillRect(x, y, 5, 30);
		g.fillRect(x + 5, y, 5, 5);
		g.fillRect(x + 5, y + 25, 5, 5);
	}

	private void drawBackBracket(int x, int y, Graphics g) {
		g.fillRect(x + 5, y, 5, 30);
		g.fillRect(x, y, 5, 5);
		g.fillRect(x, y + 25, 5, 5);
	}

	private void drawBackSlash(int x, int y, Graphics g) {
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

	public Shapemon[] getStorage() {
		return SwitchShape.storage;
	}

}
