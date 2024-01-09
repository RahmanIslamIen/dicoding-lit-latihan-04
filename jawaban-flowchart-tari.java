import java.util.*;

class DigimonEvolution_1402017156 {
    // Nama: [Nama Anda]
    // NPM: [NPM Anda]

    static Map<String, List<String>> digivolutionTree = new HashMap<>();

    static {
        // Inisialisasi pohon evolusi Digimon Agumon
        digivolutionTree.put("Agumon", Arrays.asList("Meramon", "GeoGreymon", "Greymon", "Tyranomon"));
        digivolutionTree.put("Meramon", Collections.emptyList());
        digivolutionTree.put("GeoGreymon", Arrays.asList("RiseGreymon", "VictoryGreymon"));
        digivolutionTree.put("RiseGreymon", Arrays.asList("ShineGreymon", "WarGreymon"));
        digivolutionTree.put("VictoryGreymon", Collections.emptyList());
        digivolutionTree.put("ShineGreymon", Collections.emptyList());
        digivolutionTree.put("WarGreymon", Collections.emptyList());
        digivolutionTree.put("Greymon", Collections.singletonList("MetalGreymon"));
        digivolutionTree.put("Tyranomon", Collections.singletonList("Triceramon"));
        digivolutionTree.put("MetalGreymon", Collections.singletonList("WarGreymon"));
        digivolutionTree.put("Triceramon", Collections.emptyList());
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java DigimonEvolution_1402017156 <target Digimon>");
            return;
        }

        String targetDigimon = args[0];
        List<String> path = findDigivolutionPath("Agumon", targetDigimon, new HashSet<>());

        if (path.isEmpty()) {
            System.out.println("Target Digimon tidak ditemukan dalam evolusi Agumon.");
        } else {
            System.out.println("Jalur Digivolution dari Agumon ke " + targetDigimon + ":");
            for (String digimon : path) {
                System.out.println(digimon);
            }
        }
    }

    // Fungsi rekursif untuk mencari jalur evolusi dari startDigimon ke targetDigimon
    private static List<String> findDigivolutionPath(String startDigimon, String targetDigimon, Set<String> visited) {
        if (!digivolutionTree.containsKey(startDigimon) || visited.contains(startDigimon)) {
            return Collections.emptyList();
        }

        visited.add(startDigimon);

        if (startDigimon.equals(targetDigimon)) {
            return new ArrayList<>(Collections.singletonList(startDigimon));
        }

        for (String nextDigimon : digivolutionTree.get(startDigimon)) {
            List<String> path = findDigivolutionPath(nextDigimon, targetDigimon, visited);
            if (!path.isEmpty()) {
                path.add(0, startDigimon);
                return path;
            }
        }

        return Collections.emptyList();
    }
}
