package com.alex.repo.service;

import java.io.InputStream;

public interface FileToPdfConvertor {

    void convert(InputStream inputStream, String convertedFileName, String contentType, String username);
}
