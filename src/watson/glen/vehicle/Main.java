package watson.glen.vehicle;

import java.io.IOException;
import java.util.HashSet;

public class Main
{
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException
	{
		Vehicle vehicle = new Vehicle(new Vector(2, 2), new Vector(), new Vector());
		HashSet<Vector> targets = new HashSet<>();
		targets.add(new Vector(0,0));
		targets.add(new Vector(0,9));
		targets.add(new Vector(9,0));
		targets.add(new Vector(9,9));
		
		Model model = new Model(vehicle, targets, new Vector(5, 5));
		
		Input input = new CLInput();
		
		boolean run = true;
		while(run)
		{
			model.accelerate(input.getDirection(model));
			
			model.tick();
			
			if(model.getTargets().isEmpty()) //exit condition
				run = false;
		}
	}
	
}
