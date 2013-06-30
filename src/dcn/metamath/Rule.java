package dcn.metamath;

import java.util.ArrayList;

public class Rule implements Checkable {

  Node left;

  Node right;


  @Override
  public TreeConsistencyCheckResult checkConsistency() {
    TreeConsistencyCheckResult errors = TreeConsistencyCheckResult.plus(left.checkConsistency(), right.checkConsistency());
    ArrayList<TreeConsistencyError> filteredErrors = new ArrayList<TreeConsistencyError>();
    for (TreeConsistencyError error:errors.getErrors()) {
      if (error.getType() != TreeConsistencyError.ErrorType.PHANTOM_NODE) {
        filteredErrors.add(error);
      }
    }
    return new TreeConsistencyCheckResult(filteredErrors);
  }
}
