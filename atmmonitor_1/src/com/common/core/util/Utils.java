package com.common.core.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.common.constants.Constants;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
public final class Utils {
    private static Logger logger = LoggerFactory.getLogger(Utils.class);
    private static Pattern replacePattern = Pattern.compile("\\$\\{(.+?)\\}");

    /**
     * @return
     */
    public static String newId() {
        return UUID.randomUUID().toString().toLowerCase().replace("-", "");
    }

    /**
     * @param objs
     */
    public static void close(AutoCloseable... objs) {
        if (objs == null) {
            return;
        }
        for (AutoCloseable obj : objs) {
            if (obj == null) {
                continue;
            }
            try {
                obj.close();
            } catch (Exception e) {
                logger.debug(e.getMessage(), e);
            }
        }
    }

    /**
     * @param e
     * @return
     */
    public static String trace(Exception e) {
        StringWriter sWriter = new StringWriter();
        PrintWriter pWriter = new PrintWriter(sWriter);
        e.printStackTrace(pWriter);
        String text = sWriter.toString();
        pWriter.close();
        try {
            sWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return text;
    }

    /**
     * @param file
     * @return
     * @throws IOException
     */
    public static String readFile(File file) throws IOException {
        return readFile(file, "utf-8");
    }

    /**
     * @param file
     * @param encoding
     * @return
     * @throws IOException
     */
    public static String readFile(File file, String encoding) throws IOException {
        return readFile(file.getPath(), encoding);
    }

    /**
     * @param filePath
     * @return
     * @throws IOException
     */
    public static String readFile(String filePath) throws IOException {
        return readFile(filePath, "utf-8");
    }

    /**
     * @param filePath
     * @param encoding
     * @return
     * @throws IOException
     */
    public static String readFile(String filePath, String encoding) throws IOException {
        FileInputStream stream = null;
        InputStreamReader iReader = null;
        BufferedReader bReader = null;
        try {
            stream = new FileInputStream(filePath);
            iReader = new InputStreamReader(stream, encoding);
            bReader = new BufferedReader(iReader);
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = bReader.readLine()) != null) {
                sb.append(line);
                sb.append(Constants.NEWLINE);
            }
            return sb.toString();
        } finally {
            Utils.close(bReader, iReader, stream);
        }
    }

    /**
     * @param filePath
     * @param text
     * @param append
     * @throws IOException
     */
    public static void writeFile(String filePath, String text, boolean append)
            throws IOException {
        FileWriter fWriter = null;
        BufferedWriter bWriter = null;
        try {
            fWriter = new FileWriter(filePath, append);
            bWriter = new BufferedWriter(fWriter);
            bWriter.write(text);
            bWriter.flush();
        } finally {
            Utils.close(bWriter, fWriter);
        }
    }

    /**
     * @param srcFilePath
     * @param targetFilePath
     * @throws IOException
     */
    public static void copyFile(String srcFilePath, String targetFilePath)
            throws IOException {
        File srcFile = new File(srcFilePath);
        File targetFile = new File(targetFilePath);
        copyFile(srcFile, targetFile);
    }

    /**
     * @param srcFile
     * @param targetFile
     * @throws IOException
     */
    public static void copyFile(File srcFile, File targetFile)
            throws IOException {
        FileInputStream srcStream = null;
        FileOutputStream targetStream = null;
        try {
            srcStream = new FileInputStream(srcFile);
            targetStream = new FileOutputStream(targetFile);
            byte[] buffer = new byte[1024];
            int i;
            while ((i = srcStream.read(buffer)) != -1) {
                targetStream.write(buffer, 0, i);
            }
        } finally {
            Utils.close(srcStream, targetStream);
        }
    }

    /**
     * 查找字符串中所有${}中的关键词
     *
     * @param format
     * @return
     */
    public static List<String> findKey(String format) {
        if (format == null) {
            return null;
        }
        List<String> result = new ArrayList<String>();
        Matcher matcher = replacePattern.matcher(format);
        while (matcher.find()) {
            String name = matcher.group(1);
            result.add(name);
        }
        return result;
    }

    /**
     * 查找字符串中所有${}中的关键词进行大小写敏感替换
     *
     * @param format
     * @param paramMap
     * @return
     */
    public static String replace(String format, Map<String, String> paramMap) {
        if (format == null) {
            return null;
        }
        StringBuffer sb = new StringBuffer();
        Matcher matcher = replacePattern.matcher(format);
        while (matcher.find()) {
            String name = matcher.group(1);
            String value = paramMap.get(name);
            if (value == null) {
                value = "";
            } else {
                value = value.replaceAll("\\$", "\\\\\\$");
            }
            matcher.appendReplacement(sb, value);
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
}
