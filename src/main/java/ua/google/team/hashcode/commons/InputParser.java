package ua.google.team.hashcode.commons;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class InputParser {

        static int videosCount, endPointsCount, requestDescriptionsCount, cachesCount, cacheSize;
        static String test;

        public static void main(String[] args) throws IOException {
            InputParser obj = new InputParser();
            obj.getFile("me_at_the_zoo.in");
//            obj.getFile("me_at_the_zoo.in");
            System.out.println("count of Videos " + videosCount);
            System.out.println("count of endPoints " + endPointsCount);
            System.out.println("count of requests " + requestDescriptionsCount);
            System.out.println("count of Caches " + cachesCount);
        }

        private void getFile(String fileName) throws IOException {

//            StringBuilder result = new StringBuilder("");

//            List<Cache> allCaches = new ArrayList<>();
//            List<Video> allVideos = new ArrayList<>();

            ClassLoader classLoader = getClass().getClassLoader();
            Path path = Paths.get(classLoader.getResource(fileName).getFile());
            List<String> strings = Files.readAllLines(path);
            System.out.println(strings);

//            try (Scanner scanner = new Scanner(file)) {
//
//                while (scanner.hasNextLine()) {
//                    String line = scanner.nextLine();
////                test = line;
////                try (Scanner scan = new Scanner(line)) {
//                    Scanner scan = new Scanner(line);
//                    while (scan.hasNext()) {
//                        videosCount = scan.nextInt();
//                        endPointsCount = scan.nextInt();
//                        requestDescriptionsCount = scan.nextInt();
//                        cachesCount = scan.nextInt();
//                        cacheSize = scan.nextInt();
////                        for (int i = 0; i < cachesCount; i++) {
////                            allCaches.add(new Cache(i++, cacheSize));
////                        }
////
////                        for (int i = 0; i < videosCount; i++) {
////                            allVideos.add(new Video(i, scan.nextInt()));
////                        }
////                        break;
//                    }
////                    scan.close();
////                } catch (IOException e){
////                    e.printStackTrace();
////                }
////                result.append(line).append("\n");
//                }
//
//                scanner.close();
//
//            }catch(IOException e){
//                e.printStackTrace();
//            }
//            return result.toString();
        }
}