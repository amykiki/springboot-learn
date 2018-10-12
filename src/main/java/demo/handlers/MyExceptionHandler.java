package demo.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author :  ZouShumin
 * @Project Name :  springboot-learn
 * @Package Name :  demo.handlers
 * @Description :
 * @Creation Date:  2018-10-09 14:35
 * --------  ---------  --------------------------
 */
@Component
public class MyExceptionHandler implements HandlerExceptionResolver {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyExceptionHandler.class);
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        String url = request.getScheme() + "://" + request.getServerName() + ":"
                     + request.getServerPort() + request.getServletPath();
        LOGGER.info("=====INTO MyExcetionHander====:" + url);
        if (null != ex) {
            LOGGER.error(ex.getMessage());
        }
        return null;
//        return new ModelAndView("myexe");

    }

}
