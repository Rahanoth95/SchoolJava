

/**
 *
 * @author omora
 */

import java.util.*;

public class Assert {
       
    private static final String ANSI_RED         = "\u001B[31m";
    private static final String ANSI_BLACK       = "\u001B[30m";
    private static final String ANSI_WHITE       = "\u001B[37m";
    private static final String ANSI_BG_RED      = "\u001B[41m";
    private static final String ANSI_BG_GREEN    = "\u001B[42m";
    private static final String ANSI_BG_CYAN     = "\u001B[46m";
    private static final String ANSI_BG_YELLOW   = "\u001B[43m";
    private static final String ANSI_RESET       = "\u001B[0m";
    
// == and != Double
    public static void assertEqualsDouble (double actual, double expected) {
        if (Double.compare(actual, expected) == 0 )
                System.out.println(actualLabel() + actual + equalsInBG() + 
                        expextedlLabel() + expected + " " + pass());
        else
                System.out.println(actualLabel() + actual + doesNotEqualInBG() + 
                        expextedlLabel() + expected + " " + fail());
    }
        
    public static void assertNotEqualsDouble (double actual, double expected) {
        if (Double.compare(actual, expected) != 0 )
                System.out.println(actualLabel() + actual + doesNotEqualInBG() + 
                        expextedlLabel() + expected + " " + pass());
        else
                System.out.println(actualLabel() + actual + equalsInBG() + 
                        expextedlLabel() + expected + " " + fail());
    }
    
    
// == and != Int
    public static void assertEqualsInt (int actual, int expected) {
        if (actual == expected)
                System.out.println(actualLabel() + actual +  equalsInBG() + 
                        expextedlLabel() + expected + " " + pass());
        else
                System.out.println(actualLabel() + actual + doesNotEqualInBG() + 
                        expextedlLabel() + expected + " " + fail());
    }
    
    public static void assertNotEqualsInt (int actual, int expected) {
        if (actual != expected)
                System.out.println(actualLabel() + actual + doesNotEqualInBG() + 
                        expextedlLabel() + expected + " " + pass());
        else
                System.out.println(actualLabel() + actual + equalsInBG() + 
                        expextedlLabel() + expected + " " + fail());
    }
    
    
// == and != Long    
    public static void assertEqualsLong (Long actual, Long expected) {
        if (actual.equals(expected))
                System.out.println(actualLabel() + actual + equalsInBG() + 
                        expextedlLabel() + expected + " " + pass());
        else
                System.out.println(actualLabel() + actual + doesNotEqualInBG() + 
                        expextedlLabel() + expected + " " + fail());
    }
    
    public static void assertNotEqualsLong (Long actual, Long expected) {
        if (!actual.equals(expected))
                System.out.println(actualLabel() + actual + doesNotEqualInBG() + 
                        expextedlLabel() + expected + " " + pass());
        else
                System.out.println(actualLabel() + actual + equalsInBG() + 
                        expextedlLabel() + expected + " " + fail());
    }
    
    
    
// == and != String    
    public static void assertEqualsString(String actual, String expected) {
    if ( actual.equals(expected) )
            System.out.println(actualLabel() + actual + equalsInBG() + 
                    expextedlLabel() + expected + " " + pass());
    else
            System.out.println(actualLabel() + actual + doesNotEqualInBG() + 
                    expextedlLabel() + expected + " " + fail());
    }
    
    public static void assertNotEqualsString(String actual, String expected) {
    if ( !actual.equals(expected) )
            System.out.println(actualLabel() + actual + doesNotEqualInBG() + 
                    expextedlLabel() + expected + " " + pass());
    else
            System.out.println(actualLabel() + actual + equalsInBG() + 
                    expextedlLabel() + expected + " " + fail());
    }
    


// == and != Date    
    public static void assertEqualsDate(Date actual, Date expected) {
    if ( actual.compareTo(expected) == 0 )
            System.out.println(actualLabel() + actual + equalsInBG() + 
                    expextedlLabel() + expected + " " + pass());
    else
            System.out.println(actualLabel() + actual + doesNotEqualInBG() + 
                    expextedlLabel() + expected + " " + fail());
    }
    
    public static void assertNotEqualsDate(Date actual, Date expected) {
    if ( actual.compareTo(expected) != 0 )
            System.out.println(actualLabel() + actual + doesNotEqualInBG() + 
                    expextedlLabel() + expected + " " + pass());
    else
            System.out.println(actualLabel() + actual + equalsInBG() + 
                    expextedlLabel() + expected + " " + fail());
    }
    
  
    
    // == and != UUID    
    public static void assertEqualsUUID(UUID actual, UUID expected) {
    if ( actual.equals(expected) == true )
            System.out.println(actualLabel() + actual + equalsInBG() + 
                    expextedlLabel() + expected + " " + pass());
    else
            System.out.println(actualLabel() + actual + doesNotEqualInBG() + 
                    expextedlLabel() + expected + " " + fail());
    }
    
    public static void assertNotEqualsUUID(UUID actual, UUID expected) {
    if ( actual.equals(expected) == false )
            System.out.println(actualLabel() + actual + doesNotEqualInBG() + 
                    expextedlLabel() + expected + " " + pass());
    else
            System.out.println(actualLabel() + actual + equalsInBG() + 
                    expextedlLabel() + expected + " " + fail());
    }
    
    
    private static String actualLabel() {
        return ("Actual:");
    }
    
    private static String expextedlLabel() {
        return ("Expected:");
    }
    
    private static String equalsInBG() {
        return (" " + ANSI_BG_YELLOW + "equals" + ANSI_RESET + " ");
    }
    
    private static String doesNotEqualInBG() {
        return (" " + ANSI_BG_YELLOW + "does not equal" + ANSI_RESET + " ");
    }
    
    private static String pass() {
        return (" " + ANSI_BLACK + ANSI_BG_GREEN + "PASS" + ANSI_RESET + " ");
    }
    
    private static String fail() {
        return (" " + ANSI_WHITE + ANSI_BG_RED + "FAIL" + ANSI_RESET + " ");
    }
    
}
