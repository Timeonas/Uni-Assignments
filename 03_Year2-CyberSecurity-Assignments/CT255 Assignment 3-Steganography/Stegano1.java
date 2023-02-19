
/**
 * CT255 - Assignment 3
 * Skeleton code for Steganography assignment.
 *
 * @author Michael Schukat 
 * @version 1.0
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Stegano1
{
    /**
     * Constructor for objects of class Stegano1
     */
    public Stegano1()
    {
    }

    public static void main(String[] args) {
        String arg1, arg2, arg3, arg4;
        Boolean err = false;
        
        if (args != null && args.length > 1) { // Check for minimum number of arguments
            arg1 = args[0];
            arg2 = args[1];
                
            if (arg2 == "") {
                err = true;
            }
            //"==" was changed to equals
            else if ((arg1.equals("A")) && (args.length > 3)){
                // Get other arguments
                arg3 = args[2];
                arg4 = args[3];
                if (arg3 == "" || arg4 == "") {
                    err = true;
                }
                else {
                    // Hide bitstring
                    hide(arg2, arg3, arg4);
                }
            }
            else if (arg1.equals("E")){
                // Extract bitstring from text   
                retrieve(arg2);   
            }
            else {
                err = true;
            }
        }
        else {
            err = true;
        }
        
        if (err == true) {
            System.out.println();
            System.out.println("Use: Stegano1 <A:E><Input File><OutputFile><Bitstring>");
            System.out.println("Example: Stegano1 A inp.txt out.txt 0010101");
            System.out.println("Example: Stegano1 E inp.txt");
            
        } 
    }
    
    static void hide(String inpFile, String outFile, String binString) {
        // 
        BufferedReader reader;
        BufferedWriter writer;
	
        try {
            reader = new BufferedReader(new FileReader(inpFile));
            writer = new BufferedWriter(new FileWriter(outFile));
            String line = reader.readLine();
            //binString index is declared before loop
            int i = 0;
            //Appending a 0 bit to the bitvector if the input bitvector length is odd
            if(binString.length()%2==1){
                binString = binString.concat("0");
            }
            //While loop ensures that no more bits than the available lines are written
            while (line != null) {
                //Ensures that the index variable doesnt exceed length of bit message
                if(i<binString.length()) {
                    if (binString.charAt(i) == '0') {
                        //Single space is concatenated at the end of the line
                        line = line.concat(" ");
                    }
                    else if (binString.charAt(i) == '1') {
                        //Two spaces are concatenated at the end of the line
                        line = line.concat("  ");
                    }
                    //Move to the second bit
                    i++;
                    //First bit was hidden, now the second bit
                    //The second bit will be hidden using the tab escape character "\t"
                    if (binString.charAt(i) == '0') {
                        //A hidden escape character tab will be appended
                        line = line.concat("\t");
                    }
                    else if (binString.charAt(i) == '1') {
                        //Two stabs are concatenated at the end of the line
                        line = line.concat("\t\t");
                    }
                    //Proceed to the next pair of bits
                    i++;
                }
                // Store amended line in output file
                writer.write(line);
		        // read next line
		        line = reader.readLine();
                //If the next line is not null, print a newline "\n" to file for the next line to be amended
                if (line != null) {
                    writer.newLine();
                }
            }
            reader.close();
            writer.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}

    }
    static void retrieve(String inpFile) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(inpFile));
            String line = reader.readLine();
            //Keep looping until all lines in text file have been looped through
            while (line != null) {
                //First, the line is checked to see if it contains anything
                //and if the final character in the current line is a tab escape character
                //If there are secret bits hidden at the end of the line, the last character will always be a tab character
                //This is done to prevent errors associated with using charAt()
                //If a tab can't be found, it continues looping to the next line without doing any checks
                if(line.length()>0 && line.charAt((line.length())-1) == '\t') {
                    for(int i = 4; i>1; i--){
                        //This loop is used to search for space characters (which represent the first secret bit)
                        //A space character can exist within the 4th last character and the 2nd last character
                        //i.e. between two spaces followed by two tabs or one space followed by one tab
                        if(line.charAt((line.length()) - i) == ' ') {
                            //If a space character is found, the character before it is also checked
                            if (line.charAt((line.length()) - (i-1)) == ' '){
                                //If two spaces side by side are found, a 1 is printed to the console
                                System.out.print("1");
                                break;
                            }
                            else
                                //Else, if only a single space is present, a 0 is printed and the loop finishes
                                System.out.print("0");
                            break;
                        }
                    }
                //Looking for tab escape characters
                    //This loop works similarly to the previous loop
                    //Instead, only the last two characters of the line are checked
                    //This is where the tabs will be present
                    for(int i = 2; i>0; i--){
                        if(line.charAt((line.length()) - i) == '\t') {
                            //If a tab is found, and is not located at the very end of the line,
                            //the next last character is checked to see if its also a tab escape character.
                            if (i != 1 && line.charAt((line.length()) - (i-1)) == '\t'){
                                //If two tabs are side by side print 1 to the console
                                System.out.print("1");
                                break;
                            }
                            else
                                //Else, if only one tab is on its lonesome, it must be a 0
                                System.out.print("0");
                            break;
                        }
                    }
                }
		        // read next line
		        line = reader.readLine();
            }
            reader.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}

    }
}
