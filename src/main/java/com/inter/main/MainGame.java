package com.inter.main;

import java.util.Scanner;

import com.inter.cch.pojo.Commands;
import com.inter.cch.pojo.Direction;
import com.inter.cch.pojo.Position;
import com.inter.cch.pojo.SquareTable;

public class MainGame {
	static RobotToy robot;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SquareTable squareTabke = new SquareTable(5,5);
		
		System.out.println("Robot Toy Program");
		System.out.println("Please enter commands following the below format:");
		System.out.println("PLACE X,Y, NORTH-SOUTH-WEST-EAST, MOVE,LEFT,RIGHT, REPORT");
		
		Scanner scan = new Scanner(System.in);
		String inputS = scan.nextLine();
		System.out.println("input = "+inputS);
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
		
		String output;
		switch(command){
			case PLACE: 
				output = String.valueOf(moveRobot(new Position(x,y,direction)));
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
		
	}

	private static String report() {
		// TODO Auto-generated method stub
		return robot.getPosition().getX() + "," + robot.getPosition().getY() + "," + robot.getPosition().getDirection().toString();
	}

	private static boolean moveRobot(Position position) {
		// TODO Auto-generated method stub
		robot.setPosition(position);
		return true;
	}
}
