package ra.session03.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.session03.model.Student;
import ra.session03.repository.StudentRepository;

import java.util.*;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudents(String sortBy, String search, String faculty) {
        List<Student> students = studentRepository.findAll();

        students = filterByName(students, search);
        students = filterByFaculty(students, faculty);
        students = sortStudents(students, sortBy);

        return students;
    }

    private List<Student> filterByName(List<Student> list, String search) {
        if (search == null || search.isEmpty()) return list;

        return list.stream()
                .filter(s -> s.getFullName().toLowerCase().contains(search.toLowerCase()))
                .toList();
    }

    private List<Student> filterByFaculty(List<Student> list, String faculty) {
        if (faculty == null || faculty.isEmpty()) return list;

        return list.stream()
                .filter(s -> s.getFaculty().equalsIgnoreCase(faculty))
                .toList();
    }

    private List<Student> sortStudents(List<Student> list, String sortBy) {
        if ("name".equals(sortBy)) {
            return list.stream()
                    .sorted(Comparator.comparing(Student::getFullName))
                    .toList();
        } else if ("gpa".equals(sortBy)) {
            return list.stream()
                    .sorted(Comparator.comparing(Student::getGpa).reversed())
                    .toList();
        }
        return list;
    }

    public Student getById(int id) {
        return studentRepository.findAll().stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public int totalStudents() {
        return studentRepository.findAll().size();
    }

    public double avgGpa() {
        List<Student> list = studentRepository.findAll();

        if (list.isEmpty()) return 0.0;

        double sum = 0;
        for (Student s : list) {
            sum += s.getGpa();
        }

        return sum / list.size();
    }

    public Student topStudent() {
        List<Student> list = studentRepository.findAll();

        if (list.isEmpty()) return null;

        Student top = list.get(0);

        for (Student s : list) {
            if (s.getGpa() > top.getGpa()) {
                top = s;
            }
        }

        return top;
    }

    public Map<String, Double> statusPercent() {
        List<Student> list = studentRepository.findAll();
        Map<String, Double> result = new HashMap<>();

        int total = list.size();
        if (total == 0) return result;

        int dangHoc = 0;
        int canhCao = 0;
        int daTotNghiep = 0;
        int moiNhapHoc = 0;

        for (Student s : list) {
            if ("Đang học".equals(s.getStatus())) {
                dangHoc++;
            } else if ("Cảnh cáo".equals(s.getStatus())) {
                canhCao++;
            } else if ("Đã tốt nghiệp".equals(s.getStatus())) {
                daTotNghiep++;
            } else if ("Mới nhập học".equals(s.getStatus())) {
                moiNhapHoc++;
            }
        }

        result.put("Đang học", dangHoc * 100.0 / total);
        result.put("Cảnh cáo", canhCao * 100.0 / total);
        result.put("Đã tốt nghiệp", daTotNghiep * 100.0 / total);
        result.put("Mới nhập học", moiNhapHoc * 100.0 / total);

        return result;
    }


}
