Day_20;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


class Operation implements Serializable {
    private static final long serialVersionUID = 1L;
    private int number1;
    private int number2;
    private String operator;

    public Operation(int number1, int number2, String operator) {
        this.number1 = number1;
        this.number2 = number2;
        this.operator = operator;
    }

    public int getNumber1() {
        return number1;
    }

    public int getNumber2() {
        return number2;
    }

    public String getOperator() {
        return operator;
    }
}

// Server class to handle client requests
public class JavaNetworking_Serialization {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server is listening on port 12345");
            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

                    Operation operation = (Operation) ois.readObject();
                    int result = performOperation(operation);
                    
                    oos.writeObject(result);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int performOperation(Operation operation) {
        int number1 = operation.getNumber1();
        int number2 = operation.getNumber2();
        String operator = operation.getOperator();

        switch (operator) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            case "/":
                return number2 != 0 ? number1 / number2 : 0;  // Handle division by zero
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}

// Client class to send requests to the server
class OperationClient {

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345)) {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter first number: ");
            int number1 = scanner.nextInt();
            System.out.println("Enter second number: ");
            int number2 = scanner.nextInt();
            System.out.println("Enter operator (+, -, *, /): ");
            String operator = scanner.next();

            Operation operation = new Operation(number1, number2, operator);
            oos.writeObject(operation);

            int result = (int) ois.readObject();
            System.out.println("Result: " + result);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

