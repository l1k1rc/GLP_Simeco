package ressources;

public class ContentSize {
	private float contentSize;
	
	public ContentSize(float content) {
		contentSize=content;
	}

	public float getContentSize() {
		return contentSize;
	}

	public void setContentSize(float contentSize) {
		this.contentSize = contentSize;
	}
	
	public void reducerContentSize(int reducer) {
		this.contentSize -= reducer;
	}
	
	
}
