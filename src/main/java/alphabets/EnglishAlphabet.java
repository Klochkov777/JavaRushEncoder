package alphabets;

import alphabets.Alphabet;

import java.util.ArrayList;
import java.util.Arrays;

public class EnglishAlphabet extends Alphabet {

    public EnglishAlphabet() {
        super.listCapitalLetters = new ArrayList<>(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
            'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'));
        super.listLittleLetters = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
                'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));
        super.setCountOfLetters(26);
    }

}
