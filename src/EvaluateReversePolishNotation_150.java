public class EvaluateReversePolishNotation_150 {
    public int evalRPN(String[] tokens) {
        return evalRPNHelper(tokens, tokens.length - 1)[0];
    }

    public int[] evalRPNHelper(String[] tokens, int index) {
        String currentToken = tokens[index];
        if (!(currentToken.equals("+") || currentToken.equals("-") || currentToken.equals("*") || currentToken.equals("/")))
            return new int[]{Integer.parseInt(tokens[index]), 1};

        int[] right = evalRPNHelper(tokens, index - 1);
        int[] left = evalRPNHelper(tokens, index - 1 - right[1]);

        if (currentToken.equals("+"))
            return new int[]{left[0] + right[0], left[1] + right[1] + 1};
        else if (currentToken.equals("-"))
            return new int[]{left[0] - right[0], left[1] + right[1] + 1};
        else if (currentToken.equals("*"))
            return new int[]{left[0] * right[0], left[1] + right[1] + 1};
        else
            return new int[]{left[0] / right[0], left[1] + right[1] + 1};
    }
}
