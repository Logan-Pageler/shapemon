

/*Coded by : Logan
 * Finsied 5/18/18
 * job hold everything together
 * 
 * 
 */
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MainClass extends JPanel implements ActionListener {

	private static volatile boolean upPressed = false;
	private static volatile boolean upReleased = true;
	private static volatile boolean leftPressed = false;
	private static volatile boolean downPressed = false;
	private static volatile boolean downReleased = true;
	private static volatile boolean rightPressed = false;
	private static volatile boolean menuPressed = false;
	private static volatile boolean menuReleased = true;
	private static volatile boolean selectPressed = false;
	private static volatile boolean selectReleased = true;
	private static volatile boolean shiftReleased = true;
	private static volatile boolean shiftPressed = false;
	private static volatile boolean qPressed = false;
	private static volatile boolean qReleased = true;

	private static int tutorialPart = 2;

	private boolean movingUp = false;
	private boolean movingLeft = false;
	private boolean movingDown = false;
	private boolean movingRight = false;

	private int movingUpCounter = 0;
	private int movingLeftCounter = 0;
	private int movingDownCounter = 0;
	private int movingRightCounter = 0;

	private static int up = 'W';
	private static int left = 'A';
	private static int down = 'S';
	private static int right = 'D';
	private static int select = 10;
	private static int menu = 27;
	private static int oldKey = 0;

	private static Battle battle = new Battle();

	private int upTile1;
	private int leftTile1;
	private int downTile1;
	private int rightTile1;

	private boolean battlingLegendary = false;

	private int frame = 0;

	private boolean battleJustEnded = false;

	public static Player player = new Player();

	private int[] solidBlock = {
			121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 91, 300, 304,
			303, 503, 507, 315, 312, 314, 313, 93, 94, 311, 29, 999, 998, 997, 996, 995, 994, 993, 992, 991,
			990, 989, 988, 987, 986, 985, 984, 983, 982, 981, 980, 979, 11, 12, 13, 14, 15, 16, 17, 18, 19,
			20, 21, 22, 23, 24 };

	private int[] waterTile = { 3, 4, 5, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214,
			215, 216, 217, 218, 219, 220, 221, 222, 223 };

	private int[] backToLandTiles = { 70, 1, 2, 38, 39, 40, 41, 33, 32, 31, 30 };

	private int[] grassTiles = { 2, 400 };
	static final int[] MapArray1 = MapGetterPart1.mapPart1;
	static final int[] MapArray2 = MapGetterPart2.mapPart2;
	static final int[] MapArray3 = MapGetterPart3.mapPart3;
	static final int[] MapArray4 = MapGetterPart4.mapPart4;
	static final int[] MapArray5 = MapGetterPart5.mapPart5;
	private static MapGenerator map = new MapGenerator(MapArray1, MapArray2, MapArray3, MapArray4, MapArray5,
			player, battle);
	private boolean battleRunning = false;

	public MainClass() {

		Timer clock = new Timer(9, this);
		clock.start();
		initComponents();

	}

	private void initComponents() {

		JPanel jPanel = new JPanel();
		JFrame jFrame = new JFrame();
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		jPanel.add(map);
		jPanel.add(battle);
		battle.setVisible(false);

		jFrame.add(jPanel);

		jFrame.setResizable(false);
		jFrame.setSize(720, 720);
		jFrame.setVisible(true);

	}

	public static void main(String[] args) {
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {

			@Override
			public boolean dispatchKeyEvent(KeyEvent ke) {
				synchronized (MainClass.class) {
					switch (ke.getID()) {
						case KeyEvent.KEY_PRESSED:

							if (map.getSelectUpKey()) {
								oldKey = up;
								up = (char) ke.getKeyCode();
								map.setUpKey(up);
								if (up == left) {
									left = oldKey;
									map.setLeftKey(oldKey);
								} else if (up == right) {
									right = oldKey;
									map.setRightKey(oldKey);
								} else if (up == down) {
									down = oldKey;
									map.setDownKey(oldKey);
								} else if (up == menu) {
									menu = oldKey;
									map.setMenuKey(oldKey);
								} else if (up == select) {
									select = oldKey;
									map.setSelectKey(oldKey);
								}
							} else if (map.getSelectLeftKey()) {
								oldKey = left;
								left = (char) ke.getKeyCode();
								map.setLeftKey(left);
								if (left == up) {
									up = oldKey;
									map.setUpKey(oldKey);
								} else if (left == right) {
									right = oldKey;
									map.setRightKey(oldKey);
								} else if (left == down) {
									down = oldKey;
									map.setDownKey(oldKey);
								} else if (left == menu) {
									menu = oldKey;
									map.setMenuKey(oldKey);
								} else if (left == select) {
									select = oldKey;
									map.setSelectKey(oldKey);
								}
							} else if (map.getSelectDownKey()) {
								oldKey = down;
								down = (char) ke.getKeyCode();
								map.setDownKey(down);
								if (down == right) {
									right = oldKey;
									map.setRightKey(oldKey);
								} else if (down == left) {
									left = oldKey;
									map.setLeftKey(oldKey);
								} else if (down == up) {
									up = oldKey;
									map.setUpKey(oldKey);
								} else if (down == menu) {
									menu = oldKey;
									map.setMenuKey(oldKey);
								} else if (down == select) {
									select = oldKey;
									map.setSelectKey(oldKey);
								}
							} else if (map.getSelectRightKey()) {
								oldKey = right;
								right = ke.getKeyCode();
								map.setRightKey(right);
								if (right == up) {
									up = oldKey;
									map.setUpKey(oldKey);
								} else if (right == down) {
									down = oldKey;
									map.setDownKey(oldKey);
								} else if (right == left) {
									left = -1;
									map.setLeftKey(oldKey);
								} else if (right == menu) {
									menu = oldKey;
									map.setMenuKey(oldKey);
								} else if (right == select) {
									select = oldKey;
									map.setSelectKey(oldKey);
								}
							} else if (map.getSelectSelectKey()) {
								oldKey = select;
								select = ke.getKeyCode();
								map.setSelectKey(select);
								if (select == up) {
									up = oldKey;
									map.setUpKey(oldKey);
								} else if (select == left) {
									left = oldKey;
									map.setLeftKey(oldKey);
								} else if (select == down) {
									down = oldKey;
									map.setDownKey(oldKey);
								} else if (select == right) {
									right = oldKey;
									map.setRightKey(oldKey);
								} else if (select == menu) {
									menu = oldKey;
									map.setMenuKey(oldKey);
								}

							} else if (map.getSelectMenuKey()) {
								oldKey = menu;
								menu = ke.getKeyCode();
								map.setMenuKey(menu);
								if (menu == up) {
									up = oldKey;
									map.setUpKey(oldKey);
								} else if (menu == left) {
									left = oldKey;
									map.setLeftKey(oldKey);
								} else if (menu == down) {
									down = oldKey;
									map.setDownKey(oldKey);
								} else if (menu == right) {
									right = oldKey;
									map.setRightKey(oldKey);
								} else if (menu == select) {
									select = oldKey;
									map.setSelectKey(oldKey);
								}

							} else {

								if (ke.getKeyCode() == up) {
									upPressed = true;

								}
								if (ke.getKeyCode() == left) {
									leftPressed = true;
								}
								if (ke.getKeyCode() == down) {
									downPressed = true;
								}
								if (ke.getKeyCode() == right) {
									rightPressed = true;
								}
								if (ke.getKeyCode() == select) {
									selectPressed = true;
								}

								if (ke.getKeyCode() == menu) {
									menuPressed = true;
								}
								if (ke.getKeyCode() == ke.VK_Q) {
									qPressed = true;
								}
								if (ke.getKeyCode() == ke.VK_SHIFT) {
									shiftPressed = true;
								}
							}
							break;

						case KeyEvent.KEY_RELEASED:
							if (ke.getKeyCode() == up) {
								upPressed = false;
								upReleased = true;
							}
							if (ke.getKeyCode() == left) {
								leftPressed = false;
							}
							if (ke.getKeyCode() == down) {
								downPressed = false;
								downReleased = true;
							}
							if (ke.getKeyCode() == right) {
								rightPressed = false;
							}
							if (ke.getKeyCode() == menu) {
								menuPressed = false;
								menuReleased = true;
							}
							if (ke.getKeyCode() == select) {
								selectPressed = false;
								selectReleased = true;
							}
							if (ke.getKeyCode() == ke.VK_Q) {
								qPressed = false;
							}
							if (ke.getKeyCode() == ke.VK_SHIFT) {
								shiftPressed = false;
							}

							break;
					}
					return false;
				}
			}
		});
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				MainClass MainProgram = new MainClass();
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		map.setBounds(0, 0, 720, 720);
		battle.setBounds(0, 0, 720, 720);

		if (!battle.isBattling() && battleJustEnded) {
			battleJustEnded = false;

			if (map.getFinalBattle() && battle.playerWins()) {
				map.setFinalBattle(false);
				map.openMenu();
				map.setMenuPart(32);
				tutorialPart = 5;
			}
			if (battlingLegendary && battle.playerWins()) {
				tutorialPart = 4;
				map.setXY(193, 36);
				map.openMenu();
				map.setShapemonCenterNumber(4);
				map.setMenuPart(24);
			}
			if (!battle.playerWins()) {

				if (map.getShapemonCenterNumber() == 1) {
					map.setXY(101, 98);
					try {
						player.getShapemon(1).heal();
					} catch (Exception ex) {
					}
					try {
						player.getShapemon(2).heal();
					} catch (Exception ex) {
					}
					try {
						player.getShapemon(3).heal();
					} catch (Exception ex) {
					}
					try {
						player.getShapemon(4).heal();
					} catch (Exception ex) {
					}
					try {
						player.getShapemon(5).heal();
					} catch (Exception ex) {
					}
					try {
						player.getShapemon(6).heal();
					} catch (Exception ex) {
					}

				} else {
					map.setXY(193, 36);
					try {
						player.getShapemon(1).heal();
					} catch (Exception ex) {
					}
					try {
						player.getShapemon(2).heal();
					} catch (Exception ex) {
					}
					try {
						player.getShapemon(3).heal();
					} catch (Exception ex) {
					}
					try {
						player.getShapemon(4).heal();
					} catch (Exception ex) {
					}
					try {
						player.getShapemon(5).heal();
					} catch (Exception ex) {
					}
					try {
						player.getShapemon(6).heal();
					} catch (Exception ex) {
					}
				}
			}
		}
		if (frame < 300) {

			map.increaseFrame();
			frame++;
		} else {

			if (!movingUp && !movingLeft && !movingDown && !movingRight && !map.getMenuOpen()) {
				if (menuPressed && menuReleased) {

					if (map.isVisible()) {

						map.openMenu();

						menuReleased = false;
					}
				} else if (upPressed) {

					if (map.isVisible()) {
						map.shiftHeadUp();
						if (map.getUpTile() == 601) {
							if (tutorialPart == 2) {
								map.openMenu();
								map.setMenuPart(18);
								tutorialPart++;
							} else {
								map.openMenu();
								map.setMenuPart(19);
							}
						} else if (map.getUpTile() == 600) {
							if (tutorialPart == 2) {
								map.openMenu();
								map.setMenuPart(20);

							} else {
								map.openMenu();
								map.setMenuPart(19);
							}
						} else if (map.getUpTile() == 602) {
							if (tutorialPart == 3) {
								map.openMenu();
								map.setMenuPart(29);

							} else {
								map.openMenu();
								map.setMenuPart(19);
							}
						} else if (map.getUpTile() == 603) {
							if (tutorialPart == 4) {
								map.openMenu();
								map.setMenuPart(31);

							} else {
								map.openMenu();
								map.setMenuPart(19);
							}
						} else if (map.getUpTile() == 974) {
							map.openMenu();
							map.setMenuPart(5);
						} else if (map.getUpTile() == 973) {
							map.setShapemonCenterNumber(2);
							map.setXY(193, 40);
						} else if (map.getUpTile() == 970) {
							map.setShapemonCenterNumber(3);
							map.setXY(193, 40);
						} else if (map.getUpTile() == 969) {
							map.setShapemonCenterNumber(4);
							map.setXY(193, 40);
						} else if (map.getUpTile() == 968) {
							map.setShapemonCenterNumber(5);
							map.setXY(193, 40);
						} else if (map.getUpTile() == 978) {
							if (player.hasMove(9)) {
								map.openMenu();
								map.setMenuPart(27);
							} else {
								map.openMenu();
								map.setMenuPart(26);
							}
						} else if (map.getUpTile() == 977) {
							if (player.hasMove(11)) {
								map.openMenu();
								map.setMenuPart(35);
							} else {
								map.openMenu();
								map.setMenuPart(34);
							}
						} else if (map.getUpTile() == 971) {
							if (map.getShapemonCenterNumber() == 2) {
								map.openMenu();
								map.setMenuPart(21);
							} else if (map.getShapemonCenterNumber() == 3) {
								map.openMenu();
								map.setMenuPart(22);
							} else if (map.getShapemonCenterNumber() == 4) {
								if (tutorialPart == 3) {
									map.openMenu();
									map.setMenuPart(23);
								} else {
									map.openMenu();
									map.setMenuPart(30);
								}
							} else if (map.getShapemonCenterNumber() == 5) {
								if (tutorialPart == 4) {
									map.openMenu();
									map.setMenuPart(25);
								} else {
									map.openMenu();
									map.setMenuPart(33);
								}
							}

						} else if (isTile(map.getUpTile(), grassTiles)
								&& player.getNumOfShapemon() == 0) {

							map.openMenu();
							map.setMenuPart(36);

						} else if (isTile(map.getUpTile(), backToLandTiles)) {
							map.setSwimming(false);
							movingUp = true;
						} else if (isTile(map.getUpTile(), waterTile)) {

							if (!map.getSwimming() && player.hasMove(10)) {
								map.openMenu();
								map.setMenuPart(28);
							} else if (!isTile(map.getUpTile(), solidBlock)
									&& map.getSwimming()) {
								movingUp = true;
							}
						} else if (!isTile(map.getUpTile(), solidBlock)) {

							movingUp = true;

						}
					} else if (battle.isBattling()) {
						battle.upPressed();
					}

				} else if (leftPressed) {
					if (map.isVisible()) {
						map.shiftHeadLeft();
						if (map.getLeftTile() == 601) {
							if (tutorialPart == 2) {
								map.openMenu();
								map.setMenuPart(18);
								tutorialPart++;
							} else {
								map.openMenu();
								map.setMenuPart(19);
							}
						} else if (map.getLeftTile() == 978) {
							if (player.hasMove(9)) {
								map.openMenu();
								map.setMenuPart(27);
							} else {
								map.openMenu();
								map.setMenuPart(26);
							}
						} else if (map.getLeftTile() == 977) {
							if (player.hasMove(11)) {
								map.openMenu();
								map.setMenuPart(35);
							} else {
								map.openMenu();
								map.setMenuPart(34);
							}
						} else if (map.getLeftTile() == 600) {
							if (tutorialPart == 2) {
								map.openMenu();
								map.setMenuPart(20);

							} else {
								map.openMenu();
								map.setMenuPart(19);
							}

						} else if (map.getLeftTile() == 602) {
							if (tutorialPart == 3) {
								map.openMenu();
								map.setMenuPart(29);

							} else {
								map.openMenu();
								map.setMenuPart(19);
							}
						} else if (map.getLeftTile() == 603) {
							if (tutorialPart == 4) {
								map.openMenu();
								map.setMenuPart(31);

							} else {
								map.openMenu();
								map.setMenuPart(19);
							}
						} else if (isTile(map.getLeftTile(), grassTiles)
								&& player.getNumOfShapemon() == 0) {

							map.openMenu();
							map.setMenuPart(36);

						} else if (isTile(map.getLeftTile(), backToLandTiles)) {
							map.setSwimming(false);
							movingLeft = true;
						} else if (isTile(map.getLeftTile(), waterTile)) {
							if (!map.getSwimming() && player.hasMove(10)) {
								map.openMenu();
								map.setMenuPart(28);
							} else if (!isTile(map.getLeftTile(), solidBlock)
									&& map.getSwimming()) {
								movingLeft = true;
							}
						} else if (!isTile(map.getLeftTile(), solidBlock)) {

							movingLeft = true;
						}
					} else if (battle.isBattling()) {
						battle.leftPressed();
					}

				} else if (downPressed) {
					if (map.isVisible()) {
						map.shiftHeadDown();
						if (map.getDownTile() == 601) {
							if (tutorialPart == 2) {
								map.openMenu();
								map.setMenuPart(18);
								tutorialPart++;
							} else {
								map.openMenu();
								map.setMenuPart(19);
							}
						} else if (map.getDownTile() == 600) {
							if (tutorialPart == 2) {
								map.openMenu();
								map.setMenuPart(20);

							} else {
								map.openMenu();
								map.setMenuPart(19);
							}
						} else if (map.getDownTile() == 602) {
							if (tutorialPart == 3) {
								map.openMenu();
								map.setMenuPart(29);

							} else {
								map.openMenu();
								map.setMenuPart(19);
							}
						} else if (map.getDownTile() == 603) {
							if (tutorialPart == 4) {
								map.openMenu();
								map.setMenuPart(31);

							} else {
								map.openMenu();
								map.setMenuPart(19);
							}
						} else if (map.getDownTile() == 977) {
							if (player.hasMove(11)) {
								map.openMenu();
								map.setMenuPart(35);
							} else {
								map.openMenu();
								map.setMenuPart(34);
							}
						} else if (map.getDownTile() == 978) {
							if (player.hasMove(9)) {
								map.openMenu();
								map.setMenuPart(27);
							} else {
								map.openMenu();
								map.setMenuPart(26);
							}
						} else if (map.getDownTile() == 972) {
							if (map.getShapemonCenterNumber() == 2) {
								map.setXY(108, 26);
							} else if (map.getShapemonCenterNumber() == 3) {
								map.setXY(210, 68);
							} else if (map.getShapemonCenterNumber() == 4) {
								map.setXY(115, 199);
							} else if (map.getShapemonCenterNumber() == 5) {
								map.setXY(37, 71);
							}
						} else if (isTile(map.getDownTile(), backToLandTiles)) {
							map.setSwimming(false);
							movingDown = true;
						} else if (isTile(map.getDownTile(), grassTiles)
								&& player.getNumOfShapemon() == 0) {

							map.openMenu();
							map.setMenuPart(36);

						} else if (isTile(map.getDownTile(), waterTile)) {
							if (!map.getSwimming() && player.hasMove(10)) {
								map.openMenu();
								map.setMenuPart(28);
							} else if (!isTile(map.getDownTile(), solidBlock)
									&& map.getSwimming()) {
								movingDown = true;
							}
						} else if (!isTile(map.getDownTile(), solidBlock)) {
							movingDown = true;

						}
					} else if (battle.isBattling()) {
						battle.downPressed();
					}
				} else if (rightPressed) {
					if (map.isVisible()) {
						map.shiftHeadRight();
						if (map.getRightTile() == 601) {
							if (tutorialPart == 2) {
								map.openMenu();
								map.setMenuPart(18);
								tutorialPart++;
							} else {
								map.openMenu();
								map.setMenuPart(19);
							}
						} else if (map.getRightTile() == 977) {
							if (player.hasMove(11)) {
								map.openMenu();
								map.setMenuPart(35);
							} else {
								map.openMenu();
								map.setMenuPart(34);
							}
						} else if (map.getRightTile() == 978) {
							if (player.hasMove(9)) {
								map.openMenu();
								map.setMenuPart(27);
							} else {
								map.openMenu();
								map.setMenuPart(26);
							}
						} else if (map.getRightTile() == 600) {
							if (tutorialPart == 2) {
								map.openMenu();
								map.setMenuPart(20);

							} else {
								map.openMenu();
								map.setMenuPart(19);
							}
						} else if (map.getRightTile() == 602) {
							if (tutorialPart == 3) {
								map.openMenu();
								map.setMenuPart(29);

							} else {
								map.openMenu();
								map.setMenuPart(19);
							}
						} else if (map.getRightTile() == 603) {
							if (tutorialPart == 4) {
								map.openMenu();
								map.setMenuPart(31);

							} else {
								map.openMenu();
								map.setMenuPart(19);
							}
						} else if (isTile(map.getRightTile(), grassTiles)
								&& player.getNumOfShapemon() == 0) {
							map.openMenu();
							map.setMenuPart(36);
						} else if (isTile(map.getRightTile(), backToLandTiles)) {
							map.setSwimming(false);
							movingRight = true;
						} else if (isTile(map.getRightTile(), waterTile)) {
							if (!map.getSwimming() && player.hasMove(10)) {
								map.openMenu();
								map.setMenuPart(28);
							} else if (!isTile(map.getRightTile(), solidBlock)
									&& map.getSwimming()) {
								movingRight = true;
							}
						} else if (!isTile(map.getRightTile(), solidBlock)) {
							movingRight = true;

						}
					} else if (battle.isBattling()) {
						battle.rightPressed();
					}

				}
			}
			if (movingUp) {

				map.moveUp(movingUpCounter);

				movingUpCounter++;
				if (movingUpCounter == 16) {
					movingUpCounter = 0;
					movingUp = false;
					if (map.getCenterTile() == 2) {
						if (Math.random() < 0.1) {
							battle.runBattle(player, new ShapemonSquare(3, 1, 2));
							map.setVisible(false);
							battle.setVisible(true);
							battleJustEnded = true;
						}
					} else if (map.getCenterTile() == 400) {
						if (Math.random() < 0.10) {

							battle.runBattle(player, new ShapemonTriangle(5, 2, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 402) {
						if (Math.random() < 0.10) {

							battle.runBattle(player, new ShapemonSquare(9, 2, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 403) {
						if (Math.random() < 0.10) {

							battle.runBattle(player, new ShapemonCircle(
									12 + (int) (Math.random() * 5), 4, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 404) {
						if (Math.random() < 0.10) {

							battle.runBattle(player, new ShapemonTriangle(
									20 + (int) (Math.random() * 5), 2, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 5) {
						if (Math.random() < 0.03) {

							battle.runBattle(player, new ShapemonHexagon(
									30 + (int) (Math.random() * 5), 2, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 405) {
						if (Math.random() < 0.10) {

							battle.runBattle(player, new ShapemonSquare(
									50 + (int) (Math.random() * 5), 2, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 406) {
						if (Math.random() < 0.10) {

							battle.runBattle(player, new ShapemonHexagon(
									47 + (int) (Math.random() * 5), 2, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 407) {
						if (Math.random() < 0.10) {

							battle.runBattle(player, new ShapemonCircle(
									53 + (int) (Math.random() * 5), 2, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 408) {
						if (Math.random() < 0.10) {

							battle.runBattle(player, new ShapemonOctagon(
									67 + (int) (Math.random() * 5), 2, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 409) {
						if (Math.random() < 0.10) {

							battle.runBattle(player, new ShapemonHexagon(
									74 + (int) (Math.random() * 5), 2, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 410) {
						if (Math.random() < 0.08) {

							battle.runBattle(player, new ShapemonOctagon(
									85 + (int) (Math.random() * 5), 2, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 411) {
						if (Math.random() < 0.08) {

							battle.runBattle(player, new ShapemonStar(
									85 + (int) (Math.random() * 5), 2, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 4) {
						if (Math.random() < 0.10) {

							battle.runBattle(player, new ShapemonHexagon(
									60 + (int) (Math.random() * 5), 2, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 3) {
						if (Math.random() < 0.10) {

							battle.runBattle(player, new ShapemonStar(
									60 + (int) (Math.random() * 5), 2, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 401 && tutorialPart == 3) {

						battle.runBattle(player, new ShapemonPacman(60, 8, 6));
						battlingLegendary = true;
						battleJustEnded = true;
						map.setVisible(false);
						battle.setVisible(true);

					}
				}
			} else if (movingLeft) {

				map.moveLeft(movingLeftCounter);

				movingLeftCounter++;
				if (movingLeftCounter == 16) {
					movingLeftCounter = 0;
					movingLeft = false;
					if (map.getCenterTile() == 2) {
						if (Math.random() < 0.10) {

							battleJustEnded = true;
							battle.runBattle(player, new ShapemonSquare(3, 1, 2));

							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 400) {
						if (Math.random() < 0.10) {

							battle.runBattle(player, new ShapemonTriangle(5, 2, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 402) {
						if (Math.random() < 0.10) {

							battle.runBattle(player, new ShapemonSquare(9, 2, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 403) {
						if (Math.random() < 0.10) {

							battle.runBattle(player, new ShapemonCircle(
									12 + (int) (Math.random() * 5), 4, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 404) {
						if (Math.random() < 0.10) {

							battle.runBattle(player, new ShapemonTriangle(
									20 + (int) (Math.random() * 5), 2, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 5) {
						if (Math.random() < 0.03) {

							battle.runBattle(player, new ShapemonHexagon(
									30 + (int) (Math.random() * 5), 2, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 405) {
						if (Math.random() < 0.10) {

							battle.runBattle(player, new ShapemonSquare(
									50 + (int) (Math.random() * 5), 2, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 406) {
						if (Math.random() < 0.10) {

							battle.runBattle(player, new ShapemonHexagon(
									47 + (int) (Math.random() * 5), 2, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 407) {
						if (Math.random() < 0.10) {

							battle.runBattle(player, new ShapemonCircle(
									53 + (int) (Math.random() * 5), 2, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 408) {
						if (Math.random() < 0.10) {

							battle.runBattle(player, new ShapemonOctagon(
									67 + (int) (Math.random() * 5), 2, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 409) {
						if (Math.random() < 0.10) {

							battle.runBattle(player, new ShapemonHexagon(
									74 + (int) (Math.random() * 5), 2, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 410) {
						if (Math.random() < 0.08) {

							battle.runBattle(player, new ShapemonOctagon(
									85 + (int) (Math.random() * 5), 2, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 411) {
						if (Math.random() < 0.08) {

							battle.runBattle(player, new ShapemonStar(
									85 + (int) (Math.random() * 5), 2, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 4) {
						if (Math.random() < 0.10) {

							battle.runBattle(player, new ShapemonHexagon(
									60 + (int) (Math.random() * 5), 2, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 3) {
						if (Math.random() < 0.10) {

							battle.runBattle(player, new ShapemonStar(
									60 + (int) (Math.random() * 5), 2, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 401 && tutorialPart == 3) {

						battle.runBattle(player, new ShapemonPacman(60, 8, 6));
						battlingLegendary = true;
						battleJustEnded = true;
						map.setVisible(false);
						battle.setVisible(true);

					}
				}
			} else if (movingDown) {

				map.moveDown(movingDownCounter);

				movingDownCounter++;
				if (movingDownCounter == 16) {
					movingDownCounter = 0;
					movingDown = false;
					if (map.getCenterTile() == 2) {
						if (Math.random() < 0.1) {
							battle.runBattle(player, new ShapemonSquare(3, 1, 2));
							map.setVisible(false);
							battle.setVisible(true);
							battleJustEnded = true;
						}
					} else if (map.getCenterTile() == 400) {
						if (Math.random() < 0.10) {

							battle.runBattle(player, new ShapemonTriangle(5, 2, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 402) {
						if (Math.random() < 0.10) {

							battle.runBattle(player, new ShapemonSquare(9, 2, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 403) {
						if (Math.random() < 0.10) {

							battle.runBattle(player, new ShapemonCircle(
									12 + (int) (Math.random() * 5), 4, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 404) {
						if (Math.random() < 0.10) {

							battle.runBattle(player, new ShapemonTriangle(
									20 + (int) (Math.random() * 5), 2, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 5) {
						if (Math.random() < 0.03) {

							battle.runBattle(player, new ShapemonHexagon(
									30 + (int) (Math.random() * 5), 2, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 405) {
						if (Math.random() < 0.10) {

							battle.runBattle(player, new ShapemonSquare(
									50 + (int) (Math.random() * 5), 2, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 406) {
						if (Math.random() < 0.10) {

							battle.runBattle(player, new ShapemonHexagon(
									47 + (int) (Math.random() * 5), 2, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 407) {
						if (Math.random() < 0.10) {

							battle.runBattle(player, new ShapemonCircle(
									53 + (int) (Math.random() * 5), 2, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 408) {
						if (Math.random() < 0.10) {

							battle.runBattle(player, new ShapemonOctagon(
									67 + (int) (Math.random() * 5), 2, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 409) {
						if (Math.random() < 0.10) {

							battle.runBattle(player, new ShapemonHexagon(
									74 + (int) (Math.random() * 5), 2, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 410) {
						if (Math.random() < 0.08) {

							battle.runBattle(player, new ShapemonOctagon(
									85 + (int) (Math.random() * 5), 2, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 411) {
						if (Math.random() < 0.08) {

							battle.runBattle(player, new ShapemonStar(
									85 + (int) (Math.random() * 5), 2, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 4) {
						if (Math.random() < 0.10) {

							battle.runBattle(player, new ShapemonHexagon(
									60 + (int) (Math.random() * 5), 2, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 3) {
						if (Math.random() < 0.10) {

							battle.runBattle(player, new ShapemonStar(
									60 + (int) (Math.random() * 5), 2, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 401 && tutorialPart == 3) {

						battle.runBattle(player, new ShapemonPacman(60, 8, 6));
						battlingLegendary = true;
						battleJustEnded = true;
						map.setVisible(false);
						battle.setVisible(true);

					}
				}
			} else if (movingRight) {

				map.moveRight(movingRightCounter);

				movingRightCounter++;
				if (movingRightCounter == 16) {
					movingRightCounter = 0;
					movingRight = false;
					if (map.getCenterTile() == 2) {
						if (Math.random() < 0.1) {
							battle.runBattle(player, new ShapemonSquare(3, 1, 2));
							map.setVisible(false);
							battle.setVisible(true);
							battleJustEnded = true;
						}
					} else if (map.getCenterTile() == 400) {
						if (Math.random() < 0.10) {

							battle.runBattle(player, new ShapemonTriangle(5, 2, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 402) {
						if (Math.random() < 0.10) {

							battle.runBattle(player, new ShapemonSquare(9, 2, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 403) {
						if (Math.random() < 0.10) {

							battle.runBattle(player, new ShapemonCircle(
									12 + (int) (Math.random() * 5), 4, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 404) {
						if (Math.random() < 0.10) {

							battle.runBattle(player, new ShapemonTriangle(
									20 + (int) (Math.random() * 5), 2, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 5) {
						if (Math.random() < 0.03) {

							battle.runBattle(player, new ShapemonHexagon(
									30 + (int) (Math.random() * 5), 2, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 405) {
						if (Math.random() < 0.10) {

							battle.runBattle(player, new ShapemonSquare(
									50 + (int) (Math.random() * 5), 2, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 406) {
						if (Math.random() < 0.10) {

							battle.runBattle(player, new ShapemonHexagon(
									47 + (int) (Math.random() * 5), 2, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 407) {
						if (Math.random() < 0.10) {

							battle.runBattle(player, new ShapemonCircle(
									53 + (int) (Math.random() * 5), 2, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 408) {
						if (Math.random() < 0.10) {

							battle.runBattle(player, new ShapemonOctagon(
									67 + (int) (Math.random() * 5), 2, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 409) {
						if (Math.random() < 0.10) {

							battle.runBattle(player, new ShapemonHexagon(
									74 + (int) (Math.random() * 5), 2, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 410) {
						if (Math.random() < 0.08) {

							battle.runBattle(player, new ShapemonOctagon(
									85 + (int) (Math.random() * 5), 2, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 411) {
						if (Math.random() < 0.08) {

							battle.runBattle(player, new ShapemonStar(
									85 + (int) (Math.random() * 5), 2, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 4) {
						if (Math.random() < 0.10) {

							battle.runBattle(player, new ShapemonHexagon(
									60 + (int) (Math.random() * 5), 2, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 3) {
						if (Math.random() < 0.10) {

							battle.runBattle(player, new ShapemonStar(
									60 + (int) (Math.random() * 5), 2, 3));
							battleJustEnded = true;
							map.setVisible(false);
							battle.setVisible(true);
						}
					} else if (map.getCenterTile() == 401 && tutorialPart == 3) {

						battle.runBattle(player, new ShapemonPacman(60, 8, 6));
						battlingLegendary = true;
						battleJustEnded = true;
						map.setVisible(false);
						battle.setVisible(true);

					}
				}
			} else if (map.getMenuOpen()) {
				if (menuReleased && menuPressed) {
					if (map.isVisible()) {
						if (map.menuPart == 1) {
							map.closeMenu();

						} else if (map.menuPart == 2) {
							map.setMenuPart(1);
							map.setSelected(1);
						}
					}
					menuReleased = false;
				}
				if (map.getMenuPart() >= 5 && map.getMenuPart() <= 36) {
					if (upPressed) {
						map.upPressed();

					} else if (!upPressed) {
						map.upReleased();

					}
					if (leftPressed) {
						map.leftPressed();

					} else if (!leftPressed) {
						map.leftReleased();

					}
					if (downPressed) {
						map.downPressed();

					} else if (!downPressed) {
						map.downReleased();

					}
					if (rightPressed) {
						map.rightPressed();

					} else if (!rightPressed) {
						map.rightReleased();

					}
					if (selectPressed) {
						map.enterPressed();

					} else if (!selectPressed) {

						map.enterReleased();

					}
				}
				if (upPressed && upReleased) {
					map.menuUp();
					upReleased = false;
				} else if (downPressed && downReleased) {
					map.menuDown();
					downReleased = false;
				}
				if (selectPressed && selectReleased) {

					map.select();
					selectReleased = false;

				}
			} else if (!upPressed && !rightPressed && !downPressed && !leftPressed) {
				map.standStill();
			}

		}
		if (battle.isBattling()) {
			battleJustEnded = true;
			if (!upPressed) {
				battle.upReleased();
			}
			if (!leftPressed) {
				battle.leftReleased();
			}
			if (!downPressed) {
				battle.downReleased();
			}
			if (!rightPressed) {
				battle.rightReleased();
			}
			if (selectPressed) {
				battle.selectPressed();
			} else if (!selectPressed) {
				battle.selectReleased();
			}
			if (shiftPressed) {
				battle.specialMovePressed();
			} else if (!shiftPressed) {
				battle.specialMoveReleased();
			}
			if (qPressed) {
				battle.switchMovePressed();
			} else if (!qPressed) {
				battle.switchMoveReleased();
			}

			battle.repaint();
		} else {
			map.setVisible(true);
			battle.setVisible(false);
			map.repaint();
		}

	}

	public static void setTutorialPart(int n) {
		tutorialPart = n;
	}

	public static int getTutorialPart() {
		return tutorialPart;
	}

	private boolean isTile(int n, int[] a) {
		for (int i = 0; i < a.length; i++) {
			if (n == a[i]) {
				return true;
			}
		}
		return false;
	}

}
