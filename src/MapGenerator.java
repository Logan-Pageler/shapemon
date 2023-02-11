import java.awt.*;
/*Author: Logan
 * Completion: 5/18/18
 * 
 * Job:convert arrays into graphics to display as well as display menus
 */

import javax.swing.*;
public class MapGenerator extends JPanel {
	Dialogue dialogue = new Dialogue();

	private int dialogueX = 20;
	private int shapemonCenterNumber = 1;
	private int x = 0;
	private int y = 0;
	private int [] n;
	private int [] n2;
	private int [] n3;
	private int [] n4;
	private int [] n5;
	private int removed;

	private boolean swimming = false;

	private boolean finalBattle = false;

	private Color c = new Color(200,200,200);
	private Shapemon[] storage = {new ShapemonBlank(),new ShapemonBlank(),new ShapemonBlank(),new ShapemonBlank(),new ShapemonBlank(),new ShapemonBlank(),new ShapemonBlank(),new ShapemonBlank(),new ShapemonBlank(),new ShapemonBlank(),new ShapemonBlank(),new ShapemonBlank(),};
	private boolean upPressed = false;
	private boolean leftPressed = false;
	private boolean downPressed = false;
	private boolean rightPressed = false;
	private boolean enterPressed = false;
	private boolean upReleased = true;
	private boolean leftReleased = true;
	private boolean downReleased = true;
	private boolean rightReleased = true;
	private boolean enterReleased = true;
	Shapemon oldShape = new ShapemonBlank();	
	Shapemon newShape = new ShapemonBlank();
	private int wu = 1;
	private int ws = 1;
	private Image check = (new ImageIcon("check.gif").getImage());
	private Image check2 = (new ImageIcon("check2.gif").getImage());
	private Image select1 =(new ImageIcon("select1.gif").getImage());
	private Image select1pt2 =(new ImageIcon("select1pt2.gif").getImage());
	private Image select7 =(new ImageIcon("select7.gif").getImage());
	private Image select7pt2 =(new ImageIcon("select7pt2.gif").getImage());
	private Image storage1 = (new ImageIcon("storage1.gif").getImage());
	private Image storage2 = (new ImageIcon("storage2.gif").getImage());
	private Image leftArrow = (new ImageIcon("left.gif").getImage());
	private Image rightArrow = (new ImageIcon("right.gif").getImage());
	private Image left2 = (new ImageIcon("left2.gif").getImage());
	private Image right2 = (new ImageIcon("right2.gif").getImage());
	private Image nyan = (new ImageIcon("NyanCat.gif").getImage());
	private Image pacman = (new ImageIcon("Pacman.gif").getImage());
	private Image star = (new ImageIcon("StarAnim.gif").getImage());
	private Image circle = (new ImageIcon("Circle.gif").getImage());
	private Image triangle = (new ImageIcon("Triangle.gif").getImage());
	private Image square = (new ImageIcon("Square.gif").getImage());
	private Image pentagon = (new ImageIcon("Pentagon.gif").getImage());
	private Image hexagon = (new ImageIcon("Hexagon.gif").getImage());
	private Image octagon = (new ImageIcon("Octagon.gif").getImage());
	private Image blank = (new ImageIcon("blank.gif").getImage());

	private int movingDirection = 0;

	private boolean menuOpen = true;
	int menuPart = 0;
	private boolean select = false;

	private int selected = 1;
	private Color box1 = new Color(200,200,200);
	private Color box2 = new Color(200,200,200);
	private Color box3 = new Color(200,200,200);
	private Color box4 = new Color(200,200,200);
	private Color box5 = new Color(200,200,200);
	private Color box6 = new Color(200,200,200);
	private Color box7 = new Color(200,200,200);

	private int up = 'W';
	private int left = 'A';
	private int down = 'S';
	private int right = 'D';
	private int menuKey  = 27;
	private int selectKey = 10;

	private boolean selectUpKey = false;
	private boolean selectLeftKey = false;
	private boolean selectDownKey = false;
	private boolean selectRightKey = false;
	private boolean selectSelectKey = false;
	private boolean selectMenuKey = false;

	private int frame = 0;

	private int f = 0;

	private String playerSprite = "PlayerUpStill.gif";

	private int XShift = 0;
	private int YShift = 0;

	private Image grassTile = new ImageIcon("GrassTile.gif").getImage();
	private Image proffesor = new ImageIcon("Proffesor.gif").getImage();
	private Image house1Tile1 = new ImageIcon("House1Tile1.gif").getImage();
	private Image house1Tile2 = new ImageIcon("House1Tile2.gif").getImage();
	private Image house1Tile3 = new ImageIcon("House1Tile3.gif").getImage();
	private Image house1Tile4 = new ImageIcon("House1Tile4.gif").getImage();
	private Image house1Tile5 = new ImageIcon("House1Tile5.gif").getImage();
	private Image house1Tile6 = new ImageIcon("House1Tile6.gif").getImage();
	private Image house1Tile7 = new ImageIcon("House1Tile7.gif").getImage();
	private Image house1Tile8 = new ImageIcon("House1Tile8.gif").getImage();
	private Image house1Tile9 = new ImageIcon("House1Tile9.gif").getImage();
	private Image house1Tile10 = new ImageIcon("House1Tile10.gif").getImage();
	private Image house1Tile11 = new ImageIcon("House1Tile11.gif").getImage();
	private Image house1Tile12 = new ImageIcon("House1Tile12gif").getImage();
	private Image house1Tile13 = new ImageIcon("House1Tile13.gif").getImage();
	private Image house1Tile14 = new ImageIcon("House1Tile14.gif").getImage();
	private Image house1Tile15 = new ImageIcon("House1Tile15.gif").getImage();
	private Image house1Tile16 = new ImageIcon("House1Tile16.gif").getImage();
	private Image lightSand = new ImageIcon("LightSand.gif").getImage();
	private Image pathBottom = new ImageIcon("PathBottom.gif").getImage();
	private Image pathBottomLeft1 = new ImageIcon("PathBottomLeft1.gif").getImage();
	private Image pathBottomLeft2 = new ImageIcon("PathBottomLeft2.gif").getImage();
	private Image pathBottomRight1 = new ImageIcon("PathBottomRight1.gif").getImage();
	private Image pathBottomRight2 = new ImageIcon("PathBottomRight2.gif").getImage();
	private Image pathCenter = new ImageIcon("PathCenter.gif").getImage();

	private Image shapemonTitle = new ImageIcon("ShapemonTitle.gif").getImage();

	private boolean playSwimmingAnimation = false;
	private int swimmingAnimationPart = 1;

	private Image treeTopRight = new ImageIcon("TreeTopRight.gif").getImage();
	private Image treeTopLeft = new ImageIcon("TreeTopLeft.gif").getImage();
	private Image treeMiddleRight = new ImageIcon("TreeMiddleRight.gif").getImage();
	private Image treeMiddleLeft = new ImageIcon("TreeMiddleLeft.gif").getImage();
	private Image treeBottomRight = new ImageIcon("TreeBottomRight.gif").getImage();
	private Image treeBottomLeft = new ImageIcon("TreeBottomLeft.gif").getImage();
	private Image tallGrass = new ImageIcon("TallGrass.gif").getImage();
	private Image rockTile = new ImageIcon("RockTile.gif").getImage();
	private Image waterTile = new ImageIcon("WaterTile.gif").getImage();
	private Image waterTile1 = new ImageIcon("WaterTile1.gif").getImage();
	private Image waterTile2 = new ImageIcon("WaterTile2.gif").getImage();
	private Image waterGroundMurgeGroundUp1 = new ImageIcon("WaterGroundMurgeGroundUp1.gif").getImage();
	private Image waterGroundMurgeGroundUp2 = new ImageIcon("WaterGroundMurgeGroundUp2.gif").getImage();
	private Image waterGroundMurgeGroundLeft1 = new ImageIcon("WaterGroundMurgeGroundLeft1.gif").getImage();
	private Image waterGroundMurgeGroundLeft2 = new ImageIcon("WaterGroundMurgeGroundleft2.gif").getImage();
	private Image waterGroundMurgeGroundDown1 = new ImageIcon("WaterGroundMurgeGroundDown1.gif").getImage();
	private Image waterGroundMurgeGroundDown2 = new ImageIcon("WaterGroundMurgeGroundDown2.gif").getImage();
	private Image waterGroundMurgeGroundRight1 = new ImageIcon("WaterGroundMurgeGroundRight1.gif").getImage();
	private Image waterGroundMurgeGroundRight2 = new ImageIcon("WaterGroundMurgeGroundRight2.gif").getImage();
	private Image waterGroundMurgeWaterUpLeft1 = new ImageIcon("WaterGroundMurgeWaterUpLeft1.gif").getImage();
	private Image waterGroundMurgeWaterUpLeft2 = new ImageIcon("WaterGroundMurgeWaterUpLeft2.gif").getImage();
	private Image waterGroundMurgeWaterUpRight1 = new ImageIcon("WaterGroundMurgeWaterUpRight1.gif").getImage();
	private Image waterGroundMurgeWaterUpRight2 = new ImageIcon("WaterGroundMurgeWaterUpRight2.gif").getImage();
	private Image waterGroundMurgeWaterDownLeft1 = new ImageIcon("WaterGroundMurgeWaterDownLeft1.gif").getImage();
	private Image waterGroundMurgeWaterDownLeft2 = new ImageIcon("WaterGroundMurgeWaterDownLeft2.gif").getImage();
	private Image waterGroundMurgeWaterDownRight1 = new ImageIcon("WaterGroundMurgeWaterDownRight1.gif").getImage();
	private Image waterGroundMurgeWaterDownRight2 = new ImageIcon("WaterGroundMurgeWaterDownRight2.gif").getImage();
	private Image waterGroundMurgeGroundUpLeft1 = new ImageIcon("WaterGroundMurgeGroundUpLeft1.gif").getImage();
	private Image waterGroundMurgeGroundUpLeft2 = new ImageIcon("WaterGroundMurgeGroundUpLeft2.gif").getImage();
	private Image waterGroundMurgeGroundUpRight1 = new ImageIcon("WaterGroundMurgeGroundUpRight1.gif").getImage();
	private Image waterGroundMurgeGroundUpRight2 = new ImageIcon("WaterGroundMurgeGroundUpRight2.gif").getImage();
	private Image waterGroundMurgeGroundDownLeft1 = new ImageIcon("WaterGroundMurgeGroundDownLeft1.gif").getImage();
	private Image waterGroundMurgeGroundDownLeft2 = new ImageIcon("WaterGroundMurgeGroundDownLeft2.gif").getImage();
	private Image waterGroundMurgeGroundDownRight1 = new ImageIcon("WaterGroundMurgeGroundDownRight1.gif").getImage();
	private Image waterGroundMurgeGroundDownRight2 = new ImageIcon("WaterGroundMurgeGroundDownRight2.gif").getImage();

	private Image hillTileFront = new ImageIcon("HillTileFront.gif").getImage();
	private Image hillTileLeft = new ImageIcon("HillTileLeft.gif").getImage();
	private Image hillTileRight = new ImageIcon("HillTileRight.gif").getImage();
	private Image hillTileTop = new ImageIcon("HillTileTop.gif").getImage();
	private Image hillTileGroundDownLeft = new ImageIcon("HillTileGroundDownLeft.gif").getImage();
	private Image hillTileGroundDownRight = new ImageIcon("HillTileGroundDownRight.gif").getImage();
	private Image hillTileGroundUpLeft = new ImageIcon("HillTileGroundUpLeft.gif").getImage();
	private Image hillTileGroundUpRight = new ImageIcon("HillTileGroundUpRight.gif").getImage();
	private Image hillTileHillDownLeft = new ImageIcon("HillTileHillDownLeft.gif").getImage();
	private Image hillTileHillDownRight = new ImageIcon("HillTileHillDownRight.gif").getImage();
	private Image hillTileHillUpLeft = new ImageIcon("HillTileHillUpLeft.gif").getImage();
	private Image hillTileHillUpRight = new ImageIcon("HillTileHillUpRight.gif").getImage();

	private Image waterMurgeUp = new ImageIcon("WaterMurgeUp.gif").getImage();
	private Image waterMurgeLeft = new ImageIcon("WaterMurgeLeft.gif").getImage();
	private Image waterMurgeDown = new ImageIcon("WaterMurgeDown.gif").getImage();
	private Image waterMurgeRight = new ImageIcon("WaterMurgeRight.gif").getImage();
	private Image waterMurgeSandUpLeft = new ImageIcon("WaterMurgeSandUpLeft.gif").getImage();
	private Image waterMurgeSandUpRight = new ImageIcon("WaterMurgeSandUpRight.gif").getImage();
	private Image waterMurgeSandDownLeft = new ImageIcon("WaterMurgeSandDownLeft.gif").getImage();
	private Image waterMurgeSandDownRight = new ImageIcon("WaterMurgeSandDownRight.gif").getImage();
	private Image waterMurgeWaterUpLeft = new ImageIcon("WaterMurgeWaterUpLeft.gif").getImage();
	private Image waterMurgeWaterUpRight = new ImageIcon("WaterMurgeWaterUpRight.gif").getImage();
	private Image waterMurgeWaterDownLeft = new ImageIcon("WaterMurgeWaterDownLeft.gif").getImage();
	private Image waterMurgeWaterDownRight = new ImageIcon("WaterMurgeWaterDownRight.gif").getImage();

	private Image lightSandCorner1 = new ImageIcon("LightSandCorner1.gif").getImage();
	private Image lightSandCorner2 = new ImageIcon("LightSandCorner2.gif").getImage();
	private Image lightSandCorner3 = new ImageIcon("LightSandCorner3.gif").getImage();
	private Image lightSandCorner4 = new ImageIcon("LightSandCorner4.gif").getImage();

	private Image shapemonCenter = new ImageIcon("ShapemonCenter.gif").getImage();
	private Image shapemonCenterInside = new ImageIcon("ShapemonCenterInside.gif").getImage();
	private Image house2 = new ImageIcon("house2.gif").getImage();
	private Image house3 = new ImageIcon("house3.gif").getImage();
	private Image house4 = new ImageIcon("house4.gif").getImage();
	private Image house5 = new ImageIcon("house5.gif").getImage();
	private Image breakableRock = new ImageIcon("breakableRock.gif").getImage();
	private Image breakableTree = new ImageIcon("breakableTree.gif").getImage();

	private Image stairRightTop = new ImageIcon("StairRightTop.gif").getImage();
	private Image stairRightBottom = new ImageIcon("StairRightBottom.gif").getImage();
	private Image stairRightTop2 = new ImageIcon("StairRightTop2.gif").getImage();
	private Image stairRightBottom2 = new ImageIcon("StairRightBottom2.gif").getImage();
	private Image stairRightCenter = new ImageIcon("StairRightCenter.gif").getImage();
	private Image stairForwardRight = new ImageIcon("StairForwardRight.gif").getImage();
	private Image stairForwardCenter = new ImageIcon("StairForwardCenter.gif").getImage();
	private Image stairForwardLeft = new ImageIcon("StairForwardLeft.gif").getImage();
	private Battle battle;
	private Player player;
	SaveFile saveFile = new SaveFile("ShapemonSaveFile.txt", "C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\ShapemonSaveFile.txt");
	int shapeNew, shapeOld;

	public MapGenerator(int [] mapP1, int[] mapP2, int[] mapP3, int[] mapP4, int[] mapP5, Player player, Battle battle) {
		this.battle = battle;
		n = mapP1;
		n2 = mapP2;
		n3 = mapP3;
		n4 = mapP4;
		n5 = mapP5;
		this.player = player;

		if(n[1] * n[0] + 3 < n.length) {
			y = (0-64 * (n[n[1] * n[0] + 3] ) + 394);
		} else if(n[1] * n[0] + 3 - n.length < n2.length) {
			y = (0 - 64 * n2[n[1] * n[0] + 3 - n.length] + 394);
		} else if(n[1] * n[0] + 3 - n.length - n2.length < n3.length) {
			y = (0-64 * (n3[n[1] * n[0] + 3 - n.length - n2.length] ) + 392);
		} else if(n[1] * n[0] + 3 - n.length - n2.length - n3.length < n4.length) {
			y = (0-64 * (n4[n[1] * n[0] + 3 - n.length - n2.length - n3.length] ) + 392);
		} else if(n[1] * n[0] + 3 - n.length - n2.length - n3.length - n4.length< n5.length) {
			y = (0-64 * (n5[n[1] * n[0] + 3 - n.length - n2.length -n3.length - n4.length] ) + 392);

		}

		if(n[1] * n[0] + 2 < n.length) {
			x = (0-64 * (n[n[1] * n[0] + 2] ) + 392);
		} else if(n[1] * n[0] + 2 - n.length < n2.length) {
			x = (0-64 * (n2[n[1] * n[0] + 2 - n.length] ) + 392);
		} else if(n[1] * n[0] + 2 - n.length - n2.length < n3.length) {
			x = (0-64 * (n3[n[1] * n[0] + 2 - n.length - n2.length] ) + 392);
		} else if(n[1] * n[0] + 2 - n.length - n2.length - n3.length < n4.length) {
			x = (0-64 * (n4[n[1] * n[0] + 2 - n.length - n2.length - n3.length] ) + 392);
		} else if(n[1] * n[0] + 2 - n.length - n2.length - n3.length - n4.length< n5.length) {
			x = (0-64 * (n5[n[1] * n[0] + 2 - n.length - n2.length -n3.length - n4.length] ) + 392);
		}



	}

