/**
 * 
 */
package com.inter.cch.pojo;

import com.inter.exception.RobotToyException;

/**
 * @author vu
 *
 */
public class Position {
	int x,y;
	public Direction direction;
	public Position(int x, int y, Direction direction){
		this.x = x;
		this.y = y;
		this.direction = direction;
	}
	public Position(Position position) {
		// TODO Auto-generated constructor stub
		this.x = position.getX();
		this.y = position.getY();
		this.direction = position.getDirection();
	}
	public Position getNextPosition() throws RobotToyException {
		// TODO Auto-generated method stub
		if(this.direction == null){
			throw new RobotToyException("Invalid Robot Direction");
		}
		Position newPosition = new Position(this);
		switch(this.direction){
			case NORTH:
				newPosition.change(0,1);
				break;
			case WEST:
				newPosition.change(-1,0);
				break;
			case SOUTH:
				newPosition.change(0,-1);
				break;
			case EAST:
				newPosition.change(1,0);
				break;
		}
		return newPosition;
	}
	private void change(int i, int j) {
		// TODO Auto-generated method stub
		this.x +=i;
		this.y +=j;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Direction getDirection() {
		return direction;
	}
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
}
