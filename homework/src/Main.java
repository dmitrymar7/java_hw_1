import java.io.FileReader;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {
        ex1();
    }

    public static void ex1(){

        String inputFileName = "input.txt";
        String outputFileName = "output.txt";

        String text = "";
        try(FileReader inputFile = new FileReader(inputFileName)) {
            while (inputFile.ready()){
                text += (char) inputFile.read();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return;
        }

        text = text.replace("\r", "");

        Integer a = null;
        Integer b = null;

        String[] lines = text.split("\n");
        if (lines.length < 2){
            System.out.println("Неверный формат данных в файле");
            return;
        }

        for (String line : lines) {
            String[] arrayLine = line.split(" ");

            if (arrayLine.length < 2) {
                continue;
            }

            if (arrayLine[0].equals("a")) {
                try {
                    a = Integer.parseInt(arrayLine[1]);
                } catch (Exception e) {
                    a = null;
                }
            } else if (arrayLine[0].equals("b")) {
                try {
                    b = Integer.parseInt(arrayLine[1]);
                } catch (Exception e) {
                    b = null;
                }
            }
        }

            String errorText = "";
            if (a == null){
                errorText += "Число a не определено";
            }

            if (b == null){
                if (!errorText.isEmpty()){
                    errorText += "\n";
                }
                errorText += "Число b не определено";
            }

            if (!errorText.isEmpty()){
                System.out.println(errorText);
                return;
            }

            int res = (int) Math.pow(a, b);

            try(FileWriter fileOutput = new FileWriter(outputFileName)){
                fileOutput.write(String.valueOf(res));
            }catch(Exception e){
                System.out.println(e.getMessage());
                return;
            }

    }

}

