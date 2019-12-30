# Destiny
Culture Activity Api With Spring Boot 

## Languages
1. Java
2. Kotlin

## Database 
Mysql

## Project Status
Under Development

## Apis
```
http://localhost:8181/v1/accounts/register
http://localhost:8181/v1/accounts/login
http://localhost:8181/v1/accounts
http://localhost:8181/v1/accounts/{id}
http://localhost:8181/v1/accounts/{id} DELETE
http://localhost:8181/v1/accounts/all DELETE

http://localhost:8181/v1/categories
http://localhost:8181/v1/categories/{id}
http://localhost:8181/v1/categories/{id} DELETE
http://localhost:8181/v1/categories/all DELETE

http://localhost:8181/v1/collections GET
http://localhost:8181/v1/collections?promoted=true
http://localhost:8181/v1/collections POST
http://localhost:8181/v1/collections/{id} DELETE
http://localhost:8181/v1/collections/all DELETE

http://localhost:8181/v1/cities GET
http://localhost:8181/v1/cities POST
http://localhost:8181/v1/cities/{id}
http://localhost:8181/v1/cities/{id} DELETE
http://localhost:8181/v1/cities/all DELETE

etc
```

## Success Response
```
{
    "code": 201,
    "message": "Account Created",
    "status": "Success",
    "data": {
        "token": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJZYXphbiA5OCIsImV4cCI6MTU3Nzc1OTA4OSwiaWF0IjoxNTc3NzQxMDg5fQ.OPqIMEIhIWTQhYvrEbbDY43xuThdd6RREk41bw7hyqL8RPY9wL0DHCgc2TvxGZTAAqdaNJ1uggUD83WO0-pf_A",
        "user": {
            "id": 34,
            "username": "Yazan 98",
            "email": "yazan@gmail.com",
            "phoneNumber": "123456789",
            "image": "HEHEH",
            "enabled": true,
            "accountStatus": "NOT_ACTIVATED",
            "location": {
                "latitude": 0.0,
                "longitude": 0.0,
                "name": "Amman"
            }
        }
    }
}
```

