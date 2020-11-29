package com.lugew.winsimcloud.ppt.interfaces

import com.lugew.winsimcloud.ppt.core.PPTXHolder
import com.lugew.winsimcloud.ppt.domain.Patient
import org.springframework.util.ResourceUtils
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Title

import java.time.LocalDateTime

@Title("pptx测试")
@Subject(PPTXHolder.class)
class PPTXSpec extends Specification {
    @Shared
    PPTX pptx
    @Shared
    String fileName

    def setupSpec() {
        fileName = "新齐玉正畸病例母版.pptx"
        pptx = new PPTXHolder()
        String filePath = ResourceUtils.getURL("classpath:static").getPath() + "/" + fileName
        pptx.initial(filePath)

    }

    def "根据文件名获取ppt"() {
        expect: "获取到幻灯片"
        pptx.getSlideShow() != null

    }

    def "获取幻灯片数量"() {
        expect: "幻灯片数量为21"
        pptx.getSlides().size() == 21
    }

    def "验证每页图片数量"() {
        expect: "每页图片模板数量正确"
        pptx.getPicturePlaceholderSize(index) == size
        where: "详情"
        index | size
        0     | 0
        1     | 3
        2     | 5
        3     | 1
        4     | 1
        5     | 8
        6     | 8
        7     | 3
        8     | 5
        9     | 5
        10    | 5
        11    | 5
        12    | 8
        13    | 5
        14    | 3
        15    | 10
        16    | 6
        17    | 6
        18    | 2
        19    | 2
        20    | 1

    }

    def "患者信息填入ppt"() {
        given: "初始化患者"
        Patient patient = initializePatient()
        when: "填入ppt"
        pptx.replaceText(patient)
        then: "填入信息正确"
        pptx.getTextContent()
        textTag

    }

    def  initializePatient() {
        Patient patient = new Patient()
        LocalDateTime now = LocalDateTime.now()
        patient.with {
            setName("夏露桂")
            setId(1L)
            setName("12-13")
            setAge(18)
            setCc("这是主诉")
            setA("134")
            setB("12")
            setC("12")
            setD("123")
            setDevice("装置")
            setPreDateTime(now)
            setPostDateTime(now.plusDays(1))
            setOpgDateTime(now.plusDays(1))
            setFinalOpgDateTime(now.plusDays(2))
            setCephDateTime(now.plusDays(2))
            setFinalCephDateTime(now.plusDays(3))

        }
        return patient
    }
}

