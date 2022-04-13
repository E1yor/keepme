package uz.wiut.keepme.helper;

import org.springframework.util.StringUtils;

public class StringHelper {
    public static String get(Object obj){
        String text = null;
        if(!StringUtils.isEmpty(obj)){
            text = String.valueOf(obj);
        }
        return text;
    }
}
