import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;

class Languages {

    public static HashMap parse(String fileName){
        HashMap<String,String> map = new HashMap<>();
        String data;
        String[] dataParsed;

		// try required to not get error
        try{
        File lang = new File(fileName);
        Scanner sc = new Scanner(lang);
        while(sc.hasNextLine()){
            data = sc.nextLine();
            dataParsed = data.split(",");
            map.put(dataParsed[0], dataParsed[1]);
        }
        sc.close();
        } catch (FileNotFoundException e){
            System.out.println("error");
        }

        return map;
    }


}
