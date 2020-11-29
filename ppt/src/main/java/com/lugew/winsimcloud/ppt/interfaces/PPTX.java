package com.lugew.winsimcloud.ppt.interfaces;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;

import java.io.File;
import java.util.List;

public interface PPTX {

    void initial(String path);

    void initial(File file);

    XMLSlideShow getSlideShow();

    List<XSLFSlide> getSlides();

    XSLFSlide getSlide(int index);

    int getPicturePlaceholderSize(int slideIndex);
}
