package Paper;

public interface Iterator<O> {
	
	boolean hasNext();
	<O> O next();
}
