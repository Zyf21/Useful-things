import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


public class CopyFile {

    public static void main(String[] args) throws IOException {

       // getFreeMemory();
        deleteTmpFile();
//        copyDir("/home/dmtech/Документы/test1","/home/dmtech/Документы/test2");

//        File[] directories = new File("/home/dmtech/Документы/test2").listFiles(File::isDirectory);
//        System.out.println(directories[0] + " "+directories.length);

//        File file = new File("/home/dmtech/Документы/test2");
//        String[] directories2 = file.list(new FilenameFilter() {
//            @Override
//            public boolean accept(File current, String name) {
//                return new File(current, name).isDirectory();
//            }
//        });
//        System.out.println(directories2[0]);

//        String dir = "/home/dmtech/Документы/test2";
//        File file3 = new File(dir);
//        String reliseName;
//        String[] folderFiles = file3.list();
//        if(folderFiles.length == 1){
//            for(String name : folderFiles) {
//                if (new File(dir + "/" + name).isDirectory()) {
//                    reliseName = name;
//                    System.out.println(reliseName);
//                }
//            }
//        }





    }



    private static void copyDir(String sourceDirName, String targetSourceDir) throws IOException {

//        File folder = new File("/home/dmtech/Документы/test1");
//        //File folder = new File("\\\\CCR-ATOLL-01\\Atoll Coverage map Exports\\Test folder");
//        File[] listOfFiles = folder.listFiles();
//        //Path destDir = Paths.get("/test");
//        Path destDir = Paths.get("/home/dmtech/Документы/test2");

        File folder = new File(sourceDirName);

        File[] listOfFiles = folder.listFiles();

        Path destDir = Paths.get(targetSourceDir);
        if (listOfFiles != null && listOfFiles.length == 3)
            for (File file : listOfFiles) {
                Files.copy(file.toPath(), destDir.resolve(file.getName()), StandardCopyOption.REPLACE_EXISTING);
                System.out.println(FilenameUtils.getExtension(file.getName()));
                System.out.println(file.toPath());
            }
    }

    public static void getFreeMemory() throws IOException {
        Long freeMemory = new File("/").getUsableSpace();
        Long memoryInGB = freeMemory / 1024 /1024 / 1024;
        if(memoryInGB < 500){
            //clean temp
            //clean big files in
        }
        System.out.println(memoryInGB);

    }



    public static void  deleteTmpFile(){

        //String tmpdir = System.getProperty("java.io.tmpdir");
        System.out.println("3434");
        String dir = "/home/dmtech/Документы/test2";
        File tmpFolder = new File(dir);
        File[] tmpFiles = tmpFolder.listFiles();
        for (File file : tmpFiles) {
//            if (file.isFile() && file.exists() && file.getName().contains(".docx")){
            if ( file.exists() ){

                System.out.println(file.getName());
                System.out.println(file.getParent());
                file.delete();
                System.out.println("successfully deleted");
            }
        }

    }



//    private static final String PATH = "C:\\project\\DownloadTest\\src\\main\\resources\\tmp\\";
//    private static final String FILENAME = "data.pdf";
//    private static final String SvDPDFURL = "http://kundservice.svd.se/ui/templates/HttpHandler/PDFTidningen/PDFTidningen.ashx?date=2014-07-27&file=SVD_D_BILAGA_2014-07-27.pdf&mac=92267fcd3c75feff13154ba66870a523&free=True";
//
//    public static void main(String[] args) throws Exception{
//        File file = new File(PATH + FILENAME);
//        URL url = new URL(SvDPDFURL);
//        FileUtils.copyURLToFile(url, file);
//    }
}
