public class BulbSwitcher_319 {
    // O(log n)
    // For int k = a*b
    //     if a != b, it will be open.
    //     if a == b, it will be close because switch on only at a
    // Therefore, the bulb remained on will only be the ones of perfect squares
    // Hence, the result if the number of perfect squares <= n
    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }
}
