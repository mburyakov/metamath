package dcn.metamath;

class TreeConsistencyError {

  private String message;
  private Node node;

  public TreeConsistencyError(String message, Node node) {
    this.message = message;
    this.node = node;
  }

  public String getMessage() {
    return message;
  }

  public Node getNode() {
    return node;
  }
}
