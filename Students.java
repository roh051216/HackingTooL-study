    import java.util.ArrayList;

    public class Students {
        private String id;
        private String name;
        private String birthDate;
        public String contact;
        private ArrayList<String> courses;

        public void addCourse(String courseName) {
            courses.add(courseName);

        }

        public Students()
        {
            id = "";
            name = "";
            birthDate = "";
            contact = "";
            courses = new ArrayList<>();


        }

        public Students(String id, String name, String birthDate, String contact)
        {
            this.id = id;
            this.name = name;
            this.birthDate = birthDate;
            this.contact = contact;
        }

        public void SetStudents(String id, String name, String birthDate, String contact)
        {
            this.id = id;
            this.name = name;
            this.birthDate = birthDate;
            this.contact = contact;
        }

        public void printStudentInfo() {
            System.out.println("ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Birth Date: " + birthDate);
            System.out.println("Contact: " + contact);

        }


        public void printCourses() {

            System.out.println("수강 교과목 목록:");
            if (courses.isEmpty()) {
                System.out.println("없음");
            } else {
                for (String course : courses) {
                    System.out.println(course);
                }
            }


        }
    }