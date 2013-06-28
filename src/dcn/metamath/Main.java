package dcn.metamath;

import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    Concept nullConcept = new Concept(new ArrayList<Concept.ChildType>());
    Node node = new Node(nullConcept, new ArrayList<Node>());
    System.out.println(node.checkConsistency().isSuccess());
  }
}
