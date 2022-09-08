package com.alex.repo.service;

import java.io.InputStream;

/**
 * @author Andrii Borozdykh
 */

public interface FileToPdfConvertor {

    void convert(InputStream inputStream, String convertedFileName, String contentType);
}
