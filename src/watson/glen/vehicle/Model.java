package watson.glen.vehicle;

import java.util.HashSet;
import java.util.Set;

public class Model
{
	private Vehicle vehicle;
	private Set<Vector> targets;
	private Vector size;
	
	public Model(Vehicle vehicle, Set<Vector> targets, Vector size)
	{
		super();
		this.vehicle = vehicle;
		this.targets = targets;
		this.size = size;
	}
	
	public void tick()
	{
		vehicle.move();
		
		vehicle.setAcceleration(new Vector());

		removeReachedTargets();
	}
	
	public void accelerate(Direction dir)
	{
		switch (dir)
		{
			case NORTH:
				vehicle.setAcceleration(new Vector(0, -1));
				break;
			case EAST:
				vehicle.setAcceleration(new Vector(1, 0));
				break;
			case SOUTH:
				vehicle.setAcceleration(new Vector(0, 1));
				break;
			case WEST:
				vehicle.setAcceleration(new Vector(-1, 0));
				break;
			case NONE:
				vehicle.setAcceleration(new Vector());
				break;
			default:
				throw new IllegalArgumentException(dir+" is not a supported Direction");
		}
	}

	private void removeReachedTargets()
	{
		Set<Vector> reachedTargets = new HashSet<>();
		for(Vector target : getTargets())
		{
			if(vehicle.getPostion().equals(target))
				reachedTargets.add(target);
		}
		getTargets().removeAll(reachedTargets);
	}

	public Vehicle getVehicle()
	{
		return vehicle;
	}
	
	public void setVehicle(Vehicle vehicle)
	{
		this.vehicle = vehicle;
	}

	public Set<Vector> getTargets()
	{
		return targets;
	}

	public void setTargets(Set<Vector> targets)
	{
		this.targets = targets;
	}

	public Vector getSize()
	{
		return size;
	}

	public void setSize(Vector size)
	{
		this.size = size;
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		StringBuilder headerFooter = new StringBuilder();
		headerFooter.append('+');
		for(int i = 0; i < size.getX(); i++)
			headerFooter.append('-');
		headerFooter.append("+\r\n");
		sb.append(headerFooter);
		
		for(int y=0; y < size.getY(); y++)
		{
			sb.append('|');
			for(int x = 0; x < size.getX(); x++)
			{
				Vector current = new Vector(x, y);
				if(current.equals(vehicle.getPostion()))
					sb.append('O');
				else if(targets.contains(current))
					sb.append('X');
				else 
					sb.append(' ');
			}
			
			sb.append("|\r\n");
		}
		
		sb.append(headerFooter);
		return sb.toString();
	}
}
