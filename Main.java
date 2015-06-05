package task2;

/** Description Main Class
 *  This class launch application for text parsing
 * @author Viacheslav Chichin
 * @version 1.0  June 3, 2015.
 */

public class Main {
    public static void main(String[] args) {
        /** In parametrs need to quote array of words, which is need to find in the text */
        TextParser textParser = new TextParser(new String[]{"in","our", "to", "of", "the" } );

        /** In parametrs need to quote path to file, in which is need to find words */
        textParser.parseForSentences("/home/viacheslav/IdeaProjects/epam/resourses/task2/text.txt");
    }
}