## Error Response
```
{
    "code": 400,
    "message": "User Username Required",
    "status": "Failed",
    "error": {
        "type": "Invalid Or Missing Value",
        "details": {
            "name": "Username",
            "reason": "Attribute Missing"
        },
        "stacktrace": [
            {
                "methodName": "create",
                "fileName": "ProfileService.kt",
                "lineNumber": 39,
                "className": "com.yazan98.destiny.server.service.ProfileService",
                "nativeMethod": false
            },
            {
                "methodName": "invoke",
                "fileName": "<generated>",
                "lineNumber": -1,
                "className": "com.yazan98.destiny.server.service.ProfileService$$FastClassBySpringCGLIB$$12abef57",
                "nativeMethod": false
            },
            {
                "methodName": "invoke",
                "fileName": "MethodProxy.java",
                "lineNumber": 218,
                "className": "org.springframework.cglib.proxy.MethodProxy",
                "nativeMethod": false
            },
            {
                "methodName": "invokeJoinpoint",
                "fileName": "CglibAopProxy.java",
                "lineNumber": 769,
                "className": "org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation",
                "nativeMethod": false
            },
            {
                "methodName": "proceed",
                "fileName": "ReflectiveMethodInvocation.java",
                "lineNumber": 163,
                "className": "org.springframework.aop.framework.ReflectiveMethodInvocation",
                "nativeMethod": false
            },
            {
                "methodName": "proceed",
                "fileName": "CglibAopProxy.java",
                "lineNumber": 747,
                "className": "org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation",
                "nativeMethod": false
            },
            {
                "methodName": "invokeWithinTransaction",
                "fileName": "TransactionAspectSupport.java",
                "lineNumber": 366,
                "className": "org.springframework.transaction.interceptor.TransactionAspectSupport",
                "nativeMethod": false
            },
            {
                "methodName": "invoke",
                "fileName": "TransactionInterceptor.java",
                "lineNumber": 99,
                "className": "org.springframework.transaction.interceptor.TransactionInterceptor",
                "nativeMethod": false
            },
            {
                "methodName": "proceed",
                "fileName": "ReflectiveMethodInvocation.java",
                "lineNumber": 186,
                "className": "org.springframework.aop.framework.ReflectiveMethodInvocation",
                "nativeMethod": false
            },
            {
                "methodName": "proceed",
                "fileName": "CglibAopProxy.java",
                "lineNumber": 747,
                "className": "org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation",
                "nativeMethod": false
            },
            {
                "methodName": "intercept",
                "fileName": "CglibAopProxy.java",
                "lineNumber": 689,
                "className": "org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor",
                "nativeMethod": false
            },
            {
                "methodName": "create",
                "fileName": "<generated>",
                "lineNumber": -1,
                "className": "com.yazan98.destiny.server.service.ProfileService$$EnhancerBySpringCGLIB$$8e77510e",
                "nativeMethod": false
            },
            {
                "methodName": "createNewAccount",
                "fileName": "ProfileService.kt",
                "lineNumber": 85,
                "className": "com.yazan98.destiny.server.service.ProfileService",
                "nativeMethod": false
            },
            {
                "methodName": "save",
                "fileName": "AuthController.kt",
                "lineNumber": 32,
                "className": "com.yazan98.destiny.server.controller.AuthController",
                "nativeMethod": false
            },
            {
                "methodName": "invoke0",
                "fileName": "NativeMethodAccessorImpl.java",
                "lineNumber": -2,
                "className": "sun.reflect.NativeMethodAccessorImpl",
                "nativeMethod": true
            },
            {
                "methodName": "invoke",
                "fileName": "NativeMethodAccessorImpl.java",
                "lineNumber": 62,
                "className": "sun.reflect.NativeMethodAccessorImpl",
                "nativeMethod": false
            },
            {
                "methodName": "invoke",
                "fileName": "DelegatingMethodAccessorImpl.java",
                "lineNumber": 43,
                "className": "sun.reflect.DelegatingMethodAccessorImpl",
                "nativeMethod": false
            },
            {
                "methodName": "invoke",
                "fileName": "Method.java",
                "lineNumber": 498,
                "className": "java.lang.reflect.Method",
                "nativeMethod": false
            },
            {
                "methodName": "doInvoke",
                "fileName": "InvocableHandlerMethod.java",
                "lineNumber": 190,
                "className": "org.springframework.web.method.support.InvocableHandlerMethod",
                "nativeMethod": false
            },
            {
                "methodName": "invokeForRequest",
                "fileName": "InvocableHandlerMethod.java",
                "lineNumber": 138,
                "className": "org.springframework.web.method.support.InvocableHandlerMethod",
                "nativeMethod": false
            },
            {
                "methodName": "invokeAndHandle",
                "fileName": "ServletInvocableHandlerMethod.java",
                "lineNumber": 106,
                "className": "org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod",
                "nativeMethod": false
            },
            {
                "methodName": "invokeHandlerMethod",
                "fileName": "RequestMappingHandlerAdapter.java",
                "lineNumber": 888,
                "className": "org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter",
                "nativeMethod": false
            },
            {
                "methodName": "handleInternal",
                "fileName": "RequestMappingHandlerAdapter.java",
                "lineNumber": 793,
                "className": "org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter",
                "nativeMethod": false
            },
            {
                "methodName": "handle",
                "fileName": "AbstractHandlerMethodAdapter.java",
                "lineNumber": 87,
                "className": "org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter",
                "nativeMethod": false
            },
            {
                "methodName": "doDispatch",
                "fileName": "DispatcherServlet.java",
                "lineNumber": 1040,
                "className": "org.springframework.web.servlet.DispatcherServlet",
                "nativeMethod": false
            },
            {
                "methodName": "doService",
                "fileName": "DispatcherServlet.java",
                "lineNumber": 943,
                "className": "org.springframework.web.servlet.DispatcherServlet",
                "nativeMethod": false
            },
            {
                "methodName": "processRequest",
                "fileName": "FrameworkServlet.java",
                "lineNumber": 1006,
                "className": "org.springframework.web.servlet.FrameworkServlet",
                "nativeMethod": false
            },
            {
                "methodName": "doPost",
                "fileName": "FrameworkServlet.java",
                "lineNumber": 909,
                "className": "org.springframework.web.servlet.FrameworkServlet",
                "nativeMethod": false
            },
            {
                "methodName": "service",
                "fileName": "HttpServlet.java",
                "lineNumber": 660,
                "className": "javax.servlet.http.HttpServlet",
                "nativeMethod": false
            },
            {
                "methodName": "service",
                "fileName": "FrameworkServlet.java",
                "lineNumber": 883,
                "className": "org.springframework.web.servlet.FrameworkServlet",
                "nativeMethod": false
            },
            {
                "methodName": "service",
                "fileName": "HttpServlet.java",
                "lineNumber": 741,
                "className": "javax.servlet.http.HttpServlet",
                "nativeMethod": false
            },
            {
                "methodName": "internalDoFilter",
                "fileName": "ApplicationFilterChain.java",
                "lineNumber": 231,
                "className": "org.apache.catalina.core.ApplicationFilterChain",
                "nativeMethod": false
            },
            {
                "methodName": "doFilter",
                "fileName": "ApplicationFilterChain.java",
                "lineNumber": 166,
                "className": "org.apache.catalina.core.ApplicationFilterChain",
                "nativeMethod": false
            },
            {
                "methodName": "doFilter",
                "fileName": "WsFilter.java",
                "lineNumber": 53,
                "className": "org.apache.tomcat.websocket.server.WsFilter",
                "nativeMethod": false
            },
            {
                "methodName": "internalDoFilter",
                "fileName": "ApplicationFilterChain.java",
                "lineNumber": 193,
                "className": "org.apache.catalina.core.ApplicationFilterChain",
                "nativeMethod": false
            },
            {
                "methodName": "doFilter",
                "fileName": "ApplicationFilterChain.java",
                "lineNumber": 166,
                "className": "org.apache.catalina.core.ApplicationFilterChain",
                "nativeMethod": false
            },
            {
                "methodName": "doFilter",
                "fileName": "VortexJwtTokenFilter.kt",
                "lineNumber": 26,
                "className": "io.vortex.spring.boot.base.config.security.VortexJwtTokenFilter",
                "nativeMethod": false
            },
            {
                "methodName": "internalDoFilter",
                "fileName": "ApplicationFilterChain.java",
                "lineNumber": 193,
                "className": "org.apache.catalina.core.ApplicationFilterChain",
                "nativeMethod": false
            },
            {
                "methodName": "doFilter",
                "fileName": "ApplicationFilterChain.java",
                "lineNumber": 166,
                "className": "org.apache.catalina.core.ApplicationFilterChain",
                "nativeMethod": false
            },
            {
                "methodName": "doFilter",
                "fileName": "FilterChainProxy.java",
                "lineNumber": 320,
                "className": "org.springframework.security.web.FilterChainProxy$VirtualFilterChain",
                "nativeMethod": false
            },
            {
                "methodName": "doFilter",
                "fileName": "ExceptionTranslationFilter.java",
                "lineNumber": 118,
                "className": "org.springframework.security.web.access.ExceptionTranslationFilter",
                "nativeMethod": false
            },
            {
                "methodName": "doFilter",
                "fileName": "FilterChainProxy.java",
                "lineNumber": 334,
                "className": "org.springframework.security.web.FilterChainProxy$VirtualFilterChain",
                "nativeMethod": false
            },
            {
                "methodName": "doFilter",
                "fileName": "SessionManagementFilter.java",
                "lineNumber": 137,
                "className": "org.springframework.security.web.session.SessionManagementFilter",
                "nativeMethod": false
            },
            {
                "methodName": "doFilter",
                "fileName": "FilterChainProxy.java",
                "lineNumber": 334,
                "className": "org.springframework.security.web.FilterChainProxy$VirtualFilterChain",
                "nativeMethod": false
            },
            {
                "methodName": "doFilter",
                "fileName": "AnonymousAuthenticationFilter.java",
                "lineNumber": 111,
                "className": "org.springframework.security.web.authentication.AnonymousAuthenticationFilter",
                "nativeMethod": false
            },
            {
                "methodName": "doFilter",
                "fileName": "FilterChainProxy.java",
                "lineNumber": 334,
                "className": "org.springframework.security.web.FilterChainProxy$VirtualFilterChain",
                "nativeMethod": false
            },
            {
                "methodName": "doFilter",
                "fileName": "SecurityContextHolderAwareRequestFilter.java",
                "lineNumber": 158,
                "className": "org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter",
                "nativeMethod": false
            },
            {
                "methodName": "doFilter",
                "fileName": "FilterChainProxy.java",
                "lineNumber": 334,
                "className": "org.springframework.security.web.FilterChainProxy$VirtualFilterChain",
                "nativeMethod": false
            },
            {
                "methodName": "doFilter",
                "fileName": "RequestCacheAwareFilter.java",
                "lineNumber": 63,
                "className": "org.springframework.security.web.savedrequest.RequestCacheAwareFilter",
                "nativeMethod": false
            },
            {
                "methodName": "doFilter",
                "fileName": "FilterChainProxy.java",
                "lineNumber": 334,
                "className": "org.springframework.security.web.FilterChainProxy$VirtualFilterChain",
                "nativeMethod": false
            },
            {
                "methodName": "doFilter",
                "fileName": "LogoutFilter.java",
                "lineNumber": 116,
                "className": "org.springframework.security.web.authentication.logout.LogoutFilter",
                "nativeMethod": false
            },
            {
                "methodName": "doFilter",
                "fileName": "FilterChainProxy.java",
                "lineNumber": 334,
                "className": "org.springframework.security.web.FilterChainProxy$VirtualFilterChain",
                "nativeMethod": false
            },
            {
                "methodName": "doFilterInternal",
                "fileName": "CorsFilter.java",
                "lineNumber": 92,
                "className": "org.springframework.web.filter.CorsFilter",
                "nativeMethod": false
            },
            {
                "methodName": "doFilter",
                "fileName": "OncePerRequestFilter.java",
                "lineNumber": 119,
                "className": "org.springframework.web.filter.OncePerRequestFilter",
                "nativeMethod": false
            },
            {
                "methodName": "doFilter",
                "fileName": "FilterChainProxy.java",
                "lineNumber": 334,
                "className": "org.springframework.security.web.FilterChainProxy$VirtualFilterChain",
                "nativeMethod": false
            },
            {
                "methodName": "doHeadersAfter",
                "fileName": "HeaderWriterFilter.java",
                "lineNumber": 92,
                "className": "org.springframework.security.web.header.HeaderWriterFilter",
                "nativeMethod": false
            },
            {
                "methodName": "doFilterInternal",
                "fileName": "HeaderWriterFilter.java",
                "lineNumber": 77,
                "className": "org.springframework.security.web.header.HeaderWriterFilter",
                "nativeMethod": false
            },
            {
                "methodName": "doFilter",
                "fileName": "OncePerRequestFilter.java",
                "lineNumber": 119,
                "className": "org.springframework.web.filter.OncePerRequestFilter",
                "nativeMethod": false
            },
            {
                "methodName": "doFilter",
                "fileName": "FilterChainProxy.java",
                "lineNumber": 334,
                "className": "org.springframework.security.web.FilterChainProxy$VirtualFilterChain",
                "nativeMethod": false
            },
            {
                "methodName": "doFilter",
                "fileName": "SecurityContextPersistenceFilter.java",
                "lineNumber": 105,
                "className": "org.springframework.security.web.context.SecurityContextPersistenceFilter",
                "nativeMethod": false
            },
            {
                "methodName": "doFilter",
                "fileName": "FilterChainProxy.java",
                "lineNumber": 334,
                "className": "org.springframework.security.web.FilterChainProxy$VirtualFilterChain",
                "nativeMethod": false
            },
            {
                "methodName": "doFilterInternal",
                "fileName": "WebAsyncManagerIntegrationFilter.java",
                "lineNumber": 56,
                "className": "org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter",
                "nativeMethod": false
            },
            {
                "methodName": "doFilter",
                "fileName": "OncePerRequestFilter.java",
                "lineNumber": 119,
                "className": "org.springframework.web.filter.OncePerRequestFilter",
                "nativeMethod": false
            },
            {
                "methodName": "doFilter",
                "fileName": "FilterChainProxy.java",
                "lineNumber": 334,
                "className": "org.springframework.security.web.FilterChainProxy$VirtualFilterChain",
                "nativeMethod": false
            },
            {
                "methodName": "doFilterInternal",
                "fileName": "FilterChainProxy.java",
                "lineNumber": 215,
                "className": "org.springframework.security.web.FilterChainProxy",
                "nativeMethod": false
            },
            {
                "methodName": "doFilter",
                "fileName": "FilterChainProxy.java",
                "lineNumber": 178,
                "className": "org.springframework.security.web.FilterChainProxy",
                "nativeMethod": false
            },
            {
                "methodName": "invokeDelegate",
                "fileName": "DelegatingFilterProxy.java",
                "lineNumber": 358,
                "className": "org.springframework.web.filter.DelegatingFilterProxy",
                "nativeMethod": false
            },
            {
                "methodName": "doFilter",
                "fileName": "DelegatingFilterProxy.java",
                "lineNumber": 271,
                "className": "org.springframework.web.filter.DelegatingFilterProxy",
                "nativeMethod": false
            },
            {
                "methodName": "internalDoFilter",
                "fileName": "ApplicationFilterChain.java",
                "lineNumber": 193,
                "className": "org.apache.catalina.core.ApplicationFilterChain",
                "nativeMethod": false
            },
            {
                "methodName": "doFilter",
                "fileName": "ApplicationFilterChain.java",
                "lineNumber": 166,
                "className": "org.apache.catalina.core.ApplicationFilterChain",
                "nativeMethod": false
            },
            {
                "methodName": "doFilterInternal",
                "fileName": "WebMvcMetricsFilter.java",
                "lineNumber": 108,
                "className": "org.springframework.boot.actuate.metrics.web.servlet.WebMvcMetricsFilter",
                "nativeMethod": false
            },
            {
                "methodName": "doFilter",
                "fileName": "OncePerRequestFilter.java",
                "lineNumber": 119,
                "className": "org.springframework.web.filter.OncePerRequestFilter",
                "nativeMethod": false
            },
            {
                "methodName": "internalDoFilter",
                "fileName": "ApplicationFilterChain.java",
                "lineNumber": 193,
                "className": "org.apache.catalina.core.ApplicationFilterChain",
                "nativeMethod": false
            },
            {
                "methodName": "doFilter",
                "fileName": "ApplicationFilterChain.java",
                "lineNumber": 166,
                "className": "org.apache.catalina.core.ApplicationFilterChain",
                "nativeMethod": false
            },
            {
                "methodName": "doFilterInternal",
                "fileName": "CharacterEncodingFilter.java",
                "lineNumber": 201,
                "className": "org.springframework.web.filter.CharacterEncodingFilter",
                "nativeMethod": false
            },
            {
                "methodName": "doFilter",
                "fileName": "OncePerRequestFilter.java",
                "lineNumber": 119,
                "className": "org.springframework.web.filter.OncePerRequestFilter",
                "nativeMethod": false
            },
            {
                "methodName": "internalDoFilter",
                "fileName": "ApplicationFilterChain.java",
                "lineNumber": 193,
                "className": "org.apache.catalina.core.ApplicationFilterChain",
                "nativeMethod": false
            },
            {
                "methodName": "doFilter",
                "fileName": "ApplicationFilterChain.java",
                "lineNumber": 166,
                "className": "org.apache.catalina.core.ApplicationFilterChain",
                "nativeMethod": false
            },
            {
                "methodName": "invoke",
                "fileName": "StandardWrapperValve.java",
                "lineNumber": 202,
                "className": "org.apache.catalina.core.StandardWrapperValve",
                "nativeMethod": false
            },
            {
                "methodName": "invoke",
                "fileName": "StandardContextValve.java",
                "lineNumber": 96,
                "className": "org.apache.catalina.core.StandardContextValve",
                "nativeMethod": false
            },
            {
                "methodName": "invoke",
                "fileName": "AuthenticatorBase.java",
                "lineNumber": 526,
                "className": "org.apache.catalina.authenticator.AuthenticatorBase",
                "nativeMethod": false
            },
            {
                "methodName": "invoke",
                "fileName": "StandardHostValve.java",
                "lineNumber": 139,
                "className": "org.apache.catalina.core.StandardHostValve",
                "nativeMethod": false
            },
            {
                "methodName": "invoke",
                "fileName": "ErrorReportValve.java",
                "lineNumber": 92,
                "className": "org.apache.catalina.valves.ErrorReportValve",
                "nativeMethod": false
            },
            {
                "methodName": "invoke",
                "fileName": "StandardEngineValve.java",
                "lineNumber": 74,
                "className": "org.apache.catalina.core.StandardEngineValve",
                "nativeMethod": false
            },
            {
                "methodName": "invoke",
                "fileName": "AbstractAccessLogValve.java",
                "lineNumber": 678,
                "className": "org.apache.catalina.valves.AbstractAccessLogValve",
                "nativeMethod": false
            },
            {
                "methodName": "service",
                "fileName": "CoyoteAdapter.java",
                "lineNumber": 343,
                "className": "org.apache.catalina.connector.CoyoteAdapter",
                "nativeMethod": false
            },
            {
                "methodName": "service",
                "fileName": "Http11Processor.java",
                "lineNumber": 408,
                "className": "org.apache.coyote.http11.Http11Processor",
                "nativeMethod": false
            },
            {
                "methodName": "process",
                "fileName": "AbstractProcessorLight.java",
                "lineNumber": 66,
                "className": "org.apache.coyote.AbstractProcessorLight",
                "nativeMethod": false
            },
            {
                "methodName": "process",
                "fileName": "AbstractProtocol.java",
                "lineNumber": 861,
                "className": "org.apache.coyote.AbstractProtocol$ConnectionHandler",
                "nativeMethod": false
            },
            {
                "methodName": "doRun",
                "fileName": "NioEndpoint.java",
                "lineNumber": 1579,
                "className": "org.apache.tomcat.util.net.NioEndpoint$SocketProcessor",
                "nativeMethod": false
            },
            {
                "methodName": "run",
                "fileName": "SocketProcessorBase.java",
                "lineNumber": 49,
                "className": "org.apache.tomcat.util.net.SocketProcessorBase",
                "nativeMethod": false
            },
            {
                "methodName": "runWorker",
                "fileName": "ThreadPoolExecutor.java",
                "lineNumber": 1142,
                "className": "java.util.concurrent.ThreadPoolExecutor",
                "nativeMethod": false
            },
            {
                "methodName": "run",
                "fileName": "ThreadPoolExecutor.java",
                "lineNumber": 617,
                "className": "java.util.concurrent.ThreadPoolExecutor$Worker",
                "nativeMethod": false
            },
            {
                "methodName": "run",
                "fileName": "TaskThread.java",
                "lineNumber": 61,
                "className": "org.apache.tomcat.util.threads.TaskThread$WrappingRunnable",
                "nativeMethod": false
            },
            {
                "methodName": "run",
                "fileName": "Thread.java",
                "lineNumber": 745,
                "className": "java.lang.Thread",
                "nativeMethod": false
            }
        ]
    },
    "path": null
}
```
