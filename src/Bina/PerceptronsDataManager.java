package Bina;
import java.util.ArrayList;
import java.util.Random;


public class PerceptronsDataManager {
	
	public ArrayList<LetterRecognition> Letters;
	
	public ArrayList<LetterRecognition> LettersTesting;
	
	public static Double[] Wights;
	public PerceptronsDataManager() {
		Letters = new ArrayList<LetterRecognition>();
		LettersTesting = new ArrayList<LetterRecognition>();
		Wights = new Double[Constans.NUmberOfFeatures];
		randWights();
	}
	
	public void randWights()
	{
		Random rand = new Random(1);
		for(int i=0 ; i<Constans.NUmberOfFeatures;i++)
		{
			Wights[i] = rand.nextDouble();
		}
	}
	
	public static void printWights()
	{
		
		for(int i=0 ; i<Constans.NUmberOfFeatures;i++)
		{
			System.out.print(Wights[i]+" , ");
		}
	}

}
