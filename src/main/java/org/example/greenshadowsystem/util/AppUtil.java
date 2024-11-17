package org.example.greenshadowsystem.util;

import java.util.Base64;
import java.util.UUID;

public class AppUtil {
    public static String generateStaffId(){
        return "Staff-"+UUID.randomUUID();
    }

    public static String generateUserId(){
        return "User-"+UUID.randomUUID();
    }
    public static String profilePicToBase64(byte [] profilePic){
        return Base64.getEncoder().encodeToString(profilePic);
    }

}
