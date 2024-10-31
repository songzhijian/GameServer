package com.gameengine.system.net.scan;

import com.google.protobuf.MessageLite;
import com.gameengine.system.net.processor.MsgProcessor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageProcessorScanner {

    private ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
    private HashMap<Short, MsgProcessor<MessageLite>> processorTypeMap = new HashMap<>();

    public void scanClasses(String processorPathPrefix) throws IOException {
        String processorPathPattern = "classpath*:"+processorPathPrefix+"/*.class";
        Pattern processorClassPattern = Pattern.compile("(" + processorPathPrefix + "(.*?)([0-9]+))\\.class\\]$");
        ClassLoader classLoader = getClass().getClassLoader();
        Resource[] resources = resourcePatternResolver.getResources(processorPathPattern);
        String oldValue = null;
        for (Resource res : resources) {
            String desc = res.getDescription();
            if(desc!=null&&desc.contains("$")){
                //内部类跳过
                continue;
            }
            Matcher m = processorClassPattern.matcher(desc);
            if (m.find() && m.groupCount() > 2) {
                String msgClassName = m.group(1);
                String msgTypeStr = m.group(3);
                msgClassName = msgClassName.replaceAll("/", ".");
                try {
                    Class<?> clazz = Class.forName(msgClassName, true, classLoader);
                    short msgTypeNum = Short.parseShort(msgTypeStr);
                    @SuppressWarnings("unchecked")
                    MsgProcessor<MessageLite> processor = (MsgProcessor<MessageLite>)clazz.newInstance();
                    processor.setMsgType(msgTypeNum);
                    MsgProcessor<MessageLite> omp = processorTypeMap.put(msgTypeNum, processor);
                    if(omp != null) {
                        oldValue = omp.getClass().getName() +", " + processor.getClass().getName();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if(oldValue != null) {
                System.out.println("Processor duplicated "+oldValue);
                oldValue = null;
            }
        }
    }

    public void scanClassesWin(String processorPathPrefix) throws IOException {
        String processorPathPattern = "classpath*:"+processorPathPrefix+"/*.class";
        String regex = "file \\[.*[" + Pattern.quote(File.separator) + "](.*?)([0-9]+)\\.class\\]$";
        Pattern processorClassPattern = Pattern.compile(regex);
        ClassLoader classLoader = getClass().getClassLoader();
        Resource[] resources = resourcePatternResolver.getResources(processorPathPattern);
        String oldValue = null;
        for (Resource res : resources) {
            String desc = res.getDescription();
            if(desc!=null&&desc.contains("$")){
                //内部类跳过
                continue;
            }
            Matcher m = processorClassPattern.matcher(desc);
            if (m.find() && m.groupCount() > 1) {
                String fileName = m.group(1);
                String msgTypeStr = m.group(2);
                String msgClassName = processorPathPrefix+fileName+msgTypeStr;
                msgClassName = msgClassName.replaceAll("/", ".");
                try {
                    Class<?> clazz = Class.forName(msgClassName, true, classLoader);
                    short msgTypeNum = Short.parseShort(msgTypeStr);
                    @SuppressWarnings("unchecked")
                    MsgProcessor<MessageLite> processor = (MsgProcessor<MessageLite>)clazz.newInstance();
                    processor.setMsgType(msgTypeNum);
                    MsgProcessor<MessageLite> omp = processorTypeMap.put(msgTypeNum, processor);
                    if(omp != null) {
                        oldValue = omp.getClass().getName() +", " + processor.getClass().getName();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if(oldValue != null) {
                System.out.println("Processor duplicated "+oldValue);
                oldValue = null;
            }
        }
    }


    public MsgProcessor<MessageLite> getMsgProcessor(short key) {
        return (MsgProcessor<MessageLite>)processorTypeMap.get(key);
    }

    public HashMap<Short, MsgProcessor<MessageLite>> getProcessorTypeMap() {
        return processorTypeMap;
    }


    public static void main(String[] args) throws Exception {
        MessageProcessorScanner protocLoader = new MessageProcessorScanner();
        protocLoader.init("com/example/processor/");
    }

    public void init(String processorPathPrefix) throws Exception {
        scanClasses(processorPathPrefix);

    }
}
