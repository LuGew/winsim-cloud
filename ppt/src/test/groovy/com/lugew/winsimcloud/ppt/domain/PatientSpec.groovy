package com.lugew.winsimcloud.ppt.domain

import spock.lang.Specification
import spock.lang.Title

@Title("tst")
class PatientSpec extends Specification {

    def "trivial test with Groovy closure"() {

        given: "a list of products"
        List<String> products = ["camera", "laptop", "hifi"]

        expect: "camera should be one of them"
        products.any { productName -> productName == "camera" }

        and: "hotdog is not one of them"
        products.every { productName -> productName != "hotdog" }
    }

    def "trivial 1test with Groovy closure"() {

        given: "a list of products"
        List<String> products = ["camera", "laptop", "hifi"]

        expect: "camera should be one of them"
        products.any { productName -> productName == "camera" }

        and: "hotdog is not one of them"
        products.every { productName -> productName != "hotdog" }
    }
}