	//paint graphics
	public void paintComponent(Graphics g) {

		//spawn in animated tiles to help stop desync
		super.paintComponent(g);
		g.drawImage(waterGroundMurgeGroundUp1,1,1,1,1,null);
		g.drawImage(waterGroundMurgeGroundUp2,1,1,1,1,null);
		g.drawImage(waterGroundMurgeGroundLeft1,1,1,1,1,null);
		g.drawImage(waterGroundMurgeGroundLeft2,1,1,1,1,null);
		g.drawImage(waterGroundMurgeGroundDown1,1,1,1,1,null);
		g.drawImage(waterGroundMurgeGroundDown2,1,1,1,1,null);
		g.drawImage(waterGroundMurgeGroundRight1,1,1,1,1,null);
		g.drawImage(waterGroundMurgeGroundRight2,1,1,1,1,null);
		g.drawImage(waterGroundMurgeGroundUpRight1,1,1,1,1,null);
		g.drawImage(waterGroundMurgeGroundUpRight2,1,1,1,1,null);
		g.drawImage(waterGroundMurgeGroundUpLeft1,1,1,1,1,null);
		g.drawImage(waterGroundMurgeGroundUpLeft2,1,1,1,1,null);
		g.drawImage(waterGroundMurgeGroundDownRight1,1,1,1,1,null);
		g.drawImage(waterGroundMurgeGroundDownRight2,1,1,1,1,null);
		g.drawImage(waterGroundMurgeGroundDownLeft1,1,1,1,1,null);
		g.drawImage(waterGroundMurgeGroundDownLeft2,1,1,1,1,null);
		g.drawImage(waterGroundMurgeWaterUpRight1,1,1,1,1,null);
		g.drawImage(waterGroundMurgeWaterUpRight2,1,1,1,1,null);
		g.drawImage(waterGroundMurgeWaterUpLeft1,1,1,1,1,null);
		g.drawImage(waterGroundMurgeWaterUpLeft2,1,1,1,1,null);
		g.drawImage(waterGroundMurgeWaterDownRight1,1,1,1,1,null);
		g.drawImage(waterGroundMurgeWaterDownRight2,1,1,1,1,null);
		g.drawImage(waterGroundMurgeWaterDownLeft1,1,1,1,1,null);
		g.drawImage(waterGroundMurgeWaterDownLeft2,1,1,1,1,null);

		g.drawImage(waterTile1,1,1,1,1,null);
		g.drawImage(waterTile2,1,1,1,1,null);


		if(menuPart != 0 && menuPart != 3) {


			drawTiles(g);


			if(movingDirection == 0) {

				g.drawImage(new ImageIcon(playerSprite).getImage(), 328,290,64,100,null);
			}else if(movingDirection == 1) {
				g.drawImage(new ImageIcon(playerSprite).getImage(), 328,290,64,100,null);
			}else if(movingDirection == 2) {
				g.drawImage(new ImageIcon(playerSprite).getImage(), 328,290,64,100,null);
			}else if(movingDirection == 3) {
				g.drawImage(new ImageIcon(playerSprite).getImage(), 328,290,64,100,null);
			}

		}
		//draw if menu open
		if(menuOpen) {
			//draw home screen
			if(menuPart == 0) {
				if(frame < 300) {
					g.setColor(Color.BLACK);
					g.fillRect(0, 0, 720, 720);


					//start up animation
					if(frame<60) {
						int starX = (int)(Math.cos((12 * (frame - 1) + 90)*Math.PI/180) * (360 - 6 * frame) + 360);
						int starY = (int)(360 - Math.sin((12   * (frame - 1) + 90)*Math.PI/180) * (360 - 6 * frame - 1));
						g.setColor(Color.RED);
						drawStar(starX,starY,50,g);
					}
					if(frame>=60 && frame<90) {
						g.drawImage((new ImageIcon("Logo1.gif")).getImage(),0,0,720,720,null);
					}
					if(frame>=90 && frame<135) {
						g.drawImage((new ImageIcon("Logo2.gif")).getImage(),0,0,720,720,null);
					}
					if(frame>=135 && frame<180) {
						g.drawImage((new ImageIcon("Logo3.gif")).getImage(),0,0,720,720,null);
						g.setColor(Color.WHITE);
						g.fillRect(117, 414,5, 6);
						g.fillRect(144, 414,5, 6);
						g.fillRect(125, 450,5, 6);
					}
					if(frame>=180) {
						g.drawImage((new ImageIcon("Logo4.gif")).getImage(),0,0,720,720,null);
						g.setColor(Color.WHITE);
						g.fillRect(117, 414,5, 6);
						g.fillRect(144, 414,5, 6);
						g.fillRect(125, 450,5, 6);
					}
					if(frame>= 60 && frame < 180) {
						g.setColor(Color.RED);
						drawStar(360,360-14*(frame%30),30,g);
						drawStar((int)(360-13.31479*(frame%30)),(int)(360-4.32623*(frame%30)),30,g);
						drawStar((int)(360+13.31479*(frame%30)),(int)(360-4.32623*(frame%30)),30,g);
						drawStar((int)(360-8.228993*(frame%30)),(int)(360+11.3262*(frame%30)),30,g);
						drawStar((int)(360+8.228993*(frame%30)),(int)(360+11.3262*(frame%30)),30,g);

					}

				} else {
					//front screen
					box1 = new Color(200,200,200);
					box2 = new Color(200,200,200);
					box3 = new Color(200,200,200);


					if(selected == 0) {
						selected = 1;
					} else if(selected == 5) {
						selected = 4;
					}
					if(selected == 1) {
						box1 = Color.YELLOW;
						if(select) {
							if(saveFile.exists()) {
								menuPart = 3;
							} else {
								menuPart = 17;
								enterReleased = false;


							}
							select = false;

						}
					} else if(selected == 2) {
						box2 = Color.YELLOW;
						if(select) {
							select = false;


						}
					} else if(selected == 3) {
						box3 = Color.YELLOW;
						if(select) {

							select = false;
							saveFile.deleteSave();
						}
					} 
					g.drawImage(shapemonTitle,94,50,512,200,null);


					g.setColor(box1);
					g.fillRect(180, 320, 360, 50);

					g.setColor(Color.BLACK);
					g.fillRect(175, 320, 5, 50);
					g.fillRect(540, 320, 5, 50);
					g.fillRect(180, 315, 360, 5);
					g.fillRect(180, 370, 360, 5);

					//S
					drawS(285,330,g);
					//T
					drawT(315,330,g);
					//A
					drawA(350,330,g);
					//R
					drawR(380,330,g);
					//T
					drawT(410,330,g);

					//save
					g.setColor(box2);
					g.fillRect(180, 420, 360, 50);

					g.setColor(Color.BLACK);
					g.fillRect(175, 420, 5, 50);
					g.fillRect(540, 420, 5, 50);
					g.fillRect(180, 415, 360, 5);
					g.fillRect(180, 470, 360, 5);

					//c
					drawU(240,430,g);
					//o
					drawS(270,430,g);
					//n
					drawE(300,430,g);
					//t
					drawL(330,430,g);
					//r
					drawE(365,430,g);
					//o
					drawS(395,430,g);
					//l
					drawS(425,430,g);
					//s




					//main menu
					g.setColor(box3);
					g.fillRect(180, 520, 360, 50);

					g.setColor(Color.BLACK);
					g.fillRect(175, 520, 5, 50);
					g.fillRect(540, 520, 5, 50);
					g.fillRect(180, 515, 360, 5);
					g.fillRect(180, 570, 360, 5);

					//U
					drawU(230,530,g);
					//N
					drawN(260,530,g);
					//I
					drawI(290,530,g);
					//N
					drawN(315,530,g);
					//S
					drawS(345,530,g);
					//T
					drawT(375,530,g);
					//A
					drawA(410,530,g);
					//L
					drawL(440,530,g);
					//L
					drawL(470,530,g);
				}
			} else if(menuPart == 1) {

				box1 = new Color(200,200,200);
				box2 = new Color(200,200,200);
				box3 = new Color(200,200,200);
				box4 = new Color(200,200,200);

				if(selected == 0) {
					selected = 1;
				} else if(selected == 5) {
					selected = 4;
				}
				if(selected == 1) {
					box1 = Color.YELLOW;
					if(select) {
						menuOpen = false;
						select = false;

					}
				} else if(selected == 2) {
					box2 = Color.YELLOW;
					if(select) {
						menuPart = 2;
						select = false;
						selected = 1;


					}
				} else if(selected == 3) {
					box3 = Color.YELLOW;
					if(select) {
						save();
						select = false;

					}
				} else if(selected == 4) {
					box4 = Color.YELLOW;
					if(select) {
						selected = 1;
						select = false;
						menuPart = 0;

					}
				}
				//resume
				g.setColor(box1);
				g.fillRect(180, 130, 360, 70);

				g.setColor(Color.BLACK);
				g.fillRect(175, 130, 5, 70);
				g.fillRect(540, 130, 5, 70);
				g.fillRect(180, 125, 360, 5);
				g.fillRect(180, 200, 360, 5);

				//r
				drawR(270,155,g);
				//e
				drawE(300,155,g);
				//s
				drawS(330,155,g);
				//u
				drawU(360,155,g);
				//m
				drawM(390,155,g);
				//e
				drawE(420,155,g);

				//controls
				g.setColor(box2);
				g.fillRect(180, 260, 360, 70);

				g.setColor(Color.BLACK);
				g.fillRect(175, 260, 5, 70);
				g.fillRect(540, 260, 5, 70);
				g.fillRect(180, 255, 360, 5);
				g.fillRect(180, 330, 360, 5);

				//c
				drawC(240,285,g);
				//o
				drawO(270,285,g);
				//n
				drawN(300,285,g);
				//t
				drawT(330,285,g);
				//r
				drawR(365,285,g);
				//o
				drawO(395,285,g);
				//l
				drawL(425,285,g);
				//s
				drawS(455,285,g);

				//save
				g.setColor(box3);
				g.fillRect(180, 390, 360, 70);

				g.setColor(Color.BLACK);
				g.fillRect(175, 390, 5, 70);
				g.fillRect(540, 390, 5, 70);
				g.fillRect(180, 385, 360, 5);
				g.fillRect(180, 460, 360, 5);

				//s
				drawS(300,415,g);
				//a
				drawA(330,415,g);
				//v
				drawV(360,415,g);
				//e
				drawE(390,415,g);

				//main menu
				g.setColor(box4);
				g.fillRect(180, 520, 360, 70);

				g.setColor(Color.BLACK);
				g.fillRect(175, 520, 5, 70);
				g.fillRect(540, 520, 5, 70);
				g.fillRect(180, 515, 360, 5);
				g.fillRect(180, 590, 360, 5);

				//m
				drawM(230,545,g);
				//a
				drawA(265,545,g);
				//i
				drawI(295,545,g);
				//n
				drawN(325,545,g);

				//m
				drawM(375,545,g);
				//e
				drawE(410,545,g);
				//n
				drawN(440,545,g);
				//u
				drawU(470,545,g);








			} else if(menuPart == 2) {
				box1 = new Color(200,200,200);
				box2 = new Color(200,200,200);
				box3 = new Color(200,200,200);
				box4 = new Color(200,200,200);
				box5 = new Color(200,200,200);
				box6 = new Color(200,200,200);
				box7 = new Color(200,200,200);

				if(selected == 0) {
					selected = 1;
				} else if(selected == 8) {
					selected = 7;
				}
				if(selected == 1) {
					box1 = Color.YELLOW;
					if(select) {
						select = false;
						selectUpKey = true;

					}
				} else if(selected == 2) {
					box2 = Color.YELLOW;
					if(select) {
						select = false;
						selectLeftKey = true;

					}
				} else if(selected == 3) {
					box3 = Color.YELLOW;
					if(select) {
						select = false;
						selectDownKey = true;

					}
				} else if(selected == 4) {
					box4 = Color.YELLOW;
					if(select) {
						select = false;
						selectRightKey = true;

					}
				} else if(selected == 5) {
					box5 = Color.YELLOW;
					if(select) {
						select = false;
						selectSelectKey = true;

					}
				} else if(selected == 6) {
					box6 = Color.YELLOW;
					if(select) {
						select = false;
						selectMenuKey = true;

					}
				} else if(selected == 7) {
					box7 = Color.YELLOW;
					if(select) {
						menuPart = 1;
						selected = 1;

						select = false;
					}
				}

				//up
				g.setColor(box1);
				g.fillRect(380, 80, 100, 50);

				//left
				g.setColor(box2);
				g.fillRect(380, 155, 100, 50);

				//down
				g.setColor(box3);
				g.fillRect(380, 230, 100, 50);

				//right
				g.setColor(box4);
				g.fillRect(380, 305, 100, 50);

				//menu
				g.setColor(box5);
				g.fillRect(380, 380, 100, 50);

				//select
				g.setColor(box6);
				g.fillRect(380, 455, 100, 50);

				//back
				g.setColor(box7);
				g.fillRect(240, 530, 240, 50);

				g.setColor(Color.BLACK);
				//up
				g.fillRect(380,75, 100, 5);
				g.fillRect(380,130, 100, 5);
				g.fillRect(375,80, 5, 50);
				g.fillRect(480,80, 5, 50);

				//left
				g.fillRect(380,150, 100, 5);
				g.fillRect(380,205, 100, 5);
				g.fillRect(375,155, 5, 50);
				g.fillRect(480,155, 5, 50);

				//down
				g.fillRect(380,225, 100, 5);
				g.fillRect(380,280, 100, 5);
				g.fillRect(375,230, 5, 50);
				g.fillRect(480,230, 5, 50);

				//right
				g.fillRect(380,300, 100, 5);
				g.fillRect(380,355, 100, 5);
				g.fillRect(375,305, 5, 50);
				g.fillRect(480,305, 5, 50);

				//menu
				g.fillRect(380,375, 100, 5);
				g.fillRect(380,430, 100, 5);
				g.fillRect(375,380, 5, 50);
				g.fillRect(480,380, 5, 50);

				//select
				g.fillRect(380,450, 100, 5);
				g.fillRect(380,505, 100, 5);
				g.fillRect(375,455, 5, 50);
				g.fillRect(480,455, 5, 50);

				//back
				g.fillRect(240,525, 240, 5);
				g.fillRect(240,580, 240, 5);
				g.fillRect(235,530, 5, 50);
				g.fillRect(480,530, 5, 50);


				//up
				drawP(340,90,g);
				drawU(310,90,g);

				//left
				drawT(340,165,g);
				drawF(310,165,g);
				drawE(280,165,g);
				drawL(250,165,g);

				//down
				drawN(340,240,g);
				drawW(310,240,g);
				drawO(280,240,g);
				drawD(250,240,g);

				//right
				drawT(340,315,g);
				drawH(310,315,g);
				drawG(280,315,g);
				drawI(250,315,g);
				drawR(220,315,g);

				//Select
				drawT(340,390,g);
				drawC(310,390,g);
				drawE(280,390,g);
				drawL(250,390,g);
				drawE(220,390,g);
				drawS(180,390,g);

				//Menu
				drawU(340,465,g);
				drawN(310,465,g);
				drawE(280,465,g);
				drawM(250,465,g);

				//Back
				drawB(310, 540, g);
				drawA(340, 540, g);
				drawC(370, 540, g);
				drawK(400, 540, g);

				//first button
				if(selectUpKey) {
					drawS(390,90,g);
					drawL(420,90,g);
					drawC(450,90,g);
				} else if(up == -1) {
					drawN(400,90,g);
					drawA(440,90,g);
				} else if(up == 10) {
					drawE(395,90,g);
					drawN(420,90,g);
					drawT(450,90,g);
				} else if(up == 27) {
					drawE(395,90,g);
					drawS(420,90,g);
					drawC(450,90,g);
				} else if(up == 8) {
					drawD(395,90,g);
					drawE(420,90,g);
					drawL(450,90,g);
				} else if(up == 37) {
					drawLeft(420,90,g);
				} else if(up == 38) {
					drawUp(420,90,g);
				} else if(up == 40) {
					drawDown(420,90,g);
				} else if(up == 39) {
					drawRight(420,90,g);
				} else if(up == 44) {
					drawComma(420,90,g);
				} else if(up == 46) {
					drawPeriod(420,90,g);
				} else if(up == 47) {
					drawSlash(420,90,g);
				} else if(up == 59) {
					drawSemmicolen(420,90,g);
				} else if(up == 222) {
					drawApostrophi(420,90,g);
				} else if(up == 91) {
					drawBracket(420,90,g);
				} else if(up == 93) {
					drawBackBracket(420,90,g);
				} else if(up == 92) {
					drawBackSlash(420,90,g);
				} else if(up == 61) {
					drawEqualsign(420,90,g);
				} else if(up == 45) {
					drawDash(420,90,g);
				} else if(up == 192) {
					drawAccentmark(420,90,g);
				} else if(up == 0) {
					drawF(405,90,g);
					drawN(435,90,g);
				} else if(up == 17) {
					drawC(395,90,g);
					drawT(420,90,g);
					drawL(450,90,g);
				} else if(up == 18) {
					drawA(395,90,g);
					drawL(420,90,g);
					drawT(445,90,g);
				} else if(up == 157) {
					drawC(395,90,g);
					drawM(420,90,g);
					drawD(450,90,g);
				} else if(up == 16) {
					drawS(395,90,g);
					drawF(420,90,g);
					drawT(445,90,g);
				} else if(up == 20) {
					drawC(405,90,g);
					drawL(435,90,g);
				} else if(up == 9) {
					drawT(395,90,g);
					drawA(425,90,g);
					drawB(450,90,g);
				} else if(up == '1') {
					draw1(420,90,g);
				} else if(up == '2') {
					draw2(420,90,g);
				} else if(up == '3') {
					draw3(420,90,g);
				} else if(up == '4') {
					draw4(420,90,g);
				} else if(up == '5') {
					draw5(420,90,g);
				} else if(up == '6') {
					draw6(420,90,g);
				} else if(up == '7') {
					draw7(420,90,g);
				} else if(up == '8') {
					draw8(420,90,g);
				} else if(up == '9') {
					draw9(420,90,g);
				} else if(up == '0') {
					draw0(420,90,g);
				} else if(up == 'A') {
					drawA(420,90,g);
				} else if(up == 'B') {
					drawB(420,90,g);
				} else if(up == 'C') {
					drawC(420,90,g);
				} else if(up == 'D') {
					drawD(420,90,g);
				} else if(up == 'E') {
					drawE(420,90,g);
				} else if(up == 'F') {
					drawF(420,90,g);
				} else if(up == 'G') {
					drawG(420,90,g);
				} else if(up == 'H') {
					drawH(420,90,g);
				} else if(up == 'I') {
					drawI(420,90,g);
				} else if(up == 'J') {
					drawJ(420,90,g);
				} else if(up == 'K') {
					drawK(420,90,g);
				} else if(up == 'L') {
					drawL(420,90,g);
				} else if(up == 'M') {
					drawM(420,90,g);
				} else if(up == 'N') {
					drawN(420,90,g);
				} else if(up == 'O') {
					drawO(420,90,g);
				} else if(up == 'P') {
					drawP(420,90,g);
				} else if(up == 'Q') {
					drawQ(420,90,g);
				} else if(up == 'R') {
					drawR(420,90,g);
				} else if(up == 'S') {
					drawS(420,90,g);
				} else if(up == 'T') {
					drawT(420,90,g);
				} else if(up == 'U') {
					drawU(420,90,g);
				} else if(up == 'V') {
					drawV(420,90,g);
				} else if(up == 'W') {
					drawW(420,90,g);
				} else if(up == 'X') {
					drawX(420,90,g);
				} else if(up == 'Y') {
					drawY(420,90,g);
				} else if(up == 'Z') {
					drawZ(420,90,g);
				}
				if(selectLeftKey) {
					drawS(390,165,g);
					drawL(420,165,g);
					drawC(450,165,g);
				} else if(left == -1) {
					drawN(400,165,g);
					drawA(440,165,g);
				} else if(left == 10) {
					drawE(395,165,g);
					drawN(420,165,g);
					drawT(450,165,g);
				} else if(left == 27) {
					drawE(395,165,g);
					drawS(420,165,g);
					drawC(450,165,g);
				} else if(left == 8) {
					drawD(395,165,g);
					drawE(420,165,g);
					drawL(450,165,g);
				} else if(left == 37) {
					drawLeft(420,165,g);
				} else if(left == 38) {
					drawUp(420,165,g);
				} else if(left == 40) {
					drawDown(420,165,g);
				} else if(left == 39) {
					drawRight(420,165,g);
				} else if(left == 44) {
					drawComma(420,165,g);
				} else if(left == 46) {
					drawPeriod(420,165,g);
				} else if(left == 47) {
					drawSlash(420,165,g);
				} else if(left == 59) {
					drawSemmicolen(420,165,g);
				} else if(left == 222) {
					drawApostrophi(420,165,g);
				} else if(left == 91) {
					drawBracket(420,165,g);
				} else if(left == 93) {
					drawBackBracket(420,165,g);
				} else if(left == 92) {
					drawBackSlash(420,165,g);
				} else if(left == 61) {
					drawEqualsign(420,165,g);
				} else if(left == 45) {
					drawDash(420,165,g);
				} else if(left == 192) {
					drawAccentmark(420,165,g);
				} else if(left == 0) {
					drawF(405,165,g);
					drawN(435,165,g);
				} else if(left == 17) {
					drawC(395,165,g);
					drawT(420,165,g);
					drawL(450,165,g);
				} else if(left == 18) {
					drawA(395,165,g);
					drawL(420,165,g);
					drawT(445,165,g);
				} else if(left == 157) {
					drawC(395,165,g);
					drawM(420,165,g);
					drawD(450,165,g);
				} else if(left == 16) {
					drawS(395,165,g);
					drawF(420,165,g);
					drawT(445,165,g);
				} else if(left == 20) {
					drawC(405,165,g);
					drawL(435,165,g);
				} else if(left == 9) {
					drawT(395,165,g);
					drawA(425,165,g);
					drawB(450,165,g);
				} else if(left == '1') {
					draw1(420,165,g);
				} else if(left == '2') {
					draw2(420,165,g);
				} else if(left == '3') {
					draw3(420,165,g);
				} else if(left == '4') {
					draw4(420,165,g);
				} else if(left == '5') {
					draw5(420,165,g);
				} else if(left == '6') {
					draw6(420,165,g);
				} else if(left == '7') {
					draw7(420,165,g);
				} else if(left == '8') {
					draw8(420,165,g);
				} else if(left == '9') {
					draw9(420,165,g);
				} else if(left == '0') {
					draw0(420,165,g);
				} else if(left == 'A') {
					drawA(420,165,g);
				} else if(left == 'B') {
					drawB(420,165,g);
				} else if(left == 'C') {
					drawC(420,165,g);
				} else if(left == 'D') {
					drawD(420,165,g);
				} else if(left == 'E') {
					drawE(420,165,g);
				} else if(left == 'F') {
					drawF(420,165,g);
				} else if(left == 'G') {
					drawG(420,165,g);
				} else if(left == 'H') {
					drawH(420,165,g);
				} else if(left == 'I') {
					drawI(420,165,g);
				} else if(left == 'J') {
					drawJ(420,165,g);
				} else if(left == 'K') {
					drawK(420,165,g);
				} else if(left == 'L') {
					drawL(420,165,g);
				} else if(left == 'M') {
					drawM(420,165,g);
				} else if(left == 'N') {
					drawN(420,165,g);
				} else if(left == 'O') {
					drawO(420,165,g);
				} else if(left == 'P') {
					drawP(420,165,g);
				} else if(left == 'Q') {
					drawQ(420,165,g);
				} else if(left == 'R') {
					drawR(420,165,g);
				} else if(left == 'S') {
					drawS(420,165,g);
				} else if(left == 'T') {
					drawT(420,165,g);
				} else if(left == 'U') {
					drawU(420,165,g);
				} else if(left == 'V') {
					drawV(420,165,g);
				} else if(left == 'W') {
					drawW(420,165,g);
				} else if(left == 'X') {
					drawX(420,165,g);
				} else if(left == 'Y') {
					drawY(420,165,g);
				} else if(left == 'Z') {
					drawZ(420,165,g);
				}
				if(selectDownKey) {
					drawS(390,240,g);
					drawL(420,240,g);
					drawC(450,240,g);
				} else if(down == -1) {
					drawN(400,240,g);
					drawA(440,240,g);
				} else if(down == 10) {
					drawE(395,240,g);
					drawN(420,240,g);
					drawT(450,240,g);
				} else if(down == 27) {
					drawE(395,240,g);
					drawS(420,240,g);
					drawC(450,240,g);
				} else if(down == 8) {
					drawD(395,240,g);
					drawE(420,240,g);
					drawL(450,240,g);
				} else if(down == 37) {
					drawLeft(420,240,g);
				} else if(down == 38) {
					drawUp(420,240,g);
				} else if(down == 40) {
					drawDown(420,240,g);
				} else if(down == 39) {
					drawRight(420,240,g);
				} else if(down == 44) {
					drawComma(420,240,g);
				} else if(down == 46) {
					drawPeriod(420,240,g);
				} else if(down == 47) {
					drawSlash(420,240,g);
				} else if(down == 59) {
					drawSemmicolen(420,240,g);
				} else if(down == 222) {
					drawApostrophi(420,240,g);
				} else if(down == 91) {
					drawBracket(420,240,g);
				} else if(down == 93) {
					drawBackBracket(420,240,g);
				} else if(down == 92) {
					drawBackSlash(420,240,g);
				} else if(down == 61) {
					drawEqualsign(420,240,g);
				} else if(down == 45) {
					drawDash(420,240,g);
				} else if(down == 192) {
					drawAccentmark(420,240,g);
				} else if(down == 0) {
					drawF(405,240,g);
					drawN(435,240,g);
				} else if(down == 17) {
					drawC(395,240,g);
					drawT(420,240,g);
					drawL(450,240,g);
				} else if(down == 18) {
					drawA(395,240,g);
					drawL(420,240,g);
					drawT(445,240,g);
				} else if(down == 157) {
					drawC(395,240,g);
					drawM(420,240,g);
					drawD(450,240,g);
				} else if(down == 16) {
					drawS(395,240,g);
					drawF(420,240,g);
					drawT(445,240,g);
				} else if(down == 20) {
					drawC(405,240,g);
					drawL(435,240,g);
				} else if(down == 9) {
					drawT(395,240,g);
					drawA(425,240,g);
					drawB(450,240,g);
				} else if(down == '1') {
					draw1(420,240,g);
				} else if(down == '2') {
					draw2(420,240,g);
				} else if(down == '3') {
					draw3(420,240,g);
				} else if(down == '4') {
					draw4(420,240,g);
				} else if(down == '5') {
					draw5(420,240,g);
				} else if(down == '6') {
					draw6(420,240,g);
				} else if(down == '7') {
					draw7(420,240,g);
				} else if(down == '8') {
					draw8(420,240,g);
				} else if(down == '9') {
					draw9(420,240,g);
				} else if(down == '0') {
					draw0(420,240,g);
				} else if(down == 'A') {
					drawA(420,240,g);
				} else if(down == 'B') {
					drawB(420,240,g);
				} else if(down == 'C') {
					drawC(420,240,g);
				} else if(down == 'D') {
					drawD(420,240,g);
				} else if(down == 'E') {
					drawE(420,240,g);
				} else if(down == 'F') {
					drawF(420,240,g);
				} else if(down == 'G') {
					drawG(420,240,g);
				} else if(down == 'H') {
					drawH(420,240,g);
				} else if(down == 'I') {
					drawI(420,240,g);
				} else if(down == 'J') {
					drawJ(420,240,g);
				} else if(down == 'K') {
					drawK(420,240,g);
				} else if(down == 'L') {
					drawL(420,240,g);
				} else if(down == 'M') {
					drawM(420,240,g);
				} else if(down == 'N') {
					drawN(420,240,g);
				} else if(down == 'O') {
					drawO(420,240,g);
				} else if(down == 'P') {
					drawP(420,240,g);
				} else if(down == 'Q') {
					drawQ(420,240,g);
				} else if(down == 'R') {
					drawR(420,240,g);
				} else if(down == 'S') {
					drawS(420,240,g);
				} else if(down == 'T') {
					drawT(420,240,g);
				} else if(down == 'U') {
					drawU(420,240,g);
				} else if(down == 'V') {
					drawV(420,240,g);
				} else if(down == 'W') {
					drawW(420,240,g);
				} else if(down == 'X') {
					drawX(420,240,g);
				} else if(down == 'Y') {
					drawY(420,240,g);
				} else if(down == 'Z') {
					drawZ(420,240,g);
				}
				if(selectRightKey) {
					drawS(390,315,g);
					drawL(420,315,g);
					drawC(450,315,g);
				} else if(right == -1) {
					drawN(400,315,g);
					drawA(440,315,g);
				}  else if(right == 10) {
					drawE(395,315,g);
					drawN(420,315,g);
					drawT(450,315,g);
				}  else if(right == 27) {
					drawE(395,315,g);
					drawS(420,315,g);
					drawC(450,315,g);
				} else if(right == 8) {
					drawD(395,315,g);
					drawE(420,315,g);
					drawL(450,315,g);
				} else if(right == 37) {
					drawLeft(420,315,g);
				} else if(right == 38) {
					drawUp(420,315,g);
				} else if(right == 40) {
					drawDown(420,315,g);
				} else if(right == 39) {
					drawRight(420,315,g);
				} else if(right == 44) {
					drawComma(420,315,g);
				} else if(right == 46) {
					drawPeriod(420,315,g);
				} else if(right == 47) {
					drawSlash(420,315,g);
				} else if(right == 59) {
					drawSemmicolen(420,315,g);
				} else if(right == 222) {
					drawApostrophi(420,315,g);
				} else if(right == 91) {
					drawBracket(420,315,g);
				} else if(right == 93) {
					drawBackBracket(420,315,g);
				} else if(right == 92) {
					drawBackSlash(420,315,g);
				} else if(right == 61) {
					drawEqualsign(420,315,g);
				} else if(right == 45) {
					drawDash(420,315,g);
				} else if(right == 192) {
					drawAccentmark(420,315,g);
				} else if(right == 0) {
					drawF(405,315,g);
					drawN(435,315,g);
				} else if(right == 17) {
					drawC(395,315,g);
					drawT(420,315,g);
					drawL(450,315,g);
				} else if(right == 18) {
					drawA(395,315,g);
					drawL(420,315,g);
					drawT(445,315,g);
				} else if(right == 157) {
					drawC(395,315,g);
					drawM(420,315,g);
					drawD(450,315,g);
				} else if(right == 16) {
					drawS(395,315,g);
					drawF(420,315,g);
					drawT(445,315,g);
				} else if(right == 20) {
					drawC(405,315,g);
					drawL(435,315,g);
				} else if(right == 9) {
					drawT(395,315,g);
					drawA(425,315,g);
					drawB(450,315,g);
				} else if(right == '1') {
					draw1(420,315,g);
				} else if(right == '2') {
					draw2(420,315,g);
				} else if(right == '3') {
					draw3(420,315,g);
				} else if(right == '4') {
					draw4(420,315,g);
				} else if(right == '5') {
					draw5(420,315,g);
				} else if(right == '6') {
					draw6(420,315,g);
				} else if(right == '7') {
					draw7(420,315,g);
				} else if(right == '8') {
					draw8(420,315,g);
				} else if(right == '9') {
					draw9(420,315,g);
				} else if(right == '0') {
					draw0(420,315,g);
				} else if(right == 'A') {
					drawA(420,315,g);
				} else if(right == 'B') {
					drawB(420,315,g);
				} else if(right == 'C') {
					drawC(420,315,g);
				} else if(right == 'D') {
					drawD(420,315,g);
				} else if(right == 'E') {
					drawE(420,315,g);
				} else if(right == 'F') {
					drawF(420,315,g);
				} else if(right == 'G') {
					drawG(420,315,g);
				} else if(right == 'H') {
					drawH(420,315,g);
				} else if(right == 'I') {
					drawI(420,315,g);
				} else if(right == 'J') {
					drawJ(420,315,g);
				} else if(right == 'K') {
					drawK(420,315,g);
				} else if(right == 'L') {
					drawL(420,315,g);
				} else if(right == 'M') {
					drawM(420,315,g);
				} else if(right == 'N') {
					drawN(420,315,g);
				} else if(right == 'O') {
					drawO(420,315,g);
				} else if(right == 'P') {
					drawP(420,315,g);
				} else if(right == 'Q') {
					drawQ(420,315,g);
				} else if(right == 'R') {
					drawR(420,315,g);
				} else if(right == 'S') {
					drawS(420,315,g);
				} else if(right == 'T') {
					drawT(420,315,g);
				} else if(right == 'U') {
					drawU(420,315,g);
				} else if(right == 'V') {
					drawV(420,315,g);
				} else if(right == 'W') {
					drawW(420,315,g);
				} else if(right == 'X') {
					drawX(420,315,g);
				} else if(right == 'Y') {
					drawY(420,315,g);
				} else if(right == 'Z') {
					drawZ(420,315,g);
				}
				if(selectSelectKey) {
					drawS(390,390,g);
					drawL(420,390,g);
					drawC(450,390,g);
				} else if(selectKey == -1) {
					drawN(400,390,g);
					drawA(440,390,g);
				}  else if(selectKey == 10) {
					drawE(395,390,g);
					drawN(420,390,g);
					drawT(450,390,g);
				}  else if(selectKey == 27) {
					drawE(395,390,g);
					drawS(420,390,g);
					drawC(450,390,g);
				} else if(selectKey == 8) {
					drawD(395,390,g);
					drawE(420,390,g);
					drawL(450,390,g);
				} else if(selectKey == 37) {
					drawLeft(420,390,g);
				} else if(selectKey == 38) {
					drawUp(420,390,g);
				} else if(selectKey == 40) {
					drawDown(420,390,g);
				} else if(selectKey == 39) {
					drawRight(420,390,g);
				} else if(selectKey == 44) {
					drawComma(420,390,g);
				} else if(selectKey == 46) {
					drawPeriod(420,390,g);
				} else if(selectKey == 47) {
					drawSlash(420,390,g);
				} else if(selectKey == 59) {
					drawSemmicolen(420,390,g);
				} else if(selectKey == 222) {
					drawApostrophi(420,390,g);
				} else if(selectKey == 91) {
					drawBracket(420,390,g);
				} else if(selectKey == 93) {
					drawBackBracket(420,390,g);
				} else if(selectKey == 92) {
					drawBackSlash(420,390,g);
				} else if(selectKey == 61) {
					drawEqualsign(420,390,g);
				} else if(selectKey == 45) {
					drawDash(420,390,g);
				} else if(selectKey == 192) {
					drawAccentmark(420,390,g);
				} else if(selectKey == 0) {
					drawF(405,390,g);
					drawN(435,390,g);
				} else if(selectKey == 17) {
					drawC(395,390,g);
					drawT(420,390,g);
					drawL(450,390,g);
				} else if(selectKey == 18) {
					drawA(395,390,g);
					drawL(420,390,g);
					drawT(445,390,g);
				} else if(selectKey == 157) {
					drawC(395,390,g);
					drawM(420,390,g);
					drawD(450,390,g);
				} else if(selectKey == 16) {
					drawS(395,390,g);
					drawF(420,390,g);
					drawT(445,390,g);
				} else if(selectKey == 20) {
					drawC(405,390,g);
					drawL(435,390,g);
				} else if(selectKey == 9) {
					drawT(395,390,g);
					drawA(425,390,g);
					drawB(450,390,g);
				} else if(selectKey == '1') {
					draw1(420,390,g);
				} else if(selectKey == '2') {
					draw2(420,390,g);
				} else if(selectKey == '3') {
					draw3(420,390,g);
				} else if(selectKey == '4') {
					draw4(420,390,g);
				} else if(selectKey == '5') {
					draw5(420,390,g);
				} else if(selectKey == '6') {
					draw6(420,390,g);
				} else if(selectKey == '7') {
					draw7(420,390,g);
				} else if(selectKey == '8') {
					draw8(420,390,g);
				} else if(selectKey == '9') {
					draw9(420,390,g);
				} else if(selectKey == '0') {
					draw0(420,390,g);
				} else if(selectKey == 'A') {
					drawA(420,390,g);
				} else if(selectKey == 'B') {
					drawB(420,390,g);
				} else if(selectKey == 'C') {
					drawC(420,390,g);
				} else if(selectKey == 'D') {
					drawD(420,390,g);
				} else if(selectKey == 'E') {
					drawE(420,390,g);
				} else if(selectKey == 'F') {
					drawF(420,390,g);
				} else if(selectKey == 'G') {
					drawG(420,390,g);
				} else if(selectKey == 'H') {
					drawH(420,390,g);
				} else if(selectKey == 'I') {
					drawI(420,390,g);
				} else if(selectKey == 'J') {
					drawJ(420,390,g);
				} else if(selectKey == 'K') {
					drawK(420,390,g);
				} else if(selectKey == 'L') {
					drawL(420,390,g);
				} else if(selectKey == 'M') {
					drawM(420,390,g);
				} else if(selectKey == 'N') {
					drawN(420,390,g);
				} else if(selectKey == 'O') {
					drawO(420,390,g);
				} else if(selectKey == 'P') {
					drawP(420,390,g);
				} else if(selectKey == 'Q') {
					drawQ(420,390,g);
				} else if(selectKey == 'R') {
					drawR(420,390,g);
				} else if(selectKey == 'S') {
					drawS(420,390,g);
				} else if(selectKey == 'T') {
					drawT(420,390,g);
				} else if(selectKey == 'U') {
					drawU(420,390,g);
				} else if(selectKey == 'V') {
					drawV(420,390,g);
				} else if(selectKey == 'W') {
					drawW(420,390,g);
				} else if(selectKey == 'X') {
					drawX(420,390,g);
				} else if(selectKey == 'Y') {
					drawY(420,390,g);
				} else if(selectKey == 'Z') {
					drawZ(420,390,g);
				}
				if(selectMenuKey) {
					drawS(390,465,g);
					drawL(420,465,g);
					drawC(450,465,g);
				} else if(menuKey == -1) {
					drawN(400,465,g);
					drawA(440,465,g);
				}  else if(menuKey == 10) {
					drawE(395,465,g);
					drawN(420,465,g);
					drawT(450,465,g);
				}  else if(menuKey == 27) {
					drawE(395,465,g);
					drawS(420,465,g);
					drawC(450,465,g);
				} else if(menuKey == 8) {
					drawD(395,465,g);
					drawE(420,465,g);
					drawL(450,465,g);
				} else if(menuKey == 37) {
					drawLeft(420,465,g);
				} else if(menuKey == 38) {
					drawUp(420,465,g);
				} else if(menuKey == 40) {
					drawDown(420,465,g);
				} else if(menuKey == 39) {
					drawRight(420,465,g);
				} else if(menuKey == 44) {
					drawComma(420,465,g);
				} else if(menuKey == 46) {
					drawPeriod(420,465,g);
				} else if(menuKey == 47) {
					drawSlash(420,465,g);
				} else if(menuKey == 59) {
					drawSemmicolen(420,465,g);
				} else if(menuKey == 222) {
					drawApostrophi(420,465,g);
				} else if(menuKey == 91) {
					drawBracket(420,465,g);
				} else if(menuKey == 93) {
					drawBackBracket(420,465,g);
				} else if(menuKey == 92) {
					drawBackSlash(420,465,g);
				} else if(menuKey == 61) {
					drawEqualsign(420,465,g);
				} else if(menuKey == 45) {
					drawDash(420,465,g);
				} else if(menuKey == 192) {
					drawAccentmark(420,465,g);
				} else if(menuKey == 0) {
					drawF(405,465,g);
					drawN(435,465,g);
				} else if(menuKey == 17) {
					drawC(395,465,g);
					drawT(420,465,g);
					drawL(450,465,g);
				} else if(menuKey == 18) {
					drawA(395,465,g);
					drawL(420,465,g);
					drawT(445,465,g);
				} else if(menuKey == 157) {
					drawC(395,465,g);
					drawM(420,465,g);
					drawD(450,465,g);
				} else if(menuKey == 16) {
					drawS(395,465,g);
					drawF(420,465,g);
					drawT(445,465,g);
				} else if(menuKey == 20) {
					drawC(405,465,g);
					drawL(435,465,g);
				} else if(menuKey == 9) {
					drawT(395,465,g);
					drawA(425,465,g);
					drawB(450,465,g);
				} else if(menuKey == '1') {
					draw1(420,465,g);
				} else if(menuKey == '2') {
					draw2(420,465,g);
				} else if(menuKey == '3') {
					draw3(420,465,g);
				} else if(menuKey == '4') {
					draw4(420,465,g);
				} else if(menuKey == '5') {
					draw5(420,465,g);
				} else if(menuKey == '6') {
					draw6(420,465,g);
				} else if(menuKey == '7') {
					draw7(420,465,g);
				} else if(menuKey == '8') {
					draw8(420,465,g);
				} else if(menuKey == '9') {
					draw9(420,465,g);
				} else if(menuKey == '0') {
					draw0(420,465,g);
				} else if(menuKey == 'A') {
					drawA(420,465,g);
				} else if(menuKey == 'B') {
					drawB(420,465,g);
				} else if(menuKey == 'C') {
					drawC(420,465,g);
				} else if(menuKey == 'D') {
					drawD(420,465,g);
				} else if(menuKey == 'E') {
					drawE(420,465,g);
				} else if(menuKey == 'F') {
					drawF(420,465,g);
				} else if(menuKey == 'G') {
					drawG(420,465,g);
				} else if(menuKey == 'H') {
					drawH(420,465,g);
				} else if(menuKey == 'I') {
					drawI(420,465,g);
				} else if(menuKey == 'J') {
					drawJ(420,465,g);
				} else if(menuKey == 'K') {
					drawK(420,465,g);
				} else if(menuKey == 'L') {
					drawL(420,465,g);
				} else if(menuKey == 'M') {
					drawM(420,465,g);
				} else if(menuKey == 'N') {
					drawN(420,465,g);
				} else if(menuKey == 'O') {
					drawO(420,465,g);
				} else if(menuKey == 'P') {
					drawP(420,465,g);
				} else if(menuKey == 'Q') {
					drawQ(420,465,g);
				} else if(menuKey == 'R') {
					drawR(420,465,g);
				} else if(menuKey == 'S') {
					drawS(420,465,g);
				} else if(menuKey == 'T') {
					drawT(420,465,g);
				} else if(menuKey == 'U') {
					drawU(420,465,g);
				} else if(menuKey == 'V') {
					drawV(420,465,g);
				} else if(menuKey == 'W') {
					drawW(420,465,g);
				} else if(menuKey == 'X') {
					drawX(420,465,g);
				} else if(menuKey == 'Y') {
					drawY(420,465,g);
				} else if(menuKey == 'Z') {
					drawZ(420,465,g);
				}


			} else if(menuPart == 3) {

				box1 = new Color(200,200,200);
				box2 = new Color(200,200,200);
				box3 = new Color(200,200,200);
				box4 = new Color(200,200,200);

				if(selected == 0) {
					selected = 1;
				} else if(selected == 4) {
					selected = 3;
				}
				if(selected == 1) {
					box1 = Color.YELLOW;
					if(select) {
						menuOpen = false;
						select = false;
						menuPart = 1;
						load();

					}
				} else if(selected == 2) {
					box2 = Color.YELLOW;
					if(select) {
						menuPart = 17;
						select = false;
						
						selected = 1;
						


					}
				} else if(selected == 3) {
					box3 = Color.YELLOW;
					if(select) {

						select = false;

					}
				}
				g.setColor(box1);
				g.fillRect(60, 50, 600, 400);

				g.setColor(Color.BLACK);
				g.fillRect(55, 50, 5, 400);
				g.fillRect(660, 50, 5, 400);
				g.fillRect(60, 45, 600, 5);
				g.fillRect(60, 450, 600, 5);

				drawL(235,70,g);
				drawO(265,70,g);
				drawA(295,70,g);
				drawD(325,70,g);
				drawG(370,70,g);
				drawA(400,70,g);
				drawM(430,70,g);
				drawE(465,70,g);

				g.setColor(box2);
				g.fillRect(60, 470, 600, 70);

				g.setColor(Color.BLACK);
				g.fillRect(55, 470, 5, 70);
				g.fillRect(660, 470, 5, 70);
				g.fillRect(60, 465, 600, 5);
				g.fillRect(60, 540, 600, 5);


				drawN(245,490,g);
				drawE(275,490,g);
				drawW(305,490,g);
				drawG(350,490,g);
				drawA(380,490,g);
				drawM(410,490,g);
				drawE(445,490,g);

				g.setColor(box3);
				g.fillRect(60, 560, 600, 70);

				g.setColor(Color.BLACK);
				g.fillRect(55, 560, 5, 70);
				g.fillRect(660, 560, 5, 70);
				g.fillRect(60, 555, 600, 5);
				g.fillRect(60, 630, 600, 5);



			} else if(menuPart >= 5 &&  menuPart <= 16) {
				//menu for switching shapemon
				menuPart = SwitchShape.computerScreen(g, player, battle, this, menuPart, upPressed, downPressed, rightPressed, leftPressed, enterPressed);
				
				//rest of paint component is jsut printing dialogue
			}else if(menuPart == 17) {
				if(enterPressed && enterReleased) {
					dialogueX -= 720;
					dialogue.enterPressed();
					enterReleased = false;
				} else if(!enterPressed){
					dialogue.enterReleased();
				}
				if(leftPressed) {
					dialogue.leftPressed();
				} else {
					dialogue.leftReleased();
				}
				if(upPressed) {
					dialogue.upPressed();
				} else {
					dialogue.upReleased();
				}
				if(downPressed) {
					dialogue.downPressed();
				} else {
					dialogue.downReleased();
				}
				if(rightPressed) {
					dialogue.rightPressed();
				} else {
					dialogue.rightReleased();
				}
				g.setColor(new Color(200,200,200));
				g.fillRect(10, 530, 695, 190);
				g.setColor(Color.BLACK);
				g.fillRect(5, 530, 5, 190);
				g.fillRect(10, 525, 695, 5);
				g.fillRect(705, 530, 5, 190);
				if(dialogue.drawTutorialPart1(dialogueX, 560, g)) {
					dialogue.reset();
					menuOpen = false;
					menuPart = 1;
					dialogueX = 20;
				}

			}else if(menuPart == 18) {
				if(enterPressed && enterReleased) {
					dialogueX -= 720;
					dialogue.enterPressed();
					enterReleased = false;
				} else if(!enterPressed){
					dialogue.enterReleased();
				}
				if(leftPressed) {
					dialogue.leftPressed();
				} else {
					dialogue.leftReleased();
				}
				if(upPressed) {
					dialogue.upPressed();
				} else {
					dialogue.upReleased();
				}
				if(downPressed) {
					dialogue.downPressed();
				} else {
					dialogue.downReleased();
				}
				if(rightPressed) {
					dialogue.rightPressed();
				} else {
					dialogue.rightReleased();
				}
				g.setColor(new Color(200,200,200));
				g.fillRect(10, 530, 695, 190);
				g.setColor(Color.BLACK);
				g.fillRect(5, 530, 5, 190);
				g.fillRect(10, 525, 695, 5);
				g.fillRect(705, 530, 5, 190);
				if(dialogue.drawTutorialPart2(dialogueX, 560, g, player)) {
					dialogue.reset();
					menuOpen = false;
					menuPart = 1;
					dialogueX = 20;
				}

			}else if(menuPart == 19) {
				if(enterPressed && enterReleased) {

					dialogueX -= 720;
					dialogue.enterPressed();
					enterReleased = false;
				} else if(!enterPressed){
					dialogue.enterReleased();
				}
				if(leftPressed) {
					dialogue.leftPressed();
				} else {
					dialogue.leftReleased();
				}
				if(upPressed) {
					dialogue.upPressed();
				} else {
					dialogue.upReleased();
				}
				if(downPressed) {
					dialogue.downPressed();
				} else {
					dialogue.downReleased();
				}
				if(rightPressed) {
					dialogue.rightPressed();
				} else {
					dialogue.rightReleased();
				}
				g.setColor(new Color(200,200,200));
				g.fillRect(10, 530, 695, 190);
				g.setColor(Color.BLACK);
				g.fillRect(5, 530, 5, 190);
				g.fillRect(10, 525, 695, 5);
				g.fillRect(705, 530, 5, 190);
				if(dialogue.drawHealingProffesor(dialogueX, 560, g, player)) {
					dialogue.reset();
					menuOpen = false;
					menuPart = 1;
					dialogueX = 20;
				}

			} else if(menuPart == 20) {
				if(enterPressed && enterReleased) {

					dialogueX -= 720;
					dialogue.enterPressed();
					enterReleased = false;
				} else if(!enterPressed){
					dialogue.enterReleased();
				}
				if(leftPressed) {
					dialogue.leftPressed();
				} else {
					dialogue.leftReleased();
				}
				if(upPressed) {
					dialogue.upPressed();
				} else {
					dialogue.upReleased();
				}
				if(downPressed) {
					dialogue.downPressed();
				} else {
					dialogue.downReleased();
				}
				if(rightPressed) {
					dialogue.rightPressed();
				} else {
					dialogue.rightReleased();
				}
				g.setColor(new Color(200,200,200));
				g.fillRect(10, 530, 695, 190);
				g.setColor(Color.BLACK);
				g.fillRect(5, 530, 5, 190);
				g.fillRect(10, 525, 695, 5);
				g.fillRect(705, 530, 5, 190);
				if(dialogue.drawProffesorGoToLakeText(dialogueX, 560, g)) {
					dialogue.reset();
					menuOpen = false;
					menuPart = 1;
					dialogueX = 20;
				}

			} else if(menuPart == 21) {
				if(enterPressed && enterReleased) {

					dialogueX -= 720;
					dialogue.enterPressed();
					enterReleased = false;
				} else if(!enterPressed){
					dialogue.enterReleased();
				}
				if(leftPressed) {
					dialogue.leftPressed();
				} else {
					dialogue.leftReleased();
				}
				if(upPressed) {
					dialogue.upPressed();
				} else {
					dialogue.upReleased();
				}
				if(downPressed) {
					dialogue.downPressed();
				} else {
					dialogue.downReleased();
				}
				if(rightPressed) {
					dialogue.rightPressed();
				} else {
					dialogue.rightReleased();
				}
				g.setColor(new Color(200,200,200));
				g.fillRect(10, 530, 695, 190);
				g.setColor(Color.BLACK);
				g.fillRect(5, 530, 5, 190);
				g.fillRect(10, 525, 695, 5);
				g.fillRect(705, 530, 5, 190);
				if(dialogue.drawHealingCenterWithMoveLearn(dialogueX, 560, "slash", player, g)) {
					dialogue.reset();
					menuOpen = false;
					menuPart = 1;
					dialogueX = 20;
				}

			} else if(menuPart == 20) {
				if(enterPressed && enterReleased) {

					dialogueX -= 720;
					dialogue.enterPressed();
					enterReleased = false;
				} else if(!enterPressed){
					dialogue.enterReleased();
				}
				if(leftPressed) {
					dialogue.leftPressed();
				} else {
					dialogue.leftReleased();
				}
				if(upPressed) {
					dialogue.upPressed();
				} else {
					dialogue.upReleased();
				}
				if(downPressed) {
					dialogue.downPressed();
				} else {
					dialogue.downReleased();
				}
				if(rightPressed) {
					dialogue.rightPressed();
				} else {
					dialogue.rightReleased();
				}
				g.setColor(new Color(200,200,200));
				g.fillRect(10, 530, 695, 190);
				g.setColor(Color.BLACK);
				g.fillRect(5, 530, 5, 190);
				g.fillRect(10, 525, 695, 5);
				g.fillRect(705, 530, 5, 190);
				if(dialogue.drawProffesorGoToLakeText(dialogueX, 560, g)) {
					dialogue.reset();
					menuOpen = false;
					menuPart = 1;
					dialogueX = 20;
				}

			} else if(menuPart == 22) {
				if(enterPressed && enterReleased) {

					dialogueX -= 720;
					dialogue.enterPressed();
					enterReleased = false;
				} else if(!enterPressed){
					dialogue.enterReleased();
				}
				if(leftPressed) {
					dialogue.leftPressed();
				} else {
					dialogue.leftReleased();
				}
				if(upPressed) {
					dialogue.upPressed();
				} else {
					dialogue.upReleased();
				}
				if(downPressed) {
					dialogue.downPressed();
				} else {
					dialogue.downReleased();
				}
				if(rightPressed) {
					dialogue.rightPressed();
				} else {
					dialogue.rightReleased();
				}
				g.setColor(new Color(200,200,200));
				g.fillRect(10, 530, 695, 190);
				g.setColor(Color.BLACK);
				g.fillRect(5, 530, 5, 190);
				g.fillRect(10, 525, 695, 5);
				g.fillRect(705, 530, 5, 190);
				if(dialogue.drawHealingCenterWithMoveLearn(dialogueX, 560, "swim", player, g)) {
					dialogue.reset();
					menuOpen = false;
					menuPart = 1;
					dialogueX = 20;
				}

			} else if(menuPart == 23) {
				if(enterPressed && enterReleased) {

					dialogueX -= 720;
					dialogue.enterPressed();
					enterReleased = false;
				} else if(!enterPressed){
					dialogue.enterReleased();
				}
				if(leftPressed) {
					dialogue.leftPressed();
				} else {
					dialogue.leftReleased();
				}
				if(upPressed) {
					dialogue.upPressed();
				} else {
					dialogue.upReleased();
				}
				if(downPressed) {
					dialogue.downPressed();
				} else {
					dialogue.downReleased();
				}
				if(rightPressed) {
					dialogue.rightPressed();
				} else {
					dialogue.rightReleased();
				}
				g.setColor(new Color(200,200,200));
				g.fillRect(10, 530, 695, 190);
				g.setColor(Color.BLACK);
				g.fillRect(5, 530, 5, 190);
				g.fillRect(10, 525, 695, 5);
				g.fillRect(705, 530, 5, 190);
				if(dialogue.drawHealingCenterPart1(dialogueX, 560, g, player)) {
					dialogue.reset();
					menuOpen = false;
					menuPart = 1;
					dialogueX = 20;
				}

			} else if(menuPart == 24) {
				if(enterPressed && enterReleased) {

					dialogueX -= 720;
					dialogue.enterPressed();
					enterReleased = false;
				} else if(!enterPressed){
					dialogue.enterReleased();
				}
				if(leftPressed) {
					dialogue.leftPressed();
				} else {
					dialogue.leftReleased();
				}
				if(upPressed) {
					dialogue.upPressed();
				} else {
					dialogue.upReleased();
				}
				if(downPressed) {
					dialogue.downPressed();
				} else {
					dialogue.downReleased();
				}
				if(rightPressed) {
					dialogue.rightPressed();
				} else {
					dialogue.rightReleased();
				}
				g.setColor(new Color(200,200,200));
				g.fillRect(10, 530, 695, 190);
				g.setColor(Color.BLACK);
				g.fillRect(5, 530, 5, 190);
				g.fillRect(10, 525, 695, 5);
				g.fillRect(705, 530, 5, 190);
				if(dialogue.drawHealingCenterPart2(dialogueX, 560, g, player)) {
					dialogue.reset();
					menuOpen = false;
					menuPart = 1;
					dialogueX = 20;
				}

			} else if(menuPart == 25) {
				if(enterPressed && enterReleased) {

					dialogueX -= 720;
					dialogue.enterPressed();
					enterReleased = false;
				} else if(!enterPressed){
					dialogue.enterReleased();
				}
				if(leftPressed) {
					dialogue.leftPressed();
				} else {
					dialogue.leftReleased();
				}
				if(upPressed) {
					dialogue.upPressed();
				} else {
					dialogue.upReleased();
				}
				if(downPressed) {
					dialogue.downPressed();
				} else {
					dialogue.downReleased();
				}
				if(rightPressed) {
					dialogue.rightPressed();
				} else {
					dialogue.rightReleased();
				}
				g.setColor(new Color(200,200,200));
				g.fillRect(10, 530, 695, 190);
				g.setColor(Color.BLACK);
				g.fillRect(5, 530, 5, 190);
				g.fillRect(10, 525, 695, 5);
				g.fillRect(705, 530, 5, 190);
				if(dialogue.drawHealingCenterPart3(dialogueX, 560, g, player)) {
					dialogue.reset();
					menuOpen = false;
					menuPart = 1;
					dialogueX = 20;
				}

			} else if(menuPart == 26) {
				if(enterPressed && enterReleased) {

					dialogueX -= 720;
					dialogue.enterPressed();
					enterReleased = false;
				} else if(!enterPressed){
					dialogue.enterReleased();
				}
				if(leftPressed) {
					dialogue.leftPressed();
				} else {
					dialogue.leftReleased();
				}
				if(upPressed) {
					dialogue.upPressed();
				} else {
					dialogue.upReleased();
				}
				if(downPressed) {
					dialogue.downPressed();
				} else {
					dialogue.downReleased();
				}
				if(rightPressed) {
					dialogue.rightPressed();
				} else {
					dialogue.rightReleased();
				}
				g.setColor(new Color(200,200,200));
				g.fillRect(10, 530, 695, 190);
				g.setColor(Color.BLACK);
				g.fillRect(5, 530, 5, 190);
				g.fillRect(10, 525, 695, 5);
				g.fillRect(705, 530, 5, 190);
				if(dialogue.smallTreeWithNoSlash(dialogueX, 560, g)) {
					dialogue.reset();
					menuOpen = false;
					menuPart = 1;
					dialogueX = 20;
				}

			} else if(menuPart == 27) {
				if(enterPressed && enterReleased) {

					dialogueX -= 720;
					dialogue.enterPressed();
					enterReleased = false;
				} else if(!enterPressed){
					dialogue.enterReleased();
				}
				if(leftPressed) {
					dialogue.leftPressed();
				} else {
					dialogue.leftReleased();
				}
				if(upPressed) {
					dialogue.upPressed();
				} else {
					dialogue.upReleased();
				}
				if(downPressed) {
					dialogue.downPressed();
				} else {
					dialogue.downReleased();
				}
				if(rightPressed) {
					dialogue.rightPressed();
				} else {
					dialogue.rightReleased();
				}
				g.setColor(new Color(200,200,200));
				g.fillRect(10, 530, 695, 190);
				g.setColor(Color.BLACK);
				g.fillRect(5, 530, 5, 190);
				g.fillRect(10, 525, 695, 5);
				g.fillRect(705, 530, 5, 190);
				if(dialogue.smallTreeWithSlash(dialogueX, 560, g, this, movingDirection)) {
					dialogue.reset();
					menuOpen = false;
					menuPart = 1;
					dialogueX = 20;
				}

			} else if(menuPart == 28) {
				if(!playSwimmingAnimation) {
					if(enterPressed && enterReleased) {

						dialogueX -= 720;
						dialogue.enterPressed();
						enterReleased = false;
					} else if(!enterPressed){
						dialogue.enterReleased();
					}
					if(leftPressed) {
						dialogue.leftPressed();
					} else {
						dialogue.leftReleased();
					}
					if(upPressed) {
						dialogue.upPressed();
					} else {
						dialogue.upReleased();
					}
					if(downPressed) {
						dialogue.downPressed();
					} else {
						dialogue.downReleased();
					}
					if(rightPressed) {
						dialogue.rightPressed();
					} else {
						dialogue.rightReleased();
					}
					g.setColor(new Color(200,200,200));
					g.fillRect(10, 530, 695, 190);
					g.setColor(Color.BLACK);
					g.fillRect(5, 530, 5, 190);
					g.fillRect(10, 525, 695, 5);
					g.fillRect(705, 530, 5, 190);
					if(dialogue.swimDialogue(dialogueX, 560, g, this)) {
						if(!playSwimmingAnimation) {
							dialogue.reset();
							menuOpen = false;
							menuPart = 1;
							dialogueX = 20;
						}
					}

				} else {
					if(movingDirection == 0) {
						swimming = true;
						moveUp(swimmingAnimationPart);
						swimmingAnimationPart++;

					} else if(movingDirection == 1) {
						swimming = true;
						moveLeft(swimmingAnimationPart);
						swimmingAnimationPart++;

					} else if(movingDirection == 2) {
						swimming = true;
						moveDown(swimmingAnimationPart);
						swimmingAnimationPart++;

					} else if(movingDirection == 3) {
						swimming = true;
						moveRight(swimmingAnimationPart);
						swimmingAnimationPart++;

					} 
					if(swimmingAnimationPart == 16) {
						dialogue.reset();
						menuOpen = false;
						menuPart = 1;
						dialogueX = 20;
						swimmingAnimationPart = 1;
						playSwimmingAnimation = false;
					}

				}
			} else if(menuPart == 29) {
				if(enterPressed && enterReleased) {

					dialogueX -= 720;
					dialogue.enterPressed();
					enterReleased = false;
				} else if(!enterPressed){
					dialogue.enterReleased();
				}
				if(leftPressed) {
					dialogue.leftPressed();
				} else {
					dialogue.leftReleased();
				}
				if(upPressed) {
					dialogue.upPressed();
				} else {
					dialogue.upReleased();
				}
				if(downPressed) {
					dialogue.downPressed();
				} else {
					dialogue.downReleased();
				}
				if(rightPressed) {
					dialogue.rightPressed();
				} else {
					dialogue.rightReleased();
				}
				g.setColor(new Color(200,200,200));
				g.fillRect(10, 530, 695, 190);
				g.setColor(Color.BLACK);
				g.fillRect(5, 530, 5, 190);
				g.fillRect(10, 525, 695, 5);
				g.fillRect(705, 530, 5, 190);
				if(dialogue.drawProffesorText4(dialogueX, 560, g, player)) {
					dialogue.reset();
					menuOpen = false;
					menuPart = 1;
					dialogueX = 20;
				}

			} else if(menuPart == 30) {
				if(enterPressed && enterReleased) {

					dialogueX -= 720;
					dialogue.enterPressed();
					enterReleased = false;
				} else if(!enterPressed){
					dialogue.enterReleased();
				}
				if(leftPressed) {
					dialogue.leftPressed();
				} else {
					dialogue.leftReleased();
				}
				if(upPressed) {
					dialogue.upPressed();
				} else {
					dialogue.upReleased();
				}
				if(downPressed) {
					dialogue.downPressed();
				} else {
					dialogue.downReleased();
				}
				if(rightPressed) {
					dialogue.rightPressed();
				} else {
					dialogue.rightReleased();
				}
				g.setColor(new Color(200,200,200));
				g.fillRect(10, 530, 695, 190);
				g.setColor(Color.BLACK);
				g.fillRect(5, 530, 5, 190);
				g.fillRect(10, 525, 695, 5);
				g.fillRect(705, 530, 5, 190);
				if(dialogue.drawHealingCenterWithMoveLearn(dialogueX, 560, "smash", player, g)) {
					dialogue.reset();
					menuOpen = false;
					menuPart = 1;
					dialogueX = 20;
				}

			} else if(menuPart == 31) {
				if(enterPressed && enterReleased) {

					dialogueX -= 720;
					dialogue.enterPressed();
					enterReleased = false;
				} else if(!enterPressed){
					dialogue.enterReleased();
				}
				if(leftPressed) {
					dialogue.leftPressed();
				} else {
					dialogue.leftReleased();
				}
				if(upPressed) {
					dialogue.upPressed();
				} else {
					dialogue.upReleased();
				}
				if(downPressed) {
					dialogue.downPressed();
				} else {
					dialogue.downReleased();
				}
				if(rightPressed) {
					dialogue.rightPressed();
				} else {
					dialogue.rightReleased();
				}
				g.setColor(new Color(200,200,200));
				g.fillRect(10, 530, 695, 190);
				g.setColor(Color.BLACK);
				g.fillRect(5, 530, 5, 190);
				g.fillRect(10, 525, 695, 5);
				g.fillRect(705, 530, 5, 190);
				if(dialogue.finalBossText(dialogueX, 560, g, this, battle, player)) {
					dialogue.reset();
					menuOpen = false;
					menuPart = 1;
					dialogueX = 20;
				}

			} else if(menuPart == 32) {
				if(enterPressed && enterReleased) {

					dialogueX -= 720;
					dialogue.enterPressed();
					enterReleased = false;
				} else if(!enterPressed){
					dialogue.enterReleased();
				}
				if(leftPressed) {
					dialogue.leftPressed();
				} else {
					dialogue.leftReleased();
				}
				if(upPressed) {
					dialogue.upPressed();
				} else {
					dialogue.upReleased();
				}
				if(downPressed) {
					dialogue.downPressed();
				} else {
					dialogue.downReleased();
				}
				if(rightPressed) {
					dialogue.rightPressed();
				} else {
					dialogue.rightReleased();
				}
				g.setColor(new Color(200,200,200));
				g.fillRect(10, 530, 695, 190);
				g.setColor(Color.BLACK);
				g.fillRect(5, 530, 5, 190);
				g.fillRect(10, 525, 695, 5);
				g.fillRect(705, 530, 5, 190);
				if(dialogue.finalBossText2(dialogueX, 560, g)) {
					for(int i = 0; i < n.length; i ++) {
						if(n[i] == 600 || n[i] == 603) {
							n[i] = 0;
						}else if(n[i] == 601 || n[i] == 602 ) {
							n[i] = 1;
						}
					}
					for(int i = 0; i < n2.length; i ++) {
						if(n2[i] == 600 || n2[i] == 603) {
							n2[i] = 0;
						}else if(n2[i] == 601 || n2[i] == 602 ) {
							n2[i] = 1;
						}
					}
					for(int i = 0; i < n3.length; i ++) {
						if(n3[i] == 600 || n3[i] == 603) {
							n3[i] = 0;
						}else if(n3[i] == 601 || n3[i] == 602 ) {
							n3[i] = 1;
						}
					}
					for(int i = 0; i < n4.length; i ++) {
						if(n4[i] == 600 || n4[i] == 603) {
							n4[i] = 0;
						}else if(n4[i] == 601 || n4[i] == 602 ) {
							n4[i] = 1;
						}
					}
					for(int i = 0; i < n5.length; i ++) {
						if(n5[i] == 600 || n5[i] == 603) {
							n5[i] = 0;
						}else if(n5[i] == 601 || n5[i] == 602 ) {
							n5[i] = 1;
						}
					}
					dialogue.reset();
					menuOpen = false;
					menuPart = 1;
					dialogueX = 20;
				}

			} else if(menuPart == 33) {
				if(enterPressed && enterReleased) {

					dialogueX -= 720;
					dialogue.enterPressed();
					enterReleased = false;
				} else if(!enterPressed){
					dialogue.enterReleased();
				}
				if(leftPressed) {
					dialogue.leftPressed();
				} else {
					dialogue.leftReleased();
				}
				if(upPressed) {
					dialogue.upPressed();
				} else {
					dialogue.upReleased();
				}
				if(downPressed) {
					dialogue.downPressed();
				} else {
					dialogue.downReleased();
				}
				if(rightPressed) {
					dialogue.rightPressed();
				} else {
					dialogue.rightReleased();
				}
				g.setColor(new Color(200,200,200));
				g.fillRect(10, 530, 695, 190);
				g.setColor(Color.BLACK);
				g.fillRect(5, 530, 5, 190);
				g.fillRect(10, 525, 695, 5);
				g.fillRect(705, 530, 5, 190);
				if(dialogue.drawHealingCenter(dialogueX, 560, player, g)) {
					dialogue.reset();
					menuOpen = false;
					menuPart = 1;
					dialogueX = 20;
				}

			} else if(menuPart == 34) {
				if(enterPressed && enterReleased) {

					dialogueX -= 720;
					dialogue.enterPressed();
					enterReleased = false;
				} else if(!enterPressed){
					dialogue.enterReleased();
				}
				if(leftPressed) {
					dialogue.leftPressed();
				} else {
					dialogue.leftReleased();
				}
				if(upPressed) {
					dialogue.upPressed();
				} else {
					dialogue.upReleased();
				}
				if(downPressed) {
					dialogue.downPressed();
				} else {
					dialogue.downReleased();
				}
				if(rightPressed) {
					dialogue.rightPressed();
				} else {
					dialogue.rightReleased();
				}
				g.setColor(new Color(200,200,200));
				g.fillRect(10, 530, 695, 190);
				g.setColor(Color.BLACK);
				g.fillRect(5, 530, 5, 190);
				g.fillRect(10, 525, 695, 5);
				g.fillRect(705, 530, 5, 190);
				if(dialogue.smallRockWithNoSmash(dialogueX, 560, g)) {
					dialogue.reset();
					menuOpen = false;
					menuPart = 1;
					dialogueX = 20;
				}

			} else if(menuPart == 35) {
				if(enterPressed && enterReleased) {

					dialogueX -= 720;
					dialogue.enterPressed();
					enterReleased = false;
				} else if(!enterPressed){
					dialogue.enterReleased();
				}
				if(leftPressed) {
					dialogue.leftPressed();
				} else {
					dialogue.leftReleased();
				}
				if(upPressed) {
					dialogue.upPressed();
				} else {
					dialogue.upReleased();
				}
				if(downPressed) {
					dialogue.downPressed();
				} else {
					dialogue.downReleased();
				}
				if(rightPressed) {
					dialogue.rightPressed();
				} else {
					dialogue.rightReleased();
				}
				g.setColor(new Color(200,200,200));
				g.fillRect(10, 530, 695, 190);
				g.setColor(Color.BLACK);
				g.fillRect(5, 530, 5, 190);
				g.fillRect(10, 525, 695, 5);
				g.fillRect(705, 530, 5, 190);
				if(dialogue.smallRockWithSmash(dialogueX, 560, g, this, movingDirection)) {
					dialogue.reset();
					menuOpen = false;
					menuPart = 1;
					dialogueX = 20;
				}

			}  else if(menuPart == 36) {
				if(enterPressed && enterReleased) {

					dialogueX -= 720;
					dialogue.enterPressed();
					enterReleased = false;
				} else if(!enterPressed){
					dialogue.enterReleased();
				}
				if(leftPressed) {
					dialogue.leftPressed();
				} else {
					dialogue.leftReleased();
				}
				if(upPressed) {
					dialogue.upPressed();
				} else {
					dialogue.upReleased();
				}
				if(downPressed) {
					dialogue.downPressed();
				} else {
					dialogue.downReleased();
				}
				if(rightPressed) {
					dialogue.rightPressed();
				} else {
					dialogue.rightReleased();
				}
				g.setColor(new Color(200,200,200));
				g.fillRect(10, 530, 695, 190);
				g.setColor(Color.BLACK);
				g.fillRect(5, 530, 5, 190);
				g.fillRect(10, 525, 695, 5);
				g.fillRect(705, 530, 5, 190);
				if(dialogue.tallGrassWithNoShapemonDialogue(dialogueX, 560, g)) {
					dialogue.reset();
					menuOpen = false;
					menuPart = 1;
					dialogueX = 20;
				}

			} 

		}
	}

	

