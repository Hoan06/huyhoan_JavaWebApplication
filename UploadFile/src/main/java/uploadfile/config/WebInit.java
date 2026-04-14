package uploadfile.config;

import jakarta.servlet.MultipartConfigElement;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    private final Long MAX_FILE_SIZE = 20*1024*1024L; // Tối đa file upload là 20 mb
    private final Long MAX_REQUEST_SIZE = 100*1024*1024L; // Tối đa trong 1 lần up là 5 file ( 20 * 5 = 100 )
    private final String TMP_LOCATION = ""; // Xử lý đường dẫn tuyệt đối ( đặt rỗng là tự xử lí lấy )
    private final Integer FILE_SIZE_THRESHOLD = 0; // Đặt 0 là không giới hạn kích thước upload lên


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
        registration.setMultipartConfig(new MultipartConfigElement(TMP_LOCATION , MAX_FILE_SIZE , MAX_REQUEST_SIZE, FILE_SIZE_THRESHOLD));
    }
}