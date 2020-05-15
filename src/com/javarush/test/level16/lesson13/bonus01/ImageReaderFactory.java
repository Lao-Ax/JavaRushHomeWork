package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created by Alex on 08.09.2015 008.
 */
public class ImageReaderFactory {
    public static ImageReader getReader(ImageTypes fileType) {
        switch (fileType){
            case BMP: return new BmpReader();
            case JPG: return new JpgReader();
            case PNG: return new PngReader();
            default: throw new IllegalArgumentException("Неизвестный тип картинки");
        }
//        if (fileType == ImageTypes.BMP) return new BmpReader();
//        if (fileType == ImageTypes.PNG) return new PngReader();
//        if (fileType == ImageTypes.JPG) return new JpgReader();
//        throw new IllegalArgumentException("Неизвестный тип картинки");
    }
}
