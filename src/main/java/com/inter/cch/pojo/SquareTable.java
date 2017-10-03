package com.inter.cch.pojo;

public class SquareTable{
	int x;
	int y;
	public SquareTable(int x, int y){
		this.x = x;
		this.y = y;
	}
	public boolean isPositionValid(Position position){
		if(position.getX() > this.y || position.getX()<0 || position.getY() > this.x || position.getY()<0){
			return false;
		}
		return true;
		
	}
}
