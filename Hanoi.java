class Hanoi {
     public static void main (String[] args) {
    	 int disknum=5;
    	 System.out.println("Number of Plates is "+ disknum + ".");
         doTowers(disknum,'a', 'b', 'c');
     }
     static void doTowers (int n,char x, char y, char z) {
         if (n > 0) {
             doTowers(n-1,x, z, y);
            System.out.println("Move disk "+ n + " from " + x + " to " + z + ".");
             doTowers(n-1,y, x, z);
     	}
     }
 }