package com.cilka.telgt.utils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class HandlerHelpers {
    public static Map<String,Object> buildObject(Class c, Object obj){

        Map<String,Object> m  = null;

            m =Arrays.stream(c.getFields()).collect(Collectors.toMap(Field::getName, o -> {
                try {
                    return o.get(obj);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                return null;
            }));

        return m;
    }
}
