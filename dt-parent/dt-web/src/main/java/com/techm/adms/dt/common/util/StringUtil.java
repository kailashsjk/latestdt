package com.techm.adms.dt.common.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

import org.apache.commons.io.FilenameUtils;

import com.techm.adms.dt.common.exception.DTServiceException;



/**
 * this class used for String Util functionalities
 * 
 * @CreatedBy TechM
 * @CreatedOn 07-Oct-2015 10:44:35 am
 */
public final class StringUtil {

    /**
     * private constructor
     */
    private StringUtil() {

    }

    /**
     * @param inputString
     * @return boolean
     */
    public static boolean isStringNotNull(final String inputString) {

        boolean emptyStrCheck = true;

        if (null == inputString || CommonConstant.NULL_STR.equalsIgnoreCase(inputString) || CommonConstant.EMPTY_STR.equals(inputString.trim())) {
            emptyStrCheck = false;
        }
        return emptyStrCheck;
    }

    /**
     * @param inputString
     * @return long
     */
    public static long stringToLong(final String inputString) {

        long outputLong = 0;
        try {
            if (null != inputString && !CommonConstant.EMPTY_STR.equalsIgnoreCase(inputString.trim()) && !CommonConstant.NULL_STR.equalsIgnoreCase(inputString.trim())) {
                outputLong = Long.parseLong(inputString);

            }
        } catch (NumberFormatException nfe) {
            throw new DTServiceException(nfe);
        }
        return outputLong;
    }

    /**
     * @param fileName
     * @return
     */
    public static String getFileNameWithOutExt(final String fileName) {
        if (fileName == null) {
            return null;

        } else {
            return FilenameUtils.removeExtension(fileName);
        }
    }

    /**
     * @param fileName
     * @return
     */
    public static String getFileNameWithExt(final String fileName) {
        if (fileName == null) {
            return null;

        } else {
            return FilenameUtils.getName(fileName);
        }
    }

    /**
     * Get the date and timein yyyyMMddHHMM format
     * 
     * @return String
     */
    public static String getDateTimeStr() {
        return new SimpleDateFormat("yyyyMMddHHMM", Locale.ENGLISH).format(new Date());
    }

    /**
     * returns empty string if the input string is null, returns its actual
     * value otherwise
     * 
     * @param str
     * @return String
     */
    public static String handleNullStr(final String str) {
        if (null == str) {
            return "";
        } else {
            return str;
        }
    }

    public static List<String> convertStringToList(final String string, final String token) {
        List<String> strList = new ArrayList<String>();

        StringTokenizer st = new StringTokenizer(string, token);
        while (st.hasMoreTokens()) {
            strList.add(st.nextToken());
        }
        return strList;
    }

	public static String doSubstring(String stringValue, int range){
		String append= "...";
		if(stringValue != null && stringValue.length() > range){
			return stringValue.substring(0, range) + append;
		}else{
			return stringValue;
		}
	}
}
