package org.itstep;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileCopyManager {

	public void copyFile(String outPath, String inputPath) {
		File outFile = new File(outPath);

		File inputFile = new File(inputPath);

		FileInputStream inputStream;
		try {
			inputStream = new FileInputStream(inputFile);

			BufferedInputStream bufferedIntputStream = new BufferedInputStream(inputStream);

			FileOutputStream outputStream = new FileOutputStream(outFile);
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);

			int outputBytes;
			while ((outputBytes = bufferedIntputStream.read()) != -1) {
				bufferedOutputStream.write((char) outputBytes);
			}
			
			bufferedOutputStream.flush();
			bufferedIntputStream.close();
			bufferedOutputStream.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
