package task2;

/**
 * Abstract Class for symbols joining purposes.
 * Used for fabric creating different symbols posibility
 * Implements marker interface for adding punctuation symbols as an Object of Sentence
 * @author Viacheslav Chichin
 * @version 1.0  June 3, 2015.
 */
public abstract class Symbols implements SentenceElement {
    private char symbol;

    /**
     * Creates new CharSymbol by the given character.
     * @param symbol the character to be stored
     */
    public Symbols (char symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return ""+symbol;
    }

    /**
     * Returns the stored character.
     * @return the character representation of the CharSymbol
     */
    public char getSymbol() {
        return symbol;
    }
}
