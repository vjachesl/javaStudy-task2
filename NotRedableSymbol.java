package task2;

/**
 * Class for NOT PRINTABLE symbols creating (EOF, CR, LF)
 * It needs to parser analysys purposes. It didn't save into Sentence object
 * Logic conditions is situated in the SymbolsFactory Class
 * @author Viacheslav Chichin
 * @version 1.0  June 3, 2015.
 */
public class NotRedableSymbol extends Symbols {
    /** Stores Symbol value as Char*/
    private char symbol;

    /** Constructor
     * @param symb - Char for creating Object
     * */
    public NotRedableSymbol(char symb){ super((char)0);
    }

}


