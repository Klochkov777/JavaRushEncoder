package alphabets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Alphabet {
    public List<Character> listCapitalLetters;
    public List<Character> listLittleLetters;
    private int countOfLetters;
    public int getCountOfLetters() {
        return countOfLetters;
    }

    public void setCountOfLetters(int countOfLetters) {
        this.countOfLetters = countOfLetters;
    }
//    private List<Character> createRightOrderAlphabetCapitalLetters(Character... characters) {
//        List<Character> result = new ArrayList<>();
//        Collections.addAll(result, characters);
//        return result;
//    }
//
//    private List<Character> createRightOrderAlphabetNotCapitalLetters(Character... characters) {
//        List<Character> result = new ArrayList<>();
//        Collections.addAll(result, characters);
//        return result;
//    }
}
