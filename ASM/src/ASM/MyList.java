package ASM;

import java.util.Scanner;

public class MyList {

    Node head, tail;
    public MyList() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addStudentFromKeyBoard() {
        int id = 0; 
        String name = ""; 
        double mark = 0.0; 
        boolean validInput = false; 

        while (!validInput) {
            try {
                System.out.println("Enter the ID student: ");
                String idInput = System.console().readLine(); 
                id = Integer.parseInt(idInput);

                if (isDuplicateId(id)) {
                    System.out.println("ID already exists! Please enter a different ID.");
                } else {
                    validInput = true; 
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! ID must be a number. Please try again.");
            }
        }

        validInput = false; 
        while (!validInput) {
            System.out.println("Enter the name student: ");
            name = System.console().readLine();

            if (name.matches("[a-zA-Z\\s]+")) { 
                validInput = true;
            } else {
                System.out.println("Invalid input! " + "Name must not contain numbers or special characters." + " Please try again.");
            }
        }

        validInput = false; 
        while (!validInput) {
            try {
                System.out.println("Enter the mark student (1-10): ");
                String markInput = System.console().readLine(); 
                mark = Double.parseDouble(markInput); 

                if (mark >= 1 && mark <= 10) {
                    validInput = true; 
                } else {
                    System.out.println("Invalid input! Mark must be between 1 and 10. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Mark must be a number. Please try again.");
            }
        }

        add(new Student(id, name, mark));
        System.out.println("Student added successfully!");
    }

    public void add(Student s) {
        Node newNode = new Node(s);
        if (isEmpty() == true) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    private boolean isDuplicateId(int id) {
        Node current = head;

        while (current != null) {
            if (current.student.getId() == id) {
                return true; 
            }
            current = current.next; 
        }
        return false; 
    }
 
    public void editStudent() {
        int id = 0; 
        String newName = ""; 
        double newMark = 0.0;
        boolean validInput = false; 

        while (!validInput) {
            try {
                System.out.println("Enter the ID student update: ");
                String idInput = System.console().readLine(); 
                id = Integer.parseInt(idInput);

                if (!isIdExist(id)) {
                    System.out.println("Student with ID " + id + " does not exist. Please try again.");
                } else {
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! ID must be a number. Please try again.");
            }
        }

        validInput = false;
        while (!validInput) {
            System.out.println("Enter the new name student: ");
            newName = System.console().readLine(); 

            if (newName.matches("[a-zA-Z\\s]+")) { 
                validInput = true; 
            } else {
                System.out.println("Invalid input! Name must not contain numbers or special characters. Please try again.");
            }
        }

        validInput = false; 
        while (!validInput) {
            try {
                System.out.println("Enter the new mark student: ");
                String markInput = System.console().readLine(); 
                newMark = Double.parseDouble(markInput);

                if (newMark >= 1 && newMark <= 10) {
                    validInput = true; 
                } else {
                    System.out.println("Invalid input! Mark must be between 1 and 10. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Mark must be a number. Please try again.");
            }
        }
        Node p = head;
        while (p != null) {
            if (p.student.getId() == id) {
                p.student = new Student(id, newName, newMark);
                System.out.println("The student with ID " + id + " has been updated.");
                return;
            }
            p = p.next;
        }
    }

    private boolean isIdExist(int id) {
        Node current = head;

        while (current != null) {
            if (current.student.getId() == id) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void deleStudent(int id) {
        try {
            if (head == null) {
                System.out.println("No student to delete. The list is empty.");
                return;
            }

            if (head.student.getId() == id) {
                head = head.next;
                System.out.println("The student with ID " + id + " has been deleted.");
                return;
            }

            Node p = head;
            while (p.next != null) {
                if (p.next.student.getId() == id) {
                    p.next = p.next.next;
                    System.out.println("The student with ID " + id + " has been deleted.");
                    return;
                }
                p = p.next;
            }

            System.out.println("Student with ID " + id + " not found.");
        } catch (Exception e) {
            System.out.println("An error occurred while deleting the student: " + e.getMessage());
        }
    }

    public void bubbleSort(boolean ascending) {
        if (head == null || head.next == null) {
            System.out.println("The list is empty or has only one element. No sorting needed.");
            return;
        }
        try {
            boolean swapped;
            do {
                swapped = false;
                Node p = head;

                while (p.next != null) {
                    boolean condition;
                    if (ascending) {
                        condition = p.student.getMark() > p.next.student.getMark();
                    } else {
                        condition = p.student.getMark() < p.next.student.getMark();
                    }

                    if (condition) {
                        Student temp = p.student;
                        p.student = p.next.student;
                        p.next.student = temp;
                        swapped = true;
                    }
                    p = p.next;
                }
            } while (swapped);

            System.out.println("Sorting completed successfully.");
        } catch (Exception e) {
            System.out.println("An error occurred during sorting: " + e.getMessage());
        }
    }

    public void quickSort(boolean ascending) {
        head = quickSortRec(head, ascending);
        Node p = head;
        while (p != null && p.next != null) {
            p = p.next;
        }
        tail = p;
    }

    private Node quickSortRec(Node start, boolean ascending) {
        try {
            if (start == null || start.next == null) {
                return start;
            }

            Node pivot = start;
            Node less = null, greater = null;
            Node current = start.next;

            while (current != null) {
                Node next = current.next;

                boolean condition;
                if (ascending) {
                    condition = current.student.getMark() < pivot.student.getMark();
                } else {
                    condition = current.student.getMark() > pivot.student.getMark();
                }

                if (condition) {
                    current.next = less;
                    less = current;
                } else {
                    current.next = greater;
                    greater = current;
                }
                current = next;
            }

            less = quickSortRec(less, ascending);
            greater = quickSortRec(greater, ascending);

            if (less == null) {
                pivot.next = greater;
                return pivot;
            } else {
                Node temp = less;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = pivot;
                pivot.next = greater;
                return less;
            }
        } catch (Exception e) {
            System.out.println("An error occurred during Quick Sort: " + e.getMessage());
            return start;
        }
    }

    public int linearSearch(int id) {
        try {
            Node p = head;
            int index = 0;

            while (p != null) {
                if (p.student.getId() == id) {
                    return index;
                }
                p = p.next;
                index++;
            }
            return -1;
        } catch (Exception e) {
            System.out.println("An error occurred during Linear Search: " + e.getMessage());
            return -1;
        }
    }

    public int binarySearch(int id) {
        try {
            bubbleSort(true);

            Node p = head;
            int low = 0, high = 0;

            while (p != null) {
                high++;
                p = p.next;
            }
            high--;

            while (low <= high) {
                int mid = (low + high) / 2;

                p = head;
                for (int i = 0; i < mid; i++) {
                    p = p.next;
                }

                if (p.student.getId() == id) {
                    return mid;
                } else if (p.student.getId() < id) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return -1;
        } catch (Exception e) {
            System.out.println("An error occurred during Binary Search: " + e.getMessage());
            return -1;
        }
    }

    public void traverse() {
        Node p = head;
        while (p != null) {
            System.out.println(p.student.toString());
            p = p.next;
        }
    }

    public void pushStack(MyStack stack) {
        Node p = head;
        while (p != null) {
            stack.push(p.student);
            p = p.next;
        }
    }
}