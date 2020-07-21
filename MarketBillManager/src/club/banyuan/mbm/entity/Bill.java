package club.banyuan.mbm.entity;

public class Bill {
    private int id;
    private int providerId;
    private int money;
    private String product;
    private boolean isPay;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public boolean isPay() {
        return isPay;
    }

    public void setPay(boolean pay) {
        isPay = pay;
    }
}
