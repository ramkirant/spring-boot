package com.ramlearning.customer.config;

import com.ramlearning.customer.filter.LoggingFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {

    @Bean
    public FilterRegistrationBean<LoggingFilter>
    loggingFilterFilterRegistrationBean() {
        FilterRegistrationBean<LoggingFilter> registrationBean = new
                FilterRegistrationBean<>();
        registrationBean.setFilter(new LoggingFilter());
        registrationBean.addUrlPatterns("/customer/*");

        return registrationBean;
    }
}
