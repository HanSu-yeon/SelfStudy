package thread;

import java.awt.*;

public class BeepPrintEx {
    public static void main(String[] args) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for (int i = 0; i < 5; i++) {
            toolkit.beep(); //비프음 발생
            try {
                Thread.sleep(500); //0.5초간 일시 정지
            } catch (Exception e) {
            }
        }
        for (int i = 0; i < 5; i++) {
            System.out.println("띵");
            try {
                Thread.sleep(500); //0.5초간 일시 정지
            } catch (Exception e) {

            }
        }
    }
}
