package com.gameengine.system.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * Date:   2016/11/30 18:56
 */
public final class MD5 {
	private static final Logger log = LoggerFactory.getLogger(MD5.class);
	private static ThreadLocal<MD5> localMd5 = new ThreadLocal<MD5>() {
		@Override
		protected MD5 initialValue() {
			return new MD5();
		}
	};

	private final static char[] hexDigits = {
			'0', '1', '2', '3', '4', '5',
			'6', '7', '8', '9', 'a', 'b',
			'c', 'd', 'e', 'f'
	};

	private MessageDigest messageDigest;
	private StringBuilder sb = new StringBuilder(32);

	private MD5() {
		try {
			this.messageDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			this.log.error("Could not instantiate the MD5 Message Digest!", e);
		}
	}

	public static MD5 getInstance() {
		return localMd5.get();
	}

	public String getHash(String s) {
		byte[] data = s.getBytes();
		return getHash(data);
	}

	public String getHash(byte[] data) {
		this.messageDigest.update(data);
		return this.toHexString(this.messageDigest.digest());
	}

	public String getHash(byte[] data, int offset, int length) {
		this.messageDigest.update(data, offset, length);
		return this.toHexString(this.messageDigest.digest());
	}

	public String getHash(ByteBuffer buffer) {
		this.messageDigest.update(buffer);
		return this.toHexString(this.messageDigest.digest());
	}

	private String toHexString(byte[] byteData) {
		sb.setLength(0);
		int temp;
		for (int i = 0; i < byteData.length; ++i) {
			temp = byteData[i];
			if (temp < 0) {
				temp += 256;
			}
			sb.append(hexDigits[temp >> 4]);
			sb.append(hexDigits[temp & 0xf]);
		}
		return sb.toString();
	}
}