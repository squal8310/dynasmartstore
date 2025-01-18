package org.surfdynamic.dynamocrud.utils;

import java.util.UUID;

public class UtilsDto {

    public static String getNumberId(){
        return UUID.randomUUID().toString();
    }
}
