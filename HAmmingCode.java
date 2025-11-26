public class hammingcode1 {
    public static void main(String[] args){
        int [] hamm = {1,0,1,1,  0,1,0,0,  1,0,1,0,   1,1,0,1};
        int s;
        int blockSize;
        int blockStart;
        for(int n=0;n<5;n++){
            blockSize=(int) (Math.pow(2, n));
            blockStart=(int)Math.pow(2, n);
            for(int i=blockStart;i<hamm.length;i+=blockSize*2){
            s=0;
            for(int k=0;k<blockSize;k++){
                if((i+k)<hamm.length){
                    s+=hamm[i+k];
                }
            }System.out.println("for hamming bit-  " + (n+1) + " the sum is " +  s );
            }
        }
        }
    }
