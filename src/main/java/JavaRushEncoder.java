import alphabets.EnglishAlphabet;
import encoders.Encoder;

import java.nio.file.Files;
import java.nio.file.Path;

public class JavaRushEncoder {
    public static void main(String[] args) {
//        if (!isToEncodeAndCorrectOtherArgs(args)){
//
//        }
    }


    public static void creteEncodedFile(String[] args){
        EnglishAlphabet englishAlphabet = new EnglishAlphabet();
        Path pathInputFile = Path.of(args[1]);
            Encoder encoderCesar = new Encoder(pathInputFile, Integer.parseInt(args[2]));
            encoderCesar.createFileForEncoding(pathInputFile);
            encoderCesar.writeEncodeFile(englishAlphabet);

    }

    private static boolean isToEncodeAndCorrectOtherArgs(String[] args){
        Path pathInputFile = Path.of(args[1]);
        if (!args[0].equalsIgnoreCase("encoded")) {
            return false;
        }if (Files.notExists(pathInputFile)){
            System.out.println("File for encoding does not exist");
            return false;
        }
        if (!Files.notExists(Path.of(args[1] + "encoded"))){
            System.out.println("File is exist with such name as we are creating. " +
                    "Please delete file and then restart application");
            return false;
        }
        char[] arr = args[2].toCharArray();
        for (char c : arr) {
           if (!Character.isDigit(c)) {
               System.out.println("Third arg must be number, please restart application with correct arg.");
               return false;
           }
        }
        return true;
    }
}
