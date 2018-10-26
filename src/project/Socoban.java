package project;


import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class Socoban extends JFrame{
	
	private DBConnect db;
	private LevelController lc;
	private String[] data;
	private int[][] map;
	private int[][] restartMap = new int[10][10];
	private int boxAmount;
	protected static int boxOnPointAmount = 0;
	private Wall wall;
	private BoX box;
	private Grass grass;
	private Builder builder;
	private Point point;
	private int level = 1;
	private JPanel gamePanel;
	protected static ArrayList<Cell> world = new ArrayList<Cell>();
	private JLabel grassLabel;
	private JLabel wallLabel;
	private JLabel boxLabel;
	private JLabel pointLabel;
	private JLabel builderLabel;
	private Container parent;
	private static int steps = 0;
	private JPanel panel;
	private final URL LOGO_URL = Socoban.class.getResource("/logo.png");

	private static final long serialVersionUID = 1L;
	
	public Socoban() {
		
		// creating frame and panel
		JFrame frame = new JFrame("Socoban");
		panel = new JPanel();
		frame.setSize(700, 700);
		
		// creating layout for button sequencing; border
		BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.PAGE_AXIS);
		panel.setLayout(boxLayout);
		
		// creating and adding buttons to panel; set the alignment of buttons; set the size of buttons;
		// set spaces between the buttons; adding panel to frame
		//JLabel logoLabel = new JLabel("LOGO IMAGE");
		JButton newGameButton = new JButton("New Game");
		JButton recordsTableButton = new JButton("Records Table");
		JButton exitButton = new JButton("Exit");
		ImageIcon icon = new ImageIcon(LOGO_URL);
		Image logoImage = icon.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
		ImageIcon logoIcon = new ImageIcon(logoImage);
		JLabel logoLabel = new JLabel(logoIcon);
		logoLabel.setAlignmentX(CENTER_ALIGNMENT);
		logoLabel.setAlignmentY(TOP_ALIGNMENT);
		newGameButton.setAlignmentX(CENTER_ALIGNMENT);
		recordsTableButton.setAlignmentX(CENTER_ALIGNMENT);
		exitButton.setAlignmentX(CENTER_ALIGNMENT);
		newGameButton.add(Box.createRigidArea(new Dimension(100,20)));
		recordsTableButton.add(Box.createRigidArea(new Dimension(100,20)));
		exitButton.add(Box.createRigidArea(new Dimension(100,20)));
		panel.add(logoLabel);
		panel.add(Box.createRigidArea(new Dimension(100,20)));
		panel.add(newGameButton);
		panel.add(Box.createRigidArea(new Dimension(100,20)));
		panel.add(recordsTableButton);
		panel.add(Box.createRigidArea(new Dimension(100,20)));
		panel.add(exitButton);
		frame.add(panel);
		
		// download results from the DB 
		db = new DBConnect();
		db.getDataBaseConnection();
		
		//frame settings
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setFocusable(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//exit button (close the app)
		exitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				db.freeDBResources();
				frame.dispose();
			}
		});
		
		/* records table button (show the best 10 scores)
		 * sets visibility of the panel to false;
		 * create new panel (resultPanel) with new Layout (GridLayout) and button "Back"
		 */
		recordsTableButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				panel.setVisible(false);
				JPanel resultPanel = new JPanel();
				JButton backButton = new JButton("Back");
				GridLayout gridLayout = new GridLayout(10, 4);
				resultPanel.setLayout(gridLayout);
				for(int i = 0; i < 10; i++) {
					for(int j = 0; j < 4; j++) {
						if(i == 9 && j == 3) {
							resultPanel.add(backButton);
						}else {
							if(j == 0) {
								data = db.getDataFromDB("Position");
							}else if(j == 1){
								data = db.getDataFromDB("Nickname");
							}else if (j == 2) {
								data = db.getDataFromDB("Score");
							}else {
								data[i] = "";
							}
							JLabel label = new JLabel(data[i], SwingConstants.CENTER);
							if(j != 3) {
								label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
							}
							resultPanel.add(label);
						}
					}
					
				}
				resultPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				frame.add(resultPanel);
				
				/* actionListener on backButton that sets visibility of resultPanel to false
				 * and sets visibility of panel to true
				 */
				
				backButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						resultPanel.setVisible(false);
						panel.setVisible(true);
						
					}
				});
				
				
			}
		});
		
		/* new game button (starts the game)
		 * create new panel with new layout (gridLeyout(10, 10))
		 * get map from LevelController class and paint it
		 */
		newGameButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				panel.setVisible(false);
				gamePanel = new JPanel();
				GridLayout gameLayout = new GridLayout(10, 10);
				gamePanel.setLayout(gameLayout);
				lc = new LevelController();
				lc.getFileConnection();
				map = lc.getLevelMap(level);
				restartMap = lc.getRestartMap(map);
				initializeMap(map);
				paintMap();
				frame.add(gamePanel);
				parent = gamePanel.getParent();
				
				/*
				 * adding keyListener to frame
				 */
				frame.addKeyListener(new KeyListener() {
					
					@Override
					public void keyTyped(KeyEvent e) {
						
					}
					
					@Override
					public void keyReleased(KeyEvent e) {
						
					}
					
					@Override
					public void keyPressed(KeyEvent e) {
						int key = e.getKeyCode();
						
						if(key == KeyEvent.VK_LEFT) {
							if(builder.isLeftWallCollision(wall)) {
								
							}else if(builder.isLeftBoxCollision(box)) {
								if(builder.isLeftPointToBoxCollision(point)) {
									builder.pushBoxLeftOnPoint(box, point);
								}else if(builder.isLeftGrassToBoxCollision(grass)){
									builder.pushBoxLeft(box, grass);
								}
							}else if(builder.isLeftPointCollision(point)) {
								builder.moveLeftOnPoint(point);
							}else {
								builder.moveLeft(grass);
							}
						}else if(key == KeyEvent.VK_RIGHT) {
							if(builder.isRightWallCollision(wall)) {
								
							}else if(builder.isRightBoxCollision(box)) {
								if(builder.isRightPointToBoxCollision(point)) {
									builder.pushBoxRightOnPoint(box, point);
								}else if(builder.isRightGrassToBoxCollision(grass)) {
									builder.pushBoxRight(box, grass);
								}
							}else if(builder.isRightPointCollision(point)) {
								builder.moveRightOnPoint(point);
							}else {
								builder.moveRight(grass);
							}
						}else if(key == KeyEvent.VK_UP) {
							if(builder.isUpWallCollision(wall)) {
								
							}else if(builder.isUpBoxCollision(box)) {
								if(builder.isUpPointToBoxCollision(point)) {
									builder.pushBoxUpOnPoint(box, point);
								}else if(builder.isUpGrassToBoxCollision(grass)){
									builder.pushBoxUp(box, grass);
								}
							}else if(builder.isUpPointCollision(point)) {
								builder.moveUpOnPoint(point);
							}else {
								builder.moveUp(grass);
							}
						}else if(key == KeyEvent.VK_DOWN) {
							if(builder.isDownWallCollision(wall)) {
								
							}else if(builder.isDownBoxCollision(box)) {
								if(builder.isDownPointToBoxCollision(point)) {
									builder.pushBoxDownOnPoint(box, point);
								}else if(builder.isDownGrassToBoxCollision(grass)){
									builder.pushBoxDown(box, grass);
								}
							}else if(builder.isDownPointCollision(point)) {
								builder.moveDownOnPoint(point);
							}else {
								builder.moveDown(grass);
							}
						}else if(key == KeyEvent.VK_R) {
							world.removeAll(world);
							boxAmount = 0;
							boxOnPointAmount = 0;
							initializeMap(restartMap);
							removeIcons();
							repaintIcons();
							parent.validate();
							parent.repaint();
						}
						steps++;
						repaintIcons();
						parent.validate();
						parent.repaint();
						if(boxAmount == boxOnPointAmount) {
							if(level == 3) {
								frame.removeKeyListener(this);
								gameComplete();
							}else {
								levelComplete();
							}
						}
					}
				});
			}
		});
		
	}
	
	// method to initialize map
	public void initializeMap(int[][] map) {
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if(map[i][j] == 0) {
					grass = new Grass(i, j);
					world.add(grass);
				}else if(map[i][j] == 1) {
					wall = new Wall(i, j);
					world.add(wall);
				}else if(map[i][j] == 2) {
					box = new BoX(i, j);
					world.add(box);
					boxAmount++;
				}else if(map[i][j] == 3) {
					point = new Point(i, j);
					world.add(point);
				}else if(map[i][j] == 4) {
					builder = new Builder(i, j);
					world.add(builder);
				}
			}
		}
	}
	
	// method to paint map
	public void paintMap() {
		for(int i = 0; i < world.size(); i++) {
			Cell cell = world.get(i);
			if(cell instanceof Grass) {
				grassLabel = new JLabel(grass.getGrassIcon());
				gamePanel.add(grassLabel);
			}else if(cell instanceof Wall) {
				wallLabel = new JLabel(wall.getWallIcon());
				gamePanel.add(wallLabel);
			}else if(cell instanceof BoX) {
				boxLabel = new JLabel(box.getBoxIcon());
				gamePanel.add(boxLabel);
			}else if(cell instanceof Point) {
				pointLabel = new JLabel(point.getPointIcon());
				gamePanel.add(pointLabel);
			}else if(cell instanceof Builder) {
				builderLabel = new JLabel(builder.getBuilderIcon());
				gamePanel.add(builderLabel);
			}
		}
	}
	
	// method repaint labels icons according to the objects sequences
	public void repaintIcons() {
		for(int i = 0; i < world.size(); i++) {
			Cell cell = world.get(i);
			if(cell instanceof Grass) {
				grassLabel = (JLabel) gamePanel.getComponent(i);
				grassLabel.setIcon(null);
				grassLabel.setIcon(grass.getGrassIcon());
			}else if(cell instanceof Wall) {
				wallLabel = (JLabel) gamePanel.getComponent(i);
				wallLabel.setIcon(null);
				wallLabel.setIcon(wall.getWallIcon());
			}else if(cell instanceof BoX) {
				boxLabel = (JLabel) gamePanel.getComponent(i);
				boxLabel.setIcon(null);
				boxLabel.setIcon(box.getBoxIcon());
			}else if(cell instanceof Point) {
				pointLabel = (JLabel) gamePanel.getComponent(i);
				pointLabel.setIcon(null);
				pointLabel.setIcon(point.getPointIcon());
			}else if(cell instanceof Builder) {
				builderLabel = (JLabel) gamePanel.getComponent(i);
				builderLabel.setIcon(null);
				builderLabel.setIcon(builder.getBuilderIcon());
			}
		}
	}

	public void removeIcons() {
		for(int i = 0; i < world.size(); i++) {
			Cell cell = world.get(i);
			if(cell instanceof Grass) {
				grassLabel = (JLabel) gamePanel.getComponent(i);
				grassLabel.setIcon(null);
			}else if(cell instanceof Wall) {
				wallLabel = (JLabel) gamePanel.getComponent(i);
				wallLabel.setIcon(null);
			}else if(cell instanceof BoX) {
				boxLabel = (JLabel) gamePanel.getComponent(i);
				boxLabel.setIcon(null);
			}else if(cell instanceof Point) {
				pointLabel = (JLabel) gamePanel.getComponent(i);
				pointLabel.setIcon(null);
			}else if(cell instanceof Builder) {
				builderLabel = (JLabel) gamePanel.getComponent(i);
				builderLabel.setIcon(null);
			}
		}
	}
	
	public void levelComplete() {
		
		JFrame levelCompleteFrame = new JFrame();
		JPanel levelCompletePanel = new JPanel();
		JLabel levelCompleteLabel = new JLabel();
		JButton nextLevelButton = new JButton("Next level");
		levelCompleteLabel.setText("Level " + level + " complete!");
		levelCompletePanel.add(levelCompleteLabel);
		levelCompletePanel.add(nextLevelButton);
		levelCompleteFrame.add(levelCompletePanel);
		levelCompleteFrame.setSize(200, 120);
		levelCompleteFrame.setVisible(true);
		levelCompleteFrame.setResizable(false);
		levelCompleteFrame.setFocusable(true);
		levelCompleteFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		level++;
		
		nextLevelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				levelCompleteFrame.setVisible(false);
				world.removeAll(world);
				map = lc.getLevelMap(level);
				initializeMap(map);
				removeIcons();
				repaintIcons();
				parent.validate();
				parent.repaint();
			}
		});
		
	}

	public void gameComplete() {
		JFrame gameCompleteFrame = new JFrame();
		JPanel gameCompletePanel = new JPanel();
		JLabel gameCompleteLabel = new JLabel();
		JTextField nicknameTextField = new JTextField(20);
		JButton sendButton = new JButton("OK");
		gameCompleteLabel.setText("Game has been completed! Congradulations!");
		nicknameTextField.setText("Nickname");
		gameCompletePanel.add(gameCompleteLabel);
		gameCompletePanel.add(nicknameTextField);
		gameCompletePanel.add(sendButton);
		gameCompleteFrame.add(gameCompletePanel);
		gameCompleteFrame.setSize(290, 120);
		gameCompleteFrame.setVisible(true);
		gameCompleteFrame.setResizable(false);
		gameCompleteFrame.setFocusable(true);
		gameCompleteFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		sendButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nickname = nicknameTextField.getText();
				db.addResultToDB(steps, nickname);
				gameCompleteFrame.setVisible(false);
				gamePanel.setVisible(false);
				world.removeAll(world);
				level = 1;
				panel.setVisible(true);
				
			}
		});
		
	}
	
}
