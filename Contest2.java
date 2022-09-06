import java.io.File;
import java.io.*;
import java.util.*;
import java.io.FileNotFoundException;

public class Contest2 {

  public static void removeSpam(String folder) {

    // Your logic goes here
    String spamwords[] = {
      "idiot",
      "stupid"
    };
    File Folder = new File(folder);
    File[] listOfFiles = Folder.listFiles();
    for (File file: listOfFiles) {
      try {
        String fileNameWithoutExtension = file.getName().substring(0, file.getName().lastIndexOf('.'));
        File newfile = new File(Folder, fileNameWithoutExtension + "_processed" + ".txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(newfile));

        Scanner myReader = new Scanner(file);
        while (myReader.hasNextLine()) {
          String data = myReader.nextLine();
          String[] line = data.split(" ");
          for (String word: line) {

            try {
              if (Arrays.asList(spamwords).contains(word)) {
                String str = "****";

                writer.write(str);

              } else {
                writer.write(word);

              }

            } catch (IOException e) {
              System.out.println(e);

            }

            writer.write(" ");
          }
          writer.write("\n");
        }
        myReader.close();
        writer.close();
      } catch (FileNotFoundException e) {
        System.out.println(e);
        e.printStackTrace();
      } catch (IOException e) {
        System.out.println(e);

      }

    }
  }

  public static void main(String[] args) throws Exception {
    String folder = "C:/textfiles";
    removeSpam(folder);
  }

}