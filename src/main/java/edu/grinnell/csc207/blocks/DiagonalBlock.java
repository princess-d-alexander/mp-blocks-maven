package edu.grinnell.csc207.blocks;

/**
 * A diagonal ASCII block.
 *
 * This class creates a text block where one character fills the diagonal
 * from the top-left to the bottom-right of the grid, and another character
 * fills the remaining spaces.
 *
 * @author Moise Milnge
 * @author Princess Alexander
 */
public class DiagonalBlock implements AsciiBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The character that fills the diagonal.
   */
  private char diagonalChar;

  /**
   * The character that fills the remaining spaces.
   */
  private char fillChar;

  /**
   * The width of the block.
   */
  private int width;

  /**
   * The height of the block.
   */
  private int height;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a diagonal block with specified characters and dimensions.
   *
   * @param diagonalChar1 the character that fills the diagonal
   * @param fillChar1     the character that fills the remaining spaces
   * @param width1        the width of the block
   * @param height1       the height of the block
   */
  public DiagonalBlock(char diagonalChar1, char fillChar1, int width1, int height1) {
    this.diagonalChar = diagonalChar1; // Field initialization
    this.fillChar = fillChar1;         // Field initialization
    this.width = width1;               // Field initialization
    this.height = height1;             // Field initialization
  } // DiagonalBlock(char, char, int, int)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the diagonal block.
   *
   * @param i the number of the row
   * @return row i.
   * @exception Exception if i is outside the range of valid rows.
   */
  @Override
  public String row(int i) throws Exception {
    if (i < 0 || i >= height) {
      throw new Exception("Row index out of bounds");
    } // if

    StringBuilder row = new StringBuilder();
    for (int j = 0; j < width; j++) {
      if (i == j) {
        row.append(diagonalChar); // Fill diagonal
      } else {
        row.append(fillChar); // Fill other space
      } // else
    } // for
    return row.toString();
  } // row(int)

  /**
   * Determine how many rows are in the block.
   *
   * @return the number of rows
   */
  @Override
  public int height() {
    return height;
  } // height()

  /**
   * Determine how many columns are in the block.
   *
   * @return the number of columns
   */
  @Override
  public int width() {
    return width;
  } // width()

  /**
   * Determine if another block is structurally equivalent to this block.
   *
   * @param other the block to compare to this block
   * @return true if the two blocks are structurally equivalent and false otherwise
   */
  @Override
  public boolean eqv(AsciiBlock other) {
    if (!(other instanceof DiagonalBlock)) {
      return false;
    } // if
    DiagonalBlock o = (DiagonalBlock) other;
    return this.diagonalChar == o.diagonalChar
           &&
           this.fillChar == o.fillChar
           &&
           this.width == o.width
           &&
           this.height == o.height;
  } // eqv(AsciiBlock)
} // class DiagonalBlock
