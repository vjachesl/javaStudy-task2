package task2;

/**
 * Class, which store static method for creating different Symbols, based on internal logic
 * @author Viacheslav Chichin
 * @version 1.0  June 3, 2015.
 */
public class SymbolsFactory {

    /** stores previous operated char for double spaces removing option */
    private static char previousSymbol=(char)0;

    /**
     * Public static method for creating different Symbols, based on internal logic
     * @param symbol - char for creating Symbols object
     * @return one of symbols child - CharSymbol - PuncSymbol - NotRedableSymbol -  EOSSymbol
     */
    public static Symbols create(char symbol) {
        if ((previousSymbol ==' ' && symbol == ' ') || // remove double spaces
                (byte)symbol<=31) return new NotRedableSymbol((char)0);   // check for codes like EOF, TAB, CR, LF
        previousSymbol = symbol;
        if (endOfSentenceSymbol(symbol)) return new EOSSymbol(symbol);
        if (charSymbol(symbol)) return new CharSymbol(symbol);
        return new PuncSymbol(symbol);
    }

    /**
     * Private method checks if the parametr regular char or not
     * @param symbol - char for analysis
     * @return true if char is regular char from Alphabet
     */
    private static boolean charSymbol(char symbol) {
        if (symbol >= 'a' && symbol <= 'z' ||
                symbol >= 'A' && symbol <= 'Z' ||
                symbol >= '0' && symbol <= '9' ||
                symbol == '-' || (byte)symbol==96) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Private method checks if the parametr end of sentence char or not
     * @param symbol - char for analysis
     * @return true if char is end of sentence char
     */
    private static boolean endOfSentenceSymbol(char symbol) {
        if (symbol == '.' || symbol == '?' || symbol == '!') return true;
        return false;
    }



}
