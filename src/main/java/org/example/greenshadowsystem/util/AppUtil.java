package org.example.greenshadowsystem.util;

import java.util.Base64;
import java.util.UUID;

public class AppUtil {
    public static String generateStaffId(){
        return "Staff-"+UUID.randomUUID();
    }
    public static String generateVehicleId(){
        return "Vehicle-"+UUID.randomUUID();
    }
    public static String generateEquipmentId(){return "Equipment-"+UUID.randomUUID();}
    public static String generateFieldId(){return "Field-"+UUID.randomUUID();}
    public static String generateLogId(){return "Log-"+UUID.randomUUID();}
    public static String generateCropId(){return "Crop-"+UUID.randomUUID();}
    public static String profilePicToBase64(byte [] profilePic){
        return Base64.getEncoder().encodeToString(profilePic);
    }

}
