package extra_features;

/**
 * The {@code NameFormatter} class provides utilities for formatting names. This
 * class includes methods to standardize the format of personal or
 * organizational names. For example, it can be used to ensure that names are
 * properly capitalized.
 *
 * @author Kein Bermejo
 */
public class NameFormatter {

    /**
     * Formats a given name string by trimming leading and trailing spaces,
     * replacing multiple spaces with a single space, and capitalizing the first
     * letter of each word while making the rest of the letters lowercase.
     *
     * For example, " john DOE " will be formatted as "John Doe".
     *
     * @param name The name string to be formatted.
     * @return A formatted name string with proper capitalization and spacing.
     */
    public static String formatName(String name) {
        name = name.trim();
        name = name.replaceAll("\\s+", " ");
        String[] words = name.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (!words[i].isEmpty()) {
                words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
            }
        }
        return String.join(" ", words);
    }
}