import java.util.ArrayList;
public class Vertex<T> {
	public Vertex()
	{
		Adj = new ArrayList<Vertex<T>>();
	}
	public void addEdge(Vertex<T> v) throws Exception
	{
		if(!Adj.contains(v))
			Adj.add(v);
		else
			throw new Exception("Edge from " + this + " and " + v + " already exist");
	}
	public void removeEdge(Vertex<T> v) throws Exception
	{
		if(Adj.contains(v))
			Adj.remove(v);
		else
			throw new Exception("Edge between " + this + " and " + v + " do not exist");
	}
	public boolean isEdge(Vertex<T> e )
	{
		return Adj.contains(e);
	}
	
	public ArrayList<Vertex<T>> getAdjacent()
	{
		return Adj;
	}
	public int getDegree()
	{
		return Adj.size();
	}
	
	private ArrayList<Vertex<T>> Adj;
}
