package edu.grinnell.csc207.blocks;

/**
 * A checkerboard ASCII block.
 *
 * This class generates a checkerboard pattern using two specified characters.
 * It can be used to represent a grid with alternating characters.
 *
 * @author Samuel A. Rebelsky
 * @author Moise Milnge
 * @author Princess Alexander
 */
public final class CheckerBoard implements AsciiBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /** First character for the checkerboard. */
  private final char char1;

  /** Second character for the checkerboard. */
  private final char char2;

  /** Width of the checkerboard. */
  private final int width;

  /** Height of the checkerboard. */
  private final int height;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Constructor for creating a checkerboard block.
   *
   * @param c1 The first character.
   * @param c2 The second character.
   * @param w The width of the checkerboard.
   * @param h The height of the checkerboard.
   */
  public CheckerBoard(char c1, char c2, int w, int h) {
    this.char1 = c1;
    this.char2 = c2;
    this.width = w;
    this.height = h;
  } // CheckerBoard

  // +--------------------+------------------------------------------
  // | AsciiBlock methods |
  // +--------------------+

  /**
   * Get a row from the checkerboard.
   *
   * @param i The index of the row.
   * @return The string representing row i of the checkerboard.
   * @throws Exception If the row index is invalid.
   */
  @Override
  public String row(int i) throws Exception {
    if (i < 0 || i >= height) {
      throw new Exception("Invalid row index: " + i);
    } // if
    StringBuilder row = new StringBuilder();
    for (int j = 0; j < width; j++) {
      if ((i + j) % 2 == 0) {
        row.append(char1);
      } else {
        row.append(char2);
      } // else
    } // for
    return row.toString();
  } // row(int)

  /**
   * Determine the height of the checkerboard.
   *
   * @return The height of the checkerboard.
   */
  @Override
  public int height() {
    return this.height;
  } // height()

  /**
   * Determine the width of the checkerboard.
   *
   * @return The width of the checkerboard.
   */
  @Override
  public int width() {
    return this.width;
  } // width()

  /**
   * Check structural equivalence between this block and another block.
   *
   * @param other The block to compare.
   * @return true if the blocks are structurally equivalent; false otherwise.
   */
  @Override
  public boolean eqv(AsciiBlock other) {
    if (!(other instanceof CheckerBoard)) {
      return false;
    } // if
    CheckerBoard o = (CheckerBoard) other;
    return this.char1 == o.char1 && this.char2 == o.char2
        && this.width == o.width && this.height == o.height;
  } // eqv(AsciiBlock)
} // class CheckerBoard
