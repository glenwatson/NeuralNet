package watson.glen.vehicle.neuralnet;

/**
 * Trains a single perceptron
 * @author glen.watson
 */
public class Trainer
{
	protected float[] inputs;
	protected float answer;
	protected float learningRate;
	
	public Trainer(float[] inputs, float answer, float learningRate)
	{
		super();
		this.inputs = inputs;
		this.answer = answer;
		this.learningRate = learningRate;
	}
	
	/**
	 * runs this Trainer on the perceptron
	 * @param p the perceptron to train
	 * @return the error value (how much the perceptron was off)
	 */
	public float train(Perceptron p)
	{
		return p.train(inputs, answer, learningRate);
	}
	
}
