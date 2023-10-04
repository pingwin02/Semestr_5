package aui.lab1;

import java.io.*;
import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {

        // Ex 2
        System.out.println("Ex 2");
        Warehouse w1 = Warehouse.builder()
                .name("Amazon")
                .capacity(50)
                .build();

        Warehouse w2 = Warehouse.builder()
                .name("Allegro")
                .capacity(80)
                .build();

        Package p1 = Package.builder()
                .name("smartphone")
                .weight(10)
                .warehouse(w1)
                .build();

        w1.addPackage(p1);

        Package p2 = Package.builder()
                .name("vacuum cleaner")
                .weight(20)
                .warehouse(w1)
                .build();

        w1.addPackage(p2);

        Package p3 = Package.builder()
                .name("tv")
                .weight(30)
                .warehouse(w2)
                .build();

        w2.addPackage(p3);

        Package p4 = Package.builder()
                .name("dishwasher")
                .weight(40)
                .warehouse(w2)
                .build();

        w2.addPackage(p4);

        Collection<Warehouse> warehouses = new ArrayList<>();
        warehouses.add(w1);
        warehouses.add(w2);

        warehouses.forEach(warehouse -> {
            System.out.println(warehouse);
            warehouse.getPackages().forEach(System.out::println);
        });

        // Ex 3
        System.out.println("Ex 3");
        Set<Package> packages = warehouses.stream()
                .map(Warehouse::getPackages)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());

        packages.forEach(System.out::println);

        // Ex 4
        System.out.println("Ex 4");
        packages.stream()
                .filter(p -> p.getWeight() > 20)
                .sorted()
                .forEach(System.out::println);

        // Ex 5
        System.out.println("Ex 5");
        List<PackageDTO> packageDTOs = packages.stream()
                .map(p -> PackageDTO.builder()
                        .name(p.getName())
                        .weight(p.getWeight())
                        .warehouseName(p.getWarehouse().getName())
                        .build())
                .sorted()
                .collect(Collectors.toList());

        packageDTOs.forEach(System.out::println);

        // Ex 6
        System.out.println("Ex 6");
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("warehouses.bin"))) {
            outputStream.writeObject(warehouses);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("warehouses.bin"))) {
            Collection<Warehouse> deserializedWarehouses = (Collection<Warehouse>) inputStream.readObject();
            deserializedWarehouses.forEach(warehouse -> {
                System.out.println(warehouse);
                warehouse.getPackages().forEach(System.out::println);
            });
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        //Ex 7
        System.out.println("Ex 7");
        int customThreadPoolSize = 4;

        ForkJoinPool customThreadPool = new ForkJoinPool(customThreadPoolSize);

        warehouses.parallelStream().forEach(warehouse -> {
            warehouse.getPackages().forEach(packageItem -> {
                try {
                    Thread.sleep(1000);
                    System.out.println(packageItem);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });

        customThreadPool.shutdown();


    }
}
