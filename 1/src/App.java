public class App {
    public static void main(String[] args) throws Exception {
        //float x = convert(5);
        //String result = String.format("%.3f",x);

        

        int x = fitCalc(24,2);
        //int x = containers(3, 4, 2);
        //int x = ternaryEvaluation(8, 4);
        //int x = howManyItems(45, 1.8, 1.9);
        //int x = factorial(5);
        //int x = gcd(48, 18);
        //int x = ticketSaler(70, 1500);
        //int x = tables(5, 1);
        int result = x;

        //String result = triangleType(2,4,5);

        System.out.println(result);
    };
    public static float convert(int x) {
        return x*3.785f;
    };
    public static int fitCalc(int x, int y) {
        return x*y;
    }
    public static int containers(int x, int y, int z) {
        return x*20 + y*50 + z*100;
    }
    public static String triangleType(int x, int y, int z) {
        if ((x+y > z) && (x+z > y) && (y+z > x)) {
            if ((x == y) & (x == z)) {
                return "isosceles";
            }
            else if ((x==y)||(x==z)||(y==z)) {
                return "equilateral";
            }
            else {
                return "different-sided";
            }
        }
        else {
            return "not a triangle";
        }
    }
    public static int ternaryEvaluation(int a, int b) {
        return (a > b) ?  a :  b;
    }
    public static int howManyItems(double n, double w, double h) {
        return (int)Math.floor(n / w / h /2);
    }
    public static int factorial(int a) {
        int i = 1;
        int result = 1;
        do{
            result *= i;
            i++;
        }
        while(i <= a);
        return result;
    }
    public static int gcd(int a, int b) {
        while (a != 0 && b!= 0) {
            if (a>b) {
                a = a % b;
            }
            else {
                b = b % a;
            }
        }
        return (a+b);
    }
    public static int ticketSaler(int a, int b) {
        return (int) (a * b * 0.72);
    }
    public static int tables (int a, int b) {
        int c = a - 2 * b;
        c = (c > 0) ? c : 0;
        return c;
    }
}
