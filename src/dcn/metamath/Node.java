package dcn.metamath;

public class Node {

  //Nullable
  private NodeInstance instance;

  public Node(NodeInstance instance) {
    this.instance = instance;
  }

  public Node() {

  }

  public NodeInstance getInstance() {
    return instance;
  }

  public boolean isPhantom() {
    return instance==null;
  }

  public TreeConsistencyCheckResult checkConsistency() {
    if (this.isPhantom()) {
      //todo: should not pass null
      return TreeConsistencyCheckResult.error(new TreeConsistencyError("phantom node", null));
    } else {
      return this.getInstance().checkConsistency();
    }
  }

}
