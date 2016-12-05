import java.util.ArrayList;
import java.util.Stack;
public class Tarjan {
	
	private int index;
	private Stack<Vertex<Integer>> stack;
	private ArrayList<Vertex<Integer>> marked;
	private int count; //probably don't need since using components.size() should yield same results
	private ArrayList<Integer> low;
	private ArrayList<ArrayList<Vertex<Integer>>> components;
	
	public Tarjan(DirectedGraph<Integer> G)
	{
		components = new ArrayList<ArrayList<Vertex<Integer>>>();
		ArrayList<Vertex<Integer>> list = G.getVertices();
		for(Vertex<Integer> v : list)
		{
			if(!marked.contains(v))
			{
				findComponents(v);
			}
		}
	}
	public void findComponents(Vertex<Integer> v)
	{
		marked.add(index, v);
		low.add(index, index); 
		index++;
		stack.push(v);
		for(Vertex<Integer> adj : v.getAdjacent())
		{
			if(!marked.contains(adj))
			{
				findComponents(adj);
				//v.lowlink = min(v.lowlink, w.index); //get the min value of the two
				if(index > marked.indexOf(adj))
				{
					low.add(index, marked.indexOf(adj));
				}
			}
			else if(stack.contains(adj))
			{
				if(index > marked.indexOf(adj))
				{
					low.add(index, marked.indexOf(adj));
				}
			}
		}
		
		//if v is a root node, pop the stack and generate a SCC
		if(index==low.get(index))
		{
			//start new strongly connected component
			ArrayList<Vertex<Integer>> component = new ArrayList<Vertex<Integer>>();
			Vertex<Integer> w;
			do{
				//add w to the current component
				w = stack.pop();
				component.add(w);
			}while(v != w);
			count++;
			components.add(component);
		}
	}
	
	public ArrayList<Vertex<Integer>> getcomponent(Vertex<Integer> v)
	{
		for(ArrayList<Vertex<Integer>> list : components)
		{
			if(list.contains(v))
			{
				return list;
			}
		}
		return null;
	}
	
	public ArrayList<ArrayList<Vertex<Integer>>> getComponents()
	{
		return components;
	}
	
	public int getCount()
	{
		return count;
	}
	
}
