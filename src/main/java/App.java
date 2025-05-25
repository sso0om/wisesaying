import java.util.Scanner;

public class App {

    /**
     * 명언 게시판 실행
     */
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                sc.nextLine();

                System.out.print("작가 : ");
                sc.nextLine();

                System.out.println("1번 명언이 등록되었습니다.");
            }
        }
        sc.close();
    }
}
