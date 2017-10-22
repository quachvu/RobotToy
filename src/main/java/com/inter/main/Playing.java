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
	PlaceObject placeObject;
	POPosition poPosition;
	
	public Playing(PlaceObject placeObject, RobotToy robot, SquareTable squareTable){
		this.robot = robot;
		this.squareTable = squareTable;
		this.placeObject = placeObject;
	}
	
	//constructor for PLACE_OBJECT
	public boolean initObject(POPosition poPosition) throws RobotToyException{
		if(poPosition==null){
			throw new RobotToyException("Invalid position");
		}
		placeObject.setPoPosition(poPosition);
		return true;
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
//		System.out.println("inputCommand[1] = " + inputCommand[1]);
		Commands command = Commands.valueOf(inputCommand[0]);
		String inputParams[];
		int x=0;
		int y=0;
		Direction direction = null;
		String output="";
		if(command == Commands.PLACE){
			inputParams = inputCommand[1].split(",");
			try{
				
				x = Integer.parseInt(inputParams[0]);
				y = Integer.parseInt(inputParams[1]);
				direction = Direction.valueOf(inputParams[2]);
			}catch(Exception re){
				throw new RobotToyException("Invalid Commands input!");
			}
			
		}
		switch(command){
			case PLACE: 
				Position po = new Position(x, y, direction);
				 poPosition = new POPosition(po);
				boolean initRobot = initRobot(po);
				boolean initObject = initObject(poPosition);
				
				output = String.valueOf(initRobot && initObject);
				break;
			case MOVE:
				Position newPosition = robot.getPosition().getNextPosition();
				if (!squareTable.isPositionValid(newPosition))
                    output = String.valueOf(false);
                else
                    output = String.valueOf(robot.move(newPosition));
				break;
			case LEFT:
				output = String.valueOf(robot.rotateLeft());
				break;
			case RIGHT:
				output = String.valueOf(robot.rotateRight());
				break;
			case PLACE_OBJECT:
				output = String.valueOf(poPosition.getNewPOPosition(robot.getPosition()));
				break;
			case REPORT:
				output = report();
				break;
			default:
				throw new RobotToyException("Command invalid! Please try again with correct format!");
		}
		return output;
	}
	
	public String report() {
		// TODO Auto-generated method stub
		return robot.getPosition().getX() + "," + robot.getPosition().getY() + "," 
				+ robot.getPosition().getDirection().toString()+"- PLACE_OBJECT: "+poPosition.getX()+","+poPosition.getY();
	}
}
