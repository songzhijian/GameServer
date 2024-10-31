package com.gameengine.system.net.scan;

import com.google.protobuf.MessageLite;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageScanner implements MessageMapper{

    private ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();

    private Map<Short, MessageLite> msgTypeMap = new HashMap<>();

    private Map<Class<? extends Object> , Short> classShortMap = new HashMap<>();


    @Override
    public Short getMsgType(MessageLite msg) {
        return classShortMap.get(msg.getClass());

    }

    @Override
    public MessageLite getProto(short msgType) {

            return msgTypeMap.get(msgType);
    }


    public void scanClasses(String path) throws Exception {
        if(StringUtils.isEmpty(path)){
            path = "com/dreamfun/opg/message";
        }

        String msgPath = "classpath*:"+path+"/*.class";
        Pattern msgClassPattern = Pattern.compile("(" + path + "(.+?[A-Za-z/0-9]+?)([0-9]+))\\.class\\]$");
        ClassLoader classLoader = getClass().getClassLoader();
        Resource[] resources = resourcePatternResolver.getResources(msgPath);
        short msgType = 0;
        Set<String> tmpSet = new HashSet<>();
        String simpleName = "";
        String oldValue = null;
        for (Resource res : resources) {
            String desc = res.getDescription();
            desc = desc.replaceAll("[\\\\]", "/");
            Matcher m = msgClassPattern.matcher(desc);
            if (m.find() && m.groupCount() > 2) {
                String msgClassName = m.group(1);
                String msgTypeStr = m.group(3);
                msgClassName = msgClassName.replaceAll("/", ".");
                try {
                    Class<?> clazz = Class.forName(msgClassName, true, classLoader);
                    Method method = clazz.getMethod("getDefaultInstance");
                    Object inst = method.invoke(clazz);
                    MessageLite msgLite = (MessageLite) inst;
                    short msgTypeNum = Short.parseShort(msgTypeStr);
                    msgType = msgTypeNum;
                    MessageLite ol = msgTypeMap.put(msgTypeNum, msgLite);
                    if(ol != null) {
                        oldValue = ol.getClass().getName() +", " + msgLite.getClass().getName();
                        //TODO
                    }
                    classShortMap.put(msgLite.getClass(), msgTypeNum);
//                    simpleName = msgLite.getClass().getSimpleName();
//                    if(simpleName.startsWith("S")){
//                        tmpSet.add(simpleName);
//                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
