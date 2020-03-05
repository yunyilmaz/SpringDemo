package com.yunyilmaz.OrderService;

public class OrderRequestDTO {

    private int customerId;
    private int productId;
    private int count;

    @Override
    public String toString() {
        return "OrderRequestDTO [customerId=" + customerId + ", productId=" + productId + ", count=" + count + "]";
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
