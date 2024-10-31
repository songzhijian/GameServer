package com.gameengine.system.util;

import java.nio.ByteBuffer;

public class ByteUtils {
   private static final int HEX_BYTES_PER_LINE = 16;
   private static final char TAB = '\t';
   private static final String NEW_LINE = System.getProperty("line.separator");

   public static byte[] resizeByteArray(byte[] source, int pos, int size) {
      byte[] tmpArray = new byte[size];
      System.arraycopy(source, pos, tmpArray, 0, size);
      return tmpArray;
   }

   public static String fullHexDump(ByteBuffer buffer, int bytesPerLine) {
      return fullHexDump(buffer.array(), bytesPerLine);
   }

   public static String fullHexDump(ByteBuffer buffer) {
      return fullHexDump((byte[])buffer.array(), 16);
   }

   public static String fullHexDump(byte[] buffer) {
      return fullHexDump((byte[])buffer, 16);
   }

   public static String fullHexDump(byte[] buffer, int bytesPerLine) {
      StringBuilder sb = (new StringBuilder("Binary size: ")).append(buffer.length).append("\n");
      StringBuilder hexLine = new StringBuilder();
      StringBuilder chrLine = new StringBuilder();
      int index = 0;
      int count = 0;

      do {
         byte var10 = buffer[index];
         String j = Integer.toHexString(var10 & 255);
         if(j.length() == 1) {
            hexLine.append("0");
         }

         hexLine.append(j.toUpperCase()).append(" ");
         char currChar = var10 >= 33 && var10 <= 126?(char)var10:46;
         chrLine.append(currChar);
         ++count;
         if(count == bytesPerLine) {
            count = 0;
            sb.append(hexLine).append('\t').append(chrLine).append(NEW_LINE);
            hexLine.delete(0, hexLine.length());
            chrLine.delete(0, chrLine.length());
         }

         ++index;
      } while(index < buffer.length);

      if(count != 0) {
         for(int var101 = bytesPerLine - count; var101 > 0; --var101) {
            hexLine.append("   ");
            chrLine.append(" ");
         }

         sb.append(hexLine).append('\t').append(chrLine).append(NEW_LINE);
      }

      return sb.toString();
   }
}
