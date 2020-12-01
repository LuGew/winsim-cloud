package com.lugew.winsimcloud.ppt.core;

import com.lugew.winsimcloud.ppt.interfaces.PPTX;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.sl.usermodel.Placeholder;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTextShape;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class AbstractPPTX implements PPTX {
    private XMLSlideShow xmlSlideShow;

    @Override
    public void initial(String path) {
        initial(new File(path));
    }

    @Override
    public void initial(File file) {
        try {
            xmlSlideShow = new XMLSlideShow(new FileInputStream(file));
        } catch (IOException e) {
            throw new RuntimeException("file.not.exist:" + file.getAbsolutePath());
        }
    }

    @Override
    public XMLSlideShow getSlideShow() {
        return xmlSlideShow;
    }

    @Override
    public List<XSLFSlide> getSlides() {
        return getSlideShow().getSlides();
    }

    @Override
    public XSLFSlide getSlide(int index) {
        return getSlides().get(index);
    }

    @Override
    public int getPicturePlaceholderSize(int slideIndex) {
        XSLFSlide slide = getSlide(slideIndex);
        XSLFTextShape[] placeholders = slide.getPlaceholders();
        int size = 0;
        for (XSLFTextShape placeholder : placeholders) {
            if (Placeholder.PICTURE.equals(placeholder.getTextType())) {
                size++;
            }
        }
        return size;
    }

    @Override
    public Map<String, List<XSLFTextShape>> getText() {
        List<XSLFSlide> slides = getSlides();
        Map<String, List<XSLFTextShape>> result = new HashMap<>();

        for (XSLFSlide slide : slides) {
            XSLFTextShape[] placeholders = slide.getSlideLayout().getPlaceholders();
            for (XSLFTextShape placeholder : placeholders) {
                if (Placeholder.BODY.equals(placeholder.getTextType())) {
                    String text = placeholder.getText();
                    result.putIfAbsent(text, new ArrayList<>());
                    result.get(text).add(placeholder);
                }
            }
        }
        return result;
    }
}
