package com.common.core.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;


public class ImageUtils {
	
	/**
	 * 二进制转为图片保存
	 * @param imgByte
	 * @param imgPath
	 * @param imgName
	 * @return
	 */
	public static int saveToImgByStr(byte[] imgByte, String imgPath,
			String imgName) {

		int stateInt = 1;

		try {

			InputStream in = new ByteArrayInputStream(imgByte);

			File file = new File(imgPath, imgName);// 可以是任何图片格式.jpg,.png等
			FileOutputStream fos = new FileOutputStream(file);

			byte[] b = new byte[1024];
			int nRead = 0;
			while ((nRead = in.read(b)) != -1) {
				fos.write(b, 0, nRead);
			}
			fos.flush();
			fos.close();
			in.close();

		} catch (Exception e) {
			stateInt = 0;
			e.printStackTrace();
		} finally {
		}
		return stateInt;
	}
}
