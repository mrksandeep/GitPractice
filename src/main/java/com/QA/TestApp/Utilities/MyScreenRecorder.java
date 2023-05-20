package com.QA.TestApp.Utilities;

import static org.monte.media.FormatKeys.EncodingKey;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.FormatKeys.KeyFrameIntervalKey;
import static org.monte.media.FormatKeys.MIME_AVI;
import static org.monte.media.FormatKeys.MediaTypeKey;
import static org.monte.media.FormatKeys.MimeTypeKey;
import static org.monte.media.VideoFormatKeys.CompressorNameKey;
import static org.monte.media.VideoFormatKeys.DepthKey;
import static org.monte.media.VideoFormatKeys.ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE;
import static org.monte.media.VideoFormatKeys.QualityKey;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.Registry;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;

public class MyScreenRecorder extends ScreenRecorder {
	public static ScreenRecorder screenRecorder;
	public String name;
	public static FrameWorkUtility fUtil=new FrameWorkUtility();
	public static Log logger=new Log();
	public static String recordingName;


	public MyScreenRecorder(GraphicsConfiguration cfg, Rectangle captureArea, Format fileFormat,
			Format screenFormat, Format mouseFormat, Format audioFormat, File movieFolder, String name)
					throws IOException, AWTException {
		super(cfg, captureArea, fileFormat, screenFormat, mouseFormat, audioFormat, movieFolder);
		this.name = name;

	}

	@Override
	protected File createMovieFile(Format fileFormat) throws IOException {

		if (!movieFolder.exists()) {
			movieFolder.mkdirs();
		} else if (!movieFolder.isDirectory()) {
			throw new IOException("\"" + movieFolder + "\" is not a directory.");
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
		return new File(movieFolder,
				name + "-" + dateFormat.format(new Date()) + "." + Registry.getInstance().getExtension(fileFormat));

	}

	public static void startRecording() throws Exception {
		logger.info("Screen Recording Started ...");
		System.out.println("Screen Recording Started ...");
		File file ;
		if(fUtil.readInput("ExtentReportingLevel").equalsIgnoreCase("Suite")) {
			recordingName="Suite_Run_Recording";
			file = new File(BaseScript.ResultLocation.get()+File.separator+"Suite_Execution_Report"+File.separator+"Test_Execution_Recordings"+File.separator);
		}else {
			recordingName=BaseScript.scenarioName.get();
			file = new File(BaseScript.ResultLocation.get()+File.separator+BaseScript.testSetName.get()+"_"+BaseScript.scenarioName.get()+File.separator+"Test_Execution_Recordings"+File.separator);
		}


		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;

		Rectangle captureSize = new Rectangle(0, 0, width, height);

		GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().
				getDefaultScreenDevice()
				.getDefaultConfiguration();

		screenRecorder = new MyScreenRecorder(gc, captureSize,
				new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
				new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
						CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24, FrameRateKey,
						Rational.valueOf(15), QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 60),
				new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
				null, file, recordingName);

		screenRecorder.start();

	}

	public static void stopRecording() throws Exception {
		screenRecorder.stop();
		logger.info("Screen Recording Stopped ...");
		logger.info("Recording File Name : "+recordingName);

	}

}