package ssy.io;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class TestFile1 {

	public static void main(String[] args) throws IOException {

		
		File f = new File("c:/src/");
		String[] names = f.list((dir, name) -> {
		    if(name.endsWith(".txt")){
		        return true;
            }
            return false;
        });

		for (String name : names) {
			System.out.println(name);
		}

	}

}
