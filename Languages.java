import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.Scanner;
import java.util.HashMap;

class Languages {

	public static void main(String[] args){
		System.out.println(chooseLanguage());
	}

	public static HashMap chooseLanguage(){

		boolean languageChosen = false;
		Scanner sc = new Scanner(System.in);
		File langFile;
		String playerChoice = "English.csv";
		while(languageChosen != true){
			System.out.println("Choose language:");
			printLanguages();
			playerChoice = sc.nextLine() + ".csv";
			langFile = new File(playerChoice);

			if (langFile.exists()){
				languageChosen = true;
			} else{
				System.out.println("The chosen file does not exist, please note your selection is case sensitive, try again");
			}
		}
		sc.close();

		return parse(playerChoice);
	}

	public static void printLanguages(){
		File folder = new File(".");
		FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(".csv");  // Filters for .csv files
            }
        };

		File[] listOfFiles = folder.listFiles(filter);

		System.out.println("Below you see all the languages currently supported");

		for(File e: listOfFiles){
			System.out.println(e.getName().split(".csv")[0]);
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
            dataParsed = data.split(",", 2);
            map.put(dataParsed[0], dataParsed[1]);
        }
        sc.close();
        } catch (FileNotFoundException e){
            System.out.println("error");
        }

        return map;
    }


}
