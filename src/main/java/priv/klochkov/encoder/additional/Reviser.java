package priv.klochkov.encoder.additional;

import priv.klochkov.encoder.encoderDecoder.DecoderCesar;
import priv.klochkov.encoder.encoderDecoder.EncoderDecoder;

import java.nio.file.Files;
import java.nio.file.Path;

public class Reviser {
    String[] args;

    public Reviser(String[] args) {
        this.args = args;
    }

    public boolean isArgsCorrect() {
        return (isFirstArgCorrect() && isSecondArgCorrect() && isThirdArgCorrect());
    }

    public boolean isFirstArgCorrect() {
        if (args.length == 0) {Communicator.messageNoArgs(); return false;}
        if (!args[0].equalsIgnoreCase("encode") && !args[0].equalsIgnoreCase("decode")) {
            Communicator.messageFirstArg();
            return false;
        }
        return true;
    }

    public boolean isSecondArgCorrect() {
        Path pathInputFile = Path.of(args[1]);
        if (Files.notExists(pathInputFile)) {
            Communicator.messageSecondArg();
            return false;
        }
        return true;
    }

    public boolean isThirdArgCorrect() {
        char[] arr = args[2].toCharArray();
        for (char c : arr) {
            if (!Character.isDigit(c)) {
                Communicator.messageThirdArg();
                return false;
            }
        }
        return true;
    }

    public boolean isNeedEncode() {
        return args[0].equalsIgnoreCase("encode");
    }

    public boolean isNeedDecode() {
        return args[0].equalsIgnoreCase("decode");
    }

    public boolean isExistDecodedFileWhenEncode(EncoderDecoder encoderDecoder) {
        String str;
        if (encoderDecoder instanceof DecoderCesar)
            str = "(decoded)";
        else str = "(encoded)";
        return (!Files.notExists(Path.of(args[1] + str)));
    }
}
