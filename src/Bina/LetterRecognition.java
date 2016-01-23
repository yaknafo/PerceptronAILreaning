package Bina;
import java.util.Arrays;


public class LetterRecognition {
	
	public Character LetterSymble;

	public Double[] Features;
	
	public LetterRecognition() {
		this.Features = new Double[Constans.NUmberOfFeatures]; 
	}
	

	@Override
	public String toString() {
		return "LetterRecognition [LetterSymble=" + LetterSymble
				+ ", Features=" + Arrays.toString(Features) + "]";
	}

}
