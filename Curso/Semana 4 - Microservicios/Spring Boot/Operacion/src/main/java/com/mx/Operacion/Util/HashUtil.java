package com.mx.Operacion.Util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class HashUtil {

    public static String sha512(String input) {
        try {
        	// StandardCharsets.UTF_8
        	return Base64.getEncoder().encodeToString(
                MessageDigest.getInstance("SHA-512").digest(input.getBytes(StandardCharsets.UTF_8))
            );
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al calcular SHA-512", e);
        }
    }
}
