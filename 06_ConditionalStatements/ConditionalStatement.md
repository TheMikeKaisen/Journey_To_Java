# Conditional statements in Java — in depth

Nice — let’s dive deep. I’ll cover the full landscape: `if` / `else`, the `?:` ternary, the classic `switch` (including modern switch expressions), boolean logic, short-circuiting, best practices, common pitfalls, and interview-style examples. Code is valid Java (comments show key points). If you want runnable snippets or exercises afterwards, tell me and I’ll provide them.

---

# 1) Basic `if` and `if-else`

```java
int x = 10;

if (x > 0) {
    System.out.println("positive");
} else {
    System.out.println("non-positive");
}
```

* `if` evaluates a boolean expression. The expression **must** be `boolean` (no implicit conversions from int).
* Blocks are controlled by `{}`. Without `{}`, only the single immediate statement is controlled — **beware** of the dangling-statement bug.

Pitfall example (avoid):

```java
if (x > 0)
    System.out.println("positive");
    System.out.println("always prints"); // not part of if
```

---

# 2) `if-else if-else` ladder (multiple branches)

```java
if (score >= 90) {
    grade = 'A';
} else if (score >= 80) {
    grade = 'B';
} else if (score >= 70) {
    grade = 'C';
} else {
    grade = 'F';
}
```

* Evaluated top-to-bottom; the first true branch runs and the rest are skipped. Use ordering carefully.
* Use parentheses for clarity in compound conditions.

---

# 3) Nested `if` and guard clauses

* Nested `if` is allowed but can be messy. Prefer early returns (“guard clauses”) to reduce nesting:

Bad (deep nesting):

```java
if (a != null) {
  if (a.isActive()) {
    if (a.getCount() > 0) {
       // ...
    }
  }
}
```

Better (guards):

```java
if (a == null) return;
if (!a.isActive()) return;
if (a.getCount() <= 0) return;
// ...
```

---

# 4) Boolean logic, precedence & short-circuiting

Operators: `!`, `&&`, `||`, `^` (xor)

Precedence (high → low): `!` → `&&` → `||`.

Short-circuit behavior:

* `A && B`: if `A` is `false`, `B` is **not evaluated**.
* `A || B`: if `A` is `true`, `B` is **not evaluated**.

This is useful (and dangerous) — you can safely do null checks like:

```java
if (obj != null && obj.isValid()) { ... } // safe: second only runs if first true
```

But avoid relying on side effects in the second operand when short-circuiting matters.

---

# 5) Ternary operator `?:` (conditional expression)

```java
String s = (x > 0) ? "positive" : "non-positive";
```

* Returns a value, so can be nested but nesting hurts readability.
* Types of both outcomes must be compatible (or auto-boxing/conversion applies).

Bad when complex:

```java
String x = cond1 ? (cond2 ? "a" : "b") : (cond3 ? "c" : "d"); // hard to read
```

---

# 6) `switch` statement — classic and modern

## Classic `switch` (works with `int`, `char`, `short`, `byte`, `String` (since Java 7), `enum`)

```java
switch (day) {
    case "MONDAY":
        System.out.println("Start of week");
        break;                // prevents fall-through
    case "TUESDAY":
        System.out.println("Second day");
        break;
    default:
        System.out.println("Other day");
}
```

Key points:

* **Fall-through**: without `break`, execution continues into the next case. Useful intentionally, but error-prone.
* `case` labels must be compile-time constants.
* `switch` on `null` for `String` will throw `NullPointerException`.

## Enhanced `switch` / switch expressions (Java 14+ standardized)

Arrow labels and `yield` let `switch` be used as an expression:

```java
String result = switch (day) {
    case "MONDAY", "TUESDAY" -> "start";
    case "WEDNESDAY" -> "mid";
    case "THURSDAY", "FRIDAY" -> "almost";
    case "SATURDAY", "SUNDAY" -> "weekend";
    default -> "unknown";
};
```

Or with block + `yield`:

