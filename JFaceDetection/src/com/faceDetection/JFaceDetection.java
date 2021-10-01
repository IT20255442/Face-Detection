package com.faceDetection;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

public class JFaceDetection {

	public static void main(String[] args) {

//		load the openVc libraries
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
//		path for image(you can add your wishing image)
		String imgFile =  "images/tv_series.jpg";
		Mat src = Imgcodecs.imread(imgFile);
		
//		add xml file that tells the app how a face look like
//		this serves to help app to detect image faces
		String xmlFile = "xmls/lbpcascade_frontalface.xml";
		CascadeClassifier cc = new CascadeClassifier(xmlFile);
		
		MatOfRect faceDetection = new MatOfRect();
		cc.detectMultiScale(src, faceDetection);
		System.out.println(String.format("Detected fades %d", faceDetection.toArray().length));
		
//		how to show detected face
		for(Rect rect: faceDetection.toArray()) {
			Imgproc.rectangle(src, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height) , new Scalar(0,0,255), 3);
		}
//		get face detected image
		Imgcodecs.imwrite("images/tv_series_out.jpg", src);
		System.out.println("Image Detection Finished !");
		

	}

}




























