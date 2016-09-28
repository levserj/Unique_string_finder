import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * Created by Levchynskyi Serhii on 28.09.16.
 */
public class UniqueSymbolsStringFinder {

    private HashSet<Character> set = new HashSet<Character>();
    private HashSet<Character> backupSet = new HashSet<Character>();

    public String findStringOfUniqueSymbols(String inputStr){
        char [] chars = inputStr.toCharArray();
        for (char c : chars){
            set.add(c);
        }

        for (int i=0; i<chars.length-set.size(); i++){
            backupSet.addAll(set);
            for (int j= i; j<j+set.size(); j++){
                if (!backupSet.remove(chars[j])){
                    break;
                }
                if (backupSet.size()==0){
                    return inputStr.substring(i, i+set.size());
                }

            }

            backupSet.clear();
        }
        return "No such substring";
    }
}
