import java.io.*;

/**
 * @author Simon Pirko on 5.01.23
 */
public class ConsoleApplication implements Application {

    private final FileWriter fileWriter;

    {
        try {
            fileWriter = new FileWriter("history.txt", true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private final Reader objectReader = new ConsolerReader();
    private final Writer objectWriter = new ConsoleWriter();
    private final Calculator objectCalc = new Calculator();

    @Override
    public void run() {
        checkFile();
        while (true) {
            objectWriter.methodWrite("Enter number 1");
            double a = objectReader.readDouble(); //10
            objectWriter.methodWrite("Enter number 2");
            double b = objectReader.readDouble(); //20
            objectWriter.methodWrite("Enter operation type");
            String operationType = objectReader.readString();


            Operation operation = new Operation(a, b, operationType);

            Operation result = objectCalc.calculate(operation);
            try {
                fileWriter.write(result.toString());
				fileWriter.write("\n");
                fileWriter.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            objectWriter.methodWrite("Result " + result);
            //some code
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader("test.txt"));
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    objectWriter.methodWrite(line);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void checkFile() {
        File file = new File("history.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
