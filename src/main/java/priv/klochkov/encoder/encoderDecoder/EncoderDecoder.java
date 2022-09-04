package priv.klochkov.encoder.encoderDecoder;

import priv.klochkov.encoder.alphabets.Alphabet;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public abstract class EncoderDecoder {
    private int key;
    private Path pathInput;


    public EncoderDecoder(Path pathInput, int key) {
        this.pathInput = pathInput;
        this.key = key;
    }

    public void writeEncodeDecodeFile(Alphabet alphabet) {
        Path pathOutput = getPathOutput(pathInput);
        try (BufferedReader reader = new BufferedReader(new FileReader(pathInput.toFile()));
             BufferedWriter writer = new BufferedWriter(new FileWriter(pathOutput.toFile(), true))) {
            while (reader.ready()) {
                String str = reader.readLine();
                str = encodeDecodeLine(str, alphabet);
                writer.write(str + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String encodeDecodeLine(String line, Alphabet alphabet) {
        int shiftInAlphabet = calculateShiftInAlphabetByKey(key, alphabet);
        var stringBuilder = new StringBuilder();
        char[] charArray = line.toCharArray();
        for (char letter : charArray) {
            stringBuilder.append(encodeDecodeLetter(letter, alphabet, shiftInAlphabet));
        }
        return stringBuilder.toString();
    }

    public char encodeDecodeLetter(char letter, Alphabet alphabet, int shift) {
        int indexNotEncodeLetter;
        if (checkContainsInsideAlphabet(letter, alphabet)) {
            return letter;
        }
        if ((indexNotEncodeLetter = alphabet.listCapitalLetters.indexOf(letter)) != -1) {
            return getEncodedDecodedLetterByIndexOfNotEncodedLetter(indexNotEncodeLetter, alphabet.listCapitalLetters, shift);
        } else {
            indexNotEncodeLetter = alphabet.listLittleLetters.indexOf(letter);
            return getEncodedDecodedLetterByIndexOfNotEncodedLetter(indexNotEncodeLetter, alphabet.listLittleLetters, shift);
        }
    }

    private char getEncodedDecodedLetterByIndexOfNotEncodedLetter(int indexOfNotEncodedLetter, List<Character> listAlphabet, int shift) {
        int indexEncodeLetter = calculateIndexNewMeaningOfLetter(indexOfNotEncodedLetter, shift,
                listAlphabet.size() - 1);
        return listAlphabet.get(indexEncodeLetter);
    }

    public void createFileForEncodingDecoding() {
        try {
            Files.createFile(getPathOutput(pathInput));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Path getPathOutput(Path path) {
        if (this instanceof EncoderCesar) {
            path = Path.of(path.toString() + "(encoded)");
        } else if (this instanceof DecoderCesar) {
            path = Path.of(path.toString() + "(decoded)");
        }
        return path;
    }

    private boolean checkContainsInsideAlphabet(char letter, Alphabet alphabet) {
        return (!alphabet.listCapitalLetters.contains(letter) && !alphabet.listLittleLetters.contains(letter));
    }


    private int calculateShiftInAlphabetByKey(int key, Alphabet alphabet) {
        return key % alphabet.getCountOfLetters();
    }

    public abstract int calculateIndexNewMeaningOfLetter(int startIndex, int shift, int lastIndex);

    public Path getPathInput() {
        return pathInput;
    }
}