	//variables for plot
	public void setSwimming(boolean s) {
		swimming = s;

	}
	public void playSwimmingAnimation() {
		playSwimmingAnimation = true;
	}
	public boolean getSwimming() {
		return swimming;

	}
	public void setFinalBattle(boolean b) {
		finalBattle = b;
	}

	public boolean getFinalBattle() {
		return finalBattle;
	}
	//controls
	public int getUpTile() {
		int k = ((y - 394)/(0-64) - 2) * n[0] + (x - 392)/(0-64) - 7;
		try {
			if(k < n.length) {
				return n[k];
			} else if(k <n.length +n2.length) {
				return n2[k - n.length];
			} else if(k <n.length +n2.length + n3.length) {
				return n3[k - n.length -n2.length];
			} else if(k <n.length +n2.length +  n3.length + n4.length) {
				return n4[k - n.length -n2.length - n3.length];
			} else {
				return n5[k - n.length -n2.length - n3.length - n4.length];
			}
		}catch(Exception e) {
			return -1;
		}
	}
	public void setUpTile(int tile) {
		int k = ((y - 394)/(0-64) - 2) * n[0] + (x - 392)/(0-64) - 7;
		try {
			if(k < n.length) {
				n[k] = tile;
			} else if(k <n.length +n2.length) {
				n2[k - n.length] = tile;
			} else if(k <n.length +n2.length + n3.length) {
				n3[k - n.length -n2.length] = tile;
			} else if(k <n.length +n2.length +  n3.length + n4.length) {
				n4[k - n.length -n2.length - n3.length] = tile;
			} else {
				n5[k - n.length -n2.length - n3.length - n4.length] = tile;
			}
		}catch(Exception e) { }
	}
	public void setLeftTile(int tile) {
		int k = ((y - 394)/(0-64) - 1) * n[0] + (x - 392)/(0-64) - 8;
		try {
			if(k < n.length) {
				n[k] = tile;
			} else if(k <n.length +n2.length) {
				n2[k - n.length] = tile;
			} else if(k <n.length +n2.length + n3.length) {
				n3[k - n.length -n2.length] = tile;
			} else if(k <n.length +n2.length +  n3.length + n4.length) {
				n4[k - n.length -n2.length - n3.length] = tile;
			} else {
				n5[k - n.length -n2.length - n3.length - n4.length] = tile;
			}
		}catch(Exception e) { }
	}
	public void setDownTile(int tile) {
		int k = ((y - 394)/(0-64)) * n[0] + (x - 392)/(0-64) - 7;
		try {
			if(k < n.length) {
				n[k] = tile;
			} else if(k <n.length +n2.length) {
				n2[k - n.length] = tile;
			} else if(k <n.length +n2.length + n3.length) {
				n3[k - n.length -n2.length] = tile;
			} else if(k <n.length +n2.length +  n3.length + n4.length) {
				n4[k - n.length -n2.length - n3.length] = tile;
			} else {
				n5[k - n.length -n2.length - n3.length - n4.length] = tile;
			}
		}catch(Exception e) { }
	}
	public void setRightTile(int tile) {
		int k = ((y - 394)/(0-64) - 1) * n[0] + (x - 392)/(0-64) - 6;
		try {
			if(k < n.length) {
				n[k] = tile;
			} else if(k <n.length +n2.length) {
				n2[k - n.length] = tile;
			} else if(k <n.length +n2.length + n3.length) {
				n3[k - n.length -n2.length] = tile;
			} else if(k <n.length +n2.length +  n3.length + n4.length) {
				n4[k - n.length -n2.length - n3.length] = tile;
			} else {
				n5[k - n.length -n2.length - n3.length - n4.length] = tile;
			}
		}catch(Exception e) { }
	}
	public int getLeftTile() {
		int k = ((y - 394)/(0-64) - 1) * n[0] + (x - 392)/(0-64) - 8;
		try {
			if(k < n.length) {
				return n[k];
			} else if(k <n.length +n2.length) {
				return n2[k - n.length];
			} else if(k <n.length +n2.length + n3.length) {
				return n3[k - n.length -n2.length];
			} else if(k <n.length +n2.length +  n3.length + n4.length) {
				return n4[k - n.length -n2.length - n3.length];
			} else {
				return n5[k - n.length -n2.length - n3.length - n4.length];
			}
		}catch(Exception e) {
			return -1;
		}
	}
	public int getDownTile() {
		int k = ((y - 394)/(0-64)) * n[0] + (x - 392)/(0-64) - 7;
		try {
			if(k < n.length) {
				return n[k];
			} else if(k <n.length +n2.length) {
				return n2[k - n.length];
			} else if(k <n.length +n2.length + n3.length) {
				return n3[k - n.length -n2.length];
			} else if(k <n.length +n2.length +  n3.length + n4.length) {
				return n4[k - n.length -n2.length - n3.length];
			} else {
				return n5[k - n.length -n2.length - n3.length - n4.length];
			}
		}catch(Exception e) {
			return -1;
		}
	}
	public int getRightTile() {
		int k = ((y - 394)/(0-64) - 1) * n[0] + (x - 392)/(0-64) - 6;
		try {
			if(k < n.length) {
				return n[k];
			} else if(k <n.length +n2.length) {
				return n2[k - n.length];
			} else if(k <n.length +n2.length + n3.length) {
				return n3[k - n.length -n2.length];
			} else if(k <n.length +n2.length +  n3.length + n4.length) {
				return n4[k - n.length -n2.length - n3.length];
			} else {
				return n5[k - n.length -n2.length - n3.length - n4.length];
			}
		}catch(Exception e) {
			return -1;
		}
	}
	public int getCenterTile() {
		int k = ((y - 394)/(0-64) - 1) * n[0] + (x - 392)/(0-64) - 7;
		try {
			if(k < n.length) {
				return n[k];
			} else if(k <n.length +n2.length) {
				return n2[k - n.length];
			} else if(k <n.length +n2.length + n3.length) {
				return n3[k - n.length -n2.length];
			} else if(k <n.length +n2.length +  n3.length + n4.length) {
				return n4[k - n.length -n2.length - n3.length];
			} else {
				return n5[k - n.length -n2.length - n3.length - n4.length];
			}
		}catch(Exception e) {
			return -1;
		}
	}
	public int getShapemonCenterNumber(){
		return shapemonCenterNumber;
	}
	public void setShapemonCenterNumber(int n){
		shapemonCenterNumber = n;
	}
	public void standStill() {
		if(!swimming) {
			if(movingDirection == 0) {
				playerSprite = "PlayerUpStill.gif";
			} else if(movingDirection == 1) {
				playerSprite = "PlayerLeftStill.gif";
			} else if(movingDirection == 2) {
				playerSprite = "PlayerDownStill.gif";
			} else if(movingDirection == 3) {
				playerSprite = "PlayerRightStill.gif";
			}
		} else { 
			if(movingDirection == 0) {
				playerSprite = "PlayerWaterUp.gif";
			} else if(movingDirection == 1) {
				playerSprite = "PlayerWaterLeft.gif";
			} else if(movingDirection == 2) {
				playerSprite = "PlayerWaterDown.gif";
			} else if(movingDirection == 3) {
				playerSprite = "PlayerWaterRight.gif";
			}
		}
	}
	public void moveUp(int f) {
		y+=4;
		if(!swimming) {
			if(f%16 == 0) {
				playerSprite = "PlayerUpStep1.gif";
			} else if(f%8 == 0){ 
				playerSprite = "PlayerUpStep2.gif";
			}
		} else {
			playerSprite = "PlayerWaterUp.gif";
		}
		YShift += 4;
		if(YShift == 4) { 
			YShift = -60;
		}


	}
	public void shiftHeadUp() {
		movingDirection = 0;

	}

