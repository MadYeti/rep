package project;

import java.net.URL;

import javax.swing.ImageIcon;

public class Point extends Cell{
	
	private final int VALUE = 3;
	private final URL ICON_URL = Point.class.getResource("/point.png");
	private ImageIcon pointIcon;
	
	public Point() {
		
	}
	
	public Point(int positionX, int positionY) {
		this.setPositionX(positionX);
		this.setPositionY(positionY);
		this.pointIcon = new ImageIcon(ICON_URL);
	}

	public int getValue() {
		return VALUE;
	}

	public ImageIcon getPointIcon() {
		return pointIcon;
	}

}
