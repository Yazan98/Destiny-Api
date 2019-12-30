package com.yazan98.destiny.server.config

import com.yazan98.destiny.server.data.repository.ProfileRepository
import io.vortex.spring.boot.base.config.security.VortexJwtConfigurer
import io.vortex.spring.boot.base.config.security.VortexSecurityConfig
import io.vortex.spring.boot.base.config.security.VortexTokenProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import java.util.*

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 1:29 PM
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
@Order(1000)
open class SecurityConfiguration @Autowired constructor(private val repo: ProfileRepository) : VortexSecurityConfig() {

//    override fun configWebSecurity(http: HttpSecurity) {
//        http.httpBasic().disable()
//                .csrf().disable()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .authorizeRequests()
//                .antMatchers(AUTH_WHITELIST[0]).permitAll()
//                .antMatchers(AUTH_WHITELIST[1]).permitAll()
//                .antMatchers(AUTH_WHITELIST[2]).permitAll()
//                .antMatchers(AUTH_WHITELIST[3]).permitAll()
//                .antMatchers(AUTH_WHITELIST[4]).permitAll()
//                .antMatchers(AUTH_WHITELIST[5]).permitAll()
//                .antMatchers(AUTH_WHITELIST[6]).permitAll()
//                .antMatchers(HttpMethod.POST, "/v1/auth/register").permitAll()
//                .antMatchers(HttpMethod.POST, "v1/auth/register/").permitAll()
//                .antMatchers(HttpMethod.POST, "v1/auth").permitAll()
//                .antMatchers("/").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .apply(VortexJwtConfigurer(getTokenProvider()))
//    }

    override fun configWebSecurity(http: HttpSecurity) {

    }

    override fun configure(http: HttpSecurity?) {
        http?.cors()?.and()?.csrf()?.disable()
    }

    @Bean
    open fun corsConfigurationSource(): CorsConfigurationSource {
        val configuration = CorsConfiguration()
        configuration.allowedOrigins = Arrays.asList("*")
        configuration.allowedMethods = listOf("*")
        configuration.allowedHeaders = Arrays.asList("*")
        configuration.allowCredentials = true
        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", configuration)
        return source
    }

    override fun getTokenProvider(): VortexTokenProvider<*> {
        return TokenProvider(repo)
    }
}