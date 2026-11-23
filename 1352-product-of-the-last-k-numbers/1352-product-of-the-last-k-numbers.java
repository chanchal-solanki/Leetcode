// class ProductOfNumbers {
//     ArrayList<Integer> product ;
//     ArrayList<Integer> zeroCount;
//     public ProductOfNumbers() {
//         product = new ArrayList<>();
//         zeroCount = new ArrayList<>();
//     }
    
//     public void add(int num) {
//         int n = product.size();
        
//         if( n == 0) product.add(num);
//         else product.add(num*product.get(n-1));
//         if(num == 0) {
//             product.set(product.size()-1 , 1);
//             zeroCount.add(1);
           
//         }else {
//             int s = zeroCount.size();
//             int x = (s != 0) ? zeroCount.get(s-1) : 0;
//             zeroCount.add(x);
//         }
//     }
    
//     public int getProduct(int k) {
//         int l = product.size()-k;
//         int r = product.size()-1;
//         if(r < 0) return product.get(0);
//         return (zeroCount.get(l-1)-zeroCount.get(r)>=0) ? product.get(r)/product.get(l-1) : 0;
//     }
// }


class ProductOfNumbers {
    ArrayList<Integer> product;
    ArrayList<Integer> zeroCount;

    public ProductOfNumbers() {
        product = new ArrayList<>();
        zeroCount = new ArrayList<>();
    }

    public void add(int num) {
        int n = product.size();

        int prev = (n == 0) ? 1 : product.get(n - 1);
        int zeros = (n == 0) ? 0 : zeroCount.get(n - 1);

        if (num == 0) {
            product.add(1);
            zeroCount.add(zeros + 1);
        } else {
            product.add(prev * num);
            zeroCount.add(zeros);
        }
    }

    public int getProduct(int k) {
        int r = product.size() - 1;
        int l = r - k + 1;

        int zerosBefore = (l == 0) ? 0 : zeroCount.get(l - 1);
        int zerosInRange = zeroCount.get(r) - zerosBefore;

        if (zerosInRange > 0) return 0;

        int prev = (l == 0) ? 1 : product.get(l - 1);

        return product.get(r) / prev;
    }
}


/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */