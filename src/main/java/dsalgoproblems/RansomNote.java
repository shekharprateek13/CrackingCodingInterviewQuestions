package dsalgoproblems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 * @author shekh
 * Given the words in the magazine and the words in the ransom note, print Yes if he can replicate his ransom note exactly using whole words from the magazine; 
 * otherwise, print No.
 * 
 * Input Format
 * The first line contains two space-separated integers describing the respective values of (the number of words in the magazine) and (the number of words in the ransom note).
 * The second line contains space-separated strings denoting the words present in the magazine.
 * The third line contains space-separated strings denoting the words present in the ransom note.
 * 
 * Constraints
 * Each word consists of English alphabetic letters (i.e., to and to )..........
 * The words in the note and magazine are case-sensitive...............
 * Output Format
 * Print Yes if he can use the magazine to create an untraceable replica of his ransom note; otherwise, print No.....................
 * Sample Input
 * 6 4
 * give me one grand today night
 * give one grand today
 * Sample Output
 * Yes
 * Explanation
 * All four words needed to write an untraceable replica of the ransom note are present in the magazine, so we print Yes as our answer.
 *
 */
public class RansomNote {
	Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;
    
    public RansomNote(String magazine, String note){
        magazineMap = new HashMap<String,Integer>();
        noteMap = new HashMap<String,Integer>();
        
        if(magazine!=null){
            for(String word:magazine.split(" ")){
                if(magazineMap.containsKey(word)){
                    magazineMap.put(word,magazineMap.get(word)+1);
                }else{
                    magazineMap.put(word,1);
                }
            }
        }
        
        if(note!=null){
            for(String word:note.split(" ")){
                if(noteMap.containsKey(word)){
                    noteMap.put(word,noteMap.get(word)+1);
                }else{
                    noteMap.put(word,1);
                }
            }
        }
    }
    
    public boolean solve() {
        boolean status = true;
        for(String word:noteMap.keySet()){
            int wordFrequency = noteMap.get(word);
            if(magazineMap.containsKey(word)){
                if(wordFrequency > magazineMap.get(word)){
                    status = false;
                    break;
                }
            }else{
                status = false;
                break;
            }
        }
        return status;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        
        // Eat whitespace to beginning of next line
        scanner.nextLine();
        
        RansomNote s = new RansomNote(scanner.nextLine(), scanner.nextLine());
        scanner.close();
        
        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");
      
    }
}
