package dcn.metamath;

import java.util.ArrayList;
import java.util.Iterator;

class Concept {

  Concept(ArrayList<ChildType> childrenType) {
    this.childrenType = childrenType;
  }

  static class ChildType {
    Concept type;
    String role;
  }

  private ArrayList<ChildType> childrenType;

  public TreeConsistencyCheckResult verifyNode(Node node) {
    Iterator<ChildType> typeIterator = childrenType.iterator();
    Iterator<Node> childIterator = node.getChildren().iterator();
    ArrayList<TreeConsistencyError> result = new ArrayList<TreeConsistencyError>();
    while (typeIterator.hasNext() && childIterator.hasNext()) {
      ChildType type = typeIterator.next();
      Node child = childIterator.next();
      if (child==null) {
        result.add(new TreeConsistencyError("Null link", child));
      } else if (!type.type.equals(child.getMyConcept())) {
        result.add(new TreeConsistencyError("Incorrect concept", child));
      }
    }
    if (typeIterator.hasNext() != childIterator.hasNext()) {
      result.add(new TreeConsistencyError("Incorrect children amount", node));
    }
    return new TreeConsistencyCheckResult(result);
  }

}
