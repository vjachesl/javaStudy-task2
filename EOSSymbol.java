package task2;

/**
 * Class for End Of Sentence Symbols creating (!, ?, .)
 * Logic conditions is situated in the SymbolsFactory Class
 * @author Viacheslav Chichin
 * @version 1.0  June 3, 2015.
 */
public class EOSSymbol extends CharSymbol {

    /** Stores Symbol value as Char*/
    private char symbol;

    /** Constructor
     * @param symb - Symbol for creating Object
     * */
    public EOSSymbol(char symb){
     super(symb);
    }

}


