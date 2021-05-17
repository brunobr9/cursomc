package com.brunobr9.cursomc.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EncodeUtils {

    public static String decodeParam(String s) {
	try {
	    return URLDecoder.decode(s, "UTF-8");
	} catch (UnsupportedEncodingException e) {
	    return "";
	}
    }

    public static List<Integer> decodeIntList(String s) {
	String[] vet = s.split(",");
	return Arrays.asList(vet).stream().map(Integer::parseInt).collect(Collectors.toList());
    }
    
    public static String decodeListString(List<String> list) {
	return list.stream().collect(Collectors.joining(", "));
    }
}
