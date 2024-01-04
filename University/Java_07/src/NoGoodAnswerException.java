import java.io.FileNotFoundException;

public class NoGoodAnswerException extends RuntimeException {

	public NoGoodAnswerException(String message)
	{
		super(message);
	}
}
