package org.itstep;

import java.util.ArrayList;

public class GoGo {

	public static void main(String[] args) {
		
		LogFileCreater logCreator = new LogFileCreater();
		
		ArrayList<LogForExample> logList = logCreator.getLogList(20);
		logCreator.createFile(logList, "D:\\test\\logSession.txt");
		

	}

}
