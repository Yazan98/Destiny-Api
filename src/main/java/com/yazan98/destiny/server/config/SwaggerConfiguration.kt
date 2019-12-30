package com.yazan98.destiny.server.config

import io.vortex.spring.boot.base.config.swagger.VortexSwaggerConfiguration
import io.vortex.spring.boot.base.models.SwaggerContact
import io.vortex.spring.boot.base.models.VortexSwaggerDetails
import org.springframework.context.annotation.Configuration
import springfox.documentation.swagger2.annotations.EnableSwagger2

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 3:12 AM
 */

//@Configuration
//@EnableSwagger2
open class SwaggerConfiguration : VortexSwaggerConfiguration() {
    override fun getSwaggerDetails(): VortexSwaggerDetails {
        return VortexSwaggerDetails(
                "Destiny Server",
                "Just Simple Example To Build SpringBoot Applications",
                SwaggerContact("Yazan Tarifi" , "yazantarifi1@hotmail.com" , "github.com/Yazan98"),
                "",
                "",
                "1.0.0"
        )
    }
}