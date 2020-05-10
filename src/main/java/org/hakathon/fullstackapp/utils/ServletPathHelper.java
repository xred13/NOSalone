package org.hakathon.fullstackapp.utils;

import org.hakathon.fullstackapp.controller.ConcertController;

public class ServletPathHelper {

    public static boolean isPathSecured(String path){
        return ConcertController.SECURED_PATHS.contains(path);
    }

}
