import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class InventoryManager {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");

        Set<Products> inventory = new TreeSet<>();

        while (!input[0].equals("end")) {
            switch (input[0]) {
                case "add":
                    Products newProduct = new Products(input[1], Double.parseDouble(input[2]), input[3]);
                    if (!inventory.contains(newProduct)) {
                        inventory.add(newProduct);
                        System.out.printf("Ok: Item %s added successfully%n", newProduct.getItemName());
                    } else {
                        System.out.printf("Error: Item %s already exists%n", newProduct.getItemName());
                    }
                    break;
                case "filter":
                    switch (input[2]) {
                        case "type":
                            String type = input[3];
                            if (inventory.stream().anyMatch(products -> products.getItemType().equals(type))) {
                                List<Products> filteredByType = inventory.stream().
                                        filter(products -> products.getItemType().equals(type)).
                                        limit(10).
                                        collect(Collectors.toList());
                                System.out.print(print(filteredByType));
                            } else {
                                System.out.printf("Error: Type %s does not exist%n", type);
                            }
                        case "price":
                            switch (input[3]) {
                                case "from":
                                    double minPrice = Double.parseDouble(input[4]);
                                    if (input.length == 7) {
                                        double maxPrice = Double.parseDouble(input[6]);
                                        List<Products> filteredByPriceInRangeFromTo = inventory.stream().
                                                filter(products -> products.getItemPrice() <= maxPrice).
                                                filter(products -> products.getItemPrice() >= minPrice).
                                                limit(10).
                                                collect(Collectors.toList());
                                        System.out.print(print(filteredByPriceInRangeFromTo));
                                    } else {
                                        List<Products> filteredByPriceFrom = inventory.stream().
                                                filter(products -> products.getItemPrice() >= minPrice).
                                                limit(10).
                                                collect(Collectors.toList());
                                        System.out.print(print(filteredByPriceFrom));
                                    }
                                    break;
                                case "to":
                                    double maxPrice = Double.parseDouble(input[4]);
                                    List<Products> filteredByPriceTo = inventory.stream().
                                            filter(products -> products.getItemPrice() <= maxPrice).
                                            limit(10).
                                            collect(Collectors.toList());
                                    System.out.print(print(filteredByPriceTo));
                                    break;
                            }
                    }
            }
            input = reader.readLine().split(" ");
        }
    }

    public static String print(List<Products> filteredProducts) {
        StringBuilder result = new StringBuilder("Ok: ");
        if (filteredProducts.size() != 0) {
            for (Products products : filteredProducts) {
                result.append(String.format("%s(%.2f)",
                        products.getItemName(),
                        products.getItemPrice())).append(", ");

            }
            result.deleteCharAt(result.length() - 2);
            result.deleteCharAt(result.length() - 1);
            result.append(System.lineSeparator());
        } else {
            result.append(System.lineSeparator());
        }
        return result.toString();
    }

    static class Products implements Comparable<Products> {
        private String itemName;
        private double itemPrice;
        private String itemType;

        public Products(String itemName, double itemPrice, String itemType) {
            setItemName(itemName);
            setItemPrice(itemPrice);
            setItemType(itemType);
        }

        public String getItemName() {
            return itemName;
        }

        private void setItemName(String itemName) {
            this.itemName = itemName;
        }

        public double getItemPrice() {
            return itemPrice;
        }

        private void setItemPrice(double itemPrice) {
            if (itemPrice < 0) {
                throw new IllegalArgumentException();
            }
            this.itemPrice = itemPrice;
        }

        public String getItemType() {
            return itemType;
        }

        private void setItemType(String itemType) {
            this.itemType = itemType;
        }

        @Override
        public int compareTo(Products o) {
            if (this.getItemPrice() < o.getItemPrice())
                return -1;
            if (this.getItemPrice() > o.getItemPrice())
                return 1;
            return this.getItemName().compareTo(o.getItemName());
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Products products = (Products) o;
            return Double.compare(products.itemPrice, itemPrice) == 0 && itemName.equals(products.itemName)
                    && itemType.equals(products.itemType);
        }

        @Override
        public int hashCode() {
            return Objects.hash(itemName, itemPrice, itemType);
        }
    }
}
