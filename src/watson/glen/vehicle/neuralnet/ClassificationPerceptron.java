package watson.glen.vehicle.neuralnet;


public class ClassificationPerceptron extends Perceptron
{
	public ClassificationPerceptron(int size)
	{
		super(size);
	}
	
	/**
	 * <a href="http://en.wikipedia.org/wiki/Heaviside_step_function">Heaviside step function</a>
	 * @param value 
	 * @return 1 if positive or -1 if negative
	 */
	protected float activate(float result)
	{
		return result >= 0 ? 1 : -1;
	}
}
