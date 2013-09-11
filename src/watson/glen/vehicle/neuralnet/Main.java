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
		Perceptron p = new Perceptron(2, true);
		
		//setup
		Trainer[] trainers = initTrainers();
		
		runTrainersOn(p, trainers);
		
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
	
	private static float runTrainersOn(Perceptron p, Trainer[] trainers)
	{
		float[] errors = new float[trainers.length];
		for (int i = 0; i < trainers.length; i++)
		{
			float[] prev = p.weights;
			errors[i] = trainers[i].train(p);
			if(!Arrays.equals(prev, p.weights));
				System.out.println(Arrays.toString(p.weights));
		}
		return standardDeviation(errors);
	}

	private static float standardDeviation(float[] population)
	{
		//calculate the standard deviation
		float sum = 0;
		for (float f : population)
			sum += f;
		float mean = sum / population.length;
		
		float variance = 0;
		for (float f : population)
			variance += Math.pow(f - mean, 2);
		variance = variance / population.length;
		
		float stddev = (float) Math.sqrt(variance);
		System.out.println(stddev);
		return stddev;
	}
	
	private static void shuffleTrainers(Trainer[] trainers)
	{
		Random r = new Random();
		for(int i = 0; i<trainers.length; i++)
		{
			int randIdx = r.nextInt(trainers.length);
			Trainer temp = trainers[i];
			trainers[i] = trainers[randIdx];
			trainers[randIdx] = temp;
		}
	}
	
	public static float f(float x, float y)
	{
		return 2*x + 1;// >= y ? 1 : -1;
	}
}
