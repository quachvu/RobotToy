/**
 * 
 */
package com.inter.main;

import com.inter.cch.pojo.Position;
import com.inter.exception.RobotToyException;

/**
 * @author vu
 *
 */
public class RobotToy {
	private Position position;
	
	public RobotToy(){
		
	}
	public RobotToy(Position position){
		this.position = position;
	}
	public boolean setPosition(Position position){
//		this.setPosition(position);
		this.position = position;
		return true;
	}
	public Position getPosition(){
		return this.position; 
	}
	public boolean move(Position newPosition) {
		// TODO Auto-generated method stub
		this.position = newPosition;
		return true;
	}
	public boolean move() throws RobotToyException{
		return move(position.getNextPosition()); 
	}
	public boolean rotateLeft() {
		// TODO Auto-generated method stub
		this.position.direction = this.position.direction.rotateLeft(); 
		return true;
	}
	public boolean rotateRight() {
		// TODO Auto-generated method stub
		this.position.direction = this.position.direction.rotateRight(); 
		return true;
	}
}
