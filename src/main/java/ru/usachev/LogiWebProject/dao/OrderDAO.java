package ru.usachev.LogiWebProject.dao;

import ru.usachev.LogiWebProject.entity.Order;

import java.util.List;

public interface OrderDAO {

    public List<Order> getAllOrders();

    public void saveOrder(Order order);

    public Order getOrder(int id);

    public void deleteOrder(int id);
}
