package com.liuganchen.indigo.util;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class AuthUtil {
    static final Base64.Decoder decoder = Base64.getDecoder();
    static final Base64.Encoder encoder = Base64.getEncoder();

    @NotNull
    @Contract(pure = true)
    public static String encryption(String str) {
        final byte[] textByte = str.getBytes(StandardCharsets.UTF_8);
        return encoder.encodeToString(textByte);
    }

    @NotNull
    @Contract(pure = true)
    public static String decrypt(String str) {
        return new String(decoder.decode(str), StandardCharsets.UTF_8);
    }
}
