# Java Data Structures & Algorithms

A collection of fundamental data structures and algorithms implemented from scratch in Java. This project explores the principles behind common computer science data structures, focusing on clean object-oriented design, generic implementations, algorithmic efficiency, and comprehensive testing.

## Overview

The goal of this project is to develop a deeper understanding of how data structures work internally rather than relying exclusively on Java's built-in implementations.

Each implementation is designed to be independent, reusable, and thoroughly tested using JUnit 5.

## Data Structures

The project is organized into several categories:

### Linear Data Structures

| Data Structure | Description | Status |
|---|---|---|
| Dynamic Array | Resizable array with automatic capacity management | 🚧 Planned |
| Linked List | Node-based sequential collection | 🚧 Planned |
| Stack | Last-In, First-Out (LIFO) collection | 🚧 Planned |
| Queue | First-In, First-Out (FIFO) collection | 🚧 Planned |

### Non-Linear Data Structures

| Data Structure | Description | Status |
|---|---|---|
| Binary Search Tree | Ordered binary tree supporting efficient search and insertion | 🚧 Planned |
| AVL Tree | Self-balancing binary search tree | 🚧 Planned |
| Hash Table | Key-value storage using hash-based indexing | 🚧 Planned |
| Graph | Representation of vertices and edges | 🚧 Planned |

### Algorithms

| Category | Algorithms |
|---|---|
| Sorting | Merge Sort, Quick Sort, Heap Sort |
| Searching | Linear Search, Binary Search |
| Graph Traversal | Breadth-First Search (BFS), Depth-First Search (DFS) |
| Graph Algorithms | Dijkstra's Shortest Path |
| Tree Traversal | Inorder, Preorder, Postorder, Level Order |

*Implementation status will be updated as the project progresses.*

## Project Structure

```text
java-data-structures/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── dev/bosse/datastructures/
│   │           ├── list/
│   │           ├── stack/
│   │           ├── queue/
│   │           ├── tree/
│   │           ├── hash/
│   │           └── graph/
│   │
│   └── test/
│       └── java/
│           └── dev/bosse/datastructures/
│               ├── list/
│               ├── stack/
│               ├── queue/
│               ├── tree/
│               ├── hash/
│               └── graph/
│
├── pom.xml
└── README.md
```

Each package contains the corresponding implementations and their unit tests.

## Technologies

- **Java 21** — Primary programming language.
- **Apache Maven** — Dependency management and build automation.
- **JUnit 5** — Unit testing framework.
- **Git** — Version control.

## Getting Started

### Prerequisites

- JDK 21 or later
- Git

Maven can be installed separately or invoked through the included Maven Wrapper.

### Clone the repository

```bash
git clone https://github.com/YOUR_USERNAME/java-data-structures.git

cd java-data-structures
```

### Build the project

```bash
./mvnw clean package
```

Alternatively, if Maven is installed globally:

```bash
mvn clean package
```

### Run tests

```bash
./mvnw test
```

## Design Principles

The implementations follow a few consistent principles:

- **Generic programming:** Use Java generics to support reusable, type-safe data structures.
- **Encapsulation:** Keep internal implementation details separate from public interfaces.
- **Separation of concerns:** Organize implementations, interfaces, and tests into logical packages.
- **Testability:** Cover expected behavior, edge cases, and exceptional conditions with automated tests.
- **Efficiency:** Consider time and space complexity when designing operations.
- **Documentation:** Document public APIs and relevant implementation decisions.

## Algorithmic Complexity

An important part of this project is understanding the computational cost of individual operations.

Each completed data structure will include a complexity overview using Big O notation.

For example, a dynamic array:

| Operation | Average / Amortized | Worst Case |
|---|---:|---:|
| Access by index | O(1) | O(1) |
| Append | O(1) | O(n) |
| Insert at index | O(n) | O(n) |
| Remove at index | O(n) | O(n) |
| Search | O(n) | O(n) |

Complexity tables will be added and refined as implementations are completed.

## Project Goals

Beyond implementing the data structures themselves, this project aims to:

- Strengthen understanding of fundamental computer science concepts.
- Improve proficiency in Java and object-oriented programming.
- Explore algorithmic complexity and performance trade-offs.
- Develop consistent testing and documentation practices.
- Build a collection of reusable implementations that can serve as a reference for future projects.

---

**Author:** [Bosse Schumacher](https://github.com/YOUR_USERNAME)

**License:** MIT (to be added)