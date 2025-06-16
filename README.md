# 簡易預金管理システム（BankSystem）

Spring Boot と HTML（一部JavaScript）を使って構築した、簡単なWebベースの預金管理システムです。  
ユーザーがログイン後に、入金・出金・残高確認が行える機能を備えています。

---

## 使用技術

| 種別        | 内容                                  |
|-------------|---------------------------------------|
| 言語        | Java, HTML, JavaScript                |
| フレームワーク | Spring Boot (v3.5.0)                   |
| IDE         | Eclipse                   |
| ビルドツール | Maven（Spring Initializr 経由）         |

---

## 📦 構成ディレクトリ概要
<pre>
BankSystem/
├── src/
│ └── main/
│ ├── java/
│ │  └── com/example/demo/
│ │   ├── BankSystemApplication.java
│ │   ├── BankAccount.java
│ │   ├── BankController.java
│ │   └── HomeController.java
│ └── resources/
│ └── static/
│   ├── login.html
│   └── transaction.html
├── pom.xml
└── README.md
</pre>
  
---

## 起動手順

1. Eclipse でプロジェクトをインポート（Maven プロジェクト）
2. `BankSystemApplication.java` を右クリック → 実行（Javaアプリケーション）
3. [URLにアクセス：]http://localhost:8080/

---

## ログイン情報（初期値）

| 項目       | 値         |
|------------|------------|
| ユーザーID | `1234567`  |
| パスワード | `1234`     |

---

## 画面概要

### 1. ログイン画面（`login.html`）

- ユーザーIDとパスワードを入力
- 成功すると `/transaction.html` に遷移

### 2. 入出金画面（`transaction.html`）

- 入金・出金・残高確認の各ボタンを操作
- REST API 経由でサーバーと通信

---

## クラスと役割

| ファイル名                 | 説明                                                         |
|---------------------------|--------------------------------------------------------------|
| `BankSystemApplication.java` | Spring Bootアプリのエントリーポイント                         |
| `BankAccount.java`        | ロジック（ログイン認証、入出金、残高）を管理するモデル         |
| `BankController.java`     | `/api/**` に対する REST API を提供するコントローラー          |
| `HomeController.java`     | ルートパス `/` にアクセスしたとき `login.html` にリダイレクト   |

---

## 利用可能なAPI

| メソッド | エンドポイント     | 概要                 |
|----------|--------------------|----------------------|
| POST     | `/api/login`       | ログイン認証         |
| POST     | `/api/deposit`     | 入金                 |
| POST     | `/api/withdraw`    | 出金                 |
| GET      | `/api/balance`     | 残高確認             |

---

## 苦労した箇所

- 設計<br>
  システム設計の初期段階では、chatGPTを活用して仕様を明確化しながら構成をブラッシュアップした
- エラー処理<br>
  自己調査とツールを併用して、ロジックや非同期通信に関するエラーの解消を行った

---

