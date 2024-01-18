package com.techphantoms.registration.util;

import com.google.gson.JsonParser;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang.RandomStringUtils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class CommonUtil {
    public static boolean isNullOrZero(BigDecimal id) {
        BigDecimal zero = new BigDecimal(0);
        if (id == null || id.compareTo(zero) == 0) {
            return true;
        }
        return false;
    }

    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
    public static String generateUniqueFileNumber() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = dateFormat.format(new Date());
        Random random = new Random();
        int randomNum = random.nextInt(10000);
        String uniqueFileNumber = timestamp + "_" + randomNum;
        return uniqueFileNumber;
    }

    public static boolean isNullOrZero(Long id) {
        Long zero = 0L;
        if (id == null || zero.equals(id)) {
            return true;
        }
        return false;
    }

    public static boolean isNullOrZero(BigInteger id) {
        BigInteger zero = new BigInteger("0");
        if (id == null || zero.equals(id)) {
            return true;
        }
        return false;
    }

    public static boolean isNullOrZero(Double id) {
        Double zero = 0D;
        if (id == null || zero.equals(id)) {
            return true;
        }
        return false;
    }

    public static boolean isNullOrZero(Float id) {
        Float zero = 0F;
        if (id == null || zero.equals(id)) {
            return true;
        }
        return false;
    }

    public static boolean isNullOrZeroOrNegative(Long id) {
        return isNullOrZero(id) || id.intValue() < 0;
    }

    public static boolean isNullOrZero(Integer id) {
        Integer zero = 0;
        if (id == null || zero.equals(id)) {
            return true;
        }
        return false;
    }

    public static boolean isNullOrEmpty(String string) {
        if (string == null || string.trim().equals("") || string.trim().equals("null")) {
            return true;
        }
        return false;
    }

    public static boolean isNullOrEmpty(Character character) {
        if (character == null || character.equals(' ')) {
            return true;
        }
        return false;
    }

    public static boolean isNotNull(Object obj) {
        return (obj != null);
    }
    /*
     * #########################################################################
     * #######
     */

    /*
     * #########################################################################
     * #######
     */
    /* ##### FUNCTIONS TO GET STRING LIST FROM DELIMITED STRING ##### */
    public static List<String> getListFromDelimitedString(String delimitedStr, String delimiter) {
        if (delimitedStr == null || delimiter == null) {
            return Collections.emptyList();
        } else {
            String[] dataArray = delimitedStr.split(delimiter);
            List<String> dataList = Arrays.asList(dataArray);
            return dataList;
        }
    }
    /*
     * #########################################################################
     * #######
     */

    /*
     * #########################################################################
     * #######
     */
    /* ##### FUNCTIONS TO GET STRING LIST FROM DELIMITED STRING ##### */
    public static Set<String> getSetFromDelimitedString(String delimitedStr, String delimiter) {
        if (delimitedStr == null || delimiter == null) {
            return Collections.emptySet();
        } else {
            String[] dataArray = delimitedStr.split(delimiter);
            Set<String> dataList = new HashSet<String>();
            if (dataArray != null) {
                for (String data : dataArray) {
                    dataList.add(data);
                }
            }
            return dataList;
        }
    }
    /*
     * #########################################################################
     * #######
     */

    /*
     * #########################################################################
     * #######
     */
    /* ##### FUNCTIONS TO GET ARRAY FROM THE STRING WITH DELIMITER ##### */
    public static String[] convertDelimitStringToArray(String string, String delimiter) {
        if (string != null && delimiter != null) {
            String[] strings = string.split(delimiter);
            return strings;
        }
        return new String[] {};
    }

    /*
     * #########################################################################
     * #######
     */
    /* ##### FUNCTIONS TO GET LIST FROM THE STRING WITH DELIMITER ##### */
    public static List<String> extractListFromString(String dataString, String delimiter) {
        if (dataString == null || delimiter == null) {
            return Collections.emptyList();
        } else {
            String[] dataArray = dataString.split(delimiter);
            List<String> dataList = Arrays.asList(dataArray);
            return dataList;
        }
    }


    public static int calculateYearDifference(Date arg1, Date arg2) {

        if (isNotNull(arg1) && isNotNull(arg2)) {
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(arg1);
            int year1 = cal1.get(Calendar.YEAR);

            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(arg2);
            int year2 = cal2.get(Calendar.YEAR);

            return year1 - year2;
        }
        return 0;
    }



    public static boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidJson(String jsonStr) {
        try {
            JsonParser jsonParser = new JsonParser();
            jsonParser.parse(jsonStr);

            return true;
        } catch (Exception ex1) {
            return false;
        }

    }

    public static String removeSqlInjection(String str) {

        if (str != null && str.length() > 0) {
            str = str.replace("--", "");
            str = str.replace("\\", "\\\\");
            str = str.replace("'", "\\'");
            str = str.replace("\0", "\\0");
            str = str.replace("\n", "\\n");
            str = str.replace("\r", "\\r");
            str = str.replace("\"", "\\\"");
            str = str.replace("\\x1a", "\\Z");

        }
        return str;
    }

    public static boolean validateLongValue(Long longValue) {
        if (longValue != null) {
            if (!(longValue instanceof Long))
                return false;
            if (longValue > Long.MAX_VALUE)
                return false;
            if (longValue < Long.MIN_VALUE)
                return false;
        }
        return true;
    }

    public static boolean isValidBoolean(Boolean booleanValue) {
        if (booleanValue != null) {
            if (!(booleanValue != true || booleanValue != false))
                return false;
            else
                return true;
        }
        return true;
    }

    public static boolean validateIntegerValue(Integer integerValue) {
        if (integerValue != null) {
            if (!(integerValue instanceof Integer))
                return false;
            if (integerValue > Integer.MAX_VALUE)
                return false;
            if (integerValue < Integer.MIN_VALUE)
                return false;
        }
        return true;
    }


    public static Boolean xOR(Boolean a, Boolean b) {
        Boolean x;
        if ((a && (!b)) || ((!a) && b)) {
            x = true;
        } else
            x = false;

        return x;
    }

    public static String encodeStringByBase64(String stringToEncode) {
        byte[] encodedBytes = Base64.encodeBase64(stringToEncode.getBytes());
        String encodedString = new String(encodedBytes);
        return encodedString;
    }

    public static String decodeStringByBase64(String stringToDecode) {
        byte[] decodedBytes = stringToDecode.getBytes();
        byte[] decoded = Base64.decodeBase64(decodedBytes);
        String decodedString = new String(decoded);
        return decodedString;
    }

    public static String encryptData(String text, String password) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte[] keyBytes = new byte[16];
            byte[] pwdBytes = password.getBytes("UTF-8");
            int len = pwdBytes.length;
            if (len > keyBytes.length)
                len = keyBytes.length;
            System.arraycopy(pwdBytes, 0, keyBytes, 0, len);

            cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(keyBytes, "AES"), new IvParameterSpec(keyBytes));
            byte[] plainText = text.getBytes("UTF-8");
            byte[] cipherText = cipher.doFinal(plainText, 0, plainText.length);
            return Base64.encodeBase64String(cipherText);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static String decodeBase64(String bytesEncoded) {
        byte[] valueDecoded = Base64.decodeBase64(bytesEncoded);
        System.out.println("Decoded value is " + new String(valueDecoded));
        return valueDecoded.toString();
    }

    public static Date addMinutesToDate(Date date, int numberOfMinutes) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, numberOfMinutes);
        Date otpExpTime = cal.getTime();
        return otpExpTime;
    }

    public static String generateOTP() {

        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        // System.out.println(number);
        return new Integer(getRandomInteger(100000, 999999)).toString();

    }

    /* ##### FUNCTIONS TO RANDOM NUMBER ##### */
    public static final int getRandomInteger(int rangeStart, int rangeEnd) {
        if (rangeStart > rangeEnd) {
            throw new IllegalArgumentException("Start cannot exceed End.");
        }
        // get the range, casting to long to avoid overflow problems
        long range = (long) rangeEnd - (long) rangeStart + 1;
        // compute a fraction of the range, 0 <= frac < range
        Random rnd = new Random(System.currentTimeMillis());
        long fraction = (long) (range * rnd.nextDouble());
        int randomNumber = (int) (fraction + rangeStart);
        return randomNumber;
    }

    public static String genHash(String sContent) {
        try {
            if (!CommonUtil.isNullOrEmpty(sContent)) {
                MessageDigest obDig = MessageDigest.getInstance("md5");
                byte[] byDig;
                try {
                    byDig = obDig.digest(sContent.getBytes("CP1252"));
                    Hex obHex = new Hex();
                    String digested = new String(obHex.encode(byDig));

                    return digested;
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean containsOnlyNumbers(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i)))
                return false;
        }
        return true;
    }

    public static boolean isValidEmailId(String emailId) {

        boolean isEmailValid = false;
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        if (emailId != null) {
            java.util.regex.Matcher m = p.matcher(emailId);
            isEmailValid = m.matches();

        }
        return isEmailValid;
    }



    public static boolean isValidPassword(String str) {
        char ch;
        boolean capitalFlag = false;
        boolean lowerCaseFlag = false;
        boolean numberFlag = false;
        for(int i=0;i < str.length();i++) {
            ch = str.charAt(i);
            if( Character.isDigit(ch)) {
                numberFlag = true;
            }
            else if (Character.isUpperCase(ch)) {
                capitalFlag = true;
            } else if (Character.isLowerCase(ch)) {
                lowerCaseFlag = true;
            }
            if(numberFlag && capitalFlag && lowerCaseFlag)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        //System.out.println(isValidLoginId("sachin@gmail.com"));
        System.out.println(isValidLoginId("rajnish@123"));
    }

    public static boolean isValidLoginIdPattern(String loginid) {

        Matcher matcher = Pattern.compile("^[a-z0-9]([._-](?![._-])|[a-z0-9]){3,38}[a-z0-9]$") .matcher(loginid);
        return matcher.matches();
    }

    public static boolean isValidLoginId(String loginid) {
        if(!isValidLoginIdPattern(loginid))
        {
            return isValidEmail(loginid);
        }
        return isValidLoginIdPattern(loginid);
    }

    public static String generateRandomPassword() {
        String upperCaseLetters = RandomStringUtils.random(2, 65, 90, true, true);
        String lowerCaseLetters = RandomStringUtils.random(2, 97, 122, true, true);
        String numbers = RandomStringUtils.randomNumeric(3);
        //String specialChar = RandomStringUtils.random(2, 33, 47, false, false);
        String totalChars = RandomStringUtils.randomAlphanumeric(3);
        String combinedChars = upperCaseLetters.concat(lowerCaseLetters)
                .concat(numbers)
                //.concat(specialChar)
                .concat(totalChars);
        List<Character> pwdChars = combinedChars.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
        Collections.shuffle(pwdChars);
        String password = pwdChars.stream()
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
        return password;
    }

    public static byte[] convertFileToByteArray(File file) {
        /* INITIALIZE BYTE ARRAY WITH FILE LENGTH */
        byte[] bytesArray = new byte[(int) file.length()];
        FileInputStream fis;
        try {
            fis = new FileInputStream(file);
            fis.read(bytesArray);
            fis.close();
            return bytesArray;
        } catch (FileNotFoundException exception) {
            throw new RuntimeException(exception);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }


    public static String getUniqueNumber(){
        Random random = new Random(System.nanoTime());
        int randomInt = random.nextInt(1000000000);
        return String.valueOf(randomInt);
    }


    private static final AtomicLong LAST_TIME_MS = new AtomicLong();
    public static long uniqueCurrentTimeMS() {
        long now = System.currentTimeMillis();
        while(true) {
            long lastTime = LAST_TIME_MS.get();
            if (lastTime >= now)
                now = lastTime+1;
            if (LAST_TIME_MS.compareAndSet(lastTime, now))
                return now;
        }
    }

    /* * returns random integer between minimum and maximum range */
    public static int getRandomNumber(int maximum, int minimum){ return ((int) (Math.random()*(maximum - minimum))) + minimum; }


    public static  long  findDays(String actionDate, String currentDate)   {
        //SimpleDateFormat obj = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        SimpleDateFormat obj = new SimpleDateFormat("dd-MM-yyyy ");
        try {
            long days_difference;
            Date date1 = obj.parse(actionDate);
            Date date2 = obj.parse(currentDate);

            long time_difference = date2.getTime() - date1.getTime();
            // Calucalte time difference in days
            days_difference = (time_difference / (1000*60*60*24)) % 365;

            if(days_difference!=0) {

                return days_difference;
            }

            else {
                return days_difference;
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return 0;

    }


    public static  boolean  checkValidStringDate(String dateToCheck)   {
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm a");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDateTime parsedDateTime = null;

        try {
            parsedDateTime = LocalDateTime.parse(dateToCheck, formatter1);
        } catch (DateTimeParseException e) {
            // Try the second date format
            try {
                parsedDateTime = LocalDateTime.parse(dateToCheck, formatter2);
            } catch (DateTimeParseException e2) {
                System.out.println("Not a valid date in either format.");
            }
        }

        if (parsedDateTime != null) {
            return true;
        }else {
            return false;
        }


    }


    public static  String  addDaysInDate(String date,String daysToAdd)   {
        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm a");

        LocalDateTime dateTime = LocalDateTime.parse(date, inputFormat);
        LocalDateTime updatedDateTime = dateTime.plusDays(Integer.parseInt(daysToAdd));
        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm a");
        String updatedDateString = updatedDateTime.format(outputFormat);
        return updatedDateString;

    }

    public static String  getIpClientIpAddress()  {
        return  ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getRemoteAddr();
    }

}
