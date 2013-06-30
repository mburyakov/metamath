package dcn.metamath;

public class Node implements Checkable {

  //Nullable
  private NodeInstance instance;

  public Node(NodeInstance instance) {
    this.instance = instance;
    try {
      this.instance.setContainingNode(this);
    } catch (ImmutableException e) {
      throw new IllegalArgumentException();
    }
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
      return TreeConsistencyCheckResult.error(new TreeConsistencyError(TreeConsistencyError.ErrorType.PHANTOM_NODE, this));
    } else {
      return this.getInstance().checkConsistency();
    }
  }

}
