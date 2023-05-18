package BakJoon;

public class Back2003 {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3 ,4, 2 ,5 ,3 ,1, 1 ,2};

        System.out.println(method(5, arr));

    }

    public static int method(int gap, int[] arr) {

        int result = 0; // 경우의 수
        int sum = 0; // 포인트 사이의 값의 합
        int low = 0;
        int high = 0;

        while (true) {

            // high 증가
            if (sum >= gap) {   // 합친게 주어진 크기보다 크면 큰 포인터 하나 증가하고 합계에서 하나 빼야하갰지?
                sum -= arr[low++];
            }
            // break;
            else if (high == arr.length) {
                break;
            } else {
                sum += arr[high++];
            }
            System.out.println("high: " + high + " low: " + low + " sum : " + sum + " result : " + result);
            if (sum==gap) result++;
            // low 증가
        }

        return result;
    }

}

