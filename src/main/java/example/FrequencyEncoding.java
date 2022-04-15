package example;

import java.util.HashMap;

import org.neo4j.procedure.Description;
import org.neo4j.procedure.Name;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.neo4j.procedure.Procedure;
import java.util.Arrays;


public class FrequencyEncoding {
	@Procedure(value = "example.frequencyEncoding")
    @Description("call example.frequencyEncoding(['s1','s2',..., 'sn'], ['s1', 's2']) - return frequency embedding.")
    public IntStream frequencyEncoding(
            @Name("world") String[] world,
            @Name("states") String[] states) {
		
		// Initialise with default value 0
		int[] rets = new int[world.length];
		
		// map from word to index
		HashMap<String, Integer> w2i = new HashMap<String, Integer>();
		for (int i = 0; i < world.length; i++) {
			w2i.put(world[i], i);
		}
		
		for (String w : states) {
			rets[w2i.get(w)] += 1;
		}
		
		return Arrays.stream(rets);
    }
	
//	public static void main(String[] args) {
//		System.out.print("Hello World!");
//		FrequencyEncoding obj = new FrequencyEncoding();
//		String[] worlds = {"good", "bad", "avrage"};
//		String[] states = {"bad", "bad", "good"};
//		obj.frequencyEncoding(worlds, states).forEach(x -> System.out.print(x));
//	}
}

