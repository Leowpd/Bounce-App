/*
 *  ============================================================================================
 *  enum which defines the type of shapes in A3
 *  YOUR UPI: ldun202
 *  ============================================================================================
 */
enum ShapeType { RECTANGLE(4), SQUARE(4), NESTED(4);
  private int numberOfSides;
  private ShapeType(int numberOfSides) { this.numberOfSides = numberOfSides; }
  public int getNumberOfSides() { return numberOfSides; }
}
