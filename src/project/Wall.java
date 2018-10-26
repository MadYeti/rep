package project;

import java.net.URL;

import javax.swing.ImageIcon;

public class Wall extends Cell{
	
	private final int VALUE = 1;
	private final URL ICON_URL = Wall.class.getResource("/wall.png");
	private ImageIcon wallIcon;
	
	public Wall(){
		
	}
	
	public Wall(int positionX, int positionY) {
		this.setPositionX(positionX);
		this.setPositionY(positionY);
		this.wallIcon = new ImageIcon(ICON_URL);
	}
	
	public int getValue() {
		return VALUE;
	}

	public ImageIcon getWallIcon() {
		return wallIcon;
	}

}
