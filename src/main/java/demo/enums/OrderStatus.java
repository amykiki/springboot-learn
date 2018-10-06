package demo.enums;

public enum OrderStatus {
    WAIT_PAID(0),
    ALREADY_PAID(1),
    WAIT_DELIVERED(2),
    ALREADY_DELIVERED(3),
    ORDER_SUCCESS(4),
    ORDER_CLOSED(5),
    ORDER_FAIL(6);

    OrderStatus(Integer status) {
        this.status = status;
    }
    private Integer status;

    public Integer getStatus() {
        return status;
    }
}
