A simple face recognition-based attendance system built with Java Swing and OpenCV.It allows user registration with face images, real-time face detection and recognition via webcam, and automatic attendance logging.

Features

1. Face registration (store user faces with name and ID)
2. Real-time webcam face detection using OpenCV
3. Face recognition using OpenCV's LBPHFaceRecognizer
4. Auto attendance marking with timestamp
5. View and export attendance logs
6. GUI built using Java Swing
7. File-based face data storage (for small setups)
8. Prevents duplicate attendance in the same session

Technologies Used
1.Component	Technology
2.Programming	Java
3.GUI	Swing
4.Face Recognition	OpenCV (Java)
5.Webcam Access	OpenCV VideoCapture
6.Data Storage	CSV / SQLite (optional)

Folder Structure
JavaFaceAttendance/
│
├── JavaFaceAttendance.java       # Main GUI
├── FaceRegister.java             # Face registration module
├── FaceRecognizer.java           # Real-time recognition
├── AttendanceLogger.java         # Handles attendance logging
├── lbph_model.xml                # Trained face model
├── faces/                        # Stored face images
├── attendance.csv                # Logs attendance records
└── README.md

How to Run
Prerequisites:
Java JDK 8 or higher
OpenCV (Java bindings configured)
A webcam

Steps:
Install OpenCV with Java bindings:
Download OpenCV
Set up OpenCV .jar and native .dll/.so files in your project

Compile the Program:
javac -cp .;<path_to_opencv>/opencv-4.x.x.jar JavaFaceAttendance.java
Replace <path_to_opencv> with your OpenCV jar path.

Run the Program:
bash
Copy code
java -cp .;<path_to_opencv>/opencv-4.x.x.jar -Djava.library.path=<path_to_opencv_build>/x64 JavaFaceAttendance
On Linux/macOS, replace ; with : in classpath
The GUI will open. You can:

Register faces
Start recognition
Log attendance
View/export attendance records

Sample Features in GUI
Register User
Enter name/ID, capture 10+ face images
Train and save model
Start Attendance
Open webcam
Recognize known faces
Mark time-stamped attendance in a CSV file
Export Attendance
Export .csv logs to Excel for reporting

Known Limitations
Recognition accuracy depends on training image quality and lighting
Not suitable for large-scale use without database/backend
Only supports LBPH (OpenCV) face recognition

Future Improvements
MySQL database support
Deep learning face recognition (e.g., FaceNet)
Web dashboard integration
Email/SMS notification

