package dcn.metamath;

class TreeConsistencyError {

  private ErrorType type;

  static enum ErrorType {
    PHANTOM_NODE,
    NULL_LINK,
    INCOMPATIBLE_CONCEPT,
    INCORRECT_CHILDREN_AMOUNT
  }

  private Node node;

  public TreeConsistencyError(ErrorType message, Node node) {
    this.type = message;
    this.node = node;
  }

  public ErrorType getType() {
    return type;
  }

  public Node getNode() {
    return node;
  }
}
