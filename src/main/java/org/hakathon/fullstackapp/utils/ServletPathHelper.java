package org.hakathon.fullstackapp.utils;

import org.hakathon.fullstackapp.controller.ConcertController;
import org.hakathon.fullstackapp.controller.UserController;

public class ServletPathHelper {

    public static boolean isPathSecured(String path){
        return ConcertController.SECURED_PATHS.contains(path) || UserController.SECURED_PATHS.contains(path);
    }

}
