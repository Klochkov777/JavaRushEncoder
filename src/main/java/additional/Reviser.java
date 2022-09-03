package additional;

import java.nio.file.Files;
import java.nio.file.Path;

public class Reviser {
    String[] args;
    public Reviser(String[] args) {
        this.args = args;
    }

    public boolean isArgsCorrect(){
        return (isFirstArgCorrect() && isSecondArgCorrect() && isThirdArgCorrect());
    }

    public boolean isFirstArgCorrect(){
        if (!args[0].equalsIgnoreCase("encode") && !args[0].equalsIgnoreCase("decode")){
            System.out.println("First arg is not correct. Enter right arg (\"encode/decode\")");
            return false;
        }
        return true;
    }

    public boolean isSecondArgCorrect(){
        Path pathInputFile = Path.of(args[1]);
        if (Files.notExists(pathInputFile)){
            System.out.println("File for encoding does not exist, restart application and enter right path");
            return false;
        }
        return true;
    }

    public boolean isThirdArgCorrect(){
        char[] arr = args[2].toCharArray();
        for (char c : arr) {
            if (!Character.isDigit(c)) {
                System.out.println("Third arg must be number, please restart application with correct arg.");
                return false;
            }
        }
        return true;
    }

    public boolean isNeedEncode(){
        return args[0].equalsIgnoreCase("encode");
    }
    public boolean isNeedDecode(){
        return args[0].equalsIgnoreCase("decode");
    }

    public boolean isExistDecodedFileWhenEncode(){
        if (!Files.notExists(Path.of(args[1] + "(encoded)"))){
            System.out.println("File is exist with such name as we are creating. " +
                    "Please delete file and then restart application");
            return true;
        }
        return false;
    }


}
