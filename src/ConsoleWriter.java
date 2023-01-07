/**
 * @author Simon Pirko on 5.01.23
 */
public class ConsoleWriter implements Writer{

	private int count = 0;

	@Override
	public void methodWrite(String message) {
		count++;
		System.out.println(message);
	}
}
