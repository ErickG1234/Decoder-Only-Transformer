# Decoder-Only Transformer Project — Agent Rules

## Project Overview
- **Goal**: Build a decoder-only, character-level GPT in **pure Java** (no external libraries)
- **Purpose**: Educational project + potential AP CSA student lab. Students implement simple parts (getters, setters, some of Main) and interact with a mini text generator
- **Training data**: Small text file (Shakespeare, song lyrics, etc.)
- **Character-level tokenization**: each character is a token (a=0, b=1, c=2...)

## High-Level Roadmap

| Step | Component | Status |
|------|-----------|--------|
| 1 | Matrix math utilities (`Matrix.java`) | ✅ Core done |
| 2 | Character tokenizer | 🔨 Up next |
| 3 | Embedding layer | 🔲 Not started |
| 4 | Positional encoding | 🔲 Not started |
| 5 | Self-attention (single head) | 🔲 Not started |
| 6 | Multi-head attention | 🔲 Not started |
| 7 | Feed-forward network | 🔲 Not started |
| 8 | Transformer block | 🔲 Not started |
| 9 | Full model (stack blocks + output layer) | 🔲 Not started |
| 10 | Training (next-character prediction) | 🔲 Not started |
| 11 | Text generation | 🔲 Not started |

## Deferred Matrix Operations (add when needed)
- 🔲 **Causal masking** — set "future" positions to -∞ before softmax so tokens can't see ahead (needed for Step 5: self-attention)
- 🔲 **Activation function (ReLU)** — max(0, x) for the feed-forward layer (needed for Step 7: feed-forward network)
- Any other ops we discover we need — add them as we go, then polish at the end

## Teaching Style
- **Mentor-mentee relationship**: Give hints and guide Erick to the answer
- **Do NOT give full solutions** unless Erick is truly stuck or doesn't know how to do something
- Ask guiding questions, provide small hints, and let Erick figure it out
- Help Erick understand both the **topic** (transformers/ML) and the **programming** (Java) behind it
- **Concrete examples first**: Erick learns best when he works through the math by hand before coding (e.g., matrix multiplication on paper → then code)
- **Rusty on some Java**: static methods, @Override/toString — he picks them up fast with a reminder but may need a nudge
- **Design discussions help**: He's engaged by "why is this better?" conversations (e.g., static factory vs boolean flag)
- **Likes chronological flow**: Prefers to encounter problems naturally as they build, then go back and add what's needed

## Technical Context
- Erick has watched the **3Blue1Brown transformer series** — has solid high-level intuition
- Previously built a simple feedforward neural net with backprop (guided by Gemini)
- Pure Java, no libraries — we build everything from scratch (matrix math, etc.)

## Matrix.java — Completed Operations
1. ✅ Data constructor (`Matrix(double[][] userData)`)
2. ✅ Zero constructor (`Matrix(int row, int col)`)
3. ✅ Random static factory method (`Matrix.random(int row, int col)`)
4. ✅ Getters: `getRow()`, `getCol()`, `getData(int row, int col)`
5. ✅ `toString()` override
6. ✅ Transpose (`transpose()`)
7. ✅ Element-wise addition (`add()`)
8. ✅ Matrix multiplication (`multiply()`) — dot product of row × column
9. ✅ Scalar multiplication (`scalarMultiply()`) — mutates in place, returns `this`
10. ✅ Softmax (`softmax()`) — row-wise, two-pass approach, mutates in place, returns `this`

## Current Task
- **Step 2**: Build a character tokenizer (`Tokenizer.java`)
- Completed so far:
  1. ✅ Basic class structure (fields, constructor taking text, getter stubs).
  2. ✅ Fixed variable shadowing for fields (`charToNum`, `numToChar`).
  3. ✅ Populating `charToNum` (encoding map) with sequential indices using `charCounter` to avoid gaps.
- Up next:
  1. 🔲 Populate `numToChar` (decoding array) with *only* unique characters. Hint: Use the size of the HashMap to determine the array size!
  2. 🔲 Set the `vocabSize` field.
  3. 🔲 Implement `encode()`: text → `int[]`
  4. 🔲 Implement `decode()`: `int[]` → text

