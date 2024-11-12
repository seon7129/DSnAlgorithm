import java.util.StringTokenizer;

public class KPrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static int result = 0;
	
	public int solution(int n, int k) {
		
		String convertN = convertToBaseK(n,k);
        StringTokenizer st = new StringTokenizer(convertN, "0");

        while (st.hasMoreTokens()) {
        	if (isPrime(Long.parseLong(convertN)))
        		result++;
        }
		return result;
    }
	
	public static String convertToBaseK(int n, int k) {
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            result.insert(0, n % k); // 나머지를 앞에 추가
            n /= k;                  // n을 k로 나누기
        }
        return result.toString();
    }
	
	
	public static boolean isPrime(long n) {
        if (n <= 1) return false; // 1 이하의 숫자는 소수가 아님
        if (n == 2) return true;  // 2는 소수
        if (n % 2 == 0) return false; // 2를 제외한 짝수는 소수가 아님

        long sqrt = (long) Math.sqrt(n); // n의 제곱근
        for (long i = 3; i <= sqrt; i += 2) { // 홀수만 검사
            if (n % i == 0) {
                return false; // 나누어떨어지면 소수가 아님
            }
        }
        return true; // 소수임
    }
}
