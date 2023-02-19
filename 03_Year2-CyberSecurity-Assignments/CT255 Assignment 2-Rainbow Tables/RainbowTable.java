
/*  CT255 Assignment 2
 *  This class provides functionality to build rainbow tables (with a different reduction function per round) for 8 character long strings, which
    consist of the symbols "a .. z", "A .. Z", "0 .. 9", "!" and "#" (64 symbols in total).
    Properly used, it creates the following value pairs (start value - end value) after 10,000 iterations of hashFunction() and reductionFunction():
          start value  -  end value
          Kermit12        lsXcRAuN
          Modulus!        L2rEsY8h
          Pigtail1        R0NoLf0w
          GalwayNo        9PZjwF5c
          Trumpets        !oeHRZpK
          HelloPat        dkMPG7!U
          pinky##!        eDx58HRq
          01!19!56        vJ90ePjV

                  rLtVvpQS
          036abgH#        klQ6IeQJ
          
          
 *
 * @author Michael Schukat
 * @version 1.0
 */
public class RainbowTable
{
    /**
     * Constructor, not needed for this assignment
     */
    public RainbowTable() {

    }

    public static void main(String[] args) {
		long res = 0;
		int i;
		String start;

		if (args != null && args.length > 0) { // Check for <input> value
			start = args[0];
				
			if (start.length() != 8) {
				System.out.println("Input " + start + " must be 8 characters long - Exit");
			}
			else {
                //Long array with given hash values in problem 2.
                long[] matches = new long[]{895210601874431214L, 750105908431234638L, 111111111115664932L,
                        977984261343652499L};
                long hashGen;
                //Passed value passed into the program is assigned as the first value
                String stringGen = start;
                //For loop is used to search and iterate over each password hash.
                for(int matchIndex=0; matchIndex<4; matchIndex++) {
                    System.out.println("\nStart value pair: "+stringGen);
                    System.out.println("Searching for "+matches[matchIndex]);
                    for (i = 0; i < 10000; i++) {
                        hashGen = (hashFunction(stringGen));
                        //If a generated hash is found to be the same as the given hash value thats being searched for, inform
                        //the user
                        if (hashGen == matches[matchIndex]) {
                            //The password that matches the given hash value is printed to the screen.
                            System.out.println("\nHash: " + matches[matchIndex] + " found!\nChain element match: " + stringGen+"\n");
                        }
                        //The loop continues searching for more matches
                        //The reduction function is run 10000 times, and the rounding value is also incremented (Starts at 0)
                        stringGen = reductionFunction(hashGen, i);
                    }
                    //String chain is reset and loop starts again to look for matches with the next hash value
                    //End value is printed to the screen
                    System.out.println("End value pair after 10000 iterations: "+stringGen);
                    stringGen = start;
                }
            }
		}
		else { // No <input> 
			System.out.println("Use: RainbowTable <Input>");
		} 
	}
        
    private static long hashFunction(String s){
        long ret = 0;
        int i;
        long[] hashA = new long[]{1, 1, 1, 1};
        
        String filler, sIn;
        
        int DIV = 65536;
        
        filler = new String("ABCDEFGHABCDEFGHABCDEFGHABCDEFGHABCDEFGHABCDEFGHABCDEFGHABCDEFGH");
        
        sIn = s + filler; // Add characters, now have "<input>HABCDEF..."
        sIn = sIn.substring(0, 64); // // Limit string to first 64 characters

        for (i = 0; i < sIn.length(); i++) {
            char byPos = sIn.charAt(i); // get i'th character
            hashA[0] += (byPos * 17111); // Note: A += B means A = A + B
            hashA[1] += (hashA[0] + byPos * 31349);
            hashA[2] += (hashA[1] - byPos * 101302);
            hashA[3] += (byPos * 79001);
        } 
           
        ret = (hashA[0] + hashA[2]) + (hashA[1] * hashA[3]);
        if (ret < 0) ret *= -1;
        return ret;
    } 
    
    private static String reductionFunction(long val, int round) {  // Note that for the first function call "round" has to be 0, 
        String car, out;                                            // and has to be incremented by one with every subsequent call. 
        int i;                                                      // I.e. "round" created variations of the reduction function.
        char dat;                                                  
        
        car = new String("0123456789ABCDEFGHIJKLMNOPQRSTUNVXYZabcdefghijklmnopqrstuvwxyz!#");
        out = new String("");
      
        for (i = 0; i < 8; i++) {
            val -= round;
            dat = (char) (val % 63);
            val = val / 83;
            out = out + car.charAt(dat);
        }
        
        return out;
    }
}
