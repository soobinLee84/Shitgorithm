package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ20546 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 현금
        int junCash = Integer.parseInt(br.readLine());
        int sungCash = junCash;

        // 주식
        int junStock = 0;
        int sungStock = 0;

        // 일별 주식
        String[] spl = br.readLine().split(" ");
        int[] stock = new int[spl.length + 1];
        for (int i = 0; i < spl.length; i++) {
            stock[i + 1] = Integer.parseInt(spl[i]);
        }
        stock[0] = stock[1];

        int seq = 0; // sung 연속확인
        for (int i = 1; i < stock.length; i++) {

            // jun 계산
            if (stock[i] <= junCash) {
                junStock += (junCash / stock[i]);
                junCash %= stock[i];
            }

            // sung 계산
            if (stock[i-1] < stock[i]) {
                if (seq < 0) seq = 0;
                seq++;
                
            } else if (stock[i-1] > stock[i]) {
                if (seq > 0) seq = 0;
                seq--;
            }
            
            // 3연 증가 주식 팔기
            if (seq >= 3 && sungStock > 0) {
                sungCash += sungStock * stock[i];
                sungStock = 0;
                
            } else if (seq <= -3) { // 3연 감소 주식 사기
                sungStock += (sungCash / stock[i]);
                sungCash %= stock[i];
                
            }
        }
        
        // 결과 계산
        int junResult = junCash + (junStock * stock[stock.length - 1]);
        int sungResult = sungCash + (sungStock * stock[stock.length - 1]);
                
        if (junResult == sungResult) {
            System.out.println("SAMESAME");
        } else if (junResult > sungResult) {
            System.out.println("BNP");
        } else {
            System.out.println("TIMING");
        }
    }
}
