

/*
 * Author:Logan Pageler
 * Compleation:uhhhhhhhhhhhhhhhhhhh idk 5/1/18?
 * 
 * Job:store data in file to be called on when game reboots
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.List;

public class SaveFile {
	static File file;
	String path;

	public SaveFile(String path) {

		file = new File(path);

	}

	// alters text to data
	public void setSave(String save) {
		try {

			file.createNewFile();
			PrintWriter writer = new PrintWriter(file);
			writer.println("DO NOT EDIT FILE");
			writer.println("DELETE FILE IF SHAPEMON HAS BEEN DELETED");
			writer.println();
			writer.println(save);
			writer.close();
		} catch (FileNotFoundException e) {
			System.out.println("Exception Occurred:");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Exception Occurred:");
			e.printStackTrace();
		}

	}

	// gets data from save file
	public List<String> getSave() {

		try {
			return Files.readAllLines(file.toPath());
		} catch (IOException e) {
			System.out.println("Exception Occurred:");
			e.printStackTrace();
		}
		return null;

	}

	// checks if file exsists
	public boolean exists() {
		System.out.println(file.exists());
		return file.exists();

	}

	// removes save file
	public void deleteSave() {
		if (file.exists()) {
			file.delete();
		}
	}

}