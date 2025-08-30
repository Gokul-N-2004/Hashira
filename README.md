# Hashira Project

This project demonstrates **manual base conversion** and **JSON-based polynomial root validation** without using any external libraries like Maven or Gson.

## 📌 Features
- Reads input from two JSON files:
  - `data.json`
  - `data1.json`
- Each JSON file contains:
  - `n`: Number of roots provided
  - `k`: Minimum roots required (`k = m + 1`, where `m` is polynomial degree)
  - Roots in different bases
- Converts numbers from **any given base** (2–16) into decimal **using manual logic** (no built-in Java parsing).
- User provides the **base** as input, and the program checks both JSON files to find matching roots.
- Handles conflicts (same base appearing in both files → considers one as true, the other as false).

## 🛠 Usage
1. Clone this repo:
   ```bash
   git clone https://github.com/Gokul-N-2004/Hashira.git
   cd Hashira
