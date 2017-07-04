package org.itstep;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class LogFileCreater {

	public ArrayList<LogForExample> getLogList(int size) { // с большой лонг потому что прописываем не примитивный, а класс обертку
															
		ArrayList<LogForExample> logList = new ArrayList<>();

		for (int i = 1; i <= size; i++) {
			long connectionId = getRandomNumber((long)Integer.MAX_VALUE + 10000, (long)Integer.MAX_VALUE + 19999);
			long connectionTime = System.currentTimeMillis() - ((1000 * 60 * 60) * 1);
			String connectorIp = getRandomNumber(1, 255) + "." + getRandomNumber(1, 255) + "." + getRandomNumber(1, 255)
					+ "." + getRandomNumber(1, 255) + ".";
			int specId = (int) getRandomNumber(1000000, 1999999);
			LogForExample log = new LogForExample(connectionId, connectionTime, connectorIp, specId);
			logList.add(log);

		}
		return logList;
	}
	
	public void createFile(ArrayList<LogForExample> logList, String filePath){
		File file = new File(filePath); //создали файл, точнее что мы будем делать файл - указатель на файл, указываем путь
		try {
			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter); //создали экземпл€р буфередрайтер
			String stringToWrite = "";
			for (LogForExample log : logList) {
				stringToWrite += log.getConnectionId()+" "+log.getConnectionTime()+ " "+log.getConnectorIp()+ " "+log.getSpecId()+ "\n";
		}
		bufferedWriter.write(stringToWrite);
		bufferedWriter.flush();
		bufferedWriter.close();	
	} catch (IOException e) {
			e.printStackTrace();		
		}	
	}

	public long getRandomNumber(long minNum, long maxNum) {
		return (long) (minNum + (Math.random() * (maxNum - minNum + 1)));
	}
}
