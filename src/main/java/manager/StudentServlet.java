package manager;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/students")
public class StudentServlet extends HttpServlet {
    public List<Student> studentList;
    @Override
    public void init() throws ServletException {
        super.init();
        studentList = new ArrayList<>();
        studentList.add(new Student(1, "An", 6.5, "B"));
        studentList.add(new Student(2, "Bang", 9, "A"));
        studentList.add(new Student(3, "Cao", 10, "A"));
        studentList.add(new Student(3, "Hung", 2, "D"));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "new":
                newStudent(request, response);
                break;
            case "create":
                createStudent(request, response);
                break;
            case "update":
                updateStudent(request, response);
                break;
            case "edit":
                editStudent(request, response);
                break;
            case "delete":
                deleteStudent(request, response);
                break;

            default:
                listStudent(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void listStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("studentList", studentList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student-view.jsp");
        dispatcher.forward(request, response);
    }
    private void newStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("student-form.jsp");
        dispatcher.forward(request, response);
    }

    private void createStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        double score = Double.parseDouble(request.getParameter("score"));
        String grade = request.getParameter("grade");
        int id = studentList.size() + 1;

        //Create new student
        Student newStudent = new Student(id, name, score, grade);
        studentList.add(newStudent);

        response.sendRedirect("students");
    }
    private void editStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = getStudentById(id);

        request.setAttribute("student", student);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student-form.jsp");
        dispatcher.forward(request, response);
    }
    private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Double score = Double.parseDouble(request.getParameter("score"));
        String grade = request.getParameter("grade");

        Student studentUp = getStudentById(id);
        studentUp.setId(id);
        studentUp.setName(name);
        studentUp.setScore(score);
        studentUp.setGrade(grade);

        response.sendRedirect("students");
    }
    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = getStudentById(id);

            studentList.remove(student);


        response.sendRedirect("students");
    }


    private Student getStudentById(int id) {
        for (Student student : studentList) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

}


