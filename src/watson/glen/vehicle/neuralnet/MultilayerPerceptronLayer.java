package watson.glen.vehicle.neuralnet;

public class MultilayerPerceptronLayer
{
	protected MultilayerPerceptronNode[] nodes;
	
	public MultilayerPerceptronLayer(MultilayerPerceptronNode[] perceptrons)
	{
		super();
		this.nodes = perceptrons;
		assertInputSizesEqual();
	}
	
	private void assertInputSizesEqual()
	{
		int size = nodes[0].getWeights().length;
		for (int i = 1; i < nodes.length; i++)
			assert size == nodes[i].getInputSize() : "The input sizes must all be the same.";
	}
	
	public Perceptron[] getPerceptrons()
	{
		return nodes;
	}
	
	public float[] calc(float[] inputs)
	{
		assert nodes[0].getInputSize() == inputs.length : "The inputs must be the same size as the Layer's perceptrons.";
		float[] output = new float[nodes.length];
		for (int i = 0; i < nodes.length; i++)
		{
			output[i] = nodes[i].calc(inputs);
		}
		return output;
	}
	
	public float[] train(float[] inputs, float desired, float learningRate)
	{
		assertInputSizesEqual();
		float[] errors = new float[nodes.length];
		for(int i = 0; i < nodes.length; i++)
		{
			errors[i] = nodes[i].train(inputs, desired, learningRate);
		}
		return errors;
	}
	
	public int getInputSize()
	{
		return nodes[0].getInputSize();
	}
	
	public int getOutputSize()
	{
		return nodes.length;
	}
}
