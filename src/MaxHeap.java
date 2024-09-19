import java.util.ArrayList;
import java.util.Collection;

public class MaxHeap
{
    private ArrayList<Student> students;

    public MaxHeap(int capacity)
    {
        students = new ArrayList<Student>(capacity);
    }

    public MaxHeap(Collection<Student> collection)
    {
        students = new ArrayList<Student>(collection);
        for(int i = size()/2 - 1; i >= 0; i--)
        {
            maxHeapify(i);
        }
    }

    public Student getMax()
    {
        if(size() < 1)
        {
            throw new IndexOutOfBoundsException("No maximum value:  the heap is empty.");
        }
        return students.get(0);
    }

    public Student extractMax()
    {
        Student value = getMax();
        students.set(0,students.get(size()-1));
        students.remove(size()-1);
        maxHeapify(0);
        return value;
    }

    public int size()
    {
        return students.size();
    }

    public void insert(Student elt)
    {
        students.add(elt);
        int index = size() -1; // index of the added node(student)
        elt.setIndex(index); // set index for student
        bubbleUp(elt);
    }

    public void addGrade(Student elt, double gradePointsPerUnit, int units)
    {
        int index = elt.getIndex();

        if (index != -1){ // if the student exists
            elt.addGrade(gradePointsPerUnit, units); // update the GPA
            maxHeapify(index); // bubble down
            bubbleUp(elt); // bubble up
        } else {
            throw new IllegalArgumentException("Student does not exist");
        }
    }

    public void bubbleUp(Student elt)
    {
        int index = students.indexOf(elt);

        while (elt.compareTo(students.get(parent(index))) > 0){
            swap(index, parent(index)); // after comparison swap parent and new node
            index = parent(index); // child node is now the parent
            elt.setIndex(index); // new index set
        }
    }

    private int parent(int index)
    {
        return (index - 1)/2;
    }

    private int left(int index)
    {
        return 2 * index + 1;
    }

    private int right(int index)
    {
        return 2 * index + 2;
    }

    private void swap(int from, int to)
    {
        Student val = students.get(from);
        students.set(from,  students.get(to));
        students.set(to,  val);

        students.get(from).setIndex(from);
        students.get(to).setIndex(to);
    }

    private void maxHeapify(int index) // this method is only used for bubble down
    {
        int left = left(index);
        int right = right(index);
        int largest = index;
        if (left <  size() && students.get(left).compareTo(students.get(largest)) > 0)
        {
            largest = left;
        }
        if (right <  size() && students.get(right).compareTo(students.get(largest)) > 0)
        {
            largest = right;
        }
        if (largest != index)
        {
            swap(index, largest);
            maxHeapify(largest);
        }
    }
}