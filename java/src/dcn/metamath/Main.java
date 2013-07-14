package dcn.metamath;

import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    Concept nullConcept = new Concept(new ArrayList<Concept.ChildType>());
    NodeInstance instance = new NodeInstance(nullConcept, new ArrayList<Node>());
    Node node = new Node(instance);
    System.out.println(node.checkConsistency().isSuccess());
  }
}
