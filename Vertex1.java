class Vertex1
{
	static int min(int x, int y)
	{
		return (x < y) ? x : y;
	}
	static class node
	{
		int data;
		node left, right;
	};
	static int vCover(node root)
	{
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 0;
		int size_incl = 1 + vCover(root.left) + vCover(root.right);
		int size_excl = 0;
		if (root.left != null)
			size_excl += 1 + vCover(root.left.left) + vCover(root.left.right);
		if (root.right != null)
			size_excl += 1 + vCover(root.right.left) + vCover(root.right.right);
		return Math.min(size_incl, size_excl);
	}
	static node newNode(int data)
	{
		node temp = new node();
		temp.data = data;
		temp.left = temp.right = null;
		return temp;
	}
	public static void main(String[] args)
	{
		node root = newNode(20);
		root.left = newNode(8);
		root.left.left = newNode(4);
		root.left.right = newNode(12);
		root.left.right.left = newNode(10);
		root.left.right.right = newNode(14);
		root.right = newNode(22);
		root.right.right = newNode(25);

		System.out.printf("Size of the smallest vertex" + "cover is %d ", vCover(root));

	}
}