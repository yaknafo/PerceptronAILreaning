import java.util.List;



public class AlgoritemPerceptrons {
	
	public int TrashHole = 1;
	
	public double N = 0.2;
	
	
	public void algoTesting(List<LetterRecognition> letter)
	{
		int res = 0;
		int expectedResult =0;
		int sumOfCorecctResult =0;
		int maxOfCorecctResult =0;
		
		
		while (true){
			 sumOfCorecctResult =0;
			for(LetterRecognition letterRecognition : letter)
			{
				expectedResult = convertor(letterRecognition.LetterSymble);
				res	=checkSingleLetter(letterRecognition);
				if(res == expectedResult)		
					sumOfCorecctResult++;
			}
			
			System.out.println("sum Of Corecct Result: "+ sumOfCorecctResult + " size: "+letter.size());
			if(maxOfCorecctResult < sumOfCorecctResult)
			{
				maxOfCorecctResult = sumOfCorecctResult;
					
				for(LetterRecognition letterRecognition : letter)
				{	
					expectedResult = convertor(letterRecognition.LetterSymble);
					res	=checkSingleLetter(letterRecognition);
					if(res != expectedResult)
					{
						upDateWight(res,expectedResult,letterRecognition);	
					}
				}
			}
			else
			{
				break;
			}
		}
					
		
	}

	
	private void upDateWight(int res, int expectedResult, LetterRecognition l) {
		
		double newWight =0; 
		for(int i=0 ; i<Constans.NUmberOfFeatures; i++)
		{
			newWight = upDateWightSingle(i, expectedResult, res, l);
			PerceptronsDataManager.Wights[i] = newWight;
		}
		
	}
	
	private double upDateWightSingle(int index , int t, int o,LetterRecognition l) {
		
		return PerceptronsDataManager.Wights[index]+N*(t-o)*l.Features[index];
	}


	private int checkSingleLetter(LetterRecognition letter) {
		
		double sum =compute(letter.Features,PerceptronsDataManager.Wights);
		
		return activation(sum) ;
	}
	
	public int activation(double compute)
	{
		if(compute <= TrashHole)
		{
			return -1;
		}
		return 1;
		
	}
	
	public double compute(Double[] features, Double[] wights)
	{
		double sum=0;
		
		for(int i=0 ; i<Constans.NUmberOfFeatures; i++)
		{
			sum+=computeSingle(features[i], wights[i]);
		}
		
		return sum;
	}
	
	
	
	public double computeSingle(Double features, double wight)
	{
		return (features) * wight;
	}
	
	private int convertor(char c)
	{
		if(c == 'A')
			return 1;
		return -1;
	}
	
	

}
