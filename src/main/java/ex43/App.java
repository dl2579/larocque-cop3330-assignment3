package ex43;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {

    public static class websiteGenerator{
        File websiteDirectory;

        websiteGenerator(File websiteDirectory){
            this.websiteDirectory = websiteDirectory;
            new File(websiteDirectory.getPath()).mkdirs();
        }

        public void generateWebsite(String webName, String author, Boolean js, Boolean css){
            File websiteFolder = new File(websiteDirectory.getPath() + "/" + webName);
            websiteFolder.mkdirs();
            System.out.println("Created " + websiteFolder.getPath());

            try {
                FileWriter myWriter = new FileWriter(websiteFolder.getPath() + "/index.html");
                myWriter.write("<!DOCTYPE html>\n<html>\n<head>\n");
                String titleTag = String.format("    <title>%s</title>\n", webName);
                myWriter.write(titleTag);

                String metaTag = String.format("    <meta name=\"author\" content=\"%s\">\n", author);
                myWriter.write(metaTag);

                myWriter.write("<head>\n<body>\n\n<h1>This is a heading</h1>\n<p>This is a paragraph.</p>\n\n</body>\n</html>");

                myWriter.close();
                System.out.println("Created " + websiteFolder.getPath() + "/index.html");

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Cannot generate index.html");
            }

            if(js){
                new File(websiteFolder.getPath()+ "/js").mkdirs();
                System.out.println("Created " + websiteFolder.getPath() + "/js");
            }

            if(css){
                new File(websiteFolder.getPath() + "/css").mkdirs();
                System.out.println("Created " + websiteFolder.getPath() + "/css");
            }
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Site name: ");
        String name = sc.nextLine();

        System.out.print("Author: ");
        String author = sc.nextLine();

        System.out.print("Do you want a folder for JavaScript? ");
        String jsResponse;
        while(true) {
            try {
                jsResponse = sc.nextLine();
                if (jsResponse.equals("y") || jsResponse.equals("n")) {
                    break;
                } else{
                    throw new Exception("invalid input");
                }
            } catch (Exception e) {
                System.out.println("\nInvalid input. Please enter y or n .");
                System.out.print("Do you want a folder for JavaScript? ");
                //System.exit(1);
            }
        }

        System.out.print("Do you want a folder for CSS? ");
        String cssResponse;
        while(true) {
            try {
                cssResponse = sc.nextLine();
                if (cssResponse.equals("y") || cssResponse.equals("n")) {
                    break;
                } else{
                    throw new Exception("invalid input");
                }
            } catch (Exception e) {
                System.out.println("\nInvalid input. Please enter y or n .");
                System.out.print("Do you want a folder for CSS? ");
            }
        }

        Boolean js = false;
        Boolean css = false;

        if(jsResponse.equals("y")){
            js = true;
        }
        if(cssResponse.equals("y")){
            css = true;
        }

        File websiteDirectory = new File("src/main/java/ex43/website/");
        websiteGenerator wg = new websiteGenerator(websiteDirectory);
        wg.generateWebsite(name, author, js, css);

    }
}
