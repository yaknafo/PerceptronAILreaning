package Bina;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

public static PerceptronsDataManager dm = new PerceptronsDataManager();

	public static void main(String[] args) {
		AlgoritemPerceptrons algo = new AlgoritemPerceptrons();
		System.out.println("Learning Rate = "+algo.N);
		for(int  i =66 ; i<91;i++)
		{
			System.out.println("========================== 'A' vs '"+(char)i+"'==========================");
			initData((char)i);
			algo.algoTraining(dm.Letters,(char)i);
			algo.algoTesting(dm.LettersTesting,(char)i);
			dm.Letters = new ArrayList<LetterRecognition>();
			dm.LettersTesting = new ArrayList<LetterRecognition>();
			System.out.println();
		
		}
	}
	
	
	public static void initData(char letter) {

		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader("data/letter-recognition.txt"));

			String line;
			String[] numbers;
			int counter_A = 0;
			int countallLettersInFile = getNumberOfLetterInFile(letter);
			int counter_letter =0;
			while((line = (in.readLine())) != null)
			{
				if(line.charAt(0) == 'A' || line.charAt(0) == letter)
				{
					LetterRecognition temp = new LetterRecognition();
					
					temp.LetterSymble = line.charAt(0);
					numbers =line.split(",");
					for(int i =1 ; i<=Constans.NUmberOfFeatures; i++ )
					{
						temp.Features[i-1] = Integer.parseInt(numbers[i])/Constans.DivdieFactor;
				
					}
					if(temp.LetterSymble == 'A' && counter_A < Constans.A_training || temp.LetterSymble == letter && countallLettersInFile/2 > counter_letter)
						dm.Letters.add(temp);
					else
						dm.LettersTesting.add(temp);
					
					
					if(temp.LetterSymble == 'A')
						counter_A++;
					else
						counter_letter++;
				}
			}
			in.close();
		} catch (IOException e) {
		}
	}
	
	
	public static int getNumberOfLetterInFile(char letter)
	{
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader("data/letter-recognition.txt"));
			int counter= 0;
			String line;
			while((line = (in.readLine())) != null)
			{
				if(line.charAt(0) == letter)
					counter++;
			}
			in.close();
			return counter;
		} catch (IOException e) {
		}
		return 0;
		
	}
}


