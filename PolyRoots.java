import java.io.*;
import java.util.*;

public class PolyRoots {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String json1 = readFile("data.json");
        String json2 = readFile("data1.json");

        System.out.print("Enter base number: ");
        int userBase = sc.nextInt();

        System.out.println("Checking in data.json...");
        List<Integer> roots1 = extractRootsByBase(json1, userBase);
        if (roots1.isEmpty()) {
            System.out.println("No values found for base " + userBase);
        } else {
            System.out.println("Values for base " + userBase + ": " + roots1);
        }

        System.out.println("\nChecking in data1.json...");
        List<Integer> roots2 = extractRootsByBase(json2, userBase);
        if (roots2.isEmpty()) {
            System.out.println("No values found for base " + userBase);
        } else {
            System.out.println("Values for base " + userBase + ": " + roots2);
        }
    }

    private static List<Integer> extractRootsByBase(String json, int baseInput) {
        List<Integer> roots = new ArrayList<>();
        String[] parts = json.split("\\},");
        for (String part : parts) {
            if (part.contains("\"base\"")) {
                String base = part.replaceAll(".*\"base\"\\s*:\\s*\"(.*?)\".*", "$1");
                String value = part.replaceAll(".*\"value\"\\s*:\\s*\"(.*?)\".*", "$1");
                if (Integer.parseInt(base) == baseInput) {
                    int root = manualBaseToDecimal(value, Integer.parseInt(base));
                    roots.add(root);
                }
            }
        }
        return roots;
    }

    private static int manualBaseToDecimal(String value, int base) {
        int num = 0;
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            int digit;
            if (c >= '0' && c <= '9') digit = c - '0';
            else digit = 10 + (c - 'a');
            num = num * base + digit;
        }
        return num;
    }

    private static String readFile(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }
}
