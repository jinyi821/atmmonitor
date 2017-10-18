package com.common.core.util.video;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.common.constants.PropertiesUtils;
import com.common.core.util.WebApplicationManager;

public class FFMpegUtil implements IStringGetter {

	private long runtime = 0;
	private String ffmpegUri;// ffmpeg地址
	private String originFileUri; // 视频源文件地址

	private enum FFMpegUtilStatus {
		Empty, CheckingFile, GettingRuntime
	};

	private static Logger logger = Logger.getLogger(FFMpegUtil.class);

	private FFMpegUtilStatus status = FFMpegUtilStatus.Empty;

	/**
	 * 构造函数
	 * 
	 * @param ffmpegUri
	 *            ffmpeg的全路径 如e:/ffmpeg/ffmpeg.exe 或 /usr/local/bin/ffmpeg
	 * @param originFileUri
	 *            所操作视频文件的全路径 如e:/upload/temp/test.wmv
	 */
	public FFMpegUtil(String ffmpegUri, String originFileUri) {

		this.ffmpegUri = ffmpegUri;
		this.originFileUri = originFileUri;
	}

	/**
	 * 构造函数
	 * 
	 * @param ffmpegUri
	 *            ffmpeg的全路径 如e:/ffmpeg/ffmpeg.exe 或 /usr/local/bin/ffmpeg
	 * @param originFileUri
	 *            所操作视频文件的全路径 如e:/upload/temp/test.wmv
	 */
	public FFMpegUtil(String originFileUri) {
		String ffmpegPath = PropertiesUtils.getProperty("ffmpeg.address");
		
		logger.info("ffmpeg.address=" + ffmpegPath);
		if (ffmpegPath != null) {
			File file = new File(ffmpegPath);
			if (file != null && file.exists()) {
				this.ffmpegUri = ffmpegPath;
			} else {
				if (OS.contains("windows")) {
					this.ffmpegUri = WebApplicationManager.servletContext.getRealPath("/video/ffmpeg.exe");
					
					logger.info("1.this.ffmpegUri=" + ffmpegUri);
				}
			}
		} else {
			if (OS.contains("windows")) {
				this.ffmpegUri = WebApplicationManager.servletContext.getRealPath("/video/ffmpeg.exe");
				logger.info("2.this.ffmpegUri=" + ffmpegUri);
			}
		}

		this.originFileUri = originFileUri;
	}

	private static String OS = System.getProperty("os.name").toLowerCase();

	/**
	 * 获取视频时长
	 * 
	 * @return
	 */
	public long getRuntime() {
		runtime = 0;
		status = FFMpegUtilStatus.GettingRuntime;
		System.out.println(status);
		cmd.clear();
		cmd.add(ffmpegUri);
		cmd.add("-i");
		cmd.add(originFileUri);
		VideoCmdExecuter.exec(cmd, this);
		return runtime;
	}

	/**
	 * 检测文件是否是支持的格式 将检测视频文件本身，而不是扩展名
	 * 
	 * @return
	 */
	public boolean isSupported() {
		isSupported = false;
		status = FFMpegUtilStatus.CheckingFile;
		cmd.clear();
		cmd.add(ffmpegUri);
		cmd.add("-i");
		cmd.add(originFileUri);
		cmd.add("Duration: (.*?), start: (.*?), bitrate: (\\d*) kb\\/s");
		VideoCmdExecuter.exec(cmd, this);
		logger.info("==isSupported===" + isSupported);
		return isSupported;
	}

	private boolean isSupported;

	/**
	 * 生成视频截图
	 * 
	 * @param imageSavePath
	 *            截图文件保存全路径
	 * @param screenSize
	 *            截图大小 如640x480
	 */
	public void makeScreenCut(String imageSavePath, String screenSize) {
		cmd.clear();
		cmd.add(ffmpegUri);
		cmd.add("-i");
		cmd.add(originFileUri);
		cmd.add("-y");
		cmd.add("-f");
		cmd.add("image2");
		cmd.add("-ss");
		cmd.add("2");
		cmd.add("-t");
		cmd.add("0.001");
		cmd.add("-s");
		cmd.add(screenSize);
		cmd.add(imageSavePath);
		VideoCmdExecuter.exec(cmd, this);

	}

	private List<String> cmd = new ArrayList<String>();

	public void dealString(String str) {
		System.out.println("==dealString===" + str);
		logger.info("==dealString===" + str);
		switch (status) {
		case Empty:
			break;
		case CheckingFile: {
			if (-1 != str.indexOf("Metadata:"))
				this.isSupported = true;
			break;
		}
		case GettingRuntime: {
			String strs = "";

			if (str.contains("Duration")) {
				System.out.println(str.substring(str.indexOf(":") + 1, str.indexOf(",")));
				strs = str.substring(str.indexOf(":") + 1, str.indexOf(","));
				if (strs != null) {
					runtime = TimeUtils.Test(strs);
				}
			}
			// Matcher m = Pattern.compile("Duration").matcher(str);
			// System.out.println("====msgm======="+m);
			// while (m.find()) {
			// String msg = m.group();
			// msg = msg.replace("Duration: ","");
			// System.out.println("====msg======="+msg);
			// runtime = TimeUtils.Test(strs);
			// }
			break;
		}
		}// switch
	}

	public static void main(String[] args) {
		FFMpegUtil ffMpegUtil = new FFMpegUtil("c:\\ffmpeg.exe", "c:\\1471850652584_6327.mp4");
		long runtime2 = ffMpegUtil.getRuntime();

		System.out.println(runtime2);

		ffMpegUtil.makeScreenCut("c:\\100.png", "800*300");
	}
}