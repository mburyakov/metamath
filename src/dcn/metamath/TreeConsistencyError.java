package dcn.metamath;

class TreeConsistencyError {

  private String message;


  //todo: different concept for every error type

  private NodeInstance node;

  public TreeConsistencyError(String message, NodeInstance node) {
    this.message = message;
    this.node = node;
  }

  public String getMessage() {
    return message;
  }

  public NodeInstance getNode() {
    return node;
  }
}
