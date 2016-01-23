package Bina;
import java.util.List;

public class AlgoritemPerceptrons {
	
	public int TrashHole = 0;
	
	public double N = 0.2;
	
	
	public void algoTesting(List<LetterRecognition> letter, char l)
	{
		int res = 0;
		int expectedResult =0;
		int sumOfCorecctResult =0;
		int a_right = 0;
		int b_right = 0;
		int a_wrong = 0;
		int b_wrong  = 0;
		
		
			for(LetterRecognition letterRecognition : letter)
			{
				expectedResult = convertor(letterRecognition.LetterSymble);
				res	=checkSingleLetter(letterRecognition);
				if(res == expectedResult)
				{
					sumOfCorecctResult++;
					if(letterRecognition.LetterSymble =='A')
						a_right++;
					else
						b_right++;
				}
				else{
					if(letterRecognition.LetterSymble =='A')
						a_wrong++;
					else
						b_wrong++;
				}
			}
			
			double d = (double)sumOfCorecctResult / letter.size();
			System.out.println("Number of correct result in testing: "+ sumOfCorecctResult + " From: "+letter.size());
			System.out.println("The percent accuracy on the test data: "+ d);
			System.out.println("‘A’ that were correctly classified as ‘A’: "+a_right);
			System.out.println("'"+l+"' that were correctly classified as '"+l+"': "+b_right);
			System.out.println("‘A’ that were misclassified as '"+l+"': "+a_wrong);
			System.out.println("'"+l+"' that were misclassified as ‘A’: "+b_wrong);
	}
	
	public void algoTraining(List<LetterRecognition> letter, char l)
	{
		int res = 0;
		int expectedResult =0;
		int sumOfCorecctResult =0;
		int maxOfCorecctResult =0;
		int counterEpochs = 0;
		
		
		
		while (true){
			 sumOfCorecctResult =0;
			for(LetterRecognition letterRecognition : letter)
			{
				expectedResult = convertor(letterRecognition.LetterSymble);
				res	=checkSingleLetter(letterRecognition);
				if(res == expectedResult)		
					sumOfCorecctResult++;
			}
			
			
			if(maxOfCorecctResult < sumOfCorecctResult)
			{
				maxOfCorecctResult = sumOfCorecctResult;
					
				for(LetterRecognition letterRecognition : letter)
				{	
					expectedResult = convertor(letterRecognition.LetterSymble);
					res	=checkSingleLetter(letterRecognition);
					if(res != expectedResult)
					{
						counterEpochs++;
						upDateWight(res,expectedResult,letterRecognition);	
					}
				}
			}
			else
			{
				 double d = (double)maxOfCorecctResult / letter.size();
				System.out.println("Counter epochs: "+ counterEpochs);
				System.out.println("Number of correct result in training : "+ maxOfCorecctResult + " from: "+letter.size());
				System.out.println("The percent accuracy on the training data: "+ d);
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
		if(compute >= TrashHole)
		{
			return 1;
		}
		return -1;
		
	}
	
	
	public double compute(Double[] features, Double[] wights)
	{
		double sum=0;
		
		for(int i=0 ; i<Constans.NUmberOfFeatures; i++)
		{
			sum+=computeSingle(features[i], wights[i]);
		}
		
		return sum+1;
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
