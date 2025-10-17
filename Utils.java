import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {

    // Save attendance to CSV
    public static void markAttendance(String name) {
        String file = "attendance.csv";
        try {
            File f = new File(file);
            if(!f.exists()) {
                FileWriter writer = new FileWriter(f);
                writer.append("Name,Date,Time\n");
                writer.close();
            }

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");

            FileWriter writer = new FileWriter(file, true);
            writer.append(name + "," + now.format(date) + "," + now.format(time) + "\n");
            writer.close();

            System.out.println("Attendance marked for " + name);

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    // Create data folder if not exists
    public static void createDataFolder() {
        File dir = new File("data");
        if(!dir.exists()) dir.mkdir();
    }
}
