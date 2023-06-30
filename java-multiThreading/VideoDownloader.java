import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class VideoDownloader implements Runnable {
    private final String videoUrl;
    private final String savePath;

    public VideoDownloader(String videoUrl, String savePath) {
        this.videoUrl = videoUrl;
        this.savePath = savePath;
    }

    @Override
    public void run() {
        try {
            downloadVideo();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void downloadVideo() throws IOException {
        URL url = new URL(videoUrl);
        try (BufferedInputStream inputStream = new BufferedInputStream(url.openStream());
             FileOutputStream outputStream = new FileOutputStream(savePath)) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer, 0, buffer.length)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }
    }

    public static void main(String[] args) {
        String[] videoUrls = {
            "https://www.onirikal.com/videos/mp4/animatic_caronte.mp4",
            "https://www.onirikal.com/videos/mp4/animatic_caronte.mp4",
            "https://www.onirikal.com/videos/mp4/animatic_caronte.mp4",
            "https://www.onirikal.com/videos/mp4/animatic_caronte.mp4",
            "https://www.onirikal.com/videos/mp4/animatic_caronte.mp4"
        };
        
        String saveDirectory = "C:\\Users\\Dell\\Desktop\\java\\multithread.java";
        Thread[] threads = new Thread[videoUrls.length];
        
        for (int i = 0; i < videoUrls.length; i++) {
            String savePath = saveDirectory + "video" + (i + 1) + ".mp4";
            threads[i] = new Thread(new VideoDownloader(videoUrls[i], savePath));
            threads[i].start();
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("All videos downloaded successfully.");
    }
}
