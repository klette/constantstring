Constant String
===============

[![Build Status](https://travis-ci.org/klette/constantstring.svg?branch=master)](https://travis-ci.org/klette/constantstring)
[![Coverage Status](https://img.shields.io/coveralls/klette/constantstring.svg)](https://coveralls.io/r/klette/constantstring)

Constant String is a library for doing constant time string manipulation in
Java.

```java

CString cs = CStringInit
    .create("foo")
    .append("bar")
    .substring(3)
    .add("bara");

cs.toString(); // barbara

```

Perhaps not the most useful thing in everyday programming, but still a fun
exercise to implement.



