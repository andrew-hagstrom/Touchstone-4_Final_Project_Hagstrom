import java.util.Scanner; //import Scanner from java utilities

public class GeneticSequenceAssistant { //public class declared for my program

    public static void main(String[] args) { //main program. This is the entry point of the program. It is static, meaning that it belongs to the class as a whole rather than to an instance of the class. It is void because it does not return anything. Takes in strings for arguments. 
        Scanner scanner = new Scanner(System.in); //scanner declared for the entire class.
        String input = ""; //input from scanner declared as a string.
        String sequence; //sequence declared as a string for entire class.
        String menuOption; //menuOption declared as a string for entire class. 

        while (true) { //outer loop begins
            sequence = Home(scanner); //Home method is called, and returned value is assigned to "sequence." The scanner is fed into the method.
            
            while (true) { //inner loop begins
                menuOption = Menu(scanner); //Menu() method is called, and returned value is assigned to "menuOption."
        
                if (menuOption.equals("1")) { //Transcription method called if option is 1, and the sequence input by the user is fed into the method. 
                    Transcription(sequence);}
                else if (menuOption.equals("2")) {//FindComplements method is called if option is 2, and the sequence input by the user is fed into the method. 
                    FindComplements(sequence);
            }
                System.out.println("Press 'Enter' to perform another action on the genetic sequence.  Or press 'H' to go to home and enter another genetic sequence.\n"); //Follow on actions
                input = scanner.nextLine(); //user input is picked up by the scanner. 

                if (input.equals("")){ //if user presses "enter", the inner loop continues. 
                    continue; 
                } 
                else if (input.equalsIgnoreCase("H")){//if user presses "H" or "h", the program breaks out of inner loop and reenters outer loop. 
                    break;
                } else {
                    System.out.println("Invalid input. Please press 'Enter' or 'H'\n"); //If user enters anything other than "Enter" or "H/h", he is reprompted for input. 
            }
        }
    }
}
    public static String Home(Scanner scanner) {//Home method. Static because belongs to class. It returns a string. And the input is scanner. 
        String sequence = ""; //sequence input is declared to be a string. 
        while (true) { //loop continues until break. 
            System.out.println("\nWelcome to the Genetic Sequence Helper.\n");
            System.out.println("Please enter a DNA sequence that you would like to transform: \n"); 

            sequence = scanner.nextLine().toUpperCase(); //User input transformed into upper case. 

            if (sequence.matches("[ATCG]+")){
                break; //if user input is A, T, C, or G, or any combination thereof, the loop is broken, and the sequence is returned. 
            } else { //Otherwise, loop continues until there is a valid entry. 
                System.out.println("Invalid input. Please enter a sequence containing only A, T, C, or G.");
            }
        }
        return sequence; //The user input is returned to the main program. 
    }

    public static String Menu(Scanner scanner) { //Menu method begins. Static because belongs to class. Returns a string. Input is scanner. 
        String menuOption=""; //The user's input is declared as a string. 
        while (true) { //loop continues until valid entry, when it will break. 
            System.out.println("Select action that you would like to perform on the DNA sequence.\n");
            System.out.println("Press ‘1’ for RNA Transcription, or press ‘2’ for Complements of the sequence.\n"); 
            menuOption = scanner.nextLine(); //User input picked up by scanner. 

            if (menuOption.equals("1") || menuOption.equals("2")) {
                break; //The loop will break, and menuOption will be returned if user input is "1" or "2".
            } else { //Otherwise, the loop continues, and user continues to be reprompted. 
                 System.out.println("Invalid input. Please enter '1' or '2'.");
            }
        }
        return menuOption; //Menu option returned to main program. 
    }

    public static void Transcription(String sequence) { //Transcription method begins. Static because belongs to class. Void because nothing returned. Input is the sequence string entered by user. 
        String rnaSequence = sequence.replace("T", "U"); //All T's in the sequence entered by the user are replaced by "U's."
        System.out.println("\nRNA Transcription: " + rnaSequence + "\n"); //The result is printed to the console. 

    }
    
    public static void FindComplements(String sequence) { //FindComplements method begins. Static because belongs to class. Void because nothing returned. Input is the sequence string entered by user. 
        String string_1 = ""; //Strings are declared. String_1 will be complement. 
        String string_2 = ""; //String_2 will be reverse complement. 

        for (int i = 0; i < sequence.length(); i++) { //Loop to form the complement begins. 
            if (sequence.charAt(i) == 'A') { //"A" replaced with "T."
                string_1 += "T";
            } else if (sequence.charAt(i) == 'T') { //"T" replaced with "A."
                string_1 += "A";
            } else if (sequence.charAt(i)== 'C') { //"C" replaced with "G."
                string_1 += "G";
            } else if (sequence.charAt(i) == 'G') { //"G" replaced with "C."
                string_1 += "C"; 
            }
        }

        for (int i = string_1.length()-1; i >= 0; i--){ //String_2, the reverse complement, is simply formed by looping through complement in reverse and concatenating a new string. 
            string_2 += string_1.charAt(i); 
        }

        System.out.println("\nComplement: " + string_1); //Both strings are printed. 
        System.out.println("\nReverse Complement: " + string_2 + "\n"); 

    }
}

