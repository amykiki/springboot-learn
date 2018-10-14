package demo.controller;

import demo.enums.OrderExceptionEnum;
import demo.exceptions.OrderException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/order")
public class OrderController {

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getOrderList() {
        return "order/list";
    }

    @RequestMapping(value = "/exe/{type}", method = RequestMethod.GET)
    @ResponseBody
    public String orderExe(@PathVariable int type) {
        if (type == 2) {
            throw new OrderException(OrderExceptionEnum.NETWORK_ERROR.getErrCode(), OrderExceptionEnum.NETWORK_ERROR.getErrMsg());
        }else {
            throw new OrderException(OrderExceptionEnum.RISK_ORDER.getErrCode(), OrderExceptionEnum.RISK_ORDER.getErrMsg());
        }
    }
}
