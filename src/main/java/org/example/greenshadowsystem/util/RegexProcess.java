package org.example.greenshadowsystem.util;

import java.util.regex.Pattern;

public class RegexProcess {
    public static boolean staffIdMatcher(String staffId) {
        String regexForStaffId = "^STAFF-[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$";
        Pattern regexPattern = Pattern.compile(regexForStaffId);
        return regexPattern.matcher(staffId).matches();
    }
    public static boolean vehicleIdMatcher(String vehicleId){
        String regexForVehicleId = "^VEHICLE-[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$";
        Pattern regexPattern = Pattern.compile(regexForVehicleId);
        return regexPattern.matcher(vehicleId).matches();
    }
}
