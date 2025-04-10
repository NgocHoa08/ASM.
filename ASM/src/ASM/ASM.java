package ASM;

import java.util.Scanner;

public class ASM {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyList studentList = new MyList();
        MyStack studentStack = new MyStack();
        int section = 0;
        
        while (section != 8) {
            System.out.println("       MENU");
            System.out.println("1. Add Student");
            System.out.println("2. Display Student");
            System.out.println("3. Edit Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Sort Student");
            System.out.println("6. Search Student");
            System.out.println("7. Stack");
            System.out.println("8. Exitting...");
            System.out.println("Enter the choice: ");
            
            try {
                section = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number (1-8).");
                continue;
            }

            switch (section) {
                case 1:
                    studentList.addStudentFromKeyBoard();
                    break;

                case 2:
                    studentList.traverse();
                    break;

                case 3:
                    studentList.editStudent();
                    break;
                    
                case 4:
                    System.out.println("Enter the ID student delete: ");
                    try {
                        int deleteId = Integer.parseInt(sc.nextLine());
                        studentList.deleStudent(deleteId);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID! Please enter a numeric ID.");
                    }
                    break;

                case 5:
                    System.out.println("1.Bubble Sort(By points): ");
                    System.out.println("2. Quick Sort(By points): ");
                    System.out.println("- Enter your choice: ");
                    
                    try {
                        int sortOption = Integer.parseInt(sc.nextLine());
                        if (sortOption == 1) {
                            studentList.bubbleSort(true);
                        } else if (sortOption == 2) {
                            studentList.quickSort(false);
                        } else {
                            System.out.println("Invalid choice!");
                        }
                        studentList.traverse();
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input! Please enter 1 or 2.");
                    }
                    break;

                case 6:
                    System.out.println("1. Linear Search");
                    System.out.println("2. Binary Search");
                    System.out.println("- Enter your choice: ");
                    
                    try {
                        int searchOption = Integer.parseInt(sc.nextLine());
                        System.out.println("- Enter the ID student to search: ");
                        int searchId = Integer.parseInt(sc.nextLine());

                        if (searchOption == 1) {
                            int index = studentList.linearSearch(searchId);
                            if (index != -1) {
                                Node p = studentList.head;
                                for (int i = 0; i < index; i++) {
                                    p = p.next;
                                }
                                System.out.println("Student found: " + p.student.toString());
                            } else {
                                System.out.println("Student with ID " + searchId + " not found.");
                            }
                        } else if (searchOption == 2) {
                            int index = studentList.binarySearch(searchId);
                            if (index != -1) {
                                Node p = studentList.head;
                                for (int i = 0; i < index; i++) {
                                    p = p.next;
                                }
                                System.out.println("Student found: " + p.student.toString());
                            } else {
                                System.out.println("Student with ID " + searchId + " not found.");
                            }
                        } else {
                            System.out.println("Invalid choice!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input! Please enter numeric values.");
                    }
                    break;

                case 7:
                    System.out.println("1. Push student onto stack");
                    System.out.println("2. Pop student from stack");
                    System.out.println("3. Display stack");
                    System.out.println("Enter your choice: ");
                    
                    try {
                        int stackOption = Integer.parseInt(sc.nextLine());
                        if (stackOption == 1) {
                            studentList.pushStack(studentStack);
                        } else if (stackOption == 2) {
                            studentStack.pop();
                        } else if (stackOption == 3) {
                            studentStack.displayStack();
                        } else {
                            System.out.println("Invalid choice!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input! Please enter 1, 2, or 3.");
                    }
                    break;

                case 8:
                    System.out.println("Exitting.");
                    break;

                default:
                    System.out.println("Incorrect. Please again.");
            }
        }
    }
}