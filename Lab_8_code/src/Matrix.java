public class Matrix{
    public static void main(String[] args) throws Exception {
        int[][] myMatrix = 
        {{1,2,3,4,5,6,7,8,9,10},
        {1,2,3,4,5,6,7,8,9,10},
        {1,2,3,4,5,6,7,8,9,10},
        {1,2,3,4,5,6,7,8,9,10},
        {1,2,3,4,5,6,7,8,9,10}};
        SyncData[] sums = new SyncData[myMatrix.length]; 
        MatrixThread[] threads = new MatrixThread[myMatrix.length];
        for (int i = 0; i < threads.length; i++) {
            sums[i] = new SyncData(0);
            threads[i] = new MatrixThread(myMatrix[i], sums[i]);
            threads[i].run();
        }
        try {
            for (int i = 0; i < threads.length; i++) {
                threads[i].join();
            }
        } 
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        int sum = 0;
        for (int i = 0; i < threads.length; i++) {
            sum += sums[i].getData();
        }
        System.out.println(sum);
    }
}
