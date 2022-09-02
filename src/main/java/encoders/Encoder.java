package encoders;

import alphabets.Alphabet;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Encoder {
    private int key;
    private Path pathInput;
    private Path pathOutput;


    public Encoder(Path pathInput, int key) {
        this.pathInput = pathInput;
        this.pathOutput = Path.of(pathInput.toString() + "(encoded)");
        this.key = key;
    }

    public void writeEncodeFile(Path pathInput, Path pathOutput, Alphabet alphabet){
        try(BufferedReader reader = new BufferedReader(new FileReader(pathInput.toFile()));
            BufferedWriter writer = new BufferedWriter(new FileWriter(pathOutput.toFile(), true))) {
            while (reader.ready()){
                writer.write(encodeLine(reader.readLine(), alphabet));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String encodeLine(String line, Alphabet alphabet) {
        int shiftInAlphabet = calculateShiftInAlphabetByKey(key, alphabet);
        var stringBuilder = new StringBuilder();
        char[] charArray = line.toCharArray();
        for (char letter : charArray) {
            stringBuilder.append(encodedLetter(letter, alphabet, shiftInAlphabet));
        }
        return stringBuilder.toString();
    }

    public char encodedLetter(char letter, Alphabet alphabet, int shift) {
        int indexNotEncodeLetter;
        if (checkContainsInsideAlphabet(letter, alphabet)) {
            return letter;
        }
        if ((indexNotEncodeLetter = alphabet.listCapitalLetters.indexOf(letter)) != -1) {
            return getEncodedLetterByIndexOfNotEncodedLetter(indexNotEncodeLetter, alphabet.listCapitalLetters, shift);
        } else {
            return getEncodedLetterByIndexOfNotEncodedLetter(indexNotEncodeLetter, alphabet.listLittleLetters, shift);
        }
    }

    private char getEncodedLetterByIndexOfNotEncodedLetter(int indexOfNotEncodedLetter, List<Character> listAlphabet, int shift) {
        int indexEncodeLetter = calculateIndexNewMeaningOfLetter(indexOfNotEncodedLetter, shift,
                listAlphabet.size() - 1);
        return listAlphabet.get(indexEncodeLetter);
    }

    public void createFileForEncoding(Path path) {
        try {
            Files.createFile(Path.of(path.toString() + "(encoded)"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean checkContainsInsideAlphabet(char letter, Alphabet alphabet) {
        return (!alphabet.listCapitalLetters.contains(letter) && !alphabet.listLittleLetters.contains(letter));
    }

    private int calculateIndexNewMeaningOfLetter(int startIndex, int shift, int lastIndex) {
        int result = startIndex + shift;
        if (result > lastIndex) {
            result = result - lastIndex - 1;
        }
        return result;
    }

    private int calculateShiftInAlphabetByKey(int key, Alphabet alphabet) {
        return key % alphabet.getCountOfLetters();
    }
}
