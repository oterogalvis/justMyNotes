package example09;

import example09.com.teamtreehouse.Treet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jorgeotero on 3/4/17.
 */
public class LearningMaps {
    private Map<String, String> acronyms = new HashMap<String, String>();

    public void addingToMap() {
        acronyms.put("yagni", "You ain't gonna need it.");
        acronyms.put("dry", "Don't repeat yourself.");
        acronyms.put("yolo", "You only live once.");
    }

    public void askingToMap() {
        acronyms.containsKey("kiss");
        acronyms.containsKey("yolo");
        acronyms.containsValue("whatever");
        acronyms.containsValue("Don't repeat yourself.");
    }

    public void removeFromMap() {
        acronyms.remove("yolo");
    }

    public void getKeysFromMap() {
        acronyms.keySet();
    }

    public void iterateByEach() {
        for (Map.Entry entry : acronyms.entrySet()) {
            System.out.printf("%s stants for %s\n", entry.getKey(), entry.getValue());
        }
    }

    public void countingHashtagWithMap(List<Treet> treets) {
        Map<String, Integer> hashtagCounts = new HashMap<String, Integer>();
        for (Treet treet : treets) {
            for (String hashtag : treet.getHashTags()) {
                Integer count = hashtagCounts.get(hashtag);
                if (count == null) {
                    count = 0;
                }
                count++;
                hashtagCounts.put(hashtag, count);
            }
        }
        System.out.printf("HashTag counts: %s %n", hashtagCounts);
    }


    public void countingAuthorsWithMaps(List<Treet> treets) {
        Map<String, List<Treet>> treetsByAuthor = new HashMap<String, List<Treet>>();
        for (Treet treet : treets) {
            List<Treet> authoredTreets = treetsByAuthor.get(treet.getAuthor());
            if (authoredTreets == null) {
                authoredTreets = new ArrayList<Treet>();
                treetsByAuthor.put(treet.getAuthor(), authoredTreets);
            }
            authoredTreets.add(treet);
        }
        System.out.printf("Treets by author: %s%n", treetsByAuthor);
        System.out.printf("Treets by Gandalf: %s%n", treetsByAuthor.get("Gandalf"));
    }
}
