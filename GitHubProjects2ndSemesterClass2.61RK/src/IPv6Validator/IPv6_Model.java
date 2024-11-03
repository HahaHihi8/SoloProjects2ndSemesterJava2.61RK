package IPv6Validator;

public class IPv6_Model {
	
	//Will contain the logic for validating an IPv6 address
	
	public boolean isValidIPv6(String address) {
		
        // 1. Check for null or empty input
        if (address == null || address.isEmpty()) {
            return false;
        }

        // 2. Split the address into segments by ":"
        String[] segments = address.split(":");

        // 3. IPv6 address should have exactly 8 segments
        if (segments.length != 8) {
            return false;
        }

        // 4. Check each segment
        for (String segment : segments) {
            // Each segment should have 1 to 4 characters
            if (segment.length() < 1 || segment.length() > 4) {
                return false;
            }

            // Check if each character in the segment is a valid hexadecimal digit
            for (char c : segment.toCharArray()) {
                if (!isHexDigit(c)) {
                    return false;
                }
            }
        }

        // If all checks pass, the address is valid
        return true;
    }

    // Hilfsmethode zur Überprüfung, ob ein Zeichen ein Hexadezimalzeichen ist
    private boolean isHexDigit(char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F');
    }
	
	
}
