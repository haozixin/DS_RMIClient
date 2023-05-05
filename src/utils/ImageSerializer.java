package utils;

import java.awt.image.BufferedImage;
import java.io.*;

public class ImageSerializer {
    public static byte[] serialize(BufferedImage image) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(image);
        oos.flush();
        byte[] data = bos.toByteArray();
        oos.close();
        bos.close();
        return data;
    }
    public static BufferedImage deserializeImage(byte[] data) {
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(data);
            ObjectInputStream ois = new ObjectInputStream(bis);
            Object obj = ois.readObject();
            if (obj instanceof BufferedImage) {
                return (BufferedImage) obj;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
