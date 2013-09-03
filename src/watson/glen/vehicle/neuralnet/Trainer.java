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
	
	public void train(Perceptron p)
	{
		p.train(inputs, answer, learningRate);
	}
	
}
