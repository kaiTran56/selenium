package com.tranquyet.utils;

import java.io.File;
import java.io.IOException;

import org.codehaus.plexus.util.FileUtils;

public class IOUtils {
	public static boolean isExist(String dir) {
		return new File(dir).exists();
	}
	public static void deleteFile(String dir) {
		try {
			FileUtils.deleteDirectory(new File(dir));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
