package watson.glen.vehicle.neuralnet;

import java.util.Random;

//http://natureofcode.com/book/chapter-10-neural-networks/
public abstract class Perceptron
{
	
	protected static final int WEIGHT_SEED = 0;
	protected float[] weights;

	public Perceptron(int size)
	{
		super();
		this.weights = new float[size + 1];
		Random rand = new Random(WEIGHT_SEED);
		for (int i = 0; i < size; i++)
		{
			weights[i] = rand.nextFloat() * 2 - 1; //Note: will never be 1
		}
		weights[size] = 1; //add the bias
	}

	public float calc(float[] inputs)
	{
		assertInputLength(inputs.length);
		
		float result = weightedSum(inputs);
		return activate(result);
	}

	/**
	 * Trains the perceptron using supervised learning
	 * @param inputs - self explanatory
	 * @param desired - what the inputs should generate
	 * @param learningRate - the rate at which to change the weights
	 * @return the error amount the perceptron was off by
	 */
	public float train(float[] inputs, float desired, float learningRate)
	{
		assertInputLength(inputs.length);
		
		float guess = weightedSum(inputs);
		float error = desired - guess;
		
		for (int i = 0; i < inputs.length; i++)
			weights[i] += inputs[i] * error * learningRate;
		weights[weights.length-1] += error * learningRate; //add the bias (input is 1)
		return error;
	}

	protected float weightedSum(float[] inputs)
	{
		assertInputLength(inputs.length);
		float result = 0;
		for(int i=0; i<inputs.length; i++)
			result += inputs[i] * weights[i];
		result += weights[weights.length-1]; //add the bias (input is 1)
		return result;
	}
	
	protected abstract float activate(float in);

	private void assertInputLength(int inputLength)
	{
		assert inputLength + 1 == weights.length : "incorrect number of inputs";
	}

	public int getInputSize()
	{
		return weights.length - 1;
	}

	public float[] getWeights()
	{
		return weights;
	}

	public void setWeights(float[] weights)
	{
		this.weights = weights;
	}
	
}