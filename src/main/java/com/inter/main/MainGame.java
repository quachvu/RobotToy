package com.inter.main;

import java.util.Scanner;

import com.inter.cch.pojo.Commands;
import com.inter.cch.pojo.Direction;
import com.inter.cch.pojo.Position;
import com.inter.cch.pojo.SquareTable;
import com.inter.exception.RobotToyException;

public class MainGame {
	static RobotToy robot;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SquareTable squareTable = new SquareTable(5,5);
		RobotToy robot = new RobotToy();
		PlaceObject placeObject = new PlaceObject();
		
		System.out.println("Robot Toy Program");
		System.out.println("Please enter commands following the below format:");
		System.out.println("PLACE X,Y, NORTH(SOUTH)(WEST)(EAST), MOVE,LEFT,RIGHT, REPORT, PLACE_OBJECT or EXIT");
		Playing playing = new Playing(placeObject, robot, squareTable);
		//Place PLACED_OBJECT
		System.out.println("Please enter command for PLACED_OBJECT:");
		//loop through input commands to process the Robot until users wanna exit.
		String inputS = "";
		boolean moreCommands = true;
		do{
//			System.out.println("Please input your commands: ");
			Scanner scan = new Scanner(System.in);
			inputS = scan.nextLine();
			System.out.println("input = "+inputS);
			if("EXIT".equalsIgnoreCase(inputS)){
				moreCommands = false;
			}else{
				String output="";
				try {
					output = playing.evaluation(inputS);
					System.out.println("The current Robot Position is: " + output);
				} catch (RobotToyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
//				System.out.println("Output = " + output);
			}
			
		}while(moreCommands);
				
	}

	

	
}
