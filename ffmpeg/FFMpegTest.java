package ffmpeg;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder.Redirect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.json.JSONObject;

import com.google.gson.Gson;

public class FFMpegTest {
    private String ffmpegExe;
    public FFMpegTest(String ffmpegExe) {
        super();
        this.ffmpegExe = ffmpegExe;
        final File carpeta = new File("D:/file");
        listarFicherosPorCarpeta(carpeta );
    }
    public void convertor (String vidoInputPath, String videoOutputPath, List<String> com) throws Exception {
         List<String> command = new ArrayList<>();
         String comando = "volume = 0.2";
         String comando2 =  "libopus";
         command.add(ffmpegExe);
         command.add("-i");
         command.add(vidoInputPath);
         command.add("-c:a ");
         //command.add("-af volume = 0.2");
         command.add(comando2);
         command.add(videoOutputPath);
         ProcessBuilder builder = new ProcessBuilder(com);
         //for (String c : com) {
          //  System.out.println(c);
         //}
         Process process = builder.start();
         InputStream errorStream = process.getErrorStream();
         InputStreamReader inputStreamReader = new InputStreamReader(errorStream);
         BufferedReader br = new BufferedReader(inputStreamReader);
         String line = "";
         while ((line = br.readLine())!= null)  {

         }
         if ( br!= null) {
            br.close();
         }
         if (inputStreamReader != null) {
            inputStreamReader.close();
         }
         if (errorStream != null) {
            errorStream.close();
         }

          //System.out.println("command: "+ proce  ss.command());

    }
    public static void main(String[] args) throws IOException {

        /*Json obj = new JSONObject();

        obj.put("encode", "codec");
        obj.put("channels", "4");
        obj.put("bitrate", "128k");
        obj.put("format", "mp3");

        System.out.print(obj);
        List<String> testList = new ArrayList<>();
        //testList.add(test1);*/

        String json = "";
        try {
            BufferedReader read = new BufferedReader(new FileReader("D:\\converter\\JU-CONVERTER\\ffmpeg\\json.json"));
            String linea;
            while ((linea = read.readLine()) != null) {
                json += linea;
            }
            read.close();

        } catch(FileNotFoundException ex) {
            System.out.println("no funciona");
        }
        

        Gson gson = new Gson();

        ConversionData data = gson.fromJson(json, ConversionData.class);
        data.fillData();
        //Type type = new TypeToken<ArrayList<String>>(){}.getType();

        //ArrayList<String> array = gson.fromJson(json, type);

        FFMpegTest ffmpeg = new FFMpegTest("C:\\ffmpeg-master-latest-win64-gpl\\bin\\ffmpeg.exe");
        List<String> parameters = new ArrayList<>();
        parameters.add("2");
        parameters.add("128k");
        parameters.add("aac_encode");
        parameters.add("wav");
        final File carpeta = new File("D:/file");
        AudioConverter converter = new AudioConverter(data.getRequest(), listarFicherosPorCarpeta(carpeta));
        try {
            ffmpeg.convertor("C:\\Users\\alvar\\Desktop\\7millas.mp3", "C:\\Users\\alvar\\Desktop\\7milla4.mp3", converter.getCommand());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static String listarFicherosPorCarpeta(final File carpeta) {
        String directionFile = "";
        for (final File ficheroEntrada : carpeta.listFiles()) {
            if (ficheroEntrada.isDirectory()) {
                listarFicherosPorCarpeta(ficheroEntrada);
            } else {
                System.out.println(ficheroEntrada.getName());
                System.out.println(ficheroEntrada.getAbsolutePath());
                directionFile = ficheroEntrada.getAbsolutePath();
            }
        }
        return directionFile;
    }


}
