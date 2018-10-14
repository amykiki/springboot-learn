package demo.exceptions;

public class OrderException extends RuntimeException{
    private static final long serialVersionUID = -6303200653305351161L;
    private String errorCode;
    private String errorDesc;

    public OrderException(String errorCode, String errorDesc) {
        super();
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
    }

    public OrderException(String message, String errorCode, String errorDesc) {
        super(message);
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
    }

    public OrderException(String message, Throwable cause, String errorCode, String errorDesc) {
        super(message, cause);
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
    }

    public OrderException(Throwable cause, String errorCode, String errorDesc) {
        super(cause);
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
    }

    public OrderException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String errorCode, String errorDesc) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorDesc() {
        return errorDesc;
    }
}
