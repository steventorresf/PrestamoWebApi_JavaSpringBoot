package com.prestamofacilweb.service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.prestamofacilweb.service.IFileTxtService;

@Service
public class FileTxtService implements IFileTxtService {

    @Value("${fileTxtUri}")
    private String uri;

    @Override
    public void FileLogError(Exception exception) {
        try {
            String filePath = uri + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + ".txt";
            File file = new File(filePath);
            Boolean fileExists = file.exists();
            if (!fileExists)
                file.createNewFile();

            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);

            if (fileExists)
                bw.append("\r\n");

            bw.write(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "|" + exception.getMessage());
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
