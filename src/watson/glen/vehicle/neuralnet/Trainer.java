package watson.glen.vehicle.neuralnet;

public class Trainer
{
	protected float[] inputs;
	protected float answer;
	protected float learningRate;
	
	public Trainer(float x, float y, float answer, float learningRate)
	{
		super();
		this.inputs = new float[]{x, y};
		this.answer = answer;
		this.learningRate = learningRate;
	}
	
	public float train(Perceptron p)
	{
		return p.train(inputs, answer, learningRate);
	}
	
}
