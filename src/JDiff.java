import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
/**
    * If you have two lists to compare, and the first list is the superset of the second
    * then you can see the diferences without compare line by line and see what is diferente 
    * beteween the firs and the second  (Only if FIRST contains SECOND)
    * you can redirect the output to an file using > (java Diff first second > diff_text)
*/
public class JDiff {
    public static void main(String args[]) throws IOException {
        if(args[0].equals("--help")){
            helpMessage();
            return;
        }
        String sourceFile = args[0];
        String targetFile = args[1];
        List<String> sourceValues = readFromFile(sourceFile);
        List<String> targetValues = readFromFile(targetFile);
        List<String> diff = new ArrayList();

        sourceValues.forEach(value->{
            if(!targetValues.contains(value)){
                diff.add(value);
            }
        });

        System.out.println("There are "+ diff.size()+ " diferent values");
        diff.forEach(System.out::println);
    }

      private static List<String> readFromFile(String filename) throws IOException{

        List<String> values = new ArrayList();
        String line = "";

        BufferedReader br = new BufferedReader(new FileReader(filename));
        do {
            line = br.readLine();
            if(line == null) break;
            values.add(line);
        } while(true);
        return values;
    }
    private static void helpMessage(){
            String message =  "\n\t\t\t\tJDIFF\nIf you have two lists to compare, and the first list is the superset of the second\n"+
            "then you can see the diferences without compare line by line and see what is diferente\n"+
            "beteween the firs and the second  (Only if FIRST contains SECOND)\n"+
            "you can redirect the output to an file using > (java JDiff first second > diff_text)\n";
            System.out.println(message);
    }
}