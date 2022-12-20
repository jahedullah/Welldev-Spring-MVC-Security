package com.jahedullah.config;

import com.jahedullah.config.MyAppConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    protected Class<?>[] getServletConfigClasses() {
        Class[] configFiles = {MyAppConfig.class};

        return configFiles;
    }

    protected String[] getServletMappings() {

        String[] mappings = {"/"};

        return mappings;
    }
}
