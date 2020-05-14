package org.hakathon.fullstackapp.utils;

import org.hakathon.fullstackapp.controller.ConcertController;
import org.hakathon.fullstackapp.controller.UserController;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ServletPathHelper {

    public static boolean isPathSecured(String path){
        return getSecuredPaths().contains(path);
    }

    public static Collection<String> getSecuredPaths(){
        return Stream.concat(ConcertController.SECURED_PATHS.stream(), UserController.SECURED_PATHS.stream()).collect(Collectors.toList());
    }

}
