package task2;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Class for parsing text and creation all sentences as array of different objects
 * Each sentence can consist the next Objects
 * Words(inside has array of symbols) - as word object
 * Punc symbols - as synbols object
 * EOSSymbol - as end of sentence object
 * @author Viacheslav Chichin
 * @version 1.0  June 3, 2015.
 */
public class TextParser {

    /** Stores all parsed sentences from file as array of objects  */
    private List<Sentence> sentences;

    /** Stores of words for finding in sentence as array of Word Object*/
    private List<Word> wordsForFinding;

    /** Stores the TOTAL result of word finding for all sentences in the text*/
    private Map<Word,Integer> resultMap;

    /**
     * Constructor, which prepares program to work
     * @param words - needs to receive String array of words, which is need to be find in the file.
     */
    public TextParser(String[] words) {
        sentences = new ArrayList<>();
        wordsForFinding = new ArrayList<>();
        resultMap = new HashMap<>();
        for (String word : words){
            wordsForFinding.add(new Word(word));
            resultMap.put(new Word(word),0);
        }
    }

    /**
     * Main method for parsing chars as objects and creating sentences as object
     * As result of working - array of sentences "sentences"
     * @param fileName - String - path to file
     */
    public void parseForSentences(String fileName) {
        String text = ""; // initial text assigning in case of file reading error
        try {
            text = getTextFromFile(fileName);  // get text from file using internal method
        } catch (IOException e) {
            System.out.println("File Not Found Exception");
            return;
        }
        if (text == "" || text == null) {
            System.out.println("Nothing to parse. Terminated");
            return;
        }
        // section for creating sentences as arrays of objects
        Sentence tempSentence = new Sentence(wordsForFinding);
        ArrayList<CharSymbol> tempWord = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {  // all chars in text analysis
            Symbols tempSymbol = SymbolsFactory.create(text.charAt(i)); // receiving object from factory
            // check what need to do with the received symbol
            if (tempSymbol instanceof CharSymbol) tempWord.add((CharSymbol) tempSymbol);
            if (((tempSymbol instanceof NotRedableSymbol || (tempSymbol instanceof PuncSymbol)) && tempWord.size() >= 1)) {
                tempSentence.addElement(new Word(tempWord));
                tempWord = new ArrayList<>();
            }
            if (tempSymbol instanceof PuncSymbol) tempSentence.addElement(tempSymbol);
            if (tempSymbol instanceof EOSSymbol) {
                if (tempWord.size() >= 1) {
                    tempSentence.addElement(new Word(tempWord));
                }
                tempWord = new ArrayList<>();
                tempSentence.addElement(tempSymbol);
                sentences.add(tempSentence);
                tempSentence = new Sentence(wordsForFinding);

            }

        }
        countingWordsinEachSentence(); // counting words using in each sentence
        printingResult();
    }

    /**
     * Method incapsulate working with the source text file
     * @param fileName - String - path to file
     * @return - String - result of reading from the file
     * @throws IOException - in case File Not Found or unexpected error
     */
    private String getTextFromFile(String fileName) throws IOException {
        if (fileName == null || fileName.length() < 1) throw new IllegalArgumentException("Illegial File Name");
        Path file = Paths.get(fileName);
        StringBuilder strBuilder = new StringBuilder();
        try (SeekableByteChannel channel1 = Files.newByteChannel(file)) {
            ByteBuffer buffer = ByteBuffer.allocate(20);
            int read;
            while ((read = channel1.read(buffer)) > 0) {
                strBuilder.append(new String(buffer.array(), 0, read));
                buffer.clear();
            }
        }
        return strBuilder.toString();
    }

    /**
     * Method counts how many times each words from wordsForFinding was found in each sentence
     * and stores result in two places - in sentence for each sentence and ToTAL in the result map
     */
    private void countingWordsinEachSentence(){
        for (Sentence sen : sentences){
            Iterator<SentenceElement> iter = sen.iterator();
            while (iter.hasNext()){
                SentenceElement elem = iter.next();
                if (elem instanceof Word) {
                    for (Word word : wordsForFinding) {
                        if (word.equals(elem)) {
                            sen.incrementValueForFindedWord(word); // adding into sentence data
                            resultMap.replace(word, resultMap.get(word)+1);
                        }
                    }
                }
            }

        }
    }

    /**
     * Method print result of programm working into console - All parsed sentences
     * and result of words finding for each sentence and the total result
     */
    private void printingResult(){
        for (int i=0; i<sentences.size(); i++) {
            System.out.println("=============================================================");
            System.out.println("For "+i+" sentence:");
            System.out.println(sentences.get(i));
            System.out.println("-----------------------------");
            System.out.println(sortByValues(sentences.get(i).returnWordCountingResults()));
         }
        System.out.println();
        System.out.println("TOTAL RESULT=====================================================");
        System.out.println(sortByValues(resultMap));

    }

    /**
     * Method for treMap with words sorting, based on finded quantity decrement
     * @param map - source map for sorting purposed
     * @param <Word> - map Key Object
     * @param <Integer> - map value Object
     * @return - sorted map
     */
    public static <Word, Integer extends Comparable<Integer>> Map<Word, Integer>
    sortByValues(final Map<Word, Integer> map) {
        Comparator<Word> valueComparator =
                new Comparator<Word>() {
                    public int compare(Word k1, Word k2) {
                        int compare =
                                map.get(k2).compareTo(map.get(k1));
                        if (compare == 0)
                            return 1;
                        else
                            return compare;
                    }
                };

        Map<Word, Integer> sortedByValues =
                new TreeMap<Word, Integer>(valueComparator);
        sortedByValues.putAll(map);
        return sortedByValues;
    }

}