	public void moveRight(int f) {
		x-=4;
		XShift -=4;
		if (!swimming) {
			if(f%16 == 0) {
				playerSprite = "PlayerRightStep1.gif";
			} else if(f%8 == 0){ 
				playerSprite = "PlayerRightStep2.gif";
			}
		} else {
			playerSprite = "PlayerWaterRight.gif";
		}
		if(XShift == -64) {
			XShift = 0;
		}
	}
	public void shiftHeadRight() {
		movingDirection = 3;

	}

	public void moveDown(int f) {
		y-=4;
		if(!swimming) {
			if(f%16 == 0) {
				playerSprite = "PlayerDownStep1.gif";
			} else if(f%8 == 0){ 
				playerSprite = "PlayerDownStep2.gif";
			}
		} else {
			playerSprite = "PlayerWaterDown.gif";
		}
		YShift -=4;
		if(YShift == -64) {
			YShift = 0;
		}

	}
	public void shiftHeadDown() {
		movingDirection = 2;

	}

	public void moveLeft(int f) {
		x+=4;
		XShift += 4;
		if (!swimming) {
			if(f%16 == 0) {
				playerSprite = "PlayerLeftStep1.gif";
			} else if(f%8 == 0){ 
				playerSprite = "PlayerLeftStep2.gif";
			}
		} else {
			playerSprite = "PlayerWaterLeft.gif";
		}
		if(XShift == 4) { 
			XShift = -60;
		}

	}
	public void shiftHeadLeft() {
		movingDirection = 1;

	}
	public void setXY(int X, int Y) {
		x = x = (0-64 * (X) + 392);;
		y = y = (0-64 * (Y) + 394);
	}
	public void openMenu() {
		menuOpen = true;

	}
	public void closeMenu() {
		menuOpen = false;

	}
	public boolean getMenuOpen() {
		return menuOpen;
	}
	public void menuUp() {
		selected--;

	}
	public void menuDown() {
		selected++;

	}
	public void select() {
		select = true;

	}

