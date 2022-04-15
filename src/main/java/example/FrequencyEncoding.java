package example;

import java.util.List;
import java.util.Arrays;
import java.util.HashMap;

import org.neo4j.procedure.Description;
import org.neo4j.procedure.Name;
import org.neo4j.procedure.UserFunction;

public class FrequencyEncoding {
	@UserFunction
    @Description("example.frequencyEncoding(['s1','s2',..., 'sn'], ['s1', 's2']) - return frequency embedding.")
    public int[] frequencyEncoding(
            @Name("world") String[] world,
            @Name("states") String[] states) {
		
		// initialize with default value 0
		int[] rets = new int[world.length];
		
		// map from word to index
		HashMap<String, Integer> w2i = new HashMap<String, Integer>();
		for (int i = 0; i < world.length; i++) {
			w2i.put(world[i], i);
		}
		
		for (String w : states) {
			rets[w2i.get(w)] += 1;
		}
		
		return rets;
    }
	
//	public static void main(String[] args) {
//		System.out.print("Hello World!");
//		FrequencyEncoding obj = new FrequencyEncoding();
//		String[] worlds = {"good", "bad", "avrage"};
//		String[] states = {"good", "bad", "good"};
//		System.out.print(
//				Arrays.toString(obj.frequencyEncoding(worlds, states))
//		);
//	}
}

