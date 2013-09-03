package watson.glen.vehicle;

public class Vector implements ReadonlyVector
{
	private int x;
	private int y;

	public Vector()
	{
		super();
	}
	
	public Vector(int x, int y)
	{
		super();
		this.x = x;
		this.y = y;
	}
	/**
	 * @return if the vector is the null vector (0,0)
	 */
	public boolean isStill()
	{
		return x == 0 && y == 0;
	}
	public int getX()
	{
		return x;
	}
	public void setX(int x)
	{
		this.x = x;
	}
	public int getY()
	{
		return y;
	}
	public void setY(int y)
	{
		this.y = y;
	}
	
	@Override
	public String toString()
	{
		return "("+x+","+y+")";
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Vector other = (Vector) obj;
		if(x != other.x)
			return false;
		if(y != other.y)
			return false;
		return true;
	}
	
}
