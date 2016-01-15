import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;




public class Main {

public static PerceptronsDataManager dm = new PerceptronsDataManager();

	public static void main(String[] args) {
		
		initData();
		System.out.println(dm.Letters.size());
	}
	
	
	public static void initData() {

		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader("data/letter-recognition.txt"));

			String line;
			String[] numbers;
			//line = "start"
			
			while((line = (in.readLine())) != null)
			{
				if(line.charAt(0) == 'A' || line.charAt(0) == 'B')
				{
					LetterRecognition temp = new LetterRecognition();
					
					temp.LetterSymble = line.charAt(0);
					numbers =line.split(",");
					for(int i =1 ; i<17; i++ )
					{
						temp.Features[i-1] = Integer.parseInt(numbers[i]);
				
					}
					
					dm.Letters.add(temp);
				}
			
			}

			in.close();

			

		} catch (IOException e) {
		}
	}

}
