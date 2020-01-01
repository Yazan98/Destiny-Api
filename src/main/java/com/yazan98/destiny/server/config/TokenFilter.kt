package com.yazan98.destiny.server.config

import com.yazan98.destiny.server.error.TokenErrorDetails
import io.vortex.spring.boot.base.errors.VortexAuthException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.GenericFilterBean
import java.io.IOException
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest


/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 1:28 PM
 */

@Configuration
open class TokenFilter @Autowired constructor(private val provider: JwtTokenProvider) : GenericFilterBean() {

    @Throws(IOException::class, ServletException::class)
    override fun doFilter(req: ServletRequest, res: ServletResponse, filterChain: FilterChain) {
        val token = provider.resolveToken(req as HttpServletRequest)
        if (token != null && provider.validateToken(token)) {
            val auth = provider.getAuthentication(token)
            SecurityContextHolder.getContext().authentication = auth
        }
        filterChain.doFilter(req, res)
    }

}