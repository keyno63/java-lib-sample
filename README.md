# java-lib-sample

Java の library の砂場  
Filter plugin 的なのを試したい.  

## やったこと
### 必要なレポジトリの追加

gradle に必要なモジュールを追加  

servlet filter のファイルを追加
[Maven Repository: javax\.servlet » javax\.servlet\-api](https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api)

### 実装

### 必要な import は以下
javax.servlet.*  
なぜか勝手に `*` import する
  
### クラスに Filter の実装をする  
### 必要な override
- init
  設定の初期化
- doFilter
  リクエストを受け取ったあとの Filter の処理する実装  
  メインロジック
- destroy
  終了時の処理
