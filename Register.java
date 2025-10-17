import org.opencv.core.*;
import org.opencv.videoio.VideoCapture;
import org.opencv.imgcodecs.Imgcodecs;
import java.util.Scanner;

public class Register {
    static { System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }

    public static void main(String[] args) {
        Utils.createDataFolder();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        VideoCapture cap = new VideoCapture(0);
        if(!cap.isOpened()) {
            System.out.println("Cannot open webcam");
            return;
        }

        Mat frame = new Mat();
        int count = 0;

        System.out.println("Capturing images, press Ctrl+C to stop");

        while(count < 20) {  // Capture 20 images
            cap.read(frame);
            if(!frame.empty()) {
                String filename = "data/" + name + "_" + count + ".jpg";
                Imgcodecs.imwrite(filename, frame);
                System.out.println("Captured: " + filename);
                count++;
            }
        }

        cap.release();
        System.out.println("Registration complete for " + name);
    }
}
