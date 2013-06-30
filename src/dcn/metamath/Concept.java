package dcn.metamath;

import java.util.ArrayList;
import java.util.Iterator;

class Concept {

  //todo: inheritance

  Concept(ArrayList<ChildType> childrenType) {
    this.childrenType = childrenType;
  }

  static class ChildType {
    Concept type;
    String role;
  }

  private ArrayList<ChildType> childrenType;

  public TreeConsistencyCheckResult verifyNode(NodeInstance node) {
    Iterator<ChildType> typeIterator = childrenType.iterator();
    Iterator<Node> childIterator = node.getChildren().iterator();
    ArrayList<TreeConsistencyError> result = new ArrayList<TreeConsistencyError>();
    while (typeIterator.hasNext() && childIterator.hasNext()) {
      ChildType type = typeIterator.next();
      Node child = childIterator.next();
      if (child == null) {
        result.add(new TreeConsistencyError("Null link", node));
      } else if (child.isPhantom()) {
        result.add(new TreeConsistencyError("phantom node", node));
      } else if (!type.type.equals(child.getInstance().getMyConcept())) {
        result.add(new TreeConsistencyError("Incorrect concept", node));
      }
    }
    if (typeIterator.hasNext() != childIterator.hasNext()) {
      result.add(new TreeConsistencyError("Incorrect children amount", node));
    }
    return new TreeConsistencyCheckResult(result);
  }

}
