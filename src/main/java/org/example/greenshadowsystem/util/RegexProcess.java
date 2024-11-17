package org.example.greenshadowsystem.util;

import java.util.regex.Pattern;

public class RegexProcess {
    public static boolean staffIdMatcher(String staffId) {
        String regexForStaffId = "^STAFF-[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$";
        Pattern regexPattern = Pattern.compile(regexForStaffId);
        return regexPattern.matcher(staffId).matches();
    }
    public static boolean userIdMatcher(String userId){
        String regexForUserId = "^USER-[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$";
        Pattern regexPattern = Pattern.compile(regexForUserId);
        return regexPattern.matcher(userId).matches();
    }
}
