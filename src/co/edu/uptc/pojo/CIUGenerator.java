package co.edu.uptc.pojo;

import java.util.Random;

public class CIUGenerator {
    public static String generateCIU() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }
}
