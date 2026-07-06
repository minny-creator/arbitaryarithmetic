# ARBITARY ARITHMETIC

`AInteger.java` describes the `AInteger` class.(https://github.com/minny-creator/arbitaryarithmetic/blob/main/arbitaryarithmetic/AInteger.java)

`AFloat.java` describes the `AFloat` class.(https://github.com/minny-creator/arbitaryarithmetic/blob/main/arbitaryarithmetic/AFloat.java)

`App.java` is the main application of the project.

## Project Structure

```text
ProjectFolder
│
└── src
    └── com
        └── project1
            ├── App.java
            ├── AInteger.java
            └── AFloat.java
```

## Compilation

```bash
cd src
javac com/project1/*.java
```

## Commands Available

### Integer Addition

```bash
java com.project1.App int add A B
```

### Integer Subtraction

```bash
java com.project1.App int sub A B
```

### Integer Multiplication

```bash
java com.project1.App int mul A B
```

### Integer Division

```bash
java com.project1.App int div A B
```

### Float Addition

```bash
java com.project1.App float add A B
```

### Float Subtraction

```bash
java com.project1.App float sub A B
```

### Float Multiplication

```bash
java com.project1.App float mul A B
```

### Float Division

```bash
java com.project1.App float div A B N
```

Where:
- `A`, `B` → operands
- `N` → number of digits required after the decimal point of the result.

## Highlights

- More accurate than a normal calculator (e.g. `0.999999` is represented exactly).
- Supports arbitrarily large numbers, unlike built-in numeric types.

## Drawbacks

- The maximum input and output size is limited by Java's maximum `String` length.

