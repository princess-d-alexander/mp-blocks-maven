# mp-blocks-maven

Explorations with the creation, composition, and mutation of blocks of ASCII text.

**Authors**

* Samuel A. Rebelsky (starter code).
* Princess Alexander
* Moise Milnge

**Notes for the reader**
This project, mp-blocks-maven, explores creating, manipulating, and composing ASCII art blocks using object-oriented programming concepts in Java. ASCII blocks are represented as collections of text rows that can be composed, flipped, aligned, padded, and trimmed.
Key Features

Block Manipulation:
    Horizontal and Vertical Composition: Combine multiple blocks side-by-side or stacked vertically.
    Flipping: Flip blocks horizontally (HFlip) or vertically (VFlip).
    Padding and Trimming: Adjust block size by adding or removing rows/columns.

Alignment:
    Align blocks horizontally (HAlignment) or vertically (VAlignment) during composition.

Interface Implementation:
    All blocks implement the AsciiBlock interface, which defines core methods:
        row(int i): Retrieve a specific row of the block.
        height(): Get the number of rows.
        width(): Get the number of columns.
        eqv(AsciiBlock other): Check structural equivalence.

**Final Revisions**
Important Note: Final reivisions for this project were made by Princess Alexander, and included a major overhaul of the program including implementing all eqv methods we missed, fixing over 120 checkstyle errors, and modifying the CheckerBoard part of the project that Moise submitted in the first version.

This code may be found at <https://github.com/princess-d-alexander/mp-blocks-maven.git>. The original project can be found at <https://github.com/Grinnell-CSC207/mp-blocks-maven>.
