package com.yazan98.destiny.server

import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

/**
 * Created By : Yazan Tarifi
 * Date : 12/31/2019
 * Time : 3:50 PM
 */

open class ServletInitializer : SpringBootServletInitializer() {
    override fun configure(builder: SpringApplicationBuilder?): SpringApplicationBuilder? {
        return builder?.sources(DestinyApplication::class.java)
    }
}
