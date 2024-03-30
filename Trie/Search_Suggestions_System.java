package Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Search_Suggestions_System {
    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        String cur = "";
        List<List<String>> result = new ArrayList<>();
        for (char i : searchWord.toCharArray()) {
            cur += i;
            int index = Arrays.binarySearch(products, cur);
            if (index < 0) {
                index = -index - 1;
            }
            List<String> suggestion = new ArrayList<>();
            for (int j = index; j < index + 3 && j < products.length && products[j].startsWith(cur); j++) {
                suggestion.add(products[j]);
            }
            result.add(suggestion);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = new String[] { "mobile", "mouse", "moneypot", "monitor", "mousepad" };
        System.out.println(suggestedProducts(words, "mouse"));
    }
}
