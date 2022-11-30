/*
Here you need to apply all your previous knowledge to develop a delivery processing system (oversimplified, of course). In this system, an order is an instance of the DeliveryOrder class. It stores a lot of information, but for simplicity we ask you to use only three fields:

orderId that represents a unique identifier of the order;
address that is the place where the order is expected;
deliveryDate that is the date when the order needs to be delivered (only the date, time doesn't matter).
Sometimes, work with the system produces duplicate orders when orderId is different, but address and deliveryDate are the same. Such orders are considered as duplicates.

What exactly you need to do is implement the following two methods.

The findFirstOrder method takes a list of orders and must return the first / earliest order in the list according to the value of the deliveryDate field. If the list is empty, the method must return an order created by its default constructor ("the empty order").
The printAddressesToDeliver method also takes a list of orders and must print addresses sorted by deliveryDate (from the earliest to the latest one) without duplicates. Every address must be print on a new line. If the list contains a duplicate, only the first order should be printed to avoid visiting the same address twice.
To help you implement both the methods, we have provided the utility method DeliveryOrder.getComparatorByDeliveryDate() that returns the comparator to compare orders by the deliveryDate field.

An example

Imagine, we have information about the following three orders:

1|2021-09-03|112 Mammoth Street, Colorado Springs, CO 80911
2|2021-09-05|369 Woodside Court, Troy, NY 12180
3|2021-09-02|837 Bowman Street, Helena, MT 59601
4|2021-09-03|112 Mammoth Street, Colorado Springs, CO 80911
The first field is orderId, the second is deliveryDate and the last one is address.

In this case, the method findFirstOrder must return the order 3|2021-09-02|837 Bowman Street, Helena, MT 59601 because it has the earliest deliveryDate (2021-09-02) whereas the method printAddressesToDeliver must print the following addresses according to the chronological order and without duplicates:

837 Bowman Street, Helena, MT 59601
112 Mammoth Street, Colorado Springs, CO 80911
369 Woodside Court, Troy, NY 12180
 */


package streams;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class ProcessDeliveryOrders {

    public static DeliveryOrder findFirstOrder(List<DeliveryOrder> orders) {
//        if (orders.isEmpty()) return new DeliveryOrder();
        return orders
                .stream()
                .min(DeliveryOrder.getComparatorByDeliveryDate())
                .orElseGet(DeliveryOrder::new);
//        return orders
//                .stream()
//                .sorted(DeliveryOrder.getComparatorByDeliveryDate())
//                .limit(1).collect(Collectors.toList()).get(0);
    }

    public static void printAddressesToDeliver(List<DeliveryOrder> orders) {
        orders
                .stream()
                .distinct()
                .sorted(DeliveryOrder.getComparatorByDeliveryDate())
                .forEach(order -> System.out.println(order.getAddress()));
//                .map(x -> x.getAddress())
//                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        List<DeliveryOrder> orders = Stream.iterate(1, i -> scanner.hasNextLine(), i -> i + 1)
                .map(i -> scanner.nextLine().split("\\|"))
                .map(parts -> new DeliveryOrder(
                        Long.parseLong(parts[0]), parts[2], LocalDate.parse(parts[1])))
                .collect(Collectors.toList());

        System.out.println(findFirstOrder(orders));

        printAddressesToDeliver(orders);
    }
}

class DeliveryOrder {
    private final long orderId;
    private final String address;
    private final LocalDate deliveryDate;
    // there are even more fields: customer name, phone, products info, etc

    public DeliveryOrder() {
        this.orderId = -1;
        this.address = "No address";
        this.deliveryDate = LocalDate.MIN;
    }

    public DeliveryOrder(long orderId, String address, LocalDate deliveryDate) {
        this.orderId = orderId;
        this.address = address;
        this.deliveryDate = deliveryDate;
    }

    public static Comparator<DeliveryOrder> getComparatorByDeliveryDate() {
        return Comparator.comparing(DeliveryOrder::getDeliveryDate);
    }

    public long getOrderId() {
        return orderId;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DeliveryOrder that = (DeliveryOrder) o;
        return address.equals(that.address) &&
                deliveryDate.equals(that.deliveryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, deliveryDate);
    }

    @Override
    public String toString() {
        return orderId + "|" + deliveryDate + "|" + address;
    }
}