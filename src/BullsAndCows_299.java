public class BullsAndCows_299 {
    public String getHint(String secret, String guess) {
        char[] secrets = secret.toCharArray();
        char[] guesses = guess.toCharArray();
        int numA = 0, numB = 0;
        for(int i = 0; i < guess.length(); i++){
            if (secrets[i] == guesses[i]) {
                secrets[i] = 'x';
                guesses[i] = 'y';
                numA++;
            }
        }
        for(int i = 0; i < guess.length(); i++){
            for (int j = 0; j < secret.length(); j++) {
                if (secrets[j] == guesses[i]) {
                    secrets[j] = 'x';
                    guesses[i] = 'y';
                    numB++;
                }
            }
        }
        String res = numA + "A" + numB + "B";
        return res;
    }
}
