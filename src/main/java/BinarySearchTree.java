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
        }
        else
        {
            Node<T> current = root;

            if (value.compareTo(current.getData()) <= 0)
            {
                if (current.getLeft() == null)
                {
                    current.left = new Node<>(value, null, null);
                }
                else
                {
                    root = current.getLeft();
                    this.insert(value);
                }
            }
            else
            {
                if (current.getRight() == null)
                {
                    current.right = new Node<>(value, null, null);
                }
                else
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
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    List<T> getAsLevelOrderList()
    {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
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
