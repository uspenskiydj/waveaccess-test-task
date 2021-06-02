package com.waveaccess.waveaccesstesttask.util;

import com.waveaccess.waveaccesstesttask.util.exception.NotFoundException;

public class ValidationUtil {

    public static <T> T checkNotFoundWithId(T object, Integer id) {
        checkNotFoundWithId(object != null, id);
        return object;
    }

    public static void checkNotFoundWithId(boolean found, Integer id) {
        checkNotFound(found, "id=" + id);
    }

    public static <T> T checkNotFound(T object, String msg) {
        checkNotFound(object != null, msg);
        return object;
    }

    public static void checkNotFound(boolean found, String msg) {
        if (!found) {
            throw new NotFoundException("Not found entity with " + msg);
        }
    }
}