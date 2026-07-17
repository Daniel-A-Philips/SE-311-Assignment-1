# Data Design

## What data structure did you use to store the lines read from the input file?

An `ArrayList<String>`. `FileReader` (abstract) reads the file line by line with a
`BufferedReader` and appends each line, after an optional per-format (using abstraction) transform via the
`processLine()` hook, to a `protected ArrayList<String> lines` field, exposed through
`getLines()`. `TxtReader` uses the line unchanged; `CsvReader` overrides `processLine()`
to replace commas with spaces so CSV rows are parsed in the same way plain sentences. An
`ArrayList` was chosen over a plain array because the number of lines isn't known in
advance and the list only needs sequential access and appends while reading.

## What data structure did you use to store the circularly shifted lines (or their indexes)?

Two structures work together in `CShift`:

- `ArrayList<FormattedLine> formattedLines` - the primary structure. Each circular shift
  is wrapped in a `FormattedLine` object that pairs the shifted text (`data`) with the
  original line number (`originalLine`) it was generated from. This is what is used when sorting and printing, since the KWIC output requires the original line
  index to travel with each shift.
- `ArrayList<String> shiftLines` / `Map<String, ArrayList<String>> shiftLinesGrouped` -
  a flat list of all shifted strings, and a map from each original sentence to its list
  of shifts. These are kept for callers that want the shifts without the extra
  bookkeeping (e.g. quick inspection or testing), but the KWIC command itself uses
  `formattedLines`. This was very useful during testing, and is kept in due to the ease of use for searching, but could be replaced in the future.

## What data structure did you use to store the sorted lines (or their indexes)?

The same `ArrayList<FormattedLine>` produced by `CShift` is sorted **in place** by
`Alphabetizer`, using
`Comparator.comparing(FormattedLine::getData, String.CASE_INSENSITIVE_ORDER)`. No
separate structure is created for the sorted result. Sorting the `ArrayList` in place
avoided allocating a second collection, since nothing else needs the pre-sort order once
`Alphabetizer` has run. After sorting, `getSorted()` walks the list once and calls
`setIndex(i + 1)` on each `FormattedLine` so the display index (1..N) reflects the final
sorted position.