package com.stan.webfluxdemo1.shirotest;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.UnsupportedEncodingException;




class CodecException extends RuntimeException {
    public CodecException() {
    }

    public CodecException(String message) {
        super(message);
    }

    public CodecException(Throwable cause) {
        super(cause);
    }

    public CodecException(String message, Throwable cause) {
        super(message, cause);
    }
}


public abstract class CodecSupport {
    public static final String PREFERRED_ENCODING = "UTF-8";

    public CodecSupport() {
    }

    public static byte[] toBytes(char[] chars) {
        return toBytes(new String(chars), "UTF-8");
    }

    public static byte[] toBytes(char[] chars, String encoding) throws CodecException {
        return toBytes(new String(chars), encoding);
    }

    public static byte[] toBytes(String source) {
        return toBytes(source, "UTF-8");
    }

    public static byte[] toBytes(String source, String encoding) throws CodecException {
        try {
            return source.getBytes(encoding);
        } catch (UnsupportedEncodingException var4) {
            String msg = "Unable to convert source [" + source + "] to byte array using " + "encoding '" + encoding + "'";
            throw new CodecException(msg, var4);
        }
    }

    public static String toString(byte[] bytes) {
        return toString(bytes, "UTF-8");
    }

    public static String toString(byte[] bytes, String encoding) throws CodecException {
        try {
            return new String(bytes, encoding);
        } catch (UnsupportedEncodingException var4) {
            String msg = "Unable to convert byte array to String with encoding '" + encoding + "'.";
            throw new CodecException(msg, var4);
        }
    }

    public static char[] toChars(byte[] bytes) {
        return toChars(bytes, "UTF-8");
    }

    public static char[] toChars(byte[] bytes, String encoding) throws CodecException {
        return toString(bytes, encoding).toCharArray();
    }


    protected String toString(Object o) {
        if (o == null) {
            String msg = "Argument for String conversion cannot be null.";
            throw new IllegalArgumentException(msg);
        } else if (o instanceof byte[]) {
            return toString((byte[])((byte[])o));
        } else if (o instanceof char[]) {
            return new String((char[])((char[])o));
        } else {
            return o instanceof String ? (String)o : this.objectToString(o);
        }
    }

    protected String objectToString(Object o) {
        return o.toString();
    }
}
