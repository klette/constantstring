Constant String
===============

[![Build Status](https://travis-ci.org/klette/constantstring.svg?branch=master)](https://travis-ci.org/klette/constantstring)
[![Coverage Status](https://img.shields.io/coveralls/klette/constantstring.svg)](https://coveralls.io/r/klette/constantstring)

Constant String is a library for doing constant time string manipulation in
Java.

```java
CString cs = CStringInit
    .create("foo")
    .concat(CStringInit.create("bar"))
    .substring(3)
    .concat(CStringInit.create("bara"))
    .delete(3,7)
    .insert(0, CStringInit.create("foo"));

cs.toString(); // foobar
```

Perhaps not the most useful thing in everyday programming, but still a fun
exercise to implement.



