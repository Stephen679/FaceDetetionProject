package FaceDetection;
import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

public class Main {
    static {System.loadLibrary(Core.NATIVE_LIBRARY_NAME);}
    public static void main(String[] args) {

        String imgfile = "people.jpg";
        Mat src = Imgcodecs.imread(imgfile);
        String xmlfile = "lbpcascade_frontalface.xml";
        CascadeClassifier cc = new CascadeClassifier(xmlfile);

        MatOfRect faceDetection = new MatOfRect();
        cc.detectMultiScale(src ,faceDetection);
        System.out.println(String.format("Detected face : %d",faceDetection.toArray().length));
        for(Rect rect : faceDetection.toArray()) {
            Imgproc.rectangle(src, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height), new Scalar(0, 0, 255), 3);
        }
        
        Imgcodecs.imwrite("people_out.jpg",src);
        System.out.println("Image Detection finished.");

    }
}
