package org.ganyuke.postrack.database;

import com.opencsv.CSVWriter;
import org.bukkit.Bukkit;
import org.ganyuke.postrack.PositionTracker;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class FlatfileHandler {
    private final CSVWriter csvWriter;

    public FlatfileHandler(String path) throws IOException {
        csvWriter = new CSVWriter(new FileWriter(path, true));

        if (new File(path).length() == 0L) {
            writeData(new String[]{"TIMESTAMP", "PLAYER", "WORLD", "STATE", "X", "Y", "Z", "PITCH", "YAW", "DIRECTION"});
        }
    }

    public void writeData(String[] data) {
        csvWriter.writeNext(data);
    }

    public void closeWriter(CSVWriter writer) throws IOException {
        writer.close();
    }


}
