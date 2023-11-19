package fileexceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("Current Working Directory (cd) = " +
                new File("").getAbsolutePath());

        String fileName = "Input&Output/files/testing.csv";

        testFile2(fileName);

        File file = new File(fileName);
        System.out.println(file.getAbsolutePath());
        if (!file.exists()) {
            System.out.println("I can't run unless this file exists");
            return;
        }

        System.out.println("I'm good to go");

        for (File f : File.listRoots()) {
            System.out.println(f);
        }

        Path path = Paths.get("Input&Output/files/testing.csv");
        System.out.println(file.getAbsolutePath());
        if (!Files.exists(path)) {
            System.out.println("2. I can't run unless this file exists");
            return;
        }

        System.out.println("2. I'm good to go");
    }

    public static void testFile(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        FileReader reader = null;
        try {
//            List<String> lines = Files.readAllLines(path);
            reader = new FileReader(fileName);
        } catch (IOException e) {
            int i = 1 / 0;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Maybe I'd log something either way...");
        }

        System.out.println("File exists and able to use as a resource");
    }

    public static void testFile2(String fileName) {

        try (FileReader reader = new FileReader(fileName)) {

        } catch (FileNotFoundException e) {
            System.out.println("File " + fileName + " does not exist");
            throw new RuntimeException(e);
        } catch (NullPointerException | IllegalArgumentException badData) {
            System.out.println("User has added bad data "+ badData.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.println("Something unrelated and unexpected happened");
        } finally {
            System.out.println("Maybe I'd log something either way...");
        }
        System.out.println("File exists and able to use as a resource");
    }
}