	//set key
	public void setUpKey(int c) {
		up = c;
		selectUpKey = false;

	}
	public void setLeftKey(int c) {
		left = c;
		selectLeftKey = false;

	}
	public void setDownKey(int c) {
		down = c;
		selectDownKey = false;

	}
	public void setRightKey(int c) {
		right = c;
		selectRightKey = false;

	}
	public void setSelectKey(int c) {
		selectKey = c;
		selectSelectKey = false;

	}
	public void setMenuKey(int c) {
		menuKey = c;
		selectMenuKey = false;

	}

	public void increaseFrame() {
		frame++;

	}

	//tell if key is being selected
	public boolean getSelectUpKey() {
		return selectUpKey;
	}
	public boolean getSelectLeftKey() {
		return selectLeftKey;
	}
	public boolean getSelectDownKey() {
		return selectDownKey;
	}
	public boolean getSelectRightKey() {
		return selectRightKey;
	}
	public boolean getSelectSelectKey() {
		return selectSelectKey;
	}
	public boolean getSelectMenuKey() {
		return selectMenuKey;
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
		rightPressed= true;
	}
	public void rightReleased() {
		rightPressed = false;
		rightReleased = true;
	}
	public void enterPressed() {
		enterPressed = true;
	}
	public void enterReleased() {
		enterPressed = false;
		enterReleased = true;
	}

	//set the menu tab
	public void setMenuPart(int n) {
		menuPart = n;

	}
	//menu controls
	public int getMenuPart() {
		return menuPart;
	}

	public void setSelected(int n) {
		selected = n;
	}

	public int getSelected() {
		return selected;
	}

	//save data
	private void save() {
		String storageToString = "";
		for(int i = 0; i < Battle.storage.length; i ++) {
			storageToString += "/" + Shapemon.shapemonToSave(Battle.storage[i]);
		}
		saveFile.setSave(x + "/" + y + "/" + movingDirection + "/" + swimming + "/" + MainClass.getTutorialPart() + "/" + shapemonCenterNumber + "/" + 
		Shapemon.shapemonToSave(player.getShapemon(1)) + "/" + Shapemon.shapemonToSave(player.getShapemon(2)) + "/" + Shapemon.shapemonToSave(player.getShapemon(3)) + "/" + 
		Shapemon.shapemonToSave(player.getShapemon(4)) + "/" + Shapemon.shapemonToSave(player.getShapemon(5)) + "/" + Shapemon.shapemonToSave(player.getShapemon(6)) + storageToString );
	}
	//load data
	private void load() {
		int l = saveFile.getSave().indexOf("/");
		x = Integer.parseInt(saveFile.getSave().substring(59,l));
		y = Integer.parseInt(saveFile.getSave().substring(l + 1, saveFile.getSave().indexOf("/", l + 1) ));
		l = saveFile.getSave().indexOf("/", l + 1);
		movingDirection = Integer.parseInt(saveFile.getSave().substring(l + 1,saveFile.getSave().indexOf("/", l + 1) ));
		l = saveFile.getSave().indexOf("/", l + 1);
		swimming = Boolean.parseBoolean(saveFile.getSave().substring(l + 1, saveFile.getSave().indexOf("/", l + 1)) );
		l = saveFile.getSave().indexOf("/", l + 1);
		MainClass.setTutorialPart(Integer.parseInt(saveFile.getSave().substring(l + 1, saveFile.getSave().indexOf("/", l + 1)) ));
		l = saveFile.getSave().indexOf("/", l + 1);
		

	}
	//text font----------------------------------------------------------------------------------------------------------------------------------------
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

