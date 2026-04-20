package Storage;
import java.io.File;

public class Data {
    private String text;
    private File image;
    private String voicePath; // optional
    private String speaker;

    public Data(String speaker, String text, File image, String voicePath) {
        this.speaker = speaker;
        this.text = text;
        this.image = image;
        this.voicePath = voicePath;
    }

    public String getSpeaker() {
        try {
            return speaker;
        } catch (Exception e) {
            return null;
        }
    }

    public String getText() {
        try {
            return text;
        } catch (Exception e) {
            return null;
        }
    }

    public File getImage() {
        try {
            return image;
        } catch (Exception e) {
            return null;
        }
    }

    public String getVoicePathe() {
        try {
            return voicePath;
        } catch (Exception e) {
            return null;
        }
    }
}