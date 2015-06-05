package task2;

/**
 * Class for Punctuation symbols creating (all printable symbols except chars)
 * Logic conditions is situated in the SymbolsFactory Class
 * @author Viacheslav Chichin
 * @version 1.0  June 3, 2015.
 */
public class PuncSymbol extends Symbols implements SentenceElement{

    /** Stores Symbol value as Char*/
    private char symbol;

    /** Constructor
     * @param symb - Char for creating Object
     * */
    public PuncSymbol(char symb){
     super(symb);
    }

}


