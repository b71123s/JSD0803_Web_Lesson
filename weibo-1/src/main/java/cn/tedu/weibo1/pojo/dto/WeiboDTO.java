package cn.tedu.weibo1.pojo.dto;

import java.lang.ref.PhantomReference;

public class WeiboDTO {
    private String content;
    private String urls;

    @Override
    public String toString() {
        return "WeiboDTO{" +
                "content='" + content + '\'' +
                ", urls='" + urls + '\'' +
                '}';
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrls() {
        return urls;
    }

    public void setUrls(String urls) {
        this.urls = urls;
    }
}
