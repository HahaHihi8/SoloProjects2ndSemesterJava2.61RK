package IPv6Validator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class IPv6_ModelTest {

    private final IPv6_Model model = new IPv6_Model();

    @Test
    void testValidIPv6Addresses() {
        // Gültige IPv6-Adressen
        assertTrue(model.isValidIPv6("2001:0db8:85a3:0000:0000:8a2e:0370:7334"), "Valid IPv6 failed");
        
        
        // RICHTIGER FEHLER FEFUNDEN!!! METHODE ERKENNT KOMPAKTE SCHREIBWEISE NICHT
        assertTrue(model.isValidIPv6("::1"), "Valid IPv6 (::1) failed");
        
        
        assertTrue(model.isValidIPv6("2001:db8::ff00:42:8329"), "Valid IPv6 failed");
    }

    @Test
    void testInvalidIPv6Addresses() {
        // Ungültige IPv6-Adressen
        assertFalse(model.isValidIPv6("2001:0db8:85a3:0000:0000:8a2e:0370"), "Invalid IPv6 passed");
        assertFalse(model.isValidIPv6("12001:db8::ff00:42:8329"), "Invalid IPv6 (extra digit) passed");
        assertFalse(model.isValidIPv6("2001:dg8::ff00:42:8329"), "Invalid IPv6 (g is a non-hex character) passed");
    }

    @Test
    void testEmptyAndNullInput() {
        // Leere Eingabe
        assertFalse(model.isValidIPv6(""), "Empty string passed");
        // Null
        assertFalse(model.isValidIPv6(null), "Null value passed");
    }

    @Test
    void testSegmentLength() {
        // Zu kurze oder zu lange Segmente
        assertFalse(model.isValidIPv6("2001:0db8:85a3::0370:733"), "Short segment passed");
        assertFalse(model.isValidIPv6("2001:0db8:85a3:00000::7334"), "Long segment passed");
    }
}