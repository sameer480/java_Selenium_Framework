package utils;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class TestDataUtil {

    private static final String TEST_DATA_PATH =
            System.getProperty("user.dir") + "/src/main/resources/testdata.json";

    //  Random number
    public static int getRandomNumber(int min, int max) {
        return new Random().nextInt(max - min) + min;
    }

    //  Random email
    public static String getRandomEmail() {
        return "user" + System.currentTimeMillis() + "@test.com";
    }

    //  Random string
    public static String getRandomString(int length) {
        String chars = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = new Random().nextInt(chars.length());
            sb.append(chars.charAt(index));
        }
        return sb.toString();
    }

    //  Read JSON file
    public static JSONObject getJsonData() {
        try {
            String content = new String(Files.readAllBytes(Paths.get(TEST_DATA_PATH)));
            return new JSONObject(content);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read test data", e);
        }
    }

    //  Get specific value from JSON
    public static String getValue(String key) {
        return getJsonData().getString(key);
    }
}