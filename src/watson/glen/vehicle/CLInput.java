package watson.glen.vehicle;

import java.util.Scanner;

public class CLInput implements Input
{
	Scanner scan = new Scanner(System.in);
	
	public Direction getDirection(Model model)
	{
		System.out.println(model);
		System.out.println(model.getVehicle().getPostion());
		
		String line = scan.nextLine();
		
		if(line.equalsIgnoreCase("w"))
			return Direction.NORTH;
		else if(line.equalsIgnoreCase("a"))
			return Direction.WEST;
		else if(line.equalsIgnoreCase("s"))
			return Direction.SOUTH;
		else if(line.equalsIgnoreCase("d"))
			return Direction.EAST;
		else
			return Direction.NONE;
		
	}
}
