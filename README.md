gsolIcalUtil
============

ICalenddar utilities on intra-mart Accel Collaboration

* Version 2016.7

## 概要
intra-mart Accel Collaboration(以下、iAC)のカレンダーを読み取って、icsファイルに出力します。
付属のDDLをiACのDBに適用することで、更新されたスケジュールのみ抽出し、icsファイルを出力するバッチが作成できます。

## ファイル構成
* doc : Javadoc
* sample : actionとjobのサンプル
* src
    * main
        * conf/message/gsol/ical : descriptionの生成に使用
        * java/jp/co/gsol/oss/ical
            * data : カレンダーの変換
            * entity
            * exception
            * io : ファイル操作
            * logic : ファイル操作・DBアクセスの抽象化
            * model : カレンダーモデル
            * service : DBアクセス
                * extended
            * settings : 設定ファイル読み込み
        * resources
            * iCalSetting.json : 設定ファイル
            * jp/co/gsol/oss/ical/service/extended : SQL
* target/gsol-ical-util.jar
* build.xml : jar生成用ビルドファイル
* build.properties : ライブラリパス設定ファイル
* ChangeLog
* ical-ddl.sql : postgres用DDL
* LICENSE
* README.md

## 動作環境
* intra-mart Accel Collaboration 2013 Winter or later
* postgres v9.2, v9.3, v9.4
* JavaSE 1.8

## インストール (jarで出力する場合)
1. build.propertiesのINTREMART_HOME(webapp directoryのlib)とJAVAX_PERSISTENCE(javax.persistencdの実装を含んだjar)を設定し、jarをコンパイル
2. gsol-ical-util.jarをプロジェクトのビルドパスに追加
3. main/conf/message/gsol/ical/ical-message.propertiesをプロジェクトの同じpathに配置
4. main/resourcesにiCalSetting.jsonを設置・編集
5. ical-ddl.sqlをiACスケジュールのDBに適用
6. app.diconにs2jdbc.diconのincludeを追加
7. jobとactionを作成。job schedulerの設定

## インストール (immで出力する場合)
1. module assembllyを設定し、ビルドパスを通す
2. ユーザモジュールとしてエクスポート
3. エクスポートしたユーザモジュールをプロジェクトに依存性に追加
4. main/resourcesにiCalSetting.jsonを設置・編集
5. ical-ddl.sqlをiACスケジュールのDBに適用
6. app.diconにs2jdbc.diconのincludeを追加
7. jobとactionを作成。job schedulerの設定

## 設定ファイル iCalSetting.json
```javascript
{
    // icsファイルを書き込むディレクトリ
    documentDirectory: "\\absolute\\path\\to\\your\\webapp\\ical\\ics",
    // icsファイルdownload URI
    locationPath: "http://example.com/ical/ics",
    // icsファイル出力アプリのプロダクト名
    prodId: "-//Global Solutions Co., Ltd.//iAC Calendar/EN",
    // カレンダー名({userCd}をユーザコードに置換)
    calendarNameTemplate: "{userCd} @ iAC Calendar",
    // 何ヶ月前のスケジュールまで抽出するか
    icsStartMonth: -1,
    // 何ヶ月後のスケジュールまで抽出するか
    icsEndMonth: 13,
    // icsファイル名の長さ
    icsFilenameLen: 50,
    // icsファイルの拡張子
    icsFileExtension: ".ics",
    // 一時ファイルのprefix
    tempFilePrefix: null,
    // 一時ファイルの拡張子
    tempFileSuffix: null,
    // ファイルのencoding
    charset: "utf-8",
    // iacSchEventテーブルのdate文字列のパターン
    iacSchEventDatePattern: "yyyyMMdd"
}
```

## 著作権および特記事項
このライブラリの著作権は、Global Solutionsが所有しています。
利用者は、GPL version 3にて、本ライブラリを使用することができます。
詳しくは、LICENSEを参照してください。
intra-mart は株式会社 NTT データ イントラマートの登録商標です。

## THANKS
* iCal4j

## 連絡先
* github : https://github.com/Global-Solutions
