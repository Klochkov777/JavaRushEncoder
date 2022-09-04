import additional.Reviser;
import alphabets.Alphabet;
import alphabets.EnglishAlphabet;
import encoderDecoder.DecoderCesar;
import encoderDecoder.EncoderCesar;
import encoderDecoder.EncoderDecoder;

import java.nio.file.Path;

public class JavaRushEncoder {
    public static void main(String[] args) {
        EncoderDecoder encoderDecoder = null;
        Reviser reviser = new Reviser(args);
        Alphabet alphabet = new EnglishAlphabet();
        if (!reviser.isArgsCorrect()) return;
        Path pathInputFile = Path.of(args[1]);
        if (reviser.isNeedDecode()) {
            encoderDecoder = new DecoderCesar(pathInputFile, Integer.parseInt(args[2]));
        }
        if ((reviser.isNeedEncode())) {
            encoderDecoder = new EncoderCesar(pathInputFile, Integer.parseInt(args[2]));
        }
        if (reviser.isExistDecodedFileWhenEncode(encoderDecoder)) {
            return;
        } else {
            createEncodedDecodedFile(alphabet, encoderDecoder);
        }
        System.out.println("Application finished, look in " + encoderDecoder.getPathInput().getParent());
    }

    public static void createEncodedDecodedFile(Alphabet alphabet, EncoderDecoder encoderDecoder) {
        encoderDecoder.createFileForEncoding();
        encoderDecoder.writeEncodeFile(alphabet);
    }
}
