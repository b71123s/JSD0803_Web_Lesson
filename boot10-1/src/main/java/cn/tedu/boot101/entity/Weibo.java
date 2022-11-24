package cn.tedu.boot101.entity;

public class Weibo {
    private Integer id;
    private String content;
    private String url;
/*
use empdb;
create table weibo(id int primary key auto_increment,
                    content varchar(100),url varchar(200));
* */
    @Override
    public String toString() {
        return "Weibo{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