```java
int value = switch (obj.getType()) {
    case TYPE_A -> 1;
    case TYPE_B -> {
        // complex logic
        int computed = compute();
        yield computed * 2;
    }
    default -> -1;
};
```

* Arrow `->` **does not fall through** by default (safer).
* You can group labels with commas.
* Use `yield` inside block forms to produce the expression's value.

---

# 7) `instanceof` and pattern matching (modern)

Classic:

```java
if (obj instanceof String) {
    String s = (String) obj;
    // use s
}
```

Pattern matching for `instanceof` (Java 16+ finalized):

```java
if (obj instanceof String s) {
    // s is in scope and already cast
    System.out.println(s.length());
}
```

* Reduces boilerplate casting.
* Scope of the pattern variable is limited to the `if` block (or logical scope it appears in).

---

# 8) Using enums with `switch`

```java
enum Day { MON, TUE, WED }
switch(day) {
  case MON -> ...
  case TUE -> ...
}
```

* Very common and safe (no risk of spelling mistakes compile-time).

---

# 9) Null handling & NPEs in conditionals

* Always check for `null` before calling methods on an object (or use `Objects.requireNonNull` if nulls are exceptional).
* `Objects.equals(a, b)` is null-safe for equality tests: it returns `true` if both null, `false` if one null.
* For `String` comparisons prefer constant-first pattern for null-safety:

    * `"constant".equals(s)` avoids NPE if `s` is null.

---

# 10) Common pitfalls and gotchas

1. **Assignment vs equality**: `if (a = true)` is a compile error in Java (since `a = true` yields `boolean`, but if `a` is boolean variable it’s allowed — but best avoid). Unlike C, `if (x = 1)` with int is a compile error in Java because non-boolean can't be used in `if`.
2. **Floating point comparisons**: Do not use `==` for double/float when equality semantics are approximate; use `Math.abs(a - b) < eps`.
3. **String `==`** vs `.equals()`:

    * `==` checks reference equality (same object).
    * `.equals()` checks content (what you usually want).
4. **Switch on null**: Causes `NullPointerException` for `String` or boxed types. Check for null first.
5. **Fall-through forgetting `break`**: leads to logic errors.
6. **Complex boolean expressions**: parenthesize for readability even if precedence rules would work.

---

# 11) Readability & style best practices

* Favor small, clear boolean expressions. Extract complex conditions into well-named boolean methods:

  ```java
  if (user.isActive() && !user.isSuspended() && hasPermission(user)) { ... }
  // or
  if (canPerformAction(user)) { ... } // encapsulates complexity
  ```
* Prefer `switch` for many-discrete-value branching (especially enums).
* Prefer `if` for range checks or boolean logic.
* Use early returns to reduce nesting and improve readability.
* Avoid deeply nested ternary expressions — use `if` for clarity.

---

# 12) Performance considerations

* Conditional statements themselves are cheap; the expensive part is the code executed inside branches.
* Keep hot paths simple and avoid unnecessary object creation inside frequently executed branches.
* Branch prediction in CPUs makes predictable branches fast; deeply random branch patterns can reduce performance. This is micro-optimization and rarely needed in application code.

---

# 13) Interview-style examples & explanations

1. **Check palindrome ignoring non-alpha and case**

    * Use two-pointer `while (i < j)` with `Character.isLetterOrDigit()` and short-circuit checks.

2. **Longest run of same char**

    * Iterate, use `if (s.charAt(i) == s.charAt(i-1)) count++ else reset`.

3. **Grading logic**: show `if-else if-else` vs `switch` on a bucketed integer grade.

I can provide full example solutions for any of these on request.

---

# 14) Quick cheat-sheet (most common constructs)

* `if (cond) { }`
* `if (cond) { } else { }`
* `if (c1) { } else if (c2) { } else { }`
* `result = cond ? a : b;`  // ternary
* `switch (val) { case A: break; case B: ... default: ... }`
* `switch (val) { case A, B -> expression; default -> ... }` // enhanced switch

---



