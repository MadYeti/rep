package project;

import java.net.URL;

import javax.swing.ImageIcon;

public class Grass extends Cell{
	
	private final int VALUE = 0;
	private final URL ICON_URL = Grass.class.getResource("/grass.png");
	private ImageIcon grassIcon;
	
	public Grass() {
		
	}
	
	public Grass(int positionX, int positionY) {
		this.setPositionX(positionX);
		this.setPositionY(positionY);
		this.grassIcon = new ImageIcon(ICON_URL);
	}
	
	public int getValue() {
		return VALUE;
	}

	public ImageIcon getGrassIcon() {
		return grassIcon;
	}

}