	private void drawStar(int starX, int starY, int r, Graphics g) {
		Polygon star = new Polygon();
		star.addPoint(starX, starY-r);
		star.addPoint(starX+(int)(0.223348*r), starY-(int)(r*0.3090169));
		star.addPoint(starX+(int)(0.9510*r),starY-(int)(r*0.3090169));
		star.addPoint(starX+(int)(0.3614014*r), starY+(int)(r*0.117426));
		star.addPoint(starX+(int)(0.587785*r), starY+(int)(r*0.80901699));
		star.addPoint(starX, starY+(int)(r*0.38));
		star.addPoint(starX-(int)(0.587785*r), starY+(int)(r*0.80901699));
		star.addPoint(starX-(int)(0.3614014*r),starY+(int)(r*0.117426));
		star.addPoint(starX-(int)(0.9510*r), starY-(int)(r*0.3090169));
		star.addPoint(starX-(int)(0.223348*r), starY-(int)(r*0.3090169));
		g.fillPolygon(star);
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
	
	//----------------------------------------------------------------------------------------------------------------------------------------
	
	//rest of code is long simple algorith of breaking down arrays into printable tiles
	//the algorithim got to big for one method so its in multiple
	private void drawTiles(Graphics g) {
		int k = ((y - 394)/(0-64) - 8) * n[0] + (x - 392)/(0-64) - 14 ;
		//int k = 2;


		for(int i = 1; i <= 15; i++) {

			for(int j = 1; j <= 15; j++) {

				//64 * (j - 1) + x, 64 * (i - 1) + y,
				//64 * (j - 1) - 120 + ShiftY, 64 * (i - 1) - 120 + ShiftX,

				try {
					if(k < n.length) {
						if(n[k] == 0  ) {
							
							g.drawImage(pathCenter, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 30) {
							
							g.drawImage((new ImageIcon("PathLeft.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 31 ) {
							
							g.drawImage((new ImageIcon("PathRight.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 32) {
							
							g.drawImage((new ImageIcon("PathTop.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 33) {
							
							g.drawImage((new ImageIcon("PathBottom.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 34) {
							
							g.drawImage((new ImageIcon("PathBottomLeft1.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 35) {
							
							g.drawImage((new ImageIcon("PathBottomRight1.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 36) {
							
							g.drawImage((new ImageIcon("PathTopLeft1.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 37) {
							
							g.drawImage((new ImageIcon("PathTopRight1.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 38) {
							
							g.drawImage((new ImageIcon("PathBottomLeft2.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 39) {
							
							g.drawImage((new ImageIcon("PathBottomRight2.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 40) {
							
							g.drawImage((new ImageIcon("PathTopLeft2.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 41) {
							
							g.drawImage((new ImageIcon("PathTopRight2.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 50) {
							
							g.drawImage((new ImageIcon("WaterLeft.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 51) {
							
							g.drawImage((new ImageIcon("WaterRight.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 52) {
							
							g.drawImage((new ImageIcon("WaterTop.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 53) {
							
							g.drawImage((new ImageIcon("WaterBottom.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 54) {
							
							g.drawImage((new ImageIcon("PathBottomLeft1.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 55) {
							
							g.drawImage((new ImageIcon("PathBottomRight1.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 56) {
							
							g.drawImage((new ImageIcon("PathTopLeft1.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] ==  57) {
							
							g.drawImage((new ImageIcon("PathTopRight1.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 58) {
							
							g.drawImage((new ImageIcon("PathBottomLeft2.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 59) {
							
							g.drawImage((new ImageIcon("PathBottomRight2.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 60) {
							
							g.drawImage((new ImageIcon("PathTopLeft2.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 61) {
							
							g.drawImage((new ImageIcon("PathTopRight2.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 1) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 2) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 11) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(treeTopLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 12) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(treeTopRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 13) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(treeMiddleLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 14) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(treeMiddleRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 15) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(treeBottomLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 16) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(treeBottomRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						}  else if(n[k] == 17) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(treeBottomLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(treeTopLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 18) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(treeBottomRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(treeTopRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 19) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(treeBottomRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(treeTopLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 20) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(treeBottomLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(treeTopRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						}  else if(n[k] == 21 ) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(treeTopLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						}   else if(n[k] == 22 ) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(treeTopRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						}  else if(n[k] == 23  ) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(rockTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(treeTopLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						}   else if(n[k] == 24 ) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(rockTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(treeTopRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 3  ) {
							//water
							g.drawImage(waterTile1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 4  ) {
							//wet sand
							g.drawImage(waterTile2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 5  ) {
							//rock on dry sand
							g.drawImage(waterTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 6  ) {
							//rock on wet sand
							g.setColor(new Color (200,170,0));
							g.fillRect(64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64);
							g.setColor(new Color(155,100,50));
							g.fillRect(64 * (j - 1) + x + 10, 64 * (i - 1) + y + 10, 60, 60);
						} else if(n[k] == 7 ) {
							//dirt tile
							g.setColor(new Color(150,100,25));
							g.fillRect(64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64);
						} else if(n[k] == 28) {
							//mountain tile
							g.setColor(new Color(130,64,10));
							g.fillRect(64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64);
						} else if(n[k] == 29 ) {
							//hole tile
							g.setColor(new Color(0,0,0));
							g.fillRect(64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64);

						} else if(n[k] == 91) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(rockTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 92) {
							
							g.drawImage(waterMurgeDown, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(rockTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 93) {
							
							g.drawImage(lightSand, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(rockTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 94) {
							
							g.drawImage(waterTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(rockTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 95) {
							
							g.drawImage(waterMurgeRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(rockTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 96) {
							
							g.drawImage(waterGroundMurgeGroundDown1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(rockTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 97) {
							
							g.drawImage(waterTile1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(rockTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 98) {
							
							g.drawImage(waterTile2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(rockTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 400) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

							g.drawImage(waterGroundMurgeGroundUp1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(rockTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						}   else if(n[k] == 70) {
							

							g.drawImage(lightSand, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 71) {
							

							g.drawImage(waterMurgeWaterDownLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 72) {
							

							g.drawImage(waterMurgeWaterUpLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 73) {
							

							g.drawImage(waterMurgeWaterUpRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 74) {
							

							g.drawImage(waterMurgeWaterDownRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 75) {
							

							g.drawImage(waterMurgeDown, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 76 ) {
							

							g.drawImage(waterMurgeUp, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 77) {
							

							g.drawImage(waterMurgeRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 78) {
							

							g.drawImage(waterMurgeLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 79) {
							

							g.drawImage(waterMurgeSandUpLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 64) {
							

							g.drawImage((new ImageIcon("SandMurgeLightUpRight.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 81) {
							

							g.drawImage((new ImageIcon("SandMurgeLightDownLeft.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 82 ) {
							

							g.drawImage((new ImageIcon("SandMurgeLightDownRight.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 83 ) {
							

							g.drawImage(waterMurgeSandDownRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 87) {
							

							g.drawImage(waterMurgeWaterUpLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 99) {
							

							g.drawImage((new ImageIcon("RedFlower.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 121) {
							
							g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage((new ImageIcon("House1Tile1.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 122 ) {
							
							g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage((new ImageIcon("House1Tile2.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 123) {
							
							g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage((new ImageIcon("House1Tile3.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 124) {
							
							g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage((new ImageIcon("House1Tile4.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 125) {
							
							g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage((new ImageIcon("House1Tile5.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 126) {
							
							g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage((new ImageIcon("House1Tile6.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 127) {
							
							g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage((new ImageIcon("House1Tile7.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 128) {
							
							g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage((new ImageIcon("House1Tile8.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 129) {
							
							g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage((new ImageIcon("House1Tile9.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 130) {
							
							g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage((new ImageIcon("House1Tile10.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 131) {
							
							g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage((new ImageIcon("House1Tile11.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 132) {
							
							g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage((new ImageIcon("House1Tile12.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 133) {
							
							g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage((new ImageIcon("House1Tile13.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 134 ) {
							
							g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage((new ImageIcon("House1Tile14.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 135 ) {
							
							g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage((new ImageIcon("House1Tile15.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 136) {
							
							g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage((new ImageIcon("House1Tile16.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 127) {
							
							g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage((new ImageIcon("TreeTopLeft3.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 200) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(waterGroundMurgeGroundUp1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 201 ) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(waterGroundMurgeGroundUp2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 202) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(waterGroundMurgeGroundLeft1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 203 ) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(waterGroundMurgeGroundLeft2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 204) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(waterGroundMurgeGroundDown1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 205 ) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(waterGroundMurgeGroundDown2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 206) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(waterGroundMurgeGroundRight1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 207 ) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(waterGroundMurgeGroundRight2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 208) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(waterGroundMurgeGroundUpRight1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 209) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(waterGroundMurgeGroundUpRight2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 210) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(waterGroundMurgeGroundUpLeft1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 211) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(waterGroundMurgeGroundUpLeft2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 212) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(waterGroundMurgeGroundDownRight1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 213) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(waterGroundMurgeGroundDownRight2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 214) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(waterGroundMurgeGroundDownLeft1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 215) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(waterGroundMurgeGroundDownLeft2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 216) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(waterGroundMurgeWaterUpRight1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 217) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(waterGroundMurgeWaterUpRight2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 218) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(waterGroundMurgeWaterUpLeft1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 219) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(waterGroundMurgeWaterUpLeft2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 220) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(waterGroundMurgeWaterDownRight1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 221) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(waterGroundMurgeWaterDownRight2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 222) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(waterGroundMurgeWaterDownLeft1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 223) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(waterGroundMurgeWaterDownLeft2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 300) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(hillTileFront, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 301) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(hillTileLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 302) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(hillTileTop, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 303) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(hillTileRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 304) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(hillTileHillUpLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 305) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(hillTileHillUpRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 306) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(hillTileHillDownLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 307) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(hillTileHillDownRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 308) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(hillTileGroundUpLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 309) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(hillTileGroundUpRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 310) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(hillTileGroundDownLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 311) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(hillTileGroundDownRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 312) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(lightSandCorner4, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 88 + YShift, 32, 32, null);
							g.drawImage(lightSandCorner3, 64 * (j - 1) - 88 + XShift, 64 * (i - 1) - 88 + YShift, 32, 32, null);
							g.drawImage(hillTileFront, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 313) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(lightSandCorner3, 64 * (j - 1) - 88 + XShift, 64 * (i - 1) - 88 + YShift, 32, 32, null);
							g.drawImage(hillTileGroundDownRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 314) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(lightSandCorner2, 64 * (j - 1) - 88 + XShift, 64 * (i - 1) - 120 + YShift, 32, 32, null);
							g.drawImage(lightSandCorner4, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 88 + YShift, 32, 32, null);
							g.drawImage(lightSandCorner3, 64 * (j - 1) - 88 + XShift, 64 * (i - 1) - 88 + YShift, 32, 32, null);
							g.drawImage(hillTileHillUpLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n[k] == 998) {
							

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 256, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 320 , 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 384, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 468, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 256, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift +256, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift +320, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift +320, 64, 64, null);


							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 256, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 320 ,64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 384, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 468, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);

							g.drawImage(shapemonCenter, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 576, 448, null);
						}else if(n[k] == 997) {
							

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift,64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 256, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 320 , 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 384, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 468, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 256, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift +256, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift +320, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift +320, 64, 64, null);


							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 256, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 320 ,64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 384, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 468, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);

							g.drawImage(shapemonCenter, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift, 576, 448, null);
						}else if(n[k] == 996) {
							

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift,64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 256, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 320, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 384, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 468, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 256, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift -256, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift -320, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift -320, 64, 64, null);


							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 256, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 320 ,64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 384, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 468, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);

							g.drawImage(shapemonCenter, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift - 384, 576, 448, null);
						}else if(n[k] == 995) {
							

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 256, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 320 , 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 384, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 468, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 256, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift -256, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift -320, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift -320, 64, 64, null);


							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 256, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 320 ,64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 384, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 468, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);

							g.drawImage(shapemonCenter, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 384, 576, 448, null);
						} else if(n[k] == 994) {
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);

							g.drawImage(house2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 256, 256, null);
						} else if(n[k] == 993) {
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);

							g.drawImage(house2, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 256, 256, null);
						} else if(n[k] == 992) {
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);

							g.drawImage(house2, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 256, 256, null);
						} else if(n[k] == 991) {
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);

							g.drawImage(house2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 192, 256, 256, null);
						} else if(n[k] == 990) {
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);

							g.drawImage(house3, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 256, 256, null);
						} else if(n[k] == 989) {
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);

							g.drawImage(house3, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 256, 256, null);
						} else if(n[k] == 988) {
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);

							g.drawImage(house3, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 256, 256, null);
						} else if(n[k] == 987) {
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);

							g.drawImage(house3, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 192, 256, 256, null);
						}  else if(n[k] == 986) {
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);

							g.drawImage(house4, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 256, 256, null);
						} else if(n[k] == 985) {
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);

							g.drawImage(house4, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 256, 256, null);
						} else if(n[k] == 984) {
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);

							g.drawImage(house4, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 256, 256, null);
						} else if(n[k] == 983) {
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);

							g.drawImage(house4, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 256, 256, null);
						}  else if(n[k] == 982) {
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);

							g.drawImage(house5, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 256, 256, null);
						} else if(n[k] == 981) {
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);

							g.drawImage(house5, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 256, 256, null);
						} else if(n[k] == 980) {
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);

							g.drawImage(house5, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 256, 256, null);
						} else if(n[k] == 979) {
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);

							g.drawImage(house4, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 192, 256, 256, null);
						} else if(n[k] == 978) {
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(breakableTree, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
						} else if(n[k] == 977) {
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(breakableRock, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
						} else if(n[k] == 400) {
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
						} else if(n[k] == 976) {
							g.setColor(Color.black);
							g.fillRect( 64 * (j - 1) - 120 + XShift - 448, 64 * (i - 1) - 120 + YShift - 256, 960, 64);
							g.fillRect( 64 * (j - 1) - 120 + XShift - 448, 64 * (i - 1) - 120 + YShift + 256, 960, 64);
							g.fillRect( 64 * (j - 1) - 120 + XShift - 448, 64 * (i - 1) - 120 + YShift - 192, 64, 448);
							g.fillRect( 64 * (j - 1) - 120 + XShift + 448, 64 * (i - 1) - 120 + YShift + 192, 64, 448);
							g.drawImage(shapemonCenterInside, 64 * (j - 1) - 120 + XShift - 448, 64 * (i - 1) - 120 + YShift - 256, 960, 576, null);

						}else if(n[k] == 972) {
							g.setColor(Color.black);
							g.fillRect( 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64);
						} else if(n[k] == 603) {
							g.drawImage(pathCenter, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(proffesor, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 16, 64, 80, null);
						} else if(n[k] == 402) {
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 16, 64, 80, null);
						} else if(n[k] == 403) {
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 16, 64, 80, null);
						} else if(n[k] == 404) {
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 16, 64, 80, null);
						} else if(n[k] == 405) {
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 16, 64, 80, null);
						} else if(n[k] == 406) {
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 16, 64, 80, null);
						} else if(n[k] == 407) {
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 16, 64, 80, null);
						} else if(n[k] == 408) {
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 16, 64, 80, null);
						} else if(n[k] == 409) {
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 16, 64, 80, null);
						} else if(n[k] == 410) {
							g.drawImage(waterTile1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
						} else if(n[k] == 411) {
							g.drawImage(waterTile2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
						}

					} else if(k >n.length && k - n.length < n2.length) {
						if(n2[k-n.length] == 0  ) {
							
							g.drawImage(pathCenter, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 30) {
							
							g.drawImage((new ImageIcon("PathLeft.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 31 ) {
							
							g.drawImage((new ImageIcon("PathRight.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 32) {
							
							g.drawImage((new ImageIcon("PathTop.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 33) {
							
							g.drawImage((new ImageIcon("PathBottom.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 34) {
							
							g.drawImage((new ImageIcon("PathBottomLeft1.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 35) {
							
							g.drawImage((new ImageIcon("PathBottomRight1.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 36) {
							
							g.drawImage((new ImageIcon("PathTopLeft1.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 37) {
							
							g.drawImage((new ImageIcon("PathTopRight1.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 38) {
							
							g.drawImage((new ImageIcon("PathBottomLeft2.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 39) {
							
							g.drawImage((new ImageIcon("PathBottomRight2.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 40) {
							
							g.drawImage((new ImageIcon("PathTopLeft2.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 41) {
							
							g.drawImage((new ImageIcon("PathTopRight2.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 50) {
							
							g.drawImage((new ImageIcon("WaterLeft.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 51) {
							
							g.drawImage((new ImageIcon("WaterRight.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 52) {
							
							g.drawImage((new ImageIcon("WaterTop.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 53) {
							
							g.drawImage((new ImageIcon("WaterBottom.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 54) {
							
							g.drawImage((new ImageIcon("PathBottomLeft1.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 55) {
							
							g.drawImage((new ImageIcon("PathBottomRight1.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 56) {
							
							g.drawImage((new ImageIcon("PathTopLeft1.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] ==  57) {
							
							g.drawImage((new ImageIcon("PathTopRight1.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 58) {
							
							g.drawImage((new ImageIcon("PathBottomLeft2.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 59) {
							
							g.drawImage((new ImageIcon("PathBottomRight2.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 60) {
							
							g.drawImage((new ImageIcon("PathTopLeft2.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 61) {
							
							g.drawImage((new ImageIcon("PathTopRight2.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 1) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 2) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 11) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(treeTopLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 12) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(treeTopRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 13) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(treeMiddleLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 14) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(treeMiddleRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 15) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(treeBottomLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 16) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(treeBottomRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						}  else if(n2[k-n.length] == 17) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(treeBottomLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(treeTopLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 18) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(treeBottomRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(treeTopRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 19) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(treeBottomRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(treeTopLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 20) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(treeBottomLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(treeTopRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						}  else if(n2[k-n.length] == 21 ) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(treeTopLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						}   else if(n2[k-n.length] == 22 ) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(treeTopRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						}  else if(n2[k-n.length] == 23  ) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(rockTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(treeTopLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						}   else if(n2[k-n.length] == 24 ) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(rockTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(treeTopRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 3  ) {
							//water
							g.drawImage(waterTile1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 4  ) {
							//wet sand
							g.drawImage(waterTile2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 5  ) {
							//rock on dry sand
							g.drawImage(waterTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 6  ) {
							//rock on wet sand
							g.setColor(new Color (200,170,0));
							g.fillRect(64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64);
							g.setColor(new Color(155,100,50));
							g.fillRect(64 * (j - 1) + x + 10, 64 * (i - 1) + y + 10, 60, 60);
						} else if(n2[k-n.length] == 7 ) {
							//dirt tile
							g.setColor(new Color(150,100,25));
							g.fillRect(64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64);
						} else if(n2[k-n.length] == 28) {
							//mountain tile
							g.setColor(new Color(130,64,10));
							g.fillRect(64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64);
						} else if(n2[k-n.length] == 29 ) {
							//hole tile
							g.setColor(new Color(0,0,0));
							g.fillRect(64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64);

						} else if(n2[k-n.length] == 91) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(rockTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 92) {
							
							g.drawImage(waterMurgeDown, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(rockTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 93) {
							
							g.drawImage(lightSand, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(rockTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 94) {
							
							g.drawImage(waterTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(rockTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 70) {
							

							g.drawImage((new ImageIcon("LightSand.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 71) {
							

							g.drawImage((new ImageIcon("SandMurgeDarkDownLeft.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 72) {
							

							g.drawImage((new ImageIcon("SandMurgeDarkUpLeft.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 73) {
							

							g.drawImage((new ImageIcon("SandMurgeDarkUpRight.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 74) {
							

							g.drawImage((new ImageIcon("SandMurgeDarkDownRight.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 75) {
							

							g.drawImage((new ImageIcon("SandMurgeDown.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 76 ) {
							

							g.drawImage((new ImageIcon("SandMurgeUp.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 77) {
							

							g.drawImage((new ImageIcon("SandMurgeRight.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 78) {
							

							g.drawImage((new ImageIcon("SandMurgeLeft.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 79) {
							

							g.drawImage((new ImageIcon("SandMurgeLightUpLeft.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 64) {
							

							g.drawImage((new ImageIcon("SandMurgeLightUpRight.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 81) {
							

							g.drawImage((new ImageIcon("SandMurgeLightDownLeft.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 82 ) {
							

							g.drawImage((new ImageIcon("SandMurgeLightDownRight.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 83 ) {
							

							g.drawImage((new ImageIcon("WaterMurgeSandDownRight.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 87) {
							

							g.drawImage((new ImageIcon("WaterMurgeWaterUpLeft.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 99) {
							

							g.drawImage((new ImageIcon("RedFlower.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 121) {
							
							g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage((new ImageIcon("House1Tile1.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 122 ) {
							
							g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage((new ImageIcon("House1Tile2.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 123) {
							
							g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage((new ImageIcon("House1Tile3.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 124) {
							
							g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage((new ImageIcon("House1Tile4.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 125) {
							
							g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage((new ImageIcon("House1Tile5.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 126) {
							
							g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage((new ImageIcon("House1Tile6.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 127) {
							
							g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage((new ImageIcon("House1Tile7.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 128) {
							
							g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage((new ImageIcon("House1Tile8.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 129) {
							
							g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage((new ImageIcon("House1Tile9.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 130) {
							
							g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage((new ImageIcon("House1Tile10.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 131) {
							
							g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage((new ImageIcon("House1Tile11.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 132) {
							
							g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage((new ImageIcon("House1Tile12.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 133) {
							
							g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage((new ImageIcon("House1Tile13.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 134 ) {
							
							g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage((new ImageIcon("House1Tile14.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 135 ) {
							
							g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage((new ImageIcon("House1Tile15.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 136) {
							
							g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage((new ImageIcon("House1Tile16.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 127) {
							
							g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage((new ImageIcon("TreeTopLeft3.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 200) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(waterGroundMurgeGroundUp1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 201 ) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(waterGroundMurgeGroundUp2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 202) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(waterGroundMurgeGroundLeft1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 203 ) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(waterGroundMurgeGroundLeft2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 204) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(waterGroundMurgeGroundDown1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 205 ) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(waterGroundMurgeGroundDown2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 206) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(waterGroundMurgeGroundRight1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 207 ) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(waterGroundMurgeGroundRight2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 208) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(waterGroundMurgeGroundUpRight1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 209) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(waterGroundMurgeGroundUpRight2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 210) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(waterGroundMurgeGroundUpLeft1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 211) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(waterGroundMurgeGroundUpLeft2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 212) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(waterGroundMurgeGroundDownRight1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 213) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(waterGroundMurgeGroundDownRight2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 214) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(waterGroundMurgeGroundDownLeft1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 215) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(waterGroundMurgeGroundDownLeft2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 216) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(waterGroundMurgeWaterUpRight1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 217) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(waterGroundMurgeWaterUpRight2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 218) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(waterGroundMurgeWaterUpLeft1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 219) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(waterGroundMurgeWaterUpLeft2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 220) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(waterGroundMurgeWaterDownRight1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 221) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(waterGroundMurgeWaterDownRight2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 222) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(waterGroundMurgeWaterDownLeft1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 223) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(waterGroundMurgeWaterDownLeft2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 300) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(hillTileFront, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 301) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(hillTileLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 302) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(hillTileTop, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 303) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(hillTileRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 304) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(hillTileHillUpLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 305) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(hillTileHillUpRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 306) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(hillTileHillDownLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 307) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(hillTileHillDownRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 308) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(hillTileGroundUpLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 309) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(hillTileGroundUpRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 310) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(hillTileGroundDownLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 311) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(hillTileGroundDownRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 312) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(lightSandCorner4, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 88 + YShift, 32, 32, null);
							g.drawImage(lightSandCorner3, 64 * (j - 1) - 88 + XShift, 64 * (i - 1) - 88 + YShift, 32, 32, null);
							g.drawImage(hillTileFront, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 313) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(lightSandCorner3, 64 * (j - 1) - 88 + XShift, 64 * (i - 1) - 88 + YShift, 32, 32, null);
							g.drawImage(hillTileGroundDownRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 314) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(lightSandCorner2, 64 * (j - 1) - 88 + XShift, 64 * (i - 1) - 120 + YShift, 32, 32, null);
							g.drawImage(lightSandCorner4, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 88 + YShift, 32, 32, null);
							g.drawImage(lightSandCorner3, 64 * (j - 1) - 88 + XShift, 64 * (i - 1) - 88 + YShift, 32, 32, null);
							g.drawImage(hillTileHillUpLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 315) {
							
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(lightSandCorner2, 64 * (j - 1) - 88 + XShift, 64 * (i - 1) - 120 + YShift, 32, 32, null);
							g.drawImage(lightSandCorner3, 64 * (j - 1) - 88 + XShift, 64 * (i - 1) - 88 + YShift, 32, 32, null);
							g.drawImage(hillTileRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 998) {
							

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 256, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 320 , 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 384, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 468, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 256, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift +256, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift +320, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift +320, 64, 64, null);


							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 256, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 320 ,64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 384, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 468, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);

							g.drawImage(shapemonCenter, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 576, 448, null);
						}else if(n2[k-n.length] == 997) {
							

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift,64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 256, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 320 , 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 384, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 468, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 256, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift +256, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift +320, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift +320, 64, 64, null);


							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 256, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 320 ,64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 384, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 468, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);

							g.drawImage(shapemonCenter, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift, 576, 448, null);
						}else if(n2[k-n.length] == 996) {
							

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift,64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 256, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 320, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 384, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 468, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 256, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift -256, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift -320, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift -320, 64, 64, null);


							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 256, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 320 ,64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 384, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 468, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);

							g.drawImage(shapemonCenter, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift - 384, 576, 448, null);
						}else if(n2[k-n.length] == 995) {
							

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 256, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 320 , 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 384, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 468, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 256, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift -256, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift -320, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift -320, 64, 64, null);


							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 256, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 320 ,64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 384, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 468, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);

							g.drawImage(shapemonCenter, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 384, 576, 448, null);
						} else if(n2[k-n.length] == 994) {
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);

							g.drawImage(house2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 256, 256, null);
						} else if(n2[k-n.length] == 993) {
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);

							g.drawImage(house2, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 256, 256, null);
						} else if(n2[k-n.length] == 992) {
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);

							g.drawImage(house2, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 256, 256, null);
						} else if(n2[k-n.length] == 991) {
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift,+64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);

							g.drawImage(house2, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift - 192, 256, 256, null);
						} else if(n2[k-n.length] == 990) {
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);

							g.drawImage(house3, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 256, 256, null);
						} else if(n2[k-n.length] == 989) {
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);

							g.drawImage(house3, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 256, 256, null);
						} else if(n2[k-n.length] == 988) {
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);

							g.drawImage(house3, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 256, 256, null);
						} else if(n2[k-n.length] == 987) {
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);

							g.drawImage(house3, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 192, 256, 256, null);
						}  else if(n2[k-n.length] == 986) {
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);

							g.drawImage(house4, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 256, 256, null);
						} else if(n2[k-n.length] == 985) {
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);

							g.drawImage(house4, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 256, 256, null);
						} else if(n2[k-n.length] == 984) {
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);

							g.drawImage(house4, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 256, 256, null);
						} else if(n2[k-n.length] == 983) {
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);

							g.drawImage(house4, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 256, 256, null);
						}  else if(n2[k-n.length] == 982) {
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);

							g.drawImage(house5, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 256, 256, null);
						} else if(n2[k-n.length] == 981) {
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);

							g.drawImage(house5, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 256, 256, null);
						} else if(n2[k-n.length] == 980) {
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);

							g.drawImage(house5, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 256, 256, null);
						} else if(n2[k-n.length] == 979) {
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);

							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);

							g.drawImage(house5, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 192, 256, 256, null);
						} else if(n2[k-n.length] == 978) {
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(breakableTree, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
						} else if(n2[k-n.length] == 977) {
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(breakableRock, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
						} else if(n2[k-n.length] == 400) {
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
						}  else if(n2[k-n.length]== 500) {
							g.drawImage(stairForwardLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length]== 501) {
							g.drawImage(stairForwardCenter, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 502) {
							g.drawImage(stairForwardRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

						} else if(n2[k-n.length] == 600) {
							g.drawImage(pathCenter, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(proffesor, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 16, 64, 80, null);
						}  else if(n2[k-n.length] == 601) {
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(proffesor, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift -16, 64, 80, null);
						}  else if(n2[k-n.length] == 402) {
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 16, 64, 80, null);
						} else if(n2[k-n.length] == 403) {
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 16, 64, 80, null);
						} else if(n2[k-n.length] == 404) {
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 16, 64, 80, null);
						} else if(n2[k-n.length] == 405) {
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 16, 64, 80, null);
						} else if(n2[k-n.length] == 406) {
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 16, 64, 80, null);
						} else if(n2[k-n.length] == 407) {
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 16, 64, 80, null);
						} else if(n2[k-n.length] == 408) {
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 16, 64, 80, null);
						} else if(n2[k-n.length] == 409) {
							g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
							g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 16, 64, 80, null);
						} else if(n2[k-n.length] == 410) {
							g.drawImage(waterTile1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
						} else if(n2[k-n.length] == 411) {
							g.drawImage(waterTile2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
						}
					} else if(k >n.length + n2.length && k - n.length -n2.length < n3.length) {
						drawArray3(g,k,i,j);


					}   else if(k >n.length + n2.length + n3.length - 1 && k - n.length -n2.length - n3.length < n4.length) {
						drawArray4(g,k,i,j);
					} else if(k >n.length + n2.length + n3.length + n4.length -1 && k - n.length -n2.length - n3.length - n4.length< n5.length) {
						drawArray5(g, k, i, j);
					}
				}catch(Exception e) {

				}
				k++;

			}
			k -= 15;
			k += n[0];
		}
	}
	private void drawArray3(Graphics g, int k, int i, int j) {
		if(n3[k-n.length-n2.length] == 0  ) {
			
			g.drawImage(pathCenter, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 30) {
			
			g.drawImage((new ImageIcon("PathLeft.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 31 ) {
			
			g.drawImage((new ImageIcon("PathRight.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 32) {
			
			g.drawImage((new ImageIcon("PathTop.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 33) {
			
			g.drawImage((new ImageIcon("PathBottom.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 34) {
			
			g.drawImage((new ImageIcon("PathBottomLeft1.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 35) {
			
			g.drawImage((new ImageIcon("PathBottomRight1.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 36) {
			
			g.drawImage((new ImageIcon("PathTopLeft1.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 37) {
			
			g.drawImage((new ImageIcon("PathTopRight1.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 38) {
			
			g.drawImage((new ImageIcon("PathBottomLeft2.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 39) {
			
			g.drawImage((new ImageIcon("PathBottomRight2.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 40) {
			
			g.drawImage((new ImageIcon("PathTopLeft2.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 41) {
			
			g.drawImage((new ImageIcon("PathTopRight2.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 50) {
			
			g.drawImage((new ImageIcon("WaterLeft.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 51) {
			
			g.drawImage((new ImageIcon("WaterRight.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 52) {
			
			g.drawImage((new ImageIcon("WaterTop.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 53) {
			
			g.drawImage((new ImageIcon("WaterBottom.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 54) {
			
			g.drawImage((new ImageIcon("PathBottomLeft1.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 55) {
			
			g.drawImage((new ImageIcon("PathBottomRight1.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 56) {
			
			g.drawImage((new ImageIcon("PathTopLeft1.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] ==  57) {
			
			g.drawImage((new ImageIcon("PathTopRight1.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 58) {
			
			g.drawImage((new ImageIcon("PathBottomLeft2.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 59) {
			
			g.drawImage((new ImageIcon("PathBottomRight2.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 60) {
			
			g.drawImage((new ImageIcon("PathTopLeft2.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 61) {
			
			g.drawImage((new ImageIcon("PathTopRight2.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 1) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 2) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 11) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(treeTopLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 12) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(treeTopRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 13) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(treeMiddleLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 14) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(treeMiddleRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 15) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(treeBottomLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 16) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(treeBottomRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		}  else if(n3[k-n.length-n2.length] == 17) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(treeBottomLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(treeTopLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 18) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(treeBottomRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(treeTopRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 19) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(treeBottomRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(treeTopLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 20) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(treeBottomLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(treeTopRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		}  else if(n3[k-n.length-n2.length] == 21 ) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(treeTopLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		}   else if(n3[k-n.length-n2.length] == 22 ) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(treeTopRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		}  else if(n3[k-n.length-n2.length] == 23  ) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(rockTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(treeTopLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		}   else if(n3[k-n.length-n2.length] == 24 ) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(rockTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(treeTopRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 3  ) {
			//water
			g.drawImage(waterTile1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 4  ) {
			//wet sand
			g.drawImage(waterTile2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 5  ) {
			//rock on dry sand
			g.drawImage(waterTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 6  ) {
			//rock on wet sand
			g.setColor(new Color (200,170,0));
			g.fillRect(64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64);
			g.setColor(new Color(155,100,50));
			g.fillRect(64 * (j - 1) + x + 10, 64 * (i - 1) + y + 10, 60, 60);
		} else if(n3[k-n.length-n2.length] == 7 ) {
			//dirt tile
			g.setColor(new Color(150,100,25));
			g.fillRect(64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64);
		} else if(n3[k-n.length-n2.length] == 28) {
			//mountain tile
			g.setColor(new Color(130,64,10));
			g.fillRect(64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64);
		} else if(n3[k-n.length-n2.length] == 29 ) {
			//hole tile
			g.setColor(new Color(0,0,0));
			g.fillRect(64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64);

		} else if(n3[k-n.length-n2.length] == 91) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(rockTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 92) {
			
			g.drawImage(waterMurgeDown, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(rockTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 93) {
			
			g.drawImage(lightSand, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(rockTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 94) {
			
			g.drawImage(waterTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(rockTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 95) {
			
			g.drawImage(waterMurgeRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(rockTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 70) {
			

			g.drawImage(lightSand, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 71) {
			

			g.drawImage(waterMurgeWaterDownLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 72) {
			

			g.drawImage(waterMurgeWaterUpLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 73) {
			

			g.drawImage(waterMurgeWaterUpRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 74) {
			

			g.drawImage(waterMurgeWaterDownRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 75) {
			

			g.drawImage(waterMurgeDown, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 76 ) {
			

			g.drawImage(waterMurgeUp, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 77) {
			

			g.drawImage(waterMurgeRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 78) {
			

			g.drawImage(waterMurgeLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 79) {
			

			g.drawImage(waterMurgeSandUpLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 64) {
			

			g.drawImage((new ImageIcon("SandMurgeLightUpRight.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 81) {
			

			g.drawImage((new ImageIcon("SandMurgeLightDownLeft.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 82 ) {
			

			g.drawImage((new ImageIcon("SandMurgeLightDownRight.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 83 ) {
			

			g.drawImage((new ImageIcon("WaterMurgeSandDownRight.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 87) {
			

			g.drawImage((new ImageIcon("WaterMurgeWaterUpLeft.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 99) {
			

			g.drawImage((new ImageIcon("RedFlower.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 121) {
			
			g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage((new ImageIcon("House1Tile1.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 122 ) {
			
			g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage((new ImageIcon("House1Tile2.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 123) {
			
			g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage((new ImageIcon("House1Tile3.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 124) {
			
			g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage((new ImageIcon("House1Tile4.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 125) {
			
			g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage((new ImageIcon("House1Tile5.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 126) {
			
			g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage((new ImageIcon("House1Tile6.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 127) {
			
			g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage((new ImageIcon("House1Tile7.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 128) {
			
			g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage((new ImageIcon("House1Tile8.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 129) {
			
			g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage((new ImageIcon("House1Tile9.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 130) {
			
			g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage((new ImageIcon("House1Tile10.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 131) {
			
			g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage((new ImageIcon("House1Tile11.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 132) {
			
			g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage((new ImageIcon("House1Tile12.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 133) {
			
			g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage((new ImageIcon("House1Tile13.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 134 ) {
			
			g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage((new ImageIcon("House1Tile14.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 135 ) {
			
			g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage((new ImageIcon("House1Tile15.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 136) {
			
			g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage((new ImageIcon("House1Tile16.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 127) {
			
			g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage((new ImageIcon("TreeTopLeft3.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 200) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeGroundUp1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 201 ) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeGroundUp2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 202) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeGroundLeft1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 203 ) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeGroundLeft2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 204) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeGroundDown1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 205 ) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeGroundDown2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 206) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeGroundRight1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 207 ) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeGroundRight2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 208) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeGroundUpRight1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 209) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeGroundUpRight2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 210) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeGroundUpLeft1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 211) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeGroundUpLeft2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 212) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeGroundDownRight1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 213) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeGroundDownRight2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 214) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeGroundDownLeft1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 215) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeGroundDownLeft2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 216) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeWaterUpRight1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 217) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeWaterUpRight2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 218) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeWaterUpLeft1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 219) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeWaterUpLeft2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 220) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeWaterDownRight1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 221) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeWaterDownRight2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 222) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeWaterDownLeft1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 223) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeWaterDownLeft2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 300) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(hillTileFront, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 301) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(hillTileLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 302) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(hillTileTop, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 303) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(hillTileRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 304) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(hillTileHillUpLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 305) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(hillTileHillUpRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 306) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(hillTileHillDownLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 307) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(hillTileHillDownRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 308) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(hillTileGroundUpLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 309) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(hillTileGroundUpRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 310) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(hillTileGroundDownLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 311) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(hillTileGroundDownRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 312) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(lightSandCorner4, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 88 + YShift, 32, 32, null);
			g.drawImage(lightSandCorner3, 64 * (j - 1) - 88 + XShift, 64 * (i - 1) - 88 + YShift, 32, 32, null);
			g.drawImage(hillTileFront, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 313) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(lightSandCorner3, 64 * (j - 1) - 88 + XShift, 64 * (i - 1) - 88 + YShift, 32, 32, null);
			g.drawImage(hillTileGroundDownRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 314) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(lightSandCorner2, 64 * (j - 1) - 88 + XShift, 64 * (i - 1) - 120 + YShift, 32, 32, null);
			g.drawImage(lightSandCorner4, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 88 + YShift, 32, 32, null);
			g.drawImage(lightSandCorner3, 64 * (j - 1) - 88 + XShift, 64 * (i - 1) - 88 + YShift, 32, 32, null);
			g.drawImage(hillTileHillUpLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 315) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(lightSandCorner2, 64 * (j - 1) - 88 + XShift, 64 * (i - 1) - 120 + YShift, 32, 32, null);
			g.drawImage(lightSandCorner3, 64 * (j - 1) - 88 + XShift, 64 * (i - 1) - 88 + YShift, 32, 32, null);
			g.drawImage(hillTileRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n3[k-n.length-n2.length] == 998) {
			

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 256, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 320 , 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 384, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 468, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 256, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift +256, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift +320, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift +320, 64, 64, null);


			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 256, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 320 ,64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 384, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 468, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);

			g.drawImage(shapemonCenter, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 576, 448, null);
		}else if(n3[k-n.length-n2.length] == 997) {
			

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift,64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 256, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 320 , 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 384, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 468, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 256, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift +256, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift +320, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift +320, 64, 64, null);


			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 256, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 320 ,64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 384, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 468, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);

			g.drawImage(shapemonCenter, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift, 576, 448, null);
		}else if(n3[k-n.length-n2.length] == 996) {
			

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift,64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 256, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 320, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 384, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 468, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 256, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift -256, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift -320, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift -320, 64, 64, null);


			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 256, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 320 ,64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 384, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 468, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);

			g.drawImage(shapemonCenter, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift - 384, 576, 448, null);
		}else if(n3[k-n.length-n2.length] == 995) {
			

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 256, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 320 , 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 384, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 468, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 256, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift -256, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift -320, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift -320, 64, 64, null);


			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 256, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 320 ,64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 384, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 468, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);

			g.drawImage(shapemonCenter, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 384, 576, 448, null);
		} else if(n3[k-n.length-n2.length] == 994) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);

			g.drawImage(house2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 256, 256, null);
		} else if(n3[k-n.length-n2.length] == 993) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);

			g.drawImage(house2, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 256, 256, null);
		} else if(n3[k-n.length-n2.length] == 992) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);

			g.drawImage(house2, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 256, 256, null);
		} else if(n3[k-n.length-n2.length] == 991) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);

			g.drawImage(house2, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 256, 256, null);
		} else if(n3[k-n.length-n2.length] == 990) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);

			g.drawImage(house3, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 256, 256, null);
		} else if(n3[k-n.length-n2.length] == 989) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);

			g.drawImage(house3, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 256, 256, null);
		} else if(n3[k-n.length-n2.length] == 988) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);

			g.drawImage(house3, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 256, 256, null);
		} else if(n3[k-n.length-n2.length] == 987) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);

			g.drawImage(house3, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 256, 256, null);
		}  else if(n3[k-n.length-n2.length] == 986) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);

			g.drawImage(house4, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 256, 256, null);
		} else if(n3[k-n.length-n2.length] == 985) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);

			g.drawImage(house4, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 256, 256, null);
		} else if(n3[k-n.length-n2.length] == 984) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);

			g.drawImage(house4, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 256, 256, null);
		} else if(n3[k-n.length-n2.length] == 983) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);

			g.drawImage(house4, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 256, 256, null);
		}  else if(n3[k-n.length-n2.length] == 982) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);

			g.drawImage(house5, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 256, 256, null);
		} else if(n3[k-n.length-n2.length] == 981) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);

			g.drawImage(house5, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 256, 256, null);
		} else if(n3[k-n.length-n2.length] == 980) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);

			g.drawImage(house5, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 256, 256, null);
		} else if(n3[k-n.length-n2.length] == 979) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);

			g.drawImage(house4, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 256, 256, null);
		} else if(n3[k-n.length-n2.length] == 978) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(breakableTree, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
		} else if(n3[k-n.length-n2.length] == 977) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(breakableRock, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
		} else if(n3[k-n.length-n2.length] == 401) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
		} else if(n3[k-n.length-n2.length] == 402) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 16, 64, 80, null);
		} else if(n3[k-n.length-n2.length] == 403) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 16, 64, 80, null);
		} else if(n3[k-n.length-n2.length] == 404) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 16, 64, 80, null);
		} else if(n3[k-n.length-n2.length] == 405) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 16, 64, 80, null);
		} else if(n3[k-n.length-n2.length] == 406) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 16, 64, 80, null);
		} else if(n3[k-n.length-n2.length] == 407) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 16, 64, 80, null);
		} else if(n3[k-n.length-n2.length] == 408) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 16, 64, 80, null);
		} else if(n3[k-n.length-n2.length] == 409) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 16, 64, 80, null);
		} else if(n3[k-n.length-n2.length] == 410) {
			g.drawImage(waterTile1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
		} else if(n3[k-n.length-n2.length] == 411) {
			g.drawImage(waterTile2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
		} else if(n3[k-n.length-n2.length] == 600) {
			g.drawImage(pathCenter, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(proffesor, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 16, 64, 80, null);
		} 
	}
	private void drawArray4(Graphics g, int k, int i, int j) {
		if(n4[k-n.length-n2.length-n3.length] == 0  ) {
			
			g.drawImage(pathCenter, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 30) {
			
			g.drawImage((new ImageIcon("PathLeft.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 31 ) {
			
			g.drawImage((new ImageIcon("PathRight.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 32) {
			
			g.drawImage((new ImageIcon("PathTop.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 33) {
			
			g.drawImage((new ImageIcon("PathBottom.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 34) {
			
			g.drawImage((new ImageIcon("PathBottomLeft1.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 35) {
			
			g.drawImage((new ImageIcon("PathBottomRight1.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 36) {
			
			g.drawImage((new ImageIcon("PathTopLeft1.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 37) {
			
			g.drawImage((new ImageIcon("PathTopRight1.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 38) {
			
			g.drawImage((new ImageIcon("PathBottomLeft2.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 39) {
			
			g.drawImage((new ImageIcon("PathBottomRight2.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 40) {
			
			g.drawImage((new ImageIcon("PathTopLeft2.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 41) {
			
			g.drawImage((new ImageIcon("PathTopRight2.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 50) {
			
			g.drawImage((new ImageIcon("WaterLeft.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 51) {
			
			g.drawImage((new ImageIcon("WaterRight.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 52) {
			
			g.drawImage((new ImageIcon("WaterTop.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 53) {
			
			g.drawImage((new ImageIcon("WaterBottom.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 54) {
			
			g.drawImage((new ImageIcon("PathBottomLeft1.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 55) {
			
			g.drawImage((new ImageIcon("PathBottomRight1.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 56) {
			
			g.drawImage((new ImageIcon("PathTopLeft1.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] ==  57) {
			
			g.drawImage((new ImageIcon("PathTopRight1.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 58) {
			
			g.drawImage((new ImageIcon("PathBottomLeft2.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 59) {
			
			g.drawImage((new ImageIcon("PathBottomRight2.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 60) {
			
			g.drawImage((new ImageIcon("PathTopLeft2.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 61) {
			
			g.drawImage((new ImageIcon("PathTopRight2.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 1) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 2) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 11) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(treeTopLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 12) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(treeTopRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 13) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(treeMiddleLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 14) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(treeMiddleRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 15) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(treeBottomLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 16) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(treeBottomRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		}  else if(n4[k-n.length-n2.length-n3.length] == 17) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(treeBottomLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(treeTopLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 18) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(treeBottomRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(treeTopRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 19) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(treeBottomRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(treeTopLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 20) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(treeBottomLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(treeTopRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		}  else if(n4[k-n.length-n2.length-n3.length] == 21 ) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(treeTopLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		}   else if(n4[k-n.length-n2.length-n3.length] == 22 ) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(treeTopRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		}  else if(n4[k-n.length-n2.length-n3.length] == 23  ) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(rockTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(treeTopLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		}   else if(n4[k-n.length-n2.length-n3.length] == 24 ) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(rockTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(treeTopRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 3  ) {
			//water
			g.drawImage(waterTile1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 4  ) {
			//wet sand
			g.drawImage(waterTile2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 5  ) {
			//rock on dry sand
			g.drawImage(waterTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 6  ) {
			//rock on wet sand
			g.setColor(new Color (200,170,0));
			g.fillRect(64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64);
			g.setColor(new Color(155,100,50));
			g.fillRect(64 * (j - 1) + x + 10, 64 * (i - 1) + y + 10, 60, 60);
		} else if(n4[k-n.length-n2.length-n3.length] == 7 ) {
			//dirt tile
			g.setColor(new Color(150,100,25));
			g.fillRect(64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64);
		} else if(n4[k-n.length-n2.length-n3.length] == 28) {
			//mountain tile
			g.setColor(new Color(130,64,10));
			g.fillRect(64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64);
		} else if(n4[k-n.length-n2.length-n3.length] == 29 ) {
			//hole tile
			g.setColor(new Color(0,0,0));
			g.fillRect(64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64);

		} else if(n4[k-n.length-n2.length-n3.length] == 91) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(rockTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 92) {
			
			g.drawImage(waterMurgeDown, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(rockTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 93) {
			
			g.drawImage(lightSand, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(rockTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 94) {
			
			g.drawImage(waterTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(rockTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 95) {
			
			g.drawImage(waterMurgeRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(rockTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 70) {
			

			g.drawImage(lightSand, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 71) {
			

			g.drawImage(waterMurgeWaterDownLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 72) {
			

			g.drawImage(waterMurgeWaterUpLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 73) {
			

			g.drawImage(waterMurgeWaterUpRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 74) {
			

			g.drawImage(waterMurgeWaterDownRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 75) {
			

			g.drawImage(waterMurgeDown, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 76 ) {
			

			g.drawImage(waterMurgeUp, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 77) {
			

			g.drawImage(waterMurgeRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 78) {
			

			g.drawImage(waterMurgeLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 79) {
			

			g.drawImage(waterMurgeSandUpLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 64) {
			

			g.drawImage((new ImageIcon("SandMurgeLightUpRight.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 81) {
			

			g.drawImage((new ImageIcon("SandMurgeLightDownLeft.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 82 ) {
			

			g.drawImage((new ImageIcon("SandMurgeLightDownRight.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 83 ) {
			

			g.drawImage((new ImageIcon("WaterMurgeSandDownRight.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 87) {
			

			g.drawImage((new ImageIcon("WaterMurgeWaterUpLeft.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 99) {
			

			g.drawImage((new ImageIcon("RedFlower.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 121) {
			
			g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage((new ImageIcon("House1Tile1.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 122 ) {
			
			g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage((new ImageIcon("House1Tile2.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 123) {
			
			g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage((new ImageIcon("House1Tile3.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 124) {
			
			g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage((new ImageIcon("House1Tile4.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 125) {
			
			g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage((new ImageIcon("House1Tile5.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 126) {
			
			g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage((new ImageIcon("House1Tile6.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 127) {
			
			g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage((new ImageIcon("House1Tile7.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 128) {
			
			g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage((new ImageIcon("House1Tile8.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 129) {
			
			g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage((new ImageIcon("House1Tile9.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 130) {
			
			g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage((new ImageIcon("House1Tile10.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 131) {
			
			g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage((new ImageIcon("House1Tile11.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 132) {
			
			g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage((new ImageIcon("House1Tile12.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 133) {
			
			g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage((new ImageIcon("House1Tile13.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 134 ) {
			
			g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage((new ImageIcon("House1Tile14.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 135 ) {
			
			g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage((new ImageIcon("House1Tile15.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 136) {
			
			g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage((new ImageIcon("House1Tile16.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 127) {
			
			g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage((new ImageIcon("TreeTopLeft3.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 200) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeGroundUp1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 201 ) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeGroundUp2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 202) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeGroundLeft1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 203 ) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeGroundLeft2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 204) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeGroundDown1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 205 ) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeGroundDown2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 206) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeGroundRight1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 207 ) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeGroundRight2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 208) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeGroundUpRight1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 209) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeGroundUpRight2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 210) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeGroundUpLeft1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 211) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeGroundUpLeft2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 212) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeGroundDownRight1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 213) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeGroundDownRight2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 214) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeGroundDownLeft1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 215) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeGroundDownLeft2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 216) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeWaterUpRight1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 217) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeWaterUpRight2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 218) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeWaterUpLeft1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 219) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeWaterUpLeft2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 220) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeWaterDownRight1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 221) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeWaterDownRight2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 222) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeWaterDownLeft1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 223) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeWaterDownLeft2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 300) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(hillTileFront, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 301) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(hillTileLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 302) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(hillTileTop, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 303) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(hillTileRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 304) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(hillTileHillUpLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 305) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(hillTileHillUpRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 306) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(hillTileHillDownLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 307) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(hillTileHillDownRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 308) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(hillTileGroundUpLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 309) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(hillTileGroundUpRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 310) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(hillTileGroundDownLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 311) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(hillTileGroundDownRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 312) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(lightSandCorner4, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 88 + YShift, 32, 32, null);
			g.drawImage(lightSandCorner3, 64 * (j - 1) - 88 + XShift, 64 * (i - 1) - 88 + YShift, 32, 32, null);
			g.drawImage(hillTileFront, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 313) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(lightSandCorner3, 64 * (j - 1) - 88 + XShift, 64 * (i - 1) - 88 + YShift, 32, 32, null);
			g.drawImage(hillTileGroundDownRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 314) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(lightSandCorner2, 64 * (j - 1) - 88 + XShift, 64 * (i - 1) - 120 + YShift, 32, 32, null);
			g.drawImage(lightSandCorner4, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 88 + YShift, 32, 32, null);
			g.drawImage(lightSandCorner3, 64 * (j - 1) - 88 + XShift, 64 * (i - 1) - 88 + YShift, 32, 32, null);
			g.drawImage(hillTileHillUpLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 315) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(lightSandCorner2, 64 * (j - 1) - 88 + XShift, 64 * (i - 1) - 120 + YShift, 32, 32, null);
			g.drawImage(lightSandCorner3, 64 * (j - 1) - 88 + XShift, 64 * (i - 1) - 88 + YShift, 32, 32, null);
			g.drawImage(hillTileRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length]== 998) {
			

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 256, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 320 , 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 384, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 468, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 256, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift +256, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift +320, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift +320, 64, 64, null);


			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 256, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 320 ,64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 384, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 468, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);

			g.drawImage(shapemonCenter, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 576, 448, null);
		}else if(n4[k-n.length-n2.length-n3.length]== 997) {
			

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift,64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 256, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 320 , 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 384, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 468, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 256, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift +256, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift +320, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift +320, 64, 64, null);


			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 256, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 320 ,64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 384, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 468, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);

			g.drawImage(shapemonCenter, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift, 576, 448, null);
		}else if(n4[k-n.length-n2.length-n3.length]== 996) {
			

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift,64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 256, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 320, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 384, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 468, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 256, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift -256, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift -320, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift -320, 64, 64, null);


			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 256, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 320 ,64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 384, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 468, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);

			g.drawImage(shapemonCenter, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift - 384, 576, 448, null);
		}else if(n4[k-n.length-n2.length-n3.length]== 995) {
			

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 256, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 320 , 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 384, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 468, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 256, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift -256, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift -320, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift -320, 64, 64, null);


			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 256, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 320 ,64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 384, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 468, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);

			g.drawImage(shapemonCenter, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 384, 576, 448, null);
		} else if(n4[k-n.length-n2.length-n3.length]== 994) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);

			g.drawImage(house2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 256, 256, null);
		} else if(n4[k-n.length-n2.length-n3.length]== 993) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);

			g.drawImage(house2, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 256, 256, null);
		} else if(n4[k-n.length-n2.length-n3.length]== 992) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);

			g.drawImage(house2, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 256, 256, null);
		} else if(n4[k-n.length-n2.length-n3.length]== 991) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);

			g.drawImage(house2, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 256, 256, null);
		} else if(n4[k-n.length-n2.length-n3.length]== 990) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);

			g.drawImage(house3, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 256, 256, null);
		} else if(n4[k-n.length-n2.length-n3.length]== 989) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);

			g.drawImage(house3, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 256, 256, null);
		} else if(n4[k-n.length-n2.length-n3.length]== 988) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);

			g.drawImage(house3, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 256, 256, null);
		} else if(n4[k-n.length-n2.length-n3.length]== 987) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);

			g.drawImage(house3, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 256, 256, null);
		}  else if(n4[k-n.length-n2.length-n3.length]== 986) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);

			g.drawImage(house4, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 256, 256, null);
		} else if(n4[k-n.length-n2.length-n3.length]== 985) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);

			g.drawImage(house4, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 256, 256, null);
		} else if(n4[k-n.length-n2.length-n3.length]== 984) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);

			g.drawImage(house4, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 256, 256, null);
		} else if(n4[k-n.length-n2.length-n3.length]== 983) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);

			g.drawImage(house4, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 256, 256, null);
		}  else if(n4[k-n.length-n2.length-n3.length]== 982) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);

			g.drawImage(house5, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 256, 256, null);
		} else if(n4[k-n.length-n2.length-n3.length]== 981) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);

			g.drawImage(house5, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 256, 256, null);
		} else if(n4[k-n.length-n2.length-n3.length]== 980) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);

			g.drawImage(house5, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 256, 256, null);
		} else if(n4[k-n.length-n2.length-n3.length]== 979) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);

			g.drawImage(house4, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 256, 256, null);
		} else if(n4[k-n.length-n2.length-n3.length]== 978) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(breakableTree, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
		} else if(n4[k-n.length-n2.length-n3.length]== 977) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(breakableRock, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
		} else if(n4[k-n.length-n2.length-n3.length] == 500) {
			g.drawImage(stairForwardLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 501) {
			g.drawImage(stairForwardCenter, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n4[k-n.length-n2.length-n3.length] == 502) {
			g.drawImage(stairForwardRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		}  else if(n4[k-n.length-n2.length-n3.length] == 602) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(proffesor, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift -16, 64, 80, null);
		}  else if(n4[k-n.length-n2.length-n3.length] == 402) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 16, 64, 80, null);
		} else if(n4[k-n.length-n2.length-n3.length] == 403) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 16, 64, 80, null);
		} else if(n4[k-n.length-n2.length-n3.length] == 404) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 16, 64, 80, null);
		} else if(n4[k-n.length-n2.length-n3.length] == 405) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 16, 64, 80, null);
		} else if(n4[k-n.length-n2.length-n3.length] == 406) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 16, 64, 80, null);
		} else if(n4[k-n.length-n2.length-n3.length] == 407) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 16, 64, 80, null);
		} else if(n4[k-n.length-n2.length-n3.length] == 408) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 16, 64, 80, null);
		} else if(n4[k-n.length-n2.length-n3.length] == 409) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 16, 64, 80, null);
		} else if(n4[k-n.length-n2.length-n3.length] == 410) {
			g.drawImage(waterTile1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
		} else if(n4[k-n.length-n2.length-n3.length] == 411) {
			g.drawImage(waterTile2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
		}
	}
	private void drawArray5(Graphics g, int k, int i, int j){
		if(n5[k-n.length-n2.length-n3.length-n4.length] == 0  ) {
			
			g.drawImage(pathCenter, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 30) {
			
			g.drawImage((new ImageIcon("PathLeft.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 31 ) {
			
			g.drawImage((new ImageIcon("PathRight.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 32) {
			
			g.drawImage((new ImageIcon("PathTop.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 33) {
			
			g.drawImage((new ImageIcon("PathBottom.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 34) {
			
			g.drawImage((new ImageIcon("PathBottomLeft1.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 35) {
			
			g.drawImage((new ImageIcon("PathBottomRight1.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 36) {
			
			g.drawImage((new ImageIcon("PathTopLeft1.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 37) {
			
			g.drawImage((new ImageIcon("PathTopRight1.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 38) {
			
			g.drawImage((new ImageIcon("PathBottomLeft2.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 39) {
			
			g.drawImage((new ImageIcon("PathBottomRight2.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 40) {
			
			g.drawImage((new ImageIcon("PathTopLeft2.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 41) {
			
			g.drawImage((new ImageIcon("PathTopRight2.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 50) {
			
			g.drawImage((new ImageIcon("WaterLeft.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 51) {
			
			g.drawImage((new ImageIcon("WaterRight.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 52) {
			
			g.drawImage((new ImageIcon("WaterTop.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 53) {
			
			g.drawImage((new ImageIcon("WaterBottom.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 54) {
			
			g.drawImage((new ImageIcon("PathBottomLeft1.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 55) {
			
			g.drawImage((new ImageIcon("PathBottomRight1.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 56) {
			
			g.drawImage((new ImageIcon("PathTopLeft1.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] ==  57) {
			
			g.drawImage((new ImageIcon("PathTopRight1.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 58) {
			
			g.drawImage((new ImageIcon("PathBottomLeft2.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 59) {
			
			g.drawImage((new ImageIcon("PathBottomRight2.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 60) {
			
			g.drawImage((new ImageIcon("PathTopLeft2.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 61) {
			
			g.drawImage((new ImageIcon("PathTopRight2.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 1) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 2) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 11) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(treeTopLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 12) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(treeTopRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 13) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(treeMiddleLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 14) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(treeMiddleRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 15) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(treeBottomLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 16) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(treeBottomRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		}  else if(n5[k-n.length-n2.length-n3.length-n4.length] == 17) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(treeBottomLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(treeTopLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 18) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(treeBottomRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(treeTopRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 19) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(treeBottomRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(treeTopLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 20) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(treeBottomLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(treeTopRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		}  else if(n5[k-n.length-n2.length-n3.length-n4.length] == 21 ) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(treeTopLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		}   else if(n5[k-n.length-n2.length-n3.length-n4.length] == 22 ) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(treeTopRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		}  else if(n5[k-n.length-n2.length-n3.length-n4.length] == 23  ) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(rockTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(treeTopLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		}   else if(n5[k-n.length-n2.length-n3.length-n4.length] == 24 ) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(rockTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(treeTopRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 3  ) {
			//water
			g.drawImage(waterTile1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 4  ) {
			//wet sand
			g.drawImage(waterTile2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 5  ) {
			//rock on dry sand
			g.drawImage(waterTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 6  ) {
			//rock on wet sand
			g.setColor(new Color (200,170,0));
			g.fillRect(64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64);
			g.setColor(new Color(155,100,50));
			g.fillRect(64 * (j - 1) + x + 10, 64 * (i - 1) + y + 10, 60, 60);
		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 7 ) {
			//dirt tile
			g.setColor(new Color(150,100,25));
			g.fillRect(64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64);
		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 28) {
			//mountain tile
			g.setColor(new Color(130,64,10));
			g.fillRect(64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64);
		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 29 ) {
			//hole tile
			g.setColor(new Color(0,0,0));
			g.fillRect(64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 91) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(rockTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 92) {
			
			g.drawImage(waterMurgeDown, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(rockTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 93) {
			
			g.drawImage(lightSand, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(rockTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 94) {
			
			g.drawImage(waterTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(rockTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 95) {
			
			g.drawImage(waterMurgeRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(rockTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 70) {
			

			g.drawImage(lightSand, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 71) {
			

			g.drawImage(waterMurgeWaterDownLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 72) {
			

			g.drawImage(waterMurgeWaterUpLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 73) {
			

			g.drawImage(waterMurgeWaterUpRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 74) {
			

			g.drawImage(waterMurgeWaterDownRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 75) {
			

			g.drawImage(waterMurgeDown, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 76 ) {
			

			g.drawImage(waterMurgeUp, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 77) {
			

			g.drawImage(waterMurgeRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 78) {
			

			g.drawImage(waterMurgeLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 79) {
			

			g.drawImage(waterMurgeSandUpLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 64) {
			

			g.drawImage((new ImageIcon("SandMurgeLightUpRight.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 81) {
			

			g.drawImage((new ImageIcon("SandMurgeLightDownLeft.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 82 ) {
			

			g.drawImage((new ImageIcon("SandMurgeLightDownRight.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 83 ) {
			

			g.drawImage((new ImageIcon("WaterMurgeSandDownRight.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 87) {
			

			g.drawImage((new ImageIcon("WaterMurgeWaterUpLeft.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 99) {
			

			g.drawImage((new ImageIcon("RedFlower.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 121) {
			
			g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage((new ImageIcon("House1Tile1.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 122 ) {
			
			g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage((new ImageIcon("House1Tile2.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 123) {
			
			g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage((new ImageIcon("House1Tile3.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 124) {
			
			g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage((new ImageIcon("House1Tile4.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 125) {
			
			g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage((new ImageIcon("House1Tile5.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 126) {
			
			g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage((new ImageIcon("House1Tile6.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 127) {
			
			g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage((new ImageIcon("House1Tile7.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 128) {
			
			g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage((new ImageIcon("House1Tile8.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 129) {
			
			g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage((new ImageIcon("House1Tile9.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 130) {
			
			g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage((new ImageIcon("House1Tile10.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 131) {
			
			g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage((new ImageIcon("House1Tile11.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 132) {
			
			g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage((new ImageIcon("House1Tile12.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 133) {
			
			g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage((new ImageIcon("House1Tile13.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 134 ) {
			
			g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage((new ImageIcon("House1Tile14.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 135 ) {
			
			g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage((new ImageIcon("House1Tile15.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 136) {
			
			g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage((new ImageIcon("House1Tile16.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 127) {
			
			g.drawImage((new ImageIcon("GrassTile.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage((new ImageIcon("TreeTopLeft3.gif")).getImage(), 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 200) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeGroundUp1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 201 ) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeGroundUp2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 202) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeGroundLeft1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 203 ) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeGroundLeft2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 204) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeGroundDown1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 205 ) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeGroundDown2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 206) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeGroundRight1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 207 ) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeGroundRight2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 208) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeGroundUpRight1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 209) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeGroundUpRight2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 210) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeGroundUpLeft1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 211) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeGroundUpLeft2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 212) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeGroundDownRight1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 213) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeGroundDownRight2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 214) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeGroundDownLeft1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 215) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeGroundDownLeft2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 216) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeWaterUpRight1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 217) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeWaterUpRight2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 218) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeWaterUpLeft1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 219) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeWaterUpLeft2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 220) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeWaterDownRight1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 221) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeWaterDownRight2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 222) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeWaterDownLeft1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 223) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(waterGroundMurgeWaterDownLeft2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 300) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(hillTileFront, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 301) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(hillTileLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 302) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(hillTileTop, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 303) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(hillTileRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 304) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(hillTileHillUpLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 305) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(hillTileHillUpRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 306) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(hillTileHillDownLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 307) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(hillTileHillDownRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 308) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(hillTileGroundUpLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 309) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(hillTileGroundUpRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 310) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(hillTileGroundDownLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 311) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(hillTileGroundDownRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 312) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(lightSandCorner4, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 88 + YShift, 32, 32, null);
			g.drawImage(lightSandCorner3, 64 * (j - 1) - 88 + XShift, 64 * (i - 1) - 88 + YShift, 32, 32, null);
			g.drawImage(hillTileFront, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 313) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(lightSandCorner3, 64 * (j - 1) - 88 + XShift, 64 * (i - 1) - 88 + YShift, 32, 32, null);
			g.drawImage(hillTileGroundDownRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 314) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(lightSandCorner2, 64 * (j - 1) - 88 + XShift, 64 * (i - 1) - 120 + YShift, 32, 32, null);
			g.drawImage(lightSandCorner4, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 88 + YShift, 32, 32, null);
			g.drawImage(lightSandCorner3, 64 * (j - 1) - 88 + XShift, 64 * (i - 1) - 88 + YShift, 32, 32, null);
			g.drawImage(hillTileHillUpLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 315) {
			
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(lightSandCorner2, 64 * (j - 1) - 88 + XShift, 64 * (i - 1) - 120 + YShift, 32, 32, null);
			g.drawImage(lightSandCorner3, 64 * (j - 1) - 88 + XShift, 64 * (i - 1) - 88 + YShift, 32, 32, null);
			g.drawImage(hillTileRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 998) {
			

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 256, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 320 , 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 384, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 468, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 256, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift +256, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift +320, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift +320, 64, 64, null);


			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 256, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 320 ,64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 384, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 468, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);

			g.drawImage(shapemonCenter, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 576, 448, null);
		}else if(n5[k-n.length-n2.length-n3.length-n4.length] == 997) {
			

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift,64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 256, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 320 , 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 384, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 468, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 256, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift +256, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift +320, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift +320, 64, 64, null);


			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 256, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 320 ,64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 384, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 468, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift + 384, 64, 64, null);

			g.drawImage(shapemonCenter, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift, 576, 448, null);
		}else if(n5[k-n.length-n2.length-n3.length-n4.length] == 996) {
			

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift,64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 256, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 320, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 384, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 468, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 256, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift -256, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift -320, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift -320, 64, 64, null);


			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 256, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 320 ,64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 384, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 468, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);

			g.drawImage(shapemonCenter, 64 * (j - 1) - 120 + XShift - 512, 64 * (i - 1) - 120 + YShift - 384, 576, 448, null);
		}else if(n5[k-n.length-n2.length-n3.length-n4.length] == 995) {
			

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 256, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 320 , 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 384, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 468, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 256, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift -256, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift -320, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift -320, 64, 64, null);


			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 256, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 320 ,64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 384, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 468, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 512, 64 * (i - 1) - 120 + YShift - 384, 64, 64, null);

			g.drawImage(shapemonCenter, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 384, 576, 448, null);
		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 994) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);

			g.drawImage(house2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 256, 256, null);
		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 993) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);

			g.drawImage(house2, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 256, 256, null);
		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 992) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);

			g.drawImage(house2, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 256, 256, null);
		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 991) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);

			g.drawImage(house2, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 256, 256, null);
		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 990) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);

			g.drawImage(house3, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 256, 256, null);
		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 989) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);

			g.drawImage(house3, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 256, 256, null);
		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 988) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);

			g.drawImage(house3, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 256, 256, null);
		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 987) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);

			g.drawImage(house3, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 256, 256, null);
		}  else if(n5[k-n.length-n2.length-n3.length-n4.length] == 986) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);

			g.drawImage(house4, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 256, 256, null);
		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 985) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);

			g.drawImage(house4, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 256, 256, null);
		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 984) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);

			g.drawImage(house4, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 256, 256, null);
		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 983) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);

			g.drawImage(house4, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 192, 256, 256, null);
		}  else if(n5[k-n.length-n2.length-n3.length-n4.length] == 982) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 64, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 128, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift + 192, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);

			g.drawImage(house5, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 256, 256, null);
		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 981) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 128, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift + 192, 64, 64, null);

			g.drawImage(house5, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 256, 256, null);
		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 980) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);

			g.drawImage(house5, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 256, 256, null);
		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 979) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 64, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 128, 64, 64, null);

			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 64, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 128, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 64, 64, null);

			g.drawImage(house5, 64 * (j - 1) - 120 + XShift - 192, 64 * (i - 1) - 120 + YShift - 192, 256, 256, null);
		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 978) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(breakableTree, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 977) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(breakableRock, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 500) {
			g.drawImage(stairForwardLeft, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 501) {
			g.drawImage(stairForwardCenter, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 502) {
			g.drawImage(stairForwardRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 503) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(hillTileRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(stairRightTop2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 504) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(hillTileRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(stairRightTop, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 505) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(hillTileRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(stairRightCenter, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 506) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(hillTileRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(stairRightBottom, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 507) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(hillTileRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(stairRightBottom2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 508) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(lightSandCorner2, 64 * (j - 1) - 88 + XShift, 64 * (i - 1) - 120 + YShift, 32, 32, null);
			g.drawImage(lightSandCorner3, 64 * (j - 1) - 88 + XShift, 64 * (i - 1) - 88 + YShift, 32, 32, null);
			g.drawImage(hillTileRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(stairRightTop2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 509) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(lightSandCorner2, 64 * (j - 1) - 88 + XShift, 64 * (i - 1) - 120 + YShift, 32, 32, null);
			g.drawImage(lightSandCorner3, 64 * (j - 1) - 88 + XShift, 64 * (i - 1) - 88 + YShift, 32, 32, null);
			g.drawImage(hillTileRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(stairRightTop, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 510) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(lightSandCorner2, 64 * (j - 1) - 88 + XShift, 64 * (i - 1) - 120 + YShift, 32, 32, null);
			g.drawImage(lightSandCorner3, 64 * (j - 1) - 88 + XShift, 64 * (i - 1) - 88 + YShift, 32, 32, null);
			g.drawImage(hillTileRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(stairRightCenter, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 511) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(lightSandCorner2, 64 * (j - 1) - 88 + XShift, 64 * (i - 1) - 120 + YShift, 32, 32, null);
			g.drawImage(lightSandCorner3, 64 * (j - 1) - 88 + XShift, 64 * (i - 1) - 88 + YShift, 32, 32, null);
			g.drawImage(hillTileRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(stairRightBottom, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 512) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(lightSandCorner2, 64 * (j - 1) - 88 + XShift, 64 * (i - 1) - 120 + YShift, 32, 32, null);
			g.drawImage(lightSandCorner3, 64 * (j - 1) - 88 + XShift, 64 * (i - 1) - 88 + YShift, 32, 32, null);
			g.drawImage(hillTileRight, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(stairRightBottom2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);

		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 402) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 16, 64, 80, null);
		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 403) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 16, 64, 80, null);
		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 404) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 16, 64, 80, null);
		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 405) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 16, 64, 80, null);
		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 406) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 16, 64, 80, null);
		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 407) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 16, 64, 80, null);
		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 408) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 16, 64, 80, null);
		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 409) {
			g.drawImage(grassTile, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
			g.drawImage(tallGrass, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift - 16, 64, 80, null);
		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 410) {
			g.drawImage(waterTile1, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
		} else if(n5[k-n.length-n2.length-n3.length-n4.length] == 411) {
			g.drawImage(waterTile2, 64 * (j - 1) - 120 + XShift, 64 * (i - 1) - 120 + YShift, 64, 64, null);
		}
	}
}