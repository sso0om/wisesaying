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
            String cmd = sc.nextLine().trim();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                String content = sc.nextLine().trim();

                System.out.print("작가 : ");
                String author = sc.nextLine().trim();

                WiseSaying wiseSaying = new WiseSaying(content, author);
                wiseSayingList.add(wiseSaying);
                System.out.printf("%d번 명언이 등록되었습니다.%n", wiseSaying.getId());
            } else if (cmd.equals("목록")) {
                printWiseSayingList();
            } else if (cmd.startsWith("삭제?id=")) {
                deleteWiseSaying(getCmdId(cmd));
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

    /**
     * 명언 삭제
     * @param id
     */
    private void deleteWiseSaying(long id) {
        boolean hasId = false;
        for (int i = 0; i < wiseSayingList.size(); i++) {
            if (wiseSayingList.get(i).getId() == id) {
                hasId = true;
                wiseSayingList.remove(i);
                System.out.printf("%d번 명언이 삭제되었습니다.%n", id);
                break;
            }
        }
        if (!hasId) {
            System.out.printf("%d번 명언은 존재하지 않습니다.%n", id);
        }
    }

    /**
     * 삭제할 명언 id 추출 (삭제?id=)
     * @param cmd
     * @return wiseSaying id
     */
    private long getCmdId(String cmd) {
        String[] parts = cmd.split("\\?id=");

        if (parts.length != 2) {
            return -1;
        }
        try {
            return Long.parseLong(parts[1]);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
