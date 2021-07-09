import java.util.ArrayList;
import java.util.List;

class BinarySearchTree<T extends Comparable<T>>
{
    private Node<T> root;
    private int size;

    public BinarySearchTree()
    {
        root = new Node<>(null, null, null);
        size = 0;
    }

    void insert(T value)
    {
        if (root.getData() == null)
        {
            root = new Node<>(value, null, null);
        } else
        {
            Node<T> current = root;

            if (value.compareTo(current.getData()) <= 0)
            {
                if (current.getLeft() == null)
                {
                    current.left = new Node<>(value, null, null);
                } else
                {
                    root = current.getLeft();
                    this.insert(value);
                }
            } else
            {
                if (current.getRight() == null)
                {
                    current.right = new Node<>(value, null, null);
                } else
                {
                    root = current.getRight();
                    this.insert(value);
                }
            }
            root = current;
        }


    }

    List<T> getAsSortedList()
    {
        if (root.getData() == null)
        {
            return new ArrayList<>();
        } else if (root.getLeft() == null && root.getRight() == null)
        {
            ArrayList<T> aList = new ArrayList<>();
            aList.add(root.getData());
            return aList;
        } else
        {
            Node<T> current = root;
            ArrayList<T> currentList = new ArrayList<>();
            List<T> leftList = null;
            List<T> rightList = null;

            if (current.getLeft() != null)
            {
                root = current.getLeft();
                leftList = this.getAsSortedList();
                currentList.addAll(leftList);
            }

            currentList.add(current.getData());

            if (current.getRight() != null)
            {
                root = current.getRight();
                rightList = this.getAsSortedList();
                currentList.addAll(rightList);

            }
            root = current;
            return currentList;
        }
    }

    List<T> getAsLevelOrderList()
    {
        if (root.getData() == null)
        {
            return new ArrayList<>();

        } else if (root.getLeft() == null && root.getRight() == null)
        {
            ArrayList<T> aList = new ArrayList<>();
            aList.add(root.getData());
            return aList;
        } else
        {
            Node<T> current = root;
            ArrayList<T> currentList = new ArrayList<>();
            List<T> leftList = null;
            List<T> rightList = null;

            //currentList.add(current.getLeft().getData());
            //currentList.add(current.getRight().getData());
            root = current.getLeft();
            leftList = this.getAsLevelOrderList();

            root = current.getRight();
            rightList = this.getAsLevelOrderList();


            currentList.add(current.getData());

            /*
            List<T> rightList = null;
            List<T> leftList = null;
            if (current.getLeft() != null)
            {
                //currentList.add(current.getLeft().data);
                root = current.getLeft();
                leftList = getAsLevelOrderList();
                //currentList.addAll(leftList);
            }
            if (current.getRight() != null)
            {
                //currentList.add(current.getRight().data);
                root = current.getRight();
                rightList = getAsLevelOrderList();
                //currentList.addAll(rightList);
            }
            //currentList.add(current.getLeft().getData());
            //currentList.add(current.getRight().getData());
            currentList.add(current.getData());
            currentList.add(current.getLeft().getData());
            currentList.add(current.getRight().getData());
            //currentList.addAll(leftList);
            //currentList.addAll(rightList);*/
            root = current;
            return currentList;
        }

    }

    Node<T> getRoot()
    {
        return this.root;
    }

    static class Node<T>
    {

        private Node<T> left, right;
        private T data;

        public Node(T aData, Node<T> aLeft, Node<T> aRight)
        {
            this.data = aData;
            this.left = aLeft;
            this.right = aRight;
        }

        Node<T> getLeft()
        {
            return this.left;
        }

        Node<T> getRight()
        {
            return this.right;
        }

        T getData()
        {
            return this.data;
        }

    }
}
