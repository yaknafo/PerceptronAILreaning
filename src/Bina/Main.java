package Bina;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

public static PerceptronsDataManager dm = new PerceptronsDataManager();

	public static void main(String[] args) {
		
		initData();
		AlgoritemPerceptrons algo = new AlgoritemPerceptrons();
		algo.algoTraining(dm.Letters);
		algo.algoTesting(dm.LettersTesting);
		
	}
	
	
	public static void initData() {

		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader("data/letter-recognition.txt"));

			String line;
			String[] numbers;
			int counter_A = 0;
			int counter_B = 0;
			
			while((line = (in.readLine())) != null)
			{
				if(line.charAt(0) == 'A' || line.charAt(0) == 'B')
				{
					
					
					LetterRecognition temp = new LetterRecognition();
					
					temp.LetterSymble = line.charAt(0);
					numbers =line.split(",");
					for(int i =1 ; i<17; i++ )
					{
						temp.Features[i-1] = Integer.parseInt(numbers[i])/Constans.DivdieFactor;
				
					}
					if(temp.LetterSymble == 'A' && counter_A < Constans.A_training || temp.LetterSymble == 'B' && counter_B < Constans.B_training)
						dm.Letters.add(temp);
					else
						dm.LettersTesting.add(temp);
					
					
					if(temp.LetterSymble == 'A')
						counter_A++;
					else
						counter_B++;
					
				}
			
			}
			in.close();

			

		} catch (IOException e) {
		}
	}

}
