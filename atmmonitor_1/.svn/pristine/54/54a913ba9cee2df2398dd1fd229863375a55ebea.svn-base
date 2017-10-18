package com.common.core.util;

import com.common.constants.Constants;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import java.io.IOException;
import java.io.StringWriter;

/**
 *
 */
public final class Serializer {

    // region deserializeXml

    /**
     * @param xml
     * @param elementName root element name.
     * @param clazz
     * @param converters
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T deserializeXml(String xml, String elementName, Class<T> clazz, SingleValueConverter... converters) {
        XStream xStream = new XStream();
        xStream.autodetectAnnotations(true);
        xStream.ignoreUnknownElements();
        return deserializeXml(xStream, xml, elementName, clazz, converters);
    }

    /**
     * @param xppDriver
     * @param xml
     * @param elementName root element name.
     * @param clazz
     * @param converters
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T deserializeXml(XppDriver xppDriver, String xml, String elementName, Class<T> clazz, SingleValueConverter... converters) {
        XStream xStream = new XStream(xppDriver);
        xStream.autodetectAnnotations(true);
        xStream.ignoreUnknownElements();
        return deserializeXml(xStream, xml, elementName, clazz, converters);
    }

    /**
     * @param xStream
     * @param xml
     * @param elementName root element name.
     * @param clazz
     * @param converters
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T deserializeXml(XStream xStream, String xml, String elementName, Class<T> clazz, SingleValueConverter... converters) {
        if (converters != null) {
            for (SingleValueConverter converter : converters) {
                xStream.registerConverter(converter);
            }
        }

        xStream.aliasType(elementName, clazz);
        Object obj = xStream.fromXML(xml);
        return (T) obj;
    }

    // endregion

    // region serializeXml

    /**
     * @param obj
     * @param converters
     * @return
     */
    public static <T> String serializeXml(T obj, SingleValueConverter... converters) {
        XStream xstream = new XStream();
        xstream.autodetectAnnotations(true);
        return serializeXml(xstream, obj, converters);
    }

    /**
     * @param xppDriver
     * @param obj
     * @param converters
     * @return
     */
    public static <T> String serializeXml(XppDriver xppDriver, T obj, SingleValueConverter... converters) {
        XStream xstream = new XStream(xppDriver);
        xstream.autodetectAnnotations(true);
        return serializeXml(xstream, obj, converters);
    }

    /**
     * @param xStream
     * @param obj
     * @param converters
     * @return
     */
    public static <T> String serializeXml(XStream xStream, T obj, SingleValueConverter... converters) {
        if (converters != null) {
            for (SingleValueConverter converter : converters) {
                xStream.registerConverter(converter);
            }
        }

        StringWriter writer = new StringWriter();
        writer.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        writer.append(Constants.NEWLINE);
        xStream.toXML(obj, writer);

        String xml = writer.toString();

        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return xml;
    }

    // endregion

    // region deserializeJson

    /**
     * @param json
     * @param clazz
     * @param modules
     * @return
     * @throws IOException
     */
    public static <T> T deserializeJson(String json, Class<T> clazz, Module... modules) throws IOException {
        ObjectMapper objMapper = new ObjectMapper();

        if (modules != null) {
            for (Module module : modules) {
                objMapper.registerModule(module);
            }
        }

        return objMapper.readValue(json, clazz);
    }

    // endregion

    // region serializeJson

    /**
     * @param obj
     * @param modules
     * @return
     * @throws IOException
     */
    public static <T> String serializeJson(T obj, Module... modules) throws IOException {
        ObjectMapper objMapper = new ObjectMapper();
        objMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        if (modules != null) {
            for (Module module : modules) {
                objMapper.registerModule(module);
            }
        }

        return objMapper.writeValueAsString(obj);
    }

    // endregion
}
