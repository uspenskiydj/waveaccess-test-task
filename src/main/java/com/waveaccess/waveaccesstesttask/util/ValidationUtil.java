package com.waveaccess.waveaccesstesttask.util;

import com.waveaccess.waveaccesstesttask.model.AbstractBaseEntity;
import com.waveaccess.waveaccesstesttask.util.exception.IllegalRequestDataException;
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

    public static void assureIdConsistent(AbstractBaseEntity bean, int id) {
        if (bean.getId() == null) {
            bean.setId(id);
        }
        else if (bean.getId() != id) {
            throw new IllegalRequestDataException(bean + " must be with id=" + id);
        }
    }

    public static void checkNew(AbstractBaseEntity bean) {
        if (bean.getId() != null) {
            throw new IllegalRequestDataException(bean + " must be new (id=null)");
        }
    }
}