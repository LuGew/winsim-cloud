package com.lugew.winsimcloud.ppt.core;

import com.lugew.winsimcloud.ppt.interfaces.PPTX;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.sl.usermodel.Placeholder;
import org.apache.poi.xslf.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

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
        List<XSLFSlideMaster> xslfSlideMasters = xmlSlideShow.getSlideMasters();
        for (XSLFSlideMaster xslfSlideMaster : xslfSlideMasters) {
            /*XSLFTextShape[] placeholders = xslfSlideMaster.getPlaceholders();

            for (XSLFTextShape placeholder : placeholders) {

                log.debug(placeholder.getText());
                log.debug(placeholder.toString());
                log.debug(placeholder.getShapeName());
                log.debug(placeholder.getTextType().toString());
                if (Placeholder.PICTURE.equals(placeholder.getTextType())) {
                }
            }*/
            XSLFSlideLayout[] xslfSlideLayouts = xslfSlideMaster.getSlideLayouts();

            for (XSLFSlideLayout xslfSlideLayout : xslfSlideLayouts) {
                XSLFTextShape[] xplaceholders = xslfSlideLayout.getPlaceholders();

                for (XSLFTextShape placeholder : xplaceholders) {

                    log.debug(placeholder.getText());
                    log.debug(placeholder.toString());
                    log.debug(placeholder.getShapeName());
                    log.debug(placeholder.getTextType().toString());
                    if (Placeholder.PICTURE.equals(placeholder.getTextType())) {
                    }
                }
                log.debug(xslfSlideLayout.getName());
            }
        }
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
        XSLFSlide xslfSlide = getSlide(slideIndex);
        XSLFTextShape[] placeholders = xslfSlide.getPlaceholders();
        int size = 0;
        for (XSLFTextShape placeholder : placeholders) {
            log.debug(placeholder.getText());
            log.debug(placeholder.toString());
            log.debug(placeholder.getShapeName());
            log.debug(placeholder.getTextType().toString());
            if (Placeholder.PICTURE.equals(placeholder.getTextType())) {
                size++;
            }
        }
        return size;
    }
}
