package Bina;
import java.util.Arrays;


public class LetterRecognition {
	
	public Character LetterSymble;

	public Double[] Features;
	
	

	public LetterRecognition() {
	
		this.Features = new Double[16]; 
	}
	
	

	@Override
	public String toString() {
		return "LetterRecognition [LetterSymble=" + LetterSymble
				+ ", Features=" + Arrays.toString(Features) + "]";
	}

}
