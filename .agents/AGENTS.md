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

## Technical Context
- Erick has watched the **3Blue1Brown transformer series** — has solid high-level intuition
- Previously built a simple feedforward neural net with backprop (guided by Gemini)
- Pure Java, no libraries — we build everything from scratch (matrix math, etc.)

## Current Task
- **Step 1**: Build a `Matrix` utility class
- Completed so far:
  1. ✅ Data constructor (`Matrix(double[][] userData)`)
  2. ✅ Random constructor with seed (`Matrix(int row, int col)`)
  3. ✅ Getters: `getRow()`, `getCol()`, `getData(int row, int col)`
  4. ✅ Transpose (`transpose()`)
  5. 🔲 Element-wise addition — **next up**
  6. 🔲 Matrix multiplication
