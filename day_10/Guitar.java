public class Guitar extends MusicalInstrument {
    private WoodenObject material;

    public Guitar(WoodenObject material) {
	this.material = material;
    }

    public void play() {
	super.play();
    }

    public void burn() {
	material.burn();
    }
}
