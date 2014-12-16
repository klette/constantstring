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

## API

Constant String exposes a simple API via the CString-interface. The static method `CString.create(...)` allows you to quickly create a new instance of a (hidden) implementation of the interface. Some of the operations are similar to the ones found on the built-in Java String class, such as the substring method. On these we try hard to map the arguments and functionality as close as possible.


### Operations

The following operations are supported by the API.

### toString()

The `toString()`-method evaluates the graph of operations, and returns the final result as a String. This is done
in a non-constant time. 

#### Create

Create a new CString instance from a String.

##### Example

`CString myStr = CString.create("The start of my text goes like this..")`

#### Substring

Extracts a part of a String, either only by start index to the end of the string, or by a start index and an end index.

##### Examples

```java
myStr.substring(4).toString() // "start of my text goes like this.."
myStr.substring(4,8).toString() // "start"
```

#### Concat

Appends a String at the end of the current value.

##### Example

```java
CString.create("foo")
       .concat(CString.create("ba"))
       .concat("r")
       .toString() // "foobar" 
```

#### Delete

Delete part of a string specified by a start index and an end index.

##### Example

```java
CString.create("foobar").delete(3,6).toString() // "foo"
```

#### Insert

Inserts a String at a given index.

##### Example

```java
CString.create("foar").insert("o",2).insert(CString.create("b"), 3).toString() // "foobar" 
```
