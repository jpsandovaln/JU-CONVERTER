/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprietary information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package com.jalasoft.convert.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.jalasoft.convert.service.ConvertImageToTextOCR;
import com.jalasoft.convert.FileStorageService;

import java.io.IOException;

/**
 * This controller creates an Endpoint for the ConvertImageToTextOCR class.
 * It works under 2 parameters, the input image and the language of the image. 
 *
 * @author Jose Romay
 * @version 1.0
 */

@RestController
public class OcrController {

    @Autowired
    private FileStorageService fileStorageService;


    @PostMapping("/uploadOcrImg")
    public void translateGt(@RequestParam("img") MultipartFile file,
            @RequestParam("lang") String lang) throws IOException {

        String fileName = fileStorageService.storeFile(file);

        ConvertImageToTextOCR convert = new ConvertImageToTextOCR();
        convert.convertImageToText(fileName, lang);

    }
}
