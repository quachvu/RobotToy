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
		
		System.out.println("Robot Toy Program");
		System.out.println("Please enter commands following the below format:");
		System.out.println("PLACE X,Y, NORTH(SOUTH)(WEST)(EAST), MOVE,LEFT,RIGHT, REPORT");
		Playing playing = new Playing(robot, squareTable);
		Scanner scan = new Scanner(System.in);
		String inputS = scan.nextLine();
		System.out.println("input = "+inputS);
		String output="";
		try {
			output = playing.evaluation(inputS);
		} catch (RobotToyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Output = " + output);
				
	}

	

	
}
