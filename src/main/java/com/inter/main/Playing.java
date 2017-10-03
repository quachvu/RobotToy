/**
 * 
 */
package com.inter.main;

import com.inter.cch.pojo.Commands;
import com.inter.cch.pojo.Direction;
import com.inter.cch.pojo.Position;
import com.inter.cch.pojo.SquareTable;
import com.inter.exception.RobotToyException;

/**
 * @author vu
 *
 */
public class Playing {
	RobotToy robot;
	SquareTable squareTable;
	
	public Playing(RobotToy robot, SquareTable squareTable){
		this.robot = robot;
		this.squareTable = squareTable;
	}
	
	public boolean initRobot(Position position) throws RobotToyException{
		if(position == null){
			throw new RobotToyException("Position has not been initialed!");
		}
		if(robot == null){
			throw new RobotToyException("Robot has not been initialized!");
		}
		if(squareTable == null){
			throw new RobotToyException("SquareTable has not been initialized!");
		}
		if(position.getDirection()==null){
			throw new RobotToyException("Direction has not been set!");
		}
		if(!squareTable.isPositionValid(position)){
			throw new RobotToyException("Robot is placed at wrong position!");
		}
		
		// TODO Auto-generated method stub
		robot.setPosition(position);
		return true;
	}
	
	public String evaluation(String inputS) throws RobotToyException{
		String[] inputCommand = inputS.split(" ");
		System.out.println("inputCommand[1] = " + inputCommand[1]);
		Commands command = Commands.valueOf(inputCommand[0]);
		String inputParams[];
		int x=0;
		int y=0;
		Direction direction = null;
		if(command == Commands.PLACE){
			inputParams = inputCommand[1].split(",");
			x = Integer.parseInt(inputParams[0]);
			y = Integer.parseInt(inputParams[1]);
			direction = Direction.valueOf(inputParams[2]);
		}
		
		String output="";
		switch(command){
			case PLACE: 
				boolean initRobot = initRobot(new Position(x,y,direction));
				output = String.valueOf(initRobot);
				break;
			case MOVE:
				Position newPosition = robot.getPosition().getNextPosition();
				output = String.valueOf(robot.move(newPosition));
				break;
			case LEFT:
				output = String.valueOf(robot.rotateLeft());
				break;
			case RIGHT:
				output = String.valueOf(robot.rotateLeft());
				break;
				
			case REPORT:
				output = report();
				break;
			default:
				System.out.println("command is invvalid! Please try again with correct format!");
		}
		return output;
	}
	
	public String report() {
		// TODO Auto-generated method stub
		return robot.getPosition().getX() + "," + robot.getPosition().getY() + "," + robot.getPosition().getDirection().toString();
	}
}
