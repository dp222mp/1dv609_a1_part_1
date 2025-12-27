package com.lab;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 * Test class for Password implementations.
 * 
 * To test different buggy versions, simply uncomment the corresponding
 * getPassword() method and comment out the others.
 * 
 * Available implementations:
 * - Password: Correct implementation
 * - BugDoesNotTrim: Does not trim whitespace
 * - BugToShortPassword: Allows passwords shorter than 12 characters
 * - BugVeryShort: Allows way to short passwords
 * - BugWrongExceptionMessage: Wrong exception message for short passwords
 * - BugMissingPasswordLengthCheck: Does not throw exception for short passwords
 * - BugMissingNumberCheck: Does not throw exception if password lacks a number
 * - BugIsPasswordSameAlwaysTrue: isPasswordSame always returns true
 * - BugWrongHashingAlgorithm: Wrong hashing algorithm
 */

public class PasswordTest {
    private IPassword getPassword(String s) throws Exception {
        return (IPassword) new Password(s);
        //return (IPassword) new BugDoesNotTrim(s);
        //return (IPassword) new BugToShortPassword(s);
        //return (IPassword) new BugVeryShort(s);
        //return (IPassword) new BugWrongExceptionMessage(s);
        //return (IPassword) new BugMissingPasswordLengthCheck(s);
        //return (IPassword) new BugMissingNumberCheck(s);
        //return (IPassword) new BugIsPasswordSameAlwaysTrue(s);
        //return (IPassword) new BugWrongHashingAlgorithm(s);
    }

    @Test
    public void shouldAlwaysPass() throws Exception {
        assertTrue(true);
    }

    @Test
    public void passwordsShouldIgnoreSurroundingWhitespace() throws Exception {
        IPassword p1 = getPassword("ValidPassword1");
        IPassword p2 = getPassword("   ValidPassword1   ");

        assertTrue(
            p1.isPasswordSame(p2),
            "Whitepace around the password must be ignored for hashing"
        );
    }
    @Test
    public void shouldThrowForPasswordsShorterThan12() throws Exception {
        Exception e1 = assertThrows(
            Exception.class,
            () -> getPassword("eleven11111"), // eleven character password input for BugToShortPassword
            "Passwords shorter than 12 characters should throw an exception"
        );
        Exception e2 = assertThrows(
            Exception.class,
            () -> getPassword("six111"), // six character password input for BugVeryShort
            "Passwords shorter than 12 characters should throw an exception"
        );
    }





}
