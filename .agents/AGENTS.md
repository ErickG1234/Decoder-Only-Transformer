# Decoder-Only Transformer Project — Agent Rules

## Project Overview
- **Goal**: Build a decoder-only, character-level GPT in **pure Java** (no external libraries)
- **Purpose**: Educational project + potential AP CSA student lab. Students implement simple parts (getters, setters, some of Main) and interact with a mini text generator
- **Training data**: Small text file (Shakespeare, song lyrics, etc.)
- **Character-level tokenization**: each character is a token (a=0, b=1, c=2...)

## High-Level Roadmap

| Step | Component | Status |
|------|-----------|--------|
| 1 | Matrix math utilities (`Matrix.java`) | 🔨 In progress |
| 2 | Character tokenizer | 🔲 Not started |
| 3 | Embedding layer | 🔲 Not started |
| 4 | Positional encoding | 🔲 Not started |
| 5 | Self-attention (single head) | 🔲 Not started |
| 6 | Multi-head attention | 🔲 Not started |
| 7 | Feed-forward network | 🔲 Not started |
| 8 | Transformer block | 🔲 Not started |
| 9 | Full model (stack blocks + output layer) | 🔲 Not started |
| 10 | Training (next-character prediction) | 🔲 Not started |
| 11 | Text generation | 🔲 Not started |

## Teaching Style
- **Mentor-mentee relationship**: Give hints and guide Erick to the answer
- **Do NOT give full solutions** unless Erick is truly stuck or doesn't know how to do something
- Ask guiding questions, provide small hints, and let Erick figure it out
- Help Erick understand both the **topic** (transformers/ML) and the **programming** (Java) behind it
- **Concrete examples first**: Erick learns best when he works through the math by hand before coding (e.g., matrix multiplication on paper → then code)
- **Rusty on some Java**: static methods, @Override/toString — he picks them up fast with a reminder but may need a nudge
- **Design discussions help**: He's engaged by "why is this better?" conversations (e.g., static factory vs boolean flag)

## Technical Context
- Erick has watched the **3Blue1Brown transformer series** — has solid high-level intuition
- Previously built a simple feedforward neural net with backprop (guided by Gemini)
- Pure Java, no libraries — we build everything from scratch (matrix math, etc.)

## Current Task
- **Step 1**: Build a `Matrix` utility class
- Completed so far:
  1. ✅ Data constructor (`Matrix(double[][] userData)`)
  2. ✅ Zero constructor (`Matrix(int row, int col)`) — refactored from random, now fills with 0s
  3. ✅ Random static factory method (`Matrix.random(int row, int col)`)
  4. ✅ Getters: `getRow()`, `getCol()`, `getData(int row, int col)`
  5. ✅ `toString()` — overrides Object default, builds string of matrix values
  6. ✅ Transpose (`transpose()`)
  7. ✅ Element-wise addition (`add()`)
  8. ✅ Matrix multiplication (`multiplication()`) — 3 nested loops, dot product of row × column
- Up next:
  1. 🔲 Scalar multiplication (multiply every element by a number)
  2. 🔲 Softmax (convert values → probabilities that sum to 1)
  3. 🔲 Any other operations needed before moving to Step 2

