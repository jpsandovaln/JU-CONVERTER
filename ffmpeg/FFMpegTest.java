package ffmpeg;
import java.util.ArrayList;
import java.util.List;

public class FFMpegTest {
    private String ffmpegExe;
    public FFMpegTest(String ffmpegExe) {
        super();
        this.ffmpegExe = ffmpegExe;
    }
    public void convertor (String vidoInputPath, String videoOutputPath) throws Exception {
         List<String> command = new ArrayList<>();
         command.add(ffmpegExe);
         command.add("-i");
         command.add(vidoInputPath);
         command.add(videoOutputPath);
         ProcessBuilder process = new ProcessBuilder(command);
         for (String c : command) {
            System.out.println(c);
         }
         process.start();

    }
    public static void main(String[] args) {
        FFMpegTest ffmpeg = new FFMpegTest("C:\\ffmpeg-master-latest-win64-gpl\\bin\\ffmpeg.exe");
        try {
            ffmpeg.convertor("C:\\Users\\alvar\\Desktop\\7millas.mp3", "C:\\Users\\alvar\\Desktop\\7milla4.wav");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
