package com.ramlearning.customer.filter;

import com.ramlearning.customer.model.RequestLog;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Slf4j
public class LoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {



        ContentCachingRequestWrapper wrappedRequest =
                new ContentCachingRequestWrapper(
                        (HttpServletRequest) servletRequest);

        ContentCachingResponseWrapper wrappedResponse =
                new ContentCachingResponseWrapper(
                        (HttpServletResponse) servletResponse);

        filterChain.doFilter(wrappedRequest, wrappedResponse);

        RequestLog requestLog = RequestLog.builder()
                .url(wrappedRequest.getRequestURI())
                .httpMethod(wrappedRequest.getMethod())
                .httpRequest(getRequestBody(wrappedRequest))
                .httpResponse(
                        new String(wrappedResponse.getContentAsByteArray()))
                .httpResponseCode(wrappedResponse.getStatus())
                .build();

        log.info(requestLog.toJson());
    }

    private String getRequestBody(ContentCachingRequestWrapper request)
            throws IOException {
        BufferedReader reader = new BufferedReader(new
                InputStreamReader(request.getInputStream()));

        return reader.lines().collect(Collectors.joining(""));

    }
}
