boot 01版
1.mybatis傳參測試，體重BMI檢測小程序

boot 02版
1.新增首頁、登入頁、註冊頁
2.新增用戶註冊業務，用戶登入業務

boot 03版
1.新增首頁、商品添加頁、商品修改頁
2.新增商品添加業務
3.新增動態請求-商品列表查詢在首頁上
4.新增列表中刪除功能
5.新增修改功能

boot 04版
1.練習上述業務功能
2.重寫成員工管理系統

boot 05版 -- 老師的在04版
1.創建工程時，新增Mybatis框架，勾選Spring Web + MyBitis Framework + MySQL Drive
2.重新配置resources裡面的application.properties文件
    (相當於DBUtils初始化和連接功能，他幫我們減化JDBC代碼量)
3.配置信息 : 資料庫url(sdu), 帳號(sdu), 密碼(sdp)
4.將之前做的商品新增、查詢、修改、刪除全部換成mybatis框架形式

boot 06版 -- 老師的在05版
1.將之前做的登入註冊系統，新增、查詢、修改、刪除全部換成mybatis框架形式

boot 07
1.異步請求測試，新增首頁、axios頁
2.axios和vue封裝成模板代碼，並在axios頁導入，簡單測試
3.測試兩種異步的呈現方式，get和post
    3-1.傳無參
    3-2.傳有參
    3-3.傳物件