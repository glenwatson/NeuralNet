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
		
		int westBorder = Math.min(0, vehicle.getPostion().getX());
		int eastBorder = Math.max(size.getX()-1, vehicle.getPostion().getX());
		int northBorder = Math.min(0, vehicle.getPostion().getY());
		int southBorder = Math.max(size.getY()-1, vehicle.getPostion().getY());
		
		for (Vector v : targets)
		{
			westBorder = Math.min(westBorder, v.getX());
			eastBorder = Math.max(eastBorder, v.getX());
			northBorder = Math.min(northBorder, v.getY());
			southBorder = Math.max(southBorder, v.getY());
		}
		
		StringBuilder headerFooter = new StringBuilder();
		headerFooter.append('+');
		for(int i = westBorder; i <= eastBorder; i++)
			headerFooter.append('-');
		headerFooter.append("+\r\n");
		sb.append(headerFooter);
		
		for(int y = northBorder; y <= southBorder; y++)
		{
			sb.append('|');
			for(int x = westBorder; x <= eastBorder; x++)
			{
				Vector current = new Vector(x, y);
				if(current.equals(vehicle.getPostion()))
					sb.append('O');
				else if(targets.contains(current))
					sb.append('X');
				else if(current.equals(new Vector(0, 0)))
					sb.append('.');
				else 
					sb.append(' ');
			}
			
			sb.append("|\r\n");
		}
		
		sb.append(headerFooter);
		return sb.toString();
	}
}
