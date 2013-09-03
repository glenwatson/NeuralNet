package watson.glen.vehicle;

public class Vehicle
{
	private Vector postion;
	private Vector velocity;
	private Vector acceleration;
	
	public Vehicle()
	{
		super();
		postion = new Vector();
		velocity = new Vector();
		acceleration = new Vector();
	}
	
	public Vehicle(Vector postion, Vector velocity, Vector acceleration)
	{
		super();
		this.postion = postion;
		this.velocity = velocity;
		this.acceleration = acceleration;
	}

	public void move()
	{
		velocity.setX(velocity.getX() + acceleration.getX());
		velocity.setY(velocity.getY() + acceleration.getY());
		
		postion.setX(postion.getX() + velocity.getX());
		postion.setY(postion.getY() + velocity.getY());
	}

	public ReadonlyVector getPostion()
	{
		return postion;
	}

	public ReadonlyVector getVelocity()
	{
		return velocity;
	}

	public ReadonlyVector getAcceleration()
	{
		return acceleration;
	}

	public void setAcceleration(Vector acceleration)
	{
		this.acceleration = acceleration;
	}
	
}
