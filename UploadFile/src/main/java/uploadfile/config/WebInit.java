package uploadfile.config;

import jakarta.servlet.MultipartConfigElement;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    private static final long MAX_FILE_SIZE = 5 * 1024 * 1024;
    private static final long MAX_REQUEST_SIZE = 10 * 1024 * 1024;
    private static final int FILE_SIZE_THRESHOLD = 1024 * 1024;

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(
                new MultipartConfigElement(
                        null,
                        MAX_FILE_SIZE,
                        MAX_REQUEST_SIZE,
                        FILE_SIZE_THRESHOLD
                )
        );
    }
}