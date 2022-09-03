import additional.Reviser;
import alphabets.Alphabet;
import alphabets.EnglishAlphabet;
import encoders.Encoder;

import java.nio.file.Path;

public class JavaRushEncoder {
    public static void main(String[] args) {
        Reviser reviser = new Reviser(args);
        EnglishAlphabet alphabet = new EnglishAlphabet();
       if (!reviser.isArgsCorrect()) return;
       if (reviser.isNeedEncode()){
           if (reviser.isExistDecodedFileWhenEncode()) {return;}
           else {createEncodedFile(args, alphabet);}
       }
       if ((reviser.isNeedDecode())){





       }
    }


    public static void createEncodedFile(String[] args, Alphabet alphabet){
        EnglishAlphabet englishAlphabet = new EnglishAlphabet();
        Path pathInputFile = Path.of(args[1]);
            Encoder encoderCesar = new Encoder(pathInputFile, Integer.parseInt(args[2]));
            encoderCesar.createFileForEncoding(pathInputFile);
            encoderCesar.writeEncodeFile(englishAlphabet);

    }


}
