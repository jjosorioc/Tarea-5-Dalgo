public class Edge {

	private Integer initial_vertex;
	private Integer final_vertex;
	private Integer cost;

	public Edge(Integer i, Integer f, Integer c) {
		this.initial_vertex = i;
		this.final_vertex = f;
		this.cost = c;
	}

	public Integer getWeight() {
		return this.cost;
	}

	public Integer getInitialVertex() {
		return this.initial_vertex;
	}

	public Integer getFinalVertex() {
		return this.final_vertex;
	}

	@Override
	public String toString() {
		return "Edge [initial_vertex=" + initial_vertex + ", final_vertex=" + final_vertex + ", cost=" + cost + "]";
	}
}