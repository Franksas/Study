# Redis
## NoSQL的优势
- 大数据量，高性能
- 灵活的数据模型
- 高可用
- 成本低
## NoSQL的劣势
- 无关系，数据之间是无联系的
- 不支持标准的SQL，没有公认的NoSQL标准
- 没有关系型数据库的约束，大多数也没有索引的概念
- 没有事务，不能 依靠事务实现ACID
- 没有丰富的数据类型（数值，日期，字符，二进制，大文本等）
### Redis是当今非常流行的基于KV结构的作为Cache使用的NoSQL数据库

<img src="F:\qq\MobileFile\R[4QOEYAPM@EULUJG3T}03P.png">
- 内存级别的缓存：map,ehcache，OSCache
- 分布式缓存：men cache，Redies，couchbase
## Redies
#### key的6个基本命令
- keys
- exists
- expire
- ttl
- type
- del
