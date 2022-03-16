package fox.marcelo.collections.map;

import java.util.*;

public class ExampleMap {
    public static void main(String[] args) {

        /*
         * Dado os modelos dos carros e seus respectivos consumos na estrada:
         * - Modelo: Gol, Consumo: 14,4 Km/l
         * - Modelo: Uno, Consumo: 15,6 Km/l
         * - Modelo: Mobi, Consumo: 16,1 Km/l
         * - Modelo: HB20, Consumo: 14,5 Km/l
         * - Modelo: Kwid, Consumo: 15,6 Km/l
         * */

        System.out.println("Crie um Dicionário que relacione os modelos e seus respectivos consumos:");
        Map<String, Double> popularCarsHashMap = new HashMap<>() {{
            put("Gol", 14.4);
            put("Uno", 15.6);
            put("Mobi", 16.1);
            put("HB20", 14.5);
            put("Kwid", 15.6);
        }};
        System.out.println(popularCarsHashMap + "\n");

        //put(key, content)
        System.out.println("Substitua o consumo do Gol por 15,2 Km/l:");
        popularCarsHashMap.put("Gol", 15.2);
        System.out.println(popularCarsHashMap + "\n");

        //containsKey(key)
        System.out.println("Confira se o modelo Tucson está no dicionário:");
        System.out.println(popularCarsHashMap.containsKey("Tucson") + "\n");

        //get(key)
        System.out.println("Exiba o consumo do Uno:");
        System.out.println(popularCarsHashMap.get("Uno") + "\n");

        //keySet() return um Set
        System.out.println("Exiba os Modelos:");
        System.out.println(popularCarsHashMap.keySet() + "\n");

        //values() return uma Collection
        System.out.println("Exiba os consumos dos carros:");
        System.out.println(popularCarsHashMap.values() + "\n");

        //entrySet() return entry
        System.out.println("Exiba o modelo mais econômico e seu consumo:");
        Double betterConsumption = Collections.max(popularCarsHashMap.values());
        Set<Map.Entry<String, Double>> entries = popularCarsHashMap.entrySet();
        String carBetterConsumption = "";
        for (Map.Entry<String, Double> entry : entries) {
            if (entry.getValue().equals(betterConsumption)) {
                carBetterConsumption = entry.getKey();
                System.out.println(carBetterConsumption + " - " + betterConsumption);
            }
        }
        System.out.println();

        System.out.println("Exiba o modelo menos econômico e seu consumo:");
        Double worstConsumption = Collections.min(popularCarsHashMap.values());
        Set<Map.Entry<String, Double>> entries1 = popularCarsHashMap.entrySet();
        String carWorstConsumption = "";
        for (Map.Entry<String, Double> entry : entries1) {
            if (entry.getValue().equals(worstConsumption)) {
                carWorstConsumption = entry.getKey();
                System.out.println(carWorstConsumption + " - " + worstConsumption);
            }
        }
        System.out.println();

        System.out.println("Exiba a soma dos consumos:");
        Iterator<Double> iterator = popularCarsHashMap.values().iterator();
        double sum = 0;
        while (iterator.hasNext()) {
            double next = iterator.next();
            sum += next;
        }
        System.out.println(sum + "\n");

        System.out.println("Exiba a média dos consumos deste dicionário de carros:");
        System.out.println(sum / popularCarsHashMap.size() + "\n");

        //remove()
        System.out.println("Remova os modelos com o consumo igual a 15,6 Km/l:");
        Iterator<Double> iterator1 = popularCarsHashMap.values().iterator();
        while (iterator1.hasNext()) {
            if (iterator1.next().equals(15.6)) {
                iterator1.remove();
            }
        }
        System.out.println(popularCarsHashMap + "\n");

        //Implementar com o LinkedHashMap
        System.out.println("Exiba todos os carros na ordem em que eles foram informados:");
        Map<String, Double> popularCarsLinkedHashMap = new LinkedHashMap<>(){{
            put("Fox", 14.4);
            put("Onix", 15.6);
            put("Sandero", 16.1);
            put("HB20", 14.5);
            put("Kwid", 15.6);
        }};
        System.out.println(popularCarsLinkedHashMap + "\n");

        System.out.println("Exiba o dicionário ordenado pelo modelo:");
        Map<String, Double> popularCarsTreeMap = new TreeMap<>(popularCarsLinkedHashMap);
        System.out.println(popularCarsTreeMap + "\n");

        System.out.println("Apague o dicionário de carros:");
        popularCarsHashMap.clear();
        popularCarsLinkedHashMap.clear();
        popularCarsTreeMap.clear();
        System.out.println();

        System.out.println("Confira se o dicionário está vazio:");
        System.out.println("popularCarsHashMap: " + popularCarsHashMap.isEmpty());
        System.out.println("popularCarsLinkedHashMap: " + popularCarsLinkedHashMap.isEmpty());
        System.out.println("popularCarsTreeMap: " + popularCarsTreeMap.isEmpty());
    }
}
