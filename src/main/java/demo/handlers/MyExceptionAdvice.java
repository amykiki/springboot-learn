package demo.handlers;

import demo.enums.OrderExceptionEnum;
import demo.exceptions.OrderException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionAdvice {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyExceptionAdvice.class);

    /*@ExceptionHandler({OrderException.class})
    @ResponseBody
    public Map<String, Object> hdndleOrderException(OrderException e) {
        Map<String, Object> retMap = new HashMap<>();
        retMap.put("errorCode", e.getErrorCode());
        retMap.put("errorDesc", e.getErrorDesc());
        return retMap;
    }*/
    @ExceptionHandler({OrderException.class})
    public ModelAndView handleOrderExceptionHtml(OrderException e, HttpServletResponse response) {
        Map<String, Object> retMap = new HashMap<>();
        retMap.put("errorCode", e.getErrorCode());
        retMap.put("errorDesc", e.getErrorDesc());
        ModelAndView mv = new ModelAndView("errorExe", retMap);
        if (e.getErrorCode().equals(OrderExceptionEnum.NETWORK_ERROR.getErrCode())) {
            response.setStatus(HttpStatus.BAD_GATEWAY.value());
        }
        return mv;
    }
}
