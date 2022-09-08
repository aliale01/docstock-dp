package com.alex.repo.service.impl;

import com.alex.repo.constants.APIServiceError;
import com.alex.repo.exception.APIExcepiton;
import com.alex.repo.service.FileToPdfConvertor;
import com.aspose.cells.SaveFormat;
import com.aspose.cells.Workbook;
import com.aspose.words.Document;
import com.aspose.words.SaveOutputParameters;
import java.io.InputStream;
import org.springframework.stereotype.Service;

/**
 * @author Andrii Borozdykh
 */

@Service
public class AsposeDocConvertor implements FileToPdfConvertor {

    public static final String PATH = "./resources/output/";
    public static final String PDF = ".pdf";

    private static final String MIME_XLSX = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    private static final String MIME_XLS = "application/vnd.ms-excel";
    private static final String MIME_DOCX = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
    private static final String MIME_DOC = "application/msword";


    @Override
    public void convert(InputStream inputStream, String convertedFileName, String contentType) {
        //TODO: It is good idea to add here some check if file with convertedFileName is exist
        //TODO: The second this is to create files with id as a name
        boolean isFileExcel = contentType.equals(MIME_XLSX) || contentType.equals(MIME_XLS);
        boolean isFileWord = contentType.equals(MIME_DOCX) || contentType.equals(MIME_DOC);
        if (isFileWord) {
            convertWord(inputStream, convertedFileName);
        } else if(isFileExcel) {
            convertExcel(inputStream, convertedFileName);
        } else{
            throw new APIExcepiton(APIServiceError.UNKNOWN_MIME_TYPE);
        }
    }

    private void convertWord(InputStream inputStream, String convertedFileName) {
        try {
            Document document = new Document(inputStream);
            SaveOutputParameters savedDoc = document.save(PATH + convertedFileName + PDF);
            String ct = savedDoc.getContentType();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void convertExcel(InputStream inputStream, String convertedFileName) {
        try {
            Workbook workbook = new Workbook(inputStream);
            workbook.save(PATH + convertedFileName + PDF, SaveFormat.PDF);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
