import java.util.*;

public class helloworld {
    public static int gcd(int m, int n) {
        return n == 0 ? m : gcd(n, m % n);
    }

    public static ArrayList<Integer> getAllPrime(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 2, temp = n; temp != 1 && i <= n / 2; ++i) {
            while (temp % i == 0) {
                res.add(i);
                temp /= i;
            }
        }
        if (res.isEmpty()) res.add(n);
        return res;
    }

    public static void mergeSort(ArrayList<Integer> nums, int left, int right, ArrayList<Integer> temp) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid + 1, right, temp);

        int i = left, lpos = left, rpos = mid + 1;
        while (lpos <= mid && rpos <= right) {
            temp.set(i++, nums.get(lpos) <= nums.get(rpos)? nums.get(lpos++): nums.get(rpos++));
        }
        while (i <= right) {
            temp.set(i++, lpos <= mid? nums.get(lpos++): nums.get(rpos++));
        }

        for (i = left; i <= right; ++i) {
            nums.set(i, temp.get(i));
        }
    }

    public static String getMultiTable() {
        String res = "";
        for (int i = 1; i <= 9; ++i) {
            for (int j = 1; j <= 9; ++j) {
                res += String.format("%d", i) + "*" + String.format("%d", j) + " = " + String.format("%d", i * j);
                if (j != 9) res += ", ";
                else res += "\n";
            }
        }
        return res;
    }

    public static void quickSort(ArrayList<Integer> nums, int left, int right) {
        if (left >= right) return;
        swap(nums, left, (left + right) >> 1);
        int pivot = nums.get(left), l = left, r = right;
        while (l < r) {
            while (l < r && nums.get(r) >= pivot) --r;
            if (l < r) nums.set(l, nums.get(r));
            while (l < r && nums.get(l) < pivot) ++l;
            if (l < r) nums.set(r, nums.get(l));
        }
        nums.set(l, pivot);
        quickSort(nums, left, l - 1);
        quickSort(nums, l + 1, right);
    }

    private static void swap(ArrayList<Integer> nums, int a, int b) {
        int temp = nums.get(a);
        nums.set(a, nums.get(b));
        nums.set(b, temp);
    }

    public static void main(String[] args) {
        // System.out.printf("GCD of (10, 4) = %d", gcd(10, 4));
        // System.out.printf("LCM of (10, 4) = %d", lcm(10, 4));
        Scanner sc = new Scanner(System.in);
        Integer num = sc.nextInt();
        while (num != -1) {
            ArrayList<Integer> primeOfN = getAllPrime(num);
            String res = String.format("%d = ", num);
            for (int i = 0; i < primeOfN.size(); ++i) {
                if (i != primeOfN.size() - 1) {
                    res += String.format("%d", primeOfN.get(i)) + " * ";
                }
                else {
                    res += String.format("%d", primeOfN.get(i));
                }
            }
            System.out.println(res);
            num = sc.nextInt();
        }
//        ArrayList<Integer> nums = new ArrayList<>();
//        nums.add(-11);
//        nums.add(121);
//        nums.add(-1);
//        nums.add(1781);
//        nums.add(90);
//        nums.add(0);
//        nums.add(-1);
//        nums.add(511);
//        ArrayList<Integer> temp = new ArrayList<>(nums);
//        quickSort(nums, 0, nums.size() - 1);
//        for (int num: nums) {
//            System.out.print(num + " ");
//        }
//        String res = getMultiTable();
//        System.out.println(res);
    }
}
