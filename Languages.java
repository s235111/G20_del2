import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.Scanner;
import java.util.HashMap;

class Languages {

	public static void main(String[] args){
		printLanguages();
	}

	public static void printLanguages(){
		File folder = new File(".");
		FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(".csv");  // Filters for .csv files
            }
        };

		File[] listOfFiles = folder.listFiles(filter);

		for(File e: listOfFiles){
			System.out.println(e);
		}
}


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
