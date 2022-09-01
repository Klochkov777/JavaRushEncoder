import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CreatorAlphabet {

    public void createEnglishAlphabet(List<Character> listCapitalLetters, List<Character> listLittleLetters) {
        listCapitalLetters = createAlphabetCapitalLetters('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
                'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');
        listLittleLetters = createAlphabetNotCapitalLetters('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
                'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
    }


    private List<Character> createAlphabetCapitalLetters (Character ...characters){
        List<Character> result = new ArrayList<>();
        Collections.addAll(result, characters);
        return result;
    }

    private List<Character> createAlphabetNotCapitalLetters (Character ...characters){
        List<Character> result = new ArrayList<>();
        Collections.addAll(result, characters);
        return result;
    }
}
