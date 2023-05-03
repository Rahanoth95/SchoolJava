import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class wk8 {
    public static void main(String[] args) {
        //the index represents the number of lines in the text file
        // this will determine our rows for the 2d array
        int index = 0;
        //we have to get the number of lines first in our text file
        // so we open up the students.txt file and read it using Scanner object. When there is a line then we increment index
        // we enclose the process in a try catch since we want to check if the students.txt file existtry
        {
            File file1 = new File("students.txt");
            Scanner reader1 = new Scanner(file1);
            while (reader1.hasNextLine()) {
                reader1.nextLine();
                index++;
            }
            reader1.close();
        } catch(FileNotFoundException ex){
            System.out.println("File not found.");
        }//now we now the index we can create our 2d array studentInfo
        // using index as our row. Since we already know that we have 5 datafor student information
        // id, name, age, sex and course we can use 5 as a index for column
        String[][] studentInfo = new String[index][5];
        int ctr = 0;
        //we open students.txt fle again and read it
        try {
            File file2 = new File("students.txt");
            Scanner reader2 = new Scanner(file2);
            //each line is contains student information each data is sperated by a comma we need to split each data and
            //put it first in an array calledline we insert our line elements to our studentInfo array
            while (reader2.hasNextLine()) {
                String[] line = reader2.nextLine().split(",");
                studentInfo[ctr][0] = line[0];
                studentInfo[ctr][1] = line[1];
                studentInfo[ctr][2] = line[2];
                studentInfo[ctr][3] = line[3];
                studentInfo[ctr][4] = line[4];
                ctr++;
            }
            reader2.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }//we display the student information in a table format using a nested for loop
        System.out.printf("%-15s%-30s%-5s%-5s%s\n", "ID Number", "Name", "Age", "Sex", "Course");
        for (int i = 0; i < studentInfo.length; i++) {
            for (int j = 0; j < studentInfo[i].length; j++) {
                switch (j) {
                    case 0:
                        System.out.printf("%-15s", studentInfo[i][j]);
                        break;
                    case 1:
                        System.out.printf("%-30s", studentInfo[i][j]);
                        break;
                    case 2:
                        System.out.printf("%-5s", studentInfo[i][j]);
                        break;
                    case 3:
                        System.out.printf("%-5s", studentInfo[i][j]);
                        break;
                    case 4:
                        System.out.printf("%s", studentInfo[i][j]);
                        break;
                }
            }
            System.out.println();
        }
    }
}