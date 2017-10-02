/**
 * 
 */
package com.inter.cch.pojo;

import java.util.HashMap;
import java.util.Map;



/**
 * @author vu
 *
 */
public enum Direction {
	NORTH(0),SOUTH(1),WEST(2),EAST(3);
	private static Map<Integer, Direction> map = new HashMap<Integer, Direction>();
	int direction;
	static {
		for (Direction directionEnum : Direction.values()) {
			map.put(directionEnum.direction, directionEnum);
		}
	}
	private Direction(int direction){
		this.direction = direction;
	}
	public static Direction valueOf(int directionNum) {
        return map.get(directionNum);
    }
	public Direction rotateLeft() {
		// TODO Auto-generated method stub
		return rotate(-1);
	}
	private Direction rotate(int i) {
		int num =0;
		// TODO Auto-generated method stub
		if(this.direction+i<0){
			num = 3;
		}else{
			num = (this.direction+i)%4;
		} 
		return Direction.valueOf(num);
	}
	public Direction rotateRight(){
		return rotate(1);
	}
}
