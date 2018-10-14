package demo.enums;

public enum OrderExceptionEnum {
    RISK_ORDER("001", "刷单用户，禁止下单"),
    NETWORK_ERROR("002", "网络错误，请稍后");
    private String errCode;
    private String errMsg;

    OrderExceptionEnum(String errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public String getErrCode() {
        return errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }
}
