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

boot 07 -- 老師的在06版
1.異步請求測試，新增首頁、axios頁
2.axios和vue封裝成模板代碼，並在axios頁導入，簡單測試
3.測試兩種異步的呈現方式，get和post
    3-1.傳無參
    3-2.傳有參
    3-3.傳物件

boot 08 -- 老師的在07版
1.登入註冊改為異步請求版本

boot 09 -- 老師的在08版
1.商品管理系統改為異步請求版本

boot 09-1 -- 老師版10-2
1.上述商品管理系統改為mybatis xml配置方式(未改完)

boot 10(失敗，10-1成功，再找時間改) -- 老師的在09版
1.異步請求:圖文上傳功能
2.商品列表增刪改查

boot 11 -- 老師的在10版
1.通过xml配置文件的方式,配置Mapper中需要用到的SQL语句
2.在test包(可看成controller包中類功能)中，測試增刪改查

boot 11-1
1.11練習，僅有增功能

boot 12
1.分頁統計練習
2.動態SQL練習，在xml的sql中插入foreach標籤遍歷

boot 12-1
1.分頁統計練習
2.動態SQL練習，在xml的sql中插入foreach標籤遍歷練習

weibo
1.實現註冊功能，成功跳出訊息，失敗跳出訊息已存在
2.登入後，顯示連結 可退出登入，可發微薄，微薄裡面有圖片上傳和說話功能
3.首頁下方展示微薄列表
4.列表先有內容，再有圖片
5.內容是超連結，點即可進到詳細訊息葉面
6.詳細訊息值內，第一是 誰說 : 說甚麼內容
7.第二行發布時間，格式 "发布时间:2022年11月17日 17時14分00秒"
8.下面再顯示圖片
9.分割線，可發表評論，接收用input，再用button傳
10.發表完評論，跳出評論完成，直接在下方評論列表顯示結果
11.結果一樣同   誰說 : 說甚麼內容 + 時間



