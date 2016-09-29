
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by Levchynskyi Serhii on 28.09.16.
 */
public class UniqueSymbolsStringFinderTest {

    private static UniqueSymbolsStringFinder usf;

    @BeforeClass
    public static void init() {
        usf = new UniqueSymbolsStringFinder();
    }

    @Test
    public void givenStringResultsInCorrectOutputString() {
        assertThat(usf.findStringOfUniqueSymbols("abbcdabc"), equalTo("bcda"));
        assertThat(usf.findStringOfUniqueSymbols("cbacdcbc"), equalTo("bacd"));
        assertThat(usf.findStringOfUniqueSymbols("aaabcaaa"), equalTo("abc"));
    }

    @Test
    public void stringWithoutSubStrOfUniqueSymbolsResultsAsExpected() {
        assertThat(usf.findStringOfUniqueSymbols("aabbc"), equalTo("No such substring"));
        assertThat(usf.findStringOfUniqueSymbols("abbcdabcx"), equalTo("No such substring"));
    }

    @Test
    public void emptyStringProcessedCorrectly() {
        assertThat(usf.findStringOfUniqueSymbols(""), equalTo(""));
    }

    @Test
    public void stringConsistOfSameOneSymbolProcessedCorrectly() {
        assertThat(usf.findStringOfUniqueSymbols("aaaaaaaaa"), equalTo("a"));
    }
}
