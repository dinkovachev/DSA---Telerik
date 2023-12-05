import java.util.*;
import java.util.stream.Collectors;

public class InventoryManager {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        Set<Products> inventory = new HashSet<>();

        StringBuilder result = new StringBuilder();


        while (!input[0].equals("end")) {
            switch (input[0]) {
                case "add":
                    Products newProduct = new Products(input[1], Double.parseDouble(input[2]), input[3]);
                    if (!inventory.contains(newProduct)) {
                        inventory.add(newProduct);
                        result.append(String.format("Ok: Item %s added successfully%n", newProduct.getItemName()));
                    } else {
                        result.append(String.format("Error: Item %s already exists%n", newProduct.getItemName()));
                    }
                case "filter":
                    switch (input[2]) {
                        case "type":
                            String type = input[3];
                            if (inventory.stream().anyMatch(products -> products.getItemType().equals(type))) {
                                List<Products> filteredByType = inventory.stream().sorted().
                                        filter(products -> products.getItemType().equals(type)).
                                        limit(10).
                                        collect(Collectors.toList());
                                print(result, filteredByType);
                            } else {
                                result.append(String.format("Error: Type %s does not exist%n", type));
                            }
                        case "price":
                            if (input[3].equals("from")) {
                                if (input.length == 7) {
                                    double minPrice = Double.parseDouble(input[4]);
                                    double maxPrice = Double.parseDouble(input[6]);
                                    List<Products> filteredByPriceInRangeFromTo = inventory.stream().sorted().
                                            filter(products -> products.getItemPrice() <= maxPrice).
                                            filter(products -> products.getItemPrice() >= minPrice).
                                            limit(10).
                                            collect(Collectors.toList());
                                    print(result, filteredByPriceInRangeFromTo);
                                } else {
                                    double minPrice = Double.parseDouble(input[4]);
                                    List<Products> filteredByPriceFrom = inventory.stream().sorted().
                                            filter(products -> products.getItemPrice() >= minPrice).
                                            limit(10).
                                            collect(Collectors.toList());
                                    print(result, filteredByPriceFrom);
                                }
                            } else if (input[3].equals("to")) {
                                double maxPrice = Double.parseDouble(input[4]);
                                List<Products> filteredByPriceTo = inventory.stream().sorted().
                                        filter(products -> products.getItemPrice() <= maxPrice).
                                        limit(10).
                                        collect(Collectors.toList());
                                print(result, filteredByPriceTo);
                            }
                    }
            }
            input = scanner.nextLine().split(" ");
        }
        System.out.println(result);
    }

    public static String print(StringBuilder result, List<Products> filteredProducts) {
        if (filteredProducts.size() != 0) {
            result.append("Ok: ");
            for (Products products : filteredProducts) {
                result.append(String.format("%s(%.2f)",
                        products.getItemName(),
                        products.getItemPrice())).append(", ");

            }
            result.deleteCharAt(result.length() - 2);
            result.deleteCharAt(result.length() - 1);
            result.append(System.lineSeparator());
        } else {
            result.append("Ok: ");
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
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Products)) return false;
            Products products = (Products) o;
            return getItemName().equals(products.getItemName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(itemName, itemPrice, itemType);
        }

        @Override
        public int compareTo(Products o) {
            if (this.getItemPrice() < o.getItemPrice()) return -1;
            if (this.getItemPrice() > o.getItemPrice()) return 1;
            return this.getItemName().compareTo(o.getItemName());
        }
    }
}
