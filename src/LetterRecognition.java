import java.util.Arrays;


public class LetterRecognition {
	
	public Character LetterSymble;

	public Integer[] Features;

	public LetterRecognition() {
	
		this.Features = new Integer[16]; 
	}
	
	

	@Override
	public String toString() {
		return "LetterRecognition [LetterSymble=" + LetterSymble
				+ ", Features=" + Arrays.toString(Features) + "]";
	}

}
