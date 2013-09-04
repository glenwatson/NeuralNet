package watson.glen.vehicle.neuralnet;

import java.util.Random;

// http://natureofcode.com/book/chapter-10-neural-networks/
public class Perceptron
{
	private static final int WEIGHT_SEED = 0;
	protected float[] weights;
	private boolean hasBias;
	
	public Perceptron(int size, boolean hasBias)
	{
		super();
		if(hasBias)
		{
			this.weights = new float[size + 1];
			weights[size] = 1; //add the bias
		}
		else
		{
			this.weights = new float[size];
		}
		Random rand = new Random(WEIGHT_SEED);
		for (int i = 0; i < size; i++)
		{
			weights[i] = rand.nextFloat() * 2 - 1; //Note: will never be 1
		}
		this.hasBias = hasBias;
	}
	
	public Perceptron(int size)
	{
		this(size, true);
	}
	
	protected int calc(float[] inputs)
	{
		assertInputLength(inputs.length);
		
		float result = weightedSum(inputs);
		return activate(result);
	}
	
	public float train(float[] inputs, float desired, float learningRate)
	{
		assertInputLength(inputs.length);
		
		float guess = weightedSum(inputs);
		float error = desired - guess;
		
		for (int i = 0; i < inputs.length; i++)
			weights[i] += inputs[i] * error * learningRate;
		if(hasBias)
			weights[weights.length-1] += error * learningRate; //add the bias (input is 1)
		return error;
	}

	private int activate(float result)
	{
		return result >= 0 ? 1 : -1;
	}

	protected float weightedSum(float[] inputs)
	{
		assertInputLength(inputs.length);
		float result = 0;
		for(int i=0; i<inputs.length; i++)
			result += inputs[i] * weights[i];
		if(hasBias)
			result += weights[weights.length-1]; //add the bias (input is 1)
		return result;
	}

	private void assertInputLength(int inputLength)
	{
		if(hasBias)
			assert inputLength + 1 == weights.length : "incorrect number of inputs";
		else
			assert inputLength == weights.length : "incorrect number of inputs";
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
