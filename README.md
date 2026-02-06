# 家計簿アプリ
---

## プロジェクト概要
自分専用の家計簿を付ける為のアプリです。
claudeと一緒にバックエンドの実装やコードの勉強を行う。

## 起動方法
```powershell
cd C:\dev\kakeibo
.\mvnw.cmd spring-boot:run
```
起動後、http://localhost:8080 でアクセス可能。

## テスト実行方法

```powershell
	# 全テスト実行
	.\mvnw.cmd test
	
	# 特定のテストクラスのみ実行
	.\mvnw.cmd test -Dtest=AmountTest
	.\mvnw.cmd test -Dtest=CategoryNameTest
	.\mvnw.cmd test -Dtest=DeleteCategoryUseCaseTest
	.\mvnw.cmd test -Dtest=CategoryControllerTest
```

## API一覧

### カテゴリ（Category）

| メソッド | エンドポイント | 説明 | ステータス |
|---------|---------------|------|-----------|
| POST | `/api/categories` | カテゴリを作成 | 201 |
| GET | `/api/categories` | カテゴリ一覧を取得 | 200 |
| DELETE | `/api/categories/{id}` | カテゴリを削除 | 204 |

### 収支（Transaction）

| メソッド | エンドポイント | 説明 | ステータス |
|---------|---------------|------|-----------|
| POST | `/api/transactions` | 収支を登録 | 201 |
| GET | `/api/transactions` | 収支一覧を取得 | 200 |
| GET | `/api/transactions/{id}` | 収支詳細を取得 | 200 |
| PUT | `/api/transactions/{id}` | 収支を更新 | 200 |
| DELETE | `/api/transactions/{id}` | 収支を削除 | 204 |
| GET | `/api/transactions/summary` | 月次集計を取得 | 200 |

---

## 開発用ツール

| ツール | URL | 用途 |
|--------|-----|------|
| Swagger UI | http://localhost:8080/swagger-ui/index.html | API ドキュメント・テスト |
| H2 Console | http://localhost:8080/h2-console | DB 確認 |

### H2 Console 接続情報

- JDBC URL: `jdbc:h2:mem:kakeibodb`
- User: `sa`
- Password: （空欄）

