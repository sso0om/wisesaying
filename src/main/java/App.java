import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private List<WiseSaying> wiseSayingList = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    /**
     * 명언 게시판 실행
     */
    public void run() {
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine().trim();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                createWiseSaying();
            } else if (cmd.equals("목록")) {
                printWiseSayingList();
            } else if (cmd.startsWith("삭제?id=")) {
                deleteWiseSaying(getCmdId(cmd));
            } else if (cmd.startsWith("수정?id=")) {
                modifyWiseSaying(getCmdId(cmd));
            }
        }
        sc.close();
    }

    /**
     * 명언 등록
     */
    private void createWiseSaying() {
        System.out.print("명언 : ");
        String content = sc.nextLine().trim();

        System.out.print("작가 : ");
        String author = sc.nextLine().trim();

        WiseSaying wiseSaying = new WiseSaying(content, author);
        wiseSayingList.add(wiseSaying);
        System.out.printf("%d번 명언이 등록되었습니다.%n", wiseSaying.getId());
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
     * 명언 수정
     * @param cmdId
     */
    private void modifyWiseSaying(long cmdId) {
        if (cmdId == -1) {
            return;
        }

        boolean hasId = false;
        for (int i = 0; i < wiseSayingList.size(); i++) {
            if (wiseSayingList.get(i).getId() == cmdId) {
                hasId = true;
                WiseSaying wiseSaying = wiseSayingList.get(i);

                System.out.printf("명언(기존) : %s%n", wiseSaying.getContent());
                System.out.print("명언 : ");
                wiseSaying.setContent(sc.nextLine().trim());

                System.out.printf("작가(기존) : %s%n", wiseSaying.getAuthor());
                System.out.print("작가 : ");
                wiseSaying.setAuthor(sc.nextLine().trim());

                break;
            }
        }
        if (!hasId) {
            System.out.printf("%d번 명언은 존재하지 않습니다.%n", cmdId);
        }
    }

    /**
     * 명언 삭제
     * @param cmdId
     */
    private void deleteWiseSaying(long cmdId) {
        if (cmdId == -1) {
            return;
        }

        boolean hasId = false;
        for (int i = 0; i < wiseSayingList.size(); i++) {
            if (wiseSayingList.get(i).getId() == cmdId) {
                hasId = true;
                wiseSayingList.remove(i);
                System.out.printf("%d번 명언이 삭제되었습니다.%n", cmdId);
                break;
            }
        }
        if (!hasId) {
            System.out.printf("%d번 명언은 존재하지 않습니다.%n", cmdId);
        }
    }


    /**
     * 수정,삭제할 명언 id 추출 (?id=)
     * @param cmd
     * @return wiseSaying id (오입력 시 -1 처리)
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
