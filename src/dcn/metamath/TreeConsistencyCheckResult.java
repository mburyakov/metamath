package dcn.metamath;

import java.util.ArrayList;

class TreeConsistencyCheckResult {
  private ArrayList<TreeConsistencyError> errors;

  TreeConsistencyCheckResult(ArrayList<TreeConsistencyError> errors) {
    this.errors = errors;
  }

  static TreeConsistencyCheckResult plus(TreeConsistencyCheckResult a, TreeConsistencyCheckResult b) {
    ArrayList<TreeConsistencyError> result = new ArrayList<TreeConsistencyError>();
    result.addAll(a.getErrors());
    result.addAll(b.getErrors());
    return new TreeConsistencyCheckResult(result);
  }

  static TreeConsistencyCheckResult success() {
    return new TreeConsistencyCheckResult(null);
  }

  ArrayList<TreeConsistencyError> getErrors() {
    if (errors==null) {
      errors = new ArrayList<TreeConsistencyError>();
    }
    return errors;
  }

  boolean isSuccess() {
    return errors == null || errors.size() == 0;
  }

}