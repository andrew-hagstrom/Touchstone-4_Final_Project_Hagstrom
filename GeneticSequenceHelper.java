import java.util.Scanner;

public class GeneticSequenceHelper {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        String sequence; 
        String menuOption; 

        while (true) {
            sequence = Home(scanner);
            
            while (true) {
                menuOption = Menu(scanner); 
        
                if (menuOption.equals("1")) {
                    Transcription(sequence);}
                else if (menuOption.equals("2")) {
                    FindComplements(sequence);
            }
                System.out.println("Press 'Enter' to perform another action on the genetic sequence.  Or press 'H' to go to home and enter another genetic sequence.\n");
                input = scanner.nextLine(); 

                if (input.equals("")){
                    continue; 
                } 
                else if (input.equals("H")){
                    break;
                } else {
                    System.out.println("Invalid input. Please press 'Enter' or 'H'\n");
            }
        }
    }
}
    public static String Home(Scanner scanner) {
        String sequence = "";
        while (true) { 
            System.out.println("\nWelcome to the Genetic Sequence Helper.\n");
            System.out.println("Please enter a DNA sequence that you would like to transform: \n"); 

            sequence = scanner.nextLine().toUpperCase();

            if (sequence.matches("[ATCG]+")){
                break; 
            } else {
                System.out.println("Invalid input. Please enter a sequence containing only A, T, C, or G.");
            }
        }
        return sequence; 
    }

    public static String Menu(Scanner scanner) {
        String menuOption="";
        while (true) {
            System.out.println("Select action that you would like to perform on the DNA sequence.\n");
            System.out.println("Press ‘1’ for RNA Transcription, or press ‘2’ for Complements of the sequence.\n"); 
            menuOption = scanner.nextLine(); 

            if (menuOption.equals("1") || menuOption.equals("2")) {
                break; 
            } else {
                 System.out.println("Invalid input. Please enter '1' or '2'.");
            }
        }
        return menuOption; 
    }

    public static void Transcription(String sequence) {
        String rnaSequence = sequence.replace("T", "U");
        System.out.println("\nRNA Transcription: " + rnaSequence + "\n"); 

    }
    
    public static void FindComplements(String sequence) {
        String string_1 = "";
        String string_2 = ""; 

        for (int i = 0; i < sequence.length(); i++) {
            if (sequence.charAt(i) == 'A') {
                string_1 += "T";
            } else if (sequence.charAt(i) == 'T') {
                string_1 += "A";
            } else if (sequence.charAt(i)== 'C') {
                string_1 += "G";
            } else if (sequence.charAt(i) == 'G') {
                string_1 += "C"; 
            }
        }

        for (int i = string_1.length()-1; i >= 0; i--){
            string_2 += string_1.charAt(i); 
        }

        System.out.println("\nComplement: " + string_1); 
        System.out.println("\nReverse Complement: " + string_2 + "\n"); 

    }
}

       
