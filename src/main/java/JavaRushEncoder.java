import priv.klochkov.encoder.additional.Communicator;
import priv.klochkov.encoder.additional.Reviser;
import priv.klochkov.encoder.alphabets.Alphabet;
import priv.klochkov.encoder.alphabets.EnglishAlphabet;
import priv.klochkov.encoder.encoderDecoder.DecoderCesar;
import priv.klochkov.encoder.encoderDecoder.EncoderCesar;
import priv.klochkov.encoder.encoderDecoder.EncoderDecoder;

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
            Communicator.messageFileExists();
            return;
        } else {
            createEncodedDecodedFile(alphabet, encoderDecoder);
        }
        System.out.println("Application finished, look in " + encoderDecoder.getPathInput().getParent());
    }

    public static void createEncodedDecodedFile(Alphabet alphabet, EncoderDecoder encoderDecoder) {
        encoderDecoder.createFileForEncodingDecoding();
        encoderDecoder.writeEncodeDecodeFile(alphabet);
    }
}
