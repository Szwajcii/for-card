package com.forcard.core.shared.utils;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CodeGeneratorUtils {

    private static final int START_INDEX = 0;
    private static final int END_INDEX = 13;

    private CodeGeneratorUtils() {
    }

    public static String generateUniqueCode() {
        String generatedCode = UUID.randomUUID().toString();
        return generatedCode.toUpperCase()
                            .substring(START_INDEX, END_INDEX)
                            .replace("-","");
    }

}
