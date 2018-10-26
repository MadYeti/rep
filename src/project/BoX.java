package project;

import java.net.URL;

import javax.swing.ImageIcon;

public class BoX extends Cell{
	
	private final int VALUE = 2;
	private final URL ICON_URL = BoX.class.getResource("/box.png");
	private ImageIcon boxIcon; 
	private boolean boxOnPoint;
	
	public BoX() {
		
	}
	
	public BoX(int positionX, int positionY) {
		this.setPositionX(positionX);
		this.setPositionY(positionY);
		this.boxIcon = new ImageIcon(ICON_URL);
		this.boxOnPoint = false;
	}

	public int getValue() {
		return VALUE;
	}

	public ImageIcon getBoxIcon() {
		return boxIcon;
	}

	public boolean isBoxOnPoint() {
		return boxOnPoint;
	}

	public void setBoxOnPoint(boolean boxOnPoint) {
		this.boxOnPoint = boxOnPoint;
	}

}
