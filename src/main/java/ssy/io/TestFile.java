package ssy.io;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Iterator;

public class TestFile {

	public static void main(String[] args) throws IOException {

		
		File f = new File("c:/","t.txt");
		System.out.println(f.createNewFile());
		System.out.println(File.separator); // \
		System.out.println(File.separatorChar); // \
		System.out.println(File.pathSeparator); // ;
		System.out.println(File.pathSeparatorChar); // ;


		File fs = new File("c:/");
		for (String str: fs.list()) {
			System.out.println(str);
		}

		File[] files = fs.listFiles();
		for (File ff :files) {

		}


		String[] names =  f.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				if(name.endsWith(".rar")){
					return true;
				}
				return false;
			}
		});

		for (String name : names) {
			System.out.println(name);
		}
		System.out.println(names.length);
		
	}

}
