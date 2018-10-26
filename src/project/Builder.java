package project;

import java.net.URL;

import javax.swing.ImageIcon;

public class Builder extends Cell{
	
	private final int VALUE = 4;
	private final URL ICON_URL = Builder.class.getResource("/builder.png");
	private ImageIcon builderIcon;
	private boolean builderOnPoint;
	
	public Builder() {
		
	}
	
	public Builder(int positionX, int positionY) {
		this.setPositionX(positionX);
		this.setPositionY(positionY);
		this.builderIcon = new ImageIcon(ICON_URL);
		this.builderOnPoint = false;
	}

	public int getValue() {
		return VALUE;
	}

	public ImageIcon getBuilderIcon() {
		return builderIcon;
	}
	
	public boolean isBuilderOnPoint() {
		return builderOnPoint;
	}

	public void setBuilderOnPoint(boolean builderOnPoint) {
		this.builderOnPoint = builderOnPoint;
	}

	/* method try to downcast to Wall object in world ArrayList on (position - 1)
	 * if it is possible then there is a wall left side from builder
	 * if exception has been caught then there is no wall left side
	 * same for other sides and other objects (points, boxes)
	 */
	public boolean isLeftWallCollision(Wall wall) {
		int positionInWorldAL = Integer.parseInt("" + this.getPositionX() + this.getPositionY());
		try {
			wall = (Wall) Socoban.world.get(positionInWorldAL - 1);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean isRightWallCollision(Wall wall) {
		int positionInWorldAL = Integer.parseInt("" + this.getPositionX() + this.getPositionY());
		try {
			wall = (Wall) Socoban.world.get(positionInWorldAL + 1);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean isUpWallCollision(Wall wall) {
		int positionInWorldAL = Integer.parseInt("" + this.getPositionX() + this.getPositionY());
		try {
			wall = (Wall) Socoban.world.get(positionInWorldAL - 10);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean isDownWallCollision(Wall wall) {
		int positionInWorldAL = Integer.parseInt("" + this.getPositionX() + this.getPositionY());
		try {
			wall = (Wall) Socoban.world.get(positionInWorldAL + 10);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean isLeftBoxCollision(BoX box) {
		int positionInWorldAL = Integer.parseInt("" + this.getPositionX() + this.getPositionY());
		try {
			box = (BoX) Socoban.world.get(positionInWorldAL - 1);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean isRightBoxCollision(BoX box) {
		int positionInWorldAL = Integer.parseInt("" + this.getPositionX() + this.getPositionY());
		try {
			box = (BoX) Socoban.world.get(positionInWorldAL + 1);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean isUpBoxCollision(BoX box) {
		int positionInWorldAL = Integer.parseInt("" + this.getPositionX() + this.getPositionY());
		try {
			box = (BoX) Socoban.world.get(positionInWorldAL - 10);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean isDownBoxCollision(BoX box) {
		int positionInWorldAL = Integer.parseInt("" + this.getPositionX() + this.getPositionY());
		try {
			box = (BoX) Socoban.world.get(positionInWorldAL + 10);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	public boolean isLeftPointCollision(Point point) {
		int positionInWorldAL = Integer.parseInt("" + this.getPositionX() + this.getPositionY());
		try {
			point = (Point) Socoban.world.get(positionInWorldAL - 1);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean isRightPointCollision(Point point) {
		int positionInWorldAL = Integer.parseInt("" + this.getPositionX() + this.getPositionY());
		try {
			point = (Point) Socoban.world.get(positionInWorldAL + 1);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean isUpPointCollision(Point point) {
		int positionInWorldAL = Integer.parseInt("" + this.getPositionX() + this.getPositionY());
		try {
			point = (Point) Socoban.world.get(positionInWorldAL - 10);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean isDownPointCollision(Point point) {
		int positionInWorldAL = Integer.parseInt("" + this.getPositionX() + this.getPositionY());
		try {
			point = (Point) Socoban.world.get(positionInWorldAL + 10);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean isLeftPointToBoxCollision(Point point) {
		int positionInWorldAL = Integer.parseInt("" + this.getPositionX() + this.getPositionY());
		try {
			point = (Point) Socoban.world.get(positionInWorldAL - 2);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean isRightPointToBoxCollision(Point point) {
		int positionInWorldAL = Integer.parseInt("" + this.getPositionX() + this.getPositionY());
		try {
			point = (Point) Socoban.world.get(positionInWorldAL + 2);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean isUpPointToBoxCollision(Point point) {
		int positionInWorldAL = Integer.parseInt("" + this.getPositionX() + this.getPositionY());
		try {
			point = (Point) Socoban.world.get(positionInWorldAL - 20);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean isDownPointToBoxCollision(Point point) {
		int positionInWorldAL = Integer.parseInt("" + this.getPositionX() + this.getPositionY());
		try {
			point = (Point) Socoban.world.get(positionInWorldAL + 20);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean isLeftGrassToBoxCollision(Grass grass) {
		int positionInWorldAL = Integer.parseInt("" + this.getPositionX() + this.getPositionY());
		try {
			grass = (Grass) Socoban.world.get(positionInWorldAL - 2);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean isRightGrassToBoxCollision(Grass grass) {
		int positionInWorldAL = Integer.parseInt("" + this.getPositionX() + this.getPositionY());
		try {
			grass = (Grass) Socoban.world.get(positionInWorldAL + 2);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean isUpGrassToBoxCollision(Grass grass) {
		int positionInWorldAL = Integer.parseInt("" + this.getPositionX() + this.getPositionY());
		try {
			grass = (Grass) Socoban.world.get(positionInWorldAL - 20);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean isDownGrassToBoxCollision(Grass grass) {
		int positionInWorldAL = Integer.parseInt("" + this.getPositionX() + this.getPositionY());
		try {
			grass = (Grass) Socoban.world.get(positionInWorldAL + 20);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public void moveLeft(Grass grass) {
		int tempY;
		int positionInWorldAL = Integer.parseInt("" + this.getPositionX() + this.getPositionY());
		grass = (Grass) Socoban.world.get(positionInWorldAL - 1);
		tempY = grass.getPositionY();
		grass.setPositionY(this.getPositionY());
		this.setPositionY(tempY);
		Socoban.world.add(positionInWorldAL - 1, this);
		Socoban.world.remove(positionInWorldAL + 1);
		if(builderOnPoint) {
			Socoban.world.add(positionInWorldAL, new Point(grass.getPositionX(), grass.getPositionY()));
			Socoban.world.remove(positionInWorldAL + 1);
			builderOnPoint = false;
		}
	}
	
	public void moveRight(Grass grass) {
		int tempY;
		int positionInWorldAL = Integer.parseInt("" + this.getPositionX() + this.getPositionY());
		grass = (Grass) Socoban.world.get(positionInWorldAL + 1);
		tempY = grass.getPositionY();
		grass.setPositionY(this.getPositionY());
		this.setPositionY(tempY);
		Socoban.world.remove(positionInWorldAL + 1);
		Socoban.world.add(positionInWorldAL, grass);
		if(builderOnPoint) {
			Socoban.world.add(positionInWorldAL, new Point(grass.getPositionX(), grass.getPositionY()));
			Socoban.world.remove(positionInWorldAL + 1);
			builderOnPoint = false;
		}
	}
	
	public void moveUp(Grass grass) {
		int tempX;
		int positionInWorldAL = Integer.parseInt("" + this.getPositionX() + this.getPositionY());
		grass = (Grass) Socoban.world.get(positionInWorldAL - 10);
		tempX = grass.getPositionX();
		grass.setPositionX(this.getPositionX());
		this.setPositionX(tempX);
		Socoban.world.remove(positionInWorldAL);
		Socoban.world.add(positionInWorldAL, grass);
		Socoban.world.remove(positionInWorldAL - 10);
		Socoban.world.add(positionInWorldAL - 10, this);
		if(builderOnPoint) {
			Socoban.world.add(positionInWorldAL, new Point(grass.getPositionX(), grass.getPositionY()));
			Socoban.world.remove(positionInWorldAL + 1);
			builderOnPoint = false;
		}
	}
	
	public void moveDown(Grass grass) {
		int tempX;
		int positionInWorldAL = Integer.parseInt("" + this.getPositionX() + this.getPositionY());
		grass = (Grass) Socoban.world.get(positionInWorldAL + 10);
		tempX = grass.getPositionX();
		grass.setPositionX(this.getPositionX());
		this.setPositionX(tempX);
		Socoban.world.remove(positionInWorldAL);
		Socoban.world.add(positionInWorldAL, grass);
		Socoban.world.remove(positionInWorldAL + 10);
		Socoban.world.add(positionInWorldAL + 10, this);
		if(builderOnPoint) {
			Socoban.world.add(positionInWorldAL, new Point(grass.getPositionX(), grass.getPositionY()));
			Socoban.world.remove(positionInWorldAL + 1);
			builderOnPoint = false;
		}
	}
	
	public void pushBoxLeft(BoX box, Grass grass) {
		int tempY;
		int positionInWorldAL = Integer.parseInt("" + this.getPositionX() + this.getPositionY());
		box = (BoX) Socoban.world.get(positionInWorldAL - 1);
		grass = (Grass) Socoban.world.get(positionInWorldAL - 2);
		tempY = grass.getPositionY();
		grass.setPositionY(box.getPositionY());
		box.setPositionY(tempY);
		tempY = grass.getPositionY();
		grass.setPositionY(this.getPositionY());
		this.setPositionY(tempY);
		Socoban.world.remove(positionInWorldAL - 2);
		Socoban.world.add(positionInWorldAL, grass);
		if(builderOnPoint) {
			Socoban.world.remove(positionInWorldAL);
			Socoban.world.add(positionInWorldAL, new Point(this.getPositionX(), this.getPositionY() + 1));
			builderOnPoint = false;
		}
		if(box.isBoxOnPoint()) {
			builderOnPoint = true;
			box.setBoxOnPoint(false);
			Socoban.boxOnPointAmount--;
		}
	}
	
	public void pushBoxRight(BoX box, Grass grass) {
		int tempY;
		int positionInWorldAL = Integer.parseInt("" + this.getPositionX() + this.getPositionY());
		box = (BoX) Socoban.world.get(positionInWorldAL + 1);
		grass = (Grass) Socoban.world.get(positionInWorldAL + 2);
		tempY = grass.getPositionY();
		grass.setPositionY(box.getPositionY());
		box.setPositionY(tempY);
		tempY = grass.getPositionY();
		grass.setPositionY(this.getPositionY());
		this.setPositionY(tempY);
		Socoban.world.remove(positionInWorldAL + 2);
		Socoban.world.add(positionInWorldAL, grass);
		if(builderOnPoint) {
			Socoban.world.remove(positionInWorldAL);
			Socoban.world.add(positionInWorldAL, new Point(this.getPositionX(), this.getPositionY() - 1));
			builderOnPoint = false;
		}
		if(box.isBoxOnPoint()) {
			builderOnPoint = true;
			box.setBoxOnPoint(false);
			Socoban.boxOnPointAmount--;
		}
		
	}
	
	public void pushBoxUp(BoX box, Grass grass) {
		int tempX;
		int positionInWorldAL = Integer.parseInt("" + this.getPositionX() + this.getPositionY());
		box = (BoX) Socoban.world.get(positionInWorldAL - 10);
		grass = (Grass) Socoban.world.get(positionInWorldAL - 20);
		tempX = grass.getPositionX();
		grass.setPositionX(box.getPositionX());
		box.setPositionX(tempX);
		tempX = grass.getPositionX();
		grass.setPositionX(this.getPositionX());
		this.setPositionX(tempX);
		Socoban.world.remove(positionInWorldAL - 20);
		Socoban.world.add(positionInWorldAL - 20, box);
		Socoban.world.remove(positionInWorldAL - 10);
		Socoban.world.add(positionInWorldAL - 10, this);
		Socoban.world.remove(positionInWorldAL);
		Socoban.world.add(positionInWorldAL, grass);
		if(builderOnPoint) {
			Socoban.world.remove(positionInWorldAL);
			Socoban.world.add(positionInWorldAL, new Point(this.getPositionX() + 1, this.getPositionY()));
			builderOnPoint = false;
		}
		if(box.isBoxOnPoint()) {
			builderOnPoint = true;
			box.setBoxOnPoint(false);
			Socoban.boxOnPointAmount--;
		}
	}
	
	public void pushBoxDown(BoX box, Grass grass) {
		int tempX;
		int positionInWorldAL = Integer.parseInt("" + this.getPositionX() + this.getPositionY());
		box = (BoX) Socoban.world.get(positionInWorldAL + 10);
		grass = (Grass) Socoban.world.get(positionInWorldAL + 20);
		tempX = grass.getPositionX();
		grass.setPositionX(box.getPositionX());
		box.setPositionX(tempX);
		tempX = grass.getPositionX();
		grass.setPositionX(this.getPositionX());
		this.setPositionX(tempX);
		Socoban.world.remove(positionInWorldAL + 20);
		Socoban.world.add(positionInWorldAL + 20, box);
		Socoban.world.remove(positionInWorldAL + 10);
		Socoban.world.add(positionInWorldAL + 10, this);
		Socoban.world.remove(positionInWorldAL);
		Socoban.world.add(positionInWorldAL, grass);
		if(builderOnPoint) {
			Socoban.world.remove(positionInWorldAL);
			Socoban.world.add(positionInWorldAL, new Point(this.getPositionX() - 1, this.getPositionY()));
			builderOnPoint = false;
		}
		if(box.isBoxOnPoint()) {
			builderOnPoint = true;
			box.setBoxOnPoint(false);
			Socoban.boxOnPointAmount--;
		}
	}

	public void pushBoxLeftOnPoint(BoX box, Point point) {
		int positionInWorldAL = Integer.parseInt("" + this.getPositionX() + this.getPositionY());
		box = (BoX) Socoban.world.get(positionInWorldAL - 1);
		point = (Point) Socoban.world.get(positionInWorldAL - 2);
		this.setPositionY(box.getPositionY());
		box.setPositionY(point.getPositionY());
		Socoban.world.remove(positionInWorldAL - 2);
		Socoban.world.add(positionInWorldAL, new Grass(this.getPositionX(), this.getPositionY() + 1));
		box.setBoxOnPoint(true);
		Socoban.boxOnPointAmount++;
	}
	
	public void pushBoxRightOnPoint(BoX box, Point point) {
		int positionInWorldAL = Integer.parseInt("" + this.getPositionX() + this.getPositionY());
		box = (BoX) Socoban.world.get(positionInWorldAL + 1);
		point = (Point) Socoban.world.get(positionInWorldAL + 2);
		this.setPositionY(box.getPositionY());
		box.setPositionY(point.getPositionY());
		Socoban.world.remove(positionInWorldAL + 2);
		Socoban.world.add(positionInWorldAL, new Grass(this.getPositionX(), this.getPositionY() - 1));
		box.setBoxOnPoint(true);
		Socoban.boxOnPointAmount++;
	}
	
	public void pushBoxUpOnPoint(BoX box, Point point) {
		int positionInWorldAL = Integer.parseInt("" + this.getPositionX() + this.getPositionY());
		box = (BoX) Socoban.world.get(positionInWorldAL - 10);
		point = (Point) Socoban.world.get(positionInWorldAL - 20);
		this.setPositionX(box.getPositionX());
		box.setPositionX(point.getPositionX());
		Socoban.world.remove(positionInWorldAL - 20);
		Socoban.world.add(positionInWorldAL - 20, box);
		Socoban.world.remove(positionInWorldAL - 10);
		Socoban.world.add(positionInWorldAL - 10, this);
		Socoban.world.remove(positionInWorldAL);
		Socoban.world.add(positionInWorldAL, new Grass(this.getPositionX() + 1, this.getPositionY()));
		box.setBoxOnPoint(true);
		Socoban.boxOnPointAmount++;
	}
	
	public void pushBoxDownOnPoint(BoX box, Point point) {
		int positionInWorldAL = Integer.parseInt("" + this.getPositionX() + this.getPositionY());
		box = (BoX) Socoban.world.get(positionInWorldAL + 10);
		point = (Point) Socoban.world.get(positionInWorldAL + 20);
		this.setPositionX(box.getPositionX());
		box.setPositionX(point.getPositionX());
		Socoban.world.remove(positionInWorldAL + 20);
		Socoban.world.add(positionInWorldAL + 20, box);
		Socoban.world.remove(positionInWorldAL + 10);
		Socoban.world.add(positionInWorldAL + 10, this);
		Socoban.world.remove(positionInWorldAL);
		Socoban.world.add(positionInWorldAL, new Grass(this.getPositionX() - 1, this.getPositionY()));
		box.setBoxOnPoint(true);
		Socoban.boxOnPointAmount++;
	}
	
	public void moveLeftOnPoint(Point point) {
		int positionInWorldAL = Integer.parseInt("" + this.getPositionX() + this.getPositionY());
		point = (Point) Socoban.world.get(positionInWorldAL - 1);
		this.setPositionY(point.getPositionY());
		Socoban.world.remove(positionInWorldAL - 1);
		Socoban.world.add(positionInWorldAL, new Grass(this.getPositionX(), this.getPositionY() + 1));
		if(builderOnPoint) {
			Socoban.world.add(positionInWorldAL, new Point(this.getPositionX(), this.getPositionY() + 1));
			Socoban.world.remove(positionInWorldAL + 1);
		}
		builderOnPoint = true;
	}
	
	public void moveRightOnPoint(Point point) {
		int positionInWorldAL = Integer.parseInt("" + this.getPositionX() + this.getPositionY());
		point = (Point) Socoban.world.get(positionInWorldAL + 1);
		this.setPositionY(point.getPositionY());
		Socoban.world.remove(positionInWorldAL + 1);
		Socoban.world.add(positionInWorldAL, new Grass(this.getPositionX(), this.getPositionY() - 1));
		if(builderOnPoint) {
			Socoban.world.add(positionInWorldAL, new Point(this.getPositionX(), this.getPositionY() - 1));
			Socoban.world.remove(positionInWorldAL + 1);
		}
		builderOnPoint = true;
	}
	
	public void moveUpOnPoint(Point point) {
		int positionInWorldAL = Integer.parseInt("" + this.getPositionX() + this.getPositionY());
		point = (Point) Socoban.world.get(positionInWorldAL - 10);
		this.setPositionX(point.getPositionX());
		Socoban.world.remove(positionInWorldAL - 10);
		Socoban.world.add(positionInWorldAL - 10, this);
		Socoban.world.remove(positionInWorldAL);
		Socoban.world.add(positionInWorldAL, new Grass(this.getPositionX() + 1, this.getPositionY()));
		if(builderOnPoint) {
			Socoban.world.add(positionInWorldAL, new Point(this.getPositionX() + 1, this.getPositionY()));
			Socoban.world.remove(positionInWorldAL + 1);
		}
		builderOnPoint = true;
	}
	
	public void moveDownOnPoint(Point point) {
		int positionInWorldAL = Integer.parseInt("" + this.getPositionX() + this.getPositionY());
		point = (Point) Socoban.world.get(positionInWorldAL + 10);
		this.setPositionX(point.getPositionX());
		Socoban.world.remove(positionInWorldAL + 10);
		Socoban.world.add(positionInWorldAL + 10, this);
		Socoban.world.remove(positionInWorldAL);
		Socoban.world.add(positionInWorldAL, new Grass(this.getPositionX() - 1, this.getPositionY()));
		if(builderOnPoint) {
			Socoban.world.add(positionInWorldAL, new Point(this.getPositionX() - 1, this.getPositionY()));
			Socoban.world.remove(positionInWorldAL + 1);
		}
		builderOnPoint = true;
	}
	
}
