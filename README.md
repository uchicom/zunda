zunda
=====

文字列を文字コードの１６進数文字列に変換、及びその逆変換ツール

## mvn
### 起動
```
mvn exec:java "-Dexec.mainClass=com.uchicom.zunda.Main"
```

### フォーマッタ
```
mvn spotless:apply
```

### 全体テスト実行
```
mvn verify
```

#### ファイル単体でテスト実行
```
mvn test "-Dtest=com.uchicom.zunda.Test"
```

### フォーマッタ & 全体テスト実行
```
mvn spotless:apply clean compile verify
```
