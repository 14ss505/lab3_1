package MVC.model.Paper;

public interface Iterator<O> {
	
	public boolean hasNext();
	public <O> O next();
}
