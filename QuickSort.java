 class QuickSort {
	 private int comparisonNum = 0; // # of comparison
	 private int exchangeNum = 0; // # of exchange
	 public int getComparisonNum() {
	 return comparisonNum;
	 }
	 public int getExchangeNum() {
		 return exchangeNum;
	 }
	 public int[] sort(int[] d, int left, int right) {
		 if (left>=right) {
	            return d;
	        }
	        int p = d[(left+right)/2];
	        int l = left, r = right, tmp;
	        while(l<=r) {
	            while(d[l] < p) { 
	            	l++; 
	            	}
	            while(d[r] > p) { 
	            	r--; 
	            	}
	            if (l<=r) {
	                tmp = d[l]; 
	                d[l] = d[r]; 
	                d[r] = tmp;
	                l++; 
	                r--;
	                exchangeNum++;
	            }
	            comparisonNum++;
	        }
	        sort(d, left, r);
	        sort(d, l, right);
		 
		 return d;
	 }
}