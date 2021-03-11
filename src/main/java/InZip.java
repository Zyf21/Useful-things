import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class InZip {
	List<String> filesListInDir = new ArrayList<String>();
	public static void main(String[] args) throws IOException {

		File direr = new File("pdfFiles");
		File[] files = direr.listFiles();
		for(File file : files){

			String fileName = StringUtils.removeEnd( file.getName(), ".pdf");
			System.out.println(file.getAbsolutePath());


		}


		File dir = new File("zipFiles");
		String zipDirName = "tempPDF/output.zip";

		InZip inZip = new InZip();

//		inZip.zipDirectory("zipFiles", zipDirName, "vtoro");
//		inZip.zipDirectory("image", zipDirName, "perv");
//		inZip.zipFiles("zipFiles","image/rer.zip");
		inZip.zipFiles("tempPDF","image/rer.zip");
		//inZip.exportFriends("image/rer.zip","pdfFilesString");
		//inZip.exportFriends("image/rer.zip","zipFiles");


//		InZip inZip2 = new InZip();
//		inZip2.ziper("zipFiles", zipDirName, "jsons");
		//deleteDirectoryStream();
		//FileUtils.deleteDirectory(new File("frfe/yyy/"));

	}
	public String removeLastSubstring(String target, String toRemove){
		int idx = target.lastIndexOf(toRemove);
		target = target.substring(0, idx) + target.substring(idx + toRemove.length());
		return target;
	}

	public void deleteDirectoryStream(Path path) throws IOException {
		Files.walk(path)
				.sorted(Comparator.reverseOrder())
				.map(Path::toFile)
				.forEach(File::delete);
	}


	private void zipDirectory(String folderDirectory, String zipDirectory, String folderNameInZip) {
		try {

			File dir = new File(folderDirectory);
			File[] files = dir.listFiles();
			List<String> filesListInDir = new ArrayList<String>();
			for(File file : files){
//				if(file.isFile()) filesListInDir.add(file.getAbsolutePath());
//				else populateFilesList(file);
				filesListInDir.add(file.getAbsolutePath());
			}

			FileOutputStream fos = new FileOutputStream(zipDirectory);
			ZipOutputStream zos = new ZipOutputStream(fos);
			for(String filePath : filesListInDir){
				System.out.println("Zipping "+filePath);
				zos.putNextEntry(new ZipEntry(folderNameInZip + "/" + filePath.substring(dir.getAbsolutePath().length() + 1)));

				FileInputStream fis = new FileInputStream(filePath);
				byte[] buffer = new byte[1024];
				int length;
				while ((length = fis.read(buffer)) > 0) {
					zos.write(buffer, 0, length);
				}
				fis.close();
			}
			zos.closeEntry();
			zos.close();
			fos.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	private void populateFilesList(File dir) throws IOException {
		File[] files = dir.listFiles();
		for(File file : files){
			if(file.isFile()) filesListInDir.add(file.getAbsolutePath());
			else populateFilesList(file);
		}
	}

	public void ziper (String folderDirectory, String zipDirectory, String folderNameInZip){
		try {
			FileOutputStream fos = new FileOutputStream(zipDirectory);
			ZipOutputStream zos = new ZipOutputStream(fos);
			File dir = new File(folderDirectory);
			File[] files = dir.listFiles();

			for (int i = 0; i < files.length; i++) {
				System.out.println("Adding file: " + files[i].getName());
				FileInputStream fis = new FileInputStream(files[i]);
				// begin writing a new ZIP entry, positions the stream to the start of the entry data
				zos.putNextEntry(new ZipEntry(folderNameInZip + "/" + files[i].getName()));
				int length;
				byte[] buffer = new byte[1024];
				while ((length = fis.read(buffer)) > 0) {
					zos.write(buffer, 0, length);
				}
				zos.closeEntry();
				fis.close();
			}

			zos.close();
		}
		catch (IOException ioe) {
			System.out.println("Error creating zip file" + ioe);
		}
	}

	private void zipDirectory2(File dir, String zipDirName) {
		try {
			//populateFilesList(dir);

			//now zip files one by one
			//create ZipOutputStream to write to the zip file
			FileOutputStream fos = new FileOutputStream(zipDirName);
			ZipOutputStream zos = new ZipOutputStream(fos);
			File[] files = dir.listFiles();
			for (int i = 0; i < files.length; i++) {
				//System.out.println("Zipping "+filePath);
				//for ZipEntry we need to keep only relative file path, so we used substring on absolute path
				ZipEntry ze = new ZipEntry(files[i].getName());
				//ZipEntry ze = new ZipEntry(filePath.substring(dir.getAbsolutePath().length()+1, filePath.length()));
				zos.putNextEntry(ze);
				//read the file and write to ZipOutputStream
				FileInputStream fis = new FileInputStream("zipFiles/" + files[i].getName());
				byte[] buffer = new byte[1024];
				int len;
				while ((len = fis.read(buffer)) > 0) {
					zos.write(buffer, 0, len);
				}

				fis.close();
			}

			zos.closeEntry();
			zos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}




	public boolean zipFiles(String srcFolder, String destZipFile) {
		boolean result = false;
		try {
			System.out.println("Program Start zipping the given files");
			/*
			 * send to the zip procedure
			 */
			zipFolder(srcFolder, destZipFile);
			result = true;
			System.out.println("Given files are successfully zipped");
		} catch (Exception e) {
			System.out.println("Some Errors happned during the zip process");
		} finally {
			return result;
		}
	}

	/*
	 * zip the folders
	 */
	private void zipFolder(String srcFolder, String destZipFile) throws Exception {
		ZipOutputStream zip = null;
		FileOutputStream fileWriter = null;
		/*
		 * create the output stream to zip file result
		 */
		fileWriter = new FileOutputStream(destZipFile);
		zip = new ZipOutputStream(fileWriter);
		/*
		 * add the folder to the zip
		 */
		addFolderToZip("", srcFolder, zip);
		/*
		 * close the zip objects
		 */
		zip.flush();
		zip.close();
	}

	/*
	 * recursively add files to the zip files
	 */
	private void addFileToZip(String path, String srcFile, ZipOutputStream zip, boolean flag) throws Exception {
		/*
		 * create the file object for inputs
		 */
		File folder = new File(srcFile);

		/*
		 * if the folder is empty add empty folder to the Zip file
		 */
		if (flag == true) {
			zip.putNextEntry(new ZipEntry(path + "/" + folder.getName() + "/"));
		} else { /*
		 * if the current name is directory, recursively traverse it
		 * to get the files
		 */
			if (folder.isDirectory()) {
				/*
				 * if folder is not empty
				 */
				addFolderToZip(path, srcFile, zip);
			} else {
				/*
				 * write the file to the output
				 */
				byte[] buf = new byte[1024];
				int len;
				FileInputStream in = new FileInputStream(srcFile);
				zip.putNextEntry(new ZipEntry(path + "/" + folder.getName()));
				while ((len = in.read(buf)) > 0) {
					/*
					 * Write the Result
					 */
					zip.write(buf, 0, len);
				}
			}
		}
	}

	/*
	 * add folder to the zip file
	 */
	private void addFolderToZip(String path, String srcFolder, ZipOutputStream zip) throws Exception {
		File folder = new File(srcFolder);

		/*
		 * check the empty folder
		 */
		if (folder.list().length == 0) {
			System.out.println(folder.getName());
			addFileToZip(path, srcFolder, zip, true);
		} else {
			/*
			 * list the files in the folder
			 */
			for (String fileName : folder.list()) {
				if (path.equals("")) {
					addFileToZip(folder.getName(), srcFolder + "/" + fileName, zip, false);
				} else {
					addFileToZip(folder.getName(), srcFolder + "/" + fileName, zip, false);
					//addFileToZip(path + "/" + folder.getName(), srcFolder + "/" + fileName, zip, false);
					System.out.println(path + "/" + folder.getName());
				}
			}
		}
	}
//public void exportFriends(String pathToFile, String folder) {
//
//	String source = pathToFile ;
//	try {
//		String sourceDir = folder;
//		String zipFile = source;
//
//		try {
//			FileOutputStream fout = new FileOutputStream(zipFile);
//			ZipOutputStream zout = new ZipOutputStream(fout);
//
//			File fileSource = new File(sourceDir);
//
//			addDirectory(zout, sourceDir, fileSource);
//
//			zout.close();
//
//			System.out.println("Zip file has been created!");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//}
//
//	public static String getRelativePath(String sourceDir, File file) {
//		// Trim off the start of source dir path...
//		String path = file.getPath().substring(sourceDir.length());
//		if (path.startsWith(File.pathSeparator)) {
//			path = path.substring(1);
//		}
//		return path;
//	}
//
//	private static void addDirectory(ZipOutputStream zout, String sourceDir, File fileSource) throws IOException {
//		if (fileSource.isDirectory()) {
//			// Add the directory to the zip entry...
//			String path = getRelativePath(sourceDir, fileSource);
//			if (path.trim().length() > 0) {
//				ZipEntry ze = new ZipEntry(getRelativePath(sourceDir, fileSource));
//				zout.putNextEntry(ze);
//				zout.closeEntry();
//			}
//
//			File[] files = fileSource.listFiles();
//			System.out.println("Adding directory " + fileSource.getName());
//			for (int i = 0; i < files.length; i++) {
//				if (files[i].isDirectory()) {
//					addDirectory(zout, sourceDir, files[i]);
//				} else {
//
//					System.out.println("Adding file " + files[i].getName());
//
//					//create byte buffer
//					byte[] buffer = new byte[1024];
//
//					//create object of FileInputStream
//					FileInputStream fin = new FileInputStream(files[i]);
//					zout.putNextEntry(new ZipEntry(getRelativePath(sourceDir, files[i])));
//
//					int length;
//
//					while ((length = fin.read(buffer)) > 0) {
//						zout.write(buffer, 0, length);
//					}
//					zout.closeEntry();
//					//close the InputStream
//					fin.close();
//				}
//			}
//		}
//	}




}
