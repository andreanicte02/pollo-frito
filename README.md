# Pollo Frito

An interpreter for an **R-like language** written in Java: vectors, lists, matrices, functions and
control flow, with **two interchangeable parsers** (JFlex + CUP, and JavaCC), symbol-table and error
reports, AST visualization and a Swing editor with syntax highlighting.

**▶ Try it in the browser: <https://andreanicte02.github.io/pollo-frito/>**

The demo is the original Swing app running unchanged through [CheerpJ](https://cheerpj.com), a Java
runtime for WebAssembly. It opens with the example programs already loaded, one per tab.

## The language

```r
a = c(1, 2, 3);                 # vectors
a[1][1][1] = 5;
print(1 + a);                   # [6, 3, 4]
l = list(25, "hola", c(1, 2));  # nested lists
m = matrix(c(1, 2, 3, 4), 2, 2);

factorial = function(num) {
  if (num == 0) {
    return 1
  } else {
    return num * factorial(num - 1)
  }
}
print(factorial(5))             # [120]
```

Also: arrow functions with default parameters, `if`/`switch`/`while`/`do-while`/`for`, `break` and
`continue`, case-insensitive identifiers, and native functions such as `length`, `trunk`, `round`,
`toLowerCase`, `pie`, `barplot`, `hist` and `plot`.

## Example programs

The programs in [`src/com/polloenpelotas/ArchivosPrueba`](src/com/polloenpelotas/ArchivosPrueba) are
published with the demo under descriptive names (see [`web/ejemplos.json`](web/ejemplos.json)):

| Demo tab | Source | Shows |
|---|---|---|
| `01-factorial-recursivo` | `A7.txt` | A recursive function |
| `02-vectores-y-listas` | `A2.txt` | Vectors, lists, indexed assignment, vector arithmetic |
| `03-combinar-tipos` | `A3.txt` | `c()` mixing types, nested lists, case-insensitive names |
| `04-funciones-flecha-y-defaults` | `A6.txt` | Arrow functions, default parameters, native functions |
| `05-control-y-matrices` | `A5.txt` | `switch`, `while`, `do-while`, matrices, nested updates |
| `06-prueba-completa` | `A1.txt` | Everything together, including `for` loops |

## How it works

- **Two front ends, one AST.** [`Lexico.jflex`](src/com/polloenpelotas/AnalizadorCup/Lexico.jflex) +
  [`Sintactico.cup`](src/com/polloenpelotas/AnalizadorCup/Sintactico.cup) (LALR) and
  [`Gramatica.jj`](src/com/polloenpelotas/AnalizadorJCC/Gramatica.jj) (JavaCC, LL) build the same node
  classes in [`language/nodes`](src/com/polloenpelotas/language/nodes). The grammars are documented in
  [`Documentacion/`](Documentacion).
- **Tree-walking interpreter.** Each node evaluates itself against a scope chain (`ZAmbit`); values are
  `ZVector`, `ZList`, `ZMatriz`, `ZFunction`, etc.
- **Reports.** Symbol table, lexical/syntax/semantic errors, a Graphviz AST and Plotly charts.

## Run it locally

```sh
mvn package
java -jar target/pollo-frito.jar                       # empty editor
java -jar target/pollo-frito.jar src/com/polloenpelotas/ArchivosPrueba/A7.txt   # open files in tabs
```

Charts and the AST image need [Graphviz](https://graphviz.org) and a desktop (they write files and
open them), so in the browser demo they report an error instead.

The UI was designed with IntelliJ's GUI Designer (`GUI2.form`). Builds that don't run IntelliJ's
form compiler, like Maven or the web demo, create the same layout in code.

## Credits

By [Andrea Nicte Vicente Campos](https://github.com/andreanicte02), for Compilers 2 (OLC2) at USAC, 2020.
The web demo uses the CheerpJ Community Edition, which is free for personal and non-commercial use.
