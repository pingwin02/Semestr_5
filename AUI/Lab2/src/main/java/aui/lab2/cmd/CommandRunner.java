package aui.lab2.cmd;

import aui.lab2.entity.Package;
import aui.lab2.service.PackageService;
import aui.lab2.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.UUID;

@Component
public class CommandRunner implements CommandLineRunner {
    private final WarehouseService warehouseService;
    private final PackageService packageService;

    @Autowired
    public CommandRunner(WarehouseService warehouseService, PackageService packageService) {
        this.warehouseService = warehouseService;
        this.packageService = packageService;
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        System.out.println("Welcome to the Warehouse Management System!");
        System.out.println("Available commands: listWarehouses, listPackages, addPackage, deletePackage, help, exit");

        while (isRunning) {
            System.out.print("Enter command: ");
            String command = scanner.nextLine().trim();

            switch (command) {
                case "listWarehouses":
                    warehouseService.getAllWarehouses().forEach(System.out::println);
                    break;
                case "listPackages":
                    packageService.getAllPackages().forEach(System.out::println);
                    break;
                case "addPackage":
                    try {
                        System.out.println("Enter package name: ");
                        String name = scanner.nextLine();
                        System.out.println("Enter package weight: ");
                        String weight = scanner.nextLine();
                        System.out.println("Enter package warehouse UUID:");
                        String warehouse = scanner.nextLine();

                        Package packageItem = Package.builder()
                                .id(UUID.randomUUID())
                                .name(name)
                                .weight(Integer.parseInt(weight))
                                .warehouse(warehouseService
                                        .getWarehouseById(UUID.fromString(warehouse))
                                        .orElseThrow(NoSuchElementException::new))
                                .build();

                        packageService.savePackage(packageItem);
                    } catch (NoSuchElementException e) {
                        System.out.println("Warehouse not found!");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid UUID or weight!");
                    }
                    break;
                case "deletePackage":
                    try {
                        System.out.println("Enter package UUID: ");
                        String id = scanner.nextLine();
                        packageService.deletePackage(UUID.fromString(id));
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid UUID!");
                    }
                    break;
                case "help":
                    System.out.println("Available commands: listWarehouses, listPackages, addPackage, deletePackage, help, exit");
                    break;
                case "exit":
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
                    break;
            }
        }

        System.out.println("Bye!");
        scanner.close();
    }
}
