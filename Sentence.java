package task2;

import java.util.*;

/**
 * Class stores Sentence as an ArrayList of Words, punctuation symbols and End Of Sentence symbol.
 * @author Viacheslav Chichin
 * @version 1.0  June 3, 2015.
 */
public class Sentence implements Iterable<SentenceElement>  {

    /** This map is used for storing results of finding Words (Key) with quantity Int (Value)
     * this result stores in each sentence */
    private Map<Word, Integer> findedWordsFreq; // stored data for vocalbulary for each sentence;

    /** This arrayList stores all sentense as array of Objects - Words, punctuation symbols and End Of Sentence symbol. */
    private List<SentenceElement> words;

    /**
     * Constructor - returns new empty sentence
     * Also in constructor we need to init map with the words for finding with 0 finded value
     * @param wordsForFinding - words, to be finded in this sentence
     */
    public Sentence(List<Word> wordsForFinding) {
        findedWordsFreq = new HashMap<>();
        for (Word w : wordsForFinding) findedWordsFreq.put(w,0);
        words = new ArrayList<>();
    }

    /**
     * Method for adding new Sentence Object
     * @param elem - Word or PUNC Symbol or End Of Sentence Object - to Be inserted into Sentence
     * @throws IllegalArgumentException in case the Word object is Null
     */
    public void addElement(SentenceElement elem){
        if (elem==null) throw new IllegalArgumentException("The word can't be null");
        words.add(elem);
    }

    /**
     * Method for adding value for words finding as value of Word key
     * @param word - Word object, which was finded in the sentence
     * @return - true, if value was chenged
     */
    public boolean incrementValueForFindedWord(Word word){
       if(findedWordsFreq.containsKey(word)) {
           findedWordsFreq.replace(word,findedWordsFreq.get(word)+1 );
           return true;
       }
        return false;
    }

    /**
     * Method for returning results for words finding process
     * @return - Map with finded words results
     */
    public Map<Word, Integer> returnWordCountingResults (){
        return findedWordsFreq;
    }

    /**
     * Overrided method toString - returns text value of Sentence Object for Unit object
     * @return - String with Sentence object
     */
    @Override
    public String toString() {
        String res = "";
        for (SentenceElement elem : words)
        res = res+elem;
        return res;
    }
    /**
     * Overrided Iterator - returns Iterator for internal array of Objects
     * @return - iterator  for words array
     */
    @Override
    public Iterator<SentenceElement> iterator() {
        return words.iterator();
    }
}
