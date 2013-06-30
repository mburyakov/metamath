package dcn.metamath;

import java.util.ArrayList;

class NodeInstance implements Checkable {

  NodeInstance(Concept myConcept, ArrayList<Node> children) {
    this.myConcept = myConcept;
    this.children = children;
  }

  private Node containingNode;

  private Concept myConcept;

  private ArrayList<Node> children;


  ArrayList<Node> getChildren() {
    return children;
  }

  Concept getMyConcept() {
    return myConcept;
  }

  public TreeConsistencyCheckResult checkConsistency() {
    TreeConsistencyCheckResult result = this.getMyConcept().verifyNode(this);
    for (Node child:children) {
      result = TreeConsistencyCheckResult.plus(result, child.checkConsistency());
    }
    return result;
  }

  Node getContainingNode() {
    return containingNode;
  }

  void setContainingNode(Node containingNode) throws ImmutableException {
    if (this.containingNode == null) {
      this.containingNode = containingNode;
    } else {
      throw new ImmutableException();
    }
  }
}
