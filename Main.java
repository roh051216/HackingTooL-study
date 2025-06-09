import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Students student1 = new Students();
//        student1.SetStudents("2024011896","노용균","2005-12-16","11");
        Students student1 = new Students("2024011896","노용균","2005-12-16","11");
        student1.contact = "0001000010000";
        student1.printStudentInfo();
        student1.addCourse("Java");
        student1.addCourse("자료구조");
        student1.printStudentInfo();

    }


}

//    static final int studentNum = 3;
//
//    static String[][] students = new String[studentNum][5];
//    static ArrayList<String>[] courseLists = new ArrayList[studentNum];
//
//    public static void main(String[] args) {
//
//        initializeData();
//        printAllStudents();
//    }
//
//    //  1. 데이터 초기화
//    public static void initializeData() {
//        for (int i = 0; i < studentNum; i++) {
//            courseLists[i] = new ArrayList<>();
//        }
//
//        students[0][0] = "2024011896"; students[0][1] = "노용균"; students[0][2] = "재학"; students[0][3] = "2005-12-16"; students[0][4] = "010-2441-0996";
//        students[1][0] = "2023011896"; students[1][1] = "김용균"; students[1][2] = "퇴학"; students[1][3] = "2003-12-16"; students[1][4] = "010-2323-0946";
//        students[2][0] = "2022011896"; students[2][1] = "도용균"; students[2][2] = "정학"; students[2][3] = "2002-12-16"; students[2][4] = "010-2646-0966";
//
//        courseLists[0].add("자료구조");
//        courseLists[0].add("운영체제");
//
//        courseLists[1].add("네트워크");
//        courseLists[1].add("자료구조");
//
//        courseLists[2].add("데이터통신");
//        courseLists[2].add("Java");
//        courseLists[2].add("데이터베이스");
//
//    }
//
//    //  2. 전체 학생 출력
//    public static void printAllStudents() {
//        for (int i = 0; i < studentNum; i++) {
//            printStudentInfo(i);
//            printCourses(i);
//            System.out.println();
//        }
//    }
//
//    // 3. 학생 정보 출력
//    public static void printStudentInfo(int index) {
//        System.out.println("==== 학생 " + (index + 1) + " 정보 ====");
//        System.out.println("학번: " + students[index][0]);
//        System.out.println("이름: " + students[index][1]);
//        System.out.println("상태: " + students[index][2]);
//        System.out.println("생년월일: " + students[index][3]);
//        System.out.println("연락처: " + students[index][4]);
//
//    }
//
//
//    //  4. 수강 과목 출력
//    public static void printCourses(int index) {
//        System.out.println("수강 교과목 목록:");
//        if (courseLists[index].isEmpty()) {
//            System.out.println("없음");
//        } else {
//            for (String course : courseLists[index]) {
//                System.out.println(course);
//            }
//        }
//    }
//}
