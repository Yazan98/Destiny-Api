package com.yazan98.destiny.server.config

import com.mongodb.MongoClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.SimpleMongoDbFactory
import org.springframework.data.mongodb.MongoDbFactory
import java.net.UnknownHostException


/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 4:08 AM
 */
@Configuration
open class SpringConfig {

    @Bean
    @Throws(UnknownHostException::class)
    open fun mongoDbFactory(): MongoDbFactory {
        return SimpleMongoDbFactory(MongoClient(), "games")
    }

    @Bean
    @Throws(UnknownHostException::class)
    open fun mongoTemplate(): MongoTemplate {
        return MongoTemplate(mongoDbFactory())
    }

}