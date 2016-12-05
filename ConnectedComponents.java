import java.util.ArrayList;
public class ConnectedComponents
{
	private ArrayList<Vertex<Integer>> marked;
	private int count;
	
	
	public ConnectedComponents(UndirectedGraph<Integer> g)
	{
		ArrayList<Vertex<Integer>> list = g.getVertices();
		for(Vertex<Integer> v: list)
		{
			if(!marked.contains(v))
			{
				search(v,g.getVertices());
				count++;
			}
		}
	}
	
	
	public ArrayList<Vertex<Integer>> findComponent(Vertex<Integer> v, UndirectedGraph<Integer> g)
	{
		ArrayList<Vertex<Integer>> component = new ArrayList<Vertex<Integer>>();
		marked.clear();
		component.add(v);
		searchComponent(v.getAdjacent(),component);
		return component;
	}
	
	//this function provides DFS for this specific case.
	private void search(Vertex<Integer> v, ArrayList<Vertex<Integer>> vertices)
	{
		for(Vertex<Integer> ad : vertices)
		{
			if(!marked.contains(v))
			{
				marked.add(ad);
				search(v,v.getAdjacent());
			}
		}
	}
	
	//used by find component to actually populate the component
	private void searchComponent(ArrayList<Vertex<Integer>> list, ArrayList<Vertex<Integer>> component)
	{
		for(Vertex<Integer> vertex: list)
		{
			if(!marked.contains(vertex))
			{
				//i don't think a vertex can be in the list without being marked. just there for safety
				marked.add(vertex);
				if(!component.contains(vertex))
				{
					component.add(vertex);
				}
				searchComponent(vertex.getAdjacent(),component);
			}
		}
	}
	
	public int getCount()
	{
		return count;
	}
	
}
