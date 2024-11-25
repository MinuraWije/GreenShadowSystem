package org.example.greenshadowsystem.util;

import java.util.regex.Pattern;

public class RegexProcess {
    public static boolean staffIdMatcher(String staffId) {
        String regexForStaffId = "^Staff-[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$";
        Pattern regexPattern = Pattern.compile(regexForStaffId);
        return regexPattern.matcher(staffId).matches();
    }
    public static boolean vehicleIdMatcher(String vehicleId){
        String regexForVehicleId = "^Vehicle-[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$";
        Pattern regexPattern = Pattern.compile(regexForVehicleId);
        return regexPattern.matcher(vehicleId).matches();
    }
    public static boolean equipmentIdMatcher(String equipmentId){
        String regexForEquipmentId = "^Equipment-[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$";
        Pattern regexPattern = Pattern.compile(regexForEquipmentId);
        return regexPattern.matcher(equipmentId).matches();
    }
    public static boolean fieldIdMatcher(String fieldId){
        String regexForFieldId = "^Field-[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$";
        Pattern regexPattern = Pattern.compile(regexForFieldId);
        return regexPattern.matcher(fieldId).matches();
    }
    public static boolean logIdMatcher(String logId){
        String regexForLogId = "^Log-[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$";
        Pattern regexPattern = Pattern.compile(regexForLogId);
        return regexPattern.matcher(logId).matches();
    }
    public static boolean cropIdMatcher(String cropId){
        String regexForCropId = "^Crop-[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$";
        Pattern regexPattern = Pattern.compile(regexForCropId);
        return regexPattern.matcher(cropId).matches();
    }
}
