package task2;


import java.util.ArrayList;
import java.util.List;

/**
 * This class stores Object Word as array of CharSymbol and methods fo work with it
 * @author Viacheslav Chichin
 * @version 1.0  June 3, 2015.
 */
public class Word implements Comparable<Word>, SentenceElement {

    /** stores word as ArrayList of CharSymbol */
    private List<CharSymbol> wordArray;

    /** Overloaded constructors
     * First Constructor - used for general purposes.
     * create new Word object based on array of Charsymbols
     * @param wordArray - previously made array of CharSymbol
     */
    public Word (List<CharSymbol> wordArray){
        this.wordArray = wordArray;
    }

    /** Overloaded constructors
     * Second Constructor - used for creating words, which need to be find in the text
     * create new Word object based on String
     * @param word - String
     */
    public Word(String word) {
        wordArray = new ArrayList<>();
        for (char c :word.toCharArray()) wordArray.add(new CharSymbol(c));
    }

    /**
     * Method for creating string equvalent of Word Object
     * @return - String - value of Word Object
     */
    public String getWord() {
        StringBuilder sb = new StringBuilder();
        for (CharSymbol s : wordArray) sb.append(s.getSymbol());
        return sb.toString();
    }

    /**
     * Overrided method for word sorting in lexicographical order
     * @param anotherWord - word for comparing with the current word
     * @return - int result of comparing value
     */
    @Override
    public int compareTo(Word anotherWord) {
        String word=getWord();
        return word.compareToIgnoreCase(anotherWord.getWord());
    }

    /**
     * Overrided method for word checking equality with another word
     * @param o - word for comparing with the current word
     * @return - boolean result of comparing 2 Words objects
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return (this.getWord()).equalsIgnoreCase(word.getWord());
    }

    /**
     * Method for printing Word Object
     * @return - String - value of Word Object
     */
    @Override
    public String toString() {
        return getWord();
    }

    /**
     * Overrided method for word hash code counting as Key for HashMap
     * @return - int value of string counting
     */
    @Override
    public int hashCode() {
        return (this.getWord()).hashCode();
    }
}
