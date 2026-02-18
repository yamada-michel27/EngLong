# 英語長文アプリ

## 概要

英語長文に特化したAndroidアプリ

## 背景

既存の英語学習アプリは、用意された文章を読む形式が中心であり、
ユーザー自身が文章を作成しながら学習する体験が不足している。

文章作成を通じて語彙を定着させるためには、

- 未知単語の記録
- 理解度の管理
- 読解速度の可視化

が重要である。

しかし、これらを統合的に管理できるアプリは少ない。

## 機能

- 英語長文の作成・編集機能
- 単語単位での理解度管理
  - 覚えていない
  - 曖昧
- 理解度に応じた色分け表示(ヒートマップ表示)
- 読解時間の計測機能
- 学習履歴の記録

## 技術

Spring BootによるREST APIとPostgreSQLをDocker環境で構築し、クライアント・サーバー型アーキテクチャで設計しています。

#### 設計方針

- AndroidはUI/UXに専念
- ビジネスロジックはSpring Boot側に分離
- DBへはAPI経由でのみアクセス
- Dockerにより開発環境を統一

## 技術選定理由

- Spring Boot: 型安全で実務利用が多く、設計力向上を目的に採用。また、AndroidだけでなくWebでも使用できるようにしたかったので、分離
- Docker: 環境依存を排除し、再現性のある開発を実現
- PostgreSQL: 実務利用率が高く、拡張性に優れるため採用

#### 技術スタック

##### フロントエンド（Android）

- Java
- Android SDK 36
- OkHttp
- REST API通信

##### バックエンド

- Java 21
- Spring Boot 3.x
- Spring Data JPA
- PostgreSQL
- Docker / Docker Compose

#### 通信の流れ

```
Android Emulator
│
│ HTTP (10.0.2.2:8080)
▼
Spring Boot API (Docker)
│
▼
PostgreSQL (Docker)
```

#### ディレクトリ構成

```
EngLong/
├── android/ # Androidアプリ
├── backend/ # Spring Boot API
├── infra/ # Docker Compose設定
└── README.md
```
