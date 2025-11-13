Here is a **clean, deep, interview-friendly explanation** of *all loops in Java* — including how they work internally, where to use each, common pitfalls, performance notes, and modern enhanced features.

---

# ✅ **Loops in Java — In Depth**

Java provides **4 main looping constructs**:

1. `for` loop
2. `while` loop
3. `do-while` loop
4. Enhanced `for-each` loop (Java 5+)

Plus extra controls: `break`, `continue`, and labeled loops.

Let’s go step by step.

---

# 1) **The `for` loop**

### 🔹 Syntax

```java
for (initialization; condition; update) {
    // loop body
}
```

### ✔ How it works internally

1. Initialization runs **once** (before the loop starts).
2. Condition is checked. If **true**, body executes.
3. Update executes (after each iteration).
4. Condition is checked again.
5. Repeats until condition becomes false.

### 🔥 Example

```java
for (int i = 0; i < 5; i++) {
    System.out.println(i);
}
```

### 🔥 Multiple initializations or updates

```java
for (int i = 0, j = 10; i < j; i++, j--) {
    System.out.println(i + " " + j);
}
```

---

# 2) **The `while` loop**

### 🔹 Syntax

```java
while (condition) {
    // body
}
```

### ✔ Execution flow

* Condition is checked **before** the loop begins.
* If true → loop runs.
* If false → loop is skipped.

### ➤ Use when:

* You don't know how many times the loop will run.
* Loop depends on dynamic conditions.

### Example

```java
while (x > 0) {
    x--;
}
```

---

# 3) **The `do-while` loop**

### 🔹 Syntax

```java
do {
    // body
} while (condition);
```

### ✔ Execution flow

* Body runs **at least once** (even if condition is false).
* Condition is checked **after** execution.

### Example

```java
do {
    System.out.println("Runs at least once");
} while (false);
```

---

# 4) **Enhanced `for-each` loop (Java 5+)**

Works on:

* arrays
* `Iterable` (ArrayList, LinkedList, HashSet, etc.)

### 🔹 Syntax

```java
for (Type variable : collection) {
    // use variable
}
```

### Example

```java
int[] arr = {1, 2, 3};
for (int num : arr) {
    System.out.println(num);
}
```

### ✔ Advantages

* Cleaner, safer.
* No index errors.

### ❌ Limitations

You **cannot**:

* Modify the collection’s structure inside loop (ConcurrentModificationException).
* Access the index directly.
* Iterate backward.

---

# 5) **Loop Control Statements**

## 🔹 `break`

Exits the loop immediately.

```java
for (int i = 0; i < 10; i++) {
    if (i == 5) break;
}
```

---

## 🔹 `continue`

Skips **current iteration**, moves to next.

```java
for (int i = 0; i < 5; i++) {
    if (i == 2) continue;
    System.out.println(i);
}
```

---

# 6) **Labeled Loops (Advanced)**

Useful when breaking nested loops cleanly.

### Example

```java
outer:
for (int i = 1; i <= 3; i++) {
    for (int j = 1; j <= 3; j++) {
        if (j == 2) break outer;
        System.out.println(i + " " + j);
    }
}
```

### ⚠ Why use it?

To break **multiple levels** at once.

---

# 7) **Infinite Loops**

### 🔹 Using `for`

```java
for (;;) { }
```

### 🔹 Using `while`

```java
while (true) { }
```

Used in servers, listeners, real-time tasks.

---

# 8) **Iterating Collections — Best Practices**

### ArrayList — best with `for-each`

```java
for (String s : list) { }
```

### HashMap iteration

```java
for (Map.Entry<String, Integer> e : map.entrySet()) {
    System.out.println(e.getKey() + "=" + e.getValue());
}
```

### Indexed iteration (when needed)

```java
for (int i = 0; i < list.size(); i++) {
    System.out.println(list.get(i));
}
```

---

# 9) **Common Pitfalls**

### ❌ Forgetting to update the variable

Causes infinite loop.

```java
while (i < 5) {
    // i never changes -> stuck
}
```

### ❌ Using `for-each` but needing index

Use normal `for` instead.

### ❌ Modifying collection during iteration

Throws `ConcurrentModificationException`.

Correct:

```java
Iterator<Integer> it = list.iterator();
while (it.hasNext()) {
    int x = it.next();
    if (x == 5) it.remove();
}
```

---

# 10) **Performance Notes**

* Classic `for` and `while` perform the same.
* For arrays → `for-each` is efficient & clean.
* For ArrayLists → `for-each` is usually faster than indexed `for`.
* For LinkedList → never use indexed loop (`list.get(i)` is O(n)).

---

# 11) **Interview-Level Examples**

## Example 1: Reverse a number using loop

```java
int rev = 0;
while (n > 0) {
    int digit = n % 10;
    rev = rev * 10 + digit;
    n /= 10;
}
```

## Example 2: Cycle through 2D matrix

```java
for (int i = 0; i < m; i++) {
    for (int j = 0; j < n; j++) {
        System.out.print(arr[i][j] + " ");
    }
}
```

## Example 3: Sum of digits using do-while

```java
int sum = 0;
do {
    sum += n % 10;
    n /= 10;
} while (n > 0);
```

---

# 12) **Quick Table Summary**

| Loop       | Condition Check | Runs At Least Once | Has Index | Best For              |
| ---------- | --------------- | ------------------ | --------- | --------------------- |
| `for`      | Before          | No                 | Yes       | Count-based loops     |
| `while`    | Before          | No                 | No        | Dynamic conditions    |
| `do-while` | After           | Yes                | No        | Menu-like tasks       |
| `for-each` | Internal        | No                 | No        | Iterating collections |

---