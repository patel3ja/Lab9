import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.ArrayList;

class Main {

  public static void main(String[] args) {
    ArrayList<Person> people = new ArrayList<Person>();
    String name = "", age = "", color = "";

    try {
      FileWriter toWriteFile = new FileWriter("data.txt");
      BufferedWriter output = new BufferedWriter(toWriteFile);
      for (int i=0; i<people.size(); i++ ) {
        output.write(people.get(i).getName());
        output.newLine();
        output.write(Integer.toString(people.get(i).getAge()));
        output.newLine();
        output.write(people.get(i).getColor());
        output.newLine();
        output.flush();
      }
      output.close();
    } catch (IOException excpt) {
      excpt.printStackTrace();
    }
    try {
      FileReader toOpenFile = new FileReader("data.txt");
      BufferedReader reader = new BufferedReader(toOpenFile);
      while (reader.ready()) {
        name = reader.readLine();
        age = reader.readLine();
        color = reader.readLine();
        System.out.printf("%-10 %-10 %-10", name, age, color);
      }
      reader.close();
    } catch (IOException exception) {
        System.out.println("An error occurred: " + exception);
    }
  }
}