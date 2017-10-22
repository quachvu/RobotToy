package com.inter.main;

import com.inter.cch.pojo.Position;
import com.inter.exception.RobotToyException;

public class POPosition extends Position {
	
	int x;
	int y;
	public Position position;
	
	public POPosition(Position position){
		super(position);
		this.position = position;
	}
	
	public boolean getNewPOPosition(Position position) throws RobotToyException{
		switch(position.getDirection()){
		 case NORTH:
			 change(0,1);
			 break;
		 case EAST:
			 change(1,0);
			 break;
		 case SOUTH:
			 change(0,-1);
			 break;
		 case WEST:
			 change(-1,0);
			 
			 break;
		default:
			throw new RobotToyException("Invalid Direction!");
		}
		return true;
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

	public void change(int x, int y) throws RobotToyException{
		this.setX(position.getNextPosition().getX()+x);
		this.setY(position.getNextPosition().getY()+y);
	}
}
