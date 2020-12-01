package com.lugew.winsimcloud.ppt.interfaces;

import com.alibaba.fastjson.JSONObject;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTextShape;

import java.io.File;
import java.util.List;
import java.util.Map;

public interface PPTX {

    void initial(String path);

    void initial(File file);

    XMLSlideShow getSlideShow();

    List<XSLFSlide> getSlides();

    XSLFSlide getSlide(int index);

    int getPicturePlaceholderSize(int slideIndex);

    Map<String, List<XSLFTextShape>> getText();

}
