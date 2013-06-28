package dcn.metamath;

import java.util.ArrayList;

class Node {

  Node(Concept myConcept, ArrayList<Node> children) {
    this.myConcept = myConcept;
    this.children = children;
  }

  private Concept myConcept;

  private ArrayList<Node> children;


  ArrayList<Node> getChildren() {
    return children;
  }

  Concept getMyConcept() {
    return myConcept;
  }

  TreeConsistencyCheckResult checkConsistency() {
    TreeConsistencyCheckResult result = this.getMyConcept().verifyNode(this);
    for (Node child:children) {
      result = TreeConsistencyCheckResult.plus(result, child.checkConsistency());
    }
    return result;
  }

}
