package com.pan.main.system.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @author MrBird
 */
public class Md5Util {

    private static final String ALGORITH_NAME = "md5";

    public static String encrypt(Long idd, String password) {
        String pwd = new SimpleHash(ALGORITH_NAME, password, ByteSource.Util.bytes(String.valueOf(idd))).toString();
        return pwd;
    }
}
