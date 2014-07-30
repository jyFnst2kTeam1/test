package per.kayu.test;
class Huge
{
    private int[] digits;

    public Huge(int nDigits)
    {
        digits = new int[nDigits];
    }

    private Huge add(Huge n2)
    {
        Huge result = new Huge(digits.length);

        int carry = 0;
        for (int k = 0; k < digits.length; k++)
        {
            int sum = carry + digits[k] + n2.digits[k];
            result.digits[k] = sum % 10;
            carry = sum / 10;
        }
        return result;
    }

    private Huge multiplyDigit(int digit)
    {
        Huge result = new Huge(digits.length);

        int carry = 0;
        for (int k = 0; k < digits.length; k++)
        {
            int prod = carry + digit * digits[k];
            result.digits[k] =  prod % 10;
            carry = prod / 10;
        }
        return result;
    }

    private Huge multiply(int number)
    {
        int weight = 0;
        Huge result = new Huge(digits.length);

        while (number > 0)
        {
            int d = number % 10;
            number /= 10;
            Huge n = multiplyDigit(d);
            n.shift(weight++);
            result = result.add(n);
        }
        return result;
    }

    private void output()
    {
        int k = digits.length - 1;
        while (digits[k--] == 0) ;

        for (k = k + 1 ; k >= 0; k--)
            System.out.printf("%d", digits[k]);
        System.out.println();
    }

    private void shift(int weight)
    {
        for (int k = digits.length - 1; k >= 0; k--)
            digits[k] = (k >= weight)? digits[k - weight] : 0;
    }

    public static void main(String[] args)
    {
        int N = Integer.parseInt(args[0]);

        // calculate num-of-digits required for storing factorial(n)
        int nbits = 0;
        for (int k = 1; k <= N; k++)
            nbits += (int)Math.ceil(Math.log10(k)); 

        Huge result = new Huge(nbits);
        result.digits[0] = 1;
        for (int k = 2; k <= Integer.parseInt(args[0]); k++)
            result = result.multiply(k);
        result.output();
    }
}