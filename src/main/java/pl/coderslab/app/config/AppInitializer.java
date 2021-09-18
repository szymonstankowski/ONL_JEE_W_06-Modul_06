package pl.coderslab.app.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import pl.coderslab.app.AppConfig;


public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

//  @Override
//  public void onStartup(ServletContext container) throws ServletException {
//    AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
//    ctx.register(AppConfig.class);
//    ctx.setServletContext(container);
//    ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(ctx));
//    servlet.setLoadOnStartup(1);
//    servlet.addMapping("/");
//  }

  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class[]{AppConfig.class};
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class[]{WebConfig.class};
  }

  @Override
  protected String[] getServletMappings() {
    return new String[]{"/"};
  }

//  @Override
//  protected Filter[] getServletFilters() {
//    Filter encodingFilter = new CharacterEncodingFilter("UTF-8", true);
//    return new Filter[]{encodingFilter};
//}
}
