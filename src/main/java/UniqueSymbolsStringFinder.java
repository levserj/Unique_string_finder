import java.util.HashSet;

/**
 * Created by Levchynskyi Serhii on 28.09.16.
 * <p/>
 * Method findStringOfUniqueSymbols() takes as an argument input String,
 * and returns substring of the input with only unique symbols,
 * if there is such substring. If not returns "No such substring".
 */
public class UniqueSymbolsStringFinder {

    private HashSet<Character> set = new HashSet<Character>();
    private HashSet<Character> backupSet = new HashSet<Character>();

    /**
     * This method uses HashSet's property "no duplicates" to fetch
     * all unique symbols from the initial String. Then it goes
     * through the string in a loop, looking on every substring with
     * length equal to set's size, comparing their symbols with
     * symbols in the set. To compare them it deletes each symbol
     * from the copy of the set.
     */
    public String findStringOfUniqueSymbols(String inputStr) {
        // Zero length string handle.
        if (inputStr.length() == 0) {
            return "";
        }
        // Fetching unique symbols to set
        char[] chars = inputStr.toCharArray();
        for (char c : chars) {
            set.add(c);
        }
        int setSize = set.size();
        // Loop to go through input string
        for (int i = 0; i < chars.length - setSize; i++) {
            // Making a copy of the set
            backupSet.clear();
            backupSet.addAll(set);
            // Loop to compare every symbol in substring with symbols in the set.
            for (int j = i; j < j + setSize; j++) {
                // If it's impossible to delete symbol from the set(it's already deleted),
                // this isn't the string we are looking for
                if (!backupSet.remove(chars[j])) {
                    break;
                }
                // If all the symbols are deleted - we have our winner
                if (backupSet.size() == 0) {
                    set.clear();
                    return inputStr.substring(i, i + setSize);
                }
            }
        }
        set.clear();
        // If nothing found
        return "No such substring";
    }
}
