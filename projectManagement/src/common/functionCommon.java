/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 *
 * @author ade
 */
public class functionCommon {

    public String connection = "jdbc:hsqldb:file:" + getPath() + "/dataBase/inventory";
    public String userName = "inventory";
    public String passWord = "ert3456";
    public boolean isDebugging = true;
    public static boolean isDevelop = true;

    public static String getPath() {
        String getBack = "", path = "";
        boolean windows = false;
        java.util.StringTokenizer stk12 = new java.util.StringTokenizer(System.getProperty("java.class.path"), "\\");
        if (stk12.countTokens() > 1) {
            windows = true;
        } else {
            stk12 = new java.util.StringTokenizer(System.getProperty("user.dir"), "\\");
            if (stk12.countTokens() > 1) {
                windows = true;
            }
        }
        if (windows) //untuk windows
        {

            path = System.getProperty("java.class.path");
            int panjang = path.length(), i = 0;
            boolean adatitikkoma = false;
            String sementara = "";
            i = 0;

            while (i < panjang && !adatitikkoma) {
                sementara = path.substring(i, (i + 1));
                if (sementara.equalsIgnoreCase(":")) {
                    adatitikkoma = true;
                }
                i++;
            }
            if (!adatitikkoma) {
                path = System.getProperty("user.dir") + "\\" + path;

            }
            java.util.StringTokenizer stk = new java.util.StringTokenizer(path, "\\");
            path = "";
            panjang = stk.countTokens();
            for (i = 0; i < panjang - 1; i++) {
                if (stk.hasMoreTokens()) {
                    path += stk.nextToken() + "/";
                }
            }
            getBack = path;
        } else //untuk linux
        {
            try {
                path = System.getProperty("java.class.path");
                String pathSeleksi = path;
                java.util.StringTokenizer stk = new java.util.StringTokenizer(path, "/");
                if (path.substring(0, 1).equalsIgnoreCase("/")) {
                    path = "/";
                } else {
                    path = System.getProperty("user.dir") + "/";
                }
                int i = 0;
                int panjang = stk.countTokens();
                for (i = 1; i < panjang; i++) {
                    if (stk.hasMoreTokens()) {
                        path += stk.nextToken() + "/";
                    }
                }
                java.io.File fl = new java.io.File(pathSeleksi);
                if (!fl.isFile()) {
                    path = System.getProperty("user.dir") + "/" + path;
                }
                getBack = path;
            } catch (Exception e) {
            }
        }
        if (isDevelop) {
            getBack = "/media/apps/raymon";
        }
        return getBack;
    }

    public String MD5(String md5) {
        if (md5.length() > 0) {
            md5 = "1" + md5 + "2";
            try {
                java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
                byte[] array = md.digest(md5.getBytes());
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < array.length; ++i) {
                    sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
                }
                return sb.toString();
            } catch (java.security.NoSuchAlgorithmException e) {
            }
        }
        return null;
    }

    public boolean isNumeric(String str) {
        boolean getBack = false;
        try {
            double d = Double.parseDouble(str); 
            getBack=true;
        } catch (Exception ex) {
        }
        return getBack;
    }

    public static String digitNumber(String nom) {
        String balik = "";
        int i = 0, x = 0;
        for (i = (nom.length() - 1); i >= 0; i--) {
            if ((x % 3) == 0 && x > 0) {
                balik = nom.substring(i, (i + 1)) + "." + balik;
            } else {
                balik = nom.substring(i, (i + 1)) + balik;
            }
            x++;
        }
        return balik;
    }

    public boolean isValidEmailAddress(String aEmailAddress) {
        if (aEmailAddress == null) {
            return false;
        }
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(aEmailAddress);
            if (!hasNameAndDomain(aEmailAddress)) {
                result = false;
            }
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }

    private static boolean hasNameAndDomain(String aEmailAddress) {
        String[] tokens = aEmailAddress.split("@");
        return (tokens.length == 2 && tokens[0].length() > 0 && tokens[1]
                .length() > 0);
    }
    
    public String viewDatefromSQL(String columnName,String asView) {
        String getBack="to_char("+columnName+",'DD MON YYYY') AS "+asView;
        return getBack;
    }
}
