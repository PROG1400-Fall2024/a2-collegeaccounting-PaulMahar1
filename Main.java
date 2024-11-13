import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Staff> members = new ArrayList<>();
        double outgoing = 0;
        double incoming = 0;


        Object[] firstChoices = {"Student", "Staff", "Finish"};

        //INPUT
        while (true) {
            int firstChoice = JOptionPane.showOptionDialog(null, "Select Student or Staff.", "Accounting App",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, firstChoices, firstChoices[0]);

            if (firstChoice == 2 || firstChoice == JOptionPane.CLOSED_OPTION) {
                break;
            }

            if (firstChoice == 0) {
                String studentName;
                while (true) {
                    studentName = JOptionPane.showInputDialog("Enter student name.");
                    if (studentName == null) {
                        break;
                    }
                    if (studentName.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid input for student name.");
                        continue;
                    }
                    break;
                }

                if (studentName == null) {
                    continue;
                }

                String studentAddress;
                while (true) {
                    studentAddress = JOptionPane.showInputDialog("Enter student address.");
                    if (studentAddress == null) {
                        break;
                    }
                    if (studentAddress.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid input for student address.");
                        continue;
                    }
                    break;
                }

                if (studentAddress == null) {
                    continue;
                }

                String inputYears;
                int studentYears = 0;
                while (true) {
                    inputYears = JOptionPane.showInputDialog("Enter student year (1-4)");
                    if (inputYears == null) {
                        break;
                    }

                    // This regex was supplied by GPT, regex is confusing, and I'll never remember all of them lol
                    if (inputYears.isEmpty() || !inputYears.matches("\\d+")) {
                        JOptionPane.showMessageDialog(null, "Please enter a number.");
                        continue;
                    }
                    studentYears = Integer.parseInt(inputYears);
                    if (studentYears < 1 || studentYears > 4){
                        JOptionPane.showMessageDialog(null, "Please enter a valid input for student year.");
                        continue;
                    }
                    break;
                }

                    Student student = new Student(studentName, studentAddress, studentYears);
                    students.add(student);

            } else if (firstChoice == 1) {
                String staffName;
                while (true) {
                    staffName = JOptionPane.showInputDialog("Enter staff name.");
                    if (staffName == null) {
                        break;
                    }
                    if (staffName.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid input for staff name.");
                        continue;
                    }
                    break;
                }

                if (staffName == null) {
                    continue;
                }

                String staffAddress;
                while (true) {
                    staffAddress = JOptionPane.showInputDialog("Enter staff address.");
                    if (staffAddress == null) {
                        break;
                    }
                    if (staffAddress.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid input for staff address.");
                        continue;
                    }
                    break;
                }

                if (staffAddress == null) {
                    continue;
                }

                String staffInYears;
                int staffYears = 0;
                while (true) {
                    staffInYears = JOptionPane.showInputDialog("Enter staff years of service.");
                    if (staffInYears == null) {
                        break;
                    }
                    if (staffInYears.isEmpty() || !staffInYears.matches("\\d+")) {
                        JOptionPane.showMessageDialog(null, "Please enter a number.");
                        continue;
                    }
                    staffYears = Integer.parseInt(staffInYears);
                    if (staffYears < 1 || staffYears > 29) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid input for years of service.");
                        continue;
                    }
                    break;
                }
                Staff staff = new Staff(staffName, staffAddress, staffYears);
                members.add(staff);
            }
        }

        //OUTPUT
//        System.out.println("\nStudents: [Total: " + students.size() + "]");
//        int studentCounter = 1;
//        for(Student student:students){
//            System.out.println(studentCounter + ". " + student.toString());
//            incoming += student.getTuition() / 2;
//            studentCounter++;
//        }
//
//        System.out.println("\nStaff: [Total: " + members.size() + "]");
//        int staffCounter = 1;
//        for(Staff staff:members){
//            System.out.println(staffCounter + ". " + staff.toString());
//            outgoing += staff.getPayBase() / 26;
//            staffCounter ++;
//        }
//
//        System.out.printf("\nResults: \nOutgoing: $%.2f\nIncoming: $%.2f\nTotal: $%.2f", outgoing, incoming, (incoming - outgoing));

        //https://chatgpt.com/share/673407fe-50d0-8013-9a5e-6352c9c69494
        StringBuilder output = new StringBuilder();

        output.append("\nStudents: [Total: ").append(students.size()).append("]\n");
        int studentCounter = 1;
        for(Student student : students) {
            output.append(studentCounter).append(". ").append(student.toString()).append("\n");
            incoming += student.getFee();
            studentCounter++;
        }

        output.append("\nStaff: [Total: ").append(members.size()).append("]\n");
        int staffCounter = 1;
        for(Staff staff : members) {
            output.append(staffCounter).append(". ").append(staff.toString()).append("\n");
            outgoing += staff.getPayBiweekly();
            staffCounter++;
        }

        output.append(String.format("\nResults: \nOutgoing: $%.2f\nIncoming: $%.2f\nTotal: $%.2f", outgoing, incoming, (incoming - outgoing)));

        // Display the output in a popup
        JOptionPane.showMessageDialog(null, output.toString(), "Results", JOptionPane.INFORMATION_MESSAGE);

    }
}
