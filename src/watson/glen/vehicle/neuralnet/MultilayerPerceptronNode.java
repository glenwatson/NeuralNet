package watson.glen.vehicle.neuralnet;

/**
 * A node in an <a href="http://en.wikipedia.org/wiki/Multilayer_perceptron">MLP</a>
 * @author glen.watson
 */
public class MultilayerPerceptronNode extends Perceptron
{
	public MultilayerPerceptronNode(int size)
	{
		super(size);
	}
	
	@Override
	protected float activate(float in)
	{
		return (float) Math.tanh(in);
	}
}
