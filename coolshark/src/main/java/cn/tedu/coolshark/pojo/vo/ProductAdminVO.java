package cn.tedu.coolshark.pojo.vo;

import java.util.Date;

public class ProductAdminVO {
    private Integer id;
    private String title;
    private String url;
    private Double price;
    private Integer saleCount;

    @Override
    public String toString() {
        return "ProductAdminVO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", price=" + price +
                ", saleCount=" + saleCount +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(Integer saleCount) {
        this.saleCount = saleCount;
    }
}
