package fox.marcelo.collections.exercises;

import java.util.*;

public class ProposedExerciseMap01 {
    public static void main(String[] args) {

        /*
         * Dada a população estimada de alguns estados do Nordeste brasileiro, faça:
         * - Estado = PE / População = 9.616.621
         * - Estado = AL / População = 3.351.543
         * - Estado = CE / População = 9.187.103
         * - Estado = RN / População = 3.534.265
         *
         * [x]1) Crie um dicionário e relacione os estados e suas populações;
         * [x]2) Substitua a população do estado do RN por 3.534.165;
         * [x]3) Confira se o estado da PB está no dicionário, caso não adicione: PB - 4.039.277;
         * [x]4) Exiba todos os estados e suas populações na ordem que foi informado;
         * [x]5) Exiba os estados e suas populações em ordem alfabética;
         * [x]6) Exiba o estado com a menor população e quantidade;
         * [x]7) Exiba o estado com a maior população e sua quantidade;
         * [x]8) Exiba a soma da populção desses estados;
         * [x]9) Exiba a média da população deste dicionário de estados;
         * [x]10) Remova os estados com a população menor que 4.000.000;
         * [x]11) Apague o dicionário de estados;
         * [x]12) Confira se o dicionário está vazio.
         * */

        System.out.println("Crie um dicionário e relacione os estados e suas populações:");
        Map<String, Long> nordesteStates = new HashMap<>() {{
            put("PE", 9616621L);
            put("AL", 3351543L);
            put("CE", 9187103L);
            put("RN", 3534265L);
        }};
        System.out.println(nordesteStates + "\n");

        System.out.println("Substitua a população do estado do RN por 3.534.165:");
        nordesteStates.put("RN", 3534165L);
        System.out.println(nordesteStates + "\n");

        System.out.println("Confira se o estado da PB está no dicionário, caso não adicione: PB - 4.039.277:");
        if (!nordesteStates.containsKey("PB")) {
            nordesteStates.put("PB", 4039277L);
        }
        System.out.println(nordesteStates + "\n");

        System.out.println("Exiba todos os estados e suas populações na ordem que foi informado:");
        Map<String, Long> nordesteStatesLinkedHashMap = new LinkedHashMap<>() {{
            put("PE", 9616621L);
            put("AL", 3351543L);
            put("CE", 9187103L);
            put("RN", 3534265L);
            put("PB", 4039277L);
        }};
        System.out.println(nordesteStatesLinkedHashMap + "\n");

        System.out.println("Exiba os estados e suas populações em ordem alfabética:");
        Map<String, Long> nordesteStatesTreeMap = new TreeMap<>() {{
            put("PE", 9616621L);
            put("AL", 3351543L);
            put("CE", 9187103L);
            put("RN", 3534265L);
            put("PB", 4039277L);
        }};
        System.out.println(nordesteStatesTreeMap + "\n");

        System.out.println("Exiba o estado com a menor população e quantidade:");
        Long lowerPopulation = Collections.min(nordesteStates.values());
        Set<Map.Entry<String, Long>> entries = nordesteStates.entrySet();
        for (Map.Entry<String, Long> entry : entries) {
            if (entry.getValue().equals(lowerPopulation)) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
        }
        System.out.println();

        System.out.println("Exiba o estado com a maior população e sua quantidade:");
        Long greaterPopulation = Collections.max(nordesteStates.values());
        for (Map.Entry<String, Long> state : nordesteStates.entrySet()) {
            if (state.getValue().equals(greaterPopulation)) {
                System.out.println(state.getKey() + " - " + state.getValue());
            }
        }
        System.out.println();

        System.out.println("Exiba a soma da populção desses estados:");
        Iterator<Map.Entry<String, Long>> iterator = nordesteStates.entrySet().iterator();
        long sum = 0;
        while (iterator.hasNext()) {
            sum += iterator.next().getValue();
        }
        System.out.println(sum + "\n");

        System.out.println("Exiba a média da população deste dicionário de estados:");
        System.out.println(sum / nordesteStates.size() + "\n");

        System.out.println("Remova os estados com a população menor que 4.000.000:");
        System.out.println(nordesteStates);
        Iterator<Map.Entry<String, Long>> iterator1 = nordesteStates.entrySet().iterator();
        while (iterator1.hasNext()) {
            if (iterator1.next().getValue() < 4000000) {
                iterator1.remove();
            }
        }
        System.out.println(nordesteStates + "\n");

        System.out.println("Apague o dicionário de estados:");
        nordesteStates.clear();
        nordesteStatesLinkedHashMap.clear();
        nordesteStatesTreeMap.clear();
        System.out.println("Dicionários limpos!" + "\n");

        System.out.println("Confira se o dicionário está vazio");
        System.out.println("nordesteStates: " + nordesteStates.isEmpty());
        System.out.println("nordesteStatesTreeMap: " + nordesteStatesTreeMap.isEmpty());
        System.out.println("nordesteStatesLinkedHashMap: " + nordesteStatesLinkedHashMap.isEmpty());

    }
}
