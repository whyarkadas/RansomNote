
import java.util.*;



public class RansomNote {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }


        Hashtable<String, Integer> magazine_hash_table = new Hashtable<String, Integer>();

        int value =0;

        for(int i=0; i<magazine.length; i++){

            if(magazine_hash_table.containsKey(magazine[i])) {
                value = magazine_hash_table.get(magazine[i]);
                magazine_hash_table.put(magazine[i], value+1);
            }
            else
                magazine_hash_table.put(magazine[i], 1);
        }

        String[] ransom = new String[n];

        String[] ransomItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String ransomItem = ransomItems[i];
            ransom[i] = ransomItem;
        }

        scanner.close();

        boolean is_ransom_note_possible = true;

        for(int i=0; i<ransom.length; i++)
        {
            if (magazine_hash_table.containsKey(ransom[i])) {

                value = magazine_hash_table.get(ransom[i]);

                if(value ==1)
                    magazine_hash_table.remove(ransom[i]);
                else
                    magazine_hash_table.put(ransom[i], value -1);
            }
            else {
                is_ransom_note_possible = false;
                System.out.println("No");
                return;
            }

        }

        System.out.println("Yes");
    }
}
