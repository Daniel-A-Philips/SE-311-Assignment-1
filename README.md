# Assignment 1: KWIC System

Daniel Philips - dap372 - Console-based Key Word In Context (KWIC) system in Java.

## Compile

```
javac -d out src/*.java
```

## Run

```
java -cp out Main <inputFile>
```

`<inputFile>` must end in `.txt` or `.csv`, e.g.:

```
java -cp out Main "Test Files/testInput.txt"
```

## Commands
Upon completion of a command, you will be returned to the main menu.
- `kwic`: prints all circular shifts of every line, alphabetized, as
  `Index | Circular Shifted Line | Original Line Index`
- `search <keyword>`: prints original sentences containing `<keyword>` (case-insensitive,
  match wrapped in `[brackets]`) and the total match count; prints `<keyword> not found.`
  if there are none
- `index`: prints every distinct word alphabetically, followed by the line number(s)
  it appears on
- `quit`

Example:

```
> search Tiger
1 sentence is found:
3 Crouching [Tiger] Hidden Dragon
```
