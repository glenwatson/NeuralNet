package watson.glen.vehicle.neuralnet;

import java.util.Arrays;
import java.util.Random;

public class Main
{
	private static final int TRAINING_SEED = 0;
	private static final int NUM_TRAINERS = 10000;
	private static final float LEARNING_RATE = 0.1f;
	private static final int X_SPREAD = 2;
	private static final int Y_SPREAD = 2;
	
	public static void main(String[] args)
	{
		Perceptron p = new Perceptron(3);
		
		//setup
		Trainer[] trainers = initTrainers();
		
		trainUsing(p, trainers);
	}

	private static Trainer[] initTrainers()
	{
		Trainer[] trainers = new Trainer[NUM_TRAINERS];
		Random rand = new Random(TRAINING_SEED);
		for (int i = 0; i < trainers.length; i++)
		{
			float x = rand.nextFloat()*X_SPREAD*2-X_SPREAD;
			float y = rand.nextFloat()*Y_SPREAD*2-Y_SPREAD;
			assert x >= -X_SPREAD;
			assert x < X_SPREAD;
			assert y >= -Y_SPREAD;
			assert y < Y_SPREAD;
			float answer = f(x, y);
			trainers[i] = new Trainer(x, y, answer, LEARNING_RATE);
		}
		return trainers;
	}
	
	private static void trainUsing(Perceptron p, Trainer[] trainers)
	{
		for (int i = 0; i < trainers.length; i++)
		{
			float[] prev = p.weights;
			trainers[i].train(p);
			if(!Arrays.equals(prev, p.weights));
				System.out.println(Arrays.toString(p.weights));
		}
	}
	
	public static float f(float x, float y)
	{
		return 2*x + 3; // >= y ? 1 : -1;
	}
}
