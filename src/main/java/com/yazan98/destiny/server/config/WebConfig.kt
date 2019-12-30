package com.yazan98.destiny.server.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 1:33 PM
 */

@Configuration
open class WebConfig : WebMvcConfigurationSupport() {

    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry.addResourceHandler("**/*.css", "**/*.js", "**/*.map", "*.html").addResourceLocations("classpath:META-INF/resources/").setCachePeriod(0)
    }

}
