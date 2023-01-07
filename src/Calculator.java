/**
 * @author Simon Pirko on 5.01.23
 */
public class Calculator {

	public Operation calculate(Operation objectOper) {
		String type = objectOper.getType();

		switch (type) {
			case "sum":
				double sum = methodSum(objectOper.getNum1(), objectOper.getNum2()); //30
				objectOper.setResult(sum);
				return objectOper;
			case "sub":
				double sub = sub(objectOper.getNum1(), objectOper.getNum2());
				objectOper.setResult(sub);
				return objectOper;
			case "mult":
				double mult = mult(objectOper.getNum1(), objectOper.getNum2());
				objectOper.setResult(mult);
				return  objectOper;
			case "div":
				double div = div(objectOper.getNum1(), objectOper.getNum2());
				objectOper.setResult(div);
				return objectOper;
		}
		return null;
	}

	private static double methodSum(double a, double b) {
		return a + b;
	}

	private static double sub(double a, double b) {
		return a - b;
	}

	private static double mult(double a, double b) {
		return a * b;
	}
	private static double div(double a, double b) {
		return a / b;
	}
}
