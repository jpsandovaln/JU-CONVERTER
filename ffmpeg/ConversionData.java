package ffmpeg;

import java.util.ArrayList;
import java.util.List;

public class ConversionData {
    String encode;
    String channels;
    String bitrate;
    String format;
    List<String> request;
    public ConversionData(String encode, String channels, String bitrate, String format) {
        this.encode = encode;
        this.channels = channels;
        this.bitrate = bitrate;
        this.format = format;

    }
    public void fillData() {
        request = new ArrayList<>();
        request.add(encode);
        request.add(channels);
        request.add(bitrate);
        request.add(format);
        System.out.println(encode);
        System.out.println(channels);
        System.out.println(bitrate);
        System.out.println(format);
    }
    public List<String> getRequest() {
        return request;
    }

}
