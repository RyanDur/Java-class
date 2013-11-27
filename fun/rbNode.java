public class rbNode {
    private int index;
    private rbNode left;
    private rbNode right;
    private boolean black;

    public rbNode(int index) {
	this.index = index;
	black = false;
    }

    public void setLeft(rbNode node) {
	left = node;
    }

    public rbNode getLeft() {
	return left;
    }

    public void setRight(rbNode node) {
	right = node;
    }

    public rbNode getRight() {
	return right;
    }

    public int getIndex() {
	return index;
    }

    public boolean getColour() {
	return black;
    }

    public void toggleColour() {
	if(black) {
	    black = false;
	} else {
	    black = true;
	}
    }

    public String toString() {
	String colour = "r";
	if(black) {
	    color = "b";
	}
	return "i: "index + ", c: " + colour;
    }
}
