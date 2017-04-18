package example_11;

import java.util.Set;

/**
 * Created by jorgeotero on 4/16/17.
 */
public class Systemizer {
    public static void main(String[] args) {
        System.out.printf("This is the Classpath: %s\n", System.getProperty("java.class.path"));
        Set<String> propNames = System.getProperties().stringPropertyNames();
        for (String property : propNames) {
            System.out.printf("%s is %s\n", property, System.getProperty(property));
        }
    }
}