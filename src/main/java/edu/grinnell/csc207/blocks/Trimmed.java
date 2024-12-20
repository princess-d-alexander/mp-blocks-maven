package edu.grinnell.csc207.blocks;

/**
 * A trimmed ASCII block.
 *
 * @author Samuel A. Rebelsky
 * @author Princess Alexander
 */
public class Trimmed implements AsciiBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The original block.
   */
  AsciiBlock block;

  /**
   * Which part of the block do we keep horizontally?
   */
  HAlignment halign;

  /**
   * Which part of the block do we keep vertically?
   */
  VAlignment valign;

  /**
   * How much of the block do we keep horizontally?
   */
  int width;

  /**
   * How much of the block do we keep vertically?
   */
  int height;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new block with the specified contents.
   *
   * @param original The original block.
   * @param horiz    How the trimmed block is horizontally aligned on the original.
   * @param vert     How the trimmed block is vertically aligned on the original.
   * @param trimmedWidth The width of the trimmed block.
   * @param trimmedHeight The height of the trimmed block.
   */
  public Trimmed(AsciiBlock original, HAlignment horiz, VAlignment vert,
      int trimmedWidth, int trimmedHeight) {
    this.block = original;
    this.halign = horiz;
    this.valign = vert;
    this.width = trimmedWidth;
    this.height = trimmedHeight;
  } // Trimmed(AsciiBlock, HAlignment, VAlignment, int, int)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the block.
   *
   * @param i The number of the row.
   * @return The row i.
   * @exception Exception If the row is invalid.
   */
  public String row(int i) throws Exception {
    if (i < 0 || i >= this.height) {
      throw new Exception("Invalid row " + i);
    } // if

    // Calculate the starting row in the original block
    int startRow = 0;
    switch (this.valign) {
      case TOP:
        startRow = 0;
        break;
      case CENTER:
        startRow = (this.block.height() - this.height) / 2;
        break;
      case BOTTOM:
        startRow = this.block.height() - this.height;
        break;
      default:
        throw new Exception("Invalid vertical alignment");
    } // switch

    int actualRow = startRow + i;
    String originalRow = this.block.row(actualRow);

    // Calculate the starting column in the original row
    int startCol = 0;
    switch (this.halign) {
      case LEFT:
        startCol = 0;
        break;
      case CENTER:
        startCol = (this.block.width() - this.width) / 2;
        break;
      case RIGHT:
        startCol = this.block.width() - this.width;
        break;
      default:
        throw new Exception("Invalid horizontal alignment");
    } // switch

    return originalRow.substring(startCol, startCol + this.width);
  } // row(int)

  /**
   * Determine how many rows are in the block.
   *
   * @return The number of rows.
   */
  public int height() {
    return this.height;
  } // height()

  /**
   * Determine how many columns are in the block.
   *
   * @return The number of columns.
   */
  public int width() {
    return this.width;
  } // width()

  /**
   * Determine if another block is structurally equivalent to this block.
   *
   * @param other The block to compare to this block.
   * @return true if the two blocks are structurally equivalent, false otherwise.
   */
  public boolean eqv(AsciiBlock other) {
    if (!(other instanceof Trimmed)) {
      return false;
    } // if
    Trimmed otherTrimmed = (Trimmed) other;
    return this.halign == otherTrimmed.halign
        && this.valign == otherTrimmed.valign
        && this.width == otherTrimmed.width
        && this.height == otherTrimmed.height
        && this.block.eqv(otherTrimmed.block);
  } // eqv(AsciiBlock)
} // class Trimmed
