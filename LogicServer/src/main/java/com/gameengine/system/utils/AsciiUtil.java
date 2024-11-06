package com.gameengine.system.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class AsciiUtil {
   private static final Logger logger = GameLoggerFactory.getLogger(AsciiUtil.class);
   private static final ResourceLoader resourceLoader = new DefaultResourceLoader();

   public static String getAsciiMessage(String fileName) {
      try (InputStream inputStream = resourceLoader.getResource("classpath:" + fileName).getInputStream();
           InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
           BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
         StringBuilder sb = new StringBuilder();
         String line;
         while ((line = bufferedReader.readLine()) != null) {
            sb.append(line).append("\n");
         }
         return sb.toString();
      } catch (IOException e) {
         logger.error("获取ASCII消息异常", e);
         return null; // 返回null或者抛出异常，根据具体业务逻辑决定
      }
   }
}
