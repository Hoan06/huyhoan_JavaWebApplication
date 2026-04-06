package session02.config;

import org.jspecify.annotations.Nullable;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import java.util.logging.Filter;

public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {


    @Override
    protected Class<?> @Nullable [] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?> @Nullable [] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected jakarta.servlet.Filter @Nullable [] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter("UTF-8", true);
        return new jakarta.servlet.Filter[]{characterEncodingFilter};
    }

}
