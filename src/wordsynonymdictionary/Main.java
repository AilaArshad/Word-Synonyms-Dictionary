package wordsynonymdictionary;

import java.util.*;

public class Main {

    private static HashMap<String, List> dictionary;
    private static Scanner input;

    static {
        dictionary = new HashMap<>();
        input = new Scanner(System.in);
    }

    public static void main(String[] args) {
        int choosedvalue = 0;
        boolean exitProgram = false;
        while (!exitProgram) {
            boolean validInput = false;
            while (!validInput) {
                try {
                    mainMenu();
                    System.out.println("Choose any Number: ");
                    choosedvalue = input.nextInt();
                    input.nextLine();
                    validInput = true;
                } catch (Exception e) {
                    System.out.println("Invalid input. Please try again.");
                    input.nextLine();
                }
            }

            switch (choosedvalue) {
                case 1: {
                    System.out.println("\n\n\n*************** Add Word and Synonyms*****************");
                    System.out.println("Add word: ");
                    String word = input.nextLine();
                    List<String> synonyms = new ArrayList<>();
                    System.out.println("How many synonyms of " + word + " you want to add?");
                    int num = input.nextInt();
                    input.nextLine();
                    System.out.println("Enter " + num + " synonyms of " + word);
                    for (int i = 0; i < num; i++) {
                        synonyms.add(input.nextLine());
                    }
                    if (addWord(word.toLowerCase(), synonyms)) {
                        System.out.println("Added successfully!\n\n");
                    } else {
                        System.out.println("Problem adding word and its synonyms\n\n");
                    }
                    break;
                }
                case 2: {
                    System.out.println("\n\n\n*************** Delete Word and Synonyms*****************");
                    System.out.println("Enter word to delete: ");
                    String word = input.nextLine();
                    if (deleteWord(word)) {
                        System.out.println("Deleted successfully!\n\n");
                    } else {
                        System.out.println("Problem deleting word and its synonyms\n\n");
                    }
                    break;
                }
                case 3: {
                    System.out.println("\n\n\n*************** Update Synonyms of word*****************");
                    System.out.println("Enter word: ");
                    String word = input.nextLine();
                    List<String> synonyms = new ArrayList<>();
                    System.out.println("How many synonyms of " + word + " you want to now?");
                    int num = input.nextInt();
                    input.nextLine();
                    System.out.println("Enter " + num + " new synonyms of " + word);
                    for (int i = 0; i < num; i++) {
                        synonyms.add(input.nextLine());
                    }
                    if (updateWord(word, synonyms)) {
                        System.out.println("Updated successfully!\n\n");
                    } else {
                        System.out.println("Problem updating word and its synonyms\n\n");
                    }
                    break;
                }
                case 4: {
                    System.out.println("\n\n\n*************** Search Word and its Synonyms*****************");
                    System.out.println("Enter word to search: ");
                    String word = input.nextLine();
                    List<String> value = searchWord(word);
                    if (value != null) {
                        System.out.println("Synonyms of word " + word + " are: ");
                        for (int i = 0; i < value.size(); i++) {
                            System.out.println(value.get(i));
                        }
                        System.out.println("\n\n");
                    } else {
                        System.out.println("Word not found\n\n");
                    }
                    break;
                }
                case 5: {
                    System.out.println("\n\n\n*************** All words of dictionary*****************");
                    if (dictionary.isEmpty()) {
                        System.out.println("Nothing in dictionary\n\n");
                    } else {
                        printAll();
                        System.out.println("\n\n");
                    }
                    break;
                }
                case 6: {
                    System.out.println("Exiting program.");
                    exitProgram = true;
                    break;
                }
                default: {
                    System.out.println("Invalid input. Please try again.\n\n");
                }
            }
        }
    }

    private static boolean addWord(String word, List synonyms) {
        if (word != null && synonyms != null) {
            dictionary.put(word, synonyms);
            return true;
        }
        return false;
    }

    private static boolean deleteWord(String word) {
        if (dictionary.remove(word.toLowerCase()) != null) {
            return true;
        }
        return false;
    }

    private static boolean updateWord(String word, List newSynonyms) {
        if (dictionary.containsKey(word.toLowerCase())) {
            dictionary.replace(word, newSynonyms);
            return true;
        }
        return false;
    }

    private static List searchWord(String word) {
        if (dictionary.containsKey(word.toLowerCase())) {
            return dictionary.get(word.toLowerCase());
        }
        return null;
    }

    private static void printAll() {
        dictionary.forEach((w, l) -> {
            System.out.println(w);  
            System.out.println(String.join(", ", l));  
            System.out.println();  
        });
    }

    private static void mainMenu() {
        String menu = "1. Add Word and its Synonyms"
                + "\n2. Delete Word with its Synonyms"
                + "\n3. Update Synonyms of word"
                + "\n4. Search word"
                + "\n5. Print all Words with its synonyms"
                + "\n6. Exit";

        System.out.println(menu);
    }

}
