package ua.homework.rest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RestService {
	private volatile String urlLogFile;
	
	private volatile Map<Integer, LocalDateTime> idMap;
	private volatile Map<Integer, LocalDateTime> copy;

	public RestService(String urlLogFile, Map<Integer, LocalDateTime> idMap) {
		this.urlLogFile = urlLogFile;
		this.idMap = Collections.synchronizedMap(idMap);
	}

	public Map<Integer, LocalDateTime> getIdMap() {
		return idMap;
	}

	public void getCopyIdMap() {
		if (idMap != null && idMap.size() != 0) {
			copy = new HashMap<Integer, LocalDateTime>();
			copy.putAll(idMap);
			for (Map.Entry<Integer, LocalDateTime> entry : copy.entrySet()) {
				idMap.remove(entry.getKey());
			}
		}
	}

	public void addLog() {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(urlLogFile, true));) {
			for (Map.Entry<Integer, LocalDateTime> entry : copy.entrySet()) {
				bw.write(entry.getKey() + " " + entry.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + " \n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
