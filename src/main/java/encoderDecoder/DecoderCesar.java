package encoderDecoder;

import java.nio.file.Path;

public class DecoderCesar extends EncoderDecoder {

    public DecoderCesar(Path pathInput, int key) {
        super(pathInput, key);
    }

    @Override
    public int calculateIndexNewMeaningOfLetter(int startIndex, int shift, int lastIndex) {
        int result = startIndex - shift;
        if (result < 0) {
            result = (lastIndex + 1) - Math.abs(result);
        }
        return result;
    }
}
