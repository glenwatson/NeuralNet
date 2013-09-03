package watson.glen.vehicle.neuralnet;

public class Trainer
{
	private float[] inputs;
	private float answer;
	private float learningRate;
	
	public Trainer(float x, float y, float answer, float learningRate)
	{
		super();
		this.inputs = new float[]{x, y, 1}; //add the bias
		this.answer = answer;
		this.learningRate = learningRate;
	}
	
	public void train(Perceptron p)
	{
		p.train(inputs, answer, learningRate);
	}
	
}
