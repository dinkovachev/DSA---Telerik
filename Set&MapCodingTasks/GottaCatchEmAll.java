import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class GottaCatchEmAll {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Pokemon> allPokemon = new ArrayList<>();
        Map<String, Set<Pokemon>> pokemonByType = new TreeMap<>();

        String[] input = reader.readLine().split(" ");

        while (!input[0].equals("end")) {
            switch (input[0]) {
                case "add":
                    String pokemonName = input[1];
                    String pokemonType = input[2];
                    int pokemonPower = Integer.parseInt(input[3]);
                    int pokemonPosition = Integer.parseInt(input[4]);
                    Pokemon newPokemon = new Pokemon(pokemonName, pokemonType, pokemonPower);
                    allPokemon.add(pokemonPosition - 1, newPokemon);
                    pokemonByType.putIfAbsent(newPokemon.getPokemonType(), new TreeSet<>());
                    pokemonByType.get(pokemonType).add(newPokemon);
                    System.out.printf("Added pokemon %s to position %d%n", pokemonName, pokemonPosition);
                    break;
                case "find":
                    String type = input[1];
                    if (!pokemonByType.containsKey(type)) {
                        System.out.printf("Type %s: %n", type);
                    } else {
                        String output = pokemonByType.get(type).stream().limit(5).
                                map(Pokemon::toString).collect(Collectors.joining("; "));
                        System.out.printf("Type %s: %s%n", type, output);
                    }
                    break;
                case "ranklist":
                    int start = Integer.parseInt(input[1]);
                    int end = Integer.parseInt(input[2]);
                    System.out.println(print(allPokemon, start, end));
                    break;
            }
            input = reader.readLine().split(" ");
        }
    }

    private static String print(List<Pokemon> pokemonList, int start, int end) {
        StringBuilder result = new StringBuilder();

        for (int i = start - 1; i < end; i++) {
            result.append(i + 1).append(". ").append(pokemonList.get(i).toString()).append("; ");
        }
        return result.substring(0, result.length() - 2);
    }

    private static class Pokemon implements Comparable<Pokemon> {
        private String pokemonName;
        private String pokemonType;
        private int pokemonPower;

        public Pokemon(String pokemonName, String pokemonType, int pokemonPower) {
            setPokemonName(pokemonName);
            setPokemonType(pokemonType);
            setPokemonPower(pokemonPower);
        }

        public String getPokemonName() {
            return pokemonName;
        }

        private void setPokemonName(String pokemonName) {
            if (pokemonName.length() < 1 || pokemonName.length() > 20) {
                throw new IllegalArgumentException();
            }
            this.pokemonName = pokemonName;
        }

        public String getPokemonType() {
            return pokemonType;
        }

        private void setPokemonType(String pokemonType) {
            if (pokemonType.length() < 1 || pokemonType.length() > 10) {
                throw new IllegalArgumentException();
            }
            this.pokemonType = pokemonType;
        }

        public int getPokemonPower() {
            return pokemonPower;
        }

        private void setPokemonPower(int pokemonPower) {
            if (pokemonPower < 10 || pokemonPower > 50) {
                throw new IllegalArgumentException();
            }
            this.pokemonPower = pokemonPower;
        }

        @Override
        public String toString() {
            return String.format("%s(%d)", getPokemonName(), getPokemonPower());
        }

        @Override
        public int compareTo(Pokemon o) {
            if (this.getPokemonName().equals(o.getPokemonName())) {
                return Integer.compare(o.getPokemonPower(), this.getPokemonPower());
            } else {
                return this.getPokemonName().compareTo(o.getPokemonName());
            }
        }
    }
}
