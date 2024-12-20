package edu.grinnell.csc207.blocks;

/**
 * A padded ASCII block.
 *
 * This class adds padding around an existing block to achieve a specific width and height.
 *
 * @author Samuel A. Rebelsky
 * @author Princess Alexander
 */
public class Padded implements AsciiBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The original block.
   */
  AsciiBlock block;

  /**
   * The character used for padding.
   */
  String pad;

  /**
   * How is the original block horizontally aligned within the padding?
   */
  HAlignment halign;

  /**
   * How is the original block vertically aligned within the padding?
   */
  VAlignment valign;

  /**
   * How wide is the padded block?
   */
  int width;

  /**
   * How tall is the padded block.
   */
  int height;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new block with the specified contents.
   *
   * @param original
   *   The original block.
   * @param ch
   *   The character we use for padding.
   * @param horiz
   *   How the original block is horizontally aligned within the padding.
   * @param vert
   *   How the original block is vertically aligned within the padding.
   * @param paddedWidth
   *   The width of the padded block.
   * @param paddedHeight
   *   The height of the padded block.
   */
  public Padded(AsciiBlock original, char ch, HAlignment horiz,
      VAlignment vert, int paddedWidth, int paddedHeight) {
    this.block = original;
    this.pad = new String(new char[] {ch});
    this.halign = horiz;
    this.valign = vert;
    this.width = paddedWidth;
    this.height = paddedHeight;
  } // Padded(AsciiBlock, char, HAlignment, VAlignment, int, int)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the block.
   *
   * @param i the number of the row
   *
   * @return row i.
   *
   * @exception Exception
   *   If the row is invalid.
   */
  @Override
  public String row(int i) throws Exception {
    if (i < 0 || i >= this.height) {
      throw new Exception("Row index out of bounds");
    } // if

    // Calculate vertical padding
    int topPadding = switch (this.valign) {
      case TOP -> 0;
      case CENTER -> (this.height - this.block.height()) / 2;
      case BOTTOM -> this.height - this.block.height();
    };

    if (i < topPadding || i >= topPadding + this.block.height()) {
      // This row is part of the vertical padding
      return this.pad.repeat(this.width);
    } // if

    // Calculate horizontal padding
    int leftPadding = switch (this.halign) {
      case LEFT -> 0;
      case CENTER -> (this.width - this.block.width()) / 2;
      case RIGHT -> this.width - this.block.width();
    };

    String contentRow = this.block.row(i - topPadding);
    return this.pad.repeat(leftPadding) + contentRow + this.pad.repeat(this.width - leftPadding - contentRow.length());
  } // row(int)

  /**
   * Determine how many rows are in the block.
   *
   * @return the number of rows
   */
  @Override
  public int height() {
    return this.height;
  } // height()

  /**
   * Determine how many columns are in the block.
   *
   * @return the number of columns
   */
  @Override
  public int width() {
    return this.width;
  } // width()

  /**
   * Determine if another block is structurally equivalent to this block.
   *
   * @param other
   *   The block to compare to this block.
   *
   * @return true if the two blocks are structurally equivalent and
   *    false otherwise.
   */
  @Override
  public boolean eqv(AsciiBlock other) {
    if (!(other instanceof Padded)) {
      return false;
    } // if
    Padded o = (Padded) other;
    return this.pad.equals(o.pad)
           &&
           this.halign == o.halign
           &&
           this.valign == o.valign
           &&
           this.width == o.width
           &&
           this.height == o.height
           &&
           this.block.eqv(o.block);
  } // eqv(AsciiBlock)
} // class Padded
