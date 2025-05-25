import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private List<WiseSaying> wiseSayingList = new ArrayList<>();

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
                String content = sc.nextLine();

                System.out.print("작가 : ");
                String author = sc.nextLine();

                WiseSaying wiseSaying = new WiseSaying(content, author);
                wiseSayingList.add(wiseSaying);
                System.out.printf("%d번 명언이 등록되었습니다.%n", wiseSaying.getId());
            } else if (cmd.equals("목록")) {
                printWiseSayingList();
            }
        }
        sc.close();
    }

    /**
     * 명언 목록 조회 (system.print)
     */
    private void printWiseSayingList() {
        for (int i = wiseSayingList.size() - 1; i >= 0; i--) {
            wiseSayingList.get(i).printWiseSaying();
        }
    }
}
