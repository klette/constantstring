Constant String
===============

[![Build Status](https://travis-ci.org/klette/constantstring.svg?branch=master)](https://travis-ci.org/klette/constantstring)
[![Coverage Status](https://img.shields.io/coveralls/klette/constantstring.svg)](https://coveralls.io/r/klette/constantstring)

Constant String is a library for doing constant time string manipulation in
Java.

```java
CString cs = CString.create("foo")
    .concat(CString.create("bar"))
    .substring(3)
    .concat(CString.create("bara"))
    .delete(3,7)
    .insert(0, CString.create("foo"));

cs.toString(); // foobar
```

Perhaps not the most useful thing in everyday programming, but still a fun
exercise to implement.

## Using

The artifacts are published on Maven Central, so trying it out is as simple as adding
the dependency to you `pom.xml` or gradle file.

```xml
<dependency>
  <groupId>us.klette</groupId>
  <artifactId>constantstring</artifactId>
  <version>2.0</version>
</dependency>
```



