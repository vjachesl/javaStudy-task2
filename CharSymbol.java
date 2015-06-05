package task2;

/**
 * Class for Char symbols creating (a-z, A-Z, -, ')
 * Logic conditions is situated in the SymbolsFactory Class
 * @author Viacheslav Chichin
 * @version 1.0  June 3, 2015.
 */
public class CharSymbol extends Symbols {

    /** Stores Symbol value as Char*/
    private char symbol;

    /** Constructor
     * @param symb - Char for creating Object
     * */
    public CharSymbol(char symb) {
        super(symb);
    }
}



