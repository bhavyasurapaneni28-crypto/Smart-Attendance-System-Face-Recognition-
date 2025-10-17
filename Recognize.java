import org.opencv.core.*;
import org.opencv.face.LBPHFaceRecognizer;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.videoio.VideoCapture;
import org.opencv.imgproc.Imgproc;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Recognize {
    static { System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }

    public static void main(String[] args) {
        // Load face detector
        CascadeClassifier faceDetector = new CascadeClassifier("haarcascade_frontalface_alt.xml");

        // Load images for training
        String dataPath = "data/";
        File folder = new File(dataPath);
        File[] files = folder.listFiles();
        List<Mat> images = new ArrayList<>();
        List<Integer> labels = new ArrayList<>();
        int label = 0;

        for(File file : files) {
            Mat img = Imgcodecs.imread(file.getAbsolutePath(), Imgcodecs.IMREAD_GRAYSCALE);
            images.add(img);
            labels.add(label++);
        }

        LBPHFaceRecognizer recognizer = LBPHFaceRecognizer.create();
        recognizer.train(images, Converters.vector_int_to_Mat(labels));

        VideoCapture cap = new VideoCapture(0);
        Mat frame = new Mat();

        System.out.println("Starting face recognition, press Ctrl+C to stop");

        while(true) {
            cap.read(frame);
            if(frame.empty()) continue;

            Mat gray = new Mat();
            Imgproc.cvtColor(frame, gray, Imgproc.COLOR_BGR2GRAY);

            MatOfRect faces = new MatOfRect();
            faceDetector.detectMultiScale(gray, faces);

            for(Rect rect : faces.toArray()) {
                Mat face = new Mat(gray, rect);
                int[] predictedLabel = new int[1];
                double[] confidence = new double[1];

                recognizer.predict(face, predictedLabel, confidence);

                if(predictedLabel[0] < files.length) {
                    String name = files[predictedLabel[0]].getName().split("_")[0];
                    Utils.markAttendance(name);
                }
            }
        }
    }
}
