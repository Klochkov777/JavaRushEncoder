import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Encoder {
    private int key;
    private Path pathInput;
    private Path pathOutput;


    public Encoder(Path pathInput ,int key) {
        this.pathInput = pathInput;
        this.pathOutput = Path.of(pathInput.toString() + "(encoded)");
        this.key = key;
    }

    public String encodeLine(String line, Alphabet alphabet){
        int shiftInAlphabet = key % alphabet.countOfLetters;
        var stringBuilder = new StringBuilder();
        char[] charArray = line.toCharArray();
        for (char letter : charArray) {
            int indexNotEncodedLetter = findIndexOfBigLetter(letter, alphabet.listCapitalLetters);
            if (indexNotEncodedLetter != -1) {
                int indexEncodedLetter = calculateIndexNewMeaningOfLetter(indexNotEncodedLetter, shiftInAlphabet,
                        alphabet.listCapitalLetters.size() -1);
                char meaningNewLetter = alphabet.listCapitalLetters.get(indexEncodedLetter);
                stringBuilder.append(meaningNewLetter);
            } else

            }

        }




            return new String();
    }

    public void createFileEncodedEndedDecoded(Path path){
        try {
            Files.createFile(Path.of(path.toString() + "(encoded)"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private int calculateIndexNewMeaningOfLetter(int startIndex, int shift, int lastIndex){
        int result = startIndex + shift;
        if (result > lastIndex){
            result = result - lastIndex;
        }
        return result;
    }

    //if method does not find index inside list it will return -1
    private int findIndexOfBigLetter(char letter, List<Character> listCapitalLetters){
        return listCapitalLetters.indexOf(letter);
    }

    //if method does not find index inside list it will return -1
    private int findIndexOfLittleLetter(char letter, List<Character> listLittleLetters){
        return listLittleLetters.indexOf(letter);
    }







}
