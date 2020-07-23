package datapull;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;


public class PullInfo {

    private File targetFile;
    private String targetPhrase;
    private String requestedInfo;



    public PullInfo(){
        targetFile = new File ("src\\datapull\\config.properties");
    }

    public void setRequestedInfo(){
        System.out.println("1 for username, 2 for profession, 3 for whether we hire user:\n");
        Scanner question = new Scanner(System.in);
        int request = question.nextInt();
        switch (request) {
            case 1: targetPhrase = "name = ";
                break;
            case 2: targetPhrase = "job = ";
                break;
            case 3: targetPhrase = "hired = ";
                break;
            default: targetPhrase = "nothing = ";
                break;
        }
    }


    public void getDocInfo(){
        try {
            Scanner infoFinder = new Scanner(targetFile);
            while (infoFinder.hasNextLine()){
                String lineRead = infoFinder.nextLine();
                if (lineRead.contains(targetPhrase)){
                    System.out.print(lineRead);
                }
                else {
                    continue;
                }
            }

        }
        catch (FileNotFoundException e) {
            System.out.println("Can't Find File");
        }
    }

}
