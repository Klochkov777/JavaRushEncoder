package encoderDecoder;

import java.nio.file.Path;

public class EncoderCesar extends EncoderDecoder {

    public EncoderCesar(Path pathInput, int key) {
        super(pathInput, key);

    }

    @Override
    public int calculateIndexNewMeaningOfLetter(int startIndex, int shift, int lastIndex) {
        int result = startIndex + shift;
        if (result > lastIndex) {
            result = result - lastIndex - 1;
        }
        return result;
    }

}
