package watson.glen.vehicle.neuralnet;

import java.util.Random;

// http://natureofcode.com/book/chapter-10-neural-networks/
public class Perceptron
{
	private static final int WEIGHT_SEED = 13;
	protected float[] weights;
	
	public Perceptron(int size)
	{
		super();
		this.weights = new float[size];
		Random rand = new Random(WEIGHT_SEED);
		for (int i = 0; i < weights.length; i++)
		{
			weights[i] = rand.nextFloat() * 2 - 1; //Note: will never be 1
		}
		
		weights[0] = 2;
		weights[1] = 1;
		weights[2] = 0.000001f;
	}

	public int calc(float[] inputs)
	{
		float result = weightedSum(inputs);
		return activate(result);
	}
	
	public void train(float[] inputs, float desired, float learningRate)
	{
		float guess = weightedSum(inputs);
		float error = desired - guess;
		
		for (int i = 0; i < weights.length; i++)
		{
			weights[i] += inputs[i] * error * learningRate;
		}
	}

	private int activate(float result)
	{
		return result >= 0 ? 1 : -1;
	}

	private float weightedSum(float[] inputs)
	{
		assert inputs.length == weights.length : "inputs' length is different that weights' length";
		float result = 0;
		for(int i=0; i<inputs.length; i++)
			result += inputs[i] * weights[i];
		return result;
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
