import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        MSLL<Object> citieslist = new MSLL<>();
        System.out.println(
                "Welcome to ICS 202 lab project, this project is about listing some\ncities and categorize them according to their first letters.");
        do {
            System.out.println("Please select an option between (1 - 13)");
            System.out.println(
                    "1.AddCityToSublistAtRear\n2.AddCityToSublistAtPosition\n3.SearchForCity\n4.DeleteCityFromCitySublist\n5.DeleteCitySublist\n6.MakeCitySublistEmpty\n7.DisplayCitySublist\n8.addToMSSLAtHead\n9.AddToMSSLAtTail\n10.DeleteFromMSSL\n11.SearchMSLList\n12.getDistance\n13.Exit");
            try {
                option = scanner.nextInt();
                switch (option) {
                case 1: {
                    System.out.println("Kindly enter the city's name: ");
                    String name = scanner.next();
                    char fl = name.toUpperCase().charAt(0);
                    name = fl + name.substring(1);
                    System.out.println("Kindly enter the city's latitude in decimal degrees: ");
                    double lat = scanner.nextDouble();
                    System.out.println("Kindly enter the city's longitude in decimal degrees: ");
                    double log = scanner.nextDouble();
                    citieslist.addCityToSublistAtRear(new City(name, log, lat));
                    System.out.println("The city with name :" + name + ", has been added successfully.");
                    break;
                }
                case 2: {
                    System.out.println("Kindly enter the city's name: ");
                    String name = scanner.next();
                    char fl = name.toUpperCase().charAt(0);
                    name = fl + name.substring(1);
                    System.out.println("Kindly enter the city's latitude in decimal degrees: ");
                    double lat = scanner.nextDouble();
                    System.out.println("Kindly enter the city's longitude in decimal degrees: ");
                    double log = scanner.nextDouble();
                    System.out.println("Kindly enter the position you want to insert the city at: ");
                    int pos = scanner.nextInt();
                    citieslist.addToCitySublistList(new City(name, log, lat), pos);
                    System.out.println("The city with name :" + name + ", has been added successfully.");
                    break;
                }
                case 3: {
                    System.out.println("Kindly enter the city's name that you want to search for: ");
                    String name = scanner.next();
                    char fl = name.toUpperCase().charAt(0);
                    name = fl + name.substring(1);
                    SLLNode<Object> search = citieslist.findCity(name);
                    if (search != null){
                        System.out.println("_____________________________________________________________________________________");
                        System.out.printf("|%-27s|%-27s|%-27s|%n", "City", "Latitude", "Longitude");
                        System.out.println("|___________________________|___________________________|___________________________|");
                        System.out.printf("|%-27s|%-27.4f|%-27.4f|%n", ((City)search.info).getName(), ((City)search.info).getLatitude(), ((City)search.info).getLongitude());
                        System.out.println("|___________________________|___________________________|___________________________|");
                    } else {
                        System.out.println( name + " city does not exist in the list");
                    }
                    break;
                }
                case 4: {
                    System.out.println("Kindly enter the city's name that you want to delete: ");
                    citieslist.deleteCityFromSublist(new City(scanner.next()));
                    break;
                }
                case 5: {
                    System.out.println("Kindly enter the city's name that you want to delete its sub list: ");
                    citieslist.deleteCitySublist(scanner.next());
                    break;
                }
                case 6: {
                    System.out.println("Kindly enter the city's name that you want to make its sub list empty: ");
                    citieslist.makeCitySublistEmpty(scanner.next());
                    break;
                }
                case 7: {
                    System.out.println("Kindly enter the cities first character that you want to display: ");
                    citieslist.displayCitySublist(scanner.next().toUpperCase().charAt(0));
                    break;
                }
                case 8: {
                    if(!citieslist.isEmpty()) {
                        citieslist.printAll();
                    }
                    System.out.println("Kindly enter the MSLLNode character that you want to add to MSLL head: ");
                    char ch = scanner.next().toUpperCase().charAt(0);
                    citieslist.addToMSLLHead(ch);
                    System.out.println("Character \'" + ch + "\' has been added successfully to MSLL.");
                    citieslist.printAll();
                    break;
                }
                case 9: {
                    if(!citieslist.isEmpty()) {
                        citieslist.printAll();
                    }
                    System.out.println("Kindly enter the MSLLNode character that you want to add to MSLL tail: ");
                    char ch = scanner.next().toUpperCase().charAt(0);
                    citieslist.addToMSLLHead(ch);
                    System.out.println("Character \'" + ch + "\' has been added successfully to MSLL.");
                    citieslist.printAll();
                    break;
                }
                case 10: {
                    if(!citieslist.isEmpty()) {
                        citieslist.printAll();
                        System.out.println("Kindly enter the MSLLNode character that you want to delete: ");
                        citieslist.deleteFromMSLL(scanner.next().toUpperCase().charAt(0));
                    } else {
                        System.out.println("MSLL is empty.");
                    }
                    break;
                }
                case 11: {
                    System.out.println("Kindly enter the MSLLNode character that you want to search for: ");
                    Character ch = scanner.next().toUpperCase().charAt(0);
                    boolean found = citieslist.isInMSLList(ch);
                    if(found){
                        System.out.println("The MSLLNode " + ch + " is in MSLL");
                            citieslist.printAll();
                    } else {
                        System.out.println("The MSLLNode " + ch + " does not exist in MSLL");
                        if(!citieslist.isEmpty()) {
                            citieslist.printAll();
                        }
                    }
                    break;
                }
                case 12: {
                    if(!citieslist.isEmpty()) {
                        citieslist.displayAll();
                    }
                    System.out.println("Kindly enter the names of the cities that you wish to find the distance between: ");
                    System.out.println("Enter the name of city1: ");
                    String c1Name = scanner.next();
                    char fl = c1Name.toUpperCase().charAt(0);
                    c1Name = fl + c1Name.substring(1);
                    System.out.println("Enter the name of city2: ");
                    String c2Name = scanner.next();
                    fl = c2Name.toUpperCase().charAt(0);
                    c2Name = fl + c2Name.substring(1);
                    System.out.printf("The straight-line distance between %s and %s is %.2f kilometers%n",
                            c1Name, c2Name, citieslist.getDistance(c1Name, c2Name));
                    break;
                }
                case 13: {
                    System.out.println("Terminating . . .");
                    scanner.close();
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("Error: invalid input.");
                    break;
                }
                }
            } catch (InputMismatchException ex) {
                System.out.println("Error: Invalid input.");
                scanner.nextLine();
            } catch (NoSuchElementException ex) {
                System.out.println(ex);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex);
            }
        } while (option != 13);
    }
}